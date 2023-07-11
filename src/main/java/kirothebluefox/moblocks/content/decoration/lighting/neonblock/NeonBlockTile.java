package kirothebluefox.moblocks.content.decoration.lighting.neonblock;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlockTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class NeonBlockTile extends ColorableBlockTile {
	public NeonBlockTile(BlockPos pos, BlockState state) {
		super(pos, state, ModTileEntities.NEON_BLOCK_TILE);
	}
}
