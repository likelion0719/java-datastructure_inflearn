package list.linkedlist;


public class DoublyLinkedList {
	//ù��° ��带 ����Ű�� �ʵ�
	private Node head;
	private Node tail;
	private int size = 0;
	
	private class Node {
		private Node next;
		private Node prev;
		private Object data;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		//����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		//��带 �����մϴ�.
		Node newNode = new Node(input);
		//���ο� ����� ���� ���� ��带 ����
		newNode.next = head;
		//������ ��尡 �־��ٸ� ���� ����� ���� ���� ���ο� ��带 ����
		if(head != null) {
			head.prev = newNode;
		}
		//���� ���ο� ��� ����
		head = newNode;
		size++;
		if(head.next ==null) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		//��带 ����
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		} else {
			//������ ���� ���� ������ ��带 ����
			tail.next = newNode;
			//���ο� ����� ������ ���Ϸ� ����
			newNode.prev = tail;
			//������ ���ο� ���� ����
			tail = newNode;
			
			size++;
		}
	}
	public void add(int k, Object input) {
		if(k==0) {
			addFirst(input);
		}else {
			Node temp1 = new Node(k-1);
			Node temp2 = temp1.next;
			
			//���ο� ��� ����
			Node newNode = new Node(input);
			//�߰��Ϸ��� ��� ������� �������� �� ��� ����
			temp1.next = newNode;
			//���ο� ����� ������嵵 ����
			newNode.prev = temp1;
			newNode.next = temp2;
			
			if(temp2 != null) {
				temp2.prev = newNode;
			}else {
				tail = newNode;
			}
			size++;
			
		}
	}
	Node node(int index) {
		//����� �ε����� ��ü ��� ���� �ݺ��� ū�� ������ ���
		if(index <size/2) {
			//head���� Ž��
			Node x = head;
			for(int i=0; i<index; i++)
				x= x.next;
			return x;
		}else {
			//tail���� Ž��
			Node x = tail;
			for(int i=size-1; i>index; i--)
				x=x.prev;
			return x;
		}
	}
	
	public Object removeFirst() {
		//ù��带 temp�������ϰ� ���� 
		Node temp = head;
		//head�� ���� ���� ����
		head = temp.next;
		Object returnData = temp.data;
		temp= null;
		
		//�����ϰ� ��尡 ���� �� ���� ���� ���� ���� 
		if (head != null) 
			head.prev = null;
		size--;
		return returnData;
	}
	public Object remove(int k) {
		if(k==0) 
			return removeFirst();
		Node todoDeleted = node(k);
		//������ ����� �������
		Node temp1 = todoDeleted.prev;
		//������ ����� �������
		Node temp2 = todoDeleted.next;
		
		temp1.next = temp2;
		//������ ����� ������尡 �ִٸ�
		if(temp2!=null) {
			temp2.prev = temp1;
		}else {
			tail = temp1;
		}
		Object returnData = todoDeleted.data;
		todoDeleted = null;
		size--;
		
		return returnData;
	}
	public Object removeLast() {
		return remove(size-1);
	}
	
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	public int size() {
		return size;
	}
	public int indexOf(Object data) {
		//Ž�� ����� �Ǵ� ��带 temp�� �����մϴ�.
		Node temp = head;
		//Ž�� ����� ���° ������Ʈ�� �ִ��� �ǹ��ϴ� ����
		int index = 0;
		//Ž�� ���� Ž�� ����� ���� ���մϴ�.
		while(temp.data != data) {
			temp = temp.next;
			index++;
			if(temp == null) {
				return -1;
			}
		}
		//Ž�� ��� ã�Ҵٸ� ����� �ε��� ���� ����
		return index;
	}
	public ListIterator iterator() {
		return new ListIterator();
	}
	
	public class ListIterator {
		//���������� ���ϵ� ���
		private Node next;
		//���������� ���ϵ� ���
		private Node lastReturned;
		//������ ���ϵ� ����� �ε���
		private int nextIndex;
		
		ListIterator() {
			next = head;
			nextIndex = 0;
		}
		
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		public boolean hasNext() {
			return nextIndex < size();
		}
		
		public boolean hasPrevious() {
			return nextIndex> 0;
		}
		
		public Object previous() {
			if(next == null) {
				lastReturned = next = tail  ;
			}else {
				lastReturned = next = next.prev;
			}
			nextIndex--;
			return lastReturned.data;
		}
		
		public void add(Object input) {
			Node newNode = new Node(input);
			if(lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.prev = lastReturned;
				if(next !=null) {
					newNode.next =next;
					next.prev = newNode;
				}
			}
		}
	}
}
