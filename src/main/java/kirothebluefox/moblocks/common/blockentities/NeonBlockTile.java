package kirothebluefox.moblocks.common.blockentities;

import kirothebluefox.moblocks.common.init.ModTileEntities;
import kirothebluefox.moblocks.common.blockentities.ColorableBlockTile;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class NeonBlockTile extends ColorableBlockTile {
    public NeonBlockTile(BlockPos pos, BlockState state) {
        super(pos, state, ModTileEntities.NEON_BLOCK_TILE);
    }
}
