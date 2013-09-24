package liana;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: lia
 * Date: 24.09.13
 * Time: 22:22
 * To change this template use File | Settings | File Templates.
 */
public class TelephoneDirectoryTest {

    public static final String NICKNAME = "sherbakov";

    @Test
    public void testAddAndGet() {
        TelephoneDirectory td = new TelephoneDirectory();
        boolean result = td.add(NICKNAME, new Entry("Sherbakov A.V.", "+79112348980"));
        assertTrue(result);
        result = td.add(NICKNAME, new Entry("Sherbakov A.V.", "+791123482330"));
        assertFalse(result);
        Entry entry = td.get(NICKNAME);
        assertNotNull(entry);
    }

    @Test
    public void testNotExistingGet() {
        TelephoneDirectory td = new TelephoneDirectory();
        Entry res = td.get(NICKNAME);
        assertNull(res);
    }

    @Test
    public void testDelete() {
        TelephoneDirectory td = new TelephoneDirectory();
        td.add(NICKNAME, new Entry("Sherbakov A.V.", "+791123482330"));
        boolean res  = td.delete(NICKNAME);
        assertTrue(res);
        assertFalse(td.delete(NICKNAME));
        assertNull(td.get(NICKNAME));
    }

    @Test
    public void testUpdate() {
        TelephoneDirectory td = new TelephoneDirectory();
        td.add(NICKNAME, new Entry("Sherbakov A.V.", "0"));
        boolean res = td.update(NICKNAME, new Entry("Sherbakov A.V.", "1"));
        assertTrue(res);
        Entry entry = td.get(NICKNAME);
        assertNotSame(entry.getTelephoneNumber(), "0");
        assertEquals(entry.getTelephoneNumber(), "1");
        assertFalse(td.update("veselkov", new Entry("Veselkov I.D.", "+1")));
    }
}

