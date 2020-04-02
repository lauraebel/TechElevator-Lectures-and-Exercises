<template>
    <div class="users">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
            <tr v-for="user in users" :key="user.id">
                <td><router-link :to="{ name: 'user', params: { id: user.id } }">{{ user.id }}</router-link></td>
                <td>{{ user.name }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
import userService from '@/service/UserService';

export default {
    name: 'users',
    data() {
        return {
            users: []
        }
    },
    methods: {
        getUsers() {
            userService.list().then( users => this.users = users );
        }
    },
    created() {
        this.getUsers();
    }    

}
</script>

<style>
    td, th {
        padding: 6px;
        margin: 0;
    }
    tr:nth-child(even) {
        background-color: lightblue;
    }
</style>