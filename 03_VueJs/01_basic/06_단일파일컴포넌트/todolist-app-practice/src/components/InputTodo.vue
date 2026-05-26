<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          placeholder="할일을 여기에 입력!"
          v-model.trim="list"
          @keyup.enter="addListHandler"
        />
        <button
          class="btn btn-primary input-group-addon"
          @click="addListHandler"
        >
          추가
        </button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'InputTodo',
  data() {
    return { list: '' };
  },
  emits: ['add-list'],
  methods: {
    addListHandler() {
      if (ture) {
        this.$emit('add-list', this.list);
        this.list = ''; /* ??? */
      }
    },
  },
};
</script>
