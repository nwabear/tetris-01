package com.nwabear.tetris;


public class TBlock {
    private SingleBlock l = new SingleBlock(26, 15);
    private SingleBlock r = new SingleBlock(24, 15);
    private SingleBlock u = new SingleBlock(25, 15);
    private SingleBlock d = new SingleBlock(25, 16);
    
    private SingleBlock[] blocks = {l, r, u, d};

    private String name;

    public void moveLeft() {
        blocks[1].moveLeft();
        blocks[2].moveLeft();
        blocks[3].moveLeft();
        blocks[0].moveLeft();
    }

    public void moveRight() {
        blocks[3].moveRight();
        blocks[0].moveRight();
        blocks[2].moveRight();
        blocks[1].moveRight();
    }

    public void moveDown() {
        blocks[3].moveDown();
        blocks[0].moveDown();
        blocks[2].moveDown();
        blocks[1].moveDown();
    }

    public void place() {
        blocks[3].place();
        blocks[0].place();
        blocks[2].place();
        blocks[1].place();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
