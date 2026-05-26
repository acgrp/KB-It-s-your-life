<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

// 전체 목록을 조회한 후 한 건 씩 순차적으로 순회하면서 조회
const requestAPI = async () => {
  let res = await axios.get(listUrl);
  console.log(res);

  // 1. 전체목록 조회
  let todoList = res.data;
  console.log(todoList);

  // 2. 순차적으로 순회
  for (let i = 0; i < todoList.length; i++) {
    res = await axios.get(
      todoUrlPrefix + todoList[i].id,
    ); /* await이 없었으면 반복 불가 */
    console.log(`## ${i + 1}번째 Todo : `, res.data);
  }
};
requestAPI();
</script>

<style setup></style>
