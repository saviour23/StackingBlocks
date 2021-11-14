package com.stacked;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackedBlockTest {

    private StackedBlocks stackedBlocks;

    @Before
    public void init() {
        stackedBlocks = new StackedBlocks();
    }

    /**
     * Scenario 1 of Test Document.
     * 3 random blocks but can be stacked together.
     */
    @Test
    public void testStackedBlock_scenario1() {
        Block[] arr = new Block[3];
        arr[0] = new Block(50, 45, 20);
        arr[1] = new Block(95, 37, 53);
        arr[2] = new Block(45, 23, 12);

        int maxHeight = stackedBlocks.maxStackHeight(arr);

        Assert.assertEquals(190, maxHeight);
    }

    /**
     * Scenario 2 of Test Document.
     * 2 uneven Blocks so max should be one of them having max height.
     */
    @Test
    public void testStackedBlock_scenario2() {
        Block[] arr = new Block[2];

        arr[0] = new Block(38, 25, 45);
        arr[1] = new Block(76, 35, 3);

        int maxHeight = stackedBlocks.maxStackHeight(arr);

        Assert.assertEquals(76, maxHeight);
    }

    /**
     * Scenario 3 of Test Document.
     * All boxes with diff dimentions but can be rotated to be same.
     */
    @Test
    public void testStackedBlock_scenario3() {
        Block[] arr = new Block[6];
        arr[0] = new Block(7, 11, 17);
        arr[1] = new Block(7, 17, 11);
        arr[2] = new Block(11, 7, 17);
        arr[3] = new Block(11, 17, 7);
        arr[4] = new Block(17, 7, 11);
        arr[5] = new Block(17, 11, 7);
        int maxHeight = stackedBlocks.maxStackHeight(arr);

        Assert.assertEquals(102, maxHeight);
    }


    /**
     * 3 Uneven blocks so max should be one of them having max height.
     */
    @Test
    public void testStackedBlock_3unevenBlocks() {
        Block[] arr = new Block[3];
        arr[0] = new Block(78, 35, 2);
        arr[1] = new Block(38, 25, 45);
        arr[2] = new Block(76, 35, 3);

        int maxHeight = stackedBlocks.maxStackHeight(arr);

        Assert.assertEquals(78, maxHeight);
    }

    /**
     * Null Input test
     */
    @Test
    public void testStackedBlock_nullInput() {
        int maxHeight = stackedBlocks.maxStackHeight(null);

        Assert.assertEquals(0, maxHeight);

    }


    /**
     * Empty Array input test
     */
    @Test
    public void testStackedBlock_EmptyInput() {
        Block[] arr = new Block[2];
        int maxHeight = stackedBlocks.maxStackHeight(arr);

        Assert.assertEquals(0, maxHeight);

    }

    /**
     * input with one value as null which is invalid.
     */
    @Test
    public void testStackedBlock_InvalidInputWithEmptyBlock() {
        Block[] arr = new Block[3];
        arr[0] = new Block(78, 35, 2);
        arr[1] = null;
        arr[2] = new Block(76, 35, 3);
        int maxHeight = stackedBlocks.maxStackHeight(arr);

        Assert.assertEquals(0, maxHeight);

    }

    /**
     * Test for negative dimension.
     */
    @Test
    public void testStackedBlock_NegativeDimensionBlocks() {
        Block[] arr = new Block[3];
        arr[0] = new Block(78, 35, 2);
        arr[1] = new Block(38, 25, 45);
        arr[2] = new Block(76, -35, 3);

        int maxHeight = stackedBlocks.maxStackHeight(arr);

        Assert.assertEquals(0, maxHeight);
    }

    /**
     * Test for count of block more than allowed.
     */
    @Test
    public void testStackedBlock_MoreBlockThanAllowed() {
        Block[] arr = new Block[101];
        for(int count =0 ; count<=100; count++){

            arr[count] = new Block(78, 35, 2);
        }

        int maxHeight = stackedBlocks.maxStackHeight(arr);

        Assert.assertEquals(0, maxHeight);
    }


}
