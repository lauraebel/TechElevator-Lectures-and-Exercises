<template>
  <div id="app">
    <h1>Nested Components Exercise</h1>
    <shopping-search v-on:filter-names="handleSearch"></shopping-search>
    <shopping-list title="Grocery" v-bind:data="groceries" v-bind:search="search"></shopping-list>
    <shopping-list title="Costco" v-bind:data="costco" v-bind:search="search"></shopping-list>
    <shopping-list title="Target" v-bind:data="target" v-bind:search="search"></shopping-list>
  </div>
</template>

<script>
import ShoppingSearch from '@/components/ShoppingSearch';
import ShoppingList from '@/components/ShoppingList';

export default {
  name: 'app',
  components: {
    ShoppingSearch,
    ShoppingList
  },
  data() {
    return {
      search: '',
        groceries: [
            { id: 1, name: 'Oatmeal', completed: false },
            { id: 2, name: 'Milk', completed: false },
            { id: 3, name: 'Banana', completed: false },
            { id: 4, name: 'Strawberries', completed: false },
            { id: 5, name: 'Lunch Meat', completed: false }
        ],
        costco: [
            { id: 1, name: 'Paper Towels', completed: false },
            { id: 2, name: 'Toilet Paper', completed: false },
            { id: 3, name: 'Bottled Water', completed: false },
            { id: 4, name: 'Paper Plates', completed: false },
            { id: 5, name: 'Pepsi', completed: false }
        ],
        target: [
            { id: 1, name: 'Baby Food', completed: false },
            { id: 2, name: 'Candles', completed: false },
            { id: 3, name: 'Aspirin', completed: false },
            { id: 4, name: 'Dish Soap', completed: false },
            { id: 5, name: 'Laundry Soap', completed: false }
        ],
    }
  },
  methods: {
    handleSearch(query) {
        this.search = query;
    }
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
