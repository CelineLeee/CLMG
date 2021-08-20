package heap;


import java.lang.Comparable;

/** Min-heap implementation */
public class MinHeap<E extends Comparable<? super E>> {
    private E[] Heap;   // Pointer to the heap array
    private int size;   // Maximum size of the heap
    private int n;      // Number of things in heap

    /** Constructor supporting preloading of heap contents */
    public MinHeap(E[] h, int num, int max){
        Heap = h;
        n = num;
        size = max;
        buildheap();
    }

    /** @return Current size of the heap */
    public int heapsize() {
        return n;
    }

    /** Re-define the heapsize. Used for reconstructing heap after sorting. */
    public void setSize(int heapsize) {
        n = heapsize;
    }

    /** @return True if pos a leaf position, false otherwise */
    public boolean isLeaf(int pos){
        return (pos >= n/2) && (pos < n);
    }

    /** @return Position for left child of pos */
    public int leftchild(int pos) {
        assert pos < n/2 : "Position has no left child";
        return 2*pos + 1;
    }

    /** @return Position for right child of pos */
    public int rightchild(int pos) {
        assert pos < (n-1)/2 : "Position has no right child";
        return 2*pos + 2;
    }

    /** @return Position for parent */
    public int parent(int pos) {
        assert pos > 0 : "Position has no parent";
        return (pos-1)/2;
    }

    private void swap(E[] A, int p1, int p2) {
        E temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }

    /** Heapify contents of Heap */
    public void buildheap(){
        for (int i=n/2-1; i>=0; i--)
            siftdown(i);
    }

    /** Insert val into heap */
    public void insert(E val) {
        assert n < size : "Heap is full";

        // fill your code

    }

    /** Put element in its correct place */
    private void siftdown(int pos) {
        // fill your code

    }

    /** Remove and return minimum value */
    public E removeMin() {
        // fill your code


    }

    /** Remove and return element at specified position */
    public E remove(int pos) {
        // fill in your code

    }

    /**  Return a position of target element */
    public int find(E value){
        // fill in your code

    }

    /** Print the Heap */
    public void printHeap() {

        // fill in your code

        for (int i=0; i<n; i++) {
            System.out.print(Heap[i].toString());
            System.out.print(" ");
        }

    }
}
