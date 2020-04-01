<template>
  <div class="weekly-specials">
    <h1>Products on Sale</h1>
    <products-list :items="items"/>
  </div>
</template>

<script>
import data from '../assets/data/products.json'
import ProductsList from '@/components/ProductsList'

export default {
  name: 'weekly-specials',
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
    getProducts() {
      this.items = this.allProducts.filter((product) => product.sale == true);
    }
  },
  created() {
    this.getProducts();
  }
}
</script>
