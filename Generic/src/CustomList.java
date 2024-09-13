public class CustomList<T> {
    Node head;
    Node tail;

    public CustomList() {
        head = null;
        tail = null;
    }

    void addLast(T value) {
        Node nodeToAdd = new Node(value, null);

        // First element
        if (head == null) {
            head = nodeToAdd;
            tail = nodeToAdd;
            return;
        }

        // Not first element
        tail.next = nodeToAdd;
        tail = nodeToAdd;
    }

    T getLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }
        return tail.value;
    }

    void addFirst(T value) {
        Node nodeToAdd = new Node(value, null);

        // First element
        if (head == null) {
            head = nodeToAdd;
            tail = nodeToAdd;
            return;
        }

        nodeToAdd.next = head;
        head = nodeToAdd;
    }

    T getFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        return head.value;
    }

    T removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        T value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    T removeLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }

        if (head == tail) {
            T value = head.value;
            head = tail = null;
            return value;
        }
        else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            T value = tail.value;
            tail = current;
            tail.next = null;
            return value;
        }

    }

    // Clas to represent elements of the List
    private class Node {
        T value;
        Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
