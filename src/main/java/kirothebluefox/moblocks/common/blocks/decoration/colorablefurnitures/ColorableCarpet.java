package kirothebluefox.moblocks.common.blocks.decoration.colorablefurnitures;

import kirothebluefox.moblocks.common.customproperties.IColorableBlock;
import kirothebluefox.moblocks.common.blocks.decoration.colorableblock.ColorableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ColorableCarpet extends ColorableBlock implements IColorableBlock {
    public ColorableCarpet() {
        super(Blocks.WHITE_CARPET);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return Block.box(0, 0, 0, 16, 1, 16);
    }
}
