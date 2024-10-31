import components.map.Map;
import components.standard.Standard;

/**
 * Tracker kernel component with primary methods.
 *
 * @mathsubtypes <pre>
 * PARTIAL_FUNCTION is finite set of (name: String, value: Integer)
 *  exemplar t
 *  constraint
 *   for all name1, name2: String, value1, value2: Integer
 *     where ((name1, value1) is in t and  (name2, value2) is in m)
 *    (if name1 = name2 then value1 = value2)
 * </pre>
 * @mathdefinitions <pre>
 * DOMAIN(
 *   t: PARTIAL_FUNCTION
 *  ): finite set of Strings satisfies
 *  for all name: String (name is in DOMAIN(t) iff
 *   there exists value: V ((name, value) is in t))
 * </pre>
 * @mathmodel type TrackerKernel is modeled by PARTIAL_FUNCTION
 * @initially <pre>
 * ():
 *  ensures
 *   this = {}
 * (String... args):
 *  ensures
 *   this = {(args[0], 0), (args[1], 0)...}
 * </pre>
 * @iterator <pre>
 * entries(~this.seen * ~this.unseen) = this  and
 * |~this.seen * ~this.unseen| = |this|
 * </pre>
 */

public interface TrackerKernel
        extends Standard<Tracker>, Iterable<Map.Pair<String, Integer>> {

    /**
     * Sets the value of a statistic, and adds it to the Tracker if it is not
     * already included.
     *
     * @param name
     *            The name of the statistic
     *
     * @param value
     *            The value of the statistic
     * @return whether name was already in this
     * @updates this
     * @ensures (name, value) is in this
     */
    boolean setValue(String name, int value);

    /**
     * Reports the size of {@code this}.
     *
     * @return The number of statistics in this
     * @ensures size = |this|
     */
    int size();

    /**
     * Reports the value assosiated with name.
     *
     * @return The vale of {@code name}
     * @param name
     *            The name of the statistic to report the value of
     * @requires name is in DOMAIN(this)
     * @ensures (name, value) is in this
     */
    int value(String name);

    /**
     * Removes name from this and returns its value.
     *
     * @param name
     *            the statistic to be removed
     * @return the value associsated with {@code name}
     * @updates this
     * @requires name is in DOMAIN(this)
     * @ensures <pre>
     * remove = name.value  and
     * remove is in #this  and
     * this = #this \ {(name, remove)}
     * </pre>
     */
    int remove(String name);

    /**
     * Removes and returns an arbitrary statistic and its value from
     * {@code this}.
     *
     * @return the pair removed from {@code this}
     * @updates this
     * @requires |this| > 0
     * @ensures <pre>
     * removeAny is in #this and
     * this = #this \ {removeAny}
     * </pre>
     */
    Map.Pair<String, Integer> removeAny();
}
