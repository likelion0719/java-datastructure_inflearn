package array;

public class array {
	/* 이런 식으로도 사용 가능
	 * int[] nums = new int[4];
	   nums[0] =1;
	*/
	static String[] members = {"가","나","다","라"};
	
	public static void main(String[] args) {
		for(int i=0; i<members.length; i++) {
			System.out.println(members[i]);
		}
	}
}
