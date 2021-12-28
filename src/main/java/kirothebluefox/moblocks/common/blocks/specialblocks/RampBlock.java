package kirothebluefox.moblocks.common.blocks.specialblocks;

import kirothebluefox.moblocks.common.customproperties.CustomBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class RampBlock extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty CONNECTED_LEFT = CustomBlockStateProperties.CONNECTED_LEFT;
    public static final BooleanProperty CONNECTED_RIGHT = CustomBlockStateProperties.CONNECTED_RIGHT;
    /**
     * Straight block
     * SCBN = Straight block collision boxes, right side up, facing North
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] SCBN = {{0, 0, 0, 16, 1, 1},
            {0, 0, 1, 16, 2, 2},
            {0, 0, 6, 16, 7, 7},
            {0, 0, 7, 16, 8, 8},
            {0, 0, 4, 16, 5, 5},
            {0, 0, 5, 16, 6, 6},
            {0, 0, 2, 16, 3, 3},
            {0, 0, 3, 16, 4, 4},
            {0, 0, 14, 16, 15, 15},
            {0, 0, 15, 16, 16, 16},
            {0, 0, 12, 16, 13, 13},
            {0, 0, 13, 16, 14, 14},
            {0, 0, 10, 16, 11, 11},
            {0, 0, 9, 16, 10, 10},
            {0, 0, 8, 16, 9, 9},
            {0, 0, 11, 16, 12, 12}};
    protected static final VoxelShape SCBNPart1 = Block.box(SCBN[0][0], SCBN[0][1], SCBN[0][2], SCBN[0][3], SCBN[0][4], SCBN[0][5]);
    protected static final VoxelShape SCBNPart2 = Block.box(SCBN[1][0], SCBN[1][1], SCBN[1][2], SCBN[1][3], SCBN[1][4], SCBN[1][5]);
    protected static final VoxelShape SCBNPart3 = Block.box(SCBN[2][0], SCBN[2][1], SCBN[2][2], SCBN[2][3], SCBN[2][4], SCBN[2][5]);
    protected static final VoxelShape SCBNPart4 = Block.box(SCBN[3][0], SCBN[3][1], SCBN[3][2], SCBN[3][3], SCBN[3][4], SCBN[3][5]);
    protected static final VoxelShape SCBNPart5 = Block.box(SCBN[4][0], SCBN[4][1], SCBN[4][2], SCBN[4][3], SCBN[4][4], SCBN[4][5]);
    protected static final VoxelShape SCBNPart6 = Block.box(SCBN[5][0], SCBN[5][1], SCBN[5][2], SCBN[5][3], SCBN[5][4], SCBN[5][5]);
    protected static final VoxelShape SCBNPart7 = Block.box(SCBN[6][0], SCBN[6][1], SCBN[6][2], SCBN[6][3], SCBN[6][4], SCBN[6][5]);
    protected static final VoxelShape SCBNPart8 = Block.box(SCBN[7][0], SCBN[7][1], SCBN[7][2], SCBN[7][3], SCBN[7][4], SCBN[7][5]);
    protected static final VoxelShape SCBNPart9 = Block.box(SCBN[8][0], SCBN[8][1], SCBN[8][2], SCBN[8][3], SCBN[8][4], SCBN[8][5]);
    protected static final VoxelShape SCBNPart10 = Block.box(SCBN[9][0], SCBN[9][1], SCBN[9][2], SCBN[9][3], SCBN[9][4], SCBN[9][5]);
    protected static final VoxelShape SCBNPart11 = Block.box(SCBN[10][0], SCBN[10][1], SCBN[10][2], SCBN[10][3], SCBN[10][4], SCBN[10][5]);
    protected static final VoxelShape SCBNPart12 = Block.box(SCBN[11][0], SCBN[11][1], SCBN[11][2], SCBN[11][3], SCBN[11][4], SCBN[11][5]);
    protected static final VoxelShape SCBNPart13 = Block.box(SCBN[12][0], SCBN[12][1], SCBN[12][2], SCBN[12][3], SCBN[12][4], SCBN[12][5]);
    protected static final VoxelShape SCBNPart14 = Block.box(SCBN[13][0], SCBN[13][1], SCBN[13][2], SCBN[13][3], SCBN[13][4], SCBN[13][5]);
    protected static final VoxelShape SCBNPart15 = Block.box(SCBN[14][0], SCBN[14][1], SCBN[14][2], SCBN[14][3], SCBN[14][4], SCBN[14][5]);
    protected static final VoxelShape SCBNPart16 = Block.box(SCBN[15][0], SCBN[15][1], SCBN[15][2], SCBN[15][3], SCBN[15][4], SCBN[15][5]);
    private static final VoxelShape FULL_SCBN_SHAPE = Shapes.or(SCBNPart1, SCBNPart2, SCBNPart3, SCBNPart4, SCBNPart5, SCBNPart6, SCBNPart7, SCBNPart8, SCBNPart9, SCBNPart10, SCBNPart11, SCBNPart12, SCBNPart13, SCBNPart14, SCBNPart15, SCBNPart16);
    /**
     * Straight block
     * SCBS = Straight block collision boxes, right side up, facing South
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] SCBS = {{0, 0, 15, 16, 1, 16},
            {0, 0, 14, 16, 2, 15},
            {0, 0, 9, 16, 7, 10},
            {0, 0, 8, 16, 8, 9},
            {0, 0, 11, 16, 5, 12},
            {0, 0, 10, 16, 6, 11},
            {0, 0, 13, 16, 3, 14},
            {0, 0, 12, 16, 4, 13},
            {0, 0, 1, 16, 15, 2},
            {0, 0, 0, 16, 16, 1},
            {0, 0, 3, 16, 13, 4},
            {0, 0, 2, 16, 14, 3},
            {0, 0, 5, 16, 11, 6},
            {0, 0, 6, 16, 10, 7},
            {0, 0, 7, 16, 9, 8},
            {0, 0, 4, 16, 12, 5}};
    protected static final VoxelShape SCBSPart1 = Block.box(SCBS[0][0], SCBS[0][1], SCBS[0][2], SCBS[0][3], SCBS[0][4], SCBS[0][5]);
    protected static final VoxelShape SCBSPart2 = Block.box(SCBS[1][0], SCBS[1][1], SCBS[1][2], SCBS[1][3], SCBS[1][4], SCBS[1][5]);
    protected static final VoxelShape SCBSPart3 = Block.box(SCBS[2][0], SCBS[2][1], SCBS[2][2], SCBS[2][3], SCBS[2][4], SCBS[2][5]);
    protected static final VoxelShape SCBSPart4 = Block.box(SCBS[3][0], SCBS[3][1], SCBS[3][2], SCBS[3][3], SCBS[3][4], SCBS[3][5]);
    protected static final VoxelShape SCBSPart5 = Block.box(SCBS[4][0], SCBS[4][1], SCBS[4][2], SCBS[4][3], SCBS[4][4], SCBS[4][5]);
    protected static final VoxelShape SCBSPart6 = Block.box(SCBS[5][0], SCBS[5][1], SCBS[5][2], SCBS[5][3], SCBS[5][4], SCBS[5][5]);
    protected static final VoxelShape SCBSPart7 = Block.box(SCBS[6][0], SCBS[6][1], SCBS[6][2], SCBS[6][3], SCBS[6][4], SCBS[6][5]);
    protected static final VoxelShape SCBSPart8 = Block.box(SCBS[7][0], SCBS[7][1], SCBS[7][2], SCBS[7][3], SCBS[7][4], SCBS[7][5]);
    protected static final VoxelShape SCBSPart9 = Block.box(SCBS[8][0], SCBS[8][1], SCBS[8][2], SCBS[8][3], SCBS[8][4], SCBS[8][5]);
    protected static final VoxelShape SCBSPart10 = Block.box(SCBS[9][0], SCBS[9][1], SCBS[9][2], SCBS[9][3], SCBS[9][4], SCBS[9][5]);
    protected static final VoxelShape SCBSPart11 = Block.box(SCBS[10][0], SCBS[10][1], SCBS[10][2], SCBS[10][3], SCBS[10][4], SCBS[10][5]);
    protected static final VoxelShape SCBSPart12 = Block.box(SCBS[11][0], SCBS[11][1], SCBS[11][2], SCBS[11][3], SCBS[11][4], SCBS[11][5]);
    protected static final VoxelShape SCBSPart13 = Block.box(SCBS[12][0], SCBS[12][1], SCBS[12][2], SCBS[12][3], SCBS[12][4], SCBS[12][5]);
    protected static final VoxelShape SCBSPart14 = Block.box(SCBS[13][0], SCBS[13][1], SCBS[13][2], SCBS[13][3], SCBS[13][4], SCBS[13][5]);
    protected static final VoxelShape SCBSPart15 = Block.box(SCBS[14][0], SCBS[14][1], SCBS[14][2], SCBS[14][3], SCBS[14][4], SCBS[14][5]);
    protected static final VoxelShape SCBSPart16 = Block.box(SCBS[15][0], SCBS[15][1], SCBS[15][2], SCBS[15][3], SCBS[15][4], SCBS[15][5]);
    private static final VoxelShape FULL_SCBS_SHAPE = Shapes.or(SCBSPart1, SCBSPart2, SCBSPart3, SCBSPart4, SCBSPart5, SCBSPart6, SCBSPart7, SCBSPart8, SCBSPart9, SCBSPart10, SCBSPart11, SCBSPart12, SCBSPart13, SCBSPart14, SCBSPart15, SCBSPart16);
    /**
     * Straight block
     * SCBE = Straight block collision boxes, right side up, facing East
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] SCBE = {{15, 0, 0, 16, 1, 16},
            {14, 0, 0, 15, 2, 16},
            {9, 0, 0, 10, 7, 16},
            {8, 0, 0, 9, 8, 16},
            {11, 0, 0, 12, 5, 16},
            {10, 0, 0, 11, 6, 16},
            {13, 0, 0, 14, 3, 16},
            {12, 0, 0, 13, 4, 16},
            {1, 0, 0, 2, 15, 16},
            {0, 0, 0, 1, 16, 16},
            {3, 0, 0, 4, 13, 16},
            {2, 0, 0, 3, 14, 16},
            {5, 0, 0, 6, 11, 16},
            {6, 0, 0, 7, 10, 16},
            {7, 0, 0, 8, 9, 16},
            {4, 0, 0, 5, 12, 16}};
    protected static final VoxelShape SCBEPart1 = Block.box(SCBE[0][0], SCBE[0][1], SCBE[0][2], SCBE[0][3], SCBE[0][4], SCBE[0][5]);
    protected static final VoxelShape SCBEPart2 = Block.box(SCBE[1][0], SCBE[1][1], SCBE[1][2], SCBE[1][3], SCBE[1][4], SCBE[1][5]);
    protected static final VoxelShape SCBEPart3 = Block.box(SCBE[2][0], SCBE[2][1], SCBE[2][2], SCBE[2][3], SCBE[2][4], SCBE[2][5]);
    protected static final VoxelShape SCBEPart4 = Block.box(SCBE[3][0], SCBE[3][1], SCBE[3][2], SCBE[3][3], SCBE[3][4], SCBE[3][5]);
    protected static final VoxelShape SCBEPart5 = Block.box(SCBE[4][0], SCBE[4][1], SCBE[4][2], SCBE[4][3], SCBE[4][4], SCBE[4][5]);
    protected static final VoxelShape SCBEPart6 = Block.box(SCBE[5][0], SCBE[5][1], SCBE[5][2], SCBE[5][3], SCBE[5][4], SCBE[5][5]);
    protected static final VoxelShape SCBEPart7 = Block.box(SCBE[6][0], SCBE[6][1], SCBE[6][2], SCBE[6][3], SCBE[6][4], SCBE[6][5]);
    protected static final VoxelShape SCBEPart8 = Block.box(SCBE[7][0], SCBE[7][1], SCBE[7][2], SCBE[7][3], SCBE[7][4], SCBE[7][5]);
    protected static final VoxelShape SCBEPart9 = Block.box(SCBE[8][0], SCBE[8][1], SCBE[8][2], SCBE[8][3], SCBE[8][4], SCBE[8][5]);
    protected static final VoxelShape SCBEPart10 = Block.box(SCBE[9][0], SCBE[9][1], SCBE[9][2], SCBE[9][3], SCBE[9][4], SCBE[9][5]);
    protected static final VoxelShape SCBEPart11 = Block.box(SCBE[10][0], SCBE[10][1], SCBE[10][2], SCBE[10][3], SCBE[10][4], SCBE[10][5]);
    protected static final VoxelShape SCBEPart12 = Block.box(SCBE[11][0], SCBE[11][1], SCBE[11][2], SCBE[11][3], SCBE[11][4], SCBE[11][5]);
    protected static final VoxelShape SCBEPart13 = Block.box(SCBE[12][0], SCBE[12][1], SCBE[12][2], SCBE[12][3], SCBE[12][4], SCBE[12][5]);
    protected static final VoxelShape SCBEPart14 = Block.box(SCBE[13][0], SCBE[13][1], SCBE[13][2], SCBE[13][3], SCBE[13][4], SCBE[13][5]);
    protected static final VoxelShape SCBEPart15 = Block.box(SCBE[14][0], SCBE[14][1], SCBE[14][2], SCBE[14][3], SCBE[14][4], SCBE[14][5]);
    protected static final VoxelShape SCBEPart16 = Block.box(SCBE[15][0], SCBE[15][1], SCBE[15][2], SCBE[15][3], SCBE[15][4], SCBE[15][5]);
    private static final VoxelShape FULL_SCBE_SHAPE = Shapes.or(SCBEPart1, SCBEPart2, SCBEPart3, SCBEPart4, SCBEPart5, SCBEPart6, SCBEPart7, SCBEPart8, SCBEPart9, SCBEPart10, SCBEPart11, SCBEPart12, SCBEPart13, SCBEPart14, SCBEPart15, SCBEPart16);
    /**
     * Straight block
     * SCBW = Straight block collision boxes, right side up, facing West
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] SCBW = {{0, 0, 0, 1, 1, 16},
            {1, 0, 0, 2, 2, 16},
            {6, 0, 0, 7, 7, 16},
            {7, 0, 0, 8, 8, 16},
            {4, 0, 0, 5, 5, 16},
            {5, 0, 0, 6, 6, 16},
            {2, 0, 0, 3, 3, 16},
            {3, 0, 0, 4, 4, 16},
            {14, 0, 0, 15, 15, 16},
            {15, 0, 0, 16, 16, 16},
            {12, 0, 0, 13, 13, 16},
            {13, 0, 0, 14, 14, 16},
            {10, 0, 0, 11, 11, 16},
            {9, 0, 0, 10, 10, 16},
            {8, 0, 0, 9, 9, 16},
            {11, 0, 0, 12, 12, 16}};
    protected static final VoxelShape SCBWPart1 = Block.box(SCBW[0][0], SCBW[0][1], SCBW[0][2], SCBW[0][3], SCBW[0][4], SCBW[0][5]);
    protected static final VoxelShape SCBWPart2 = Block.box(SCBW[1][0], SCBW[1][1], SCBW[1][2], SCBW[1][3], SCBW[1][4], SCBW[1][5]);
    protected static final VoxelShape SCBWPart3 = Block.box(SCBW[2][0], SCBW[2][1], SCBW[2][2], SCBW[2][3], SCBW[2][4], SCBW[2][5]);
    protected static final VoxelShape SCBWPart4 = Block.box(SCBW[3][0], SCBW[3][1], SCBW[3][2], SCBW[3][3], SCBW[3][4], SCBW[3][5]);
    protected static final VoxelShape SCBWPart5 = Block.box(SCBW[4][0], SCBW[4][1], SCBW[4][2], SCBW[4][3], SCBW[4][4], SCBW[4][5]);
    protected static final VoxelShape SCBWPart6 = Block.box(SCBW[5][0], SCBW[5][1], SCBW[5][2], SCBW[5][3], SCBW[5][4], SCBW[5][5]);
    protected static final VoxelShape SCBWPart7 = Block.box(SCBW[6][0], SCBW[6][1], SCBW[6][2], SCBW[6][3], SCBW[6][4], SCBW[6][5]);
    protected static final VoxelShape SCBWPart8 = Block.box(SCBW[7][0], SCBW[7][1], SCBW[7][2], SCBW[7][3], SCBW[7][4], SCBW[7][5]);
    protected static final VoxelShape SCBWPart9 = Block.box(SCBW[8][0], SCBW[8][1], SCBW[8][2], SCBW[8][3], SCBW[8][4], SCBW[8][5]);
    protected static final VoxelShape SCBWPart10 = Block.box(SCBW[9][0], SCBW[9][1], SCBW[9][2], SCBW[9][3], SCBW[9][4], SCBW[9][5]);
    protected static final VoxelShape SCBWPart11 = Block.box(SCBW[10][0], SCBW[10][1], SCBW[10][2], SCBW[10][3], SCBW[10][4], SCBW[10][5]);
    protected static final VoxelShape SCBWPart12 = Block.box(SCBW[11][0], SCBW[11][1], SCBW[11][2], SCBW[11][3], SCBW[11][4], SCBW[11][5]);
    protected static final VoxelShape SCBWPart13 = Block.box(SCBW[12][0], SCBW[12][1], SCBW[12][2], SCBW[12][3], SCBW[12][4], SCBW[12][5]);
    protected static final VoxelShape SCBWPart14 = Block.box(SCBW[13][0], SCBW[13][1], SCBW[13][2], SCBW[13][3], SCBW[13][4], SCBW[13][5]);
    protected static final VoxelShape SCBWPart15 = Block.box(SCBW[14][0], SCBW[14][1], SCBW[14][2], SCBW[14][3], SCBW[14][4], SCBW[14][5]);
    protected static final VoxelShape SCBWPart16 = Block.box(SCBW[15][0], SCBW[15][1], SCBW[15][2], SCBW[15][3], SCBW[15][4], SCBW[15][5]);
    private static final VoxelShape FULL_SCBW_SHAPE = Shapes.or(SCBWPart1, SCBWPart2, SCBWPart3, SCBWPart4, SCBWPart5, SCBWPart6, SCBWPart7, SCBWPart8, SCBWPart9, SCBWPart10, SCBWPart11, SCBWPart12, SCBWPart13, SCBWPart14, SCBWPart15, SCBWPart16);
    /**
     * Straight block
     * SCTN = Straight block collision boxes, upside down, facing North
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] SCTN = {{0, 15, 0, 16, 16, 1},
            {0, 14, 1, 16, 16, 2},
            {0, 9, 6, 16, 16, 7},
            {0, 8, 7, 16, 16, 8},
            {0, 11, 4, 16, 16, 5},
            {0, 10, 5, 16, 16, 6},
            {0, 13, 2, 16, 16, 3},
            {0, 12, 3, 16, 16, 4},
            {0, 1, 14, 16, 16, 15},
            {0, 0, 15, 16, 16, 16},
            {0, 3, 12, 16, 16, 13},
            {0, 2, 13, 16, 16, 14},
            {0, 5, 10, 16, 16, 11},
            {0, 6, 9, 16, 16, 10},
            {0, 7, 8, 16, 16, 9},
            {0, 4, 11, 16, 16, 12}};
    protected static final VoxelShape SCTNPart1 = Block.box(SCTN[0][0], SCTN[0][1], SCTN[0][2], SCTN[0][3], SCTN[0][4], SCTN[0][5]);
    protected static final VoxelShape SCTNPart2 = Block.box(SCTN[1][0], SCTN[1][1], SCTN[1][2], SCTN[1][3], SCTN[1][4], SCTN[1][5]);
    protected static final VoxelShape SCTNPart3 = Block.box(SCTN[2][0], SCTN[2][1], SCTN[2][2], SCTN[2][3], SCTN[2][4], SCTN[2][5]);
    protected static final VoxelShape SCTNPart4 = Block.box(SCTN[3][0], SCTN[3][1], SCTN[3][2], SCTN[3][3], SCTN[3][4], SCTN[3][5]);
    protected static final VoxelShape SCTNPart5 = Block.box(SCTN[4][0], SCTN[4][1], SCTN[4][2], SCTN[4][3], SCTN[4][4], SCTN[4][5]);
    protected static final VoxelShape SCTNPart6 = Block.box(SCTN[5][0], SCTN[5][1], SCTN[5][2], SCTN[5][3], SCTN[5][4], SCTN[5][5]);
    protected static final VoxelShape SCTNPart7 = Block.box(SCTN[6][0], SCTN[6][1], SCTN[6][2], SCTN[6][3], SCTN[6][4], SCTN[6][5]);
    protected static final VoxelShape SCTNPart8 = Block.box(SCTN[7][0], SCTN[7][1], SCTN[7][2], SCTN[7][3], SCTN[7][4], SCTN[7][5]);
    protected static final VoxelShape SCTNPart9 = Block.box(SCTN[8][0], SCTN[8][1], SCTN[8][2], SCTN[8][3], SCTN[8][4], SCTN[8][5]);
    protected static final VoxelShape SCTNPart10 = Block.box(SCTN[9][0], SCTN[9][1], SCTN[9][2], SCTN[9][3], SCTN[9][4], SCTN[9][5]);
    protected static final VoxelShape SCTNPart11 = Block.box(SCTN[10][0], SCTN[10][1], SCTN[10][2], SCTN[10][3], SCTN[10][4], SCTN[10][5]);
    protected static final VoxelShape SCTNPart12 = Block.box(SCTN[11][0], SCTN[11][1], SCTN[11][2], SCTN[11][3], SCTN[11][4], SCTN[11][5]);
    protected static final VoxelShape SCTNPart13 = Block.box(SCTN[12][0], SCTN[12][1], SCTN[12][2], SCTN[12][3], SCTN[12][4], SCTN[12][5]);
    protected static final VoxelShape SCTNPart14 = Block.box(SCTN[13][0], SCTN[13][1], SCTN[13][2], SCTN[13][3], SCTN[13][4], SCTN[13][5]);
    protected static final VoxelShape SCTNPart15 = Block.box(SCTN[14][0], SCTN[14][1], SCTN[14][2], SCTN[14][3], SCTN[14][4], SCTN[14][5]);
    protected static final VoxelShape SCTNPart16 = Block.box(SCTN[15][0], SCTN[15][1], SCTN[15][2], SCTN[15][3], SCTN[15][4], SCTN[15][5]);
    private static final VoxelShape FULL_SCTN_SHAPE = Shapes.or(SCTNPart1, SCTNPart2, SCTNPart3, SCTNPart4, SCTNPart5, SCTNPart6, SCTNPart7, SCTNPart8, SCTNPart9, SCTNPart10, SCTNPart11, SCTNPart12, SCTNPart13, SCTNPart14, SCTNPart15, SCTNPart16);
    /**
     * Straight block
     * SCTS = Straight block collision boxes, upside down, facing South
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] SCTS = {{0, 15, 15, 16, 16, 16},
            {0, 14, 14, 16, 16, 15},
            {0, 9, 9, 16, 16, 10},
            {0, 8, 8, 16, 16, 9},
            {0, 11, 11, 16, 16, 12},
            {0, 10, 10, 16, 16, 11},
            {0, 13, 13, 16, 16, 14},
            {0, 12, 12, 16, 16, 13},
            {0, 1, 1, 16, 16, 2},
            {0, 0, 0, 16, 16, 1},
            {0, 3, 3, 16, 16, 4},
            {0, 2, 2, 16, 16, 3},
            {0, 5, 5, 16, 16, 6},
            {0, 6, 6, 16, 16, 7},
            {0, 7, 7, 16, 16, 8},
            {0, 4, 4, 16, 16, 5}};
    protected static final VoxelShape SCTSPart1 = Block.box(SCTS[0][0], SCTS[0][1], SCTS[0][2], SCTS[0][3], SCTS[0][4], SCTS[0][5]);
    protected static final VoxelShape SCTSPart2 = Block.box(SCTS[1][0], SCTS[1][1], SCTS[1][2], SCTS[1][3], SCTS[1][4], SCTS[1][5]);
    protected static final VoxelShape SCTSPart3 = Block.box(SCTS[2][0], SCTS[2][1], SCTS[2][2], SCTS[2][3], SCTS[2][4], SCTS[2][5]);
    protected static final VoxelShape SCTSPart4 = Block.box(SCTS[3][0], SCTS[3][1], SCTS[3][2], SCTS[3][3], SCTS[3][4], SCTS[3][5]);
    protected static final VoxelShape SCTSPart5 = Block.box(SCTS[4][0], SCTS[4][1], SCTS[4][2], SCTS[4][3], SCTS[4][4], SCTS[4][5]);
    protected static final VoxelShape SCTSPart6 = Block.box(SCTS[5][0], SCTS[5][1], SCTS[5][2], SCTS[5][3], SCTS[5][4], SCTS[5][5]);
    protected static final VoxelShape SCTSPart7 = Block.box(SCTS[6][0], SCTS[6][1], SCTS[6][2], SCTS[6][3], SCTS[6][4], SCTS[6][5]);
    protected static final VoxelShape SCTSPart8 = Block.box(SCTS[7][0], SCTS[7][1], SCTS[7][2], SCTS[7][3], SCTS[7][4], SCTS[7][5]);
    protected static final VoxelShape SCTSPart9 = Block.box(SCTS[8][0], SCTS[8][1], SCTS[8][2], SCTS[8][3], SCTS[8][4], SCTS[8][5]);
    protected static final VoxelShape SCTSPart10 = Block.box(SCTS[9][0], SCTS[9][1], SCTS[9][2], SCTS[9][3], SCTS[9][4], SCTS[9][5]);
    protected static final VoxelShape SCTSPart11 = Block.box(SCTS[10][0], SCTS[10][1], SCTS[10][2], SCTS[10][3], SCTS[10][4], SCTS[10][5]);
    protected static final VoxelShape SCTSPart12 = Block.box(SCTS[11][0], SCTS[11][1], SCTS[11][2], SCTS[11][3], SCTS[11][4], SCTS[11][5]);
    protected static final VoxelShape SCTSPart13 = Block.box(SCTS[12][0], SCTS[12][1], SCTS[12][2], SCTS[12][3], SCTS[12][4], SCTS[12][5]);
    protected static final VoxelShape SCTSPart14 = Block.box(SCTS[13][0], SCTS[13][1], SCTS[13][2], SCTS[13][3], SCTS[13][4], SCTS[13][5]);
    protected static final VoxelShape SCTSPart15 = Block.box(SCTS[14][0], SCTS[14][1], SCTS[14][2], SCTS[14][3], SCTS[14][4], SCTS[14][5]);
    protected static final VoxelShape SCTSPart16 = Block.box(SCTS[15][0], SCTS[15][1], SCTS[15][2], SCTS[15][3], SCTS[15][4], SCTS[15][5]);
    private static final VoxelShape FULL_SCTS_SHAPE = Shapes.or(SCTSPart1, SCTSPart2, SCTSPart3, SCTSPart4, SCTSPart5, SCTSPart6, SCTSPart7, SCTSPart8, SCTSPart9, SCTSPart10, SCTSPart11, SCTSPart12, SCTSPart13, SCTSPart14, SCTSPart15, SCTSPart16);
    /**
     * Straight block
     * SCTE = Straight block collision boxes, upside down, facing East
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] SCTE = {{15, 15, 0, 16, 16, 16},
            {14, 14, 0, 15, 16, 16},
            {9, 9, 0, 10, 16, 16},
            {8, 8, 0, 9, 16, 16},
            {11, 11, 0, 12, 16, 16},
            {10, 10, 0, 11, 16, 16},
            {13, 13, 0, 14, 16, 16},
            {12, 12, 0, 13, 16, 16},
            {1, 1, 0, 2, 16, 16},
            {0, 0, 0, 1, 16, 16},
            {3, 3, 0, 4, 16, 16},
            {2, 2, 0, 3, 16, 16},
            {5, 5, 0, 6, 16, 16},
            {6, 6, 0, 7, 16, 16},
            {7, 7, 0, 8, 16, 16},
            {4, 4, 0, 5, 16, 16}};
    protected static final VoxelShape SCTEPart1 = Block.box(SCTE[0][0], SCTE[0][1], SCTE[0][2], SCTE[0][3], SCTE[0][4], SCTE[0][5]);
    protected static final VoxelShape SCTEPart2 = Block.box(SCTE[1][0], SCTE[1][1], SCTE[1][2], SCTE[1][3], SCTE[1][4], SCTE[1][5]);
    protected static final VoxelShape SCTEPart3 = Block.box(SCTE[2][0], SCTE[2][1], SCTE[2][2], SCTE[2][3], SCTE[2][4], SCTE[2][5]);
    protected static final VoxelShape SCTEPart4 = Block.box(SCTE[3][0], SCTE[3][1], SCTE[3][2], SCTE[3][3], SCTE[3][4], SCTE[3][5]);
    protected static final VoxelShape SCTEPart5 = Block.box(SCTE[4][0], SCTE[4][1], SCTE[4][2], SCTE[4][3], SCTE[4][4], SCTE[4][5]);
    protected static final VoxelShape SCTEPart6 = Block.box(SCTE[5][0], SCTE[5][1], SCTE[5][2], SCTE[5][3], SCTE[5][4], SCTE[5][5]);
    protected static final VoxelShape SCTEPart7 = Block.box(SCTE[6][0], SCTE[6][1], SCTE[6][2], SCTE[6][3], SCTE[6][4], SCTE[6][5]);
    protected static final VoxelShape SCTEPart8 = Block.box(SCTE[7][0], SCTE[7][1], SCTE[7][2], SCTE[7][3], SCTE[7][4], SCTE[7][5]);
    protected static final VoxelShape SCTEPart9 = Block.box(SCTE[8][0], SCTE[8][1], SCTE[8][2], SCTE[8][3], SCTE[8][4], SCTE[8][5]);
    protected static final VoxelShape SCTEPart10 = Block.box(SCTE[9][0], SCTE[9][1], SCTE[9][2], SCTE[9][3], SCTE[9][4], SCTE[9][5]);
    protected static final VoxelShape SCTEPart11 = Block.box(SCTE[10][0], SCTE[10][1], SCTE[10][2], SCTE[10][3], SCTE[10][4], SCTE[10][5]);
    protected static final VoxelShape SCTEPart12 = Block.box(SCTE[11][0], SCTE[11][1], SCTE[11][2], SCTE[11][3], SCTE[11][4], SCTE[11][5]);
    protected static final VoxelShape SCTEPart13 = Block.box(SCTE[12][0], SCTE[12][1], SCTE[12][2], SCTE[12][3], SCTE[12][4], SCTE[12][5]);
    protected static final VoxelShape SCTEPart14 = Block.box(SCTE[13][0], SCTE[13][1], SCTE[13][2], SCTE[13][3], SCTE[13][4], SCTE[13][5]);
    protected static final VoxelShape SCTEPart15 = Block.box(SCTE[14][0], SCTE[14][1], SCTE[14][2], SCTE[14][3], SCTE[14][4], SCTE[14][5]);
    protected static final VoxelShape SCTEPart16 = Block.box(SCTE[15][0], SCTE[15][1], SCTE[15][2], SCTE[15][3], SCTE[15][4], SCTE[15][5]);
    private static final VoxelShape FULL_SCTE_SHAPE = Shapes.or(SCTEPart1, SCTEPart2, SCTEPart3, SCTEPart4, SCTEPart5, SCTEPart6, SCTEPart7, SCTEPart8, SCTEPart9, SCTEPart10, SCTEPart11, SCTEPart12, SCTEPart13, SCTEPart14, SCTEPart15, SCTEPart16);
    /**
     * Straight block
     * SCTW = Straight block collision boxes, upside down, facing West
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] SCTW = {{0, 15, 0, 1, 16, 16},
            {1, 14, 0, 2, 16, 16},
            {6, 9, 0, 7, 16, 16},
            {7, 8, 0, 8, 16, 16},
            {4, 11, 0, 5, 16, 16},
            {5, 10, 0, 6, 16, 16},
            {2, 13, 0, 3, 16, 16},
            {3, 12, 0, 4, 16, 16},
            {14, 1, 0, 15, 16, 16},
            {15, 0, 0, 16, 16, 16},
            {12, 3, 0, 13, 16, 16},
            {13, 2, 0, 14, 16, 16},
            {10, 5, 0, 11, 16, 16},
            {9, 6, 0, 10, 16, 16},
            {8, 7, 0, 9, 16, 16},
            {11, 4, 0, 12, 16, 16}};
    protected static final VoxelShape SCTWPart1 = Block.box(SCTW[0][0], SCTW[0][1], SCTW[0][2], SCTW[0][3], SCTW[0][4], SCTW[0][5]);
    protected static final VoxelShape SCTWPart2 = Block.box(SCTW[1][0], SCTW[1][1], SCTW[1][2], SCTW[1][3], SCTW[1][4], SCTW[1][5]);
    protected static final VoxelShape SCTWPart3 = Block.box(SCTW[2][0], SCTW[2][1], SCTW[2][2], SCTW[2][3], SCTW[2][4], SCTW[2][5]);
    protected static final VoxelShape SCTWPart4 = Block.box(SCTW[3][0], SCTW[3][1], SCTW[3][2], SCTW[3][3], SCTW[3][4], SCTW[3][5]);
    protected static final VoxelShape SCTWPart5 = Block.box(SCTW[4][0], SCTW[4][1], SCTW[4][2], SCTW[4][3], SCTW[4][4], SCTW[4][5]);
    protected static final VoxelShape SCTWPart6 = Block.box(SCTW[5][0], SCTW[5][1], SCTW[5][2], SCTW[5][3], SCTW[5][4], SCTW[5][5]);
    protected static final VoxelShape SCTWPart7 = Block.box(SCTW[6][0], SCTW[6][1], SCTW[6][2], SCTW[6][3], SCTW[6][4], SCTW[6][5]);
    protected static final VoxelShape SCTWPart8 = Block.box(SCTW[7][0], SCTW[7][1], SCTW[7][2], SCTW[7][3], SCTW[7][4], SCTW[7][5]);
    protected static final VoxelShape SCTWPart9 = Block.box(SCTW[8][0], SCTW[8][1], SCTW[8][2], SCTW[8][3], SCTW[8][4], SCTW[8][5]);
    protected static final VoxelShape SCTWPart10 = Block.box(SCTW[9][0], SCTW[9][1], SCTW[9][2], SCTW[9][3], SCTW[9][4], SCTW[9][5]);
    protected static final VoxelShape SCTWPart11 = Block.box(SCTW[10][0], SCTW[10][1], SCTW[10][2], SCTW[10][3], SCTW[10][4], SCTW[10][5]);
    protected static final VoxelShape SCTWPart12 = Block.box(SCTW[11][0], SCTW[11][1], SCTW[11][2], SCTW[11][3], SCTW[11][4], SCTW[11][5]);
    protected static final VoxelShape SCTWPart13 = Block.box(SCTW[12][0], SCTW[12][1], SCTW[12][2], SCTW[12][3], SCTW[12][4], SCTW[12][5]);
    protected static final VoxelShape SCTWPart14 = Block.box(SCTW[13][0], SCTW[13][1], SCTW[13][2], SCTW[13][3], SCTW[13][4], SCTW[13][5]);
    protected static final VoxelShape SCTWPart15 = Block.box(SCTW[14][0], SCTW[14][1], SCTW[14][2], SCTW[14][3], SCTW[14][4], SCTW[14][5]);
    protected static final VoxelShape SCTWPart16 = Block.box(SCTW[15][0], SCTW[15][1], SCTW[15][2], SCTW[15][3], SCTW[15][4], SCTW[15][5]);
    private static final VoxelShape FULL_SCTW_SHAPE = Shapes.or(SCTWPart1, SCTWPart2, SCTWPart3, SCTWPart4, SCTWPart5, SCTWPart6, SCTWPart7, SCTWPart8, SCTWPart9, SCTWPart10, SCTWPart11, SCTWPart12, SCTWPart13, SCTWPart14, SCTWPart15, SCTWPart16);
    /**
     * Inner corner block
     * ICBN = Inner corner block collision boxes, right side up, facing North
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] ICBN = {{0, 0, 0, 1, 1, 1},
            {0, 0, 1, 2, 2, 2},
            {11, 0, 0, 12, 12, 11},
            {8, 0, 0, 9, 9, 8},
            {9, 0, 0, 10, 10, 9},
            {10, 0, 0, 11, 11, 10},
            {13, 0, 0, 14, 14, 13},
            {12, 0, 0, 13, 13, 12},
            {15, 0, 0, 16, 16, 15},
            {14, 0, 0, 15, 15, 14},
            {3, 0, 0, 4, 4, 3},
            {2, 0, 0, 3, 3, 2},
            {5, 0, 0, 6, 6, 5},
            {4, 0, 0, 5, 5, 4},
            {7, 0, 0, 8, 8, 7},
            {6, 0, 0, 7, 7, 6},
            {1, 0, 0, 2, 2, 1},
            {0, 0, 6, 7, 7, 7},
            {0, 0, 7, 8, 8, 8},
            {0, 0, 4, 5, 5, 5},
            {0, 0, 5, 6, 6, 6},
            {0, 0, 2, 3, 3, 3},
            {0, 0, 3, 4, 4, 4},
            {0, 0, 14, 15, 15, 15},
            {0, 0, 15, 16, 16, 16},
            {0, 0, 12, 13, 13, 13},
            {0, 0, 13, 14, 14, 14},
            {0, 0, 10, 11, 11, 11},
            {0, 0, 9, 10, 10, 10},
            {0, 0, 8, 9, 9, 9},
            {0, 0, 11, 12, 12, 12}};
    protected static final VoxelShape ICBNPart1 = Block.box(ICBN[0][0], ICBN[0][1], ICBN[0][2], ICBN[0][3], ICBN[0][4], ICBN[0][5]);
    protected static final VoxelShape ICBNPart2 = Block.box(ICBN[1][0], ICBN[1][1], ICBN[1][2], ICBN[1][3], ICBN[1][4], ICBN[1][5]);
    protected static final VoxelShape ICBNPart3 = Block.box(ICBN[2][0], ICBN[2][1], ICBN[2][2], ICBN[2][3], ICBN[2][4], ICBN[2][5]);
    protected static final VoxelShape ICBNPart4 = Block.box(ICBN[3][0], ICBN[3][1], ICBN[3][2], ICBN[3][3], ICBN[3][4], ICBN[3][5]);
    protected static final VoxelShape ICBNPart5 = Block.box(ICBN[4][0], ICBN[4][1], ICBN[4][2], ICBN[4][3], ICBN[4][4], ICBN[4][5]);
    protected static final VoxelShape ICBNPart6 = Block.box(ICBN[5][0], ICBN[5][1], ICBN[5][2], ICBN[5][3], ICBN[5][4], ICBN[5][5]);
    protected static final VoxelShape ICBNPart7 = Block.box(ICBN[6][0], ICBN[6][1], ICBN[6][2], ICBN[6][3], ICBN[6][4], ICBN[6][5]);
    protected static final VoxelShape ICBNPart8 = Block.box(ICBN[7][0], ICBN[7][1], ICBN[7][2], ICBN[7][3], ICBN[7][4], ICBN[7][5]);
    protected static final VoxelShape ICBNPart9 = Block.box(ICBN[8][0], ICBN[8][1], ICBN[8][2], ICBN[8][3], ICBN[8][4], ICBN[8][5]);
    protected static final VoxelShape ICBNPart10 = Block.box(ICBN[9][0], ICBN[9][1], ICBN[9][2], ICBN[9][3], ICBN[9][4], ICBN[9][5]);
    protected static final VoxelShape ICBNPart11 = Block.box(ICBN[10][0], ICBN[10][1], ICBN[10][2], ICBN[10][3], ICBN[10][4], ICBN[10][5]);
    protected static final VoxelShape ICBNPart12 = Block.box(ICBN[11][0], ICBN[11][1], ICBN[11][2], ICBN[11][3], ICBN[11][4], ICBN[11][5]);
    protected static final VoxelShape ICBNPart13 = Block.box(ICBN[12][0], ICBN[12][1], ICBN[12][2], ICBN[12][3], ICBN[12][4], ICBN[12][5]);
    protected static final VoxelShape ICBNPart14 = Block.box(ICBN[13][0], ICBN[13][1], ICBN[13][2], ICBN[13][3], ICBN[13][4], ICBN[13][5]);
    protected static final VoxelShape ICBNPart15 = Block.box(ICBN[14][0], ICBN[14][1], ICBN[14][2], ICBN[14][3], ICBN[14][4], ICBN[14][5]);
    protected static final VoxelShape ICBNPart16 = Block.box(ICBN[15][0], ICBN[15][1], ICBN[15][2], ICBN[15][3], ICBN[15][4], ICBN[15][5]);
    protected static final VoxelShape ICBNPart17 = Block.box(ICBN[16][0], ICBN[16][1], ICBN[16][2], ICBN[16][3], ICBN[16][4], ICBN[16][5]);
    protected static final VoxelShape ICBNPart18 = Block.box(ICBN[17][0], ICBN[17][1], ICBN[17][2], ICBN[17][3], ICBN[17][4], ICBN[17][5]);
    protected static final VoxelShape ICBNPart19 = Block.box(ICBN[18][0], ICBN[18][1], ICBN[18][2], ICBN[18][3], ICBN[18][4], ICBN[18][5]);
    protected static final VoxelShape ICBNPart20 = Block.box(ICBN[19][0], ICBN[19][1], ICBN[19][2], ICBN[19][3], ICBN[19][4], ICBN[19][5]);
    protected static final VoxelShape ICBNPart21 = Block.box(ICBN[20][0], ICBN[20][1], ICBN[20][2], ICBN[20][3], ICBN[20][4], ICBN[20][5]);
    protected static final VoxelShape ICBNPart22 = Block.box(ICBN[21][0], ICBN[21][1], ICBN[21][2], ICBN[21][3], ICBN[21][4], ICBN[21][5]);
    protected static final VoxelShape ICBNPart23 = Block.box(ICBN[22][0], ICBN[22][1], ICBN[22][2], ICBN[22][3], ICBN[22][4], ICBN[22][5]);
    protected static final VoxelShape ICBNPart24 = Block.box(ICBN[23][0], ICBN[23][1], ICBN[23][2], ICBN[23][3], ICBN[23][4], ICBN[23][5]);
    protected static final VoxelShape ICBNPart25 = Block.box(ICBN[24][0], ICBN[24][1], ICBN[24][2], ICBN[24][3], ICBN[24][4], ICBN[24][5]);
    protected static final VoxelShape ICBNPart26 = Block.box(ICBN[25][0], ICBN[25][1], ICBN[25][2], ICBN[25][3], ICBN[25][4], ICBN[25][5]);
    protected static final VoxelShape ICBNPart27 = Block.box(ICBN[26][0], ICBN[26][1], ICBN[26][2], ICBN[26][3], ICBN[26][4], ICBN[26][5]);
    protected static final VoxelShape ICBNPart28 = Block.box(ICBN[27][0], ICBN[27][1], ICBN[27][2], ICBN[27][3], ICBN[27][4], ICBN[27][5]);
    protected static final VoxelShape ICBNPart29 = Block.box(ICBN[28][0], ICBN[28][1], ICBN[28][2], ICBN[28][3], ICBN[28][4], ICBN[28][5]);
    protected static final VoxelShape ICBNPart30 = Block.box(ICBN[29][0], ICBN[29][1], ICBN[29][2], ICBN[29][3], ICBN[29][4], ICBN[29][5]);
    protected static final VoxelShape ICBNPart31 = Block.box(ICBN[30][0], ICBN[30][1], ICBN[30][2], ICBN[30][3], ICBN[30][4], ICBN[30][5]);
    private static final VoxelShape FULL_ICBN_SHAPE = Shapes.or(ICBNPart1, ICBNPart2, ICBNPart3, ICBNPart4, ICBNPart5, ICBNPart6, ICBNPart7, ICBNPart8, ICBNPart9, ICBNPart10, ICBNPart11, ICBNPart12, ICBNPart13, ICBNPart14, ICBNPart15, ICBNPart16, ICBNPart17, ICBNPart18, ICBNPart19, ICBNPart20, ICBNPart21, ICBNPart22, ICBNPart23, ICBNPart24, ICBNPart25, ICBNPart26, ICBNPart27, ICBNPart28, ICBNPart29, ICBNPart30, ICBNPart31);
    /**
     * Inner corner block
     * ICBS = Inner corner block collision boxes, right side up, facing South
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] ICBS = {{15, 0, 15, 16, 1, 16},
            {14, 0, 14, 16, 2, 15},
            {4, 0, 5, 5, 12, 16},
            {7, 0, 8, 8, 9, 16},
            {6, 0, 7, 7, 10, 16},
            {5, 0, 6, 6, 11, 16},
            {2, 0, 3, 3, 14, 16},
            {3, 0, 4, 4, 13, 16},
            {0, 0, 1, 1, 16, 16},
            {1, 0, 2, 2, 15, 16},
            {12, 0, 13, 13, 4, 16},
            {13, 0, 14, 14, 3, 16},
            {10, 0, 11, 11, 6, 16},
            {11, 0, 12, 12, 5, 16},
            {8, 0, 9, 9, 8, 16},
            {9, 0, 10, 10, 7, 16},
            {14, 0, 15, 15, 2, 16},
            {9, 0, 9, 16, 7, 10},
            {8, 0, 8, 16, 8, 9},
            {11, 0, 11, 16, 5, 12},
            {10, 0, 10, 16, 6, 11},
            {13, 0, 13, 16, 3, 14},
            {12, 0, 12, 16, 4, 13},
            {1, 0, 1, 16, 15, 2},
            {0, 0, 0, 16, 16, 1},
            {3, 0, 3, 16, 13, 4},
            {2, 0, 2, 16, 14, 3},
            {5, 0, 5, 16, 11, 6},
            {6, 0, 6, 16, 10, 7},
            {7, 0, 7, 16, 9, 8},
            {4, 0, 4, 16, 12, 5}};
    protected static final VoxelShape ICBSPart1 = Block.box(ICBS[0][0], ICBS[0][1], ICBS[0][2], ICBS[0][3], ICBS[0][4], ICBS[0][5]);
    protected static final VoxelShape ICBSPart2 = Block.box(ICBS[1][0], ICBS[1][1], ICBS[1][2], ICBS[1][3], ICBS[1][4], ICBS[1][5]);
    protected static final VoxelShape ICBSPart3 = Block.box(ICBS[2][0], ICBS[2][1], ICBS[2][2], ICBS[2][3], ICBS[2][4], ICBS[2][5]);
    protected static final VoxelShape ICBSPart4 = Block.box(ICBS[3][0], ICBS[3][1], ICBS[3][2], ICBS[3][3], ICBS[3][4], ICBS[3][5]);
    protected static final VoxelShape ICBSPart5 = Block.box(ICBS[4][0], ICBS[4][1], ICBS[4][2], ICBS[4][3], ICBS[4][4], ICBS[4][5]);
    protected static final VoxelShape ICBSPart6 = Block.box(ICBS[5][0], ICBS[5][1], ICBS[5][2], ICBS[5][3], ICBS[5][4], ICBS[5][5]);
    protected static final VoxelShape ICBSPart7 = Block.box(ICBS[6][0], ICBS[6][1], ICBS[6][2], ICBS[6][3], ICBS[6][4], ICBS[6][5]);
    protected static final VoxelShape ICBSPart8 = Block.box(ICBS[7][0], ICBS[7][1], ICBS[7][2], ICBS[7][3], ICBS[7][4], ICBS[7][5]);
    protected static final VoxelShape ICBSPart9 = Block.box(ICBS[8][0], ICBS[8][1], ICBS[8][2], ICBS[8][3], ICBS[8][4], ICBS[8][5]);
    protected static final VoxelShape ICBSPart10 = Block.box(ICBS[9][0], ICBS[9][1], ICBS[9][2], ICBS[9][3], ICBS[9][4], ICBS[9][5]);
    protected static final VoxelShape ICBSPart11 = Block.box(ICBS[10][0], ICBS[10][1], ICBS[10][2], ICBS[10][3], ICBS[10][4], ICBS[10][5]);
    protected static final VoxelShape ICBSPart12 = Block.box(ICBS[11][0], ICBS[11][1], ICBS[11][2], ICBS[11][3], ICBS[11][4], ICBS[11][5]);
    protected static final VoxelShape ICBSPart13 = Block.box(ICBS[12][0], ICBS[12][1], ICBS[12][2], ICBS[12][3], ICBS[12][4], ICBS[12][5]);
    protected static final VoxelShape ICBSPart14 = Block.box(ICBS[13][0], ICBS[13][1], ICBS[13][2], ICBS[13][3], ICBS[13][4], ICBS[13][5]);
    protected static final VoxelShape ICBSPart15 = Block.box(ICBS[14][0], ICBS[14][1], ICBS[14][2], ICBS[14][3], ICBS[14][4], ICBS[14][5]);
    protected static final VoxelShape ICBSPart16 = Block.box(ICBS[15][0], ICBS[15][1], ICBS[15][2], ICBS[15][3], ICBS[15][4], ICBS[15][5]);
    protected static final VoxelShape ICBSPart17 = Block.box(ICBS[16][0], ICBS[16][1], ICBS[16][2], ICBS[16][3], ICBS[16][4], ICBS[16][5]);
    protected static final VoxelShape ICBSPart18 = Block.box(ICBS[17][0], ICBS[17][1], ICBS[17][2], ICBS[17][3], ICBS[17][4], ICBS[17][5]);
    protected static final VoxelShape ICBSPart19 = Block.box(ICBS[18][0], ICBS[18][1], ICBS[18][2], ICBS[18][3], ICBS[18][4], ICBS[18][5]);
    protected static final VoxelShape ICBSPart20 = Block.box(ICBS[19][0], ICBS[19][1], ICBS[19][2], ICBS[19][3], ICBS[19][4], ICBS[19][5]);
    protected static final VoxelShape ICBSPart21 = Block.box(ICBS[20][0], ICBS[20][1], ICBS[20][2], ICBS[20][3], ICBS[20][4], ICBS[20][5]);
    protected static final VoxelShape ICBSPart22 = Block.box(ICBS[21][0], ICBS[21][1], ICBS[21][2], ICBS[21][3], ICBS[21][4], ICBS[21][5]);
    protected static final VoxelShape ICBSPart23 = Block.box(ICBS[22][0], ICBS[22][1], ICBS[22][2], ICBS[22][3], ICBS[22][4], ICBS[22][5]);
    protected static final VoxelShape ICBSPart24 = Block.box(ICBS[23][0], ICBS[23][1], ICBS[23][2], ICBS[23][3], ICBS[23][4], ICBS[23][5]);
    protected static final VoxelShape ICBSPart25 = Block.box(ICBS[24][0], ICBS[24][1], ICBS[24][2], ICBS[24][3], ICBS[24][4], ICBS[24][5]);
    protected static final VoxelShape ICBSPart26 = Block.box(ICBS[25][0], ICBS[25][1], ICBS[25][2], ICBS[25][3], ICBS[25][4], ICBS[25][5]);
    protected static final VoxelShape ICBSPart27 = Block.box(ICBS[26][0], ICBS[26][1], ICBS[26][2], ICBS[26][3], ICBS[26][4], ICBS[26][5]);
    protected static final VoxelShape ICBSPart28 = Block.box(ICBS[27][0], ICBS[27][1], ICBS[27][2], ICBS[27][3], ICBS[27][4], ICBS[27][5]);
    protected static final VoxelShape ICBSPart29 = Block.box(ICBS[28][0], ICBS[28][1], ICBS[28][2], ICBS[28][3], ICBS[28][4], ICBS[28][5]);
    protected static final VoxelShape ICBSPart30 = Block.box(ICBS[29][0], ICBS[29][1], ICBS[29][2], ICBS[29][3], ICBS[29][4], ICBS[29][5]);
    protected static final VoxelShape ICBSPart31 = Block.box(ICBS[30][0], ICBS[30][1], ICBS[30][2], ICBS[30][3], ICBS[30][4], ICBS[30][5]);
    private static final VoxelShape FULL_ICBS_SHAPE = Shapes.or(ICBSPart1, ICBSPart2, ICBSPart3, ICBSPart4, ICBSPart5, ICBSPart6, ICBSPart7, ICBSPart8, ICBSPart9, ICBSPart10, ICBSPart11, ICBSPart12, ICBSPart13, ICBSPart14, ICBSPart15, ICBSPart16, ICBSPart17, ICBSPart18, ICBSPart19, ICBSPart20, ICBSPart21, ICBSPart22, ICBSPart23, ICBSPart24, ICBSPart25, ICBSPart26, ICBSPart27, ICBSPart28, ICBSPart29, ICBSPart30, ICBSPart31);
    /**
     * Inner corner block
     * ICBE = Inner corner block collision boxes, right side up, facing East
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] ICBE = {{15, 0, 0, 16, 1, 1},
            {14, 0, 0, 15, 2, 2},
            {5, 0, 11, 16, 12, 12},
            {8, 0, 8, 16, 9, 9},
            {7, 0, 9, 16, 10, 10},
            {6, 0, 10, 16, 11, 11},
            {3, 0, 13, 16, 14, 14},
            {4, 0, 12, 16, 13, 13},
            {1, 0, 15, 16, 16, 16},
            {2, 0, 14, 16, 15, 15},
            {13, 0, 3, 16, 4, 4},
            {14, 0, 2, 16, 3, 3},
            {11, 0, 5, 16, 6, 6},
            {12, 0, 4, 16, 5, 5},
            {9, 0, 7, 16, 8, 8},
            {10, 0, 6, 16, 7, 7},
            {15, 0, 1, 16, 2, 2},
            {9, 0, 0, 10, 7, 7},
            {8, 0, 0, 9, 8, 8},
            {11, 0, 0, 12, 5, 5},
            {10, 0, 0, 11, 6, 6},
            {13, 0, 0, 14, 3, 3},
            {12, 0, 0, 13, 4, 4},
            {1, 0, 0, 2, 15, 15},
            {0, 0, 0, 1, 16, 16},
            {3, 0, 0, 4, 13, 13},
            {2, 0, 0, 3, 14, 14},
            {5, 0, 0, 6, 11, 11},
            {6, 0, 0, 7, 10, 10},
            {7, 0, 0, 8, 9, 9},
            {4, 0, 0, 5, 12, 12}};
    protected static final VoxelShape ICBEPart1 = Block.box(ICBE[0][0], ICBE[0][1], ICBE[0][2], ICBE[0][3], ICBE[0][4], ICBE[0][5]);
    protected static final VoxelShape ICBEPart2 = Block.box(ICBE[1][0], ICBE[1][1], ICBE[1][2], ICBE[1][3], ICBE[1][4], ICBE[1][5]);
    protected static final VoxelShape ICBEPart3 = Block.box(ICBE[2][0], ICBE[2][1], ICBE[2][2], ICBE[2][3], ICBE[2][4], ICBE[2][5]);
    protected static final VoxelShape ICBEPart4 = Block.box(ICBE[3][0], ICBE[3][1], ICBE[3][2], ICBE[3][3], ICBE[3][4], ICBE[3][5]);
    protected static final VoxelShape ICBEPart5 = Block.box(ICBE[4][0], ICBE[4][1], ICBE[4][2], ICBE[4][3], ICBE[4][4], ICBE[4][5]);
    protected static final VoxelShape ICBEPart6 = Block.box(ICBE[5][0], ICBE[5][1], ICBE[5][2], ICBE[5][3], ICBE[5][4], ICBE[5][5]);
    protected static final VoxelShape ICBEPart7 = Block.box(ICBE[6][0], ICBE[6][1], ICBE[6][2], ICBE[6][3], ICBE[6][4], ICBE[6][5]);
    protected static final VoxelShape ICBEPart8 = Block.box(ICBE[7][0], ICBE[7][1], ICBE[7][2], ICBE[7][3], ICBE[7][4], ICBE[7][5]);
    protected static final VoxelShape ICBEPart9 = Block.box(ICBE[8][0], ICBE[8][1], ICBE[8][2], ICBE[8][3], ICBE[8][4], ICBE[8][5]);
    protected static final VoxelShape ICBEPart10 = Block.box(ICBE[9][0], ICBE[9][1], ICBE[9][2], ICBE[9][3], ICBE[9][4], ICBE[9][5]);
    protected static final VoxelShape ICBEPart11 = Block.box(ICBE[10][0], ICBE[10][1], ICBE[10][2], ICBE[10][3], ICBE[10][4], ICBE[10][5]);
    protected static final VoxelShape ICBEPart12 = Block.box(ICBE[11][0], ICBE[11][1], ICBE[11][2], ICBE[11][3], ICBE[11][4], ICBE[11][5]);
    protected static final VoxelShape ICBEPart13 = Block.box(ICBE[12][0], ICBE[12][1], ICBE[12][2], ICBE[12][3], ICBE[12][4], ICBE[12][5]);
    protected static final VoxelShape ICBEPart14 = Block.box(ICBE[13][0], ICBE[13][1], ICBE[13][2], ICBE[13][3], ICBE[13][4], ICBE[13][5]);
    protected static final VoxelShape ICBEPart15 = Block.box(ICBE[14][0], ICBE[14][1], ICBE[14][2], ICBE[14][3], ICBE[14][4], ICBE[14][5]);
    protected static final VoxelShape ICBEPart16 = Block.box(ICBE[15][0], ICBE[15][1], ICBE[15][2], ICBE[15][3], ICBE[15][4], ICBE[15][5]);
    protected static final VoxelShape ICBEPart17 = Block.box(ICBE[16][0], ICBE[16][1], ICBE[16][2], ICBE[16][3], ICBE[16][4], ICBE[16][5]);
    protected static final VoxelShape ICBEPart18 = Block.box(ICBE[17][0], ICBE[17][1], ICBE[17][2], ICBE[17][3], ICBE[17][4], ICBE[17][5]);
    protected static final VoxelShape ICBEPart19 = Block.box(ICBE[18][0], ICBE[18][1], ICBE[18][2], ICBE[18][3], ICBE[18][4], ICBE[18][5]);
    protected static final VoxelShape ICBEPart20 = Block.box(ICBE[19][0], ICBE[19][1], ICBE[19][2], ICBE[19][3], ICBE[19][4], ICBE[19][5]);
    protected static final VoxelShape ICBEPart21 = Block.box(ICBE[20][0], ICBE[20][1], ICBE[20][2], ICBE[20][3], ICBE[20][4], ICBE[20][5]);
    protected static final VoxelShape ICBEPart22 = Block.box(ICBE[21][0], ICBE[21][1], ICBE[21][2], ICBE[21][3], ICBE[21][4], ICBE[21][5]);
    protected static final VoxelShape ICBEPart23 = Block.box(ICBE[22][0], ICBE[22][1], ICBE[22][2], ICBE[22][3], ICBE[22][4], ICBE[22][5]);
    protected static final VoxelShape ICBEPart24 = Block.box(ICBE[23][0], ICBE[23][1], ICBE[23][2], ICBE[23][3], ICBE[23][4], ICBE[23][5]);
    protected static final VoxelShape ICBEPart25 = Block.box(ICBE[24][0], ICBE[24][1], ICBE[24][2], ICBE[24][3], ICBE[24][4], ICBE[24][5]);
    protected static final VoxelShape ICBEPart26 = Block.box(ICBE[25][0], ICBE[25][1], ICBE[25][2], ICBE[25][3], ICBE[25][4], ICBE[25][5]);
    protected static final VoxelShape ICBEPart27 = Block.box(ICBE[26][0], ICBE[26][1], ICBE[26][2], ICBE[26][3], ICBE[26][4], ICBE[26][5]);
    protected static final VoxelShape ICBEPart28 = Block.box(ICBE[27][0], ICBE[27][1], ICBE[27][2], ICBE[27][3], ICBE[27][4], ICBE[27][5]);
    protected static final VoxelShape ICBEPart29 = Block.box(ICBE[28][0], ICBE[28][1], ICBE[28][2], ICBE[28][3], ICBE[28][4], ICBE[28][5]);
    protected static final VoxelShape ICBEPart30 = Block.box(ICBE[29][0], ICBE[29][1], ICBE[29][2], ICBE[29][3], ICBE[29][4], ICBE[29][5]);
    protected static final VoxelShape ICBEPart31 = Block.box(ICBE[30][0], ICBE[30][1], ICBE[30][2], ICBE[30][3], ICBE[30][4], ICBE[30][5]);
    private static final VoxelShape FULL_ICBE_SHAPE = Shapes.or(ICBEPart1, ICBEPart2, ICBEPart3, ICBEPart4, ICBEPart5, ICBEPart6, ICBEPart7, ICBEPart8, ICBEPart9, ICBEPart10, ICBEPart11, ICBEPart12, ICBEPart13, ICBEPart14, ICBEPart15, ICBEPart16, ICBEPart17, ICBEPart18, ICBEPart19, ICBEPart20, ICBEPart21, ICBEPart22, ICBEPart23, ICBEPart24, ICBEPart25, ICBEPart26, ICBEPart27, ICBEPart28, ICBEPart29, ICBEPart30, ICBEPart31);
    /**
     * Inner corner block
     * ICBW = Inner corner block collision boxes, right side up, facing West
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] ICBW = {{0, 0, 15, 1, 1, 16},
            {0, 0, 14, 2, 2, 15},
            {11, 0, 5, 12, 12, 16},
            {8, 0, 8, 9, 9, 16},
            {9, 0, 7, 10, 10, 16},
            {10, 0, 6, 11, 11, 16},
            {13, 0, 3, 14, 14, 16},
            {12, 0, 4, 13, 13, 16},
            {15, 0, 1, 16, 16, 16},
            {14, 0, 2, 15, 15, 16},
            {3, 0, 13, 4, 4, 16},
            {2, 0, 14, 3, 3, 16},
            {5, 0, 11, 6, 6, 16},
            {4, 0, 12, 5, 5, 16},
            {7, 0, 9, 8, 8, 16},
            {6, 0, 10, 7, 7, 16},
            {1, 0, 15, 2, 2, 16},
            {0, 0, 9, 7, 7, 10},
            {0, 0, 8, 8, 8, 9},
            {0, 0, 11, 5, 5, 12},
            {0, 0, 10, 6, 6, 11},
            {0, 0, 13, 3, 3, 14},
            {0, 0, 12, 4, 4, 13},
            {0, 0, 1, 15, 15, 2},
            {0, 0, 0, 16, 16, 1},
            {0, 0, 3, 13, 13, 4},
            {0, 0, 2, 14, 14, 3},
            {0, 0, 5, 11, 11, 6},
            {0, 0, 6, 10, 10, 7},
            {0, 0, 7, 9, 9, 8},
            {0, 0, 4, 12, 12, 5}};
    protected static final VoxelShape ICBWPart1 = Block.box(ICBW[0][0], ICBW[0][1], ICBW[0][2], ICBW[0][3], ICBW[0][4], ICBW[0][5]);
    protected static final VoxelShape ICBWPart2 = Block.box(ICBW[1][0], ICBW[1][1], ICBW[1][2], ICBW[1][3], ICBW[1][4], ICBW[1][5]);
    protected static final VoxelShape ICBWPart3 = Block.box(ICBW[2][0], ICBW[2][1], ICBW[2][2], ICBW[2][3], ICBW[2][4], ICBW[2][5]);
    protected static final VoxelShape ICBWPart4 = Block.box(ICBW[3][0], ICBW[3][1], ICBW[3][2], ICBW[3][3], ICBW[3][4], ICBW[3][5]);
    protected static final VoxelShape ICBWPart5 = Block.box(ICBW[4][0], ICBW[4][1], ICBW[4][2], ICBW[4][3], ICBW[4][4], ICBW[4][5]);
    protected static final VoxelShape ICBWPart6 = Block.box(ICBW[5][0], ICBW[5][1], ICBW[5][2], ICBW[5][3], ICBW[5][4], ICBW[5][5]);
    protected static final VoxelShape ICBWPart7 = Block.box(ICBW[6][0], ICBW[6][1], ICBW[6][2], ICBW[6][3], ICBW[6][4], ICBW[6][5]);
    protected static final VoxelShape ICBWPart8 = Block.box(ICBW[7][0], ICBW[7][1], ICBW[7][2], ICBW[7][3], ICBW[7][4], ICBW[7][5]);
    protected static final VoxelShape ICBWPart9 = Block.box(ICBW[8][0], ICBW[8][1], ICBW[8][2], ICBW[8][3], ICBW[8][4], ICBW[8][5]);
    protected static final VoxelShape ICBWPart10 = Block.box(ICBW[9][0], ICBW[9][1], ICBW[9][2], ICBW[9][3], ICBW[9][4], ICBW[9][5]);
    protected static final VoxelShape ICBWPart11 = Block.box(ICBW[10][0], ICBW[10][1], ICBW[10][2], ICBW[10][3], ICBW[10][4], ICBW[10][5]);
    protected static final VoxelShape ICBWPart12 = Block.box(ICBW[11][0], ICBW[11][1], ICBW[11][2], ICBW[11][3], ICBW[11][4], ICBW[11][5]);
    protected static final VoxelShape ICBWPart13 = Block.box(ICBW[12][0], ICBW[12][1], ICBW[12][2], ICBW[12][3], ICBW[12][4], ICBW[12][5]);
    protected static final VoxelShape ICBWPart14 = Block.box(ICBW[13][0], ICBW[13][1], ICBW[13][2], ICBW[13][3], ICBW[13][4], ICBW[13][5]);
    protected static final VoxelShape ICBWPart15 = Block.box(ICBW[14][0], ICBW[14][1], ICBW[14][2], ICBW[14][3], ICBW[14][4], ICBW[14][5]);
    protected static final VoxelShape ICBWPart16 = Block.box(ICBW[15][0], ICBW[15][1], ICBW[15][2], ICBW[15][3], ICBW[15][4], ICBW[15][5]);
    protected static final VoxelShape ICBWPart17 = Block.box(ICBW[16][0], ICBW[16][1], ICBW[16][2], ICBW[16][3], ICBW[16][4], ICBW[16][5]);
    protected static final VoxelShape ICBWPart18 = Block.box(ICBW[17][0], ICBW[17][1], ICBW[17][2], ICBW[17][3], ICBW[17][4], ICBW[17][5]);
    protected static final VoxelShape ICBWPart19 = Block.box(ICBW[18][0], ICBW[18][1], ICBW[18][2], ICBW[18][3], ICBW[18][4], ICBW[18][5]);
    protected static final VoxelShape ICBWPart20 = Block.box(ICBW[19][0], ICBW[19][1], ICBW[19][2], ICBW[19][3], ICBW[19][4], ICBW[19][5]);
    protected static final VoxelShape ICBWPart21 = Block.box(ICBW[20][0], ICBW[20][1], ICBW[20][2], ICBW[20][3], ICBW[20][4], ICBW[20][5]);
    protected static final VoxelShape ICBWPart22 = Block.box(ICBW[21][0], ICBW[21][1], ICBW[21][2], ICBW[21][3], ICBW[21][4], ICBW[21][5]);
    protected static final VoxelShape ICBWPart23 = Block.box(ICBW[22][0], ICBW[22][1], ICBW[22][2], ICBW[22][3], ICBW[22][4], ICBW[22][5]);
    protected static final VoxelShape ICBWPart24 = Block.box(ICBW[23][0], ICBW[23][1], ICBW[23][2], ICBW[23][3], ICBW[23][4], ICBW[23][5]);
    protected static final VoxelShape ICBWPart25 = Block.box(ICBW[24][0], ICBW[24][1], ICBW[24][2], ICBW[24][3], ICBW[24][4], ICBW[24][5]);
    protected static final VoxelShape ICBWPart26 = Block.box(ICBW[25][0], ICBW[25][1], ICBW[25][2], ICBW[25][3], ICBW[25][4], ICBW[25][5]);
    protected static final VoxelShape ICBWPart27 = Block.box(ICBW[26][0], ICBW[26][1], ICBW[26][2], ICBW[26][3], ICBW[26][4], ICBW[26][5]);
    protected static final VoxelShape ICBWPart28 = Block.box(ICBW[27][0], ICBW[27][1], ICBW[27][2], ICBW[27][3], ICBW[27][4], ICBW[27][5]);
    protected static final VoxelShape ICBWPart29 = Block.box(ICBW[28][0], ICBW[28][1], ICBW[28][2], ICBW[28][3], ICBW[28][4], ICBW[28][5]);
    protected static final VoxelShape ICBWPart30 = Block.box(ICBW[29][0], ICBW[29][1], ICBW[29][2], ICBW[29][3], ICBW[29][4], ICBW[29][5]);
    protected static final VoxelShape ICBWPart31 = Block.box(ICBW[30][0], ICBW[30][1], ICBW[30][2], ICBW[30][3], ICBW[30][4], ICBW[30][5]);
    private static final VoxelShape FULL_ICBW_SHAPE = Shapes.or(ICBWPart1, ICBWPart2, ICBWPart3, ICBWPart4, ICBWPart5, ICBWPart6, ICBWPart7, ICBWPart8, ICBWPart9, ICBWPart10, ICBWPart11, ICBWPart12, ICBWPart13, ICBWPart14, ICBWPart15, ICBWPart16, ICBWPart17, ICBWPart18, ICBWPart19, ICBWPart20, ICBWPart21, ICBWPart22, ICBWPart23, ICBWPart24, ICBWPart25, ICBWPart26, ICBWPart27, ICBWPart28, ICBWPart29, ICBWPart30, ICBWPart31);
    /**
     * Inner corner block
     * ICTN = Inner corner block collision boxes, upside down, facing North
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] ICTN = {{0, 15, 0, 1, 16, 1},
            {1, 14, 0, 2, 16, 2},
            {0, 4, 11, 11, 16, 12},
            {0, 7, 8, 8, 16, 9},
            {0, 6, 9, 9, 16, 10},
            {0, 5, 10, 10, 16, 11},
            {0, 2, 13, 13, 16, 14},
            {0, 3, 12, 12, 16, 13},
            {0, 0, 15, 15, 16, 16},
            {0, 1, 14, 14, 16, 15},
            {0, 12, 3, 3, 16, 4},
            {0, 13, 2, 2, 16, 3},
            {0, 10, 5, 5, 16, 6},
            {0, 11, 4, 4, 16, 5},
            {0, 8, 7, 7, 16, 8},
            {0, 9, 6, 6, 16, 7},
            {0, 14, 1, 1, 16, 2},
            {6, 9, 0, 7, 16, 7},
            {7, 8, 0, 8, 16, 8},
            {4, 11, 0, 5, 16, 5},
            {5, 10, 0, 6, 16, 6},
            {2, 13, 0, 3, 16, 3},
            {3, 12, 0, 4, 16, 4},
            {14, 1, 0, 15, 16, 15},
            {15, 0, 0, 16, 16, 16},
            {12, 3, 0, 13, 16, 13},
            {13, 2, 0, 14, 16, 14},
            {10, 5, 0, 11, 16, 11},
            {9, 6, 0, 10, 16, 10},
            {8, 7, 0, 9, 16, 9},
            {11, 4, 0, 12, 16, 12}};
    protected static final VoxelShape ICTNPart1 = Block.box(ICTN[0][0], ICTN[0][1], ICTN[0][2], ICTN[0][3], ICTN[0][4], ICTN[0][5]);
    protected static final VoxelShape ICTNPart2 = Block.box(ICTN[1][0], ICTN[1][1], ICTN[1][2], ICTN[1][3], ICTN[1][4], ICTN[1][5]);
    protected static final VoxelShape ICTNPart3 = Block.box(ICTN[2][0], ICTN[2][1], ICTN[2][2], ICTN[2][3], ICTN[2][4], ICTN[2][5]);
    protected static final VoxelShape ICTNPart4 = Block.box(ICTN[3][0], ICTN[3][1], ICTN[3][2], ICTN[3][3], ICTN[3][4], ICTN[3][5]);
    protected static final VoxelShape ICTNPart5 = Block.box(ICTN[4][0], ICTN[4][1], ICTN[4][2], ICTN[4][3], ICTN[4][4], ICTN[4][5]);
    protected static final VoxelShape ICTNPart6 = Block.box(ICTN[5][0], ICTN[5][1], ICTN[5][2], ICTN[5][3], ICTN[5][4], ICTN[5][5]);
    protected static final VoxelShape ICTNPart7 = Block.box(ICTN[6][0], ICTN[6][1], ICTN[6][2], ICTN[6][3], ICTN[6][4], ICTN[6][5]);
    protected static final VoxelShape ICTNPart8 = Block.box(ICTN[7][0], ICTN[7][1], ICTN[7][2], ICTN[7][3], ICTN[7][4], ICTN[7][5]);
    protected static final VoxelShape ICTNPart9 = Block.box(ICTN[8][0], ICTN[8][1], ICTN[8][2], ICTN[8][3], ICTN[8][4], ICTN[8][5]);
    protected static final VoxelShape ICTNPart10 = Block.box(ICTN[9][0], ICTN[9][1], ICTN[9][2], ICTN[9][3], ICTN[9][4], ICTN[9][5]);
    protected static final VoxelShape ICTNPart11 = Block.box(ICTN[10][0], ICTN[10][1], ICTN[10][2], ICTN[10][3], ICTN[10][4], ICTN[10][5]);
    protected static final VoxelShape ICTNPart12 = Block.box(ICTN[11][0], ICTN[11][1], ICTN[11][2], ICTN[11][3], ICTN[11][4], ICTN[11][5]);
    protected static final VoxelShape ICTNPart13 = Block.box(ICTN[12][0], ICTN[12][1], ICTN[12][2], ICTN[12][3], ICTN[12][4], ICTN[12][5]);
    protected static final VoxelShape ICTNPart14 = Block.box(ICTN[13][0], ICTN[13][1], ICTN[13][2], ICTN[13][3], ICTN[13][4], ICTN[13][5]);
    protected static final VoxelShape ICTNPart15 = Block.box(ICTN[14][0], ICTN[14][1], ICTN[14][2], ICTN[14][3], ICTN[14][4], ICTN[14][5]);
    protected static final VoxelShape ICTNPart16 = Block.box(ICTN[15][0], ICTN[15][1], ICTN[15][2], ICTN[15][3], ICTN[15][4], ICTN[15][5]);
    protected static final VoxelShape ICTNPart17 = Block.box(ICTN[16][0], ICTN[16][1], ICTN[16][2], ICTN[16][3], ICTN[16][4], ICTN[16][5]);
    protected static final VoxelShape ICTNPart18 = Block.box(ICTN[17][0], ICTN[17][1], ICTN[17][2], ICTN[17][3], ICTN[17][4], ICTN[17][5]);
    protected static final VoxelShape ICTNPart19 = Block.box(ICTN[18][0], ICTN[18][1], ICTN[18][2], ICTN[18][3], ICTN[18][4], ICTN[18][5]);
    protected static final VoxelShape ICTNPart20 = Block.box(ICTN[19][0], ICTN[19][1], ICTN[19][2], ICTN[19][3], ICTN[19][4], ICTN[19][5]);
    protected static final VoxelShape ICTNPart21 = Block.box(ICTN[20][0], ICTN[20][1], ICTN[20][2], ICTN[20][3], ICTN[20][4], ICTN[20][5]);
    protected static final VoxelShape ICTNPart22 = Block.box(ICTN[21][0], ICTN[21][1], ICTN[21][2], ICTN[21][3], ICTN[21][4], ICTN[21][5]);
    protected static final VoxelShape ICTNPart23 = Block.box(ICTN[22][0], ICTN[22][1], ICTN[22][2], ICTN[22][3], ICTN[22][4], ICTN[22][5]);
    protected static final VoxelShape ICTNPart24 = Block.box(ICTN[23][0], ICTN[23][1], ICTN[23][2], ICTN[23][3], ICTN[23][4], ICTN[23][5]);
    protected static final VoxelShape ICTNPart25 = Block.box(ICTN[24][0], ICTN[24][1], ICTN[24][2], ICTN[24][3], ICTN[24][4], ICTN[24][5]);
    protected static final VoxelShape ICTNPart26 = Block.box(ICTN[25][0], ICTN[25][1], ICTN[25][2], ICTN[25][3], ICTN[25][4], ICTN[25][5]);
    protected static final VoxelShape ICTNPart27 = Block.box(ICTN[26][0], ICTN[26][1], ICTN[26][2], ICTN[26][3], ICTN[26][4], ICTN[26][5]);
    protected static final VoxelShape ICTNPart28 = Block.box(ICTN[27][0], ICTN[27][1], ICTN[27][2], ICTN[27][3], ICTN[27][4], ICTN[27][5]);
    protected static final VoxelShape ICTNPart29 = Block.box(ICTN[28][0], ICTN[28][1], ICTN[28][2], ICTN[28][3], ICTN[28][4], ICTN[28][5]);
    protected static final VoxelShape ICTNPart30 = Block.box(ICTN[29][0], ICTN[29][1], ICTN[29][2], ICTN[29][3], ICTN[29][4], ICTN[29][5]);
    protected static final VoxelShape ICTNPart31 = Block.box(ICTN[30][0], ICTN[30][1], ICTN[30][2], ICTN[30][3], ICTN[30][4], ICTN[30][5]);
    private static final VoxelShape FULL_ICTN_SHAPE = Shapes.or(ICTNPart1, ICTNPart2, ICTNPart3, ICTNPart4, ICTNPart5, ICTNPart6, ICTNPart7, ICTNPart8, ICTNPart9, ICTNPart10, ICTNPart11, ICTNPart12, ICTNPart13, ICTNPart14, ICTNPart15, ICTNPart16, ICTNPart17, ICTNPart18, ICTNPart19, ICTNPart20, ICTNPart21, ICTNPart22, ICTNPart23, ICTNPart24, ICTNPart25, ICTNPart26, ICTNPart27, ICTNPart28, ICTNPart29, ICTNPart30, ICTNPart31);
    /**
     * Inner corner block
     * ICTS = Inner corner block collision boxes, upside down, facing South
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] ICTS = {{15, 15, 15, 16, 16, 16},
            {14, 14, 14, 15, 16, 16},
            {5, 4, 4, 16, 16, 5},
            {8, 7, 7, 16, 16, 8},
            {7, 6, 6, 16, 16, 7},
            {6, 5, 5, 16, 16, 6},
            {3, 2, 2, 16, 16, 3},
            {4, 3, 3, 16, 16, 4},
            {1, 0, 0, 16, 16, 1},
            {2, 1, 1, 16, 16, 2},
            {13, 12, 12, 16, 16, 13},
            {14, 13, 13, 16, 16, 14},
            {11, 10, 10, 16, 16, 11},
            {12, 11, 11, 16, 16, 12},
            {9, 8, 8, 16, 16, 9},
            {10, 9, 9, 16, 16, 10},
            {15, 14, 14, 16, 16, 15},
            {9, 9, 9, 10, 16, 16},
            {8, 8, 8, 9, 16, 16},
            {11, 11, 11, 12, 16, 16},
            {10, 10, 10, 11, 16, 16},
            {13, 13, 13, 14, 16, 16},
            {12, 12, 12, 13, 16, 16},
            {1, 1, 1, 2, 16, 16},
            {0, 0, 0, 1, 16, 16},
            {3, 3, 3, 4, 16, 16},
            {2, 2, 2, 3, 16, 16},
            {5, 5, 5, 6, 16, 16},
            {6, 6, 6, 7, 16, 16},
            {7, 7, 7, 8, 16, 16},
            {4, 4, 4, 5, 16, 16}};
    protected static final VoxelShape ICTSPart1 = Block.box(ICTS[0][0], ICTS[0][1], ICTS[0][2], ICTS[0][3], ICTS[0][4], ICTS[0][5]);
    protected static final VoxelShape ICTSPart2 = Block.box(ICTS[1][0], ICTS[1][1], ICTS[1][2], ICTS[1][3], ICTS[1][4], ICTS[1][5]);
    protected static final VoxelShape ICTSPart3 = Block.box(ICTS[2][0], ICTS[2][1], ICTS[2][2], ICTS[2][3], ICTS[2][4], ICTS[2][5]);
    protected static final VoxelShape ICTSPart4 = Block.box(ICTS[3][0], ICTS[3][1], ICTS[3][2], ICTS[3][3], ICTS[3][4], ICTS[3][5]);
    protected static final VoxelShape ICTSPart5 = Block.box(ICTS[4][0], ICTS[4][1], ICTS[4][2], ICTS[4][3], ICTS[4][4], ICTS[4][5]);
    protected static final VoxelShape ICTSPart6 = Block.box(ICTS[5][0], ICTS[5][1], ICTS[5][2], ICTS[5][3], ICTS[5][4], ICTS[5][5]);
    protected static final VoxelShape ICTSPart7 = Block.box(ICTS[6][0], ICTS[6][1], ICTS[6][2], ICTS[6][3], ICTS[6][4], ICTS[6][5]);
    protected static final VoxelShape ICTSPart8 = Block.box(ICTS[7][0], ICTS[7][1], ICTS[7][2], ICTS[7][3], ICTS[7][4], ICTS[7][5]);
    protected static final VoxelShape ICTSPart9 = Block.box(ICTS[8][0], ICTS[8][1], ICTS[8][2], ICTS[8][3], ICTS[8][4], ICTS[8][5]);
    protected static final VoxelShape ICTSPart10 = Block.box(ICTS[9][0], ICTS[9][1], ICTS[9][2], ICTS[9][3], ICTS[9][4], ICTS[9][5]);
    protected static final VoxelShape ICTSPart11 = Block.box(ICTS[10][0], ICTS[10][1], ICTS[10][2], ICTS[10][3], ICTS[10][4], ICTS[10][5]);
    protected static final VoxelShape ICTSPart12 = Block.box(ICTS[11][0], ICTS[11][1], ICTS[11][2], ICTS[11][3], ICTS[11][4], ICTS[11][5]);
    protected static final VoxelShape ICTSPart13 = Block.box(ICTS[12][0], ICTS[12][1], ICTS[12][2], ICTS[12][3], ICTS[12][4], ICTS[12][5]);
    protected static final VoxelShape ICTSPart14 = Block.box(ICTS[13][0], ICTS[13][1], ICTS[13][2], ICTS[13][3], ICTS[13][4], ICTS[13][5]);
    protected static final VoxelShape ICTSPart15 = Block.box(ICTS[14][0], ICTS[14][1], ICTS[14][2], ICTS[14][3], ICTS[14][4], ICTS[14][5]);
    protected static final VoxelShape ICTSPart16 = Block.box(ICTS[15][0], ICTS[15][1], ICTS[15][2], ICTS[15][3], ICTS[15][4], ICTS[15][5]);
    protected static final VoxelShape ICTSPart17 = Block.box(ICTS[16][0], ICTS[16][1], ICTS[16][2], ICTS[16][3], ICTS[16][4], ICTS[16][5]);
    protected static final VoxelShape ICTSPart18 = Block.box(ICTS[17][0], ICTS[17][1], ICTS[17][2], ICTS[17][3], ICTS[17][4], ICTS[17][5]);
    protected static final VoxelShape ICTSPart19 = Block.box(ICTS[18][0], ICTS[18][1], ICTS[18][2], ICTS[18][3], ICTS[18][4], ICTS[18][5]);
    protected static final VoxelShape ICTSPart20 = Block.box(ICTS[19][0], ICTS[19][1], ICTS[19][2], ICTS[19][3], ICTS[19][4], ICTS[19][5]);
    protected static final VoxelShape ICTSPart21 = Block.box(ICTS[20][0], ICTS[20][1], ICTS[20][2], ICTS[20][3], ICTS[20][4], ICTS[20][5]);
    protected static final VoxelShape ICTSPart22 = Block.box(ICTS[21][0], ICTS[21][1], ICTS[21][2], ICTS[21][3], ICTS[21][4], ICTS[21][5]);
    protected static final VoxelShape ICTSPart23 = Block.box(ICTS[22][0], ICTS[22][1], ICTS[22][2], ICTS[22][3], ICTS[22][4], ICTS[22][5]);
    protected static final VoxelShape ICTSPart24 = Block.box(ICTS[23][0], ICTS[23][1], ICTS[23][2], ICTS[23][3], ICTS[23][4], ICTS[23][5]);
    protected static final VoxelShape ICTSPart25 = Block.box(ICTS[24][0], ICTS[24][1], ICTS[24][2], ICTS[24][3], ICTS[24][4], ICTS[24][5]);
    protected static final VoxelShape ICTSPart26 = Block.box(ICTS[25][0], ICTS[25][1], ICTS[25][2], ICTS[25][3], ICTS[25][4], ICTS[25][5]);
    protected static final VoxelShape ICTSPart27 = Block.box(ICTS[26][0], ICTS[26][1], ICTS[26][2], ICTS[26][3], ICTS[26][4], ICTS[26][5]);
    protected static final VoxelShape ICTSPart28 = Block.box(ICTS[27][0], ICTS[27][1], ICTS[27][2], ICTS[27][3], ICTS[27][4], ICTS[27][5]);
    protected static final VoxelShape ICTSPart29 = Block.box(ICTS[28][0], ICTS[28][1], ICTS[28][2], ICTS[28][3], ICTS[28][4], ICTS[28][5]);
    protected static final VoxelShape ICTSPart30 = Block.box(ICTS[29][0], ICTS[29][1], ICTS[29][2], ICTS[29][3], ICTS[29][4], ICTS[29][5]);
    protected static final VoxelShape ICTSPart31 = Block.box(ICTS[30][0], ICTS[30][1], ICTS[30][2], ICTS[30][3], ICTS[30][4], ICTS[30][5]);
    private static final VoxelShape FULL_ICTS_SHAPE = Shapes.or(ICTSPart1, ICTSPart2, ICTSPart3, ICTSPart4, ICTSPart5, ICTSPart6, ICTSPart7, ICTSPart8, ICTSPart9, ICTSPart10, ICTSPart11, ICTSPart12, ICTSPart13, ICTSPart14, ICTSPart15, ICTSPart16, ICTSPart17, ICTSPart18, ICTSPart19, ICTSPart20, ICTSPart21, ICTSPart22, ICTSPart23, ICTSPart24, ICTSPart25, ICTSPart26, ICTSPart27, ICTSPart28, ICTSPart29, ICTSPart30, ICTSPart31);
    /**
     * Inner corner block
     * ICTE = Inner corner block collision boxes, upside down, facing East
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] ICTE = {{15, 15, 0, 16, 16, 1},
            {14, 14, 1, 16, 16, 2},
            {4, 4, 0, 5, 16, 11},
            {7, 7, 0, 8, 16, 8},
            {6, 6, 0, 7, 16, 9},
            {5, 5, 0, 6, 16, 10},
            {2, 2, 0, 3, 16, 13},
            {3, 3, 0, 4, 16, 12},
            {0, 0, 0, 1, 16, 15},
            {1, 1, 0, 2, 16, 14},
            {12, 12, 0, 13, 16, 3},
            {13, 13, 0, 14, 16, 2},
            {10, 10, 0, 11, 16, 5},
            {11, 11, 0, 12, 16, 4},
            {8, 8, 0, 9, 16, 7},
            {9, 9, 0, 10, 16, 6},
            {14, 14, 0, 15, 16, 1},
            {9, 9, 6, 16, 16, 7},
            {8, 8, 7, 16, 16, 8},
            {11, 11, 4, 16, 16, 5},
            {10, 10, 5, 16, 16, 6},
            {13, 13, 2, 16, 16, 3},
            {12, 12, 3, 16, 16, 4},
            {1, 1, 14, 16, 16, 15},
            {0, 0, 15, 16, 16, 16},
            {3, 3, 12, 16, 16, 13},
            {2, 2, 13, 16, 16, 14},
            {5, 5, 10, 16, 16, 11},
            {6, 6, 9, 16, 16, 10},
            {7, 7, 8, 16, 16, 9},
            {4, 4, 11, 16, 16, 12}};
    protected static final VoxelShape ICTEPart1 = Block.box(ICTE[0][0], ICTE[0][1], ICTE[0][2], ICTE[0][3], ICTE[0][4], ICTE[0][5]);
    protected static final VoxelShape ICTEPart2 = Block.box(ICTE[1][0], ICTE[1][1], ICTE[1][2], ICTE[1][3], ICTE[1][4], ICTE[1][5]);
    protected static final VoxelShape ICTEPart3 = Block.box(ICTE[2][0], ICTE[2][1], ICTE[2][2], ICTE[2][3], ICTE[2][4], ICTE[2][5]);
    protected static final VoxelShape ICTEPart4 = Block.box(ICTE[3][0], ICTE[3][1], ICTE[3][2], ICTE[3][3], ICTE[3][4], ICTE[3][5]);
    protected static final VoxelShape ICTEPart5 = Block.box(ICTE[4][0], ICTE[4][1], ICTE[4][2], ICTE[4][3], ICTE[4][4], ICTE[4][5]);
    protected static final VoxelShape ICTEPart6 = Block.box(ICTE[5][0], ICTE[5][1], ICTE[5][2], ICTE[5][3], ICTE[5][4], ICTE[5][5]);
    protected static final VoxelShape ICTEPart7 = Block.box(ICTE[6][0], ICTE[6][1], ICTE[6][2], ICTE[6][3], ICTE[6][4], ICTE[6][5]);
    protected static final VoxelShape ICTEPart8 = Block.box(ICTE[7][0], ICTE[7][1], ICTE[7][2], ICTE[7][3], ICTE[7][4], ICTE[7][5]);
    protected static final VoxelShape ICTEPart9 = Block.box(ICTE[8][0], ICTE[8][1], ICTE[8][2], ICTE[8][3], ICTE[8][4], ICTE[8][5]);
    protected static final VoxelShape ICTEPart10 = Block.box(ICTE[9][0], ICTE[9][1], ICTE[9][2], ICTE[9][3], ICTE[9][4], ICTE[9][5]);
    protected static final VoxelShape ICTEPart11 = Block.box(ICTE[10][0], ICTE[10][1], ICTE[10][2], ICTE[10][3], ICTE[10][4], ICTE[10][5]);
    protected static final VoxelShape ICTEPart12 = Block.box(ICTE[11][0], ICTE[11][1], ICTE[11][2], ICTE[11][3], ICTE[11][4], ICTE[11][5]);
    protected static final VoxelShape ICTEPart13 = Block.box(ICTE[12][0], ICTE[12][1], ICTE[12][2], ICTE[12][3], ICTE[12][4], ICTE[12][5]);
    protected static final VoxelShape ICTEPart14 = Block.box(ICTE[13][0], ICTE[13][1], ICTE[13][2], ICTE[13][3], ICTE[13][4], ICTE[13][5]);
    protected static final VoxelShape ICTEPart15 = Block.box(ICTE[14][0], ICTE[14][1], ICTE[14][2], ICTE[14][3], ICTE[14][4], ICTE[14][5]);
    protected static final VoxelShape ICTEPart16 = Block.box(ICTE[15][0], ICTE[15][1], ICTE[15][2], ICTE[15][3], ICTE[15][4], ICTE[15][5]);
    protected static final VoxelShape ICTEPart17 = Block.box(ICTE[16][0], ICTE[16][1], ICTE[16][2], ICTE[16][3], ICTE[16][4], ICTE[16][5]);
    protected static final VoxelShape ICTEPart18 = Block.box(ICTE[17][0], ICTE[17][1], ICTE[17][2], ICTE[17][3], ICTE[17][4], ICTE[17][5]);
    protected static final VoxelShape ICTEPart19 = Block.box(ICTE[18][0], ICTE[18][1], ICTE[18][2], ICTE[18][3], ICTE[18][4], ICTE[18][5]);
    protected static final VoxelShape ICTEPart20 = Block.box(ICTE[19][0], ICTE[19][1], ICTE[19][2], ICTE[19][3], ICTE[19][4], ICTE[19][5]);
    protected static final VoxelShape ICTEPart21 = Block.box(ICTE[20][0], ICTE[20][1], ICTE[20][2], ICTE[20][3], ICTE[20][4], ICTE[20][5]);
    protected static final VoxelShape ICTEPart22 = Block.box(ICTE[21][0], ICTE[21][1], ICTE[21][2], ICTE[21][3], ICTE[21][4], ICTE[21][5]);
    protected static final VoxelShape ICTEPart23 = Block.box(ICTE[22][0], ICTE[22][1], ICTE[22][2], ICTE[22][3], ICTE[22][4], ICTE[22][5]);
    protected static final VoxelShape ICTEPart24 = Block.box(ICTE[23][0], ICTE[23][1], ICTE[23][2], ICTE[23][3], ICTE[23][4], ICTE[23][5]);
    protected static final VoxelShape ICTEPart25 = Block.box(ICTE[24][0], ICTE[24][1], ICTE[24][2], ICTE[24][3], ICTE[24][4], ICTE[24][5]);
    protected static final VoxelShape ICTEPart26 = Block.box(ICTE[25][0], ICTE[25][1], ICTE[25][2], ICTE[25][3], ICTE[25][4], ICTE[25][5]);
    protected static final VoxelShape ICTEPart27 = Block.box(ICTE[26][0], ICTE[26][1], ICTE[26][2], ICTE[26][3], ICTE[26][4], ICTE[26][5]);
    protected static final VoxelShape ICTEPart28 = Block.box(ICTE[27][0], ICTE[27][1], ICTE[27][2], ICTE[27][3], ICTE[27][4], ICTE[27][5]);
    protected static final VoxelShape ICTEPart29 = Block.box(ICTE[28][0], ICTE[28][1], ICTE[28][2], ICTE[28][3], ICTE[28][4], ICTE[28][5]);
    protected static final VoxelShape ICTEPart30 = Block.box(ICTE[29][0], ICTE[29][1], ICTE[29][2], ICTE[29][3], ICTE[29][4], ICTE[29][5]);
    protected static final VoxelShape ICTEPart31 = Block.box(ICTE[30][0], ICTE[30][1], ICTE[30][2], ICTE[30][3], ICTE[30][4], ICTE[30][5]);
    private static final VoxelShape FULL_ICTE_SHAPE = Shapes.or(ICTEPart1, ICTEPart2, ICTEPart3, ICTEPart4, ICTEPart5, ICTEPart6, ICTEPart7, ICTEPart8, ICTEPart9, ICTEPart10, ICTEPart11, ICTEPart12, ICTEPart13, ICTEPart14, ICTEPart15, ICTEPart16, ICTEPart17, ICTEPart18, ICTEPart19, ICTEPart20, ICTEPart21, ICTEPart22, ICTEPart23, ICTEPart24, ICTEPart25, ICTEPart26, ICTEPart27, ICTEPart28, ICTEPart29, ICTEPart30, ICTEPart31);
    /**
     * Inner corner block
     * ICTW = Inner corner block collision boxes, upside down, facing West
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] ICTW = {{0, 15, 15, 1, 16, 16},
            {1, 14, 14, 2, 16, 16},
            {0, 4, 4, 11, 16, 5},
            {0, 7, 7, 8, 16, 8},
            {0, 6, 6, 9, 16, 7},
            {0, 5, 5, 10, 16, 6},
            {0, 2, 2, 13, 16, 3},
            {0, 3, 3, 12, 16, 4},
            {0, 0, 0, 15, 16, 1},
            {0, 1, 1, 14, 16, 2},
            {0, 12, 12, 3, 16, 13},
            {0, 13, 13, 2, 16, 14},
            {0, 10, 10, 5, 16, 11},
            {0, 11, 11, 4, 16, 12},
            {0, 8, 8, 7, 16, 9},
            {0, 9, 9, 6, 16, 10},
            {0, 14, 14, 1, 16, 15},
            {6, 9, 9, 7, 16, 16},
            {7, 8, 8, 8, 16, 16},
            {4, 11, 11, 5, 16, 16},
            {5, 10, 10, 6, 16, 16},
            {2, 13, 13, 3, 16, 16},
            {3, 12, 12, 4, 16, 16},
            {14, 1, 1, 15, 16, 16},
            {15, 0, 0, 16, 16, 16},
            {12, 3, 3, 13, 16, 16},
            {13, 2, 2, 14, 16, 16},
            {10, 5, 5, 11, 16, 16},
            {9, 6, 6, 10, 16, 16},
            {8, 7, 7, 9, 16, 16},
            {11, 4, 4, 12, 16, 16}};
    protected static final VoxelShape ICTWPart1 = Block.box(ICTW[0][0], ICTW[0][1], ICTW[0][2], ICTW[0][3], ICTW[0][4], ICTW[0][5]);
    protected static final VoxelShape ICTWPart2 = Block.box(ICTW[1][0], ICTW[1][1], ICTW[1][2], ICTW[1][3], ICTW[1][4], ICTW[1][5]);
    protected static final VoxelShape ICTWPart3 = Block.box(ICTW[2][0], ICTW[2][1], ICTW[2][2], ICTW[2][3], ICTW[2][4], ICTW[2][5]);
    protected static final VoxelShape ICTWPart4 = Block.box(ICTW[3][0], ICTW[3][1], ICTW[3][2], ICTW[3][3], ICTW[3][4], ICTW[3][5]);
    protected static final VoxelShape ICTWPart5 = Block.box(ICTW[4][0], ICTW[4][1], ICTW[4][2], ICTW[4][3], ICTW[4][4], ICTW[4][5]);
    protected static final VoxelShape ICTWPart6 = Block.box(ICTW[5][0], ICTW[5][1], ICTW[5][2], ICTW[5][3], ICTW[5][4], ICTW[5][5]);
    protected static final VoxelShape ICTWPart7 = Block.box(ICTW[6][0], ICTW[6][1], ICTW[6][2], ICTW[6][3], ICTW[6][4], ICTW[6][5]);
    protected static final VoxelShape ICTWPart8 = Block.box(ICTW[7][0], ICTW[7][1], ICTW[7][2], ICTW[7][3], ICTW[7][4], ICTW[7][5]);
    protected static final VoxelShape ICTWPart9 = Block.box(ICTW[8][0], ICTW[8][1], ICTW[8][2], ICTW[8][3], ICTW[8][4], ICTW[8][5]);
    protected static final VoxelShape ICTWPart10 = Block.box(ICTW[9][0], ICTW[9][1], ICTW[9][2], ICTW[9][3], ICTW[9][4], ICTW[9][5]);
    protected static final VoxelShape ICTWPart11 = Block.box(ICTW[10][0], ICTW[10][1], ICTW[10][2], ICTW[10][3], ICTW[10][4], ICTW[10][5]);
    protected static final VoxelShape ICTWPart12 = Block.box(ICTW[11][0], ICTW[11][1], ICTW[11][2], ICTW[11][3], ICTW[11][4], ICTW[11][5]);
    protected static final VoxelShape ICTWPart13 = Block.box(ICTW[12][0], ICTW[12][1], ICTW[12][2], ICTW[12][3], ICTW[12][4], ICTW[12][5]);
    protected static final VoxelShape ICTWPart14 = Block.box(ICTW[13][0], ICTW[13][1], ICTW[13][2], ICTW[13][3], ICTW[13][4], ICTW[13][5]);
    protected static final VoxelShape ICTWPart15 = Block.box(ICTW[14][0], ICTW[14][1], ICTW[14][2], ICTW[14][3], ICTW[14][4], ICTW[14][5]);
    protected static final VoxelShape ICTWPart16 = Block.box(ICTW[15][0], ICTW[15][1], ICTW[15][2], ICTW[15][3], ICTW[15][4], ICTW[15][5]);
    protected static final VoxelShape ICTWPart17 = Block.box(ICTW[16][0], ICTW[16][1], ICTW[16][2], ICTW[16][3], ICTW[16][4], ICTW[16][5]);
    protected static final VoxelShape ICTWPart18 = Block.box(ICTW[17][0], ICTW[17][1], ICTW[17][2], ICTW[17][3], ICTW[17][4], ICTW[17][5]);
    protected static final VoxelShape ICTWPart19 = Block.box(ICTW[18][0], ICTW[18][1], ICTW[18][2], ICTW[18][3], ICTW[18][4], ICTW[18][5]);
    protected static final VoxelShape ICTWPart20 = Block.box(ICTW[19][0], ICTW[19][1], ICTW[19][2], ICTW[19][3], ICTW[19][4], ICTW[19][5]);
    protected static final VoxelShape ICTWPart21 = Block.box(ICTW[20][0], ICTW[20][1], ICTW[20][2], ICTW[20][3], ICTW[20][4], ICTW[20][5]);
    protected static final VoxelShape ICTWPart22 = Block.box(ICTW[21][0], ICTW[21][1], ICTW[21][2], ICTW[21][3], ICTW[21][4], ICTW[21][5]);
    protected static final VoxelShape ICTWPart23 = Block.box(ICTW[22][0], ICTW[22][1], ICTW[22][2], ICTW[22][3], ICTW[22][4], ICTW[22][5]);
    protected static final VoxelShape ICTWPart24 = Block.box(ICTW[23][0], ICTW[23][1], ICTW[23][2], ICTW[23][3], ICTW[23][4], ICTW[23][5]);
    protected static final VoxelShape ICTWPart25 = Block.box(ICTW[24][0], ICTW[24][1], ICTW[24][2], ICTW[24][3], ICTW[24][4], ICTW[24][5]);
    protected static final VoxelShape ICTWPart26 = Block.box(ICTW[25][0], ICTW[25][1], ICTW[25][2], ICTW[25][3], ICTW[25][4], ICTW[25][5]);
    protected static final VoxelShape ICTWPart27 = Block.box(ICTW[26][0], ICTW[26][1], ICTW[26][2], ICTW[26][3], ICTW[26][4], ICTW[26][5]);
    protected static final VoxelShape ICTWPart28 = Block.box(ICTW[27][0], ICTW[27][1], ICTW[27][2], ICTW[27][3], ICTW[27][4], ICTW[27][5]);
    protected static final VoxelShape ICTWPart29 = Block.box(ICTW[28][0], ICTW[28][1], ICTW[28][2], ICTW[28][3], ICTW[28][4], ICTW[28][5]);
    protected static final VoxelShape ICTWPart30 = Block.box(ICTW[29][0], ICTW[29][1], ICTW[29][2], ICTW[29][3], ICTW[29][4], ICTW[29][5]);
    protected static final VoxelShape ICTWPart31 = Block.box(ICTW[30][0], ICTW[30][1], ICTW[30][2], ICTW[30][3], ICTW[30][4], ICTW[30][5]);
    private static final VoxelShape FULL_ICTW_SHAPE = Shapes.or(ICTWPart1, ICTWPart2, ICTWPart3, ICTWPart4, ICTWPart5, ICTWPart6, ICTWPart7, ICTWPart8, ICTWPart9, ICTWPart10, ICTWPart11, ICTWPart12, ICTWPart13, ICTWPart14, ICTWPart15, ICTWPart16, ICTWPart17, ICTWPart18, ICTWPart19, ICTWPart20, ICTWPart21, ICTWPart22, ICTWPart23, ICTWPart24, ICTWPart25, ICTWPart26, ICTWPart27, ICTWPart28, ICTWPart29, ICTWPart30, ICTWPart31);
    /**
     * Outer corner block
     * OCBN = Outer corner block collision boxes, right side up, facing North
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] OCBN = {{0, 0, 0, 16, 1, 16},
            {0, 3, 0, 1, 16, 1},
            {0, 2, 0, 2, 15, 2},
            {0, 1, 0, 3, 14, 3},
            {0, 0, 0, 4, 13, 4},
            {0, 3, 0, 5, 12, 5},
            {0, 2, 0, 6, 11, 6},
            {0, 1, 0, 7, 10, 7},
            {0, 0, 0, 8, 9, 8},
            {0, 3, 0, 9, 8, 9},
            {0, 2, 0, 10, 7, 10},
            {0, 1, 0, 11, 6, 11},
            {0, 0, 0, 12, 5, 12},
            {0, 3, 0, 13, 4, 13},
            {0, 2, 0, 14, 3, 14},
            {0, 1, 0, 15, 2, 15}};
    protected static final VoxelShape OCBNPart1 = Block.box(OCBN[0][0], OCBN[0][1], OCBN[0][2], OCBN[0][3], OCBN[0][4], OCBN[0][5]);
    protected static final VoxelShape OCBNPart2 = Block.box(OCBN[1][0], OCBN[1][1], OCBN[1][2], OCBN[1][3], OCBN[1][4], OCBN[1][5]);
    protected static final VoxelShape OCBNPart3 = Block.box(OCBN[2][0], OCBN[2][1], OCBN[2][2], OCBN[2][3], OCBN[2][4], OCBN[2][5]);
    protected static final VoxelShape OCBNPart4 = Block.box(OCBN[3][0], OCBN[3][1], OCBN[3][2], OCBN[3][3], OCBN[3][4], OCBN[3][5]);
    protected static final VoxelShape OCBNPart5 = Block.box(OCBN[4][0], OCBN[4][1], OCBN[4][2], OCBN[4][3], OCBN[4][4], OCBN[4][5]);
    protected static final VoxelShape OCBNPart6 = Block.box(OCBN[5][0], OCBN[5][1], OCBN[5][2], OCBN[5][3], OCBN[5][4], OCBN[5][5]);
    protected static final VoxelShape OCBNPart7 = Block.box(OCBN[6][0], OCBN[6][1], OCBN[6][2], OCBN[6][3], OCBN[6][4], OCBN[6][5]);
    protected static final VoxelShape OCBNPart8 = Block.box(OCBN[7][0], OCBN[7][1], OCBN[7][2], OCBN[7][3], OCBN[7][4], OCBN[7][5]);
    protected static final VoxelShape OCBNPart9 = Block.box(OCBN[8][0], OCBN[8][1], OCBN[8][2], OCBN[8][3], OCBN[8][4], OCBN[8][5]);
    protected static final VoxelShape OCBNPart10 = Block.box(OCBN[9][0], OCBN[9][1], OCBN[9][2], OCBN[9][3], OCBN[9][4], OCBN[9][5]);
    protected static final VoxelShape OCBNPart11 = Block.box(OCBN[10][0], OCBN[10][1], OCBN[10][2], OCBN[10][3], OCBN[10][4], OCBN[10][5]);
    protected static final VoxelShape OCBNPart12 = Block.box(OCBN[11][0], OCBN[11][1], OCBN[11][2], OCBN[11][3], OCBN[11][4], OCBN[11][5]);
    protected static final VoxelShape OCBNPart13 = Block.box(OCBN[12][0], OCBN[12][1], OCBN[12][2], OCBN[12][3], OCBN[12][4], OCBN[12][5]);
    protected static final VoxelShape OCBNPart14 = Block.box(OCBN[13][0], OCBN[13][1], OCBN[13][2], OCBN[13][3], OCBN[13][4], OCBN[13][5]);
    protected static final VoxelShape OCBNPart15 = Block.box(OCBN[14][0], OCBN[14][1], OCBN[14][2], OCBN[14][3], OCBN[14][4], OCBN[14][5]);
    protected static final VoxelShape OCBNPart16 = Block.box(OCBN[15][0], OCBN[15][1], OCBN[15][2], OCBN[15][3], OCBN[15][4], OCBN[15][5]);
    private static final VoxelShape FULL_OCBN_SHAPE = Shapes.or(OCBNPart1, OCBNPart2, OCBNPart3, OCBNPart4, OCBNPart5, OCBNPart6, OCBNPart7, OCBNPart8, OCBNPart9, OCBNPart10, OCBNPart11, OCBNPart12, OCBNPart13, OCBNPart14, OCBNPart15, OCBNPart16);
    /**
     * Outer corner block
     * OCBS = Outer corner block collision boxes, right side up, facing South
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] OCBS = {{0, 0, 0, 16, 1, 16},
            {15, 3, 0, 16, 16, 1},
            {14, 2, 0, 16, 15, 2},
            {13, 1, 0, 16, 14, 3},
            {12, 0, 0, 16, 13, 4},
            {11, 3, 0, 16, 12, 5},
            {10, 2, 0, 16, 11, 6},
            {9, 1, 0, 16, 10, 7},
            {8, 0, 0, 16, 9, 8},
            {7, 3, 0, 16, 8, 9},
            {6, 2, 0, 16, 7, 10},
            {5, 1, 0, 16, 6, 11},
            {4, 0, 0, 16, 5, 12},
            {3, 3, 0, 16, 4, 13},
            {2, 2, 0, 16, 3, 14},
            {1, 1, 0, 16, 2, 15}};
    protected static final VoxelShape OCBSPart1 = Block.box(OCBS[0][0], OCBS[0][1], OCBS[0][2], OCBS[0][3], OCBS[0][4], OCBS[0][5]);
    protected static final VoxelShape OCBSPart2 = Block.box(OCBS[1][0], OCBS[1][1], OCBS[1][2], OCBS[1][3], OCBS[1][4], OCBS[1][5]);
    protected static final VoxelShape OCBSPart3 = Block.box(OCBS[2][0], OCBS[2][1], OCBS[2][2], OCBS[2][3], OCBS[2][4], OCBS[2][5]);
    protected static final VoxelShape OCBSPart4 = Block.box(OCBS[3][0], OCBS[3][1], OCBS[3][2], OCBS[3][3], OCBS[3][4], OCBS[3][5]);
    protected static final VoxelShape OCBSPart5 = Block.box(OCBS[4][0], OCBS[4][1], OCBS[4][2], OCBS[4][3], OCBS[4][4], OCBS[4][5]);
    protected static final VoxelShape OCBSPart6 = Block.box(OCBS[5][0], OCBS[5][1], OCBS[5][2], OCBS[5][3], OCBS[5][4], OCBS[5][5]);
    protected static final VoxelShape OCBSPart7 = Block.box(OCBS[6][0], OCBS[6][1], OCBS[6][2], OCBS[6][3], OCBS[6][4], OCBS[6][5]);
    protected static final VoxelShape OCBSPart8 = Block.box(OCBS[7][0], OCBS[7][1], OCBS[7][2], OCBS[7][3], OCBS[7][4], OCBS[7][5]);
    protected static final VoxelShape OCBSPart9 = Block.box(OCBS[8][0], OCBS[8][1], OCBS[8][2], OCBS[8][3], OCBS[8][4], OCBS[8][5]);
    protected static final VoxelShape OCBSPart10 = Block.box(OCBS[9][0], OCBS[9][1], OCBS[9][2], OCBS[9][3], OCBS[9][4], OCBS[9][5]);
    protected static final VoxelShape OCBSPart11 = Block.box(OCBS[10][0], OCBS[10][1], OCBS[10][2], OCBS[10][3], OCBS[10][4], OCBS[10][5]);
    protected static final VoxelShape OCBSPart12 = Block.box(OCBS[11][0], OCBS[11][1], OCBS[11][2], OCBS[11][3], OCBS[11][4], OCBS[11][5]);
    protected static final VoxelShape OCBSPart13 = Block.box(OCBS[12][0], OCBS[12][1], OCBS[12][2], OCBS[12][3], OCBS[12][4], OCBS[12][5]);
    protected static final VoxelShape OCBSPart14 = Block.box(OCBS[13][0], OCBS[13][1], OCBS[13][2], OCBS[13][3], OCBS[13][4], OCBS[13][5]);
    protected static final VoxelShape OCBSPart15 = Block.box(OCBS[14][0], OCBS[14][1], OCBS[14][2], OCBS[14][3], OCBS[14][4], OCBS[14][5]);
    protected static final VoxelShape OCBSPart16 = Block.box(OCBS[15][0], OCBS[15][1], OCBS[15][2], OCBS[15][3], OCBS[15][4], OCBS[15][5]);
    private static final VoxelShape FULL_OCBS_SHAPE = Shapes.or(OCBSPart1, OCBSPart2, OCBSPart3, OCBSPart4, OCBSPart5, OCBSPart6, OCBSPart7, OCBSPart8, OCBSPart9, OCBSPart10, OCBSPart11, OCBSPart12, OCBSPart13, OCBSPart14, OCBSPart15, OCBSPart16);
    /**
     * Outer corner block
     * OCBE = Outer corner block collision boxes, right side up, facing East
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] OCBE = {{0, 0, 0, 16, 1, 16},
            {0, 3, 15, 1, 16, 16},
            {0, 2, 14, 2, 15, 16},
            {0, 1, 13, 3, 14, 16},
            {0, 0, 12, 4, 13, 16},
            {0, 3, 11, 5, 12, 16},
            {0, 2, 10, 6, 11, 16},
            {0, 1, 9, 7, 10, 16},
            {0, 0, 8, 8, 9, 16},
            {0, 3, 7, 9, 8, 16},
            {0, 2, 6, 10, 7, 16},
            {0, 1, 5, 11, 6, 16},
            {0, 0, 4, 12, 5, 16},
            {0, 3, 3, 13, 4, 16},
            {0, 2, 2, 14, 3, 16},
            {0, 1, 1, 15, 2, 16}};
    protected static final VoxelShape OCBEPart1 = Block.box(OCBE[0][0], OCBE[0][1], OCBE[0][2], OCBE[0][3], OCBE[0][4], OCBE[0][5]);
    protected static final VoxelShape OCBEPart2 = Block.box(OCBE[1][0], OCBE[1][1], OCBE[1][2], OCBE[1][3], OCBE[1][4], OCBE[1][5]);
    protected static final VoxelShape OCBEPart3 = Block.box(OCBE[2][0], OCBE[2][1], OCBE[2][2], OCBE[2][3], OCBE[2][4], OCBE[2][5]);
    protected static final VoxelShape OCBEPart4 = Block.box(OCBE[3][0], OCBE[3][1], OCBE[3][2], OCBE[3][3], OCBE[3][4], OCBE[3][5]);
    protected static final VoxelShape OCBEPart5 = Block.box(OCBE[4][0], OCBE[4][1], OCBE[4][2], OCBE[4][3], OCBE[4][4], OCBE[4][5]);
    protected static final VoxelShape OCBEPart6 = Block.box(OCBE[5][0], OCBE[5][1], OCBE[5][2], OCBE[5][3], OCBE[5][4], OCBE[5][5]);
    protected static final VoxelShape OCBEPart7 = Block.box(OCBE[6][0], OCBE[6][1], OCBE[6][2], OCBE[6][3], OCBE[6][4], OCBE[6][5]);
    protected static final VoxelShape OCBEPart8 = Block.box(OCBE[7][0], OCBE[7][1], OCBE[7][2], OCBE[7][3], OCBE[7][4], OCBE[7][5]);
    protected static final VoxelShape OCBEPart9 = Block.box(OCBE[8][0], OCBE[8][1], OCBE[8][2], OCBE[8][3], OCBE[8][4], OCBE[8][5]);
    protected static final VoxelShape OCBEPart10 = Block.box(OCBE[9][0], OCBE[9][1], OCBE[9][2], OCBE[9][3], OCBE[9][4], OCBE[9][5]);
    protected static final VoxelShape OCBEPart11 = Block.box(OCBE[10][0], OCBE[10][1], OCBE[10][2], OCBE[10][3], OCBE[10][4], OCBE[10][5]);
    protected static final VoxelShape OCBEPart12 = Block.box(OCBE[11][0], OCBE[11][1], OCBE[11][2], OCBE[11][3], OCBE[11][4], OCBE[11][5]);
    protected static final VoxelShape OCBEPart13 = Block.box(OCBE[12][0], OCBE[12][1], OCBE[12][2], OCBE[12][3], OCBE[12][4], OCBE[12][5]);
    protected static final VoxelShape OCBEPart14 = Block.box(OCBE[13][0], OCBE[13][1], OCBE[13][2], OCBE[13][3], OCBE[13][4], OCBE[13][5]);
    protected static final VoxelShape OCBEPart15 = Block.box(OCBE[14][0], OCBE[14][1], OCBE[14][2], OCBE[14][3], OCBE[14][4], OCBE[14][5]);
    protected static final VoxelShape OCBEPart16 = Block.box(OCBE[15][0], OCBE[15][1], OCBE[15][2], OCBE[15][3], OCBE[15][4], OCBE[15][5]);
    private static final VoxelShape FULL_OCBE_SHAPE = Shapes.or(OCBEPart1, OCBEPart2, OCBEPart3, OCBEPart4, OCBEPart5, OCBEPart6, OCBEPart7, OCBEPart8, OCBEPart9, OCBEPart10, OCBEPart11, OCBEPart12, OCBEPart13, OCBEPart14, OCBEPart15, OCBEPart16);
    /**
     * Outer corner block
     * OCBW = Outer corner block collision boxes, right side up, facing West
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] OCBW = {{0, 0, 0, 16, 1, 16},
            {15, 3, 15, 16, 16, 16},
            {14, 2, 14, 16, 15, 16},
            {13, 1, 13, 16, 14, 16},
            {12, 0, 12, 16, 13, 16},
            {11, 3, 11, 16, 12, 16},
            {10, 2, 10, 16, 11, 16},
            {9, 1, 9, 16, 10, 16},
            {8, 0, 8, 16, 9, 16},
            {7, 3, 7, 16, 8, 16},
            {6, 2, 6, 16, 7, 16},
            {5, 1, 5, 16, 6, 16},
            {4, 0, 4, 16, 5, 16},
            {3, 3, 3, 16, 4, 16},
            {2, 2, 2, 16, 3, 16},
            {1, 1, 1, 16, 2, 16}};
    protected static final VoxelShape OCBWPart1 = Block.box(OCBW[0][0], OCBW[0][1], OCBW[0][2], OCBW[0][3], OCBW[0][4], OCBW[0][5]);
    protected static final VoxelShape OCBWPart2 = Block.box(OCBW[1][0], OCBW[1][1], OCBW[1][2], OCBW[1][3], OCBW[1][4], OCBW[1][5]);
    protected static final VoxelShape OCBWPart3 = Block.box(OCBW[2][0], OCBW[2][1], OCBW[2][2], OCBW[2][3], OCBW[2][4], OCBW[2][5]);
    protected static final VoxelShape OCBWPart4 = Block.box(OCBW[3][0], OCBW[3][1], OCBW[3][2], OCBW[3][3], OCBW[3][4], OCBW[3][5]);
    protected static final VoxelShape OCBWPart5 = Block.box(OCBW[4][0], OCBW[4][1], OCBW[4][2], OCBW[4][3], OCBW[4][4], OCBW[4][5]);
    protected static final VoxelShape OCBWPart6 = Block.box(OCBW[5][0], OCBW[5][1], OCBW[5][2], OCBW[5][3], OCBW[5][4], OCBW[5][5]);
    protected static final VoxelShape OCBWPart7 = Block.box(OCBW[6][0], OCBW[6][1], OCBW[6][2], OCBW[6][3], OCBW[6][4], OCBW[6][5]);
    protected static final VoxelShape OCBWPart8 = Block.box(OCBW[7][0], OCBW[7][1], OCBW[7][2], OCBW[7][3], OCBW[7][4], OCBW[7][5]);
    protected static final VoxelShape OCBWPart9 = Block.box(OCBW[8][0], OCBW[8][1], OCBW[8][2], OCBW[8][3], OCBW[8][4], OCBW[8][5]);
    protected static final VoxelShape OCBWPart10 = Block.box(OCBW[9][0], OCBW[9][1], OCBW[9][2], OCBW[9][3], OCBW[9][4], OCBW[9][5]);
    protected static final VoxelShape OCBWPart11 = Block.box(OCBW[10][0], OCBW[10][1], OCBW[10][2], OCBW[10][3], OCBW[10][4], OCBW[10][5]);
    protected static final VoxelShape OCBWPart12 = Block.box(OCBW[11][0], OCBW[11][1], OCBW[11][2], OCBW[11][3], OCBW[11][4], OCBW[11][5]);
    protected static final VoxelShape OCBWPart13 = Block.box(OCBW[12][0], OCBW[12][1], OCBW[12][2], OCBW[12][3], OCBW[12][4], OCBW[12][5]);
    protected static final VoxelShape OCBWPart14 = Block.box(OCBW[13][0], OCBW[13][1], OCBW[13][2], OCBW[13][3], OCBW[13][4], OCBW[13][5]);
    protected static final VoxelShape OCBWPart15 = Block.box(OCBW[14][0], OCBW[14][1], OCBW[14][2], OCBW[14][3], OCBW[14][4], OCBW[14][5]);
    protected static final VoxelShape OCBWPart16 = Block.box(OCBW[15][0], OCBW[15][1], OCBW[15][2], OCBW[15][3], OCBW[15][4], OCBW[15][5]);
    private static final VoxelShape FULL_OCBW_SHAPE = Shapes.or(OCBWPart1, OCBWPart2, OCBWPart3, OCBWPart4, OCBWPart5, OCBWPart6, OCBWPart7, OCBWPart8, OCBWPart9, OCBWPart10, OCBWPart11, OCBWPart12, OCBWPart13, OCBWPart14, OCBWPart15, OCBWPart16);
    /**
     * Outer corner block
     * OCTN = Outer corner block collision boxes, upside down, facing North
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] OCTN = {{0, 15, 0, 16, 16, 16},
            {0, 0, 0, 1, 13, 1},
            {0, 1, 0, 2, 14, 2},
            {0, 2, 0, 3, 15, 3},
            {0, 3, 0, 4, 16, 4},
            {0, 4, 0, 5, 13, 5},
            {0, 5, 0, 6, 14, 6},
            {0, 6, 0, 7, 15, 7},
            {0, 7, 0, 8, 16, 8},
            {0, 8, 0, 9, 13, 9},
            {0, 9, 0, 10, 14, 10},
            {0, 10, 0, 11, 15, 11},
            {0, 11, 0, 12, 16, 12},
            {0, 12, 0, 13, 13, 13},
            {0, 13, 0, 14, 14, 14},
            {0, 14, 0, 15, 15, 15}};
    protected static final VoxelShape OCTNPart1 = Block.box(OCTN[0][0], OCTN[0][1], OCTN[0][2], OCTN[0][3], OCTN[0][4], OCTN[0][5]);
    protected static final VoxelShape OCTNPart2 = Block.box(OCTN[1][0], OCTN[1][1], OCTN[1][2], OCTN[1][3], OCTN[1][4], OCTN[1][5]);
    protected static final VoxelShape OCTNPart3 = Block.box(OCTN[2][0], OCTN[2][1], OCTN[2][2], OCTN[2][3], OCTN[2][4], OCTN[2][5]);
    protected static final VoxelShape OCTNPart4 = Block.box(OCTN[3][0], OCTN[3][1], OCTN[3][2], OCTN[3][3], OCTN[3][4], OCTN[3][5]);
    protected static final VoxelShape OCTNPart5 = Block.box(OCTN[4][0], OCTN[4][1], OCTN[4][2], OCTN[4][3], OCTN[4][4], OCTN[4][5]);
    protected static final VoxelShape OCTNPart6 = Block.box(OCTN[5][0], OCTN[5][1], OCTN[5][2], OCTN[5][3], OCTN[5][4], OCTN[5][5]);
    protected static final VoxelShape OCTNPart7 = Block.box(OCTN[6][0], OCTN[6][1], OCTN[6][2], OCTN[6][3], OCTN[6][4], OCTN[6][5]);
    protected static final VoxelShape OCTNPart8 = Block.box(OCTN[7][0], OCTN[7][1], OCTN[7][2], OCTN[7][3], OCTN[7][4], OCTN[7][5]);
    protected static final VoxelShape OCTNPart9 = Block.box(OCTN[8][0], OCTN[8][1], OCTN[8][2], OCTN[8][3], OCTN[8][4], OCTN[8][5]);
    protected static final VoxelShape OCTNPart10 = Block.box(OCTN[9][0], OCTN[9][1], OCTN[9][2], OCTN[9][3], OCTN[9][4], OCTN[9][5]);
    protected static final VoxelShape OCTNPart11 = Block.box(OCTN[10][0], OCTN[10][1], OCTN[10][2], OCTN[10][3], OCTN[10][4], OCTN[10][5]);
    protected static final VoxelShape OCTNPart12 = Block.box(OCTN[11][0], OCTN[11][1], OCTN[11][2], OCTN[11][3], OCTN[11][4], OCTN[11][5]);
    protected static final VoxelShape OCTNPart13 = Block.box(OCTN[12][0], OCTN[12][1], OCTN[12][2], OCTN[12][3], OCTN[12][4], OCTN[12][5]);
    protected static final VoxelShape OCTNPart14 = Block.box(OCTN[13][0], OCTN[13][1], OCTN[13][2], OCTN[13][3], OCTN[13][4], OCTN[13][5]);
    protected static final VoxelShape OCTNPart15 = Block.box(OCTN[14][0], OCTN[14][1], OCTN[14][2], OCTN[14][3], OCTN[14][4], OCTN[14][5]);
    protected static final VoxelShape OCTNPart16 = Block.box(OCTN[15][0], OCTN[15][1], OCTN[15][2], OCTN[15][3], OCTN[15][4], OCTN[15][5]);
    private static final VoxelShape FULL_OCTN_SHAPE = Shapes.or(OCTNPart1, OCTNPart2, OCTNPart3, OCTNPart4, OCTNPart5, OCTNPart6, OCTNPart7, OCTNPart8, OCTNPart9, OCTNPart10, OCTNPart11, OCTNPart12, OCTNPart13, OCTNPart14, OCTNPart15, OCTNPart16);
    /**
     * Outer corner block
     * OCTS = Outer corner block collision boxes, upside down, facing South
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] OCTS = {{0, 15, 0, 16, 16, 16},
            {15, 0, 0, 16, 13, 1},
            {14, 1, 0, 16, 14, 2},
            {13, 2, 0, 16, 15, 3},
            {12, 3, 0, 16, 16, 4},
            {11, 4, 0, 16, 13, 5},
            {10, 5, 0, 16, 14, 6},
            {9, 6, 0, 16, 15, 7},
            {8, 7, 0, 16, 16, 8},
            {7, 8, 0, 16, 13, 9},
            {6, 9, 0, 16, 14, 10},
            {5, 10, 0, 16, 15, 11},
            {4, 11, 0, 16, 16, 12},
            {3, 12, 0, 16, 13, 13},
            {2, 13, 0, 16, 14, 14},
            {1, 14, 0, 16, 15, 15}};
    protected static final VoxelShape OCTSPart1 = Block.box(OCTS[0][0], OCTS[0][1], OCTS[0][2], OCTS[0][3], OCTS[0][4], OCTS[0][5]);
    protected static final VoxelShape OCTSPart2 = Block.box(OCTS[1][0], OCTS[1][1], OCTS[1][2], OCTS[1][3], OCTS[1][4], OCTS[1][5]);
    protected static final VoxelShape OCTSPart3 = Block.box(OCTS[2][0], OCTS[2][1], OCTS[2][2], OCTS[2][3], OCTS[2][4], OCTS[2][5]);
    protected static final VoxelShape OCTSPart4 = Block.box(OCTS[3][0], OCTS[3][1], OCTS[3][2], OCTS[3][3], OCTS[3][4], OCTS[3][5]);
    protected static final VoxelShape OCTSPart5 = Block.box(OCTS[4][0], OCTS[4][1], OCTS[4][2], OCTS[4][3], OCTS[4][4], OCTS[4][5]);
    protected static final VoxelShape OCTSPart6 = Block.box(OCTS[5][0], OCTS[5][1], OCTS[5][2], OCTS[5][3], OCTS[5][4], OCTS[5][5]);
    protected static final VoxelShape OCTSPart7 = Block.box(OCTS[6][0], OCTS[6][1], OCTS[6][2], OCTS[6][3], OCTS[6][4], OCTS[6][5]);
    protected static final VoxelShape OCTSPart8 = Block.box(OCTS[7][0], OCTS[7][1], OCTS[7][2], OCTS[7][3], OCTS[7][4], OCTS[7][5]);
    protected static final VoxelShape OCTSPart9 = Block.box(OCTS[8][0], OCTS[8][1], OCTS[8][2], OCTS[8][3], OCTS[8][4], OCTS[8][5]);
    protected static final VoxelShape OCTSPart10 = Block.box(OCTS[9][0], OCTS[9][1], OCTS[9][2], OCTS[9][3], OCTS[9][4], OCTS[9][5]);
    protected static final VoxelShape OCTSPart11 = Block.box(OCTS[10][0], OCTS[10][1], OCTS[10][2], OCTS[10][3], OCTS[10][4], OCTS[10][5]);
    protected static final VoxelShape OCTSPart12 = Block.box(OCTS[11][0], OCTS[11][1], OCTS[11][2], OCTS[11][3], OCTS[11][4], OCTS[11][5]);
    protected static final VoxelShape OCTSPart13 = Block.box(OCTS[12][0], OCTS[12][1], OCTS[12][2], OCTS[12][3], OCTS[12][4], OCTS[12][5]);
    protected static final VoxelShape OCTSPart14 = Block.box(OCTS[13][0], OCTS[13][1], OCTS[13][2], OCTS[13][3], OCTS[13][4], OCTS[13][5]);
    protected static final VoxelShape OCTSPart15 = Block.box(OCTS[14][0], OCTS[14][1], OCTS[14][2], OCTS[14][3], OCTS[14][4], OCTS[14][5]);
    protected static final VoxelShape OCTSPart16 = Block.box(OCTS[15][0], OCTS[15][1], OCTS[15][2], OCTS[15][3], OCTS[15][4], OCTS[15][5]);
    private static final VoxelShape FULL_OCTS_SHAPE = Shapes.or(OCTSPart1, OCTSPart2, OCTSPart3, OCTSPart4, OCTSPart5, OCTSPart6, OCTSPart7, OCTSPart8, OCTSPart9, OCTSPart10, OCTSPart11, OCTSPart12, OCTSPart13, OCTSPart14, OCTSPart15, OCTSPart16);
    /**
     * Outer corner block
     * OCTE = Outer corner block collision boxes, upside down, facing East
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] OCTE = {{0, 15, 0, 16, 16, 16},
            {0, 0, 15, 1, 13, 16},
            {0, 1, 14, 2, 14, 16},
            {0, 2, 13, 3, 15, 16},
            {0, 3, 12, 4, 16, 16},
            {0, 4, 11, 5, 13, 16},
            {0, 5, 10, 6, 14, 16},
            {0, 6, 9, 7, 15, 16},
            {0, 7, 8, 8, 16, 16},
            {0, 8, 7, 9, 13, 16},
            {0, 9, 6, 10, 14, 16},
            {0, 10, 5, 11, 15, 16},
            {0, 11, 4, 12, 16, 16},
            {0, 12, 3, 13, 13, 16},
            {0, 13, 2, 14, 14, 16},
            {0, 14, 1, 15, 15, 16}};
    protected static final VoxelShape OCTEPart1 = Block.box(OCTE[0][0], OCTE[0][1], OCTE[0][2], OCTE[0][3], OCTE[0][4], OCTE[0][5]);
    protected static final VoxelShape OCTEPart2 = Block.box(OCTE[1][0], OCTE[1][1], OCTE[1][2], OCTE[1][3], OCTE[1][4], OCTE[1][5]);
    protected static final VoxelShape OCTEPart3 = Block.box(OCTE[2][0], OCTE[2][1], OCTE[2][2], OCTE[2][3], OCTE[2][4], OCTE[2][5]);
    protected static final VoxelShape OCTEPart4 = Block.box(OCTE[3][0], OCTE[3][1], OCTE[3][2], OCTE[3][3], OCTE[3][4], OCTE[3][5]);
    protected static final VoxelShape OCTEPart5 = Block.box(OCTE[4][0], OCTE[4][1], OCTE[4][2], OCTE[4][3], OCTE[4][4], OCTE[4][5]);
    protected static final VoxelShape OCTEPart6 = Block.box(OCTE[5][0], OCTE[5][1], OCTE[5][2], OCTE[5][3], OCTE[5][4], OCTE[5][5]);
    protected static final VoxelShape OCTEPart7 = Block.box(OCTE[6][0], OCTE[6][1], OCTE[6][2], OCTE[6][3], OCTE[6][4], OCTE[6][5]);
    protected static final VoxelShape OCTEPart8 = Block.box(OCTE[7][0], OCTE[7][1], OCTE[7][2], OCTE[7][3], OCTE[7][4], OCTE[7][5]);
    protected static final VoxelShape OCTEPart9 = Block.box(OCTE[8][0], OCTE[8][1], OCTE[8][2], OCTE[8][3], OCTE[8][4], OCTE[8][5]);
    protected static final VoxelShape OCTEPart10 = Block.box(OCTE[9][0], OCTE[9][1], OCTE[9][2], OCTE[9][3], OCTE[9][4], OCTE[9][5]);
    protected static final VoxelShape OCTEPart11 = Block.box(OCTE[10][0], OCTE[10][1], OCTE[10][2], OCTE[10][3], OCTE[10][4], OCTE[10][5]);
    protected static final VoxelShape OCTEPart12 = Block.box(OCTE[11][0], OCTE[11][1], OCTE[11][2], OCTE[11][3], OCTE[11][4], OCTE[11][5]);
    protected static final VoxelShape OCTEPart13 = Block.box(OCTE[12][0], OCTE[12][1], OCTE[12][2], OCTE[12][3], OCTE[12][4], OCTE[12][5]);
    protected static final VoxelShape OCTEPart14 = Block.box(OCTE[13][0], OCTE[13][1], OCTE[13][2], OCTE[13][3], OCTE[13][4], OCTE[13][5]);
    protected static final VoxelShape OCTEPart15 = Block.box(OCTE[14][0], OCTE[14][1], OCTE[14][2], OCTE[14][3], OCTE[14][4], OCTE[14][5]);
    protected static final VoxelShape OCTEPart16 = Block.box(OCTE[15][0], OCTE[15][1], OCTE[15][2], OCTE[15][3], OCTE[15][4], OCTE[15][5]);
    private static final VoxelShape FULL_OCTE_SHAPE = Shapes.or(OCTEPart1, OCTEPart2, OCTEPart3, OCTEPart4, OCTEPart5, OCTEPart6, OCTEPart7, OCTEPart8, OCTEPart9, OCTEPart10, OCTEPart11, OCTEPart12, OCTEPart13, OCTEPart14, OCTEPart15, OCTEPart16);
    /**
     * Outer corner block
     * OCTW = Outer corner block collision boxes, upside down, facing West
     * x1 y1 z1 x2 y2 z2
     */
    protected static final double[][] OCTW = {{0, 15, 0, 16, 16, 16},
            {15, 0, 15, 16, 13, 16},
            {14, 1, 14, 16, 14, 16},
            {13, 2, 13, 16, 15, 16},
            {12, 3, 12, 16, 16, 16},
            {11, 4, 11, 16, 13, 16},
            {10, 5, 10, 16, 14, 16},
            {9, 6, 9, 16, 15, 16},
            {8, 7, 8, 16, 16, 16},
            {7, 8, 7, 16, 13, 16},
            {6, 9, 6, 16, 14, 16},
            {5, 10, 5, 16, 15, 16},
            {4, 11, 4, 16, 16, 16},
            {3, 12, 3, 16, 13, 16},
            {2, 13, 2, 16, 14, 16},
            {1, 14, 1, 16, 15, 16}};
    protected static final VoxelShape OCTWPart1 = Block.box(OCTW[0][0], OCTW[0][1], OCTW[0][2], OCTW[0][3], OCTW[0][4], OCTW[0][5]);
    protected static final VoxelShape OCTWPart2 = Block.box(OCTW[1][0], OCTW[1][1], OCTW[1][2], OCTW[1][3], OCTW[1][4], OCTW[1][5]);
    protected static final VoxelShape OCTWPart3 = Block.box(OCTW[2][0], OCTW[2][1], OCTW[2][2], OCTW[2][3], OCTW[2][4], OCTW[2][5]);
    protected static final VoxelShape OCTWPart4 = Block.box(OCTW[3][0], OCTW[3][1], OCTW[3][2], OCTW[3][3], OCTW[3][4], OCTW[3][5]);
    protected static final VoxelShape OCTWPart5 = Block.box(OCTW[4][0], OCTW[4][1], OCTW[4][2], OCTW[4][3], OCTW[4][4], OCTW[4][5]);
    protected static final VoxelShape OCTWPart6 = Block.box(OCTW[5][0], OCTW[5][1], OCTW[5][2], OCTW[5][3], OCTW[5][4], OCTW[5][5]);
    protected static final VoxelShape OCTWPart7 = Block.box(OCTW[6][0], OCTW[6][1], OCTW[6][2], OCTW[6][3], OCTW[6][4], OCTW[6][5]);
    protected static final VoxelShape OCTWPart8 = Block.box(OCTW[7][0], OCTW[7][1], OCTW[7][2], OCTW[7][3], OCTW[7][4], OCTW[7][5]);
    protected static final VoxelShape OCTWPart9 = Block.box(OCTW[8][0], OCTW[8][1], OCTW[8][2], OCTW[8][3], OCTW[8][4], OCTW[8][5]);
    protected static final VoxelShape OCTWPart10 = Block.box(OCTW[9][0], OCTW[9][1], OCTW[9][2], OCTW[9][3], OCTW[9][4], OCTW[9][5]);
    protected static final VoxelShape OCTWPart11 = Block.box(OCTW[10][0], OCTW[10][1], OCTW[10][2], OCTW[10][3], OCTW[10][4], OCTW[10][5]);
    protected static final VoxelShape OCTWPart12 = Block.box(OCTW[11][0], OCTW[11][1], OCTW[11][2], OCTW[11][3], OCTW[11][4], OCTW[11][5]);
    protected static final VoxelShape OCTWPart13 = Block.box(OCTW[12][0], OCTW[12][1], OCTW[12][2], OCTW[12][3], OCTW[12][4], OCTW[12][5]);
    protected static final VoxelShape OCTWPart14 = Block.box(OCTW[13][0], OCTW[13][1], OCTW[13][2], OCTW[13][3], OCTW[13][4], OCTW[13][5]);
    protected static final VoxelShape OCTWPart15 = Block.box(OCTW[14][0], OCTW[14][1], OCTW[14][2], OCTW[14][3], OCTW[14][4], OCTW[14][5]);
    protected static final VoxelShape OCTWPart16 = Block.box(OCTW[15][0], OCTW[15][1], OCTW[15][2], OCTW[15][3], OCTW[15][4], OCTW[15][5]);
    private static final VoxelShape FULL_OCTW_SHAPE = Shapes.or(OCTWPart1, OCTWPart2, OCTWPart3, OCTWPart4, OCTWPart5, OCTWPart6, OCTWPart7, OCTWPart8, OCTWPart9, OCTWPart10, OCTWPart11, OCTWPart12, OCTWPart13, OCTWPart14, OCTWPart15, OCTWPart16);
    private final Block modelBlock;
    private final BlockState modelState;

    public RampBlock(Block baseBlock, BlockState state) {
        super(Block.Properties.copy(baseBlock));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, Half.BOTTOM).setValue(SHAPE, StairsShape.STRAIGHT).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(CONNECTED_LEFT, Boolean.valueOf(false)).setValue(CONNECTED_RIGHT, Boolean.valueOf(false)));
        this.modelBlock = state.getBlock();
        this.modelState = state;
    }

    private static Boolean getRightConnection(BlockState state, LevelAccessor worldIn, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockState blockstateright = worldIn.getBlockState(pos.relative(direction.getClockWise()));
        return isBlockStairs(state, blockstateright) != SameBlock.FALSE &&
                isBlockStairs(state, blockstateright) != SameBlock.TRUE &&
                blockstateright.getValue(SHAPE) == StairsShape.STRAIGHT &&
                blockstateright.getValue(FACING) == direction.getClockWise();
    }

    private static Boolean getLeftConnection(BlockState state, LevelAccessor worldIn, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockState blockstateleft = worldIn.getBlockState(pos.relative(direction.getCounterClockWise()));
        return isBlockStairs(state, blockstateleft) != SameBlock.FALSE &&
                isBlockStairs(state, blockstateleft) != SameBlock.TRUE &&
                blockstateleft.getValue(SHAPE) == StairsShape.STRAIGHT &&
                blockstateleft.getValue(FACING) == direction.getCounterClockWise();
    }

    private static StairsShape getShapeProperty(BlockState state, LevelAccessor worldIn, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockState blockstate = worldIn.getBlockState(pos.relative(direction));
        if (isBlockStairs(state, blockstate).equals(SameBlock.TRUE) && state.getValue(HALF) == blockstate.getValue(HALF)) {
            Direction direction1 = blockstate.getValue(FACING);
            if (direction1.getAxis() != state.getValue(FACING).getAxis() && isDifferentStairs(state, worldIn, pos, direction1.getOpposite())) {
                if (direction1 == direction.getCounterClockWise()) {
                    return StairsShape.OUTER_LEFT;
                }

                return StairsShape.OUTER_RIGHT;
            }
        }

        BlockState blockstate1 = worldIn.getBlockState(pos.relative(direction.getOpposite()));
        if (isBlockStairs(state, blockstate1).equals(SameBlock.TRUE) && state.getValue(HALF) == blockstate1.getValue(HALF)) {
            Direction direction2 = blockstate1.getValue(FACING);
            if (direction2.getAxis() != state.getValue(FACING).getAxis() && isDifferentStairs(state, worldIn, pos, direction2)) {
                if (direction2 == direction.getCounterClockWise()) {
                    return StairsShape.INNER_LEFT;
                }

                return StairsShape.INNER_RIGHT;
            }
        }

        return StairsShape.STRAIGHT;
    }

    private static boolean isDifferentStairs(BlockState state, BlockGetter worldIn, BlockPos pos, Direction face) {
        BlockState blockstate = worldIn.getBlockState(pos.relative(face));
        return isBlockStairs(state, blockstate).equals(SameBlock.FALSE) || blockstate.getValue(FACING) != state.getValue(FACING) || blockstate.getValue(HALF) != state.getValue(HALF);
    }

    public static Enum<SameBlock> isBlockStairs(BlockState thisState, BlockState state) {
        if (state.getBlock().equals(thisState.getBlock())) {
            return SameBlock.TRUE;
        } else if (state.getBlock() instanceof RampBlock) {
            return SameBlock.OTHER;
        } else {
            return SameBlock.FALSE;
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        if (state.getValue(SHAPE) == StairsShape.STRAIGHT) {
            if (state.getValue(HALF) == Half.TOP) {
                if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_SCTN_SHAPE;
                } else if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_SCTE_SHAPE;
                } else if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_SCTS_SHAPE;
                } else if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_SCTW_SHAPE;
                }
            } else if (state.getValue(HALF) == Half.BOTTOM) {
                if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_SCBN_SHAPE;
                } else if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_SCBE_SHAPE;
                } else if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_SCBS_SHAPE;
                } else if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_SCBW_SHAPE;
                }
            }
        } else if (state.getValue(SHAPE) == StairsShape.INNER_LEFT) {
            if (state.getValue(HALF) == Half.TOP) {
                if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_ICTN_SHAPE;
                } else if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_ICTE_SHAPE;
                } else if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_ICTS_SHAPE;
                } else if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_ICTW_SHAPE;
                }
            } else if (state.getValue(HALF) == Half.BOTTOM) {
                if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_ICBN_SHAPE;
                } else if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_ICBE_SHAPE;
                } else if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_ICBS_SHAPE;
                } else if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_ICBW_SHAPE;
                }
            }
        } else if (state.getValue(SHAPE) == StairsShape.INNER_RIGHT) {
            if (state.getValue(HALF) == Half.TOP) {
                if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_ICTN_SHAPE;
                } else if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_ICTE_SHAPE;
                } else if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_ICTS_SHAPE;
                } else if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_ICTW_SHAPE;
                }
            } else if (state.getValue(HALF) == Half.BOTTOM) {
                if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_ICBN_SHAPE;
                } else if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_ICBE_SHAPE;
                } else if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_ICBS_SHAPE;
                } else if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_ICBW_SHAPE;
                }
            }
        } else if (state.getValue(SHAPE) == StairsShape.OUTER_LEFT) {
            if (state.getValue(HALF) == Half.TOP) {
                if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_OCTN_SHAPE;
                } else if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_OCTE_SHAPE;
                } else if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_OCTS_SHAPE;
                } else if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_OCTW_SHAPE;
                }
            } else if (state.getValue(HALF) == Half.BOTTOM) {
                if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_OCBN_SHAPE;
                } else if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_OCBE_SHAPE;
                } else if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_OCBS_SHAPE;
                } else if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_OCBW_SHAPE;
                }
            }
        } else if (state.getValue(SHAPE) == StairsShape.OUTER_RIGHT) {
            if (state.getValue(HALF) == Half.TOP) {
                if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_OCTN_SHAPE;
                } else if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_OCTE_SHAPE;
                } else if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_OCTS_SHAPE;
                } else if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_OCTW_SHAPE;
                }
            } else if (state.getValue(HALF) == Half.BOTTOM) {
                if (state.getValue(FACING) == Direction.WEST) {
                    return FULL_OCBN_SHAPE;
                } else if (state.getValue(FACING) == Direction.SOUTH) {
                    return FULL_OCBE_SHAPE;
                } else if (state.getValue(FACING) == Direction.NORTH) {
                    return FULL_OCBS_SHAPE;
                } else if (state.getValue(FACING) == Direction.EAST) {
                    return FULL_OCBW_SHAPE;
                }
            }
        }
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
        this.modelBlock.animateTick(stateIn, worldIn, pos, rand);
    }

    public void attack(BlockState state, Level worldIn, BlockPos pos, Player player) {
        this.modelState.attack(worldIn, pos, player);
    }

    public void destroy(LevelAccessor worldIn, BlockPos pos, BlockState state) {
        this.modelBlock.destroy(worldIn, pos, state);
    }

    @SuppressWarnings("deprecation")
    public float getExplosionResistance() {
        return this.modelBlock.getExplosionResistance();
    }

    @SuppressWarnings("deprecation")
    public void onPlace(BlockState state, Level worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (state.getBlock() != state.getBlock()) {
            this.modelState.neighborChanged(worldIn, pos, Blocks.AIR, pos, false);
            this.modelBlock.onPlace(this.modelState, worldIn, pos, oldState, false);
        }
    }

    public void onRemove(BlockState state, Level worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            this.modelState.onRemove(worldIn, pos, newState, isMoving);
        }
    }

    public void stepOn(Level worldIn, BlockPos pos, BlockState state, Entity entityIn) {
        this.modelBlock.stepOn(worldIn, pos, state, entityIn);
    }

    @SuppressWarnings("deprecation")
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
        this.modelBlock.tick(state, worldIn, pos, random);
    }

    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        return this.modelState.use(worldIn, player, handIn, hit);
    }

    public void wasExploded(Level worldIn, BlockPos pos, Explosion explosionIn) {
        this.modelBlock.wasExploded(worldIn, pos, explosionIn);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockPos blockpos = context.getClickedPos();
        FluidState ifluidstate = context.getLevel().getFluidState(blockpos);
        LevelAccessor worldIn = context.getLevel();
        BlockState blockstate = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(HALF, direction != Direction.DOWN && (direction == Direction.UP || !(context.getClickLocation().y - (double) blockpos.getY() > 0.5D)) ? Half.BOTTOM : Half.TOP).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));

        return blockstate.setValue(CONNECTED_RIGHT, getRightConnection(blockstate, worldIn, blockpos)).setValue(CONNECTED_LEFT, getLeftConnection(blockstate, worldIn, blockpos)).setValue(SHAPE, getShapeProperty(blockstate, context.getLevel(), blockpos));
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }

        return facing.getAxis().isHorizontal() ? stateIn.setValue(CONNECTED_RIGHT, getRightConnection(stateIn, worldIn, currentPos)).setValue(CONNECTED_LEFT, getLeftConnection(stateIn, worldIn, currentPos)).setValue(SHAPE, getShapeProperty(stateIn, worldIn, currentPos)) : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @SuppressWarnings({"deprecation", "incomplete-switch"})
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        Direction direction = state.getValue(FACING);
        StairsShape stairsshape = state.getValue(SHAPE);
        switch (mirrorIn) {
            case LEFT_RIGHT:
                if (direction.getAxis() == Direction.Axis.Z) {
                    switch (stairsshape) {
                        case INNER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        case INNER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        case OUTER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        default:
                            return state.rotate(Rotation.CLOCKWISE_180);
                    }
                }
                break;
            case FRONT_BACK:
                if (direction.getAxis() == Direction.Axis.X) {
                    switch (stairsshape) {
                        case INNER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
                        case INNER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
                        case OUTER_LEFT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
                        case OUTER_RIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
                        case STRAIGHT:
                            return state.rotate(Rotation.CLOCKWISE_180);
                    }
                }
        }

        return super.mirror(state, mirrorIn);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF, SHAPE, WATERLOGGED, CONNECTED_LEFT, CONNECTED_RIGHT);
    }

    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        return false;
    }

    public enum SameBlock {
        TRUE,
        OTHER,
        FALSE
    }
}
