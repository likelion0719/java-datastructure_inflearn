package ex;

public class practice02 {
	/*18.03.09
	 * 1~100000 사이의 모든 소수들을 찾아서 출력
	 
	 */
	public static void main(String[] args) {
		for(int i=1; i<=20; i++) {
		int count = 0;
				
				// tip)약수를 검사할때 제곱근보다 작거나 같을때 까지만 검사하면 됨
				for(int j=2; j*j<=i; j++) {
					if(i%j ==0 )
						count++;
				if(count ==1)
				break;
			}
				if(count ==0)
				System.out.println(i);
		}
	}

}
