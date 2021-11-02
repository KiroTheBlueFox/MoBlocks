package kirothebluefox.moblocks.content.specialblocks;

import kirothebluefox.moblocks.MoBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;

public class TallFence extends CrossCollisionBlock {

	public TallFence(Block baseBlock) {
		super(2.0F, 2.0F, 24.0F, 24.0F, 24.0F, Block.Properties.copy(baseBlock));
		this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.valueOf(false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH, Boolean.valueOf(false)).setValue(WEST, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)));
	}

	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		return false;
	}

	public boolean connectsTo(BlockState p_220111_1_, boolean p_220111_2_, Direction p_220111_3_) {
		Block block = p_220111_1_.getBlock();
		boolean flag = (p_220111_1_.is(BlockTags.getAllTags().getTag(new ResourceLocation(MoBlocks.MODID,"tall_fences"))) || p_220111_1_.is(BlockTags.getAllTags().getTag(new ResourceLocation(MoBlocks.MODID,"tall_fence_gates")))) && p_220111_1_.getMaterial() == this.material;
		boolean flag1 = block instanceof FenceGateBlock && FenceGateBlock.connectsToDirection(p_220111_1_, p_220111_3_);
		return !isExceptionForConnection(p_220111_1_) && p_220111_2_ || flag || flag1;
	}

	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (!worldIn.isClientSide) {
			return LeadItem.bindPlayerMobs(player, worldIn, pos);
		} else {
			ItemStack itemstack = player.getItemInHand(handIn);
			return (itemstack.getItem() == Items.LEAD || itemstack.isEmpty()) ? InteractionResult.SUCCESS : InteractionResult.FAIL;
		}
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockGetter iblockreader = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		FluidState FluidState = context.getLevel().getFluidState(context.getClickedPos());
		BlockPos blockpos1 = blockpos.north();
		BlockPos blockpos2 = blockpos.east();
		BlockPos blockpos3 = blockpos.south();
		BlockPos blockpos4 = blockpos.west();
		BlockState blockstate = iblockreader.getBlockState(blockpos1);
		BlockState blockstate1 = iblockreader.getBlockState(blockpos2);
		BlockState blockstate2 = iblockreader.getBlockState(blockpos3);
		BlockState blockstate3 = iblockreader.getBlockState(blockpos4);
		return super.getStateForPlacement(context).setValue(NORTH, Boolean.valueOf(this.connectsTo(blockstate, blockstate.isFaceSturdy(iblockreader, blockpos1, Direction.SOUTH), Direction.SOUTH))).setValue(EAST, Boolean.valueOf(this.connectsTo(blockstate1, blockstate1.isFaceSturdy(iblockreader, blockpos2, Direction.WEST), Direction.WEST))).setValue(SOUTH, Boolean.valueOf(this.connectsTo(blockstate2, blockstate2.isFaceSturdy(iblockreader, blockpos3, Direction.NORTH), Direction.NORTH))).setValue(WEST, Boolean.valueOf(this.connectsTo(blockstate3, blockstate3.isFaceSturdy(iblockreader, blockpos4, Direction.EAST), Direction.EAST))).setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return facing.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? stateIn.setValue(PROPERTY_BY_DIRECTION.get(facing), Boolean.valueOf(this.connectsTo(facingState, facingState.isFaceSturdy(worldIn, facingPos, facing.getOpposite()), facing.getOpposite()))) : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
	}
}
