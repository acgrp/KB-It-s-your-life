<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="list in lists"
          :key="list.id"
          :TodoListItem="TodoListItem"
        />
      </ul>
    </div>
  </div>
</template>
<script>
import InputtTodo from './InputtTodo.vue';

export default {
  name: 'TodoList',
  components: {
    InputtTodo,
  },
};
</script>
