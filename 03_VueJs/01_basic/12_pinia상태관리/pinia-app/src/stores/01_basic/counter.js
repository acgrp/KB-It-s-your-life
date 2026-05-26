import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

/**
 * Pinia란?
 * Vue3에서 사용하는 상태 관리 라이브러리 (Vuex의 대체)
 * - 전역 상태를 관리할 수 있음
 * - setup 문법과 잘 어울림
 * - 사용법이 간단하고 직관적
 */

/**
 * Pinia 기본 구조
 *
 * defineStore()를 사용해서 store를 생성한다.
 * store는 크게 3가지로 구성된다.
 *
 * 1. state   → 데이터 (변수)
 * 2. getters → 계산된 값
 * 3. actions → 함수 (비즈니스 로직)
 */

// Store 정의 - 'counter'는 스토어의 이름(고유 식별자)
export const useCounterStore = defineStore('counter', () => {
  // 상태(state) 정의
  const count = ref(0);

  // 계산된 속성(getters) 정의
  const doubleCount = computed(() => count.value * 2);

  // 함수(actions) 정의
  function increment() {
    // 복잡한 로직, 비동기 작업 처리, 상태 변경 등의 코드 작성
    count.value++;
  }

  // 0으로 초기화
  function reset() {
    count.value = 0;
  }

  // 사용할 상태와 메소드 반환
  return { count, doubleCount, increment, reset };
});
