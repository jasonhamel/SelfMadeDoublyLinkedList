import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNewDoublyLinkedList {
    NewDoublyLinkedList<Integer> nbll;

    @Before
    public void setup() {
        nbll = new NewDoublyLinkedList<>();
    }

    @Test
    public void testAppend() {
        nbll.append(45);
        nbll.append(98);
        nbll.append(123);
        Assert.assertEquals(45, (int)nbll.getAtIndex(0).getValue());
        Assert.assertEquals(98, (int)nbll.getAtIndex(1).getValue());
        Assert.assertEquals(123, (int)nbll.getAtIndex(2).getValue());
        Assert.assertEquals(3, nbll.getLength());
    }

    @Test
    public void testPrepend() {
        nbll.prepend(45);
        nbll.prepend(98);
        nbll.prepend(123);
        Assert.assertEquals(45, (int)nbll.getAtIndex(2).getValue());
        Assert.assertEquals(98, (int)nbll.getAtIndex(1).getValue());
        Assert.assertEquals(123, (int)nbll.getAtIndex(0).getValue());
        Assert.assertEquals(3, nbll.getLength());
    }

    @Test
    public void testRemove() {
        nbll.append(45);
        nbll.append(98);
        nbll.append(123);
        nbll.remove(0);
        Assert.assertEquals(98, (int)nbll.getAtIndex(0).getValue());
        Assert.assertEquals(123, (int)nbll.getAtIndex(1).getValue());
        nbll.remove(1);
        Assert.assertEquals(98, (int)nbll.getAtIndex(0).getValue());
        nbll.remove(3);
        Assert.assertNull(nbll.getAtIndex(1));
        nbll.remove(0);
        nbll.remove(0);
        nbll.append(45);
        nbll.append(98);
        nbll.append(123);
    }

    @Test
    public void testInsert() {
        nbll.append(45);
        nbll.append(98);
        nbll.append(123);
        Assert.assertEquals(98, (int)nbll.getAtIndex(1).getValue());
        nbll.insert(1, 75);
        Assert.assertEquals(75, (int)nbll.getAtIndex(1).getValue());
        nbll.insert(2, 99);
        Assert.assertEquals(99, (int)nbll.getAtIndex(2).getValue());
        nbll.insert(0, 24);
        Assert.assertEquals(24, (int)nbll.getAtIndex(0).getValue());
        nbll.insert(7, 700);
        nbll.insert(5, 150);
        Assert.assertEquals(150, (int)nbll.getAtIndex(5).getValue());
    }
}
