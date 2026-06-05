package app.sec03;

import app.sec01.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
//import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;


public class FindOneTest {

    public static void main(String[] args) {

        MongoCollection<Document> collection = Database.getCollection("study");

        // FindIterable : 조회 결과를 반복자(Iterator) 형태로 반환할 수 있는 객체
        String id = "6a226ea66641b10c019372da";
        Bson query = eq("_id", new ObjectId(id));

        //조건을 만족하는 결과 중 1행(문서 1개)만 조회
        Document doc = collection.find(query).first();

        System.out.println(doc);

        Database.close();


    }

}
