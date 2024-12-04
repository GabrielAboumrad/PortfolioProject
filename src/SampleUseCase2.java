import components.Tracker.Tracker;
import components.Tracker.Tracker1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A sample use case for the {@code Tracker} that allows the user to directly
 * edit it.
 */
public class SampleUseCase2 {

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        Tracker players = new Tracker1L();
        int option = 0;

        while (option != 6) {
            out.println("Options:");
            out.println("1: Add a player");
            out.println("2: Remove a player");
            out.println("3: Edit a player's score");
            out.println("4: Get top players");
            out.println("5: Get bottom players");
            out.println("6: Quit");

            option = in.nextInteger();

            String name = "";
            int score = 0;
            switch (option) {
                case 1:
                    out.println("Player Name: ");
                    name = in.nextLine();
                    out.println("Player Score: ");
                    score = in.nextInteger();
                    players.setValue(name, score);
                    break;

                case 2:
                    out.println("Player Name: ");
                    name = in.nextLine();
                    score = players.remove(name);
                    out.println(name + " final score: " + score);
                    break;

                case 3:
                    out.println("Player Name: ");
                    name = in.nextLine();
                    out.println("What would you like to do?");
                    out.println("+, -, *, /, ^");
                    char operation = in.nextLine().toCharArray()[04];
                    out.println("By how much?");
                    int c = in.nextInteger();

                    switch (operation) {
                        case '+':
                            players.add(name, c);
                            break;
                        case '-':
                            players.subtract(name, c);
                            break;
                        case '*':
                            players.multiply(name, c);
                            break;
                        case '/':
                            players.divide(name, c);
                            break;
                        case '^':
                            players.power(name, c);
                            break;
                        default:
                            out.println("Not a valid Operation");
                            break;
                    }
                    break;

                case 4:
                    out.println(players.highest().toString());
                    break;
                case 5:
                    out.println(players.lowest().toString());
                    break;
                default:
                    break;
            }

        }
    }
}
