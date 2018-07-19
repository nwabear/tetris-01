package com.nwabear.tetris;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static com.nwabear.tetris.AppContext.*;

public class ShapeFactory {
    public static Shape getShapeForItem(GridItem item, int col, int row ) {
        switch( item ) {
            case TETRIS_BLOCK:
                return getShapeForBlock( col, row );
            default:
                return null;
        }
    }

    public static Shape getShapeForBlock( int col, int row ) {
        float widthActual = BLOCK_WIDTH * LOCATION_MULTIPLIER;
        float heightActual = BLOCK_HEIGHT * LOCATION_MULTIPLIER;

        return new Rectangle2D.Float( col * LOCATION_MULTIPLIER, row * LOCATION_MULTIPLIER, widthActual, heightActual );
    }
}
