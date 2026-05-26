<template>
  <div>
    <h2>App 컴포넌트22</h2>
    <hr />
    <ul>
      <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
    </ul>
  </div>
</template>

<script>
// 단일 파일 컴포넌트
// import 이름 from '주소';
// export default {name: '현재파일이름', components: {이름},}
import CheckboxItem from './Components/CheckboxItem1-1.vue';
export default {
  name: 'App',

  // 가져온 도구 목록
  components: { CheckboxItem },
};
</script>
