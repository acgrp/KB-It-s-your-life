// 1. 피자 주문 Promise 생성
const orderPizza = new Promise((resolve, reject) => {
  const success = true; // 주문 성공 여부 (false로 바꾸면 에러 상황 테스트 가능)

  if (success) {
    resolve('피자를 주문했습니다.'); // 성공 시 전달할 메시지
  } else {
    reject('피자를 주문하지 않습니다.'); // 에러 시 전달할 메시지
  }
});

// 2. Promise 실행 및 결과 출력
orderPizza
  .then((message) => {
    // resolve가 호출되었을 때 실행
    console.log(message);
  })
  .catch((error) => {
    // reject가 호출되었을 때 실행
    console.log(error);
  });
