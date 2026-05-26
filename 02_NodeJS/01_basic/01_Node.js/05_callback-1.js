const order = (menu, callback) => {
  console.log(`${menu}} 주문 접수`);

  setTimeout(() => {
    console.log(`<<3초 경과 후>>`);
    //
    callback(menu);
  }, 3000);
};

const display = (result) => {
  console.log(`${result} 완료!`);
};

//함수이름('A', B) : B는 callback으로 이어짐
order('아메리카노', display);
