package com.nwabear.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static com.nwabear.tetris.AppContext.*;

public class TetrisFrame extends JFrame {
    private TBlock block;
    private Window window;

    private TetrisFrame() {
        this.initUi();
    }

    private void initUi() {
        this.window = new Window();

        this.initBlock();

        this.add( this.window );

        this.setTitle( "Tetris" );

        int width = (int)(((COL_COUNT + 2) * LOCATION_MULTIPLIER) - 4);
        int height = (int)(((ROW_COUNT + 4) * LOCATION_MULTIPLIER) - 1);
        this.setSize( width, height );
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        this.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped( KeyEvent keyEvent ) {

            }

            @Override
            public void keyPressed( KeyEvent keyEvent ) {
                switch( keyEvent.getKeyCode() ) {
                    case 37: //left
                        window.setDirection(BlockState.LEFT);
                        break;
                    //case 38: //up
                    //    break;
                    case 39: //right
                        window.setDirection(BlockState.RIGHT);
                        break;
                    case 40: //down
                        window.setDirection(BlockState.STOPPED);
                        break;
                }
            }

            @Override
            public void keyReleased( KeyEvent keyEvent ) {

            }
        } );
        
        this.addWindowListener( new WindowListener() {

            @Override
            public void windowOpened( WindowEvent windowEvent ) {

            }

            @Override
            public void windowClosing( WindowEvent windowEvent ) {
                GameClockManager.stopGameClock();
            }

            @Override
            public void windowClosed( WindowEvent windowEvent ) {

            }

            @Override
            public void windowIconified( WindowEvent windowEvent ) {

            }

            @Override
            public void windowDeiconified( WindowEvent windowEvent ) {

            }

            @Override
            public void windowActivated( WindowEvent windowEvent ) {

            }

            @Override
            public void windowDeactivated( WindowEvent windowEvent ) {

            }
        } );
    }

    private void initBlock() {
        int midpointCol = COL_COUNT / 2;
        int midpointRow = ROW_COUNT / 2;
        this.block = new TBlock();
        this.window.initWindow( block );
        GameClockManager.startGameClock();
    }

    public static void main( String [] args ) throws Exception {
        TetrisFrame tf = new TetrisFrame();
        EventQueue.invokeLater( () -> {
            tf.setVisible( true );
        } );
    }
}
