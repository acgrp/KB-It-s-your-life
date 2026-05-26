const path = require('path');
const { fileURLToPath } = require('url');
const fullPath = path.join('some', 'work', 'ex.txt');
console.log(fullPath);

const allpath = path.join(__filename);
// __filename : 현재 파일이라는 뜻
console.log(`파일 절대 경로 : ${__filename}`);

console.log(`경로만 : ${allpath}`);

const fn = path.basename(__filename);
const fn2 = path.basename(__filename, 'js');
// 끝에 쓴 ' ' 확장자 제외
console.log(`파일 이름 : ${fn}`);
console.log(`파일 이름(확장자 제외) : ${fn2}`);

const __filenamee = fileURLToPath(import.meta.url);

console.log('출력');
console.log('...');
const ext = path.extname(__filenamee);
console.log(`파일 확장자: ${ext}`);

console.log('...');

const pathParsed = path.parse(__filenamee);
console.log(pathParsed);
