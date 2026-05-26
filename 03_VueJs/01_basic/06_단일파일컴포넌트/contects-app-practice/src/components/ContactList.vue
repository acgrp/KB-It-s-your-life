<template>
  <div class="contact-list mt-3">
    <table class="table">
      <thead>
        <tr>
          <th>이름</th>
          <th>성별</th>
          <th>나이</th>
          <th>이메일</th>
          <th>Github ID</th>
          <th>관리</th>
        </tr>
      </thead>
      <tbody>
        <ContactItem @delete-contant="$emit('delete-contant', $event)" v-for="contact in contactslist" :key="contact.id" :contactslist="contact"
         />
      </tbody>
    </table>
  </div>
</template>

<script>
import ContactItem from "./ContactItem.vue";
export default {
  components: {
    ContactItem
  },
  props: {
    contactslist: {
      type: Array,
      required: true
    }
  }
};
</script>