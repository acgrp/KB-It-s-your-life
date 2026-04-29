package main.java.ch09_collection_generic.collection.map.ex;

import java.util.*;

public class MapEx {
    /* Map : 특정 키워드(key)를 입력하면
     *       해당되는 상세한 값(value)을 얻을 수 있는 컬렉션 객체
     *
     * - K:V 한 쌍으로 데이터를 저장
     *  (K:V 한쌍을 묶어서 Entry라고 부름)
     *
     * - Key : 키워드 역할
     * 1) 중복 X (Key 중복 시 Value를 새로운 내용으로 덮어씌움)
     *  * Key 역할을 하는 객체에는 equals(),
     *    hashCode()가 오버라이딩 되어있어야 함
     *
     * 2) 순서 유지 X
     * --> Map에서 Key만 묶어놓으면 Set과 같은 특징을 지님
     *
     * - Value : 키워드에 대응되는 값의 역할
     * 1) Key로 인해서 구분됨 -> 중복 허용
     * --> Value만 묶어놓으면 List와 같은 특징을 지님
     * */

    public void ex1() {
        // Key제한 Value 제한
        Map<Integer, String> map = new HashMap<>();

        // HashMap : Map의 자식 클래스 중 가장 대표되는 Map

        // 1. map.put(K k, V v) : Map에 추가
        // Map에 추가 시 Key가 중복되면 새로운 Value로 덮어씌우고 이전 Value 반환
        // 중복이 아니라면 null 반환

        System.out.println(map.put(1, "돈까스"));
        System.out.println(map.put(2, "해물파전"));
        System.out.println(map.put(3, "골뱅이무침"));
        System.out.println(map.put(4, "골뱅이무침"));
        System.out.println(map.put(4, "육전"));

        System.out.println(map);

        // 2. map.get(K k)
        // - map에서 Key에 해당하는 Value 반환
        // 일치하는 Key가 없으면 null 반환
        System.out.println(map.get(2));

        // 3. map.size() : 저장된 K:V 쌍의 수를 반환
        System.out.println(map.size());

        // 4. map.remove(K k)
        // - map에서 Key가 일치하는 요소(K:V)를 제거
        // 제거되는 V 반환, 없으면 null 반환
        System.out.println(map.remove(1) + " 제거");
        System.out.println(map.remove(10) + " 제거");

        System.out.println(map);
    }

    public void ex2() {
        // Map에 저장된 값 순차 접근

        Map<String, String> map = new HashMap<>();

        map.put("4월 28일", "화요일");
        map.put("4월 29일", "수요일");
        map.put("4월 30일", "목요일");

        // 1. Set map.keySet()
        // - key만을 모아놓은 집합(Set)을 반환

        Set<String> set = map.keySet();
        System.out.println(set);

        // 2. KeySet을 이용해서 Map에 있는 모든 요소 순차 접근

        for (String st : set){
            System.out.printf("[%s] %s", st, map.get(st));
        }

    }

    public void ex3() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++){

            // Map 생성
            Map<String, Object> map = new HashMap<>();

            // map에 데이터 추가
            map.put("id", "user0" + i);
            map.put("pw", "pass0" + i);

            //map을 List에 추가
            list.add(map);

        }
        // for문 종료 시 List에는 10개의 map객체가 추가되어 있음
//        System.out.println(list);

        // List에 저장된 Map에서 Key가 "id"인 경우의 value 모두 출력
        for (Map<String, Object> str : list){
            System.out.println("id : " + str.get("id"));
        }
    }
}


