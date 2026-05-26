<template>
  <div>
    <h3>Options API 적용</h3>
    <div>
      이름 :
      <input
        type="text"
        placeholder="입력 시 대문자로 변환"
        @input="changeName($event.target.value)"
      />
      <!-- $event.target : 이벤트가 발생한 요소 -->
    </div>
    <hr />
    <h5>계산하기</h5>
    <div>
      X : <input v-model.number="x" type="text" /> <br />
      Y : <input v-model.number="y" type="text" /> <br />
      <button @click="calculateSum(x, y, 1)">더하기</button>
      <p>X + Y = {{ sum }}</p>
    </div>
    <div>
      A : <input v-model.number="a" type="text" /> <br />
      B : <input v-model.number="b" type="text" /> <br />
      <button @click="calculateSum(a, b, 2)">더하기</button>
      <p>A + B = {{ sum2 }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'options',
  data() {
    return {
      name: '',
      x: 0,
      y: 0,
      a: 0,
      b: 0,
      sum: 0,
      sum2: 0,
    };
  },
  methods: {
    changeName(e) {
      // console.log(inputNaem);
      // 문자열.toUpperCase() : 대문자로 변환
      //   console.log(e.toUpperCase());
      this.name = e.toUpperCase();
    },

    // 계산용 메소드
    calculateSum(x, y, z) {
      if (z === 1) {
        // x + y 버튼 클릭시
        this.sum = x + y;
      } else {
        // a + b 버튼 클릭시
        this.sum2 = x + y;
      }
    },
  },
};
</script>
<style lang=""></style>
