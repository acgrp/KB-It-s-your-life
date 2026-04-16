<template>
  <div>
    <h2>Counter</h2>
    <h3>값 꺼내기 (doubleCount): {{ counter.count }}</h3>
    <h3>값 꺼내기 (doubleCount): {{ count }}</h3>
    <button @click="increment">1씩 증가</button>
    <button @click="reset">0으로 초기화</button>
    <button @click="se">자체적으로 1 증가</button>
  </div>
</template>

<script setup>
import { useCounterStore } from '@/stores/01_basic/counter';

const counter = useCounterStore();
// 값 자체를 가져올 때 반응형이 깨지기 때문에(반응을 안한다)
// 객체 자체를 가져와서 꺼내쓰는 것이 권장됨
const { count, increment, reset } = useCounterStore();

//  권장하지 않는 방식
const selfIncrement = () => {
  counter.count++;
};
</script>
