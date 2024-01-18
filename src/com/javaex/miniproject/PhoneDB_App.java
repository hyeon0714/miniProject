package com.javaex.miniproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDB_App {
	
	public static void main(String[] args) throws IOException {

		Reader r=new FileReader("C:\\javaStudy\\PhoneDB.txt");
		BufferedReader br=new BufferedReader(r);
		
		List<PhoneDB> DB=new ArrayList<PhoneDB>();
		
		while(true) {
			String str=br.readLine();
			if(str==null) {
				break;
			}
			String[] a=str.split(",");
			PhoneDB p01 = new PhoneDB(a[0], a[1], a[2]);
			
			DB.add(p01);
		}//DB에 메모장 내용 입력
		
		System.out.println("***********************************");
		System.out.println("*     전화번호 관리 프로그램      *");
		System.out.println("***********************************");
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {//반복문 시작
			System.out.println();
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------------");
			System.out.print("메뉴번호>");
			int no=sc.nextInt();
			
			if(no==1) {
				System.out.println("<1.리스트>");
				for(int i=0; i<DB.size(); i++) {
					System.out.print(i+1+".");
					DB.get(i).showInfo();
				}
				
			}else if(no==2) {
				System.out.println("<2.등록>");
				System.out.print(">이름:");
				String name=sc.next();
				System.out.print(">휴대전화:");
				String hp=sc.next();
				System.out.print(">회사전화:");
				String company=sc.next();
				PhoneDB p02=new PhoneDB(name, hp, company);
				DB.add(p02);
				
				Writer w=new FileWriter("C:\\javaStudy\\PhoneDB.txt");
				BufferedWriter bw=new BufferedWriter(w);
				
				for(int i=0; i<DB.size(); i++) {//입력한값 텍스트 파일에 추가
					bw.write(String.valueOf(DB.get(i).getOut()));
					bw.newLine();
				}
				bw.close();
				
			}else if(no==3) {
				System.out.println("<3.삭제>");
				System.out.print(">번호 :");
				int remove=sc.nextInt();
				DB.remove(remove-1);
				
				Writer w=new FileWriter("C:\\javaStudy\\PhoneDB.txt");
				BufferedWriter bw=new BufferedWriter(w);
				
				for(int i=0; i<DB.size(); i++) {//입력한값 텍스트 파일에 추가
					bw.write(String.valueOf(DB.get(i).getOut()));
					bw.newLine();
				}
				bw.close();
				
			}else if(no==4) {
				System.out.println("<4.검색>");
				System.out.print(">이름:");
				String find=sc.next();
				for(int i=0; i<DB.size(); i++) {
					if(DB.get(i).getName().contains(find)) {
						System.out.print(i+1+".");
						DB.get(i).showInfo();
					}
				}
				
				
			}else if(no>5) {
				System.out.println("[다시 입력해주세요]");
			}else {
				System.out.println("***********************************");
				System.out.println("*           감사합니다            *");
				System.out.println("***********************************");
				break;
			}
		}
		sc.close();
		br.close();
	}
}
