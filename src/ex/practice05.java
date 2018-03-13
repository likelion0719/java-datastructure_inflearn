package ex;

import java.util.Scanner;

public class practice05 {
	/*
	 * 연속된 숫자들을 합치는 방법 
	 * ex) 1,9,4 => 194로
	 * 1*10 + 9 =19
	 * 19*10 + 4 = 194 
	 * 연속된 숫자들을 합쳐논 숫자중에 가장 큰 소수 구하기
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n개의 정수를 입력받아 배열에 저장
		int n = sc.nextInt();
		int[] numbers = new int[n];
		for(int i=0; i<n; i++) {
			numbers[i] = sc.nextInt();
		}//여기까지
		sc.close();
		
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				
				//convert data[i]..data[j] into an integer
				int val = 0;
				for(int k=i; k<=j; k++)
					val = val*10+numbers[k];
				
				//소수 판별
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
