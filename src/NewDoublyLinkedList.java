public class NewDoublyLinkedList <T>{
    private int length;
    private Node<T> head;
    private Node<T> tail;

    public NewDoublyLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    public void append(T toAdd) {
        Node<T> newNode = new Node<>(toAdd);
        if (length == 0) {
            setFirstNode(newNode);
            return;
        }
        if (length == 1) {
            this.head.setNext(newNode);
            this.head.getNext().setPrevious(this.head);
            this.tail = newNode;
            length++;
            return;
        }

        this.tail.setNext(newNode);
        this.tail.getNext().setPrevious(this.tail);
        this.tail = newNode;
        length++;
    }

    public void prepend(T toAdd) {
        Node<T> newNode = new Node<>(toAdd);
        if (length == 0) {
            setFirstNode(newNode);
            return;
        }
        Node<T> formerHead = this.head;
        this.head.setPrevious(newNode);
        this.head = newNode;
        this.head.setNext(formerHead);
        length++;
    }

    public void remove(int index) {
        if (outOfBounds(index)) {
            System.out.println("Index exceeds size of list.");
            return;
        }
        if (length == 1) {
            Node<T> newNode = new Node<>(null);
            this.head = newNode;
            this.tail = newNode;
            length--;
            return;
        }

        if (index == 0) {
            this.head.getNext().setPrevious(null);
            this.head = this.head.getNext();
            length--;
            return;
        }
        if (index == length - 1) {
            tail.getPrevious().setNext(null);
            this.tail = tail.getPrevious();
            length--;
            return;
        }

        Node<T> traversalNode = traverse(index);
        assert traversalNode != null;
        traversalNode.getNext().setPrevious(traversalNode.getPrevious());
        traversalNode.getPrevious().setNext(traversalNode.getNext());
        length--;
    }

    public Node<T> getAtIndex(int index) {
        return traverse(index);
    }

    public void setFirstNode(Node<T> newNode) {
        this.head = newNode;
        this.tail = newNode;
        length++;
    }

    private Node<T> traverse(int index) {
        Node<T> traversalNode = this.head;
        if (index > length - 1) {
            System.out.println("Index exceeds size of list.");
            return null;
        }
        if (index == 0) {
            return this.head;
        }
        if (index == length - 1) {
            return this.tail;
        }
        for (int i = 0; i < index + 1; i++) {
            if (i == index) {
                return traversalNode;
            }
            traversalNode = traversalNode.getNext();
        }
        return null;
    }

    public int getLength() {
        return this.length;
    }

    private boolean outOfBounds(int index) {
        if (length == 1 && index > 0) {
            System.out.println("Index exceeds size of list.");
            return true;
        }
        if (index > length) {
            System.out.println("Index exceeds size of list.");
            return true;
        }
        return length == 0;
    }

    public void insert(int index, T value) {
        if (outOfBounds(index)) {
            return;
        }
        if (index == 0) {
            prepend(value);
            return;
        }
        if (index == length) {
            append(value);
            return;
        }

        Node<T> traversalNode = traverse(index);
        Node<T> toInsert = new Node<>(value);
        assert traversalNode != null;
        traversalNode.getPrevious().setNext(toInsert);
        traversalNode.setPrevious(toInsert);
        toInsert.setPrevious(traversalNode.getPrevious());
        toInsert.setNext(traversalNode);
        length++;
    }
}
