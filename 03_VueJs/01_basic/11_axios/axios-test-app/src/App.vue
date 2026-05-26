<template>
  <div>
    <h2>콘솔 확인하기</h2>
  </div>
</template>

<script setup>
import axios from 'axios';
// axios : 서버랑 데이터를 주고 받는 도구

const requestAPI = () => {
  console.log('axios');

  // 프록시 서버 주소 변경 전
  // const url = 'http://localhost:3000/todos/1';

  // 프록시 서버 주소 변경 후
  const url = '/api/todos/1';

  // axios.get(url) : 해당 url로 요청 보내기
  // .then((res)=>{}) : 서버로부터 온 응답이 resp에 담김
  axios.get(url).then((res) => {
    console.log(res);
    console.log(url);
  });
};

requestAPI();
</script>

<style setup></style>
<!--  
  CORS 란
  - 다른 출처의 리소스를 공유할 수 있도록 허용하는 메커니즘
  - 웹 애플리케이션에서 다른 도메인의 리소스를 요청하는 경우, 
    보안 제한으로 인해 차단될 수 있음
  - 이를 해결하기 위해 CORS 헤더를 사용하여 허용된 도메인에서만 리소스를 공유할 수 있도록 함

  CORS 정책
  - 동일 출처 정책 : 동일한 출처에서만 리소스를 공유할 수 있도록 제한
  - 다른 출처에서 리소스를 요청하는 경우, 헤더를 통해 허용 여부를 결정
-->

<!-- 크로스 오리진 문제 해결 방법
 
  1. 프론트엔드에서 프록시 서버 설정
    - 브라우저 -> 프론트 개발 서버 -> 백엔드 서버 순으로 요청이 전달됨
    - 프론트 개발 서버가 프록시 역할을 하여 요청을 대신 전달하고,
      브라우저는 같은 출처로 인식하여 CORS 문제를 해결함

  2. 백엔드 서버에서 CORS 헤더 설정

-->
