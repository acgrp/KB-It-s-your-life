<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default panel-borderless">
      <div class="card-body">
        <InputTodo :todolist="todoList" @addTodo="addTodo" />

        <button @click="sortList" class="btn btn-outline-info btn-sm mb-2">
          {{ isSorted ? '기본 정렬' : '미완료 정렬' }}</button>
          <!-- isSorted가 true면 기본 정렬버튼으로 변경 / isSorted가 false면 미완료정렬 -->

        <TodoList :todolist="todoList" @delete-All="deleteAll" @deleteList="deleteList"
          @Add-checkbox="checkedcontact" />
      </div>
    </div>
  </div>
</template>

<script setup>
// name, components, module default, return, setup 생략!

import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';
import { ref, reactive } from 'vue';

let ts = new Date().getTime();

const todoList = reactive([
  { id: ts, todo: '자전거 타기', completed: false },
  { id: ts + 1, todo: '딸과 공원 산책', completed: true },
  { id: ts + 2, todo: '일요일 애견 카페', completed: false },
  { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
  { id: ts + 4, todo: 'Vue.js 3 컴포넌트 구조 복습하기', completed: true },
  { id: ts + 5, todo: '방 청소 하기', completed: false },
  { id: ts + 6, todo: '분리수거 하기', completed: true },
  { id: ts + 7, todo: '책 읽기', completed: false },
  { id: ts + 8, todo: '운동하기', completed: false },
  { id: ts + 9, todo: '공부하기', completed: true },
  { id: ts + 10, todo: '커밋하기', completed: false },
])

const deleteList = (id) => {
  let index = todoList.findIndex((ele) => id === ele.id);
  // console.log(index);

  todoList.splice(index, 1);
  // splice(시작index, 삭제개수)
}

const addTodo = (todo) => {
  console.log(todo);
  todoList.push({
    id: ts + todoList.length,
    todo: todo,
    complted: false,
  });
}

const checkedcontact = (id) => {
  let index = todoList.findIndex((item) => id === item.id);
  todoList[index].completed = !todoList[index].completed;
}

const deleteAll = () => {
  todoList.splice(0, todoList.length);
};

const isSorted = ref(false);
// 처음값을 false로 지정 -> 버튼을 미완료 정렬로 설정

const sortList = () => {
  if (!isSorted.value) {
    //isSorted의 값이 false 일때

    todoList.sort((a, b) => a.completed - b.completed);
    // JS에서는 false를 0, true를 1로 계산 (미완료 0, 완료 1)
    // => 음수 -> a가 앞으로 / 양수 -> a가 뒤로   
    // =>  반복시 미완료(0)이 맨위로 모임
// 
    isSorted.value = true;
    // 버튼 바꾸기

  } else {
    todoList.sort((a, b) => a.id - b.id);
    // a - b = 음수 -> a가 앞으로
    // 반복시 id값이 낮은게 앞으로 옴

    isSorted.value = false;
    //버튼 바꾸기
  }
};

</script>
