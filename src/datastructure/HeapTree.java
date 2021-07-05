package datastructure;

/*
It's a special type of binary search tree.
If BST is a complete binary tree then it called as heap tree.
Heap tree implementation can be done using Arrays.

Heap tree can be derived with two concepts -:
    1. All parent node value is less then or equal to child node value. This implementation called as min heap.
    2. All parent node value is greater or equal then child node. This implementation called as max heap.
 Any methodology can be choosen for the implementation of heap tree.
-> Because of max or min heap property,l root will be always have max or min value. Advantage of heap tree
 -> Heap tree insertation order always starts from left to right.
 -> No required ordering among sibling. We always follow the level during insertion
-> Search complexity is for insert O(log n)  , for traverse O() ,  for deleting O(nlogn) -> because of liner search

in Array implementation
    if index is = i then
    left child = 2i + 1
    right child = 2i+2
    parent = floor ((i-1) / 2) -> nearest whole value. Here i is the index of child.

   0   1   2   3   4  5  6  7
  22, 19, 18, 15, 3, 14, 4, 12

Note -> During the insertion, we always insert at the end of the array and fix the heap to preserve the property. This is called heapify
           It generally done by replacing the parents

 */


//Implementation using MAX heap


public class HeapTree {

}
