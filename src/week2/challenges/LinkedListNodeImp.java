package week2.challenges;

/**
 * <pre>
 * Challenge 1:
 * 
 * Implement a simple linked list in Java without using any collections classes. 
 * 
 * The list should be implemented using a single class such that each instance 
 * represents a single node in the list, encapsulating the node's value and 
 * a reference to the following node, as well as a convenience method to initialize 
 * a whole list from an array of values.
 * 
 * The class should implement the LinkedListNode interface
 * 
 * </pre>
 * @param <E>
 */
class LinkedListNodeImpl<E> implements LinkedListNode<E> {
	public E value;
	public LinkedListNode<E> next;

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	/*
	 * getter/setter for the subsequent node, or null if this is the last node
	 */
	public LinkedListNode<E> getNext() {
		return next;
	}

	public void setNext(LinkedListNode<E> next) {
		this.next = next;
	}

	public void setValuesFromArray(E[] listValues) {
		if (listValues == null || listValues.length == 0) {
			return;
		}

		LinkedListNode<E> node = this;
		LinkedListNode<E> prev = null;
		for (int i = 0; i < listValues.length; i++) {
			node.setValue(listValues[i]);
			if (prev != null) {
				prev.setNext(node);
			}
			prev = node;
			node = new LinkedListNodeImpl<>();
		}
	}
}