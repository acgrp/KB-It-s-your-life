<template lang="">
  <div>
    <h3>다른 컴포넌트</h3>
    <h5>계산하기</h5>
    <div>
      X : <input type="text" v-model.number="x" /><br />
      Y : <input type="text" v-model.number="y" /><br />
      <button @click="calculateSum(x, y, 1)">X + Y</button>
      <p>X + Y = {{ sum1 }}</p>
  </div>
</template>
<script>
import {usercalC} from './composition.vue'
</script>

const x, y, sum1, calculateSum = userClac();
<!-- useCalc()의 return 된 객체에서 필요한 속성만 가져옴 -->

<style lang=""></style>
<!-- ----------------------------------------------- -->
<!-- 
<script>
import { useCalc } from './Composition.vue';
export default {
  setup() {
    const { x, y, sum1, calculateSum } = useCalc();

    return { x, y, sum1, calculateSum };
  },
};
</script> -->