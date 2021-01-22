package kirothebluefox.moblocks.content.furnitures.kitchencounters;

import net.minecraft.block.Block;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class StraightKitchenCounter extends KitchenCounter {
	private static final VoxelShape PLANKS = Block.makeCuboidShape(0, 0, 1, 16, 15, 16);
	private static final VoxelShape COUNTER1 = Block.makeCuboidShape(0, 15, 0, 16, 16, 16);
	private static final VoxelShape COUNTER2 = Block.makeCuboidShape(0, 16, 15, 16, 18, 16);
	
	public StraightKitchenCounter(Block block) {
		super(block);
		super.SHAPE = VoxelShapes.or(PLANKS,COUNTER1,COUNTER2);
	}
}
