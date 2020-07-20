package kirothebluefox.moblocks.content.decoration.colorableflowerpot;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ColorableFlowerPot extends Block implements IColorableBlock {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
	
	public ColorableFlowerPot(Block.Properties properties) {
		super(properties);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ColorableFlowerPotTile();
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		if (itemstack.isEmpty()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof ColorableFlowerPotTile) {
				ColorableFlowerPotTile colorableflowerpotentity = (ColorableFlowerPotTile)tileentity;
				colorableflowerpotentity.dropItem(player, handIn);
			}
			return ActionResultType.SUCCESS;
		} else {
			Item item = itemstack.getItem();
			if (item instanceof IDyeableColorPicker) {
				IDyeableColorPicker colorpicker = (IDyeableColorPicker)item;
				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity instanceof ColorableFlowerPotTile) {
					ColorableFlowerPotTile colorableflowerpotentity = (ColorableFlowerPotTile)tileentity;
					if (player.isSneaking()) colorpicker.setColor(itemstack, colorableflowerpotentity.getColor());
					else colorableflowerpotentity.setColor(colorpicker.getColor(itemstack));
					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			} else if (item.getTags().contains(new ResourceLocation("minecraft:small_flowers"))) {
				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity instanceof ColorableFlowerPotTile) {
					ColorableFlowerPotTile colorableflowerpotentity = (ColorableFlowerPotTile)tileentity;
					if (!player.isSneaking()) colorableflowerpotentity.addItem(player.abilities.isCreativeMode ? itemstack.copy() : itemstack);
					else colorableflowerpotentity.dropItem();
				}
				return ActionResultType.SUCCESS;
			} else {
				return ActionResultType.FAIL;
			}
		}
	}

	public static int getColor(BlockState blockState, IBlockDisplayReader blockReader, BlockPos pos) {
		TileEntity tileEntity = blockReader.getTileEntity(pos);
		if (tileEntity instanceof ColorableFlowerPotTile) {
			ColorableFlowerPotTile colorableflowerpotentity = (ColorableFlowerPotTile) tileEntity;
			return colorableflowerpotentity.getColor();
		}
		return 0xFFFFFF;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
     		if (tileentity instanceof ColorableFlowerPotTile) {
     			((ColorableFlowerPotTile) tileentity).dropItem();
     		}

     		super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
}
