package ex;

import java.util.Scanner;

public class practice03 {
	/*18.03.09
	 * ����ڷκ��� ������ ���� n�� �Է� �޴´�.
	 * ũ�Ⱑ n�� �迭�� �����ؼ� ������ ��´�.
	 * �迭�ȿ� �ߺ��� ���� ���� ī��Ʈ �ؼ�  ��� 
	 * ex) 2,4,2,4,5,2 �̸� (2,2)�� 3�� (4,4)�� 1��
	   ��� 4���̴�.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] numbers = new int[n];
		int count = 0;
		for(int i=0; i<n; i++) {
			numbers[i]= sc.nextInt();
		}
		sc.close();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(numbers[i] == numbers[j])
					count++;
			}
		}
		System.out.println(count);
	}

}
