package ex;

import java.util.Scanner;

public class practice {
	
	/*18.03.09
	 * ���� �Է¹޾Ƽ� �� ���� ũ�⸸ŭ�� �迭 ����
	 * �迭�� ���� ��� �迭 �ȿ� ���� ������ ���հ�
	 * ���ڵ��� ���� ū �� ���ϱ�
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] numbers = new int[n];
		int sum =0;
		
		for(int i=0; i<numbers.length; i++) {
			numbers[i] = sc.nextInt();
			sum+=numbers[i];
		}
		int max = numbers[0];
		for(int i=1; i<numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
				
		}
		System.out.println(sum+" "+max);
	}

}
