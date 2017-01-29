package week2.challenges;

public abstract class LinkedListUtils {

	static void printLinkedListReverse(LinkedListNode<Integer> start, String separator) {
		if (start != null) {
			printLinkedListReverse(start.getNext(), separator);
			System.out.print(start.getValue() + separator);
		}
	}

	static void printLinkedList(LinkedListNode<Integer> start, String separator) {
		if (start != null) {
			System.out.print(start.getValue() + separator);
			printLinkedList(start.getNext(), separator);
		}
	}
}
