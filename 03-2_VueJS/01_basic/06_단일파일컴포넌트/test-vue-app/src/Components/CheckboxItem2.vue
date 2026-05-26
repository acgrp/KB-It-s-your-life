<!-- props 속성 사용 (객체 전달) 
  - props 목적 : 자식 컴포넌트가 필요한 데이터를 전달 받아
                 UI 렌더링 하는 것
-->

<template lang="">
  <li><input type="checkbox" />{{ idol.name }}</li>
</template>
<script>
export default {
  name: 'CheckboxItem', // 컴포넌트 이름
  props: ['idol'],
  // props로 전달 받은 idol 객체
};
</script>
