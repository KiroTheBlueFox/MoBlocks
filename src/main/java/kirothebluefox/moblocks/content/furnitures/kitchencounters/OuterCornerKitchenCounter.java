package kirothebluefox.moblocks.content.furnitures.kitchencounters;

import kirothebluefox.moblocks.utils.VoxelShapeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OuterCornerKitchenCounter extends KitchenCounter {
    private static final VoxelShape PLANKS = Block.box(1, 0, 1, 16, 15, 16);
    private static final VoxelShape COUNTER1 = Block.box(0, 15, 0, 16, 16, 16);
    private static final VoxelShape COUNTER2 = Block.box(15, 16, 15, 16, 18, 16);

    public OuterCornerKitchenCounter(Block block) {
        super(block);
        super.SHAPE = Shapes.or(PLANKS, COUNTER1, COUNTER2);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        VoxelShapeUtils.Angle angle = VoxelShapeUtils.Angle.Angle0;
        switch (state.getValue(FACING)) {
            case WEST:
                angle = VoxelShapeUtils.Angle.Angle180;
                break;
            case SOUTH:
                angle = VoxelShapeUtils.Angle.Angle90;
                break;
            case NORTH:
                angle = VoxelShapeUtils.Angle.Angle270;
                break;
            default:
                break;
        }
        return VoxelShapeUtils.rotateYAngle(SHAPE, angle);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState FluidState = context.getLevel().getFluidState(blockpos);
        BlockState blockstate = this.defaultBlockState().setValue(FACING, Direction.SOUTH).setValue(WATERLOGGED, Boolean.valueOf(FluidState.getType() == Fluids.WATER));
        float direction = (context.getPlayer().getViewYRot(1.0F)) % 360;
        if (direction < 0) direction += 360.0F;
        if (direction >= 180.0F && direction < 270.0F) {
            return blockstate.setValue(FACING, Direction.NORTH);
        } else if (direction >= 90.0F && direction < 180.0F) {
            return blockstate.setValue(FACING, Direction.WEST);
        } else if (direction >= 270.0F) {
            return blockstate.setValue(FACING, Direction.EAST);
        } else {
            return blockstate;
        }
    }
}
