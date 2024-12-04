import components.Tracker.Tracker;
import components.Tracker.Tracker1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A sample use case for the {@code Tracker} that keeps tennis score.
 */
public class SampleUseCase1 {

    public static void main(String[] args) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        //get players
        out.println("Name of contestant 1: ");
        String p1 = in.nextLine();
        out.println("Name of contestant 2: ");
        String p2 = in.nextLine();

        //create trackers
        Tracker points = new Tracker1L(p1, p2);
        Tracker advantage = new Tracker1L(p1, p2);
        Tracker games = new Tracker1L(p1, p2);
        Tracker sets = new Tracker1L(p1, p2);

        //continue match until a player wins 2 sets
        while (sets.highest().removeAny().value() < 2) {
            //continue set until a player wins 6 games by two, or wins 7 games
            while ((games.highest().removeAny().value() < 6)
                    || (games.highest().removeAny().value() < 7
                            && games.lowest().removeAny().value() > 4)) {
                //continue game until a player wins 4 points or the player with
                //advantage wins a point
                while ((points.highest().removeAny().value() < 41
                        && (points.lowest().removeAny().value() < 41))
                        && (advantage.highest().removeAny().value()
                                - advantage.lowest().removeAny().value() < 2)) {

                    //award points
                    out.println("Did contestant 1 or 2 win this point?");
                    int thisPoint = in.nextInteger();
                    if (thisPoint == 1) {
                        switch (points.value(p1)) {
                            case 0:
                            case 15:
                                points.add(p1, 15);
                                out.println("Points: " + points.toString());
                                break;
                            case 30:
                                points.add(p1, 10);
                                out.println("Points: " + points.toString());
                                break;
                            default:
                                if (points.value(p1) == 40
                                        && points.value(p2) < 40) {
                                    points.add(p1, 1);
                                } else {
                                    advantage.add(p1, 1);
                                    if (advantage.highest().removeAny()
                                            .value() == advantage.lowest()
                                                    .removeAny().value()) {
                                        out.println("No player has advantage.");
                                    } else {
                                        out.println(advantage.highest()
                                                .removeAny().key()
                                                + " has the advantage.");
                                    }
                                }
                                break;
                        }
                    } else if (thisPoint == 2) {
                        switch (points.value(p2)) {
                            case 0:
                            case 15:
                                points.add(p2, 15);
                                out.println("Points: " + points.toString());
                                break;
                            case 30:
                                points.add(p2, 10);
                                out.println("Points: " + points.toString());
                                break;
                            default:
                                if (points.value(p2) == 40
                                        && points.value(p1) < 40) {
                                    points.add(p2, 1);
                                } else {
                                    advantage.add(p2, 1);
                                    if (advantage.highest().removeAny()
                                            .value() == advantage.lowest()
                                                    .removeAny().value()) {
                                        out.println("No player has advantage.");
                                    } else {
                                        out.println(advantage.highest()
                                                .removeAny().key()
                                                + " has the advantage.");
                                    }
                                }
                                break;
                        }
                    } else {
                        out.println("Please enter 1 or 2.");
                    }

                }

                //track game winner
                if (points.value(p1) > points.value(p2)) {
                    games.add(p1, 1);
                    out.println(p1 + " won this game.");
                } else if (points.value(p1) < points.value(p2)) {
                    games.add(p2, 1);
                    out.println(p2 + " won this game.");
                } else if (advantage.value(p1) > advantage.value(p2)) {
                    games.add(p1, 1);
                    out.println(p1 + " won this game.");
                } else if (advantage.value(p1) < advantage.value(p2)) {
                    games.add(p2, 1);
                    out.println(p2 + " won this game.");
                }
                out.println("Games: " + games.toString());

                //clear points and advantages
                points.toZero(p1);
                points.toZero(p2);
                advantage.toZero(p1);
                advantage.toZero(p2);

            }

            //track set winner
            if (games.value(p1) > games.value(p2)) {
                sets.add(p1, 1);
                out.println(p1 + " won this set.");
            } else if (games.value(p1) < games.value(p2)) {
                sets.add(p2, 1);
                out.println(p2 + " won this set.");
            }
            out.println("Sets: " + sets.toString());

            //clear games
            games.toZero(p1);
            games.toZero(p2);

        }

        if (sets.value(p1) > sets.value(p2)) {
            out.println(p1 + " has won the match!");
        } else if (sets.value(p1) < sets.value(p2)) {
            out.println(p2 + " has won the match!");
        }

        in.close();
        out.close();
    }
}
