package ex;

import java.util.Scanner;

public class practice04 {
	/*18.03.10
	 * n개의 정수를 입력받아 배열에 저장한다. 이들 중에서
	 * 0개 이상의 연속된 정수들을 더하여 얻을 수 있는 최대값을
	 * 구하여 출력하는 프로그램을 작성하라
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
