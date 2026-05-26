<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="todoList in todolist"
          :key="todoList.id"
          :todoLists="todoList"
          @deleteList="$emit('deleteList', $event)"
          @Add-checkbox="$emit('Add-checkbox', $event)"
        />
        <!-- 이벤트 방출 시 전달되는 데이터는 $event로 수신 가능 -->
      </ul>
    </div>
  </div>
</template>
<script>
import TodoListItem from './TodoListItem.vue';

export default {
  name: 'TodoList',
  components: {
    TodoListItem,
  },
  props: {
    todolist: {
      type: Array,
      required: true,
    },
  },
};
</script>
