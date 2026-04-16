<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          placeholder="할일을 여기에 입력!"
          v-model="todo"
          @keyup.enter="addTodoHandler"
        /><!-- keydown은 눌려있을때 / keyup은 한번 -->
        <button class="btn btn-primary" type="button" @click="addTodoHandler">
          추가
        </button>
      </div>
      <div class="count d-flex justify-content-between">
        <span>{{ `총 개수 :${completedCount() + incompleteCount()} ` }}</span>
        <span>{{ `완료된 개수 :${completedCount()} ` }}</span>
        <span>{{ `미완료 개수 :${incompleteCount()} ` }}</span>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, defineProps, defineEmits } from 'vue';
x;
// props - defineProps / Emit - defineEmits 사용하기 위해 선언

const props = defineProps({
  todolist: {
    type: Array,
    required: true,
  },
});

const emit = defineEmits(['addTodo']);

const todo = ref('');

const completedCount = () => {
  return props.todolist.filter((item) => item.completed).length;
};
const incompleteCount = () => {
  return props.todolist.filter((item) => !item.completed).length;
};
const addTodoHandler = () => {
  if (todo.value.length < 3) {
    alert('할일은 3글자 이상 입력해주세요.');
    return;
  }
  emit('addTodo', todo.value);
  todo.value = '';
  return;
};
</script>
