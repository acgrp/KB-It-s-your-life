/* ### 화살표 함수 (Arrow Function)

- 함수를 간결하게 정의할 수 있는 문법
- 한 줄 표현식은 return, {} 생략 가능

*/
const test1 = function (a, b) {
  return a + b;
};
const test2 = (a, b) => {
  return a + b;
};
const test3 = (a, b) => a + b;

console.log(test1(3, 4));
console.log(test2(3, 4));
console.log(test3(3, 4));
