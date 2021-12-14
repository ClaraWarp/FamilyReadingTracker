<template>
    <div>
        <form @submit.prevent="">
            <input type="text" v-model="choseUser"/>
            <button>Add User</button>
            <br/>
            <input type="radio" name="isParent" value="true" id="isParent-true">
            <label for="isParent-true">As Parent</label>
            <input type="radio" name="isParent" value="false" id="isParent-false">
            <label for="isParent-false">As Child</label>
        </form>
        <ul>
            <li v-for="(user, i) in filteredList" :key="i">
                {{user.username}}
            </li>
        </ul>
        <button @click="toggleUserList">Back></button>
    </div>
</template>

<script>
import familiesService from "@/services/FamiliesService";
export default {
    data() {
        return {
            users: [],
            chosenUser: null
        }
    },
    computed: {
        filteredList() {
            let filteredUsers = this.users;
            return filteredUsers;
        }
    },
    methods: {
        toggleUserList() {
            this.$emit("toggleUserList")
        },
        addUserToFamily() {
            // use familesService to add to relational table
        }
    },
    beforeMount() {
        familiesService.getUsers().then(
            (response) => {
                if (response.status === 200) {
                    this.users = response.data;
                }
            }
        )
    }
}
</script>

<style>

</style>