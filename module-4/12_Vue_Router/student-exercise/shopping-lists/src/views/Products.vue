<template>
  <div class="products">
    <h1>Shop By Department</h1>
    <p>Below is a list of our departments. Please click on a department to view available products by department.</p>
    <div class="departments">
      <router-link to="/products/produce" class="department produce"> Produce </router-link>
      <img src="/img/produce_banner.png">
      <router-link to="/products/dairy" class="department dairy"> Dairy </router-link>
      <img src="/img/dairy_banner.png">
      <router-link to="/products/meat" class="department meat"> Meat </router-link>
      <img src="/img/meat_banner.png">
      <router-link to="/products/bakery" class="department bakery"> Bakery </router-link>
      <img src="/img/bakery_banner.png">
    </div>
  </div>
</template>

<script>
export default {
  name: "products",
  data() {
    return {
      departments: [
        { path: '/produce', banner: 'produce_banner.png', class: 'department produce' },
        { path: '/dairy', banner: 'dairy_banner.png', class: 'department dairy' },
        { path: '/meat', banner: 'meat_banner.png', class: 'department meat' },
        { path: '/bakery', banner: 'bakery_banner.png', class: 'department bakery' }
      ]
    }
  }
}
</script>

<style>
.departments {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}
</style>
