package kirothebluefox.moblocks.utils;

/*public class NoRandomBlockModelRenderer extends ModelBlockRenderer {

	public NoRandomBlockModelRenderer(BlockColors blockColorsIn) {
		super(blockColorsIn);
	}

	@Override
	public void renderModel(PoseStack.Pose p_111068_, VertexConsumer p_111069_, @Nullable BlockState stateIn, BakedModel modelIn, float p_111072_, float p_111073_, float p_111074_, int p_111075_, int p_111076_, IModelData modelData) {
		boolean flag = Minecraft.useAmbientOcclusion() && stateIn.getLightEmission(worldIn, posIn) == 0 && modelIn.useAmbientOcclusion();
		modelData = modelIn.getModelData(worldIn, posIn, stateIn, modelData);

		try {
			return this.renderModel(worldIn, modelIn, stateIn, posIn, matrixIn, buffer, checkSides, randomIn, rand, combinedOverlayIn, modelData);
		} catch (Throwable throwable) {
			CrashReport crashreport = CrashReport.forThrowable(throwable, "Tesselating block model");
			CrashReportCategory crashreportcategory = crashreport.addCategory("Block model being tesselated");
			CrashReportCategory.populateBlockDetails(crashreportcategory, posIn, stateIn);
			crashreportcategory.setDetail("Using AO", flag);
			throw new ReportedException(crashreport);
		}
	}
}*/
