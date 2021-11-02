package kirothebluefox.moblocks.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public class GuiUtils {
	private static int width = Minecraft.getInstance().getWindow().getScreenWidth();
	private static int height = Minecraft.getInstance().getWindow().getScreenHeight();

	@SuppressWarnings({ "deprecation", "unused" })
	public static void renderToolTip(PoseStack p_238654_1_, List<? extends FormattedCharSequence> p_238654_2_, int p_238654_3_, int p_238654_4_, Font font) {
		//net.minecraftforge.fml.client.gui.GuiUtils.drawHoveringText(p_238654_1_, p_238654_2_, p_238654_3_, p_238654_4_, width, height, -1, font);
		if (!p_238654_2_.isEmpty()) {
			int i = 0;

     		for(FormattedCharSequence ireorderingprocessor : p_238654_2_) {
     			int j = font.width(ireorderingprocessor);
	            if (j > i) {
	            	i = j;
	            }
     		}

     		int i2 = p_238654_3_ + 12;
     		int j2 = p_238654_4_ - 12;
     		int k = 8;
     		if (p_238654_2_.size() > 1) {
     			k += 2 + (p_238654_2_.size() - 1) * 10;
         	}

     		if (i2 + i > width) {
	            i2 -= 28 + i;
     		}

     		if (j2 + k + 6 > height) {
	            j2 = height - k - 6;
     		}

     		p_238654_1_.pushPose();
     		int l = -267386864;
     		int i1 = 1347420415;
     		int j1 = 1344798847;
     		int k1 = 400;
     		Tesselator tessellator = Tesselator.getInstance();
     		BufferBuilder bufferbuilder = tessellator.getBuilder();
     		bufferbuilder.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR);
     		Matrix4f matrix4f = p_238654_1_.last().pose();
     		fillGradient(matrix4f, bufferbuilder, i2 - 3, j2 - 4, i2 + i + 3, j2 - 3, 400, -267386864, -267386864);
     		fillGradient(matrix4f, bufferbuilder, i2 - 3, j2 + k + 3, i2 + i + 3, j2 + k + 4, 400, -267386864, -267386864);
     		fillGradient(matrix4f, bufferbuilder, i2 - 3, j2 - 3, i2 + i + 3, j2 + k + 3, 400, -267386864, -267386864);
     		fillGradient(matrix4f, bufferbuilder, i2 - 4, j2 - 3, i2 - 3, j2 + k + 3, 400, -267386864, -267386864);
     		fillGradient(matrix4f, bufferbuilder, i2 + i + 3, j2 - 3, i2 + i + 4, j2 + k + 3, 400, -267386864, -267386864);
     		fillGradient(matrix4f, bufferbuilder, i2 - 3, j2 - 3 + 1, i2 - 3 + 1, j2 + k + 3 - 1, 400, 1347420415, 1344798847);
     		fillGradient(matrix4f, bufferbuilder, i2 + i + 2, j2 - 3 + 1, i2 + i + 3, j2 + k + 3 - 1, 400, 1347420415, 1344798847);
     		fillGradient(matrix4f, bufferbuilder, i2 - 3, j2 - 3, i2 + i + 3, j2 - 3 + 1, 400, 1347420415, 1347420415);
     		fillGradient(matrix4f, bufferbuilder, i2 - 3, j2 + k + 2, i2 + i + 3, j2 + k + 3, 400, 1344798847, 1344798847);
     		RenderSystem.enableDepthTest();
     		RenderSystem.disableTexture();
     		RenderSystem.enableBlend();
     		RenderSystem.defaultBlendFunc();
     		//RenderSystem.shadeModel(7425);
     		bufferbuilder.end();
     		BufferUploader.end(bufferbuilder);
     		//RenderSystem.shadeModel(7424);
     		RenderSystem.disableBlend();
     		RenderSystem.enableTexture();
     		MultiBufferSource.BufferSource irendertypebuffer$impl = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
     		p_238654_1_.translate(0.0D, 0.0D, 400.0D);

     		for(int l1 = 0; l1 < p_238654_2_.size(); ++l1) {
     			FormattedCharSequence ireorderingprocessor1 = p_238654_2_.get(l1);
     			if (ireorderingprocessor1 != null) {
     				font.drawInBatch(ireorderingprocessor1, (float)i2, (float)j2, -1, true, matrix4f, irendertypebuffer$impl, false, 0, 15728880);
	            }

	            if (l1 == 0) {
	            	j2 += 2;
	            }

	            j2 += 10;
     		}

     		irendertypebuffer$impl.endBatch();
     		p_238654_1_.popPose();
		}
	}

	protected static void fillGradient(Matrix4f matrix, BufferBuilder builder, int x1, int y1, int x2, int y2, int z, int colorA, int colorB) {
		float f = (float)(colorA >> 24 & 255) / 255.0F;
		float f1 = (float)(colorA >> 16 & 255) / 255.0F;
		float f2 = (float)(colorA >> 8 & 255) / 255.0F;
		float f3 = (float)(colorA & 255) / 255.0F;
		float f4 = (float)(colorB >> 24 & 255) / 255.0F;
		float f5 = (float)(colorB >> 16 & 255) / 255.0F;
		float f6 = (float)(colorB >> 8 & 255) / 255.0F;
		float f7 = (float)(colorB & 255) / 255.0F;
		builder.vertex(matrix, (float)x2, (float)y1, (float)z).color(f1, f2, f3, f).endVertex();
		builder.vertex(matrix, (float)x1, (float)y1, (float)z).color(f1, f2, f3, f).endVertex();
		builder.vertex(matrix, (float)x1, (float)y2, (float)z).color(f5, f6, f7, f4).endVertex();
		builder.vertex(matrix, (float)x2, (float)y2, (float)z).color(f5, f6, f7, f4).endVertex();
   	}
}
