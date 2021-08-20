package heap;

import java.util.Arrays;

public class HeapSort<E extends Comparable<? super E>> {
    private MinHeap<E> minHeap;
    private int n;
    private E[] array;

    private static final int SORT_A = 2;
    private static final int SORT_D = 3;

    public HeapSort(int n){
        array = newArray(n);
        minHeap = new MinHeap<E>(array, 0, n);
        this.n = n;
    }

    public void add(E value){
        // fill your code

    }

    public void remove(E value){
        // fill your code

    }

    public void sort(int order){
        // fill your code

    }

    //This function is for allocating an generic array of size n
    private static <E> E[] newArray(int length, E... array)
    {
        return Arrays.copyOf(array, length);
    }
}
