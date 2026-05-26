<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': todoLists.completed }"
  >
    <!-- 조건이 true 일때 클래스 추가 -->

    <!-- <input type="checkbox" v-model="todoitem.completed" class="pointer me-3" /> -->
    <!-- checked는 input 자체에 있는 속성 = "값"이 있다면 체크 -->
    <input
      type="checkbox"
      class="pointer me-3"
      @click="$emit('Add-checkbox', todoLists.id)"
      :checked="todoLists.completed"
    />
    <!--
    객체 props에 v-model을 쓰면 부모 데이터도 같이 바뀐다.
    -> 하지만 props는 읽기 전용이 원칙이라서 권장 x
    -> 해결 : 자식 컴포넌트에서 $emit으로 부모에게 알려서 바꾸자
      -->
    <span class="pointer" :class="{ 'todo-done': todoLists.completed }"
      >{{ todoLists.todo }} {{ todoLists.completed ? `(완료)` : '' }}</span
    >
    <span
      @click="$emit('deleteList', todoLists.id)"
      class="float-end badge bg-secondary pointer"
      >삭제</span
    >
  </li>
</template>
<script>
export default {
  name: 'TodoListItem',
  props: {
    todoLists: { type: Object, required: true },
  },
  // 무엇(Array, Object, String, Number 등)이 들어와야 하는가?
  // required: false, -> 안 보내줘도 에러 안 남!
  // required: ture, -> 꼭 줘야함
};
</script>
