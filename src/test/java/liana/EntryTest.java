package liana;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: medeja
 * Date: 26.09.13
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
public class EntryTest {

    @Test(expected = IllegalArgumentException.class)
    public void parseEmptyLine() {
        Entry.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseShortLine() {
        Entry.parse("0089483959");
    }

    @Test
    public void parseCorrectEntry() {
        Entry entry = Entry.parse("Ivanova Maria Ivanovna 91134797989");
        assertEquals("Ivanova Maria Ivanovna", entry.getFullName());
        assertEquals("91134797989", entry.getTelephoneNumber());
    }

}
