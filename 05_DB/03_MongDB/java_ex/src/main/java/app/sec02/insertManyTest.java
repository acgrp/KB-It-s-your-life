package app.sec02;

import app.sec01.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class insertManyTest {

    public static void main(String[] args) {


        MongoCollection<Document> collection = Database.getCollection("study");

        // 문서 리스트 객체 생성
        List<Document> list = new ArrayList<>();


        Document document1 = new Document();

        Document document2 = new Document();
        document1.append("title", "Dune2 영화보기");
        document1.append("desc", "이번 주말IMAX로Dune2 영화보기");
        document1.append("done", "false");

        document2.append("title", "Java MongoDB 연동");
        document2.append("desc", "Java로 MongoDB 연동 프로그래밍 연습하기");
        document2.append("done", "true");

        list.add(document1);
        list.add(document2);

        InsertManyResult result  = collection.insertMany(list);

        System.out.println("InsertManyResult : " + result.getInsertedIds());

        Database.close();
    }
}
