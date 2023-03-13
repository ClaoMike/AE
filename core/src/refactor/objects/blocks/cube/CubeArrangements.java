package refactor.objects.blocks.cube;

import refactor.objects.blocks.BlockTypes;

public class CubeArrangements {

    public static class Connection {
        public static final BlockTypes[][] rightArrangement = new BlockTypes[][]{
                {BlockTypes.DIRT_SNOW_UP, BlockTypes.DIRT_SNOW_UP, BlockTypes.DIRT_SNOW_UP, BlockTypes.DIRT_SNOW_CORNER_TOP_RIGHT},
                {BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE},
                {BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE},
                {BlockTypes.DIRT_SNOW_DOWN, BlockTypes.DIRT_SNOW_DOWN, BlockTypes.DIRT_SNOW_DOWN, BlockTypes.DIRT_SNOW_CORNER_BOTTOM_RIGHT},
        };
        public static final BlockTypes[][] leftArrangement = new BlockTypes[][]{
                {BlockTypes.DIRT_SNOW_CORNER_TOP_LEFT, BlockTypes.DIRT_SNOW_UP, BlockTypes.DIRT_SNOW_UP, BlockTypes.DIRT_SNOW_UP},
                {BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE},
                {BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE},
                {BlockTypes.DIRT_SNOW_CORNER_BOTTOM_LEFT, BlockTypes.DIRT_SNOW_DOWN, BlockTypes.DIRT_SNOW_DOWN, BlockTypes.DIRT_SNOW_DOWN},
        };
    }

    public static class Platform {
        public static final BlockTypes[][] road = new BlockTypes[][]{
                {BlockTypes.DIRT_SNOW_UP, BlockTypes.DIRT_SNOW_UP, BlockTypes.DIRT_SNOW_UP, BlockTypes.DIRT_SNOW_UP},
                {BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE},
                {BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE},
                {BlockTypes.DIRT_SNOW_DOWN, BlockTypes.DIRT_SNOW_DOWN, BlockTypes.DIRT_SNOW_DOWN, BlockTypes.DIRT_SNOW_DOWN},
        };
        public static final BlockTypes[][] borderUp = new BlockTypes[][]{
                {BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE},
                {BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE},
                {BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE},
                {BlockTypes.SNOW_BODY, BlockTypes.SNOW_BODY, BlockTypes.SNOW_BODY, BlockTypes.SNOW_BODY},
        };
        public static final BlockTypes[][] borderDown = new BlockTypes[][]{
                {BlockTypes.SNOW_BODY, BlockTypes.SNOW_BODY, BlockTypes.SNOW_BODY, BlockTypes.SNOW_BODY},
                {BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE},
                {BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE},
                {BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE, BlockTypes.SNOW_SPRITE},
        };
    }

    public static class Maze {
        public static final BlockTypes[][] corners = new BlockTypes[][]{
                {BlockTypes.SNOW_BODY, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.SNOW_BODY},
                {BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE},
                {BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE, BlockTypes.DIRT_SPRITE},
                {BlockTypes.SNOW_BODY, BlockTypes.DIRT_SPRITE,BlockTypes.DIRT_SPRITE, BlockTypes.SNOW_BODY},
        };
    }

    public static BlockTypes[][] getFreshCopyOf(BlockTypes[][] a){
        BlockTypes[][] copy = new BlockTypes[a.length][a[0].length];

        for(int i=0; i<a.length;i++) {
            System.arraycopy(a[i], 0, copy[i], 0, a[i].length);
        }

        return copy;
    }

    public static void printToConsole(BlockTypes[][] arrangement) {
        System.out.println();

        for (BlockTypes[] blockTypes : arrangement) {
            for (BlockTypes blockType : blockTypes) {
                System.out.print(blockType + " ");
            }
            System.out.println();
        }
    }


}