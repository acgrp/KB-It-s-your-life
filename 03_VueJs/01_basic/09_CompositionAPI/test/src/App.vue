<template>
    <div id="app" class="container-lg">
        <div class="card card-body bg-light">
            <div class="title">우리반 Contact ❤️</div>
        </div>

        <!-- 연락처 입력 폼 -->
        <ContactForm @add-contact="AddContact" :contactlist="contacts" />
        <!-- 연락처 목록 -->
        <ContactList @delete-contact="deletecontact" :contactlist="contacts" />

    </div>
</template>

<script>
import { reactive } from 'vue';
import ContactList from './components/ContactList.vue'
import ContactForm from './components/ContactForm.vue'

export default {
    name: 'App',
    components: { ContactForm, ContactList },
    setup() {
        const contacts = reactive([{
            id: 1,
            name: '홍길동',
            gender: '남',
            age: 20,
            email: 'hong@example.com',
            github: 'hongGD',
            isEditing: false,
        }, {
            id: 2,
            name: '짱구',
            gender: '남',
            age: 7,
            email: 'janggu@example.com',
            github: 'janggu',
            isEditing: false,
        }, {
            id: 3,
            name: '유리',
            gender: '여',
            age: 7,
            email: 'yuri@example.com',
            github: 'yuri',
            isEditing: false,
        }]);

        // 이벤트값 받아서 id추가후 contacts에 붙이기
        const AddContact = (newContact) => {

            const nextId = contacts.length;
            // index값 뽑기

            const finalContact = {
                id: nextId,
                ...newContact
                // newContact에 있는것 전부 꺼내기
            }; /* 넣을 값 만들기 */

            contacts.push(finalContact);
        };
        const deletecontact = (id) => {
            let index = contacts.findIndex((item) => item.id === id)
            console.log(index);
        }

        return { contacts, AddContact, deletecontact };
    }
}
</script>