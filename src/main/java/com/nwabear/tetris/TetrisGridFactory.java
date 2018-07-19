package com.nwabear.tetris;

public class TetrisGridFactory {
    private static TetrisGrid tetrisGrid = null;

    public static TetrisGrid getTetrisGrid() {
        if( tetrisGrid == null ) {
            tetrisGrid = new TetrisGrid( AppContext.COL_COUNT, AppContext.ROW_COUNT );
        }

        return tetrisGrid;
    }
}
