let obj = { result: 0 };
obj.add = function (x, y) {
  console.log(this);

  function inner() {
    console.log(this);
    this.result = x + y;
  }
  inner();
  /* JavaScript에서 일반 함수의 this는 호출 방식에 따라 결정됨 
  inner()함수는 단독으로 호출되었기 때문에, 그 안의 this는 
  전역 객체(브라우저에서는 window, Node.js에서는 global)를 가리킴*/
};

obj.add(3, 4);
console.log(obj); // { result: 0 }
console.log(result); // 7
