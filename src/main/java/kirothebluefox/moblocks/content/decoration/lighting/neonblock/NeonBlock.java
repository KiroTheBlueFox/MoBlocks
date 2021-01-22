package kirothebluefox.moblocks.content.decoration.lighting.neonblock;

import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class NeonBlock extends ColorableBlock {
	public NeonBlock(Block block) {
		super(block);
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new NeonBlockTile();
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}
}
