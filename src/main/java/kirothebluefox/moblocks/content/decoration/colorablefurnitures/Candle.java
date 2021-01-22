package kirothebluefox.moblocks.content.decoration.colorablefurnitures;

import java.util.Random;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableLightBlockTile;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableLightColorPicker;
import net.hypherionmc.hypcore.api.ColoredLightManager;
import net.hypherionmc.hypcore.api.Light;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;


public class Candle extends Block implements IColorableBlock {
	public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.DOWN);

	public static final VoxelShape CANDLE = Block.makeCuboidShape(5,0,5,11,10,11);
	public static final VoxelShape NORTH = Block.makeCuboidShape(6,2,0,10,13,10);
	public static final VoxelShape SOUTH = Block.makeCuboidShape(6,2,6,10,13,16);
	public static final VoxelShape EAST = Block.makeCuboidShape(6,2,6,16,13,10);
	public static final VoxelShape WEST = Block.makeCuboidShape(0,2,6,10,13,10);
	
	public Candle() {
		super(Block.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance());
		if (ModList.get().isLoaded("hypcore")) {
			ColoredLightManager.registerProvider(this, this::produceColoredLight);
		}
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.DOWN));
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		if (ModList.get().isLoaded("hypcore")) {
			return 0;
		}
		return 7;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return NORTH;
		case SOUTH:
			return SOUTH;
		case EAST:
			return EAST;
		case WEST:
			return WEST;
		case UP:
			return CANDLE;
		default:
			return CANDLE;
		}
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		if (!hasEnoughSolidSide(context.getWorld(), context.getPos().offset(context.getFace().getOpposite()), context.getFace())) {
			return null;
		}
		if (context.getFace() != Direction.DOWN) {
			return this.getDefaultState().with(FACING, context.getFace().getOpposite());
		} else {
			return (hasEnoughSolidSide(context.getWorld(), context.getPos().down(), Direction.DOWN)) ? this.getDefaultState().with(FACING, Direction.DOWN) : null;
		}
	}
	
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(FACING) == Direction.DOWN) {
			if (!hasEnoughSolidSide(worldIn, currentPos.down(), Direction.DOWN)) {
				worldIn.destroyBlock(currentPos, true);
			}
		} else {
			if (!hasEnoughSolidSide(worldIn, currentPos.offset(stateIn.get(FACING)), stateIn.get(FACING))) {
				worldIn.destroyBlock(currentPos, true);
			}
		}
		return stateIn;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ColorableLightBlockTile();
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		double d0 = (double)pos.getX() + 0.5D;
		double d1 = (double)pos.getY() + 0.75D;
		double d2 = (double)pos.getZ() + 0.5D;
		worldIn.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		worldIn.addParticle((IParticleData) ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		if (itemstack.isEmpty()) {
			return ActionResultType.SUCCESS;
		} else {
			Item item = itemstack.getItem();
			if (item instanceof IDyeableColorPicker) {
				IDyeableColorPicker colorpicker = (IDyeableColorPicker)item;
				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity instanceof ColorableLightBlockTile) {
					ColorableLightBlockTile candleTile = (ColorableLightBlockTile)tileentity;
					candleTile.setColor(colorpicker.getColor(itemstack));
					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			} else if (item instanceof IDyeableLightColorPicker) {
				IDyeableLightColorPicker colorpicker = (IDyeableLightColorPicker)item;
				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity instanceof ColorableLightBlockTile) {
					ColorableLightBlockTile candleTile = (ColorableLightBlockTile)tileentity;
					candleTile.setLightColor(colorpicker.getColor(itemstack));
					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			} else {
				return ActionResultType.FAIL;
			}
		}
	}

	public static int getColor(BlockState blockState, IBlockDisplayReader blockReader, BlockPos pos) {
		TileEntity tileEntity = blockReader.getTileEntity(pos);
		if (tileEntity instanceof ColorableLightBlockTile) {
			ColorableLightBlockTile candleTile = (ColorableLightBlockTile) tileEntity;
			return candleTile.getColor();
		}
		return 0xFFFFFF;
	}

	public static int getLightColor(IBlockDisplayReader blockReader, BlockPos pos) {
		TileEntity tileEntity = blockReader.getTileEntity(pos);
		if (tileEntity instanceof ColorableLightBlockTile) {
			ColorableLightBlockTile candleTile = (ColorableLightBlockTile) tileEntity;
			return candleTile.getLightColor();
		}
		return 0xFFFFFF;
	}
	
	public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getLightColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(7).build();
	}
}
