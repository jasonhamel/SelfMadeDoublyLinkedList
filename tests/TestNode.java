import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNode {
    Node<Integer> node;

    @Before
    public void setup() {
        node = new Node<>(5);
    }

    @Test
    public void testNode() {
        Assert.assertEquals(5, (int)node.getValue());
        Assert.assertNull(node.getNext());
        Assert.assertNull(node.getPrevious());
    }

    @Test
    public void testPrevious() {
        node.setNext(new Node<>(9));
        Assert.assertEquals(9, (int)node.getNext().getValue());
        Assert.assertNull(node.getPrevious());
        node.setPrevious(new Node<>(123));
        Assert.assertEquals(9, (int)node.getNext().getValue());
        Assert.assertEquals(123, (int)node.getPrevious().getValue());
    }
}
