package ds;

import java.util.Arrays;

/**
 * General Tree class implementation for UNION/FIND
 */
public class ParPtrTree {
    private Integer[] array; // Node array
    private Integer[] size; // groupsize array. Consider only values of root nodes. We don't need to care others.
    private int maxSize;

    public ParPtrTree(int maxsize) {
        this.maxSize = maxsize;
        array = new Integer[this.maxSize]; // Create node array
        size = new Integer[this.maxSize];
        for (int i = 0; i < this.maxSize; i++) {
            array[i] = null;
            size[i] = 1;
        }
    }

    public void clear() {
        array = new Integer[this.maxSize]; // Create node array
        size = new Integer[this.maxSize];
        for (int i = 0; i < this.maxSize; i++) {
            array[i] = null;
            size[i] = 1;
        }
    }

    /**
     * Determine if nodes are in different trees
     */
    public boolean differ(Integer a, Integer b) {

        //TODO: fill your code
        System.out.println("fill your code");
        return false;
    }

    /**
     * Merge two subtrees using weighted union rule
     */
    public void union(Integer a, Integer b) {

        //TODO: fill your code
        // follow "weighted union rule"
        // if group size of two values are equal, hang b's root to a's.
        System.out.println("fill your code");
    }

    /**
     * Find the root of the node using path compression
     */
    public Integer find(Integer curr) {
        //TODO: fill your code
        // use "path compression"
        System.out.println("fill your code");
        return null;
    }

    /**
     * Return the size of the graph that the node belongs to
     */
    public Integer groupSize(Integer curr) {
        //TODO: fill your code
        System.out.println("fill your code");
        return null;
    }

    public Integer[] getSize() {
        return this.size;
    }

    public Integer[] getArray() {
        return this.array;
    }

    public void print() {
        System.out.println(Arrays.toString(array).replace("null", "N"));
    }


}
