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
      <!-- <div style="display: flex; justify-content: space-between">
        <span>전체 todo 개수:{{ todolist.length }}개 </span>
        <span>완료 todo 개수:{{ completedCount() }}</span>
        <span>미완료 todo 개수:{{ incompleteCount() }}</span>
      </div> -->
    </div>
  </div>
</template>
<script>
export default {
  name: 'InputTodo',
  props: {
    // 부모(App.vue)에게서 'todolist'라는 이름의 데이터를 받음
    todolist: { type: Array, required: true },
    // 이 데이터는 반드시 '배열(Array)' 형태여야 하고,
    // 이 데이터가 없으면 컴포넌트가 작동하지 않으니 꼭 보내달라는 뜻입니다.
  },
  data() {
    return {
      todo: '',
      // 입력창(input)에 쓰는 글자를 실시간으로 담아둘 빈 상자를 만듭니다.
    };
  },
  methods: {
    completedCount() {
      return this.todolist.filter((item) => item.completed).length;
      // 리스트 중에서 'completed'가 true인 녀석들만 골라서 그 개수(.length)를 잽니다.
      // asd는 바꿀수 있는 변수
    },
    incompleteCount() {
      return this.todolist.filter((item) => !item.completed).length;
    },
    addTodoHandler() {
      //할일이 3글자 이상인 경우에만
      if (this.todo.length < 3) {
        alert('할일은 3글자 이상 입력해주세요.');
        return;
      }
      this.$emit('addTodo', this.todo);
      this.todo = ''; /* input 초기화 */
      return; //메소드 종료 : 밑에 코드 수행x
    },
  },
  // emits: ['addTodo'],
  // // 이벤트 방출 검사
  // // -> 부모 컴포넌트로 전달되는 이벤트가
  // // addTodo가 맞는지 검사
};
</script>
