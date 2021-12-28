package kirothebluefox.moblocks.common.blocks.decoration.lighting.eyeballlamp;

import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.ColorableBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;
import java.util.List;

public class EyeballLamp extends ColorableBlock implements EntityBlock {
    public EyeballLamp(Block block) {
        super(block);
        if (ModList.get().isLoaded("hypcore")) {
            //ColoredLightManager.registerProvider(this, this::produceColoredLight);
        }
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        if (ModList.get().isLoaded("hypcore")) {
            return 0;
        }
        return 15;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return Block.box(4, 4, 4, 12, 12, 12);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EyeballLampTile(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void setPlacedBy(Level worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        BlockEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof EyeballLampTile) {
            EyeballLampTile eyeballLampTile = (EyeballLampTile) tileentity;
            if (placer.isShiftKeyDown()) {
                eyeballLampTile.setFollowPlayer(!eyeballLampTile.followPlayer());
            } else if (!eyeballLampTile.followPlayer()) {
                Vec3 thisPos = new Vec3(eyeballLampTile.getBlockPos().getX() + 0.5, eyeballLampTile.getBlockPos().getY() + 0.5, eyeballLampTile.getBlockPos().getZ() + 0.5);
                Vec3 nearestPos = placer.getEyePosition(1);
                Vec3 vector = nearestPos.subtract(thisPos);
                double pitch = Math.toDegrees(Math.acos(vector.y / Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2) + Math.pow(vector.z, 2))));
                double yaw = Math.toDegrees(Math.atan(vector.z / vector.x)) + 270;
                yaw += (nearestPos.x >= thisPos.x) ? 180 : 0;
                eyeballLampTile.setAngle((float) -yaw, (float) -pitch + 90);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        ItemStack itemstack = player.getItemInHand(handIn);
        if (!itemstack.isEmpty())
            return super.use(state, worldIn, pos, player, handIn, hit);
        else {
            BlockEntity tileentity = worldIn.getBlockEntity(pos);
            if (tileentity instanceof EyeballLampTile) {
                EyeballLampTile eyeballLampTile = (EyeballLampTile) tileentity;
                if (player.isShiftKeyDown()) {
                    eyeballLampTile.setFollowPlayer(!eyeballLampTile.followPlayer());
                } else if (!eyeballLampTile.followPlayer()) {
                    Vec3 thisPos = new Vec3(eyeballLampTile.getBlockPos().getX() + 0.5, eyeballLampTile.getBlockPos().getY() + 0.5, eyeballLampTile.getBlockPos().getZ() + 0.5);
                    Vec3 nearestPos = player.getEyePosition(1);
                    Vec3 vector = nearestPos.subtract(thisPos);
                    double pitch = Math.toDegrees(Math.acos(vector.y / Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2) + Math.pow(vector.z, 2))));
                    double yaw = Math.toDegrees(Math.atan(vector.z / vector.x)) + 270;
                    yaw += (nearestPos.x >= thisPos.x) ? 180 : 0;
                    eyeballLampTile.setAngle((float) -yaw, (float) -pitch + 90);
                }
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.FAIL;
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TranslatableComponent("tooltips.moblocks.reference_to").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)).append(new TextComponent("AsianHalfSquat").setStyle(Style.EMPTY.withColor(ChatFormatting.BLUE))));
        tooltip.add(new TranslatableComponent("tooltips.moblocks.eyeball_lamp.follow_player").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

	/*public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(15).build();
	}*/
}
