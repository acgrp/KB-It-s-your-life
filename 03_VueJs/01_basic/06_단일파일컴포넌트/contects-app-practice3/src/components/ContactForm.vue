<template>
  <div class="input-form card card-body mt-3">
    <div class="row g-3">
      <div class="col-md-2">
        <input type="text" class="form-control" placeholder="이름" />
      </div>
      <div class="col-md-2">
        <select class="form-select">
          <option value="">성별</option>
          <option value="남">남</option>
          <option value="여">여</option>
        </select>
      </div>
      <div class="col-md-2">
        <input type="number" class="form-control" placeholder="나이" />
      </div>
      <div class="col-md-3">
        <input type="email" class="form-control" placeholder="Email" />
      </div>
      <div class="col-md-2">
        <input type="text" class="form-control" placeholder="github ID" />
      </div>
      <div class="col-md-1">
        <button class="btn btn-primary w-100" @click="AddName">추가</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ContactForm',

  data() {
    return {};
  },

  methods: {
    // 이름이 입력 안된 경우 '이름을 입력하세요' 알림창
    // 이메일이 입력 안된 경우 '이메일을 입력하세요' 알림창
    // 둘 다 입력이 된 경우 연락처 추가
    AddName() {
      this.$emit('Add-Name', this.name);
      this.name = '';
    },
  },
};
</script>
