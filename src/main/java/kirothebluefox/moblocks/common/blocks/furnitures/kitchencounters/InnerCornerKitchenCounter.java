package kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class InnerCornerKitchenCounter extends KitchenCounter {
    private static final VoxelShape PLANKS1 = Block.box(0, 0, 1, 16, 15, 16);
    private static final VoxelShape PLANKS2 = Block.box(1, 0, 0, 16, 15, 1);
    private static final VoxelShape COUNTER1 = Block.box(0, 15, 0, 16, 16, 16);
    private static final VoxelShape COUNTER2 = Block.box(0, 16, 15, 16, 18, 16);
    private static final VoxelShape COUNTER3 = Block.box(15, 16, 0, 16, 18, 15);

    public InnerCornerKitchenCounter(String name, Block block) {
        super(name, block);
        super.SHAPE = Shapes.or(PLANKS1, PLANKS2, COUNTER1, COUNTER2, COUNTER3);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState FluidState = context.getLevel().getFluidState(blockpos);
        BlockState blockstate = this.defaultBlockState().setValue(FACING, Direction.WEST).setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
        float direction = (context.getPlayer().getViewYRot(1.0F)) % 360;
        if (direction < 0) direction += 360.0F;
        if (direction >= 180.0F && direction < 270.0F) {
            return blockstate.setValue(FACING, Direction.EAST);
        } else if (direction >= 90.0F && direction < 180.0F) {
            return blockstate.setValue(FACING, Direction.NORTH);
        } else if (direction >= 270.0F) {
            return blockstate.setValue(FACING, Direction.SOUTH);
        } else {
            return blockstate;
        }
    }
}
