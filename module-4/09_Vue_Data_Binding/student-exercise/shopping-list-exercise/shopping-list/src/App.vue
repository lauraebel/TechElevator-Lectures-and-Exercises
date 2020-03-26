<template>
  <div id="app">
    <shopping-list></shopping-list>
  </div>
</template>

<script>
import ShoppingList from './components/ShoppingList';

export default {
  name: 'app',
  components: {
    ShoppingList
  }
}
</script>

<style>
body {
  background: rgb(61,201,164);
  background: radial-gradient(circle, rgba(61,201,164,1) 50%, rgba(92,133,120,1) 100%);
}
</style>
