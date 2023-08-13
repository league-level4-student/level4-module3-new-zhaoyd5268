package _00_Intro_to_Linked_Lists;

public class NewLinkedList<W> {

	/*
	 * The head and tail contain references that point to the first and last
	 * elements of the LinkedList respectively.
	 * 
	 * These must be updated if elements are headed to the front or back, but allow
	 * for easy entry points into the LinkedList.
	 */
	private Node<String> head;

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String> ();
		list.add("Watermeloan");
		list.add("Cheerry");
		list.add("Manngo");
		list.add("Bluebeery");
		System.out.println("Before removal: ");
		list.print();
		list.remove(1);
		System.out.println("After removal: ");
		list.print();
		System.out.println("After list for loop changing");
		list.getHead().setValue("virus");
		list.print();
		list.getHead().getNext().setValue("virus");
		list.print();
		list.getHead().getNext().getNext().setValue("virus");
		list.print();
		System.out.println("After making all uppercase:");
		String value1 = list.getHead().getValue().toString().toUpperCase();
		String value2 = list.getHead().getNext().getValue().toString().toUpperCase();
		String value3 = list.getHead().getNext().getNext().getValue().toString().toUpperCase();
		list.getHead().setValue(value1);
		list.getHead().getNext().setValue(value2);
		list.getHead().getNext().getNext().setValue(value3);
		list.print();
	}

	public void add(String value) {

		if (head == null) {
			head = new Node<String>(value);
		} else {

			Node<String> next = head.getNext();
			Node<String> middle = head.getNext().getNext();
			while (next != null) {
				next = next.getNext();
			}

			next = new Node<String>(value);
			middle.setPrev(next);

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

	public void setHead(Node<String> head) {
		this.head = head;
	}

}
