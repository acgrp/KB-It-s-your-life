<script setup>
const props = defineProps({ username: String });
const avatar = `/api/member/${props.username}/avatar`; // 동적 아바타 생성
</script>

<template>
  <li class="nav-item">
    <router-link class="nav-link" to="/auth/profile">
      <!-- 
        img 태그의 src 속성에 URL을 작성하는 경우
        브라우저가 해당 주소로 자동으로 HTTP 요청을 보냄
      -->
      <img :src="avatar" class="avatar avatar-sm" />
      {{ username }}
    </router-link>
  </li>
</template>
