package kirothebluefox.moblocks.content.furnitures.kitchencounters.colorable;

import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.InnerCornerKitchenCounter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ColorableInnerCornerKitchenCounter extends InnerCornerKitchenCounter {
	public ColorableInnerCornerKitchenCounter(Block block) {
		super(block);
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ColorableKitchenCounterTile();
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
				if (tileentity instanceof ColorableKitchenCounterTile) {
					ColorableKitchenCounterTile colorableKitchCounterEntity = (ColorableKitchenCounterTile)tileentity;
					double y = hit.getHitVec().getY()-hit.getPos().getY();
					if (y > 15/16f) {
						if (player.isSneaking()) colorpicker.setColor(itemstack, colorableKitchCounterEntity.getCounterColor());
						else colorableKitchCounterEntity.setCounterColor(colorpicker.getColor(itemstack));
					} else {
						if (player.isSneaking()) colorpicker.setColor(itemstack, colorableKitchCounterEntity.getPlanksColor());
						else colorableKitchCounterEntity.setPlanksColor(colorpicker.getColor(itemstack));
					}
					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			} else {
				return ActionResultType.FAIL;
			}
		}
	}
}
