<template>
  <div class="items">
    <div v-for="item in items" v-bind:key="item.id" class="item">
      <img v-bind:src="require('../assets/images/products/' + item.img)">
      <div class="name">{{ item.name }}</div>
      <router-link v-bind:id="item.sku" v-bind:to="{ name: 'product', params: { sku: item.sku } }" tag="button">Product Details</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "products-list",
  props: ['items']
};
</script>

<style>
.items {
  display: grid;
  grid-template-columns: repeat(4,1fr);
  grid-gap: 40px;
}
.item {
  border: 1px solid rgb(211, 211, 211);
  background-color: #fff;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 10px;
  text-align: center;
}
.item img {
    object-fit: none;
}
button {
  width: 150px;
  padding: 10px;
  margin: 10px 0px;
  font-size: 13px;
  font-weight: 400;
  border-radius: 8px;
  background-color: #29A645;
  color: white;
  cursor: pointer;
  border:none;
  outline: none;
  text-transform: uppercase;
}
</style>
