import components.map.Map;

/**
 * Layered implementations of secondary methods for {@code Map}.
 */
public abstract class TrackerSecondary extends Object implements Tracker {

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
    @Override
    public int toZero(String name) {
        int original = this.value(name);
        this.setValue(name, 0);
        return original;
    }

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
    @Override
    public void add(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original + n);
    }

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
    @Override
    public void subtract(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original - n);
    }

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
    @Override
    public void multiply(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original * n);
    }

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
    @Override
    public void divide(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original / n);
    }

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
    @Override
    public void power(String name, int n) {
        int original = this.value(name);
        this.setValue(name, (int) Math.pow(original, n));
    }

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
    @Override
    public void root(String name, int n) {
        int original = this.value(name);
        this.setValue(name, (int) Math.pow(original, 1 / n));
    }

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
    @Override
    public Tracker highest() {

        //set maxValue to any value from the Tracker
        Tracker result = this.newInstance();
        Map.Pair<String, Integer> any = this.removeAny();
        int maxValue = any.value();
        this.setValue(any.key(), any.value());

        //Find the highest value
        for (Map.Pair<String, Integer> item : this) {

            if (item.value() > maxValue) {
                maxValue = item.value();
            }

            this.setValue(item.key(), item.value());
        }

        //Add all pairs with the highest value to result
        for (Map.Pair<String, Integer> item : this) {

            if (item.value() >= maxValue) {
                result.setValue(item.key(), item.value());
            }

            this.setValue(item.key(), item.value());
        }

        return result;
    }

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
    @Override
    public Tracker lowest() {

        //set minValue to any value from the Tracker
        Tracker result = this.newInstance();
        Map.Pair<String, Integer> any = this.removeAny();
        int minValue = any.value();
        this.setValue(any.key(), any.value());

        //Find the highest value
        for (Map.Pair<String, Integer> item : this) {

            if (item.value() < minValue) {
                minValue = item.value();
            }

            this.setValue(item.key(), item.value());
        }

        //Add all pairs with the highest value to result
        for (Map.Pair<String, Integer> item : this) {

            if (item.value() <= minValue) {
                result.setValue(item.key(), item.value());
            }

            this.setValue(item.key(), item.value());
        }

        return result;

    }

    /**
     * Reports the value of {@code this} as a String.
     *
     * @return a String representation of {@code this}
     */
    @Override
    public String toString() {

        String result = "{";

        for (Map.Pair<String, Integer> item : this) {

            result += "(" + item.key() + ", " + item.value().toString() + "), ";
        }

        result += "}";

        return result;
    }

    /**
     * Reports wheather {@code this} and {@code t} are equal.
     *
     * @param t
     *            the {@code Tracker} to compare to {@code this}
     * @return wheather {@code this} and {@code t} are equal
     */
    public boolean equals(Tracker t) {

        boolean equal = true;

        for (Map.Pair<String, Integer> item : this) {

            if (t.value(item.key()) != (item.value()) && equal) {
                equal = false;
            }
        }

        return equal;
    }
}
