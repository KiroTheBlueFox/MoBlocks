package kirothebluefox.moblocks.common.blocks.decoration.lighting.signaltowerlight;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.common.blockentities.SignalTowerLightTile;
import kirothebluefox.moblocks.common.customproperties.CustomBlockStateProperties;
import kirothebluefox.moblocks.common.init.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;

public class SignalTowerLight extends Block implements EntityBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final IntegerProperty LIGHT = CustomBlockStateProperties.LIGHT;

    /* X_AXIS */
    protected static final double[][] X_AXIS = {{11, 6, 6, 15, 10, 10},
            {11, 5, 7, 15, 6, 9},
            {11, 10, 7, 15, 11, 9},
            {11, 7, 5, 15, 9, 6},
            {11, 7, 10, 15, 9, 11},
            {6, 6, 6, 10, 10, 10},
            {6, 5, 7, 10, 6, 9},
            {6, 10, 7, 10, 11, 9},
            {6, 7, 5, 10, 9, 6},
            {6, 7, 10, 10, 9, 11},
            {1, 6, 6, 5, 10, 10},
            {1, 5, 7, 5, 6, 9},
            {1, 10, 7, 5, 11, 9},
            {1, 7, 5, 5, 9, 6},
            {1, 7, 10, 5, 9, 11},
            {15, 5, 5, 16, 11, 11},
            {15, 6, 4, 16, 10, 5},
            {15, 6, 11, 16, 10, 12},
            {15, 11, 6, 16, 12, 10},
            {15, 4, 6, 16, 5, 10},
            {10, 5, 5, 11, 11, 11},
            {10, 11, 6, 11, 12, 10},
            {10, 4, 6, 11, 5, 10},
            {10, 6, 4, 11, 10, 5},
            {10, 6, 11, 11, 10, 12},
            {5, 5, 5, 6, 11, 11},
            {5, 11, 6, 6, 12, 10},
            {5, 4, 6, 6, 5, 10},
            {5, 6, 4, 6, 10, 5},
            {5, 6, 11, 6, 10, 12},
            {0, 5, 5, 1, 11, 11},
            {0, 11, 6, 1, 12, 10},
            {0, 4, 6, 1, 5, 10},
            {0, 6, 4, 1, 10, 5},
            {0, 6, 11, 1, 10, 12}};
    protected static final VoxelShape X_AXISPart1 = Block.box(X_AXIS[0][0], X_AXIS[0][1], X_AXIS[0][2], X_AXIS[0][3], X_AXIS[0][4], X_AXIS[0][5]);
    protected static final VoxelShape X_AXISPart2 = Block.box(X_AXIS[1][0], X_AXIS[1][1], X_AXIS[1][2], X_AXIS[1][3], X_AXIS[1][4], X_AXIS[1][5]);
    protected static final VoxelShape X_AXISPart3 = Block.box(X_AXIS[2][0], X_AXIS[2][1], X_AXIS[2][2], X_AXIS[2][3], X_AXIS[2][4], X_AXIS[2][5]);
    protected static final VoxelShape X_AXISPart4 = Block.box(X_AXIS[3][0], X_AXIS[3][1], X_AXIS[3][2], X_AXIS[3][3], X_AXIS[3][4], X_AXIS[3][5]);
    protected static final VoxelShape X_AXISPart5 = Block.box(X_AXIS[4][0], X_AXIS[4][1], X_AXIS[4][2], X_AXIS[4][3], X_AXIS[4][4], X_AXIS[4][5]);
    protected static final VoxelShape X_AXISPart6 = Block.box(X_AXIS[5][0], X_AXIS[5][1], X_AXIS[5][2], X_AXIS[5][3], X_AXIS[5][4], X_AXIS[5][5]);
    protected static final VoxelShape X_AXISPart7 = Block.box(X_AXIS[6][0], X_AXIS[6][1], X_AXIS[6][2], X_AXIS[6][3], X_AXIS[6][4], X_AXIS[6][5]);
    protected static final VoxelShape X_AXISPart8 = Block.box(X_AXIS[7][0], X_AXIS[7][1], X_AXIS[7][2], X_AXIS[7][3], X_AXIS[7][4], X_AXIS[7][5]);
    protected static final VoxelShape X_AXISPart9 = Block.box(X_AXIS[8][0], X_AXIS[8][1], X_AXIS[8][2], X_AXIS[8][3], X_AXIS[8][4], X_AXIS[8][5]);
    protected static final VoxelShape X_AXISPart10 = Block.box(X_AXIS[9][0], X_AXIS[9][1], X_AXIS[9][2], X_AXIS[9][3], X_AXIS[9][4], X_AXIS[9][5]);
    protected static final VoxelShape X_AXISPart11 = Block.box(X_AXIS[10][0], X_AXIS[10][1], X_AXIS[10][2], X_AXIS[10][3], X_AXIS[10][4], X_AXIS[10][5]);
    protected static final VoxelShape X_AXISPart12 = Block.box(X_AXIS[11][0], X_AXIS[11][1], X_AXIS[11][2], X_AXIS[11][3], X_AXIS[11][4], X_AXIS[11][5]);
    protected static final VoxelShape X_AXISPart13 = Block.box(X_AXIS[12][0], X_AXIS[12][1], X_AXIS[12][2], X_AXIS[12][3], X_AXIS[12][4], X_AXIS[12][5]);
    protected static final VoxelShape X_AXISPart14 = Block.box(X_AXIS[13][0], X_AXIS[13][1], X_AXIS[13][2], X_AXIS[13][3], X_AXIS[13][4], X_AXIS[13][5]);
    protected static final VoxelShape X_AXISPart15 = Block.box(X_AXIS[14][0], X_AXIS[14][1], X_AXIS[14][2], X_AXIS[14][3], X_AXIS[14][4], X_AXIS[14][5]);
    protected static final VoxelShape X_AXISPart16 = Block.box(X_AXIS[15][0], X_AXIS[15][1], X_AXIS[15][2], X_AXIS[15][3], X_AXIS[15][4], X_AXIS[15][5]);
    protected static final VoxelShape X_AXISPart17 = Block.box(X_AXIS[16][0], X_AXIS[16][1], X_AXIS[16][2], X_AXIS[16][3], X_AXIS[16][4], X_AXIS[16][5]);
    protected static final VoxelShape X_AXISPart18 = Block.box(X_AXIS[17][0], X_AXIS[17][1], X_AXIS[17][2], X_AXIS[17][3], X_AXIS[17][4], X_AXIS[17][5]);
    protected static final VoxelShape X_AXISPart19 = Block.box(X_AXIS[18][0], X_AXIS[18][1], X_AXIS[18][2], X_AXIS[18][3], X_AXIS[18][4], X_AXIS[18][5]);
    protected static final VoxelShape X_AXISPart20 = Block.box(X_AXIS[19][0], X_AXIS[19][1], X_AXIS[19][2], X_AXIS[19][3], X_AXIS[19][4], X_AXIS[19][5]);
    protected static final VoxelShape X_AXISPart21 = Block.box(X_AXIS[20][0], X_AXIS[20][1], X_AXIS[20][2], X_AXIS[20][3], X_AXIS[20][4], X_AXIS[20][5]);
    protected static final VoxelShape X_AXISPart22 = Block.box(X_AXIS[21][0], X_AXIS[21][1], X_AXIS[21][2], X_AXIS[21][3], X_AXIS[21][4], X_AXIS[21][5]);
    protected static final VoxelShape X_AXISPart23 = Block.box(X_AXIS[22][0], X_AXIS[22][1], X_AXIS[22][2], X_AXIS[22][3], X_AXIS[22][4], X_AXIS[22][5]);
    protected static final VoxelShape X_AXISPart24 = Block.box(X_AXIS[23][0], X_AXIS[23][1], X_AXIS[23][2], X_AXIS[23][3], X_AXIS[23][4], X_AXIS[23][5]);
    protected static final VoxelShape X_AXISPart25 = Block.box(X_AXIS[24][0], X_AXIS[24][1], X_AXIS[24][2], X_AXIS[24][3], X_AXIS[24][4], X_AXIS[24][5]);
    protected static final VoxelShape X_AXISPart26 = Block.box(X_AXIS[25][0], X_AXIS[25][1], X_AXIS[25][2], X_AXIS[25][3], X_AXIS[25][4], X_AXIS[25][5]);
    protected static final VoxelShape X_AXISPart27 = Block.box(X_AXIS[26][0], X_AXIS[26][1], X_AXIS[26][2], X_AXIS[26][3], X_AXIS[26][4], X_AXIS[26][5]);
    protected static final VoxelShape X_AXISPart28 = Block.box(X_AXIS[27][0], X_AXIS[27][1], X_AXIS[27][2], X_AXIS[27][3], X_AXIS[27][4], X_AXIS[27][5]);
    protected static final VoxelShape X_AXISPart29 = Block.box(X_AXIS[28][0], X_AXIS[28][1], X_AXIS[28][2], X_AXIS[28][3], X_AXIS[28][4], X_AXIS[28][5]);
    protected static final VoxelShape X_AXISPart30 = Block.box(X_AXIS[29][0], X_AXIS[29][1], X_AXIS[29][2], X_AXIS[29][3], X_AXIS[29][4], X_AXIS[29][5]);
    protected static final VoxelShape X_AXISPart31 = Block.box(X_AXIS[30][0], X_AXIS[30][1], X_AXIS[30][2], X_AXIS[30][3], X_AXIS[30][4], X_AXIS[30][5]);
    protected static final VoxelShape X_AXISPart32 = Block.box(X_AXIS[31][0], X_AXIS[31][1], X_AXIS[31][2], X_AXIS[31][3], X_AXIS[31][4], X_AXIS[31][5]);
    protected static final VoxelShape X_AXISPart33 = Block.box(X_AXIS[32][0], X_AXIS[32][1], X_AXIS[32][2], X_AXIS[32][3], X_AXIS[32][4], X_AXIS[32][5]);
    protected static final VoxelShape X_AXISPart34 = Block.box(X_AXIS[33][0], X_AXIS[33][1], X_AXIS[33][2], X_AXIS[33][3], X_AXIS[33][4], X_AXIS[33][5]);
    protected static final VoxelShape X_AXISPart35 = Block.box(X_AXIS[34][0], X_AXIS[34][1], X_AXIS[34][2], X_AXIS[34][3], X_AXIS[34][4], X_AXIS[34][5]);
    private static final VoxelShape FULL_X_AXIS_SHAPE = Shapes.or(X_AXISPart1, X_AXISPart2, X_AXISPart3, X_AXISPart4, X_AXISPart5, X_AXISPart6, X_AXISPart7, X_AXISPart8, X_AXISPart9, X_AXISPart10, X_AXISPart11, X_AXISPart12, X_AXISPart13, X_AXISPart14, X_AXISPart15, X_AXISPart16, X_AXISPart17, X_AXISPart18, X_AXISPart19, X_AXISPart20, X_AXISPart21, X_AXISPart22, X_AXISPart23, X_AXISPart24, X_AXISPart25, X_AXISPart26, X_AXISPart27, X_AXISPart28, X_AXISPart29, X_AXISPart30, X_AXISPart31, X_AXISPart32, X_AXISPart33, X_AXISPart34, X_AXISPart35);

    /* Y_AXIS */
    protected static final double[][] Y_AXIS = {{6, 1, 6, 10, 5, 10},
            {5, 1, 7, 6, 5, 9},
            {10, 1, 7, 11, 5, 9},
            {7, 1, 5, 9, 5, 6},
            {7, 1, 10, 9, 5, 11},
            {6, 6, 6, 10, 10, 10},
            {5, 6, 7, 6, 10, 9},
            {10, 6, 7, 11, 10, 9},
            {7, 6, 5, 9, 10, 6},
            {7, 6, 10, 9, 10, 11},
            {6, 11, 6, 10, 15, 10},
            {5, 11, 7, 6, 15, 9},
            {10, 11, 7, 11, 15, 9},
            {7, 11, 5, 9, 15, 6},
            {7, 11, 10, 9, 15, 11},
            {5, 0, 5, 11, 1, 11},
            {6, 0, 4, 10, 1, 5},
            {6, 0, 11, 10, 1, 12},
            {11, 0, 6, 12, 1, 10},
            {4, 0, 6, 5, 1, 10},
            {5, 5, 5, 11, 6, 11},
            {11, 5, 6, 12, 6, 10},
            {4, 5, 6, 5, 6, 10},
            {6, 5, 4, 10, 6, 5},
            {6, 5, 11, 10, 6, 12},
            {5, 10, 5, 11, 11, 11},
            {11, 10, 6, 12, 11, 10},
            {4, 10, 6, 5, 11, 10},
            {6, 10, 4, 10, 11, 5},
            {6, 10, 11, 10, 11, 12},
            {5, 15, 5, 11, 16, 11},
            {11, 15, 6, 12, 16, 10},
            {4, 15, 6, 5, 16, 10},
            {6, 15, 4, 10, 16, 5},
            {6, 15, 11, 10, 16, 12}};
    protected static final VoxelShape Y_AXISPart1 = Block.box(Y_AXIS[0][0], Y_AXIS[0][1], Y_AXIS[0][2], Y_AXIS[0][3], Y_AXIS[0][4], Y_AXIS[0][5]);
    protected static final VoxelShape Y_AXISPart2 = Block.box(Y_AXIS[1][0], Y_AXIS[1][1], Y_AXIS[1][2], Y_AXIS[1][3], Y_AXIS[1][4], Y_AXIS[1][5]);
    protected static final VoxelShape Y_AXISPart3 = Block.box(Y_AXIS[2][0], Y_AXIS[2][1], Y_AXIS[2][2], Y_AXIS[2][3], Y_AXIS[2][4], Y_AXIS[2][5]);
    protected static final VoxelShape Y_AXISPart4 = Block.box(Y_AXIS[3][0], Y_AXIS[3][1], Y_AXIS[3][2], Y_AXIS[3][3], Y_AXIS[3][4], Y_AXIS[3][5]);
    protected static final VoxelShape Y_AXISPart5 = Block.box(Y_AXIS[4][0], Y_AXIS[4][1], Y_AXIS[4][2], Y_AXIS[4][3], Y_AXIS[4][4], Y_AXIS[4][5]);
    protected static final VoxelShape Y_AXISPart6 = Block.box(Y_AXIS[5][0], Y_AXIS[5][1], Y_AXIS[5][2], Y_AXIS[5][3], Y_AXIS[5][4], Y_AXIS[5][5]);
    protected static final VoxelShape Y_AXISPart7 = Block.box(Y_AXIS[6][0], Y_AXIS[6][1], Y_AXIS[6][2], Y_AXIS[6][3], Y_AXIS[6][4], Y_AXIS[6][5]);
    protected static final VoxelShape Y_AXISPart8 = Block.box(Y_AXIS[7][0], Y_AXIS[7][1], Y_AXIS[7][2], Y_AXIS[7][3], Y_AXIS[7][4], Y_AXIS[7][5]);
    protected static final VoxelShape Y_AXISPart9 = Block.box(Y_AXIS[8][0], Y_AXIS[8][1], Y_AXIS[8][2], Y_AXIS[8][3], Y_AXIS[8][4], Y_AXIS[8][5]);
    protected static final VoxelShape Y_AXISPart10 = Block.box(Y_AXIS[9][0], Y_AXIS[9][1], Y_AXIS[9][2], Y_AXIS[9][3], Y_AXIS[9][4], Y_AXIS[9][5]);
    protected static final VoxelShape Y_AXISPart11 = Block.box(Y_AXIS[10][0], Y_AXIS[10][1], Y_AXIS[10][2], Y_AXIS[10][3], Y_AXIS[10][4], Y_AXIS[10][5]);
    protected static final VoxelShape Y_AXISPart12 = Block.box(Y_AXIS[11][0], Y_AXIS[11][1], Y_AXIS[11][2], Y_AXIS[11][3], Y_AXIS[11][4], Y_AXIS[11][5]);
    protected static final VoxelShape Y_AXISPart13 = Block.box(Y_AXIS[12][0], Y_AXIS[12][1], Y_AXIS[12][2], Y_AXIS[12][3], Y_AXIS[12][4], Y_AXIS[12][5]);
    protected static final VoxelShape Y_AXISPart14 = Block.box(Y_AXIS[13][0], Y_AXIS[13][1], Y_AXIS[13][2], Y_AXIS[13][3], Y_AXIS[13][4], Y_AXIS[13][5]);
    protected static final VoxelShape Y_AXISPart15 = Block.box(Y_AXIS[14][0], Y_AXIS[14][1], Y_AXIS[14][2], Y_AXIS[14][3], Y_AXIS[14][4], Y_AXIS[14][5]);
    protected static final VoxelShape Y_AXISPart16 = Block.box(Y_AXIS[15][0], Y_AXIS[15][1], Y_AXIS[15][2], Y_AXIS[15][3], Y_AXIS[15][4], Y_AXIS[15][5]);
    protected static final VoxelShape Y_AXISPart17 = Block.box(Y_AXIS[16][0], Y_AXIS[16][1], Y_AXIS[16][2], Y_AXIS[16][3], Y_AXIS[16][4], Y_AXIS[16][5]);
    protected static final VoxelShape Y_AXISPart18 = Block.box(Y_AXIS[17][0], Y_AXIS[17][1], Y_AXIS[17][2], Y_AXIS[17][3], Y_AXIS[17][4], Y_AXIS[17][5]);
    protected static final VoxelShape Y_AXISPart19 = Block.box(Y_AXIS[18][0], Y_AXIS[18][1], Y_AXIS[18][2], Y_AXIS[18][3], Y_AXIS[18][4], Y_AXIS[18][5]);
    protected static final VoxelShape Y_AXISPart20 = Block.box(Y_AXIS[19][0], Y_AXIS[19][1], Y_AXIS[19][2], Y_AXIS[19][3], Y_AXIS[19][4], Y_AXIS[19][5]);
    protected static final VoxelShape Y_AXISPart21 = Block.box(Y_AXIS[20][0], Y_AXIS[20][1], Y_AXIS[20][2], Y_AXIS[20][3], Y_AXIS[20][4], Y_AXIS[20][5]);
    protected static final VoxelShape Y_AXISPart22 = Block.box(Y_AXIS[21][0], Y_AXIS[21][1], Y_AXIS[21][2], Y_AXIS[21][3], Y_AXIS[21][4], Y_AXIS[21][5]);
    protected static final VoxelShape Y_AXISPart23 = Block.box(Y_AXIS[22][0], Y_AXIS[22][1], Y_AXIS[22][2], Y_AXIS[22][3], Y_AXIS[22][4], Y_AXIS[22][5]);
    protected static final VoxelShape Y_AXISPart24 = Block.box(Y_AXIS[23][0], Y_AXIS[23][1], Y_AXIS[23][2], Y_AXIS[23][3], Y_AXIS[23][4], Y_AXIS[23][5]);
    protected static final VoxelShape Y_AXISPart25 = Block.box(Y_AXIS[24][0], Y_AXIS[24][1], Y_AXIS[24][2], Y_AXIS[24][3], Y_AXIS[24][4], Y_AXIS[24][5]);
    protected static final VoxelShape Y_AXISPart26 = Block.box(Y_AXIS[25][0], Y_AXIS[25][1], Y_AXIS[25][2], Y_AXIS[25][3], Y_AXIS[25][4], Y_AXIS[25][5]);
    protected static final VoxelShape Y_AXISPart27 = Block.box(Y_AXIS[26][0], Y_AXIS[26][1], Y_AXIS[26][2], Y_AXIS[26][3], Y_AXIS[26][4], Y_AXIS[26][5]);
    protected static final VoxelShape Y_AXISPart28 = Block.box(Y_AXIS[27][0], Y_AXIS[27][1], Y_AXIS[27][2], Y_AXIS[27][3], Y_AXIS[27][4], Y_AXIS[27][5]);
    protected static final VoxelShape Y_AXISPart29 = Block.box(Y_AXIS[28][0], Y_AXIS[28][1], Y_AXIS[28][2], Y_AXIS[28][3], Y_AXIS[28][4], Y_AXIS[28][5]);
    protected static final VoxelShape Y_AXISPart30 = Block.box(Y_AXIS[29][0], Y_AXIS[29][1], Y_AXIS[29][2], Y_AXIS[29][3], Y_AXIS[29][4], Y_AXIS[29][5]);
    protected static final VoxelShape Y_AXISPart31 = Block.box(Y_AXIS[30][0], Y_AXIS[30][1], Y_AXIS[30][2], Y_AXIS[30][3], Y_AXIS[30][4], Y_AXIS[30][5]);
    protected static final VoxelShape Y_AXISPart32 = Block.box(Y_AXIS[31][0], Y_AXIS[31][1], Y_AXIS[31][2], Y_AXIS[31][3], Y_AXIS[31][4], Y_AXIS[31][5]);
    protected static final VoxelShape Y_AXISPart33 = Block.box(Y_AXIS[32][0], Y_AXIS[32][1], Y_AXIS[32][2], Y_AXIS[32][3], Y_AXIS[32][4], Y_AXIS[32][5]);
    protected static final VoxelShape Y_AXISPart34 = Block.box(Y_AXIS[33][0], Y_AXIS[33][1], Y_AXIS[33][2], Y_AXIS[33][3], Y_AXIS[33][4], Y_AXIS[33][5]);
    protected static final VoxelShape Y_AXISPart35 = Block.box(Y_AXIS[34][0], Y_AXIS[34][1], Y_AXIS[34][2], Y_AXIS[34][3], Y_AXIS[34][4], Y_AXIS[34][5]);
    private static final VoxelShape FULL_Y_AXIS_SHAPE = Shapes.or(Y_AXISPart1, Y_AXISPart2, Y_AXISPart3, Y_AXISPart4, Y_AXISPart5, Y_AXISPart6, Y_AXISPart7, Y_AXISPart8, Y_AXISPart9, Y_AXISPart10, Y_AXISPart11, Y_AXISPart12, Y_AXISPart13, Y_AXISPart14, Y_AXISPart15, Y_AXISPart16, Y_AXISPart17, Y_AXISPart18, Y_AXISPart19, Y_AXISPart20, Y_AXISPart21, Y_AXISPart22, Y_AXISPart23, Y_AXISPart24, Y_AXISPart25, Y_AXISPart26, Y_AXISPart27, Y_AXISPart28, Y_AXISPart29, Y_AXISPart30, Y_AXISPart31, Y_AXISPart32, Y_AXISPart33, Y_AXISPart34, Y_AXISPart35);

    /* Z_AXIS */
    protected static final double[][] Z_AXIS = {{6, 6, 11, 10, 10, 15},
            {7, 5, 11, 9, 6, 15},
            {7, 10, 11, 9, 11, 15},
            {5, 7, 11, 6, 9, 15},
            {10, 7, 11, 11, 9, 15},
            {6, 6, 6, 10, 10, 10},
            {7, 5, 6, 9, 6, 10},
            {7, 10, 6, 9, 11, 10},
            {5, 7, 6, 6, 9, 10},
            {10, 7, 6, 11, 9, 10},
            {6, 6, 1, 10, 10, 5},
            {7, 5, 1, 9, 6, 5},
            {7, 10, 1, 9, 11, 5},
            {5, 7, 1, 6, 9, 5},
            {10, 7, 1, 11, 9, 5},
            {5, 5, 15, 11, 11, 16},
            {4, 6, 15, 5, 10, 16},
            {11, 6, 15, 12, 10, 16},
            {6, 11, 15, 10, 12, 16},
            {6, 4, 15, 10, 5, 16},
            {5, 5, 10, 11, 11, 11},
            {6, 11, 10, 10, 12, 11},
            {6, 4, 10, 10, 5, 11},
            {4, 6, 10, 5, 10, 11},
            {11, 6, 10, 12, 10, 11},
            {5, 5, 5, 11, 11, 6},
            {6, 11, 5, 10, 12, 6},
            {6, 4, 5, 10, 5, 6},
            {4, 6, 5, 5, 10, 6},
            {11, 6, 5, 12, 10, 6},
            {5, 5, 0, 11, 11, 1},
            {6, 11, 0, 10, 12, 1},
            {6, 4, 0, 10, 5, 1},
            {4, 6, 0, 5, 10, 1},
            {11, 6, 0, 12, 10, 1}};
    protected static final VoxelShape Z_AXISPart1 = Block.box(Z_AXIS[0][0], Z_AXIS[0][1], Z_AXIS[0][2], Z_AXIS[0][3], Z_AXIS[0][4], Z_AXIS[0][5]);
    protected static final VoxelShape Z_AXISPart2 = Block.box(Z_AXIS[1][0], Z_AXIS[1][1], Z_AXIS[1][2], Z_AXIS[1][3], Z_AXIS[1][4], Z_AXIS[1][5]);
    protected static final VoxelShape Z_AXISPart3 = Block.box(Z_AXIS[2][0], Z_AXIS[2][1], Z_AXIS[2][2], Z_AXIS[2][3], Z_AXIS[2][4], Z_AXIS[2][5]);
    protected static final VoxelShape Z_AXISPart4 = Block.box(Z_AXIS[3][0], Z_AXIS[3][1], Z_AXIS[3][2], Z_AXIS[3][3], Z_AXIS[3][4], Z_AXIS[3][5]);
    protected static final VoxelShape Z_AXISPart5 = Block.box(Z_AXIS[4][0], Z_AXIS[4][1], Z_AXIS[4][2], Z_AXIS[4][3], Z_AXIS[4][4], Z_AXIS[4][5]);
    protected static final VoxelShape Z_AXISPart6 = Block.box(Z_AXIS[5][0], Z_AXIS[5][1], Z_AXIS[5][2], Z_AXIS[5][3], Z_AXIS[5][4], Z_AXIS[5][5]);
    protected static final VoxelShape Z_AXISPart7 = Block.box(Z_AXIS[6][0], Z_AXIS[6][1], Z_AXIS[6][2], Z_AXIS[6][3], Z_AXIS[6][4], Z_AXIS[6][5]);
    protected static final VoxelShape Z_AXISPart8 = Block.box(Z_AXIS[7][0], Z_AXIS[7][1], Z_AXIS[7][2], Z_AXIS[7][3], Z_AXIS[7][4], Z_AXIS[7][5]);
    protected static final VoxelShape Z_AXISPart9 = Block.box(Z_AXIS[8][0], Z_AXIS[8][1], Z_AXIS[8][2], Z_AXIS[8][3], Z_AXIS[8][4], Z_AXIS[8][5]);
    protected static final VoxelShape Z_AXISPart10 = Block.box(Z_AXIS[9][0], Z_AXIS[9][1], Z_AXIS[9][2], Z_AXIS[9][3], Z_AXIS[9][4], Z_AXIS[9][5]);
    protected static final VoxelShape Z_AXISPart11 = Block.box(Z_AXIS[10][0], Z_AXIS[10][1], Z_AXIS[10][2], Z_AXIS[10][3], Z_AXIS[10][4], Z_AXIS[10][5]);
    protected static final VoxelShape Z_AXISPart12 = Block.box(Z_AXIS[11][0], Z_AXIS[11][1], Z_AXIS[11][2], Z_AXIS[11][3], Z_AXIS[11][4], Z_AXIS[11][5]);
    protected static final VoxelShape Z_AXISPart13 = Block.box(Z_AXIS[12][0], Z_AXIS[12][1], Z_AXIS[12][2], Z_AXIS[12][3], Z_AXIS[12][4], Z_AXIS[12][5]);
    protected static final VoxelShape Z_AXISPart14 = Block.box(Z_AXIS[13][0], Z_AXIS[13][1], Z_AXIS[13][2], Z_AXIS[13][3], Z_AXIS[13][4], Z_AXIS[13][5]);
    protected static final VoxelShape Z_AXISPart15 = Block.box(Z_AXIS[14][0], Z_AXIS[14][1], Z_AXIS[14][2], Z_AXIS[14][3], Z_AXIS[14][4], Z_AXIS[14][5]);
    protected static final VoxelShape Z_AXISPart16 = Block.box(Z_AXIS[15][0], Z_AXIS[15][1], Z_AXIS[15][2], Z_AXIS[15][3], Z_AXIS[15][4], Z_AXIS[15][5]);
    protected static final VoxelShape Z_AXISPart17 = Block.box(Z_AXIS[16][0], Z_AXIS[16][1], Z_AXIS[16][2], Z_AXIS[16][3], Z_AXIS[16][4], Z_AXIS[16][5]);
    protected static final VoxelShape Z_AXISPart18 = Block.box(Z_AXIS[17][0], Z_AXIS[17][1], Z_AXIS[17][2], Z_AXIS[17][3], Z_AXIS[17][4], Z_AXIS[17][5]);
    protected static final VoxelShape Z_AXISPart19 = Block.box(Z_AXIS[18][0], Z_AXIS[18][1], Z_AXIS[18][2], Z_AXIS[18][3], Z_AXIS[18][4], Z_AXIS[18][5]);
    protected static final VoxelShape Z_AXISPart20 = Block.box(Z_AXIS[19][0], Z_AXIS[19][1], Z_AXIS[19][2], Z_AXIS[19][3], Z_AXIS[19][4], Z_AXIS[19][5]);
    protected static final VoxelShape Z_AXISPart21 = Block.box(Z_AXIS[20][0], Z_AXIS[20][1], Z_AXIS[20][2], Z_AXIS[20][3], Z_AXIS[20][4], Z_AXIS[20][5]);
    protected static final VoxelShape Z_AXISPart22 = Block.box(Z_AXIS[21][0], Z_AXIS[21][1], Z_AXIS[21][2], Z_AXIS[21][3], Z_AXIS[21][4], Z_AXIS[21][5]);
    protected static final VoxelShape Z_AXISPart23 = Block.box(Z_AXIS[22][0], Z_AXIS[22][1], Z_AXIS[22][2], Z_AXIS[22][3], Z_AXIS[22][4], Z_AXIS[22][5]);
    protected static final VoxelShape Z_AXISPart24 = Block.box(Z_AXIS[23][0], Z_AXIS[23][1], Z_AXIS[23][2], Z_AXIS[23][3], Z_AXIS[23][4], Z_AXIS[23][5]);
    protected static final VoxelShape Z_AXISPart25 = Block.box(Z_AXIS[24][0], Z_AXIS[24][1], Z_AXIS[24][2], Z_AXIS[24][3], Z_AXIS[24][4], Z_AXIS[24][5]);
    protected static final VoxelShape Z_AXISPart26 = Block.box(Z_AXIS[25][0], Z_AXIS[25][1], Z_AXIS[25][2], Z_AXIS[25][3], Z_AXIS[25][4], Z_AXIS[25][5]);
    protected static final VoxelShape Z_AXISPart27 = Block.box(Z_AXIS[26][0], Z_AXIS[26][1], Z_AXIS[26][2], Z_AXIS[26][3], Z_AXIS[26][4], Z_AXIS[26][5]);
    protected static final VoxelShape Z_AXISPart28 = Block.box(Z_AXIS[27][0], Z_AXIS[27][1], Z_AXIS[27][2], Z_AXIS[27][3], Z_AXIS[27][4], Z_AXIS[27][5]);
    protected static final VoxelShape Z_AXISPart29 = Block.box(Z_AXIS[28][0], Z_AXIS[28][1], Z_AXIS[28][2], Z_AXIS[28][3], Z_AXIS[28][4], Z_AXIS[28][5]);
    protected static final VoxelShape Z_AXISPart30 = Block.box(Z_AXIS[29][0], Z_AXIS[29][1], Z_AXIS[29][2], Z_AXIS[29][3], Z_AXIS[29][4], Z_AXIS[29][5]);
    protected static final VoxelShape Z_AXISPart31 = Block.box(Z_AXIS[30][0], Z_AXIS[30][1], Z_AXIS[30][2], Z_AXIS[30][3], Z_AXIS[30][4], Z_AXIS[30][5]);
    protected static final VoxelShape Z_AXISPart32 = Block.box(Z_AXIS[31][0], Z_AXIS[31][1], Z_AXIS[31][2], Z_AXIS[31][3], Z_AXIS[31][4], Z_AXIS[31][5]);
    protected static final VoxelShape Z_AXISPart33 = Block.box(Z_AXIS[32][0], Z_AXIS[32][1], Z_AXIS[32][2], Z_AXIS[32][3], Z_AXIS[32][4], Z_AXIS[32][5]);
    protected static final VoxelShape Z_AXISPart34 = Block.box(Z_AXIS[33][0], Z_AXIS[33][1], Z_AXIS[33][2], Z_AXIS[33][3], Z_AXIS[33][4], Z_AXIS[33][5]);
    protected static final VoxelShape Z_AXISPart35 = Block.box(Z_AXIS[34][0], Z_AXIS[34][1], Z_AXIS[34][2], Z_AXIS[34][3], Z_AXIS[34][4], Z_AXIS[34][5]);
    private static final VoxelShape FULL_Z_AXIS_SHAPE = Shapes.or(Z_AXISPart1, Z_AXISPart2, Z_AXISPart3, Z_AXISPart4, Z_AXISPart5, Z_AXISPart6, Z_AXISPart7, Z_AXISPart8, Z_AXISPart9, Z_AXISPart10, Z_AXISPart11, Z_AXISPart12, Z_AXISPart13, Z_AXISPart14, Z_AXISPart15, Z_AXISPart16, Z_AXISPart17, Z_AXISPart18, Z_AXISPart19, Z_AXISPart20, Z_AXISPart21, Z_AXISPart22, Z_AXISPart23, Z_AXISPart24, Z_AXISPart25, Z_AXISPart26, Z_AXISPart27, Z_AXISPart28, Z_AXISPart29, Z_AXISPart30, Z_AXISPart31, Z_AXISPart32, Z_AXISPart33, Z_AXISPart34, Z_AXISPart35);

    private final int color1;
    private final int color2;
    private final int color3;

    public SignalTowerLight(String name, int color1, int color2, int color3) {
        super(Block.Properties.of(Material.DECORATION).instabreak());
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        if (ModList.get().isLoaded("hypcore")) {
            //ColoredLightManager.registerProvider(this, this::produceColoredLight);
        }
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false).setValue(FACING, Direction.UP).setValue(LIGHT, 0));
        ModItems.ITEMS.register(name, () -> new BlockItem(this, new Item.Properties().tab(MoBlocks.decoration_creative_tab)));
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        if (state.getValue(POWERED))
            if (ModList.get().isLoaded("hypcore"))
                return 0;
            else
                return 15;
        return 0;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case UP:
            case DOWN:
                return FULL_Y_AXIS_SHAPE;
            case EAST:
            case WEST:
                return FULL_X_AXIS_SHAPE;
            case SOUTH:
            case NORTH:
                return FULL_Z_AXIS_SHAPE;
        }
        return Shapes.block();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED, FACING, LIGHT);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(POWERED, Boolean.valueOf(context.getLevel().hasNeighborSignal(context.getClickedPos()))).setValue(FACING, context.getClickedFace());
    }

    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        boolean flag = worldIn.hasNeighborSignal(pos);
        if (blockIn != this && flag != state.getValue(POWERED)) {
            BlockState newState = state.setValue(POWERED, Boolean.valueOf(flag));
            worldIn.setBlock(pos, newState, 2);
            if (state.getValue(POWERED)) {
                int nextLight = state.getValue(LIGHT) - 1;
                if (nextLight < 0) nextLight = 2;
                worldIn.setBlockAndUpdate(pos, newState.setValue(LIGHT, nextLight));
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SignalTowerLightTile(color1, color2, color3, pos, state);
    }



	/*public Light produceColoredLight(BlockPos pos, BlockState state) {
		TileEntity tileEntity = Minecraft.getInstance().world.getTileEntity(pos);
		int color = 0xFFFFFF;
		if (tileEntity instanceof SignalTowerLightTile) {
			SignalTowerLightTile signalTowerLightTile = (SignalTowerLightTile) tileEntity;
			color = signalTowerLightTile.getColor(state.get(LIGHT));
			if (color == 0xFF8800) color = 0xFF7F00;
		}
		return Light.builder().pos(pos).color(color, false).radius(state.get(POWERED) ? 14 : 0).build();
	}*/
}
