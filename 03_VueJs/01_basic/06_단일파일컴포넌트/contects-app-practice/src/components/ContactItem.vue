<template>
  <tr>
    <td>{{ contactslist.name }}</td>
    <td>{{ contactslist.gender }}</td>
    <td>{{ contactslist.age }}</td>
    <td>{{ contactslist.email }}</td>
    <td>{{ contactslist.github }}</td>
    <td>
      <button @click="$emit('delete-contant', contactslist.id)" class="btn btn-danger btn-sm">삭제</button>
    </td>
  </tr>
</template>

<script>
export default {
  name: 'ContactItem',
  props: {
    contactslist: {
      type: Object,
      required:true
    }
  }
};
</script>
