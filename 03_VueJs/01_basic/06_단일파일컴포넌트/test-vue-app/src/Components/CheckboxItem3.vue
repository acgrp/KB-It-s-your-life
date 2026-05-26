<!-- props 속성 사용 (객체 전달)
  props 목적 : 자식 컴포넌트가 필요한 데이터를 전달 받아
                UI 렌더링 하는 것 
-->

<template lang="">
  <li><input type="checkbox" :checked="checked" />{{ id }}- {{ name }}</li>
</template>
<script>
export default {
  name: 'CheckboxItem', //컴포넌트 이름
  // props: ['name', 'checked', 'id'],

  // 부모 -> 자식으로 넘어오는 데이터 타입 정의
  // 유효하지 않은 경우 콘솔에 경고
  props: {
    id: [Number, String] /* 타입만 정의 */,
    name: String,
    checked: {
      /* 타입 + 옵션 정의 */

      type: Boolean,
      default: false,
      required: false,
    },
  },
};
</script>
<style lang=""></style>
