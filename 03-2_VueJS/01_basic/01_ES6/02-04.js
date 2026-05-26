// p1이 참조하는 메모리 주소가 바뀌는 것이므로
// 에러 발생함.

const p1 = { name: 'john', age: 20 };
p1 = { name: 'lee', age: 25 };

console.log(p1); // TypeError: Assignment to constant variable.
