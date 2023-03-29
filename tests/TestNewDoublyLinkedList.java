import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNewDoublyLinkedList {
    NewDoublyLinkedList<Integer> ndll;

    @Before
    public void setup() {
        ndll = new NewDoublyLinkedList<>();
    }

    @Test
    public void testAppend() {
        ndll.append(45);
        ndll.append(98);
        ndll.append(123);
        Assert.assertEquals(45, (int) ndll.getAtIndex(0).getValue());
        Assert.assertEquals(98, (int) ndll.getAtIndex(1).getValue());
        Assert.assertEquals(123, (int) ndll.getAtIndex(2).getValue());
        Assert.assertEquals(3, ndll.getLength());
    }

    @Test
    public void testPrepend() {
        ndll.prepend(45);
        ndll.prepend(98);
        ndll.prepend(123);
        Assert.assertEquals(45, (int) ndll.getAtIndex(2).getValue());
        Assert.assertEquals(98, (int) ndll.getAtIndex(1).getValue());
        Assert.assertEquals(123, (int) ndll.getAtIndex(0).getValue());
        Assert.assertEquals(3, ndll.getLength());
    }

    @Test
    public void testRemove() {
        ndll.append(45);
        ndll.append(98);
        ndll.append(123);
        ndll.remove(0);
        Assert.assertEquals(98, (int) ndll.getAtIndex(0).getValue());
        Assert.assertEquals(123, (int) ndll.getAtIndex(1).getValue());
        ndll.remove(1);
        Assert.assertEquals(98, (int) ndll.getAtIndex(0).getValue());
        ndll.remove(3);
        Assert.assertNull(ndll.getAtIndex(1));
        ndll.remove(0);
        ndll.remove(0);
        ndll.append(45);
        ndll.append(98);
        ndll.append(123);
    }

    @Test
    public void testInsert() {
        ndll.append(45);
        ndll.append(98);
        ndll.append(123);
        Assert.assertEquals(98, (int) ndll.getAtIndex(1).getValue());
        ndll.insert(1, 75);
        Assert.assertEquals(75, (int) ndll.getAtIndex(1).getValue());
        ndll.insert(2, 99);
        Assert.assertEquals(99, (int) ndll.getAtIndex(2).getValue());
        ndll.insert(0, 24);
        Assert.assertEquals(24, (int) ndll.getAtIndex(0).getValue());
        ndll.insert(7, 700);
        ndll.insert(5, 150);
        Assert.assertEquals(150, (int) ndll.getAtIndex(5).getValue());
    }
}
