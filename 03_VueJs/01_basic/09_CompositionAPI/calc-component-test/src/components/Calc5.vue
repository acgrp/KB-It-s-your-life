<template>
  <div>
    x : <input type="text" v-model.number="x" />
    <br />
    결과 : {{ result }}
  </div>
</template>

<script>
import { ref, computed, watch } from 'vue';

export default {
  name: 'Calc5',
  setup() {
    const x = ref(0);
    const result = ref(0);

    watch(x, (newValue, oldValue) => {
      console.log(`Count changed from ${oldValue} to ${newValue}`);
      result.value = oldValue;
    });
    return { x, result };
  },
};
</script>
