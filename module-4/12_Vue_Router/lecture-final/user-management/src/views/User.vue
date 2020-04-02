<template>
    <div class="user-profile">
        <h1>User Profile</h1>
        <pre>{{ user }}</pre>
        <router-link :to="{ name: 'users'}">Back to Users List</router-link>
    </div>
</template>

<script>
import userService from '@/service/UserService';

export default {
    name: 'user-profile',
    data() {
        return {
            user: null
        }
    },
    methods: {
        getUser(id) {
            userService.get(id).then( user => this.user = user);
        }
    },
    created() {
        // get the parameter id from the dynamic data in the url
        console.log( this.$route.params.id );

        this.getUser( this.$route.params.id );
    }
}
</script>