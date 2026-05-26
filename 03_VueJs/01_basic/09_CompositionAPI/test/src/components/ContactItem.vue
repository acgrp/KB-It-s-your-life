<template>
  <tr>
    <td>{{ contactlist.name }}</td>
    <td>{{ contactlist.gender }}</td>
    <td>{{ contactlist.age }}</td>
    <td>{{ contactlist.email }}</td>
    <td>{{ contactlist.github }}</td>
    <td>
      <button @click="deleteContant" class="btn btn-danger btn-sm">삭제</button>
    </td>
  </tr>
</template>

<script>
import { } from 'vue';
export default {
  name: 'ContactItem',
  props: {
    contactlist: {
      type: Object, required: true
    },
  },
  // props 데이터를 사용하기 위해선 props.contactlist.id로 접근
  setup(props, { emit }) {
    const deleteContant = () => {
      emit('delete-contact', props.contactlist.id);
    }
    return { deleteContant };
  }
};

</script> 