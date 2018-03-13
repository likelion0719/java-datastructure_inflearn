package ex;

import java.util.Scanner;

public class practice {
	
	/*18.03.09
	 * 갯수 입력받아서 그 갯수 크기만큼의 배열 생성
	 * 배열에 숫자 담고 배열 안에 담은 숫자의 총합과
	 * 숫자들중 가장 큰 값 구하기
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
