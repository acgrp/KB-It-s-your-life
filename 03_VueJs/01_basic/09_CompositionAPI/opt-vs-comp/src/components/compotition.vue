<template>
  <div>
    <h3>Composition API 적용</h3>

    <div>
      이름 :
      <input
        type="text"
        placeholder="입력 시 대문자로 변환"
        :value="name"
        @input="changeName($event.target.value)"
      />
      <!-- $event.target : 이벤트가 발생한 요소 -->
    </div>
    <hr />

    <h5>계산하기</h5>
    <div>
      X : <input type="text" v-model.number="x" /><br />
      Y : <input type="text" v-model.number="y" /><br />
      <button @click="calculateSum(x, y, 1)">X + Y</button>
      <p>X + Y = {{ sum1 }}</p>
    </div>

    <div>
      A : <input type="text" v-model.number="a" /><br />
      B : <input type="text" v-model.number="b" /><br />
      <button @click="calculateSum(a, b, 2)">A + B</button>
      <p>A + B = {{ sum2 }}</p>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'; // ref() 함수를 가져옴
// ref() : 컴포넌트의 데이터를 정의하는 함수
// -> data() 함수의 역할을 대신함
// - .value 프로퍼티를 이용해서 데이터를 조작함

export default {
  name: 'Options',

  // setup() : 컴포넌트의 로직을 작성하는 함수
  // 컴포넌트 생명주기 beforeCreate, created 사이 단계에서 실행됨
  // setup() 내부에서 this 사용 불가
  setup() {
    // name 관련 로직만 모아둠
    const name = ref('');

    const changeName = (inputName) => {
      console.log('이름 변경 함수 실행');
      name.value = inputName.toUpperCase();
    };

    // setup()에서 템플릿에 사용할 모든 변수와 함수는 반환해야한다.
    return { name, changeName, ...useCalc() };
    // ...(spread 문법) : useCalc()가 반환하는 객체를 펼쳐서 넣음
  },
};

// 계산과 관련된 로직만 모아둠 + 재사용 가능한 함수 형태로 작성
export const useCalc = () => {
  const x = ref(3);
  const y = ref(5);
  const sum1 = ref(0);

  const a = ref(4);
  const b = ref(5);
  const sum2 = ref(0);

  const calculateSum = (num1, num2, type) => {
    if (type === 1) {
      // x + y 버튼 클릭 시
      sum1.value = num1 + num2;
    } else {
      // a + b 버튼 클릭 시
      sum2.value = num1 + num2;
    }
  };

  return { x, y, sum1, a, b, sum2, calculateSum };
};
</script>

<style scoped></style>
