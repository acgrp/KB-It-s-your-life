// user = {user:'홍길동'} 이상태라 홍길동을 쓰려면 user.user을 해야함

// const user = require('./07_user.js');
// const hello = require('./08_user.js');

// hello.hello(user.user); // 모듈에서 가져온 user 변수와 hello 함수 사용하기

// {}에 쌓여져 있는 상태이기에 씌워서 받아야 바로 사용가능
const { user } = require('./06_user.js');
const { hello } = require('./01_hello.js');

console.log(user);
console.log(hello);

hello(user); // 모듈에서 가져온 user 변수와 hello 함수 사용하기
