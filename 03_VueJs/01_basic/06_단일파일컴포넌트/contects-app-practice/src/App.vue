<template>
  <div id="app" class="container-lg">
    <div class="card card-body bg-light">
      <div class="title">우리반 Contact ❤️</div>
    </div>

    <!-- 연락처 입력 폼 -->
    <ContactForm @Add-contact="Addcontact" :contactslist="contacts"/>
    <!-- 연락처 목록 -->
    <ContactList @delete-contant="deletecontant" :contactslist="contacts"/>

  </div>
</template>



<script>
import ContactForm from './components/ContactForm.vue'
import ContactList from './components/ContactList.vue'

export default {
  name: 'App',
  components: {
    ContactForm,
    ContactList
  },

  data() {
    return {
      newContact: {
        name: '',
        gender: '',
        age: '',
        email: '',
        github: '',
      },
      contacts: [
        {
          id: 1,
          name: '홍길동',
          gender: '남',
          age: 20,
          email: 'hong@example.com',
          github: 'hongGD',
          isEditing: false,
        },
        {
          id: 2,
          name: '짱구',
          gender: '남',
          age: 7,
          email: 'janggu@example.com',
          github: 'janggu',
          isEditing: false,
        },
        {
          id: 3,
          name: '유리',
          gender: '여',
          age: 7,
          email: 'yuri@example.com',
          github: 'yuri',
          isEditing: false,
        },
      ],
    };
  },
  methods: {
    /* contact 추가 */
    deletecontant(id) {
      let index = this.contacts.findIndex((item) => id === item.id);
      // 배열.findIndex((item) => 조건) : 조건이 true가 되는 첫번째 요소의 index 반환

      console.log(index);
      this.contacts.splice(index, 1);
      // splice(시작index, 삭제개수)
    },
    /* contact 삭제 */
    Addcontact(user) {
      console.log(user);
      const NewContact = {
        id: this.contacts.length,
        // id값 추가
        ...user
        // ... => 주머니 안에 든 내용물을 몽땅 꺼낸다
        
      };
      this.contacts.push(NewContact);
    }
  },
    
};
</script>
