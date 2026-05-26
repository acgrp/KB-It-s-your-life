<!-- 
  자식 -> 부모 이벤트 발신
-->
<template>
  <div>
    <!-- v-model을 사용하여 입력 값을 name변수에 양방향 바인딩 -->
    이름 : <input type="text" v-model="name" />

    <!-- 
    $emit 메소드를 사용하여 부모 컴포넌트로 이벤트 발신 
     $emit은 직계 부모 컴포넌트에게만 이벤트 발신 가능!
     -->

    <!-- 
     버튼 클릭 시 nameChanged 이벤트를 발신(방출)하고 
     name 데이터가 담긴 객체를 같이 전달
     -->
    <button @click="$emit('nameChanged2', { name })">이벤트 발신</button>
  </div>
</template>
<script>
export default {
  name: 'InputName', //컴포넌트 이름
  data() {
    return {
      name: '', //사용자가 입력한 이름을 저장할 변수
    };
  },
};
</script>
<style lang=""></style>
