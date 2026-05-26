/* ### 가변 파라미터 (Rest Parameter)

  - 전달된 인수를 매개변수로 매칭한 후, 
    매칭되지 않은 인수를 모아 배열로 지정 

  - 1개만 지정 가능, 마지막에만 작성 가능

  - 형식 : function 함수명(arg1, arg2, ...argv)

*/
function foodReport(name, age, ...favoriteFood) {
  console.log(name + ', ' + age);
  console.log(favoriteFood);
}
foodReport('이몽룡', 20, '짜장면', '냉면', '불고기');
foodReport('홍길동', 16, '초밥');
