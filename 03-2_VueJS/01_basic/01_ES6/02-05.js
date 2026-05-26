/* ### 기본 파라미터(Default Parameter) 

- 함수 매개변수에 기본값 지정 가능
- 형식 : function 함수명(arg1, arg2 = 기본값, ...)
*/

function addContact(
  name,
  mobile,
  home = '없음',
  address = '없음',
  email = '없음',
) {
  let str = `name=${name}, mobile=${mobile}, 
  home=${home}, address=${address}, email=${email}`;

  console.log(str);
}
addContact('홍길동', '010-222-3331');
addContact('이몽룡', '010-222-3331', '02-3422-9900', '서울시');
