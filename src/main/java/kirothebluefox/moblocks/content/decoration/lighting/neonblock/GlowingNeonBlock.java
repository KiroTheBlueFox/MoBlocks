package kirothebluefox.moblocks.content.decoration.lighting.neonblock;

/*import net.hypherionmc.hypcore.api.ColoredLightManager;
import net.hypherionmc.hypcore.api.Light;*/

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;

public class GlowingNeonBlock extends NeonBlock {
	public GlowingNeonBlock(Block block) {
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

	/*public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(15).build();
	}*/
}
