package com.stacked;

import java.util.Objects;

/**
 * Block is POJO class representing the dimensions and area of the single block.
 */
public final class Block implements Comparable<Block> {

    private int height, width, depth, area;

    //Constructor
    public Block(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return height == block.height && width == block.width && depth == block.depth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, depth);
    }

    @Override
    public int compareTo(Block block) {
        return block.area - this.area;

    }
}