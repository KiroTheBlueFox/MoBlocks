package kirothebluefox.moblocks.content.decoration.colorableblock;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.StainedGlassPaneBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;

public class ColorableGlassPane extends StainedGlassPaneBlock implements IColorableBlock, EntityBlock {
	public ColorableGlassPane() {
		super(DyeColor.WHITE, Block.Properties.copy(Blocks.WHITE_STAINED_GLASS_PANE));
	}

	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ColorableBlockTile(pos, state);
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
				if (tileentity instanceof ColorableBlockTile) {
					ColorableBlockTile colorableblockentity = (ColorableBlockTile)tileentity;
					if (player.isShiftKeyDown()) colorpicker.setColor(itemstack, colorableblockentity.getColor());
					else colorableblockentity.setColor(colorpicker.getColor(itemstack));
					return InteractionResult.SUCCESS;
				} else {
					return InteractionResult.FAIL;
				}
			} else {
				return InteractionResult.FAIL;
			}
		}
	}

	public static int getColor(BlockState blockState, BlockAndTintGetter blockReader, BlockPos pos) {
		BlockEntity tileEntity = blockReader.getBlockEntity(pos);
		if (tileEntity instanceof ColorableBlockTile) {
			ColorableBlockTile colorablewoolentity = (ColorableBlockTile) tileEntity;
			return colorablewoolentity.getColor();
		}
		return 0xFFFFFF;
	}
}
