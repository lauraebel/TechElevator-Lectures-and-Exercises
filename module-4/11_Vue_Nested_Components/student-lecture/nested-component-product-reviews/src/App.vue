<template>
  <div id="app">
    <search-bar v-on:filter="handleFilter" />
    <product-review
      name="Cigar Parties for Dummies"
      description="Host and plan the perfect cigar party for all of your squirrelly friends."
      v-bind:filterText="filter"
       />
       
    <product-review
      name="Tech Elevator Bootcamp Extravaganza"
      description="14 crazy weeks of fun and coding with an emphasis on the coding"
      v-bind:filterText="filter"
       />  
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue';
import SearchBar from './components/SearchBar.vue';

export default {
  name: 'app',
  components: {
    ProductReview,
    SearchBar
  },
  data() {
    return {
      filter: ''
    };
  },
  methods: {
    // filterText is the event object, that contains the filter value, 
    // which is passed implicitly from the v-on
    handleFilter(filterText) {
      this.filter = filterText;
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

#app div.main {
  display: inline-block;
  width: 45%;
  padding: 1em;
  border: 1px black solid;
  border-radius: 5px;
  margin: 0 1em;
  vertical-align: top;
}
</style>
