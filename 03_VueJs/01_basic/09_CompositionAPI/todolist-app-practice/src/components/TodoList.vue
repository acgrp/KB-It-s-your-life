<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem v-for="todoList in todolist" :key="todoList.id" :todoLists="todoList"
          @deleteList="$emit('deleteList', $event)" @Add-checkbox="$emit('Add-checkbox', $event)" />
        <!-- 이벤트 방출 시 전달되는 데이터는 $event로 수신 가능 -->
      </ul>
      <br>
      <button @click="deleteAll">전체삭제!</button>
    </div>
  </div>
</template>

<script setup>
import { defineEmits, defineProps } from 'vue';
// props, emit 사용하기 위해 import

import TodoListItem from './TodoListItem.vue';

const emit = defineEmits(['delete-all']);

const props = defineProps({
  // defineProps : Props 가져오는 함수

  todolist: {
    type: Array,
    required: true

  }
});

const deleteAll = () => {
  if (confirm("정말로 전체 삭제 하시겠습니까?")) {
    // confirm(내용) - 내용의 문구가 나오고 확인 취소로 true false를 구분

    emit('delete-all');
    // true일 경우 이벤트 발송
  }
}
</script>