<template>
  <div>
    <li><input type="checkbox" v-model="checked">옵션1</li>
  </div>
</template>

<script>
export default {
  name: "CheckboxItem",
  data() {
    return {
      checked: false,
    };
  },
};
</script>
