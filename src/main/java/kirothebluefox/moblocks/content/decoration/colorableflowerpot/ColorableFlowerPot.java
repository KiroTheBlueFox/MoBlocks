package kirothebluefox.moblocks.content.decoration.colorableflowerpot;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ColorableFlowerPot extends Block implements IColorableBlock, EntityBlock {
	protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

	public ColorableFlowerPot(Block.Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ColorableFlowerPotTile(pos, state);
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		ItemStack itemstack = player.getItemInHand(handIn);
		if (itemstack.isEmpty()) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
			if (tileentity instanceof ColorableFlowerPotTile) {
				ColorableFlowerPotTile colorableflowerpotentity = (ColorableFlowerPotTile)tileentity;
				colorableflowerpotentity.dropItem(player, handIn);
			}
			return InteractionResult.SUCCESS;
		} else {
			Item item = itemstack.getItem();
			if (item instanceof IDyeableColorPicker) {
				IDyeableColorPicker colorpicker = (IDyeableColorPicker)item;
				BlockEntity tileentity = worldIn.getBlockEntity(pos);
				if (tileentity instanceof ColorableFlowerPotTile) {
					ColorableFlowerPotTile colorableflowerpotentity = (ColorableFlowerPotTile)tileentity;
					if (player.isShiftKeyDown()) colorpicker.setColor(itemstack, colorableflowerpotentity.getColor());
					else colorableflowerpotentity.setColor(colorpicker.getColor(itemstack));
					return InteractionResult.SUCCESS;
				} else {
					return InteractionResult.FAIL;
				}
			} else if (itemstack.getTags().anyMatch(tag -> tag.equals(ItemTags.SMALL_FLOWERS))) {
				BlockEntity tileentity = worldIn.getBlockEntity(pos);
				if (tileentity instanceof ColorableFlowerPotTile colorableflowerpotentity) {
					if (!player.isShiftKeyDown()) colorableflowerpotentity.addItem(player.isCreative() ? itemstack.copy() : itemstack);
					else colorableflowerpotentity.dropItem();
				}
				return InteractionResult.SUCCESS;
			} else {
				return InteractionResult.FAIL;
			}
		}
	}

	public static int getColor(BlockState blockState, BlockAndTintGetter blockReader, BlockPos pos) {
		BlockEntity tileEntity = blockReader.getBlockEntity(pos);
		if (tileEntity instanceof ColorableFlowerPotTile colorableflowerpotentity) {
			return colorableflowerpotentity.getColor();
		}
		return 0xFFFFFF;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity tileentity = worldIn.getBlockEntity(pos);
     		if (tileentity instanceof ColorableFlowerPotTile) {
     			((ColorableFlowerPotTile) tileentity).dropItem();
     		}

     		super.onRemove(state, worldIn, pos, newState, isMoving);
		}
	}

	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public RenderShape getRenderShape(BlockState state) {
		return RenderShape.MODEL;
	}
}
