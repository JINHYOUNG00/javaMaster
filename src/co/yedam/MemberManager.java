package co.yedam;

import java.util.List;
import java.util.Scanner;

public class MemberManager {
		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			MemberDAO dao = new MemberDAO();
			
			boolean run = true;
			while(run) {
				System.out.println("1.회원목록, 2.회원등록 3.정보수정 4.정보삭제 5.상세화면 6.종료");
				System.out.print("선택 > ");
				int choice = Integer.parseInt(scn.nextLine());

				switch (choice) {
				case 1: {
					System.out.println("회원번호\t 회원명\t 연락처 \t\t 회원생일\t\t 성별");
					List<Member> list = dao.memberList();
					
					for (Member member : list) {
						System.out.println(member.toString());
						
					}
					
					break;
				} 
				case 2: {
					Member member = new Member();
					System.out.print("회원명>>");
					String name = scn.nextLine();
					System.out.print("연락처>>");
					String tel = scn.nextLine();
					System.out.print("생일>>");
					String birthday = scn.nextLine();
					System.out.print("성별>>");
					String gender = scn.nextLine();
					System.out.print("이메일>>");
					String email = scn.nextLine();
					
					member.setMemberName(name);
					member.setTel(tel);
					member.setMemberBday(birthday);
					member.setGender(gender);
					member.setEmail(email);
					
					if(dao.insertMember(member)) {
						System.out.println("정상입력");
					} else {
						System.out.println("예외발생");
					}
					break;
				} 
				case 3: {
					Member member = new Member();
					System.out.println("수정할 회원번호>>");
					int memberId = Integer.parseInt(scn.nextLine());
					System.out.println("연락처>>");
					String tel = scn.nextLine();
					member.setMemberId(memberId);
					member.setTel(tel);
					
					if(dao.updateMember(member)) {
						System.out.println("정상수정");
					} else {
						System.out.println("예외발생");
					}
					break;
				} 
				case 4: {
					System.out.println("삭제할 회원번호>>");
					int memberId = Integer.parseInt(scn.nextLine());
					
					if(dao.deleteMember(memberId)) {
						System.out.println("정상삭제");
					} else {
						System.out.println("예외발생");
					}
					
					break;
				} 
				case 5: {
					System.out.println("조회할 회원번호>>");
					int memberId = Integer.parseInt(scn.nextLine());
					System.out.println(dao.showDetail(memberId)); 
					
					
					break;
				} 
				case 6: {
					System.out.println("프로그램 종료");
					scn.close();
					run = false;
				} 
				}
			}
		}
}
