package ex;

import java.util.Scanner;

public class practice05 {
	/*
	 * ���ӵ� ���ڵ��� ��ġ�� ��� 
	 * ex) 1,9,4 => 194��
	 * 1*10 + 9 =19
	 * 19*10 + 4 = 194 
	 * ���ӵ� ���ڵ��� ���ĳ� �����߿� ���� ū �Ҽ� ���ϱ�
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
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				
				//convert data[i]..data[j] into an integer
				int val = 0;
				for(int k=i; k<=j; k++)
					val = val*10+numbers[k];
				
				//�Ҽ� �Ǻ�
				boolean isPrime = true;
				for(int k=2; k*k<=val && isPrime; k++)
					if(val%k ==0)
						isPrime = false;
				
					if(isPrime && val >1 &&val > max)
						max = val;
			}
		}
		if (max > 0)
			System.out.println(max);
		else 
			System.out.println("No prime number");
	}

}
