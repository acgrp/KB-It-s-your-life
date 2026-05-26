<template>
  <tr>
    <td>{{ contactas.name }}</td>
    <td>{{ contactas.gender }}</td>
    <td>{{ contactas.age }}</td>
    <td>{{ contactas.email }}</td>
    <td>{{ contactas.github }}</td>
    <td>
      <button class="btn btn-danger btn-sm">삭제</button>
    </td>
  </tr>
</template>

<script>
export default {
  name: 'ContactItem',
  props: {
    contactas: { type: Object, required: true },
  },
};
</script>
