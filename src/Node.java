public class Node <T> {

    private Node<T> previous;
    private Node<T> next;
    private final T value;

    public Node(T value) {
        this.previous = null;
        this.next = null;
        this.value = value;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }
}
