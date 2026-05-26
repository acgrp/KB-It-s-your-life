/* ## 새로운 객체 리터럴(ES6 객체 리터럴)

- 변수명이 객체의 속성명과 일치하는 경우 변수명만 제시 가능
- 메서드인 경우function 키워드 없이 바로 선언 */
let name = '홍길동';
let age = 20;
let email = 'gdhong@test.com';
//let obj = { name: name, age: age, email: email };
let obj = { name, age, email };
console.log(obj);
