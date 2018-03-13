package ex;

import java.util.Scanner;

public class practice01 {
	/*18.03.09
	 * 갯수 입력 받아서 그 갯수만큼의 크기로 배열생성
	 * 배열에 숫자 입력받고 1칸씩 뒤로 미루기 
	 * 마지막 배열은 첫번째 배열로 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("몇개");
		int count = sc.nextInt();
		int[] numbers = new int[count];
		for (int i=0; i<numbers.length; i++) {
			numbers[i] = sc.nextInt();
		} 
		sc.close();
		int temp = numbers[numbers.length-1];
		for(int i=numbers.length-1;i>0; i--) {
			numbers[i] = numbers[i-1];
			if (i == 1) {
				numbers[0] = temp;
			}
		}
		
		for(int i=0; i<numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
