package ex;

import java.util.Scanner;

public class practice06 {
	/*
	 * ����ڷκ��� n�� �Է¹޾� �迭�� ����
	 * ������������ �����ϱ�
	 * tip) ��������
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] numbers = new int[num];
		for(int i=0; i<num; i++) {
			numbers[i] = sc.nextInt();
		}
		
		//bubble sort
		for(int i= num-1; i>0; i--) {
			int maxSeq = 0;
			int temp = 0;
			for(int j=0; j<=i; j++) {
				if(temp <numbers[j]) {
					temp = numbers[j];
					maxSeq = j;
				}
			}
			numbers[maxSeq] = numbers[i];
			numbers[i] = temp;
 		}
		
		System.out.println("������");
		for(int i=0; i<num; i++) {
			System.out.println(numbers[i]);
		}
	}

}
