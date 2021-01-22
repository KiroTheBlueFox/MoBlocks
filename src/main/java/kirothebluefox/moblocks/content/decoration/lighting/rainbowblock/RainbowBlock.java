package kirothebluefox.moblocks.content.decoration.lighting.rainbowblock;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.IColorableBlock;
import net.hypherionmc.hypcore.api.ColoredLightManager;
import net.hypherionmc.hypcore.api.Light;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;

public class RainbowBlock extends Block implements IColorableBlock {
	public RainbowBlock(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
		if (ModList.get().isLoaded("hypcore")) {
			ColoredLightManager.registerProvider(this, this::produceColoredLight);
		}
	}
	
	@Override
	public int getLightValue(BlockState state, IBlockReader world, BlockPos pos) {
		if (ModList.get().isLoaded("hypcore"))
			return 1;
		return 15;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote && handIn.equals(Hand.MAIN_HAND) && player.getHeldItem(handIn).isEmpty()) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof RainbowBlockTile) {
				RainbowBlockTile rainbowBlockTile = (RainbowBlockTile) tileEntity;
				int speed = rainbowBlockTile.getSpeed();
				if (player.isSneaking()) {
					speed /= 2;
					if (speed < 1)
						speed = 128;
				} else {
					speed *= 2;
					if (speed > 128)
						speed = 1;
				}
				rainbowBlockTile.setSpeed(speed);
			}
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.FAIL;
		}
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new RainbowBlockTile();
	}
	
	public Light produceColoredLight(BlockPos pos, BlockState state) {
		int color = getColor(Minecraft.getInstance().world, pos);
		return Light.builder().pos(pos).color(color, false).radius(14).build();
	}

	public static int getColor(IBlockReader blockReader, BlockPos pos) {
		TileEntity tileEntity = blockReader.getTileEntity(pos);
		if (tileEntity instanceof RainbowBlockTile) {
			RainbowBlockTile rainbowBlockTile = (RainbowBlockTile) tileEntity;
			return rainbowBlockTile.getColor();
		}
		return 0xFFFFFF;
	}
}
