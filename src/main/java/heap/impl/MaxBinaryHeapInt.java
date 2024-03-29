package heap.impl;

import java.util.Arrays;

/**
 * Implementation of max binary heap
 */
public class MaxBinaryHeapInt {

    private int[] heap;
    private int size;
    private static final int d = 2; // binary heap

    MaxBinaryHeapInt(int size) {
        this.size = size;
        heap = new int[size];
        // initiate the binary heap
        Arrays.fill(heap, -1);
    }

    public int kthChildIndex(int i, int k) {
        return d * i + k;
    }

    public int maxChildIndex(int index) {
        return 0;
    }

    public int minChildIndex(int index) {
        return 0;
    }

    public void makeEmpty() {
        size = 0;
    }

    public void insert(int element) {
        heap[size++] = element;
        heapifyUp();
    }

    public void insertAt(int index) {
    }

    // performs heapifyUp for MaxHeap property
    public void heapifyUp() {
        int index = size - 1;
        int curElement = heap[index];

        while (index > 0 && curElement > heap[getParentIndex(index)]) {
            // swap the elements until the max element is at the top
            heap[index] = heap[getParentIndex(index)];
            index = getParentIndex(index);
        }
        heap[index] = curElement;
    }

    public void heapifyDown(int index) {
        int curElement = heap[index];
        int childIndex;

        while (kthChildIndex(index, 1) < size) {
            childIndex = maxChildIndex(index);
            if (heap[index] > curElement) {
                heap[index] = heap[childIndex];
            }
            else {
                break;
            }
            index = childIndex;
        }
        heap[index] = curElement;
    }

    public int delete(int index) {
        int curElement = heap[index];
        heap[index] = heap[size - 1];
        size--;
        heapifyDown(index);
        return curElement;
    }

    public int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    public int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int parent(int index) {
        return heap[getParentIndex(index)];
    }

    public int leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    public int RightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    public boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    public boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    public boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
}


//package com.codepumpkin.dataStructures;
//
//    import java.util.Arrays;
//    import java.util.NoSuchElementException;
//
//public class BinaryHeap {
//
//  private static final int d= 2;
//  private int[] heap;
//  private int heapSize;
//
//  /**
//   * This will initialize our heap with default size.
//   */
//  public BinaryHeap(int capacity){
//    heapSize = 0;
//    heap = new int[ capacity+1];
//    Arrays.fill(heap, -1);
//
//  }
//
//  /**
//   *  This will check if the heap is empty or not
//   *  Complexity: O(1)
//   */
//  public boolean isEmpty(){
//    return heapSize==0;
//  }
//
//  /**
//   *  This will check if the heap is full or not
//   *  Complexity: O(1)
//   */
//  public boolean isFull(){
//    return heapSize == heap.length;
//  }
//
//
//  private int parent(int i){
//    return (i-1)/d;
//  }
//
//  private int kthChild(int i,int k){
//    return d*i  +k;
//  }
//
//  /**
//   *  This will insert new element in to heap
//   *  Complexity: O(log N)
//   *  As worst case scenario, we need to traverse till the root
//   */
//  public void insert(int x){
//    if(isFull())
//      throw new NoSuchElementException("Heap is full, No space to insert new element");
//    heap[heapSize++] = x;
//    heapifyUp(heapSize-1);
//  }
//
//  /**
//   *  This will delete element at index x
//   *  Complexity: O(log N)
//   *
//   */
//  public int delete(int x){
//    if(isEmpty())
//      throw new NoSuchElementException("Heap is empty, No element to delete");
//    int key = heap[x];
//    heap[x] = heap[heapSize -1];
//    heapSize--;
//    heapifyDown(x);
//    return key;
//  }
//
//  /**
//   *  This method used to maintain the heap property while inserting an element.
//   *
//   */
//  private void heapifyUp(int i) {
//    int temp = heap[i];
//    while(i>0 && temp > heap[parent(i)]){
//      heap[i] = heap[parent(i)];
//      i = parent(i);
//    }
//    heap[i] = temp;
//  }
//
//  /**
//   *  This method used to maintain the heap property while deleting an element.
//   *
//   */
//  private void heapifyDown(int i){
//    int child;
//    int temp = heap[i];
//    while(kthChild(i, 1) < heapSize){
//      child = maxChild(i);
//      if(temp < heap[child]){
//        heap[i] = heap[child];
//      }else
//        break;
//
//      i = child;
//    }
//    heap[i] = temp;
//  }
//
//  private int maxChild(int i) {
//    int leftChild = kthChild(i, 1);
//    int rightChild = kthChild(i, 2);
//
//    return heap[leftChild]>heap[rightChild]?leftChild:rightChild;
//  }
//
//  /**
//   *  This method used to print all element of the heap
//   *
//   */
//  public void printHeap()
//  {
//    System.out.print("\nHeap = ");
//    for (int i = 0; i < heapSize; i++)
//      System.out.print(heap[i] +" ");
//    System.out.println();
//  }
//  /**
//   *  This method returns the max element of the heap.
//   *  complexity: O(1)
//   */
//  public int findMax(){
//    if(isEmpty())
//      throw new NoSuchElementException("Heap is empty.");
//    return heap[0];
//  }
//
//  public static void main(String[] args){
//    BinaryHeap maxHeap = new BinaryHeap(10);
//    maxHeap.insert(10);
//    maxHeap.insert(4);
//    maxHeap.insert(9);
//    maxHeap.insert(1);
//    maxHeap.insert(7);
//    maxHeap.insert(5);
//    maxHeap.insert(3);
//
//    maxHeap.printHeap();
//    maxHeap.delete(5);
//    maxHeap.printHeap();
//
//  }
//}
