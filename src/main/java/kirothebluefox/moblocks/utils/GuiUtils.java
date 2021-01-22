package kirothebluefox.moblocks.utils;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.math.vector.Matrix4f;

public class GuiUtils {
	private static int width = Minecraft.getInstance().getMainWindow().getWidth();
	private static int height = Minecraft.getInstance().getMainWindow().getHeight();
	
	@SuppressWarnings({ "deprecation", "unused" })
	public static void renderToolTip(MatrixStack p_238654_1_, List<? extends IReorderingProcessor> p_238654_2_, int p_238654_3_, int p_238654_4_, FontRenderer font) {
		//net.minecraftforge.fml.client.gui.GuiUtils.drawHoveringText(p_238654_1_, p_238654_2_, p_238654_3_, p_238654_4_, width, height, -1, font);
		if (!p_238654_2_.isEmpty()) {
			int i = 0;

     		for(IReorderingProcessor ireorderingprocessor : p_238654_2_) {
     			int j = font.func_243245_a(ireorderingprocessor);
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

     		p_238654_1_.push();
     		int l = -267386864;
     		int i1 = 1347420415;
     		int j1 = 1344798847;
     		int k1 = 400;
     		Tessellator tessellator = Tessellator.getInstance();
     		BufferBuilder bufferbuilder = tessellator.getBuffer();
     		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
     		Matrix4f matrix4f = p_238654_1_.getLast().getMatrix();
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
     		RenderSystem.shadeModel(7425);
     		bufferbuilder.finishDrawing();
     		WorldVertexBufferUploader.draw(bufferbuilder);
     		RenderSystem.shadeModel(7424);
     		RenderSystem.disableBlend();
     		RenderSystem.enableTexture();
     		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());
     		p_238654_1_.translate(0.0D, 0.0D, 400.0D);
     		
     		for(int l1 = 0; l1 < p_238654_2_.size(); ++l1) {
     			IReorderingProcessor ireorderingprocessor1 = p_238654_2_.get(l1);
     			if (ireorderingprocessor1 != null) {
     				font.func_238416_a_(ireorderingprocessor1, (float)i2, (float)j2, -1, true, matrix4f, irendertypebuffer$impl, false, 0, 15728880);
	            }

	            if (l1 == 0) {
	            	j2 += 2;
	            }

	            j2 += 10;
     		}
     		
     		irendertypebuffer$impl.finish();
     		p_238654_1_.pop();
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
		builder.pos(matrix, (float)x2, (float)y1, (float)z).color(f1, f2, f3, f).endVertex();
		builder.pos(matrix, (float)x1, (float)y1, (float)z).color(f1, f2, f3, f).endVertex();
		builder.pos(matrix, (float)x1, (float)y2, (float)z).color(f5, f6, f7, f4).endVertex();
		builder.pos(matrix, (float)x2, (float)y2, (float)z).color(f5, f6, f7, f4).endVertex();
   	}
}
