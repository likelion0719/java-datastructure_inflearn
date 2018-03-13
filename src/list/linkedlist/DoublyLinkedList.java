package list.linkedlist;


public class DoublyLinkedList {
	//첫번째 노드를 가리키는 필드
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
		//노드의 내용을 쉽게 출력해서 확인해볼 수 있는 기능
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		//노드를 생성합니다.
		Node newNode = new Node(input);
		//새로운 노드의 다음 노드로 헤드를 지정
		newNode.next = head;
		//기존에 노드가 있었다면 현재 헤드의 이전 노드로 새로운 노드를 지정
		if(head != null) {
			head.prev = newNode;
		}
		//헤드로 새로운 노드 지정
		head = newNode;
		size++;
		if(head.next ==null) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		//노드를 생성
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		} else {
			//테일의 다음 노드로 생성한 노드를 지정
			tail.next = newNode;
			//새로운 노드의 이전을 테일로 지정
			newNode.prev = tail;
			//테일을 새로운 노드로 지정
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
			
			//새로운 노드 생성
			Node newNode = new Node(input);
			//추가하려는 노드 전노드의 다음노드로 새 노드 지정
			temp1.next = newNode;
			//새로운 노드의 이전노드도 지정
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
		//노드의 인덱스가 전체 노드 수의 반보다 큰지 작은지 계산
		if(index <size/2) {
			//head부터 탐색
			Node x = head;
			for(int i=0; i<index; i++)
				x= x.next;
			return x;
		}else {
			//tail부터 탐색
			Node x = tail;
			for(int i=size-1; i>index; i--)
				x=x.prev;
			return x;
		}
	}
	
	public Object removeFirst() {
		//첫노드를 temp로지정하고 시작 
		Node temp = head;
		//head를 다음 노드로 지정
		head = temp.next;
		Object returnData = temp.data;
		temp= null;
		
		//삭제하고 노드가 있을 시 이전 노드와 연결 끊기 
		if (head != null) 
			head.prev = null;
		size--;
		return returnData;
	}
	public Object remove(int k) {
		if(k==0) 
			return removeFirst();
		Node todoDeleted = node(k);
		//삭제할 노드의 이전노드
		Node temp1 = todoDeleted.prev;
		//삭제할 노드의 다음노드
		Node temp2 = todoDeleted.next;
		
		temp1.next = temp2;
		//삭제할 노드의 다음노드가 있다면
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
		//탐색 대상이 되는 노드를 temp로 지정합니다.
		Node temp = head;
		//탐색 대상이 몇번째 엘리먼트에 있는지 의미하는 변수
		int index = 0;
		//탐색 값과 탐색 대상의 값을 비교합니다.
		while(temp.data != data) {
			temp = temp.next;
			index++;
			if(temp == null) {
				return -1;
			}
		}
		//탐색 대상 찾았다면 대상의 인덱스 값을 리턴
		return index;
	}
	public ListIterator iterator() {
		return new ListIterator();
	}
	
	public class ListIterator {
		//다음번으로 리턴될 노드
		private Node next;
		//마지막으로 리턴된 노드
		private Node lastReturned;
		//다음번 리턴될 노드의 인덱스
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
