<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
/*
try - catch - finally
* try : 예외가 발생할 가능성이 있는 코드
* catch(e){ } : 예외 발생 시 수행 할 코드
* finally {} : 마지막에 무조건 수행
*/
import axios from 'axios';
// 에러 처리 예제

const requestAPI = async () => {
  try {
    // 에러 발생 시 즉시 종료 후 catch문으로 이동
    const url = '/api/todos2';
    let res = await axios.get(url);
    console.log('응답 객체 : ', res);
  } catch (e) {
    console.log('에러 발생 시에만 수행');
    if (e instanceof Error) console.log(e.messages);
    else console.log(e);
  } finally {
    // 무조건 수행
    console.log('finally는 무조건 수행!');
  }
};

requestAPI();
</script>

<style setup></style>
