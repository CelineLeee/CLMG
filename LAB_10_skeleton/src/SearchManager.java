import java.math.BigInteger;
import java.net.PasswordAuthentication;
import java.util.concurrent.TimeUnit;

public class SearchManager {
    BigInteger[] items;
    int N = -1;

    public SearchManager() {
    }

    /**
     * Set items for the 'this.itmes' array using arithmetic or geometric sequence.
     * Print the elements in the array using 'print' function at the end of the code.
     * Hint. You have to use BigInteger1.add(BigInteger2) or BigInteger1.multiply(BigInteger2)
     * when you add or multiply BigIntegers.
     * Hint. You have to use 'new BigInterger("STRING TYPE VALUE")' to generate new BigInteger Instance.
     * e.g. a = new BigInteger("1234567890123456789")
     *
     * @param type 'A' for arithmetic, 'G" for geometric sequence.
     * @param n    the number of elements.
     * @param a0   the initial value.
     * @param d    commom difference/ ratio of the sequence.
     */
    public void setItems(char type, int n, int a0, int d) {
        this.N = n;
        this.items = new BigInteger[n];
        ///TODO: fill in the code
        System.out.println("setItems");
    }

    /**
     * Find the index of the target in "this.items" using jump search and count the number of comparisons.
     * Print "[J] Index: (index), count: (count)" if you find the target.
     * Print "[J] Not found, count: (count)" if there is no target in the "this.items".
     * Hint. Use BigInteger1.compareTo(BigInteger2) when you compare two BigInteger instances.
     *
     * @param target BigInteger type of target value
     * @return index of the target value
     */
    public int doJumpSearch(BigInteger target) {
        if (this.N == -1) {
            System.out.println("[J] The array is empty.");
            return -1;
        }
        ///TODO: fill in the code
        System.out.println("doJumpSearch");
        return -1;
    }

    /**
     * Find the index of the target in "this.items" using binary search and count the number of comparisons.
     * Print "[B] Index: (index), count: (count)" if you find the target.
     * Print "[B] Not found, count: (count)" if there is no target in the "this.items".
     * Hint. Use BigInteger1.compareTo(BigInteger2) when you compare two BigInteger instances.
     *
     * @param target BigInteger type of target value
     * @return index of the target value
     */
    public int doBinarySearch(BigInteger target) {
        if (this.N == -1) {
            System.out.println("[J] The array is empty.");
            return -1;
        }
        ///TODO: fill in the code
        System.out.println("doBinarySearch");
        return -1;

    }

    /**
     * Print the list of elements in the 'this.items'.
     */
    public void print() {
        if (this.N == -1) {
            System.out.println("There are no items to print");
        }
        String str = "";
        for (int i = 0; i < N; i++) str += this.items[i] + " ";
        System.out.println(str);
    }

    /*----------------------------------- Optional Problem ----------------------------------------------*/

    /**
     * Find the index of the target in "this.items" using interpolation search and count the number of comparisons.
     * Print "[I] Index: (index), count: (count)" if you find the target.
     * Print "[I] Not found, count: (count)" if there is no target in the "this.items".
     *
     * @param target BigInteger type of target value
     * @return index of the target value
     */
    public int doInterpolationSearch(BigInteger target) {
        ///TODO: fill in the code
        System.out.println("doInterpolationSearch");
        return -1;
    }
}