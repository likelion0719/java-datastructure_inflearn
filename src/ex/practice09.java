package ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class practice09 {
	/*
	 * �̸��� ��ȣ�� ���Ϸ� �Է��� ���� ����
	 * ���Ϸκ����� ����� 
	 * */
	static String [] name = new String[50];
	static String [] number = new String[50];
	//��� ��
	static int n = 0;
	public static void main(String[] args) {
		String fileName = "input.txt";
				
		try {
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNext()) {
				name[n] = sc.next();
				number[n] = sc.next();
				n++;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No file");;
		}
		
		bubbleSort();
		for(int i=0; i<n; i++) {
			System.out.println(name[i]+ ": "+number[i]);
		}
	}
	
	static void bubbleSort() {
		for(int i= n-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				//a.compareTo(b)�϶� a�� ũ�� ��� ������ ����
				if(name[j].compareTo(name[j+1]) > 0) {
					String temp = name[j];
					name[j] = name[j+1];
					name[j+1] = temp;
					
					temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
				}
			}
		}
	}
}
