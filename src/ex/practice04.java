package ex;

import java.util.Scanner;

public class practice04 {
	/*18.03.10
	 * n���� ������ �Է¹޾� �迭�� �����Ѵ�. �̵� �߿���
	 * 0�� �̻��� ���ӵ� �������� ���Ͽ� ���� �� �ִ� �ִ밪��
	 * ���Ͽ� ����ϴ� ���α׷��� �ۼ��϶�
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n���� ������ �Է¹޾� �迭�� ����
		int n = sc.nextInt();
		int[] numbers = new int[n];
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
		}//�������
		sc.close();
		int max = 0;
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(numbers[i]>max)
				max =numbers[i];
			sum = numbers[i];
			for(int j=i+1; j<n; j++) {
				sum+=numbers[j];
				if(sum > max)
					max = sum;
				
			}
		}
		System.out.println(max);
	}

}
