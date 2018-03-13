package list.linkedlist;

public class LinkedList {
	//첫번째 노드를 가리키는 필드
	private Node head;
	private Node tail;
	private int size= 0;
	
	private class Node{
		//데이터가 저장될 필드
		private Object data;
		//다음 노드를 가리키는 필드
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		// 노드의 내용을 쉽게 출력해서 확인해 볼 수 있는 기능
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		//노드를 생성합니다.
		Node newNode = new Node(input);
		//새로운 노드의 다음 노드를 헤드로 지정
		newNode.next = head;
		//헤드로 새로운 노드를 지정
		head = newNode;
		size++;
		if(head.next==null) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		//노드를 생성
		Node newNode = new Node(input);
		//리스트의 노드가 없다면 첫번째 노드를 추가하는 메서드 사용
		if(size == 0) {
			addFirst(input);
		} else {
			//마지막 노드의 다음노드로 생성한 노드를 지정
			tail.next = newNode;
			//마지막 노드를 갱신합니다.
			tail = newNode;
			// 엘리먼트의 개수를 1 증가 시킨다.
			size++;
		}
	}
	
	Node node(int index) {
		Node x = head;
		//원하는 번째의 노드는 그전노드의 next로 알수 있기에 i가 
		//인덱스보다 작을때까지만 반복
		for(int i = 0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	public void add(int k, Object input) {
	  //만약 k가 0일때 첫번째 노드에 추가하는 것이기에
		if(k==0) {
			addFirst(input);
		} else {
			Node temp1 = node(k-1);
			//k번째 노드를 temp2에 저장
			Node temp2 = temp1.next;
			//새로운 노드 생성
			Node newNode = new Node(input);
			//temp1의 다음 노드로 새로운 노드 지정
			temp1.next = newNode;
			//새로운 노드의 다음 노드로 temp2 지정
			newNode.next = temp2;
			size++;
			//새로운 노드의 다음 노드가 없으면 마지막 노드가 된다.
			if(newNode.next == null){
				tail = newNode;
			}
		}
	}
	
	public String toString() {
		//노드가 없다면 []를 리턴
		if(head == null) {
			return "[]";
		}
		//탐색 시작
		Node temp = head;
		String str = "[";
		//다음 노드가 없을 때까지 반복문 실행
		//마지막 노드는 다음노드가 없기 때문에 
		//다음 반복문은 마지막 노드는 제외
		while(temp.next != null) {
			str+=temp.data+",";
			temp=temp.next;
		}
		//마지막 노드를 출력 결과에 포함시킨다.
		str+= temp.data;
		return str+"]";
	}
	
	public Object removeFirst() {
		//첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경
		Node temp = head;
		head = temp.next;
		//데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담는다.
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
		
	}
	public Object remove(int k) {
		if(k == 0) {
			removeFirst();
		}
		//k-1번째 노드를 temp의 값으로 지정
		Node temp = node(k-1);
		//삭제노드를 todoDeleted에 기록
		Node todoDeleted = temp.next;
		//삭제 노드를 제거하기전에 삭제 앞노드와 뒤의 노드를 연결
		temp.next= temp.next.next;
		//삭제된 데이터를 리턴하기 위해 returnData에 저장
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
		public Node lastReturned;
		public Node next;
		private int nextIndex;
		
		ListIterator() {
			next = head;
			nextIndex=0;
		}
		//노드의 값을 리턴하는 next메서드
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
