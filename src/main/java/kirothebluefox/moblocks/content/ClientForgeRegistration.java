package kirothebluefox.moblocks.content;

import java.util.ArrayList;
import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.furnitures.bookshelves.Bookshelf;
import kirothebluefox.moblocks.content.furnitures.crates.Crate;
import kirothebluefox.moblocks.content.furnitures.potionshelves.PotionShelf;
import kirothebluefox.moblocks.content.furnitures.shelves.Shelf;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = MoBlocks.MODID, value = Dist.CLIENT, bus=Bus.FORGE)
public class ClientForgeRegistration {
	@SubscribeEvent
	public static void renderGameOverlayEvent(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL && MoBlocks.config.tooltip_rendering.get()) {
			MatrixStack matrixStack = event.getMatrixStack();
			RayTraceResult raytraceResult = Minecraft.getInstance().objectMouseOver;
			if (raytraceResult.getType() == RayTraceResult.Type.BLOCK) {
				BlockRayTraceResult raytrace = (BlockRayTraceResult) raytraceResult;
				BlockPos pos = raytrace.getPos();
				ClientWorld worldIn = Minecraft.getInstance().world;
				BlockState state = worldIn.getBlockState(pos);
				Block block = state.getBlock();
				if (block.getTags().contains(new ResourceLocation(MoBlocks.MODID, "no_gui_container_blocks"))) {
					Vector3d hit = raytrace.getHitVec();
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
						FontRenderer font = Minecraft.getInstance().fontRenderer;
						int width = Minecraft.getInstance().getMainWindow().getScaledWidth(),
								height = Minecraft.getInstance().getMainWindow().getScaledHeight(),
								posx = (int) (width/2),
								posy = (int) (height/2);
						net.minecraftforge.fml.client.gui.GuiUtils.preItemToolTip(item);
					    List<ITextComponent> tooltip = item.getTooltip(Minecraft.getInstance().player, Minecraft.getInstance().gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL);
						// MatrixStack, List<ITextComponent>, int, int, int, int, int, FontRenderer
					    // net.minecraftforge.fml.client.gui.GuiUtils.drawHoveringText(matrixStack, tooltip, posx, posy, width, height, -1, font);
						List<IReorderingProcessor> tooltipReordering = new ArrayList<>();
						tooltip.forEach((textcomponent) -> {
							tooltipReordering.add(IReorderingProcessor.fromString(textcomponent.getString(), textcomponent.getStyle()));
						});
					    kirothebluefox.moblocks.utils.GuiUtils.renderToolTip(matrixStack, tooltipReordering, posx, posy, font);
					    net.minecraftforge.fml.client.gui.GuiUtils.postItemToolTip();
					}
				}
			}
		}
	}
}
