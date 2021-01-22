package kirothebluefox.moblocks.content.decoration.lighting.eyeballlamp;

import java.util.List;

import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlock;
import net.hypherionmc.hypcore.api.ColoredLightManager;
import net.hypherionmc.hypcore.api.Light;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;

public class EyeballLamp extends ColorableBlock {
	public EyeballLamp(Block block) {
		super(block);
		if (ModList.get().isLoaded("hypcore")) {
			ColoredLightManager.registerProvider(this, this::produceColoredLight);
		}
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		if (ModList.get().isLoaded("hypcore")) {
			return 0;
		}
		return 15;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return Block.makeCuboidShape(4, 4, 4, 12, 12, 12);
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new EyeballLampTile();
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof EyeballLampTile) {
			EyeballLampTile eyeballLampTile = (EyeballLampTile)tileentity;
			if (placer.isSneaking()) {
				eyeballLampTile.setFollowPlayer(!eyeballLampTile.followPlayer());
			}
			else if (!eyeballLampTile.followPlayer()) {
				Vector3d thisPos = new Vector3d(eyeballLampTile.getPos().getX()+0.5, eyeballLampTile.getPos().getY()+0.5, eyeballLampTile.getPos().getZ()+0.5);
				Vector3d nearestPos = placer.getEyePosition(1);
				Vector3d vector = nearestPos.subtract(thisPos);
				double pitch = Math.toDegrees(Math.acos(vector.y/Math.sqrt(Math.pow(vector.x,2)+Math.pow(vector.y,2)+Math.pow(vector.z,2))));
				double yaw = Math.toDegrees(Math.atan(vector.z/vector.x))+270;
				yaw += (nearestPos.x >= thisPos.x) ? 180 : 0;
				eyeballLampTile.setAngle((float) -yaw, (float) -pitch+90);
			}
		}
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		if (!itemstack.isEmpty())
			return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
		else {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof EyeballLampTile) {
				EyeballLampTile eyeballLampTile = (EyeballLampTile)tileentity;
				if (player.isSneaking()) {
					eyeballLampTile.setFollowPlayer(!eyeballLampTile.followPlayer());
				}
				else if (!eyeballLampTile.followPlayer()) {
					Vector3d thisPos = new Vector3d(eyeballLampTile.getPos().getX()+0.5, eyeballLampTile.getPos().getY()+0.5, eyeballLampTile.getPos().getZ()+0.5);
					Vector3d nearestPos = player.getEyePosition(1);
					Vector3d vector = nearestPos.subtract(thisPos);
					double pitch = Math.toDegrees(Math.acos(vector.y/Math.sqrt(Math.pow(vector.x,2)+Math.pow(vector.y,2)+Math.pow(vector.z,2))));
					double yaw = Math.toDegrees(Math.atan(vector.z/vector.x))+270;
					yaw += (nearestPos.x >= thisPos.x) ? 180 : 0;
					eyeballLampTile.setAngle((float) -yaw, (float) -pitch+90);
				}
				return ActionResultType.SUCCESS;
			}
			return ActionResultType.FAIL;
		}
	}
	
	@Override
	public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.reference_to").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)).append(new StringTextComponent("AsianHalfSquat").setStyle(Style.EMPTY.setFormatting(TextFormatting.BLUE))));
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.eyeball_lamp.follow_player").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(15).build();
	}
}
