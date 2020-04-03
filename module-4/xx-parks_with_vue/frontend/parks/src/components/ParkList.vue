<template>
  <div class="parkList">
      <h1>Parks</h1>
      <ol>
          <li v-for="park in parks" :key="park.parkCode">
              <router-link :to="{ name:'park', params: { code: park.parkCode} }" >{{ park.parkName }}</router-link>
          </li>
      </ol>
   </div>
</template>

<script>
export default {
    name: 'park-list',
    props: {
        apiUrl: String
    },
    data() {
        return {
            parks: []
        }
    },
    methods: {
        getAllParks() {
            fetch(this.apiUrl)
                .then( response => {
                    return response.json();
                })
                .then( data => {
                    this.parks = data;
                })
                .catch( err => { console.error(err) });
        }
    },
    created() {
        this.getAllParks();
    }
}
</script>

<style>

</style>