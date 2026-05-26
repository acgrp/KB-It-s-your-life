<template>
  <div>
    <h1>이벤트 유효성 검증</h1>

    <InputName2 @nameChanged2="nameChangHandler" />
    <br />
    <h3>App 데이터 : {{ parentName }}</h3>
  </div>
</template>

<script>
import InputName2 from './Components/InputName2.vue';

export default {
  name: 'App-2',
  components: { InputName2 },
  data() {
    return {
      parentName: '',
    };
  },
  methods: {
    nameChangHandler(e) {
      // e : 자식 컴포넌트에서 전달받은 이벤트 객체
      this.parentName = e.name;
      // Vue는 data에 있어야 화면에 반영된다!
    },
  },
};
</script>
<style lang=""></style>
