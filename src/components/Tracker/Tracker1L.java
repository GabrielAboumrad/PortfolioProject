package components.Tracker;

import java.util.Iterator;
import java.util.NoSuchElementException;

import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;

/**
 * {@code Tracker} represented as a {@code components.map.Map} with
 * implementations of primary methods.
 *
 * @convention <pre>
 * $this.key is a String  and
 * $this.value is an Integer
 * </pre>
 * @correspondence this = [value of $this]
 */
public class Tracker1L extends TrackerSecondary {

    /**
     * representation of {@code this}.
     */
    private Map1L<String, Integer> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.rep = new Map1L<String, Integer>();

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Tracker1L() {

        this.createNewRep();

    }

    /**
     * Constructor with initial values.
     *
     * @param args
     *            {@code String}s to initialize from
     */
    public Tracker1L(String... args) {

        this.createNewRep();
        for (int i = 0; i < args.length; i++) {
            assert !this.rep.hasKey(
                    args[i]) : "Violation of entries in args are unique";
            this.rep.add(args[i], 0);
        }

    }

    /*
     * Standard Methods --------------------------------------------------------
     */

    @Override
    public final Tracker newInstance() {
        return new Tracker1L();
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Tracker source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Tracker1L : ""
                + "Violation of: source is of dynamic type Tracker1";

        Tracker1L localSource = (Tracker1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel Methods ----------------------------------------------------------
     */

    @Override
    public final void setValue(String name, int value) {
        assert name != null : "Violation of: name is not null";

        if (this.rep.hasKey(name)) {
            this.rep.replaceValue(name, value);
        } else {
            this.rep.add(name, value);
        }
    }

    @Override
    public final int size() {

        return this.rep.size();
    }

    @Override
    public final int value(String name) {
        assert this.rep.hasKey(name) : "Violation of name is in DOMAIN(this)";

        return this.rep.value(name);
    }

    @Override
    public final int remove(String name) {
        assert name != null : "Violation of: key is not null";
        assert this.rep.hasKey(name) : "Violation of: key is in DOMAIN(this)";

        return this.rep.remove(name).value();
    }

    @Override
    public final Map.Pair<String, Integer> removeAny() {
        assert this.size() > 0 : "Violation of: this is not empty";

        return this.rep.removeAny();
    }

    @Override
    public final boolean contains(String name) {
        assert name != null : "Violation of: name is not null";

        return this.rep.hasKey(name);
    }

    @Override
    public final Iterator<Pair<String, Integer>> iterator() {
        return new Tracker1LIterator();
    }

    /**
     * Implementation of {@code Iterator} interface for {@code Tracker1L}.
     */
    public final class Tracker1LIterator
            implements Iterator<Pair<String, Integer>> {

        /**
         * Representation iterator.
         */
        private final Iterator<components.map.Map.Pair<String, Integer>> iterator;

        /**
         * No-argument constructor.
         */
        private Tracker1LIterator() {
            this.iterator = Tracker1L.this.rep.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public Pair<String, Integer> next() {
            assert this.hasNext() : "Violation of: ~this.unseen /= <>";
            if (!this.hasNext()) {
                /*
                 * Exception is supposed to be thrown in this case, but with
                 * assertion-checking enabled it cannot happen because of assert
                 * above.
                 */
                throw new NoSuchElementException();
            }
            components.map.Map.Pair<String, Integer> entry = this.iterator
                    .next();
            return entry;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove operation not supported");
        }

    }
}