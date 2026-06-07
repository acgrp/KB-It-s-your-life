package org.edu.member.service;

import org.edu.member.dao.MemberDao;
import org.edu.member.dao.MemberDaoImpl;
import org.edu.member.dao.MemberDaoImplJjs;
import org.edu.member.vo.Member;

import java.sql.SQLException;
import java.util.Scanner;

public class MemberService {

    private Scanner sc = new Scanner(System.in);

//    private MemberDao dao = new MemberDaoImpl();

    private MemberDao dao = new MemberDaoImplJjs();

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
                System.out.println("6. 회원 부서명 조회");
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
                        get();  // 회원 한명 조회
                        break;
                    case 4:
                        update();
                        break;
                    case 5:
                        delete();
                        break;
                    case 6:
                        getDeptName();
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

    public void create() throws SQLException {

        System.out.println("=== 회원 등록 ===");

        System.out.print("아이디 입력 : ");

        String id = sc.next();

        System.out.print("비밀번호 입력 : ");
        String pw = sc.next();

        System.out.print("이름 입력 : ");
        String name = sc.next();

        System.out.print("권한 입력 : ");
        String role = sc.next();

        Member member = new Member();

        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setRole(role);

        int result = dao.create(member);

        if(result > 0) System.out.println(name+"님 가입을 환영합니다.");
        else System.out.println("회원등록 실패");

    }

    private void getList() throws SQLException {

        System.out.println("회원 전체 정보를 불러옵니다...");

        dao.selectAll();

    }

    private void get() throws SQLException {

        System.out.println("=== 회원 정보 조회 ===");

        System.out.print("조회할 회원 번호 : ");
        int no = sc.nextInt();

        Member member = new Member();
        member.setNo(no);

        dao.select(member);

    }

    private void update() throws SQLException {

        System.out.println("=== 회원 정보 변경 ===");

        System.out.print("변경할 회원 번호 : ");
        int no = sc.nextInt();

        System.out.print("변경할 이름 : ");
        String name = sc.next();

        System.out.print("변경할 권한 : ");
        String role = sc.next();
        Member member = new Member();
        member.setNo(no);
        member.setName(name);
        member.setRole(role);

        int result = dao.update(member);

        if(result > 0) System.out.println("회원 정보 변경 완료 0_<");
        else System.out.println("변경 실패 ㅜ.ㅜ");
    }

    private void delete() throws SQLException {

        System.out.println("=== 데이터 삭제 ===");

        System.out.println("삭제할 회원 번호");

        int no = sc.nextInt();

        Member member = new Member();
        member.setNo(no);

        int result = dao.delete(member);

        if(result > 0) System.out.println("회원 삭제 완료");
        else System.out.println("삭제 실패 ㅠㅠㅠ");
    }

    //회원번호가 일치하는 회원의 번호, 이름, 부서코드, 부서명 조회
    private void getDeptName() throws SQLException {

        System.out.println("=== 회원의 부서명 조회 ===");

        System.out.print("찾을 회원 번호 : ");
        int no = sc.nextInt();

        Member member = new Member();

        member.setNo(no);

        dao.getDeptName(member);

    }
}
