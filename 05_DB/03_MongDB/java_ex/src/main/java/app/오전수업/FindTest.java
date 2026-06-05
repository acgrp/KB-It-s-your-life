package app.오전수업;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Iterator;

import static com.mongodb.client.model.Filters.eq;
//import com.mongodb.client.model.Filters;

public class FindTest {
    public static void main(String[] args) {
        //Database클래스를 쓰는 순간 static{ }이 실행이 됨.db서버연결, db연결이 준비가 됨.
        MongoCollection<Document> collection = Database.getCollection("todo");
        System.out.println("3. todo 컬렉션 연결 성공.");

        //전체 검색해보자.
//        FindIterable<Document> doc = collection.find();
        //조건 검색--> json으로 조건을 만들자.(BSON)
        Bson query = eq("_id", new ObjectId("6a222fa1ae4e9c29a3260cc1"));

        FindIterable<Document> doc = collection.find(query);
        System.out.println(doc);

        //FindIterable 인덱스가 없어서 반복해서 Document를 꺼내줄 수 없음.
        //외부에 반복해서 꺼내주는 반복자를 설정해야함. Iterator
        //있는지 체크(hasNext())하고 있으면 꺼내줌(next()).
        Iterator<Document> iterator = doc.iterator();
        while(iterator.hasNext()) {
//            System.out.println(iterator.next());
            Document document = (Document) iterator.next();
            System.out.println(document.get("title"));
        }
        Database.close();
    }
}