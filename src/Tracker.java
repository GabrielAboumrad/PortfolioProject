/**
 * Layered implementations of secondary methods for {@code Tracker}.
 */
public interface Tracker extends TrackerKernel {

    /**
     * Sets the value of {@code name} to zero and returns its previous value.
     *
     * @param name
     *            the name of the statistic to reset the value of
     * @return the original value assosiated with name
     * @updates this
     * @requires name is in this
     * @ensures <pre>
     * (name, toZero) is in #this  and
     * (name, 0) is in this
     * </pre>
     */
    int toZero(String name);

    /**
     * Adds {@code n} to the value of {@code name}.
     *
     * @param name
     *            the name of the statistic to edit the value of
     * @param n
     *            the number to add
     * @updates this
     * @requires <pre>
     * name is in this  and
     * #name.value + n <= Integer.MAX_VALUE  and
     * #name.value + n >= Integer.MIN_VALUE
     * </pre>
     * @ensures (name, name.#value + n) is in this
     */
    void add(String name, int n);

    /**
     * Subtrats {@code n} from the value of {@code name}.
     *
     * @param name
     *            the name of the statistic to edit the value of
     * @param n
     *            the number to subtract
     * @updates this
     * @requires <pre>
     * name is in this  and
     * #name.value - n <= Integer.MAX_VALUE  and
     * #name.value - n >= Integer.MIN_VALUE
     * </pre>
     * @ensures (name, name.#value - n) is in this
     */
    void subtract(String name, int n);

    /**
     * Multiplies {@code n} with the value of {@code name}.
     *
     * @param name
     *            the name of the statistic to edit the value of
     * @param n
     *            the number to multiply by
     * @updates this
     * @requires <pre>
     * name is in this  and
     * #name.value * n <= Integer.MAX_VALUE  and
     * #name.value * n >= Integer.MIN_VALUE
     * </pre>
     * @ensures (name, name.#value * n) is in this
     */
    void multiply(String name, int n);

    /**
     * Divides the value of {@code name} by {@code n}.
     *
     * @param name
     *            the name of the statistic to edit the value of
     * @param n
     *            the number to divide by
     * @updates this
     * @requires <pre>
     * name is in this  and
     * n != 0
     * </pre>
     * @ensures (name, name.#value / n) is in this
     */
    void divide(String name, int n);

    /**
     * Raises the value of {@code name} to the power {@code n}.
     *
     * @param name
     *            the name of the statistic to edit the value of
     * @param n
     *            the exponent
     * @updates this
     * @requires <pre>
     * name is in this  and
     * n >= 0  and
     * #name.value ^ n <= Integer.MAX_VALUE  and
     * #name.value ^ n >= Integer.MIN_VALUE
     * </pre>
     * @ensures (name, name.#value ^ n) is in this
     */
    void power(String name, int n);

    /**
     * Updates the value of {@code name} to its {@code n}-th root.
     *
     * @param name
     *            the name of the statistic to edit the value of
     * @param n
     *            the root
     * @updates this
     * @requires <pre>
     * name is in this  and
     * n >= 2
     * </pre>
     * @ensures (name, n-th root of name.#value) is in this
     */
    void root(String name, int n);

    /**
     * Returns all of the pairs with the greatest value.
     *
     * @return pairs with highest value
     * @requires |this| > 0
     * @ensures <pre>
     * highest is in this  and
     * all name.value in DOMAIN(highest) >= all name.value in DOMAIN(this)
     * </pre>
     */
    Tracker highest();

    /**
     * Returns all of the pairs with the lowest value.
     *
     * @return pairs with lowest value
     * @requires |this| > 0
     * @ensures <pre>
     * lowest is in this  and
     * all name.value in DOMAIN(lowest) >= all name.value in DOMAIN(this)
     * </pre>
     */
    Tracker lowest();
}
