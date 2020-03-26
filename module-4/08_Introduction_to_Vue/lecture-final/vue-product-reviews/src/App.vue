<template>
  <div id="app">
    <!-- 3) Use the components name as a tag to position in pages HTML -->
    <product-reviews></product-reviews>
    <!--  Removing Hello World
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    -->
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
// 1) Import my component
import ProductReviews from './components/ProductReviews.vue'

// 2) Add the variable name from the import to the components list
export default {
  name: 'App',
  components: {
    //HelloWorld, 
    ProductReviews
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
