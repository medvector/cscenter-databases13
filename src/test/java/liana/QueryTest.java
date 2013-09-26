package liana;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: lia
 * Date: 26.09.13
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
public class QueryTest {
    @Test(expected = IllegalArgumentException.class)
    public void parseEmptyTest() {
        Query.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseOneWordTest() {
        Query.parse("add");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseWrongOperationTest() {
        Query.parse("got dfdff");
    }

    @Test
    public void parseCorrectAddTest() {
        Query query = Query.parse("add ivanov Ivanov Ivan Ivanovich 8911973728");
        assertEquals(query.getKey(), "ivanov");
        assertEquals(query.getType(), Query.Type.ADD);
        assertEquals(query.getEntry().getTelephoneNumber(), "8911973728");
        assertEquals(query.getEntry().getFullName(), "Ivanov Ivan Ivanovich");
    }

    @Test
    public void parseCorrectGetTest() {
        Query query = Query.parse("get ivanov");
        assertEquals(query.getKey(), "ivanov");
        assertEquals(query.getType(), Query.Type.GET);
        assertNull(query.getEntry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseWrongArgumentsUpdateTest() {
        Query.parse("update ivanov");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseWrongArgumentsGetTest() {
        Query.parse("get ivanov 909090");
    }
}
