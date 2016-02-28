import DoublyLinkedList.Dlist;
import DoublyLinkedList.DlistImpl;
import DoublyLinkedList.NullNodeException;
import org.junit.*;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    Dlist dlist;

    @BeforeClass
    public static void before() {

    }

    @Before
    public  void beforeEachTest() {
        dlist=new DlistImpl<String>();
    }

    @After
    public  void afterEachTest() {

    }

    @Test
    public void testCount() throws NullNodeException {
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");
        dlist.insertEnd("5");
        int expected=5;
        int actual=dlist.getSize();
        assertEquals(expected,actual);
    }

    @Test
    public void testRemoveFirst() throws NullNodeException {
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");
        dlist.insertEnd("5");
        dlist.removeFirst();
        String expected="2";
        String actual=dlist.front().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveLast() throws NullNodeException {
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");
        dlist.insertEnd("5");
        dlist.removeLast();
        String expected="4";
        String actual=dlist.back().toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertFront() throws NullNodeException {
        dlist.insertFront("3");
        dlist.insertFront("2");
        dlist.insertFront("1");

        String expected="3";
        String actual=dlist.back().toString();
        assertEquals(expected, actual);

        expected="1";
        actual=dlist.front().toString();
        assertEquals(expected, actual);


    }

    @Test
    public void testInsertAt() throws NullNodeException {
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("5");

        dlist.insertAt(3, "4");

        String expected="4";
        String actual=dlist.get(3).toString();
        assertEquals(expected, actual);

    }

    @Test
    public void testRemoveAt() throws NullNodeException {
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");

        dlist.removeAt(2);

        String expected="4";
        String actual=dlist.get(2).toString();
        assertEquals(expected, actual);

    }

    @Test
    public void testIterator() throws NullNodeException {
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");

        String[] s=new String[]{"1","2","3","4"};
        int stringNum=0;

        for(Object d:dlist)
        {
            String expected=s[stringNum];
            String actual=d.toString();
            assertEquals(expected, actual);
            stringNum++;
        }
    }



    @AfterClass
    public static void after() {

    }

}
