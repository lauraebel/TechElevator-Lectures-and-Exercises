<template>
  <div id="app">
    <h1>Nested Components Exercise</h1>

  </div>
</template>

<script>

export default {
  name: 'app',
  components: {

  },
  data() {
    return {
      
    }
  },
  methods: {

  }
}
</script>

<style>
body {
  background: rgb(61,201,164);
  background: radial-gradient(circle, rgba(61,201,164,1) 50%, rgba(92,133,120,1) 100%);
}
#app {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 20px;
}
h1 {
  grid-row: 1;
  grid-column: 1 / 4;
  text-align:center;
  color:#f2f2f2;
  text-transform: uppercase;
  font-family: 'Roboto Condensed', sans-serif;
}
.search { 
  grid-column: 2 / 3;
  grid-row: 2;
}
.shopping-list {
  grid-row: 3;
}
</style>
