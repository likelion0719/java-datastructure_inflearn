package ex;

public class practice02 {
	/*18.03.09
	 * 1~100000 ������ ��� �Ҽ����� ã�Ƽ� ���
	 
	 */
	public static void main(String[] args) {
		for(int i=1; i<=20; i++) {
		int count = 0;
				
				// tip)����� �˻��Ҷ� �����ٺ��� �۰ų� ������ ������ �˻��ϸ� ��
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
