package kirothebluefox.moblocks.content.decoration.lighting.siren;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableColorPicker;
import kirothebluefox.moblocks.content.decoration.customcolorpicker.IDyeableLightColorPicker;
import kirothebluefox.moblocks.utils.VoxelShapeUtils;
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
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;

public class Siren extends Block implements IColorableBlock {
	private final VoxelShape shape = Block.makeCuboidShape(5, 0, 5, 11, 8, 11);
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public static final DirectionProperty FACING = BlockStateProperties.FACING;
	
	public Siren() {
		super(Block.Properties.create(Material.MISCELLANEOUS).zeroHardnessAndResistance());
		if (ModList.get().isLoaded("hypcore")) {
			ColoredLightManager.registerProvider(this, this::produceColoredLight);
		}
		this.setDefaultState(this.stateContainer.getBaseState().with(POWERED, false).with(FACING, Direction.UP));
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		if (state.get(POWERED))
			if (ModList.get().isLoaded("hypcore"))
				return 1;
			else
				return 15;
		return 0;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case UP:
			return shape;
		case DOWN:
			return VoxelShapeUtils.mirrorY(shape);
		case EAST:
			return VoxelShapeUtils.switchXY(shape);
		case WEST:
			return VoxelShapeUtils.rotateYAngle(VoxelShapeUtils.switchXY(shape), VoxelShapeUtils.Angle.Angle180);
		case SOUTH:
			return VoxelShapeUtils.rotateY(VoxelShapeUtils.switchXY(shape));
		case NORTH:
			return VoxelShapeUtils.rotateYAngle(VoxelShapeUtils.switchXY(shape), VoxelShapeUtils.Angle.Angle270);
		}
		return shape;
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(POWERED, FACING);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		if (itemstack.isEmpty() || state.get(POWERED)) {
			return ActionResultType.SUCCESS;
		} else {
			Item item = itemstack.getItem();
			if (item instanceof IDyeableColorPicker) {
				IDyeableColorPicker colorpicker = (IDyeableColorPicker)item;
				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity instanceof SirenTile) {
					SirenTile sirenTile = (SirenTile)tileentity;
					sirenTile.setMaxColor(colorpicker.getColor(itemstack));
					sirenTile.setColor(colorpicker.getColor(itemstack));
					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			} else if (item instanceof IDyeableLightColorPicker) {
				IDyeableLightColorPicker colorpicker = (IDyeableLightColorPicker)item;
				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity instanceof SirenTile) {
					SirenTile sirenTile = (SirenTile)tileentity;
					sirenTile.setMaxColor(colorpicker.getColor(itemstack));
					sirenTile.setColor(colorpicker.getColor(itemstack));
					return ActionResultType.SUCCESS;
				} else {
					return ActionResultType.FAIL;
				}
			} else {
				return ActionResultType.FAIL;
			}
		}
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(POWERED, Boolean.valueOf(context.getWorld().isBlockPowered(context.getPos()))).with(FACING, context.getFace());
	}
	
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		boolean flag = worldIn.isBlockPowered(pos);
		if (blockIn != this && flag != state.get(POWERED)) {
			worldIn.setBlockState(pos, state.with(POWERED, Boolean.valueOf(flag)), 2);
		}
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new SirenTile();
	}
	
	public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(state.get(POWERED) ? 14 : 0).build();
	}

	public static int getColor(IBlockReader blockReader, BlockPos pos) {
		TileEntity tileEntity = blockReader.getTileEntity(pos);
		if (tileEntity instanceof SirenTile) {
			SirenTile rainbowBlockTile = (SirenTile) tileEntity;
			return rainbowBlockTile.getColor();
		}
		return 0xFFFFFF;
	}

	public static int getMaxColor(IBlockReader blockReader, BlockPos pos) {
		TileEntity tileEntity = blockReader.getTileEntity(pos);
		if (tileEntity instanceof SirenTile) {
			SirenTile rainbowBlockTile = (SirenTile) tileEntity;
			return rainbowBlockTile.getMaxColor();
		}
		return 0xFFFFFF;
	}
}
