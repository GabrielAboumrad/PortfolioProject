import components.map.Map1L;
import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A statistic tracker proof of concept represented as a {@code Map}.
 */
public class Tracker {

    /**
     * representation of {@code this}.
     */
    private Map1L<String, Integer> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.rep = new Map1L<>();

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Tracker() {

        this.createNewRep();

    }

    /**
     * Constructor with initial values.
     *
     * @param args
     *            {@code String}s to initialize from
     */
    public Tracker(String... args) {

        this.createNewRep();
        for (int i = 0; i < args.length; i++) {
            assert !this.rep.hasKey(
                    args[i]) : "Violation of entries in args are unique";
            this.rep.add(args[i], 0);
        }

    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    /**
     * Sets the value of a statistic, and adds it to the Tracker if it is not
     * already included.
     *
     * @param name
     *            The name of the statistic
     *
     * @param value
     *            The value of the statistic
     */
    public final void setValue(String name, int value) {

        if (this.rep.hasKey(name)) {
            this.rep.replaceValue(name, value);
        } else {
            this.rep.add(name, value);
        }
    }

    /**
     * Reports the size of {@code this}.
     *
     * @return The size of this
     */
    public final int size() {

        return this.rep.size();
    }

    /**
     * Reports the value assosiated with name.
     *
     * @return The size of this
     * @param name
     *            The name of the statistic to report the value of
     */
    public final int value(String name) {
        assert this.rep.hasKey(name) : "Violation of name is in this";

        return this.rep.value(name);
    }

    /*
     * Secondary methods--------------------------------------------------------
     */

    /**
     * Adds a number to the value of a statistic.
     *
     * @param name
     *            The name of the desired statistic
     * @param n
     *            The number to add
     */
    public final void add(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original + n);
    }

    /**
     * Sets the value of a statistic to 0 and returns the previous value.
     *
     * @return The orginal value of the statistic
     * @param name
     *            The name of the desired statistic
     */
    public final int toZero(String name) {

        int original = this.value(name);
        this.setValue(name, 0);
        return original;
    }

    /**
     * Demonstration of Tracker component.
     *
     * @param args
     */
    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //get players
        out.println("Name of contestant 1: ");
        String p1 = in.nextLine();
        out.println("Name of contestant 2: ");
        String p2 = in.nextLine();
        out.println("Number of rounds: ");
        int rounds = in.nextInteger();

        //create win tracker
        Tracker wins = new Tracker(p1, p2);

        boolean replay = true;
        while (replay) {

            //create score tracker
            Tracker score = new Tracker(p1, p2);

            //play game
            for (int i = 1; i <= rounds; i++) {
                Random rand = new Random1L();
                score.add(p1, rand.nextInt() / 100000);
                score.add(p2, rand.nextInt() / 100000);

                out.println("\nScore after round " + i + ": ");
                out.println(p1 + ": " + score.value(p1));
                out.println(p2 + ": " + score.value(p2));

            }

            //final score and reset
            if (score.value(p1) > score.value(p2)) {
                out.println("\nWinner: " + p1);
                wins.add(p1, 1);
            } else if (score.value(p1) < score.value(p2)) {
                out.println("\nWinner: " + p2);
                wins.add(p2, 1);
            } else {
                out.println("\nThe game is a draw");
            }
            out.println("\nFinal Score: ");
            out.println(p1 + ": " + score.toZero(p1));
            out.println(p2 + ": " + score.toZero(p2));
            out.println("\nGame reset");

            out.println("\nTotal Record: ");
            out.println(p1 + ": " + wins.value(p1));
            out.println(p2 + ": " + wins.value(p2));

            out.println("\nType 'Q' to quit: ");
            String response = in.nextLine();
            if (response.equals("Q") || response.equals("q")) {
                replay = false;
            }
        }

        in.close();
        out.close();
    }
}
