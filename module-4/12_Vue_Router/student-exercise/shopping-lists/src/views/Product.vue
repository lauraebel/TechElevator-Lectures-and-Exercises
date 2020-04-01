<template>
  <div class="product-details">
    <h1>{{ product.name }}</h1>
    <div class="product">
      <img v-bind:src="require('../assets/images/products/' + product.img)" />
      <div class="details">
        <div><span class="label">Sku:</span> {{ product.sku }}</div>
        <div><span class="label">Price:</span> ${{ product.price }}</div>
        <div><span class="label">Department:</span> {{ product.department }}</div>
        <div><span class="label">Description:</span> This is a description of this awesome product and you simply must try it out.</div>
        <router-link to="/cart" tag="button">Add to Cart</router-link>
      </div>
    </div>
    <p class="legal"><strong>Legal Disclaimer</strong> Actual product packaging and materials may contain additional and/or different ingredient, nutritional or proper usage information than the information displayed on our website. You should not rely solely on the information displayed on our website and you should always read labels, warnings and directions prior to using or consuming a product. If you have questions or require more information about a product, you should contact the manufacturer directly. Content on this website is for general reference purposes only and is not intended to substitute for advice given by a physician, pharmacist or other licensed health care professional. You should not use the information presented on this website for self-diagnosis or for treating a health problem. MyWebGrocer assumes no liability for inaccuracies or misstatements regarding any product.</p>
    <button v-on:click="goBack">GO BACK</button>
  </div>
</template>

<script>
import data from '../assets/data/products.json'

export default {
  name: 'product',
  data() {
    return {
      allProducts: data,
      product: null
    }
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    }
  },
  created() {
    this.product = this.allProducts.find(p => p.sku == this.$route.params.sku);
  }
}
</script>

<style>
.product {
  display: flex;
  flex-direction: row;
}
.product .details {
  flex: 1;
  margin: 0 0 0 30px;
  line-height: 2em;
}
.product .details .label {
  font-weight: 600;
}
.legal {
  border: 1px solid #EEF0F1;
  font-size: 11px;
  padding:10px;
  line-height: 2em;
}
</style>
