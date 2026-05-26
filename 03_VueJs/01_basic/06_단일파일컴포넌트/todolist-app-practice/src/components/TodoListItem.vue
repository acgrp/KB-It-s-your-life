<template>
  <li class="list-group-item">
    <input type="checkbox" class="pointer me-3" />
    <span class="pointer"> {{ todo }} </span>
    <span class="float-end badge bg-secondary pointer">삭제</span>
  </li>
</template>
<script>
import App from '../App.vue';

export default {
  name: 'TodoListItem',
  conponents: {
    App,
  },
};
</script>
