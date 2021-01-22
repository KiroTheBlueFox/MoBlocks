package kirothebluefox.moblocks.content.decoration.colorablefurnitures;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlockTile;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.content.furnitures.Chair;
import kirothebluefox.moblocks.content.furnitures.SeatChair;
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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ColorableChair extends Chair implements IColorableBlock {
	public ColorableChair(Block baseBlock) {
		super(baseBlock);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new ColorableBlockTile();
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote()) {
			ItemStack itemstack = player.getHeldItem(handIn);
			if (itemstack.isEmpty()) {
				if (player.getRidingEntity() != null) {
					return ActionResultType.FAIL;
				}
				
				Vector3d vec = new Vector3d(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
				double maxDist = 2.0d;
				if ((vec.x - player.getPosX()) * (vec.x - player.getPosX()) +
						(vec.y - player.getPosY()) * (vec.y - player.getPosY()) +
						(vec.z - player.getPosZ()) * (vec.z - player.getPosZ()) > maxDist * maxDist) {
					player.sendStatusMessage(new TranslationTextComponent("status_messages.moblocks.seats.too_far", new TranslationTextComponent("status_messages.moblocks.seats.chair")), true);
					return ActionResultType.SUCCESS;
				}
				
				if (player.isSneaking()) {
					return ActionResultType.SUCCESS;
				}
				
				SeatChair seat = new SeatChair(worldIn, pos);
				worldIn.addEntity(seat);
				player.startRiding(seat);
				
				return ActionResultType.SUCCESS;
			} else {
				Item item = itemstack.getItem();
				if (item instanceof IDyeableColorPicker) {
					IDyeableColorPicker colorpicker = (IDyeableColorPicker)item;
					TileEntity tileentity = worldIn.getTileEntity(pos);
					if (tileentity instanceof ColorableBlockTile) {
						ColorableBlockTile colorableblockentity = (ColorableBlockTile)tileentity;
						if (player.isSneaking()) colorpicker.setColor(itemstack, colorableblockentity.getColor());
						else colorableblockentity.setColor(colorpicker.getColor(itemstack));
						return ActionResultType.SUCCESS;
					} else {
						return ActionResultType.FAIL;
					}
				} else {
					if (player.getRidingEntity() != null) {
						return ActionResultType.FAIL;
					}
					
					Vector3d vec = new Vector3d(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
					double maxDist = 2.0d;
					if ((vec.x - player.getPosX()) * (vec.x - player.getPosX()) +
							(vec.y - player.getPosY()) * (vec.y - player.getPosY()) +
							(vec.z - player.getPosZ()) * (vec.z - player.getPosZ()) > maxDist * maxDist) {
						player.sendStatusMessage(new TranslationTextComponent("status_messages.moblocks.seats.too_far", new TranslationTextComponent("status_messages.moblocks.seats.chair")), true);
						return ActionResultType.SUCCESS;
					}
					
					if (player.isSneaking()) {
						return ActionResultType.SUCCESS;
					}
					
	//				List<SeatChair> seats = worldIn.getEntitiesWithinAABB(SeatChair.class, new AxisAlignedBB(pos, pos.add(1, 1, 1)));
					SeatChair seat = new SeatChair(worldIn, pos);
					worldIn.addEntity(seat);
					player.startRiding(seat);
					
					return ActionResultType.SUCCESS;
				}
			}
		}
		return ActionResultType.SUCCESS;
	}

	public static int getColor(BlockState blockState, IBlockDisplayReader blockReader, BlockPos pos) {
		TileEntity tileEntity = blockReader.getTileEntity(pos);
		if (tileEntity instanceof ColorableBlockTile) {
			ColorableBlockTile colorablewoolentity = (ColorableBlockTile) tileEntity;
			return colorablewoolentity.getColor();
		}
		return 0xFFFFFF;
	}
}
