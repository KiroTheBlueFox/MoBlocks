package kirothebluefox.moblocks.common.blocks.decoration.lighting.neonblock;

import kirothebluefox.moblocks.common.init.ModTileEntities;
import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.ColorableBlockTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class NeonBlockTile extends ColorableBlockTile {
    public NeonBlockTile(BlockPos pos, BlockState state) {
        super(pos, state, ModTileEntities.NEON_BLOCK_TILE);
    }
}
