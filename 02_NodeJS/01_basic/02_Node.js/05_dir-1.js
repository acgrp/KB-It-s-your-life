fs = require('fs');
if (fs.existsSync('./test')) {
  // 디렉터리가있다면
  console.log('folder already exists');
} else {
  // 디렉터리가없다면
  fs.mkdir('./test', (err) => {
    if (err) {
      return console.error(err);
    }
    console.log('folder created');
  });
}
