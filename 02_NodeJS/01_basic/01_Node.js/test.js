// 1. CommonJS 방식 내보내기

const user = '홍길동';

module.exports = {
  user: user,
};

// 2. ES모듈 단일(export 내보내기)
const goodbye = (name) => {
  console.log(`${name} 님, 안녕히 가세요.`);
};

export const bye = goodbye;

// 2-1. ES모듈 단일(export default 불러오기)
export default goodbye;

// 3. ES모듈 복수
const hi = (name) => {
  console.log(`${name}님, 안녕하세요?`);
};

const goodbye3 = (name) => {
  console.log(`${name}님, 안녕히 가세요.`);
};

export { hi, goodbye };

// 3-1. ES모듈
export default { hi, goodbye };

// -------------------------------------------------------

// 1. CommonJS 방식 불러오기
const data = require('./06_user.js');

// 2. ES모듈 단일(export 불러오기)+default도 동일
const {user} = require('./06_user.js');

// 3. 가져오는 종류 (상자에 담거나 안담거나)
    //  1) 다른 파일들(모듈) 가져오기
import users from './06_user.js';
import { goodbye1 } from './12_goodbye-1.mjs';

    //  2) 상자(객체)에서 알맹이 꺼내기
const { user } = users; 

    //  3) 실행하기
goodbye1(user);

// 4. ES 복수로 보낸것 따로 받기
import { hi, goodbye } from '../01_basic/14_greeting-1.mjs';

hi('홍길동');
goodbye('홍길동');

// 5. ES 복수로 보낸 것 하나로 받아서 쓰기
import say from './04_greeting-2.mjs';

say.hi('홍길동');
say.goodbye('홍길동');




//  / : 하위
// ../ : 상위
