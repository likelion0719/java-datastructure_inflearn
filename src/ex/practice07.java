package ex;

import java.util.Scanner;

public class practice07 {
	/*
	 * ����ڷκ��� n���� ������ �Է¹޴´�.
	 * ������ �ϳ��� �Է¹���������  ������� �Էµ�
	 * �������� ������������ ����
	 * orderedlist�� insert �Ҷ�
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] numbers = new int[num];
		/* ������ ������ ������ ������ ���⼱ �������� ��︮�� ����
		for(int i=0; i<num; i++) {
			numbers[i] = sc.nextInt();
			for(int j=i;j>0;j--) {
				if(numbers[j]<numbers[j-1]) {
					int temp = numbers[j];
					numbers[j] =numbers[j-1];
					numbers[j-1] = temp;
				}
			}
		}
		*/
		for(int i=0; i<num; i++) {
			int temp = sc.nextInt();
			int j = i-1;
			while(j>=0 && numbers[j] > temp) {
				numbers[j+1] = numbers[j];
				j--;
			}
			numbers[j+1] = temp;
		}
		
		for(int i=0; i<num; i++) {
			System.out.println(numbers[i]);
		}
	}

}
