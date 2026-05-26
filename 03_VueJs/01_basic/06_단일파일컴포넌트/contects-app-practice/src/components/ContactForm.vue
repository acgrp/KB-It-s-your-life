<template>
  <div class="input-form card card-body mt-3">
    <div class="row g-3">
      <div class="col-md-2">
        <input v-model="newContact.name" placeholder="이름" type="text" class="form-control" />
      </div>
      <div class="col-md-2">
        <select v-model="newContact.gender" class="form-select">
          <option value>성별</option>
          <option value="남">남</option>
          <option value="여">여</option>
        </select>
      </div>
      <div class="col-md-2">
        <input v-model="newContact.age" placeholder="나이" type="number" class="form-control" />
      </div>
      <div class="col-md-3">
        <input v-model="newContact.email" placeholder="이메일" type="email" class="form-control" />
      </div>
      <div class="col-md-2">
        <input v-model="newContact.github" placeholder="github" type="text" class="form-control" />
      </div>
      <div class="col-md-1">
        <button @click="Addcontact" class="btn btn-primary w-100">추가</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ContactForm",

  data() {
    return {
      newContact: {

      }
    };
  },

  methods: {
    Addcontact() {
<<<<<<< HEAD
      if(!this.newContact.name){
        alert('이름을 입력하세요');
        return;
      }
      if(!this.newContact.email){
        alert('이메일을 입력하세요');
        return;
      } 
      this.$emit('Add-contact', {...this.newContact});
=======
      if (!this.newContact.name) {
        alert('이름을 입력하세요');
        return;
      }
      if (!this.newContact.email) {
        alert('이메일을 입력하세요');
        return;
      }
      this.$emit('Add-contact', { ...this.newContact });
      this.newContact = {};
>>>>>>> 842efac0a9c2f34713f17842215ccd155403e5ca
      // 부모에게 이벤트 발송
    }
    // 이름이 입력 안된 경우 '이름을 입력하세요' 알림창
    // 이메일이 입력 안된 경우 '이메일을 입력하세요' 알림창
    // 둘 다 입력이 된 경우 연락처 추가
  },
  props: {
    contactslist: {
      type: Array,
      required: true
    }
  }
};
</script>
