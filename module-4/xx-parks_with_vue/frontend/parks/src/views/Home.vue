<template>
  <div class="home">
      <park-list v-bind:apiUrl="apiUrl" />
  </div>
</template>

<script>
// @ is an alias to /src
import ParkList from '@/components/ParkList.vue'

export default {
  name: 'Home',
  components: {
    ParkList
  },
  data() {
    return {
      apiUrl: process.env.VUE_APP_API_URL
    }
  }
}
</script>
