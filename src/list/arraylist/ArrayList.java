package list.arraylist;

public class ArrayList {
	//����Ʈ �ȿ� ����ִ� list �� 
	private int size = 0;
	//����Ʈ �迭 ��ü
	private Object[] elementData = new Object[100];
	
	//������ �ε����� �� �߰��ϴ� �޼���
	public boolean addLast(Object element) {
		
		elementData[size] = element;
		size++;
		
		return true;
	}
	//�߰� �ε����� �� �߰��ϴ� �޼���
	public boolean add(int idx, Object element) {
		for(int i=size-1; i>= idx; i--) {
			elementData[i+1] = elementData[i];
		}
		elementData[idx] = element;
		size++;
		return true;
	}
	//ó�� �ε����� �� �߰��ϴ� �޼���
	public boolean addFirst(Object element) {
		return add(0,element);
		
	}
	
	//������ Ȯ�� �ϱ����� �޼���
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
	//�����͸� �����ϴ� �޼��� 
	public Object remove(int idx) {
		// ������Ʈ�� �����ϱ� ���� ������ �����͸� ������ ����
		Object removed = elementData[idx];
		for(int i = idx+1; i<= size-1; i++) {
			elementData[i-1] = elementData[i];
		}
		size--;
		//�������� ��ġ�� ������Ʈ�� ��������� �������ش�.
		elementData[size] = null;
		return removed;
	}
	//�����͸� �������� �޼���
	public Object get(int idx) {
		return elementData[idx];
	}
	//����Ʈ�� ����� ���ϴ� �޼���
	public int size() {
		return size;
	}
	//�˻� ���� ���° �ε����� �ִ��� ���ϴ� �޼���
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
		//���� Ž���ϰ� �ִ� ������ ����Ű�� �ε�����
		private int nextIndex = 0;
		
		//����Ʈ�� ������Ʈ ���� ����
		public boolean hasNext() {
			//����Ʈ ������� ����������
			return nextIndex < size();
		}
		
		//���������� ������Ʈ�� Ž���ؼ� ����
		public Object next() {
			return elementData[nextIndex++];
		}
		
		public boolean hasPrevious() {
			return nextIndex>0;
		}
		
		public Object previous() {
			//���� ������Ʈ �����ϰ� nextindex 1����
			return elementData[--nextIndex];
		}
		
		//���� ������Ʈ �߰�
		public void add(Object element) {
			ArrayList.this.add(nextIndex++,element );
		}
		//���� ������Ʈ ����
		public void remove() {
			ArrayList.this.remove(--nextIndex);
		
		}
	}
}
