package com.nwabear.tetris;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JPanel implements TickListener {
    private TBlock block;
    private TetrisGrid grid;
    private BlockState direction = BlockState.NONE;
    private List<TBlock> tBlocks = new ArrayList<>();
    private static int wait = AppContext.TICK_FREQUENCY;

    public Window() {
        GameClockManager.addTickListener( this );
    }

    public void initWindow( TBlock block ) {
        this.block = block;
        this.grid = TetrisGridFactory.getTetrisGrid();
        tBlocks.add(block);
    }

    public void setDirection(BlockState direction) {
        this.direction = direction;
    }

    @Override
    protected void paintComponent( Graphics graphics ) {
        super.paintComponent( graphics );

        Graphics2D g2d = (Graphics2D)graphics;
        g2d.setColor(Color.BLACK);

        for( int i = 0; i < this.grid.getNumCols(); i++ ) {
            for( int j = 0; j < this.grid.getNumRows(); j++ ) {
                GridItem itemAt = this.grid.itemAt(i, j);
                if( itemAt != null ) {
                    Shape shape = ShapeFactory.getShapeForItem(itemAt, i, j);
                    g2d.fill(shape);
                }
            }
        }
    }

    @Override
    public void onTick( long currentTime ) {
        for(TBlock block1 : tBlocks) {
            if (currentTime % 10 == 0 && currentTime != 0) {
                block1.moveDown();
                //tBlocks.add(block1);
            }
            if (direction == BlockState.LEFT) {
                block1.moveLeft();
                //tBlocks.add(block1);
            } else if (direction == BlockState.RIGHT) {
                block1.moveRight();
                //tBlocks.add(block1);
            } else if (direction == BlockState.NONE) {
                //tBlocks.add(block1);
            } else {
                block1.place();
                block = new TBlock();
                //tBlocks.add(this.block);
            }
            direction = BlockState.NONE;
            this.repaint();
            break;
        }
    }
}
