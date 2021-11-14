# StackingBlocks

## Find the maximum height of the stacked blocks

## Problem Statement

Given n blocks where the dimensions of the ith block is blocks[i] = [widthi, lengthi, heighti] (0-indexed). Choose a subset of blocks and place them on each other. You can place block i on block j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj. 

You can rearrange any blocks's dimensions by rotating it to put it on another block. Return the maximum height of the stacked blocks.

## Solution.

StackedBlocks class is responsible for finding the max height of the blocks.

First we validate if input is not null or does not contains the null objects and also for following constraints:-

1) 1 <= n <=100, blocks cannot be more than 100 or less than 1 (null)
2) 1<= lenght, width, height <=100, Blocks dimensions (height/width/length) cannot be less than 1 or more than 100.



After validaton check, we rotate each block with max dimension as height and we are keeping the width as min and depth as max which helps us in keeping symmetry for all blocks, and it will help us in comparison.


After rotation, we sort the blocks based on area of sides facing down, in ascending order.

After sorting we have sequence in which blocks can be placed but can only be added if below condition is satisfied.

```
previousBlock.getDepth() >= currentBlock.getDepth() && previousBlock.getWidth() >= currentBlock.getWidth() && previousBlock.getHeight() >= currentBlock.getHeight()
```
based on above scenation we get the blocks which can be places over each other and will get the total height.

There might be a scenario where all the blocks are uneven, in that case we have to return the height of max block.


