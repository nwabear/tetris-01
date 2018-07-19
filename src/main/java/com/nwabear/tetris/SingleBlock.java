package com.nwabear.tetris;

public class SingleBlock {
    private int col;
    private int row;
    private boolean isMove = true;
    private Window w = new Window();
    public TetrisGrid grid;

    public SingleBlock(int col, int row) {
        this.col = col;
        this.row = row;
        this.grid = TetrisGridFactory.getTetrisGrid();
        this.grid.placeItem( col, row, GridItem.TETRIS_BLOCK );
    }

    public int getCol() { return col; }

    public int getRow() {
        return row;
    }

    public void setCol( int newCol ) { this.col = newCol; }

    public void setRow( int newRow ) { this.row = newRow; }

    public void clearBoard() {
        AppContext ac = new AppContext();
        for(int i = 0; i < ac.COL_COUNT; i++) {
            for(int j = 0; j < ac.ROW_COUNT; j++) {
                if(this.grid.itemAt(i, j) != null) {
                    this.grid.removeItemAt(i, j);
                }
            }
        }
    }

    public void moveDown() {
        if(isMove = true) {
            this.row++;
            this.grid.removeItemAt(col, row - 1);
            this.grid.placeItem(col, row, GridItem.TETRIS_BLOCK);
        }
    }

    public void moveRight() {
        if(isMove = true) {
            this.col++;
            this.grid.removeItemAt(col - 1, row);
            this.grid.placeItem(col, row, GridItem.TETRIS_BLOCK);
        }
    }

    public void moveLeft() {
        if(isMove = true) {
            this.col--;
            this.grid.removeItemAt(col + 1, row);
            this.grid.placeItem(col, row, GridItem.TETRIS_BLOCK);
        }
    }

    public void place() {
        this.grid.placeItem(col, row, GridItem.TETRIS_BLOCK);
        isMove = false;
    }
}
