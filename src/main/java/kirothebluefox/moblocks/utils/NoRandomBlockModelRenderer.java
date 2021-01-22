package kirothebluefox.moblocks.utils;

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

public class NoRandomBlockModelRenderer extends BlockModelRenderer {
	public NoRandomBlockModelRenderer(BlockColors blockColorsIn) {
		super(blockColorsIn);
	}
	
	@Override
	public boolean renderModel(IBlockDisplayReader worldIn, IBakedModel modelIn, BlockState stateIn, BlockPos posIn, MatrixStack matrixIn, IVertexBuilder buffer, boolean checkSides, Random randomIn, long rand, int combinedOverlayIn, net.minecraftforge.client.model.data.IModelData modelData) {
		boolean flag = Minecraft.isAmbientOcclusionEnabled() && stateIn.getLightValue(worldIn, posIn) == 0 && modelIn.isAmbientOcclusion();
		modelData = modelIn.getModelData(worldIn, posIn, stateIn, modelData);

      	try {
      		return flag ? this.renderModelSmooth(worldIn, modelIn, stateIn, posIn, matrixIn, buffer, checkSides, randomIn, rand, combinedOverlayIn, modelData) : this.renderModelFlat(worldIn, modelIn, stateIn, posIn, matrixIn, buffer, checkSides, randomIn, rand, combinedOverlayIn, modelData);
      	} catch (Throwable throwable) {
      		CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Tesselating block model");
      		CrashReportCategory crashreportcategory = crashreport.makeCategory("Block model being tesselated");
      		CrashReportCategory.addBlockInfo(crashreportcategory, posIn, stateIn);
      		crashreportcategory.addDetail("Using AO", flag);
      		throw new ReportedException(crashreport);
      	}
	}
}
