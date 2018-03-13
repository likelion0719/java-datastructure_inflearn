package list.arraylist;


public class main {

	public static void main(String[] args) {
		ArrayList numbers = new ArrayList();
		numbers.addLast(10);
		numbers.addLast(20);
		numbers.addLast(30);
		numbers.addLast(40);
		numbers.add(1,15);
		numbers.addFirst(5);
		System.out.println(numbers);
		System.out.println(numbers.remove(1));
		System.out.println(numbers);
		System.out.println(numbers.get(1));
		
		ArrayList.ListIterator it = numbers.listIterator();
		while(it.hasNext()) {
			if(it.next().equals(40))
				it.remove();
		}
		System.out.println(numbers);
	}

}
