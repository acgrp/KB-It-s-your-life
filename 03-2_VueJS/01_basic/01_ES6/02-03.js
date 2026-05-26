/* ### const 

- 상수를 선언하는 키워드
- SCOPE는 let과 동일
- 값을 변경할 수 없으나, 
  객체나 배열의 경우 내부 속성은 변경 가능

*/

const p1 = { name: 'john', age: 20 };
p1.age = 22;
console.log(p1);
// p1 = { name: 'lee', age: 25 };
