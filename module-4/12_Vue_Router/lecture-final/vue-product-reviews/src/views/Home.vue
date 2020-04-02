<template>
  <div class="home">
    <product-review />
  </div>
</template>

<script>
// @ is an alias to /src
import ProductReview from '@/components/ProductReview.vue'

export default {
  name: 'home',
  components: {
    ProductReview
  }
}
</script>
