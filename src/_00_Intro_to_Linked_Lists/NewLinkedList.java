package _00_Intro_to_Linked_Lists;

public class NewLinkedList <W> {

    /*
     * The head and tail contain references that point to the first and last
     * elements of the LinkedList respectively.
     * 
     * These must be updated if elements are headed to the front or back, but
     * allow for easy entry points into the LinkedList.
     */
    private Node<String> head;
    private Node<String> tail;

    public void add(String value) {

        if (head == null) {
            head = new Node<String>(value);
        } else {

            Node<String> prev = head;
            Node<String> next = head.getNext();
            Node <String> middle = head.getNext().getNext();
            while (next != null) {
                prev = prev.getNext();
                next = next.getNext();
                middle = middle.getNext();
            }

            next = new Node<String>(value);
            prev.setNext(next);
            next.setPrev(prev);
            middle.setPrev(next);
            
            tail = next;
        }
    }

    public void remove(int position) {

        if (head == null) {
            System.out.println("No items to remove!");
        } else if (position == 0) {

            head = head.getNext();

            if (head != null) {
                head.setPrev(null);
            }

        } else {

            int positionCounter = 1;
            Node<String> prev = head;
            Node<String> next = head.getNext();

            while (positionCounter < position) {

                prev = prev.getNext();
                next = next.getNext();
                positionCounter++;

            }

            if (positionCounter == position && next != null) {

                next = next.getNext();
                prev.setNext(next);

                if (next != null) {
                    next.setPrev(prev);
                }
            } else {
                System.out.println("Position not found!");
            }
        }

    }

    public void print() {
        if (head == null) {
            System.out.println("No items in list!");
        } else {

            Node<String> next = head;

            while (next != null) {

                System.out.print(next.getValue().toString() + " <-> ");
                next = next.getNext();

            }

            System.out.println();

        }

    }

    public int size() {
        int size = 0;
        if (head != null) {

            Node<String> next = head;

            while (next != null) {

                next = next.getNext();
                size++;

            }

        }
        return size;

    }

    public Node<String> getHead() {
        return head;
    }

    public Node<String> getTail() {
        return tail;
    }

    public void setHead(Node<String> head) {
        this.head = head;
    }

    public void setTail(Node<String> tail) {
        this.tail = tail;
    }

	
}
