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
                <ContactItem @delete-contact="deletecontact" v-for="contact in contactlist" :key="contact.id"
                    :contactlist="contact" />
            </tbody>
        </table>
    </div>
</template>


<script>
import ContactItem from './ContactItem.vue'
import { } from 'vue';

export default {

    name: 'ContactList',

    components: { ContactItem },

    props: {
        contactlist: {
            type: Array, required: true
        }
    },

    // 부모가 보낸 데이터를 setup에서 사용하기 위해 props
    // emit 기능을 사용하기 위해 { emit을 사용 }
    setup(props, { emit }) {
        const deletecontact = (id) => {
            emit('delete-contact', id);
        }
        return { deletecontact }
    }
};


</script>