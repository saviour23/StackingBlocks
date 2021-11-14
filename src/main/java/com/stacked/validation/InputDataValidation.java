package com.stacked.validation;

import com.stacked.Block;

/**
 * Class to validate input data of all the blocks.
 */
public class InputDataValidation {

    /**
     * Method to validate input it input is null, empty or contains any empty block.
     *
     * @param blocks input blocks
     * @return true if input is valid else false
     */
    public static boolean isInputValid(Block[] blocks) {

        //Input Null check
        if (null == blocks) {
            System.out.println("Invalid input, Input is null.");
            return false;
        }

        // 1<=block length <=100
        if (blocks.length > 100) {
            System.out.println("Input blocks cannot be more than 100");
            return false;
        }

        //checking if input has any null block
        for (int index = 0; index < blocks.length; index++) {
            if (null == blocks[index]) {
                System.out.println("Invalid input, input contains null/empty block.");
                return false;
            }
        }

        //checking if dimension of all blocks are within constraints of >=1 and <=100
        for (int index = 0; index < blocks.length; index++) {
            Block block = blocks[index];
            if (block.getHeight() < 1 || block.getHeight() > 100) {
                System.out.println("Invalid height of block, value= " + block.getHeight());
                return false;
            } else if (block.getWidth() < 1 || block.getWidth() > 100) {
                System.out.println("Invalid width of block, value= " + block.getWidth());
                return false;
            } else if (block.getDepth() < 1 || block.getDepth() > 100) {
                System.out.println("Invalid depth of block, value= " + block.getDepth());
                return false;
            }


        }
        return true;
    }
}
