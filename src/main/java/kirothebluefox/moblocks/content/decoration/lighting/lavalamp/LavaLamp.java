package kirothebluefox.moblocks.content.decoration.lighting.lavalamp;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableLightColorPicker;
import net.hypherionmc.hypcore.api.ColoredLightManager;
import net.hypherionmc.hypcore.api.Light;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;

public class LavaLamp extends Block implements IColorableBlock {
	private final VoxelShape shape1 = Block.makeCuboidShape(5, 0, 5, 11, 1, 11);
	private final VoxelShape shape2 = Block.makeCuboidShape(7, 1, 7, 9, 3, 9);
	private final VoxelShape shape3 = Block.makeCuboidShape(6, 3, 6, 10, 16, 10);
	private final VoxelShape shape = VoxelShapes.or(shape1, shape2, shape3); 
	
	public LavaLamp() {
		super(Block.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance());
		if (ModList.get().isLoaded("hypcore")) {
			ColoredLightManager.registerProvider(this, this::produceColoredLight);
		}
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		if (ModList.get().isLoaded("hypcore"))
			return 1;
		return 15;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return shape;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
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
				if (tileentity instanceof LavaLampTile) {
					LavaLampTile lavaLampTile = (LavaLampTile)tileentity;
					lavaLampTile.setColor(colorpicker.getColor(itemstack));
					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			} else if (item instanceof IDyeableLightColorPicker) {
				IDyeableLightColorPicker colorpicker = (IDyeableLightColorPicker)item;
				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity instanceof LavaLampTile) {
					LavaLampTile lavaLampTile = (LavaLampTile)tileentity;
					lavaLampTile.setColor(colorpicker.getColor(itemstack));
					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			} else {
				return ActionResultType.FAIL;
			}
		}
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new LavaLampTile();
	}
	
	public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(15).build();
	}

	public static int getColor(IBlockReader blockReader, BlockPos pos) {
		TileEntity tileEntity = blockReader.getTileEntity(pos);
		if (tileEntity instanceof LavaLampTile) {
			LavaLampTile lavaLampTile = (LavaLampTile) tileEntity;
			return lavaLampTile.getColor();
		}
		return 0xFFFFFF;
	}
}
