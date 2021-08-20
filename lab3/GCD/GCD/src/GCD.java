public class GCD {
    /**
     * Returns a greatest common divisor (GCD) of the given two integers.
     *
     * @param a A number which the GCD is to be computed
     * @param b A number which the GCD is to be computed
     * @return The GCD of a and b
     */
    public static int gcd(int a, int b) {
        // TODO Fill your code to calculate a greatest common divisor for a and b.
        // Note that you have to use recursive function call.
        if (b != 0)
            return gcd(b, a % b);
        else
            return a;
    }
}
