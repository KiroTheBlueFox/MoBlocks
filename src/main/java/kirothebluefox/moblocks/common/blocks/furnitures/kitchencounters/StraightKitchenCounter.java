package kirothebluefox.moblocks.common.blocks.furnitures.kitchencounters;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StraightKitchenCounter extends KitchenCounter {
    private static final VoxelShape PLANKS = Block.box(0, 0, 1, 16, 15, 16);
    private static final VoxelShape COUNTER1 = Block.box(0, 15, 0, 16, 16, 16);
    private static final VoxelShape COUNTER2 = Block.box(0, 16, 15, 16, 18, 16);

    public StraightKitchenCounter(String name, Block block) {
        super(name, block);
        super.SHAPE = Shapes.or(PLANKS, COUNTER1, COUNTER2);
    }
}
