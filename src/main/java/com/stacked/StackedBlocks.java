package com.stacked;

import com.stacked.validation.InputDataValidation;

import java.util.Arrays;

/**
 * Class to find the max height of all the blocks which can be stacked with the condition that
 * 2nd block can be placed on first only if following conditions meet.
 * 1) width of 2nd block is <= width of 1st block
 * 2) length of 2nd block is  <= length of 1st block
 * 3) height of 2nd block is <= height of 1st block
 * 4) dimensions of the block can be rearranged as well by rotating.
 */
public class StackedBlocks {

    /**
     * Method for finding the max height.
     *
     * @param blockArr Array of blocks
     * @return max height of the stack or 0 in case of invalid input.
     */
    public int maxStackHeight(Block[] blockArr) {

        //If input is invalid then returning 0.
        if (!InputDataValidation.isInputValid(blockArr)) {
            return 0;
        }
        int count = blockArr.length;

        //array for holding the blocks after dimension rotation.
        Block[] rotatedBlocks = new Block[count];

        for (int index = 0; index < count; index++) {
            rotatedBlocks[index] = rotateBlockForMaxHeight(blockArr[index]);
        }

        //Sorting the blocks based on area, descending order.
        Arrays.sort(rotatedBlocks);


        int maxHeight = rotatedBlocks[0].getHeight();

        for (int index = 1; index < count; index++) {
            Block previousBlock = rotatedBlocks[index - 1];
            Block currentBlock = rotatedBlocks[index];
            //checking the condition if current block can be placed on previous.
            if (previousBlock.getDepth() >= currentBlock.getDepth() && previousBlock.getWidth() >= currentBlock.getWidth() && previousBlock.getHeight() >= currentBlock.getHeight()) {
                maxHeight = maxHeight + currentBlock.getHeight();

            }
            // this condition will execute only if current block cannot be placed  but have the more height than previous block
            else if (currentBlock.getHeight() >= previousBlock.getHeight()) {
                maxHeight = currentBlock.getHeight();
            }

        }


        return maxHeight;
    }

    /**
     * Method is rotating the blocks and setting height as max from its dimentiions.
     * Here, after finding and setting the height, we are keeping the width as min and depth as max which helps us in keeping symmetry, and it will help us in comparison.
     *
     * @param block block for dimension rotation.
     * @return block with height as max.
     */
    private Block rotateBlockForMaxHeight(Block block) {

        Block b;
        if (block.getHeight() > block.getWidth() && block.getHeight() > block.getDepth()) {
            b = new Block(block.getHeight(), Math.min(block.getWidth(), block.getDepth()), Math.max(block.getWidth(), block.getDepth()));
        } else if (block.getWidth() > block.getHeight() && block.getWidth() > block.getDepth()) {
            b = new Block(block.getWidth(), Math.min(block.getHeight(), block.getDepth()), Math.max(block.getHeight(), block.getDepth()));
        } else {
            b = new Block(block.getDepth(), Math.min(block.getHeight(), block.getWidth()), Math.max(block.getHeight(), block.getWidth()));
        }
        //calculating and Setting area of base
        b.setArea(b.getWidth() * b.getDepth());
        return b;

    }


}
