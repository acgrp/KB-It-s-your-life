import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

const initState = {
  token: '', // 접근 토큰(JWT)
  user: {
    username: '', // 사용자 ID
    email: '', // Email
    roles: [], // 권한 목록
  },
};

export const useAuthStore = defineStore('auth', () => {
  const state = ref({ ...initState });

  // 로그인 여부
  const isLogin = computed(() => !!state.value.user.username);

  // 로그인 사용자 ID
  const username = computed(() => state.value.user.username);

  // 로그인 사용자 Email
  const email = computed(() => state.value.user.email);

  // 로그인
  const login = async (member) => {
    state.value.token = 'test token';

    state.value.user = {
      username: member.username,
      email: member.username + '@test.com',
      roles: [],
    };

    localStorage.setItem('auth', JSON.stringify(state.value));
  };

  // 로그아웃
  const logout = () => {
    localStorage.clear();
    state.value = { ...initState };
  };

  // 토큰 가져오기
  const getToken = () => state.value.token;

  // localStorage에서 로그인 정보 불러오기
  const load = () => {
    const auth = localStorage.getItem('auth');

    if (auth != null) {
      state.value = JSON.parse(auth);
      console.log(state.value);
    }
  };

  // 스토어 생성 시 자동 실행
  load();

  return {
    state,
    username,
    email,
    isLogin,
    login,
    logout,
    getToken,
  };
});
