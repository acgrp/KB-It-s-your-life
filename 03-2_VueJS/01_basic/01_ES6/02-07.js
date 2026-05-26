/* ### 구조분해 할당(Destructuring Assingnment)

- 배열이나 객체의 속성을 해체하여 
  그 값을 개별 변수에 담을 수 있다.
*/

let arr = [10, 20, 30, 40];
let [a1, a2, a3] = arr;
console.log(a1, a2, a3);

// 객체 p1을 구조분해하여 name, age, gender 변수에
// 각각 속성의 값을 할당
let p1 = { name: '홍길동', age: 20, gender: 'M' };
let { name: n, age: a, gender } = p1;

// 구조분해된 변수들의 값을 출력
console.log(n, a, gender);
// 객체명.속성명
console.log(p1.name, p1.age, p1.gender);
console.log(p1);
