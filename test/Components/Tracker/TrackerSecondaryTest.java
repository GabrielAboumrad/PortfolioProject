package Components.Tracker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.Tracker.Tracker;
import components.Tracker.Tracker1L;

/**
 * JUnit test fixture for {@code Tracker}'s secondary methods.
 *
 * @author Gabriel Aboumrad
 */
public class TrackerSecondaryTest {

    @Test
    public void testToZero0() {
        Tracker test = new Tracker1L("one");
        test.toZero("one");

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testToZero1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);
        test.toZero("one");

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testToZeroLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);
        test.toZero("one");

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testAdd0() {
        Tracker test = new Tracker1L("one");
        test.add("one", 0);

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testAdd1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);
        test.add("one", 1);

        assertEquals(2, test.value("one"));
    }

    @Test
    public void testAddLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);
        test.add("one", 3);

        assertEquals(6, test.value("one"));
    }

    @Test
    public void testSubtract0() {
        Tracker test = new Tracker1L("one");
        test.subtract("one", 0);

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testSubtract1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);
        test.subtract("one", 1);

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testSubtractLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);
        test.subtract("one", 3);

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testMultiply0() {
        Tracker test = new Tracker1L("one");
        test.multiply("one", 0);

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testMultiply1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);
        test.multiply("one", 1);

        assertEquals(1, test.value("one"));
    }

    @Test
    public void testMultiplyLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);
        test.multiply("one", 3);

        assertEquals(9, test.value("one"));
    }

    @Test
    public void testDivide0() {
        Tracker test = new Tracker1L("one");
        test.divide("one", 1);

        assertEquals(0, test.value("one"));
    }

    @Test
    public void testDivide1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);
        test.divide("one", 1);

        assertEquals(1, test.value("one"));
    }

    @Test
    public void testDivideLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);
        test.divide("one", 3);

        assertEquals(1, test.value("one"));
    }

    @Test
    public void testPower0() {
        Tracker test = new Tracker1L("one");
        test.power("one", 0);

        assertEquals(1, test.value("one"));
    }

    @Test
    public void testPower1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);
        test.power("one", 1);

        assertEquals(1, test.value("one"));
    }

    @Test
    public void testPowerLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);
        test.power("one", 3);

        assertEquals(27, test.value("one"));
    }

    @Test
    public void testRoot2() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 4);
        test.root("one", 2);

        assertEquals(2, test.value("one"));
    }

    @Test
    public void testRootLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 27);
        test.root("one", 3);

        assertEquals(3, test.value("one"));
    }

    @Test
    public void testHighestOneEntry0() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L("one");
        Tracker result = test.highest();

        assertEquals(expected, result);
    }

    @Test
    public void testHighestOneEntry1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);
        Tracker expected = new Tracker1L("one");
        expected.setValue("one", 1);
        Tracker result = test.highest();

        assertEquals(expected, result);
    }

    @Test
    public void testHighestOneEntryLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);
        Tracker expected = new Tracker1L("one");
        expected.setValue("one", 3);
        Tracker result = test.highest();

        assertEquals(expected, result);
    }

    @Test
    public void testHighestManyEntry0() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker expected = new Tracker1L("one", "two", "three");
        Tracker result = test.highest();

        assertEquals(expected, result);
    }

    @Test
    public void testHighestManyEntry1() {
        Tracker test = new Tracker1L("one", "two", "three");
        test.setValue("one", 1);
        Tracker expected = new Tracker1L("one");
        expected.setValue("one", 1);
        Tracker result = test.highest();

        assertEquals(expected, result);
    }

    @Test
    public void testHighestManyEntryLarge() {
        Tracker test = new Tracker1L("one", "two", "three");
        test.setValue("one", 3);
        test.setValue("two", 3);
        Tracker expected = new Tracker1L("one", "two");
        expected.setValue("one", 3);
        Tracker result = test.highest();

        assertEquals(expected, result);
    }

    @Test
    public void testLowestOneEntry0() {
        Tracker test = new Tracker1L("one");
        Tracker expected = new Tracker1L("one");
        Tracker result = test.lowest();

        assertEquals(expected, result);
    }

    @Test
    public void testLowestOneEntry1() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 1);
        Tracker expected = new Tracker1L("one");
        expected.setValue("one", 1);
        Tracker result = test.lowest();

        assertEquals(expected, result);
    }

    @Test
    public void testLowestOneEntryLarge() {
        Tracker test = new Tracker1L("one");
        test.setValue("one", 3);
        Tracker expected = new Tracker1L("one");
        expected.setValue("one", 3);
        Tracker result = test.lowest();

        assertEquals(expected, result);
    }

    @Test
    public void testLowestManyEntry0() {
        Tracker test = new Tracker1L("one", "two", "three");
        Tracker expected = new Tracker1L("one", "two", "three");
        Tracker result = test.lowest();

        assertEquals(expected, result);
    }

    @Test
    public void testLowestManyEntry1() {
        Tracker test = new Tracker1L("one", "two", "three");
        test.setValue("one", 1);
        test.setValue("two", 2);
        test.setValue("three", 2);
        Tracker expected = new Tracker1L("one");
        expected.setValue("one", 1);
        Tracker result = test.lowest();

        assertEquals(expected, result);
    }

    @Test
    public void testLowestManyEntryLarge() {
        Tracker test = new Tracker1L("one", "two", "three");
        test.setValue("one", 3);
        test.setValue("two", 3);
        test.setValue("three", 4);
        Tracker expected = new Tracker1L("one", "two");
        test.setValue("one", 3);
        expected.setValue("two", 3);
        Tracker result = test.lowest();

        assertEquals(expected, result);
    }

    @Test
    public void testToStringEmpty() {
        Tracker test = new Tracker1L();

        assertEquals("{}", test.toString());
    }

    @Test
    public void testToStringOneEntry() {
        Tracker test = new Tracker1L("one");

        assertEquals("{(one: 0)}", test.toString());
    }

    @Test
    public void testToStringManyEntry() {
        Tracker test = new Tracker1L("one", "two", "three");
        test.setValue("two", 1);
        test.setValue("three", 2);

        assertEquals("{(one: 0), (two: 1), (three: 2)}", test.toString());
    }

    @Test
    public void testEqualsTrueEmpty() {
        Tracker test1 = new Tracker1L();
        Tracker test2 = new Tracker1L();

        assertEquals(true, test1.equals(test2));
    }

    @Test
    public void testEqualsTrueOneEntry() {
        Tracker test1 = new Tracker1L("one");
        Tracker test2 = new Tracker1L("one");

        assertEquals(true, test1.equals(test2));
    }

    @Test
    public void testEqualsTrueManyEntry() {
        Tracker test1 = new Tracker1L("one", "two", "three");
        Tracker test2 = new Tracker1L("one", "two", "three");

        assertEquals(true, test1.equals(test2));
    }

    @Test
    public void testEqualsFalseOneEntry() {
        Tracker test1 = new Tracker1L("one");
        Tracker test2 = new Tracker1L("two");

        assertEquals(false, test1.equals(test2));
    }

    @Test
    public void testEqualsFalseManyEntry() {
        Tracker test1 = new Tracker1L("one", "two", "three");
        Tracker test2 = new Tracker1L("one", "two", "four");

        assertEquals(false, test1.equals(test2));
    }
}
