<template>
  <div class="products-list">
    <h1>Shop by Department: {{ $route.params.department }}</h1>
    <products-list v-bind:items="items"/>
  </div>
</template>

<script>
import data from '../assets/data/products.json'
import ProductsList from '@/components/ProductsList'

export default {
  name: 'products',
  components: {
    ProductsList
  },
  data() {
    return {
      allProducts: data,
      items: []
    }
  },
  methods: {
    getProducts(department) {
      this.items = this.allProducts.filter((product) => product.department == department);
    }
  },
  created() {

  }
}
</script>
