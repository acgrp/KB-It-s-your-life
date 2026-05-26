// mjs에서는 require사용 불가

// const {user} = require('./07_user.js');
// const {goodbye} = require('./12_goodbye-1.mjs');


// 1. 다른 파일들(모듈) 가져오기
import users from './07_user.js';
import { goodbye1 } from './12_goodbye-1.mjs';

// 2. 상자(객체)에서 알맹이 꺼내기
const { user } = users; 

// 3. 실행하기
goodbye1(user);