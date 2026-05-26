// 실행하기
// 터미널 열기 : Ctrl + shift + `
// cmd로 변경 후 파일 있는 곳으로 이동 (cd)
// node 파일명.js
// (주의!!) 꼭 저장하고 실행 할 것!!

function hello(name) {
  /* // 함수 선언 */
  //함수 정의
  console.log(name + '님, 안녕하세요?');
}

hello('홍길동'); // 함수 호출

module.exports = { hello };
