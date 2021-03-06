package seedu.multitasky.model.entry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

// @@author A0126623L
public class NameTest {

    @Test
    public void isValidName_variousNames_success() {
        // invalid name
        assertFalse(Name.isValidName("")); // empty string
        assertFalse(Name.isValidName(" ")); // spaces only
        assertFalse(Name.isValidName("^")); // only non-alphanumeric characters
        assertFalse(Name.isValidName("/test")); // non-alphanumeric as first character

        // valid name
        assertTrue(Name.isValidName("abc")); // joined alphabets only
        assertTrue(Name.isValidName("peter jack")); // alphabets with space
        assertTrue(Name.isValidName("peter jack ")); // trailing whitespace
        assertTrue(Name.isValidName("12345")); // numbers only
        assertTrue(Name.isValidName("peter the 2nd")); // alphanumeric characters
        assertTrue(Name.isValidName("Capital Tan")); // with capital letters
        assertTrue(Name.isValidName("David Roger Jackson Ray Jr 2nd")); // long names
        assertTrue(Name.isValidName("peter$")); // contains currency sign
        assertTrue(Name.isValidName("peter?.,")); // punctuation marks
        assertTrue(Name.isValidName("peter? . , / * &")); // punctuation marks with space characters
    }

    @Test
    public void equalsTest() {

        // initialize
        try {
            Name name1 = new Name("Jim");
            Name name2 = new Name("Jim");
            Name name3 = new Name("Jane");

            // equality
            assertTrue(name1.equals(name2)); // Meaningfully equal

            // inequality
            assertFalse(name1 == name3);
            assertFalse(name1.equals(name3));

        } catch (Exception e) {
            fail("Invalid name used in test.");
        }
    }
}
