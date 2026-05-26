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
                <button @click="AddContact" class="btn btn-primary w-100">추가</button>
            </div>
        </div>
    </div>
</template>

<script>
import { reactive } from 'vue';
export default {

    name: "ContactForm",
    props: {
        contactlist: { type: Array, required: true }
    },

    setup(props, { emit }) {

        // 입력값들 담아 두는곳
        const newContact = reactive({
            id: '',
            name: '',
            gender: '',
            age: '',
            email: '',
            github: '',
        });

        const AddContact = () => {
            if (!newContact.name) {
                alert("이름을 적어주세요");
                return;
            }

            if (!newContact.email) {
                alert("이메일을 적어주세요");
                return;
            }

            // 이벤트값 보내기 
            emit('add-contact', { ...newContact });

            newContact.name = '';
            newContact.age = '';
            newContact.gender = '';
            newContact.email = '';
            newContact.github = '';
        }
        return { newContact, AddContact };
    }

};



</script>