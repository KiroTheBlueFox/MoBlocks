package kirothebluefox.moblocks.content.furnitures.kitchencounters.colorable;

import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.content.furnitures.kitchencounters.InnerCornerKitchenCounter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class ColorableInnerCornerKitchenCounter extends InnerCornerKitchenCounter implements EntityBlock {
	public ColorableInnerCornerKitchenCounter(Block block) {
		super(block);
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ColorableKitchenCounterTile(pos, state);
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		ItemStack itemstack = player.getItemInHand(handIn);
		if (itemstack.isEmpty()) {
			return InteractionResult.SUCCESS;
		} else {
			Item item = itemstack.getItem();
			if (item instanceof IDyeableColorPicker) {
				IDyeableColorPicker colorpicker = (IDyeableColorPicker)item;
				BlockEntity tileentity = worldIn.getBlockEntity(pos);
				if (tileentity instanceof ColorableKitchenCounterTile) {
					ColorableKitchenCounterTile colorableKitchCounterEntity = (ColorableKitchenCounterTile)tileentity;
					double y = hit.getLocation().y()-hit.getBlockPos().getY();
					if (y > 15/16f) {
						if (player.isShiftKeyDown()) colorpicker.setColor(itemstack, colorableKitchCounterEntity.getCounterColor());
						else colorableKitchCounterEntity.setCounterColor(colorpicker.getColor(itemstack));
					} else {
						if (player.isShiftKeyDown()) colorpicker.setColor(itemstack, colorableKitchCounterEntity.getPlanksColor());
						else colorableKitchCounterEntity.setPlanksColor(colorpicker.getColor(itemstack));
					}
					return InteractionResult.SUCCESS;
				} else {
					return InteractionResult.FAIL;
				}
			} else {
				return InteractionResult.FAIL;
			}
		}
	}
}
