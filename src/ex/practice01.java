package ex;

import java.util.Scanner;

public class practice01 {
	/*18.03.09
	 * ���� �Է� �޾Ƽ� �� ������ŭ�� ũ��� �迭����
	 * �迭�� ���� �Է¹ް� 1ĭ�� �ڷ� �̷�� 
	 * ������ �迭�� ù��° �迭�� 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�");
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
