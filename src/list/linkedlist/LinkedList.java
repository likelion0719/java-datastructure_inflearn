package list.linkedlist;

public class LinkedList {
	//ù��° ��带 ����Ű�� �ʵ�
	private Node head;
	private Node tail;
	private int size= 0;
	
	private class Node{
		//�����Ͱ� ����� �ʵ�
		private Object data;
		//���� ��带 ����Ű�� �ʵ�
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		// ����� ������ ���� ����ؼ� Ȯ���� �� �� �ִ� ���
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		//��带 �����մϴ�.
		Node newNode = new Node(input);
		//���ο� ����� ���� ��带 ���� ����
		newNode.next = head;
		//���� ���ο� ��带 ����
		head = newNode;
		size++;
		if(head.next==null) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		//��带 ����
		Node newNode = new Node(input);
		//����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼��� ���
		if(size == 0) {
			addFirst(input);
		} else {
			//������ ����� �������� ������ ��带 ����
			tail.next = newNode;
			//������ ��带 �����մϴ�.
			tail = newNode;
			// ������Ʈ�� ������ 1 ���� ��Ų��.
			size++;
		}
	}
	
	Node node(int index) {
		Node x = head;
		//���ϴ� ��°�� ���� ��������� next�� �˼� �ֱ⿡ i�� 
		//�ε������� ������������ �ݺ�
		for(int i = 0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	public void add(int k, Object input) {
	  //���� k�� 0�϶� ù��° ��忡 �߰��ϴ� ���̱⿡
		if(k==0) {
			addFirst(input);
		} else {
			Node temp1 = node(k-1);
			//k��° ��带 temp2�� ����
			Node temp2 = temp1.next;
			//���ο� ��� ����
			Node newNode = new Node(input);
			//temp1�� ���� ���� ���ο� ��� ����
			temp1.next = newNode;
			//���ο� ����� ���� ���� temp2 ����
			newNode.next = temp2;
			size++;
			//���ο� ����� ���� ��尡 ������ ������ ��尡 �ȴ�.
			if(newNode.next == null){
				tail = newNode;
			}
		}
	}
	
	public String toString() {
		//��尡 ���ٸ� []�� ����
		if(head == null) {
			return "[]";
		}
		//Ž�� ����
		Node temp = head;
		String str = "[";
		//���� ��尡 ���� ������ �ݺ��� ����
		//������ ���� ������尡 ���� ������ 
		//���� �ݺ����� ������ ���� ����
		while(temp.next != null) {
			str+=temp.data+",";
			temp=temp.next;
		}
		//������ ��带 ��� ����� ���Խ�Ų��.
		str+= temp.data;
		return str+"]";
	}
	
	public Object removeFirst() {
		//ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� ����
		Node temp = head;
		head = temp.next;
		//�����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ��´�.
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
		
	}
	public Object remove(int k) {
		if(k == 0) {
			removeFirst();
		}
		//k-1��° ��带 temp�� ������ ����
		Node temp = node(k-1);
		//������带 todoDeleted�� ���
		Node todoDeleted = temp.next;
		//���� ��带 �����ϱ����� ���� �ճ��� ���� ��带 ����
		temp.next= temp.next.next;
		//������ �����͸� �����ϱ� ���� returnData�� ����
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {
			tail = temp;
		}
		todoDeleted = null;
		size--;
		return returnData;
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
		public Node lastReturned;
		public Node next;
		private int nextIndex;
		
		ListIterator() {
			next = head;
			nextIndex=0;
		}
		//����� ���� �����ϴ� next�޼���
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		public boolean hasNext() {
			return nextIndex < size();
		}
		public void add(Object input) {
			Node newNode = new Node(input);
			if(lastReturned == null) {
				head= newNode;
				newNode.next = next;
			}else {
				lastReturned.next = newNode;
				newNode.next = next;
			}
			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		public void remove() {
			if(nextIndex == 0) {
				throw new IllegalStateException();
			}
			LinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
}
