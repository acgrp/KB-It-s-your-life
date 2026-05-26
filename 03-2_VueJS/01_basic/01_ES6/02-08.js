// 구조분해 할당을 사용하여 함수 정의
function addContact1({ name, phone, email = '이메일없음', age = 0 }) {
  console.log(name, phone, email, age);
}
addContact1({ name: '이몽룡', phone: '010-3434-8989' });

function addContact2(contact) {
  if (!contact.email) contact.email = '이메일없음';
  if (!contact.age) contact.age = 0;

  // 객체의 속성을 구조분해하여 변수에 할당
  let { name, phone, email, age } = contact;
  console.log(name, phone, email, age);
}
addContact2({ name: '이몽룡', phone: '010-3434-8989' });

// 객체 사용 X
function addContact3(name, phone, email = '이메일없음', age = 0) {
  console.log(name, phone, email, age);
}
addContact3('이몽룡', '010-3434-8989');
