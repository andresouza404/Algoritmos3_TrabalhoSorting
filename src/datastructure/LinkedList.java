package datastructure;

import java.util.Comparator;

public class LinkedList<T> {

	public class Node {
		private T data;
		private Node next;
		private Node previous;

		public Node(T data) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		public void addAfter(T data) {
			Node newNode = new Node(data);
			Node next = this.next;
			newNode.previous = this;
			if (next == null) {
				tail = newNode;
			} else {
				next.previous = newNode;
			}
			this.next = newNode;
		}

		public void addBefore(T data) {
			Node newNode = new Node(data);
			Node previous = this.previous;
			newNode.next = this;
			if (previous == null) {
				head = newNode;
			} else {
				previous.next = newNode;
			}
			this.previous = newNode;
		}
	}

	private Node head;
	private Node tail;

	public void append(T data) {
		Node newNode = new Node(data);
		if (tail != null) {
			tail.next = newNode;
		} else {
			head = newNode;
		}
		newNode.previous = tail;
		tail = newNode;
	}

	public void addFirst(T data) {
		Node newNode = new Node(data);
		if (head != null) {
			head.previous = newNode;
		} else {
			tail = newNode;
		}
		newNode.next = head;
		head = newNode;
	}

	public void print() {
		Node i = head;
		while (i != null) {
			System.out.println(i.data);
			i = i.next;
		}
	}

	public void stableSort(Comparator<T> cmp) {
		Node current = this.head;
		while (current != null) {
			T data = current.data;
			Node i = current;
			while (i.previous != null && cmp.compare(data, i.previous.data) < 0) {
				i.data = i.previous.data;
				i = i.previous;
			}
			i.data = data;
			current = current.next;
		}
	}

	public void efficientSort(Comparator<T> cmp) {
		recQuicksort(this.head, this.tail, cmp);
	}

	private void recQuicksort(Node head, Node tail, Comparator<T> cmp) {
		if (tail != null && head != tail && head != tail.next) {
			Node temp = partition(head, tail, cmp);
			recQuicksort(head, temp.previous, cmp);
			recQuicksort(temp.next, tail, cmp);
		}
	}

	public Node partition(Node l, Node h, Comparator<T> cmp) {
		T x = h.data;
		Node i = l.previous;
		for (Node j = l; j !=  h; j = j.next) {
			if (cmp.compare(j.data, x) <= 0) {
				i = (i == null) ? l : i.next;
				T temp = i.data;
				i.data = j.data;
				j.data = temp;
			}
		}
		i = (i == null) ? l : i.next;
		T temp = i.data;
		i.data = h.data;
		h.data = temp;
		return i;
	}
}
