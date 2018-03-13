package list.arraylist;

public class ArrayList {
	//리스트 안에 담겨있는 list 수 
	private int size = 0;
	//리스트 배열 객체
	private Object[] elementData = new Object[100];
	
	//마지막 인덱스에 값 추가하는 메서드
	public boolean addLast(Object element) {
		
		elementData[size] = element;
		size++;
		
		return true;
	}
	//중간 인덱스에 값 추가하는 메서드
	public boolean add(int idx, Object element) {
		for(int i=size-1; i>= idx; i--) {
			elementData[i+1] = elementData[i];
		}
		elementData[idx] = element;
		size++;
		return true;
	}
	//처음 인덱스에 값 추가하는 메서드
	public boolean addFirst(Object element) {
		return add(0,element);
		
	}
	
	//데이터 확인 하기위한 메서드
	public String toString() {
		String str = "[";
		for(int i = 0; i<size; i++) {
			str += elementData[i];
			if(i != size-1) {
			str += ",";
			}
		}
		return str + "]";
	}
	//데이터를 삭제하는 메서드 
	public Object remove(int idx) {
		// 엘리먼트를 삭제하기 전에 삭제할 데이터를 변수에 저장
		Object removed = elementData[idx];
		for(int i = idx+1; i<= size-1; i++) {
			elementData[i-1] = elementData[i];
		}
		size--;
		//마지막에 위치한 엘리먼트를 명시적으로 삭제해준다.
		elementData[size] = null;
		return removed;
	}
	//데이터를 가져오는 메서드
	public Object get(int idx) {
		return elementData[idx];
	}
	//리스트의 사이즈를 구하는 메서드
	public int size() {
		return size;
	}
	//검색 값이 몇번째 인덱스에 있는지 구하는 메서드
	public int indexOf(Object o) {
		for(int i=0; i<size; i++) {
			if(o.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	class ListIterator {
		//현재 탐색하고 있는 순서를 가르키는 인덱스값
		private int nextIndex = 0;
		
		//리스트에 엘리먼트 존재 유무
		public boolean hasNext() {
			//리스트 사이즈보다 작을때까지
			return nextIndex < size();
		}
		
		//순차적으로 엘리먼트를 탐색해서 리턴
		public Object next() {
			return elementData[nextIndex++];
		}
		
		public boolean hasPrevious() {
			return nextIndex>0;
		}
		
		public Object previous() {
			//이전 엘리먼트 리턴하고 nextindex 1감소
			return elementData[--nextIndex];
		}
		
		//현재 엘리먼트 추가
		public void add(Object element) {
			ArrayList.this.add(nextIndex++,element );
		}
		//현재 엘리먼트 제거
		public void remove() {
			ArrayList.this.remove(--nextIndex);
		
		}
	}
}
