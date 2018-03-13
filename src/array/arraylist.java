package array;

import java.util.ArrayList;
import java.util.Iterator;

public class arraylist {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		System.out.println(numbers);
		System.out.println("add(ÀÎµ¦½º,°ª)");
		numbers.add(1,50);
		System.out.println(numbers);
		System.out.println("remove(ÀÎµ¦½º)");
		numbers.remove(4);
		System.out.println(numbers);
		System.out.println("get(ÀÎµ¦½º)");
		System.out.println(numbers.get(2));
		Iterator<Integer> it = numbers.iterator();
		
		//¼øÈ¯ 1
		while(it.hasNext()) {
			int value = (int)it.next();
			System.out.println(value);
		}
		System.out.println(it.hasNext());
		//¼øÈ¯ 2
		for(int value : numbers) {
			
		}
	}

}
