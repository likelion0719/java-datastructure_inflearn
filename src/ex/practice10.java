package ex;

import java.io.File;
import java.util.Scanner;

public class practice10 {
	/* 초급 알고리즘 공부
	 * 컴퓨터는 빠르다
	 * 뭔가 교모한 방법을 찾지말고 무식하지만 가장
	 * 간단 명료한 방법을 먼저 찾아라. 그다음 조금씩 개선
	 */
	
	static int n;
	static int[][] grid;
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("input.txt"));
			n = sc.nextInt();
			grid = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			sc.close();
			
			for(int x = 0; x<n; x++) {
				for(int y=0; y<n; y++) {
					for(int dir =0; dir<8; dir++) {
						for(int length =1; length <=n; length++) {
							int value = computeValue(x,y,dir,length);
							if(value!= -1 && isPrime(value))
								System.out.println(value);
						}
					}
				}
			}
		}catch(Exception e) {
			
		}
		
		
		
		
	}
	static boolean isPrime(int k) {
		for(int i=2; i*i<k; i++) {
			if(k%i==0)
				return false;
			
		}
		return true;
	}
	
	static int computeValue(int x, int y, int dir, int len) {
		int value = 0;
		for(int i=0; i<len; i++) {
			int digit = getDigit(x,y,dir,i);
			if(digit== -1)
				return -1;
			value = value*10 + digit;
		}
		return value;
	}


static int getDigit(int x, int y, int dir, int k) {
	int newX = x, newY = y;
	switch(dir) {
	case 0: newY -=k; break;
	case 1: newX +=k; newY -=k; break;
	case 2: newX +=k; break;
	case 3: newX +=k; newY +=k; break;
	case 4: newY +=k; break;
	case 5: newX -=k; newY +=k; break;
	case 6: newX -=k; break;
	case 7: newX -=k; newY -=k; break;
	}
	if(newX <0 || newX >=n || newY <0 || newY >=n)
		return -1;
	
	return grid[newX][newY];
	}
}