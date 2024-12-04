package Components.Tracker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.Tracker.Tracker;
import components.Tracker.Tracker1L;
import components.map.Map;

/**
 * JUnit test fixture for {@code Tracker}'s standard and kernel methods.
 *
 * @author Gabriel Aboumrad
 */
public abstract class Tracker1LTest {

    @Test
    public void testNewInstanceEmpty() {
        Tracker test = new Tracker1L();
        Tracker testCopy = new Tracker1L();
        Tracker expected = new Tracker1L();
        Tracker newInstance = test.newInstance();

        assertEquals(testCopy, test);
        assertEquals(expected, newInstance);
    }

    @Test
    public void testNewInstanceOneEntry() {
        Tracker test = new Tracker1L("one");
        Tracker testCopy = new Tracker1L("one");
        Tracker expected = new Tracker1L();
        Tracker newInstance = test.newInstance();

        assertEquals(testCopy, test);
        assertEquals(expected, newInstance);
    }

    @Test
    public void testNewInstanceManyEntries() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker testCopy = new Tracker1L("one", "two", "three");
        Tracker expected = new Tracker1L();
        Tracker newInstance = test.newInstance();

        assertEquals(testCopy, test);
        assertEquals(expected, newInstance);
    }

    @Test
    public void testClearEmpty() {
        Tracker test = new Tracker1L();
        Tracker expected = new Tracker1L();
        test.clear();

        assertEquals(expected, test);
    }

    @Test
    public void testClearOneEntry() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L();
        test.clear();

        assertEquals(expected, test);
    }

    @Test
    public void testClearManyEntries() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker expected = new Tracker1L();
        test.clear();

        assertEquals(expected, test);
    }

    @Test
    public void testTransferFromEmptyToEmpty() {
        Tracker test = new Tracker1L();
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L();
        Tracker transferred = new Tracker1L();

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testTransferFromEmptyToOne() {
        Tracker test = new Tracker1L();
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L();
        Tracker transferred = new Tracker1L("one");

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testTransferFromEmptyToMany() {
        Tracker test = new Tracker1L();
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L();
        Tracker transferred = new Tracker1L("one", "two", "three");

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testTransferFromOneToEmpty() {
        Tracker test = new Tracker1L("one");
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L("one");
        Tracker transferred = new Tracker1L();

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testTransferFromOneToOne() {
        Tracker test = new Tracker1L("one");
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L("one");
        Tracker transferred = new Tracker1L("one");

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testTransferFromOneToMany() {
        Tracker test = new Tracker1L("one");
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L("one");
        Tracker transferred = new Tracker1L("one", "two", "three");

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testTransferFromManyToEmpty() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L("one", "two", "three");
        Tracker transferred = new Tracker1L();

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testTransferFromManyToOne() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L("one", "two", "three");
        Tracker transferred = new Tracker1L("one");

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testTransferFromManyToMany() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker empty = new Tracker1L();
        Tracker expected = new Tracker1L("one", "two", "three");
        Tracker transferred = new Tracker1L("one", "two", "three");

        assertEquals(expected, transferred);
        assertEquals(test, empty);
    }

    @Test
    public void testsetValueEmpty0() {
        Tracker test = new Tracker1L();
        Tracker expected = new Tracker1L("one");
        test.setValue("one", 0);

        assertEquals(expected, test);
        assertEquals(0, test.value("one"));
    }

    @Test
    public void testsetValueEmpty1() {
        Tracker test = new Tracker1L();
        Tracker expected = new Tracker1L("one");
        test.setValue("one", 1);
        expected.setValue("one", 1);

        assertEquals(expected, test);
        assertEquals(1, test.value("one"));
    }

    @Test
    public void testsetValueEmptyLarge() {
        Tracker test = new Tracker1L();
        Tracker expected = new Tracker1L("one");
        test.setValue("one", 3);
        expected.setValue("one", 3);

        assertEquals(expected, test);
        assertEquals(3, test.value("one"));
    }

    @Test
    public void testsetValueOneEntryContains0() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L("one");
        test.setValue("one", 0);

        assertEquals(expected, test);
        assertEquals(0, test.value("one"));
    }

    @Test
    public void testsetValueOneEntryContains1() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L("one");
        test.setValue("one", 1);
        expected.setValue("one", 1);

        assertEquals(expected, test);
        assertEquals(1, test.value("one"));
    }

    @Test
    public void testsetValueOneEntryContainsLarge() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L("one");
        test.setValue("one", 3);
        expected.setValue("one", 3);

        assertEquals(expected, test);
        assertEquals(3, test.value("one"));
    }

    @Test
    public void testsetValueOneEntryNotContains0() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L("one", "two");
        test.setValue("two", 0);

        assertEquals(expected, test);
        assertEquals(0, test.value("two"));
    }

    @Test
    public void testsetValueOneEntryNotContains1() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L("one", "two");
        test.setValue("two", 1);
        expected.setValue("two", 1);

        assertEquals(expected, test);
        assertEquals(1, test.value("two"));
    }

    @Test
    public void testsetValueOneEntryNotContainsLarge() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L("one", "two");
        test.setValue("two", 3);
        expected.setValue("two", 3);

        assertEquals(expected, test);
        assertEquals(3, test.value("two"));
    }

    @Test
    public void testsetValueManyEntryContains0() {
        Tracker test = new Tracker1L("one", "two");
        Tracker expected = new Tracker1L("one", "two");
        test.setValue("two", 0);

        assertEquals(expected, test);
        assertEquals(0, test.value("two"));
    }

    @Test
    public void testsetValueManyEntryContains1() {
        Tracker test = new Tracker1L("one", "two");
        Tracker expected = new Tracker1L("one", "two");
        test.setValue("two", 1);
        expected.setValue("two", 1);

        assertEquals(expected, test);
        assertEquals(1, test.value("two"));
    }

    @Test
    public void testsetValueManyEntryContainsLarge() {
        Tracker test = new Tracker1L("one", "two");
        Tracker expected = new Tracker1L("one", "two");
        test.setValue("two", 3);
        expected.setValue("two", 3);

        assertEquals(expected, test);
        assertEquals(3, test.value("two"));
    }

    @Test
    public void testsetValueManyEntryNotContains0() {
        Tracker test = new Tracker1L("one", "two");
        Tracker expected = new Tracker1L("one", "two", "three");
        test.setValue("three", 0);

        assertEquals(expected, test);
        assertEquals(0, test.value("three"));
    }

    @Test
    public void testsetValueManyEntryNotContains1() {
        Tracker test = new Tracker1L("one", "two");
        Tracker expected = new Tracker1L("one", "two", "three");
        test.setValue("three", 1);
        expected.setValue("three", 1);

        assertEquals(expected, test);
        assertEquals(1, test.value("two"));
    }

    @Test
    public void testsetValueManyEntryNotContainsLarge() {
        Tracker test = new Tracker1L("one", "two");
        Tracker expected = new Tracker1L("one", "two", "three");
        test.setValue("three", 3);
        expected.setValue("three", 3);

        assertEquals(expected, test);
        assertEquals(3, test.value("three"));
    }

    @Test
    public void testSize0() {
        Tracker test = new Tracker1L();

        assertEquals(0, test.size());
    }

    @Test
    public void testSize1() {
        Tracker test = new Tracker1L("one");

        assertEquals(1, test.size());
    }

    @Test
    public void testSizeLarge() {
        Tracker test = new Tracker1L("one", "two", "three");

        assertEquals(3, test.size());
    }

    @Test
    public void testValue0() {
        Tracker test = new Tracker1L("one");

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testValue1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);

        assertEquals(1, test.value("one"));
    }

    @Test
    public void testValueLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);

        assertEquals(3, test.value("one"));
    }

    @Test
    public void testRemoveLeaveEmpty() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L();
        int result = test.remove("one");

        assertEquals(expected, test);
        assertEquals(0, result);
    }

    @Test
    public void testRemoveLeaveOne() {
        Tracker test = new Tracker1L("one", "two");
        Tracker expected = new Tracker1L("two");
        int result = test.remove("one");

        assertEquals(expected, test);
        assertEquals(0, result);
    }

    @Test
    public void testRemoveLeaveMany() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker expected = new Tracker1L("two", "three");
        int result = test.remove("one");

        assertEquals(expected, test);
        assertEquals(0, result);
    }

    @Test
    public void testRemoveAnyLeaveEmpty() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L();
        Map.Pair<String, Integer> result = test.removeAny();

        assertEquals(expected, test);
        assertEquals("one", result.key());
        assertEquals((Integer) 0, result.value());
    }

    @Test
    public void testRemoveAnyLeaveOne() {
        Tracker test = new Tracker1L("one", "two");
        Tracker expected = new Tracker1L("one", "two");
        Map.Pair<String, Integer> result = test.removeAny();

        assertEquals(expected, test);
    }

    @Test
    public void testRemoveAnyLeaveMany() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker expected = new Tracker1L("one", "two", "three");
        Map.Pair<String, Integer> result = test.removeAny();

        assertEquals(expected, test);
    }

    @Test
    public void testContainsEmpty() {
        Tracker test = new Tracker1L();

        assertEquals(false, test.contains("one"));
    }

    @Test
    public void testContainsTrueOne() {
        Tracker test = new Tracker1L("one");

        assertEquals(true, test.contains("one"));
    }

    @Test
    public void testContainsTrueMany() {
        Tracker test = new Tracker1L("one", "two", "three");

        assertEquals(true, test.contains("two"));
    }

    @Test
    public void testContainsFalseOne() {
        Tracker test = new Tracker1L("one");

        assertEquals(false, test.contains("two"));
    }

    @Test
    public void testContainsFalseMany() {
        Tracker test = new Tracker1L("one", "two", "three");

        assertEquals(false, test.contains("four"));
    }
}
