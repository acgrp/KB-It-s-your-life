package main.java.ch15.sec02.exam01;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {

        ArrayList<Board> list = new ArrayList<>();
        
        list.add(new Board("제목1", "내용1", "작성자1"));
        list.add(new Board("제목2", "내용2", "작성자2"));
        list.add(new Board("제목3", "내용3", "작성자3"));
        list.add(new Board("제목4", "내용4", "작성자4"));
        list.add(new Board("제목5", "내용5", "작성자5"));

        System.out.println(list.size());
        System.out.println(list.get(2));

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        list.remove(2);
        list.remove(2);

        for(Board str : list) {
            System.out.println(str);
        }
    }
}
