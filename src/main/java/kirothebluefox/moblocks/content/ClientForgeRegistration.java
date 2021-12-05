package kirothebluefox.moblocks.content;

import com.mojang.blaze3d.vertex.PoseStack;
import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.furnitures.bookshelves.Bookshelf;
import kirothebluefox.moblocks.content.furnitures.crates.Crate;
import kirothebluefox.moblocks.content.furnitures.potionshelves.PotionShelf;
import kirothebluefox.moblocks.content.furnitures.shelves.Shelf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = MoBlocks.MODID, value = Dist.CLIENT, bus=Bus.FORGE)
public class ClientForgeRegistration {
	@SubscribeEvent
	public static void renderGameOverlayEvent(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL && MoBlocks.config.tooltip_rendering.get()) {
			PoseStack matrixStack = event.getMatrixStack();
			HitResult raytraceResult = Minecraft.getInstance().hitResult;
			if (raytraceResult.getType() == HitResult.Type.BLOCK) {
				BlockHitResult raytrace = (BlockHitResult) raytraceResult;
				BlockPos pos = raytrace.getBlockPos();
				ClientLevel worldIn = Minecraft.getInstance().level;
				BlockState state = worldIn.getBlockState(pos);
				Block block = state.getBlock();
				if (block.getTags().contains(new ResourceLocation(MoBlocks.MODID, "no_gui_container_blocks"))) {
					Vec3 hit = raytrace.getLocation();
					ItemStack item = ItemStack.EMPTY;
					if (block instanceof PotionShelf) {
						PotionShelf potionShelf = (PotionShelf) block;
						item = potionShelf.getItemAtHit(worldIn, state, hit, pos);
					} else if (block instanceof Crate) {
						Crate crate = (Crate) block;
						item = crate.getItemAtHit(worldIn, state, hit, pos);
					} else if (block instanceof Shelf) {
						Shelf shelf = (Shelf) block;
						item = shelf.getItemAtHit(worldIn, state, hit, pos);
					} else if (block instanceof Bookshelf) {
						Bookshelf bookshelf = (Bookshelf) block;
						item = bookshelf.getItemAtHit(worldIn, state, hit, pos);
					}
					if (!item.isEmpty()) {
						Font font = Minecraft.getInstance().font;
						int width = Minecraft.getInstance().getWindow().getGuiScaledWidth(),
								height = Minecraft.getInstance().getWindow().getGuiScaledHeight(),
								posx = (int) (width/2),
								posy = (int) (height/2);
						//preItemHoverText(item);
					    List<Component> tooltip = item.getTooltipLines(Minecraft.getInstance().player, Minecraft.getInstance().options.advancedItemTooltips ? TooltipFlag.Default.ADVANCED : TooltipFlag.Default.NORMAL);
						// MatrixStack, List<ITextComponent>, int, int, int, int, int, FontRenderer
					    // net.minecraftforge.fml.client.gui.GuiUtils.drawHoveringText(matrixStack, tooltip, posx, posy, width, height, -1, font);
						List<FormattedCharSequence> tooltipReordering = new ArrayList<>();
						tooltip.forEach((textcomponent) -> {
							tooltipReordering.add(FormattedCharSequence.forward(textcomponent.getString(), textcomponent.getStyle()));
						});
					    kirothebluefox.moblocks.utils.GuiUtils.renderToolTip(matrixStack, tooltipReordering, posx, posy, font);
					    //postItemToolTip();
					}
				}
			}
		}
	}
}
