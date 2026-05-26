<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default panel-borderless">
      <div class="card-body">
        <InputTodo :todolist="todoList" @addTodo="addTodo" />

        <!-- 자식에게 넘기기 (자식은 props로 받기) -->
        <!-- @이벤트리스너="이벤트핸들러" -->
        <TodoList
          :todolist="todoList"
          @deleteList="deleteList"
          @Add-checkbox="checkedcontact"
        />
      </div>
    </div>
  </div>
</template>

<script>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';

let ts = new Date().getTime();

export default {
  name: 'App',
  components: { InputTodo, TodoList },
  data() {
    return {
      todoList: [
        { id: ts, todo: '자전거 타기', completed: false },
        { id: ts + 1, todo: '딸과 공원 산책', completed: true },
        { id: ts + 2, todo: '일요일 애견 카페', completed: false },
        { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
      ],
    };
  },
  methods: {
    deleteList(id) {
      // id가 일치하는 요소의 index 변수에 담기
      let index = this.todoList.findIndex((ele) => id === ele.id);
      // console.log(index);

      // splice(시작index, 삭제개수)
      this.todoList.splice(index, 1);
    },

    // 할일 추가
    /**
     *
     * @param e InputTodo에서 전달된 todo(할일 내용)
     */
    addTodo(todo) {
      console.log(todo);
      this.todoList.push({
        id: ts + this.todoList.length,
        todo: todo,
        complted: false,
      });
    },
    checkedcontact(id) {
      // 배열.findIndex((item) => 조건) : 조건이 true가 되는 첫번째 요소의 index 반환
      // 없는 경우 -1반환
      let index = this.todoList.findIndex((item) => id === item.id);
      // ==   (동등 비교) : 값만 비교
      // ===  (동일 비교) : 값 + 타입까지 비교

      // console.log(index);

      // console.log(this.todoList[index]);
      // console.log(this.todoList[index].completed);
      // console.log(!this.todoList[index].completed);

      // !true/false : true -> false, false -> true로 변경
      this.todoList[index].completed = !this.todoList[index].completed;

      // console.log(this.todoList[index].completed);
    },
  },
};
</script>
