package ex;

import java.util.Scanner;

public class practice08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] numbers = new int[num];
		
		for(int i=0; i<num; i++) {
			int number = sc.nextInt();
			numbers[i] = number;
		}
		sc.close();
		bubble(num,numbers);
		for(int i = 0; i<num; i++) {
			System.out.println(numbers[i]);
		}
		
	}
	//bubble sort 
	public static void bubble(int num,int[] numbers) {
		for(int i= num-1; i>0; i--) {
			for(int j= 0; j<i; j++) {
				if(numbers[j]>numbers[j+1]) {
					//swap
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
			
				}
			}
		}
	}
	/*
	 * swap �Լ��� �ٲ㵵 ���� ���� ���� �ʴ� ������
	�޼ҵ忡�� ������Ƽ�� Ÿ���� �Ű������� ȣ��� �޼��忡��
	���� �ٲ��� ȣ���� �ʿ��� ������ ���� ����
	���� ���� ȣ���̱� �����̴�.
	*/
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
}
