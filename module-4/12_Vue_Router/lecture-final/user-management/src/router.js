import Vue from 'vue'
import Router from 'vue-router'
import Users from './views/Users.vue'
import User from './views/User.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: { name: 'users' }
    },
    {
      path: '/users',
      name: 'users',
      component: Users
    },
    {
      path: '/user/:id',
      name: 'user',
      component: User
    }
  ]
})
