<template>
  <li class="list-group-item" :class="{ 'list-group-item-success': todoLists.completed }">
    <input type="checkbox" class="pointer me-3" @click="$emit('Add-checkbox', todoLists.id)"
      :checked="todoLists.completed" />

    <span class="pointer" :class="{ 'todo-done': todoLists.completed }">{{ todoLists.todo }} {{ todoLists.completed ?
      `(완료)` : '' }}</span>
    <span @click="$emit('deleteList', todoLists.id)" class="float-end badge bg-secondary pointer">삭제</span>
  </li>
</template>

<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  todoLists: {
    type: Object,
    required: true
  }
})
</script>
