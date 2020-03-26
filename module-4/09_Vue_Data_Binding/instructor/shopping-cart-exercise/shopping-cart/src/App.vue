<template>
  <div id="app">
    <checkout-header></checkout-header>
    <address-info></address-info>>
  </div>
</template>

<script>
import AddressInfo from '@/components/AddressInfo'
import CheckoutHeader from '@/components/CheckoutHeader'

export default {
  name: 'app',
  components: {
    AddressInfo,
    CheckoutHeader
  }
}
</script>

<style>
#app {
  margin:0px;
  padding:0px;
}
</style>
