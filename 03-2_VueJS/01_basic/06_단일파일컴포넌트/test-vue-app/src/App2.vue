<template>
  <div>
    <h2>관심있는 K-POP 가수?</h2>
    <ul>
      <CheckboxItem2 v-for="idol in idols" :key="idol.id" :idol="idol" />
    </ul>
    <!-- 컴포넌트간 정보 전달
      - 속성(Props) : 부모 컴포넌트에서 자식 컴포넌트로 정보 전달
        - 부모 컴포넌트 v-bind 디렉티브를 사용하여 자식 컴포넌트에 속성 전달
        - 자식 컴포넌트에서는 props 속성을 사용하여 전달받은 속성 사용
        - 단방향 데이터 흐름(부모 -> 자식, 자식은 전달 받은 값 변경 불가)
  
        - 속성 전달 시 데이터 타입 지정 가능
        - 속성 전달 시 기본값 지정 가능
        - 속성 전달 시 유효성 검사 가능
        -->
  </div>
</template>
<script>
import CheckboxItem from './Components/CheckboxItem.vue';
import CheckboxItem2 from './Components/CheckboxItem2.vue';

export default {
  // 내보내는 컴포넌트의 이름
  // App.vue는 루트 컴포넌트! -> 이름 미지정 시 <Root> 태그로 렌더링
  name: 'App',

  // 지역 컴포넌트 등록
  components: { CheckboxItem, CheckboxItem2 },
  data() {
    return {
      // props로 전달할 부모 데이터
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink', checked: false },
        { id: 3, name: 'EXO', checked: false },
        { id: 4, name: 'ITZY', checked: false },
      ],
    };
  },
};
</script>
