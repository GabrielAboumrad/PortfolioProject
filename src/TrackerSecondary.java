import components.map.Map;

/**
 * Layered implementations of secondary methods for {@code Map}.
 */
public abstract class TrackerSecondary extends Object implements Tracker {

    @Override
    public int toZero(String name) {
        int original = this.value(name);
        this.setValue(name, 0);
        return original;
    }

    @Override
    public void add(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original + n);
    }

    @Override
    public void subtract(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original - n);
    }

    @Override
    public void multiply(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original * n);
    }

    @Override
    public void divide(String name, int n) {
        int original = this.value(name);
        this.setValue(name, original / n);
    }

    @Override
    public void power(String name, int n) {
        int original = this.value(name);
        this.setValue(name, (int) Math.pow(original, n));
    }

    @Override
    public void root(String name, int n) {
        int original = this.value(name);
        this.setValue(name, (int) Math.pow(original, 1 / n));
    }

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

    @Override
    public String toString() {

        String result = "{";

        for (Map.Pair<String, Integer> item : this) {

            result += "(" + item.key() + ", " + item.value().toString() + "), ";
        }

        result += "}";

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        boolean equal = true;

        if (this == obj) {
            equal = true;
        } else if (obj == null) {
            equal = false;
        } else if (!(obj instanceof Tracker)) {
            equal = false;
        } else {

            Tracker t = (Tracker) obj;

            if (this.size() != t.size()) {
                equal = false;
            } else {
                for (Map.Pair<String, Integer> item : this) {
                    if (!t.contains(item.key()) && equal) {
                        equal = false;
                    } else if (t.value(item.key()) != (item.value()) && equal) {
                        equal = false;
                    }
                }
            }
        }

        return equal;
    }
}
