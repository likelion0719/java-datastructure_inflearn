package list.linkedlist;

import list.linkedlist.DoublyLinkedList.ListIterator;

public class main {

	public static void main(String[] args) {
		
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		ListIterator it = list.iterator();
		it.next();
		it.add(15);
		it.previous();
		
		System.out.println(list);
	}
	
}

