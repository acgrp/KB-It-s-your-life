package org.edu.member.service;

import org.edu.member.dao.MemberDao;
import org.edu.member.dao.MemberDaoImpl;
import org.edu.member.dao.MemberDaoImplJjs;
import org.edu.member.vo.Member;

import java.sql.SQLException;
import java.util.Scanner;

public class MemberService {
    private Scanner sc = new Scanner(System.in);

    // 숙제
    private MemberDao dao = new MemberDaoImplJjs();

    // 수업
    // private MemberDao dao = new MemberDaoImpl();


    public void displayMenu() {


        int menu = 0; // 메뉴 선택용 변수

        do {
            try {
            System.out.println("[메인 메뉴]");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 목록 조회");
            System.out.println("3. 회원 정보 조회");
            System.out.println("4. 회원 수정");
            System.out.println("5. 회원 삭제");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택 >> ");

            menu = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 개행문자 제거
            System.out.println(); // 줄바꿈

            switch (menu) {
                case 1:
                    create();
                    break;
                case 2:
                    getList(); // 전체조회
                    break;
                case 3:
                    //get();  // 회원 한명 조회
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    delete();
                    break;

                case 0:
                    System.out.println("[프로그램 종료]");
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
            }
            } catch (Exception e) {
                sc.nextLine(); // 잘못된 입력 제거
                e.printStackTrace();
        }
        } while (menu != 0);
    }

    // 회원 정보 전체 조회
    private void getList() {

        System.out.println("회원 전체 조회");


    }

    //회원 정보 삭제
    private void delete() throws SQLException {

        System.out.println("=== 회원 정보 삭제 ===");

        //회원 번호를 입력 받아 일치하는 회원의 정보 삭제

        System.out.print("삭제할 회원 번호 : ");

        int userNo = sc.nextInt();

        Member member = new Member();
        member.setNo(userNo);

        int result = dao.delete(member);

        if(result > 0) System.out.println(result + "개 삭제 완료.");
        else{
            System.out.println("삭제 실패");
        }

    }

    //회원 정보 수정
    private void update() throws SQLException {

        System.out.println("=== 회원 정보 수정 ===");

        // 회원 번호를 입력 받아 일치하는 회원의 이름, 권한 수정
        System.out.print("회원 번호 입력 : ");
        int userNo = sc.nextInt();

        Member findMember = new Member();
        findMember.setNo(userNo);

        int findResult = dao.select(findMember);

        if(findResult == 0) {
            System.out.println("존재하지않는 번호입니다.");
            return;
        }

        System.out.print("회원 이름 입력 : ");
        String userName = sc.next();
        System.out.print("권한 입력 :");
        String userrole = sc.next();

        Member member = new Member();
        member.setNo(userNo);
        member.setName(userName);
        member.setRole(userrole);

        int result = dao.update(member);

        if(result > 0) System.out.println("회원 정보 수정 성공 0_<");
        else System.out.println("회원 정보 수정 실패 ㅜㅜ");

    }

    // 회원 등록
    private void create() throws SQLException {
        System.out.println("=== 회원 등록 ===");

        //아이디, 비밀번호, 이름, 권한을 입력받아 각각 변수에 저장
        System.out.print("아이디 입력 :");
        String id = sc.next();

        System.out.print("비밀번호 입력 :");
        String pw = sc.next();

        System.out.print("이름 입력 :");
        String name = sc.next();

        System.out.print("권한 입력 :");
        String role = sc.next();

        //Member 객체 생성 후 전달
        Member member = new Member();
        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setRole(role);

        int result = dao.create(member);

        // 회원 등록 성공 시 : "000님의 가입을 환영합니다."
        //          실패 시 : "회원등록 실패 ㅠ.ㅠ"

        if(result == 1) System.out.println(name+"님의 가입을 환영합니다");
        else System.out.println("회원등록 실패 ㅠ.ㅠ");
    }

}
