package com.nwabear.tetris;

public class TetrisGrid {
    private GridItem[][] gridItems;

    public TetrisGrid(int cols, int rows ) { this.gridItems = new GridItem[cols][rows]; }

    public boolean placeItem( int col, int row, GridItem item ) {
        if( this.itemAt( col, row ) == null ) {
            this.gridItems[col][row] = item;

            return true;
        }
        return false;
    }

    public int getNumCols() {
        return this.gridItems.length;
    }

    public int getNumRows() {
        if( this.gridItems.length > 0 ) {
            return this.gridItems[0].length;
        } else {
            return 0;
        }
    }

    public GridItem itemAt(int col, int row ) {
        return this.gridItems[col][row];
    }

    public GridItem removeItemAt(int col, int row ) {
        GridItem removedItem = this.itemAt( col, row );
        if( removedItem != null ) {
            this.gridItems[col][row] = null;
        }
        return removedItem;
    }
}
