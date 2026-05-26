<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';
// axios : 서버랑 데이터를 주고 받는 도구(get, post, del)

// 전체 목록 조회 URL
const listUrl = '/api/todos';

// Promise 체인 방식
// -> 결과를 다음을 넘기면서 순서대로 실행하는 구조

// 4건의 목록을 조회한 후 첫 번째, 두 번째 할 일을 순차적으로 조회
const requestAPI = () => {
  let todoList = []; /* 전체 목록을 담아둘 변수 */

  // 1. 전체 목록 조회
  axios
    .get(listUrl)

    // 1-1 목록 조회 완료 후 실행
    .then((res) => {
      // resp.data : 서버에서 받은 실제 데이터
      todoList = res.data;
      console.log('# TodoList : ', todoList);

      // 다음 then으로 첫 번째 todo의 id 전달
      return todoList[0].id;
    })

    // 2. 첫 번째 todo 상세 조회
    .then((id) => {
      // id를 이용해 상세 조회 API 호출
      return axios.get('/api/todos/' + id);
    })
    .then((response) => {
      console.log('## 첫 번째 Todo :', response);

      // 두 번째 todo id를 다음 then으로 전달
      return todoList[1].id;
    })
    // 3. 두 번째 todo 상세 조회
    .then((id) => {
      // console.log(id);
      axios.get('/api/todos/' + id).then((res) => {
        console.log('##  두 번째 Todo : ', res.data);
      });
    });
};

requestAPI();
</script>

<style setup></style>
