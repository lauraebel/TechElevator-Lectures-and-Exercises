<template>
  <div class="parkDetail">
      <h1>Park Detail for {{ park.parkName }}</h1>
      <pre>{{ park }}</pre>
  </div>
</template>

<script>
export default {
    name: 'park-detail',
    data() {
        return {
            parkCode: '',
            park: null
        }
    },
    methods: {
        getParkByCode(code) {
            fetch(process.env.VUE_APP_API_URL + "/" + code)
                .then( response => {
                    return response.json();
                })
                .then( data => {
                    this.park = data;
                })
                .catch( err => { console.error(err) });
        }
    },
    created() {
        this.parkCode = this.$route.params.code;
        this.getParkByCode(this.parkCode);
    }
}
</script>

<style>

</style>