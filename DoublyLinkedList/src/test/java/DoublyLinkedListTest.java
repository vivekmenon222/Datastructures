import DoublyLinkedList.Dlist;
import DoublyLinkedList.DlistImpl;
import DoublyLinkedList.NullNodeException;
import org.junit.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {

    Dlist<String> dlist;

    @BeforeClass
    public static void before() {

    }

    @Before
    public void beforeEachTest() {
        dlist = new DlistImpl<String>();
    }

    @After
    public void afterEachTest() {

    }


    @Test
    public void blahblah() throws NullNodeException {

        LinkedList<Integer> dList1 = new LinkedList<Integer>();
        LinkedList<Integer> dList2 = new LinkedList<Integer>();
        LinkedList<Integer> dListMerged = new LinkedList<Integer>();

        dList1.addLast(1);
        dList1.addLast(8);
        dList1.addLast(12);
        dList1.addLast(15);
        dList1.addLast(85);

        dList2.addLast(2);
        dList2.addLast(3);
        dList2.addLast(12);
        dList2.addLast(24);
        dList2.addLast(85);
        dList2.addLast(185);

        int i = 0;
        int y = 0;
        int dList1Size = dList1.size();
        int dList2Size = dList2.size();
        int list1Item = dList1.get(i);
        int list2Item = dList2.get(y);
        while (i < dList1Size || y < dList2Size) {

            if (i < dList1Size) {

                if (list1Item <= list2Item || y >= dList2Size) {
                    dListMerged.addLast(list1Item);
                    i++;
                    if (i < dList1Size) {
                        list1Item = dList1.get(i);
                    }
                }
            }


            if (y < dList2Size) {

                if (list2Item <= list1Item || i >= dList1Size) {
                    dListMerged.addLast(list2Item);
                    y++;
                    if (y < dList2Size) {
                        list2Item = dList2.get(y);
                    }
                }
            }

        }

        for(int x:dListMerged)
        {
            System.out.println(x);
        }

    }


    @Test
    public void testCount() throws NullNodeException {
        dlist.insertEnd("0");
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");
        dlist.insertEnd("5");
        int expected = 6;
        int actual = dlist.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveFirst() throws NullNodeException {
        dlist.insertEnd("0");
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");
        dlist.insertEnd("5");
        dlist.removeFirst();
        String expected = "1";
        String actual = dlist.front().toString();
        assertEquals(expected, actual);

        int actualSize = dlist.getSize();
        int expectedSize = 5;

        assertEquals("size corrupted in removeFirst operation", expectedSize, actualSize);
    }

    @Test
    public void testRemoveLast() throws NullNodeException {
        dlist.insertEnd("0");
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");
        dlist.insertEnd("5");
        dlist.removeLast();
        String expected = "4";
        String actual = dlist.back().toString();
        assertEquals(expected, actual);

        int actualSize = dlist.getSize();
        int expectedSize = 5;

        assertEquals("size corrupted in removeLast operation", expectedSize, actualSize);
    }

    @Test
    public void testInsertFront() throws NullNodeException {
        dlist.insertFront("3");
        dlist.insertFront("2");
        dlist.insertFront("1");

        String expected = "3";
        String actual = dlist.back().toString();
        assertEquals(expected, actual);

        expected = "1";
        actual = dlist.front().toString();
        assertEquals(expected, actual);


    }

    @Test
    public void testInsertAt() throws NullNodeException {
        dlist.insertEnd("0");
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("5");

        dlist.insertAt(4, "4");

        String expected = "4";
        String actual = dlist.get(4).toString();
        assertEquals(expected, actual);

        int actualSize = dlist.getSize();
        int expectedSize = 6;

        assertEquals("size corrupted in insertAt operation", expectedSize, actualSize);

    }

    @Test
    public void testRemoveAt() throws NullNodeException {
        dlist.insertEnd("0");
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");

        dlist.removeAt(3);

        String actual = dlist.get(3).toString();
        String expected = "4";

        assertEquals(expected, actual);

    }

    @Test
    public void testIterator() throws NullNodeException {
        dlist.insertEnd("0");
        dlist.insertEnd("1");
        dlist.insertEnd("2");
        dlist.insertEnd("3");
        dlist.insertEnd("4");

        String[] s = new String[]{"0", "1", "2", "3", "4"};
        int stringNum = 0;

        for (Object d : dlist) {
            String expected = s[stringNum];
            String actual = d.toString();
            assertEquals(expected, actual);
            stringNum++;
        }
    }

    @Test(expected = NullNodeException.class)
    public void insertAtWrongPositionThrowsError() throws NullNodeException {

        dlist.insertAt(0, "0");
        dlist.insertAt(1, "1");
        dlist.insertAt(4, "4");
    }


    @AfterClass
    public static void after() {

    }

}
