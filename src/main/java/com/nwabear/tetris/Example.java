package com.nwabear.tetris;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main( String [] args ) {
        TBlock block1;
        List<TBlock> blocks = new ArrayList<>();

        for( int i = 0; i < 10; i++ ) {
            block1 = new TBlock();
            block1.setName( "Block " + i );

            blocks.add( block1 );
        }

        for( TBlock block : blocks ) {
            System.out.println( block.getName() );
        }
    }
}
