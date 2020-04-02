<template>
  <div class="cart">
    <h1>Shopping Cart</h1>
    <div class="products">
      <div class="product">
        <img src="../assets/images/products/produce/tomatoes.jpeg"/>
        <div class="details">
          <div><span class="label">Sku:</span> 00751666776050</div>
          <div><span class="label">Price:</span> $5.99</div>
          <div><span class="label">Qty:</span> 1</div>
          <div><span class="label">Department:</span> Produce</div>
        </div>
        <p class="line-item-total">$5.99</p>
      </div>
      <div class="product">
        <img src="../assets/images/products/dairy/milk.jpeg"/>
        <div class="details">
          <div><span class="label">Sku:</span> 00742365264474</div>
          <div><span class="label">Price:</span> $5.29</div>
          <div><span class="label">Qty:</span> 2</div>
          <div><span class="label">Department:</span> Produce</div>
        </div>
        <p class="line-item-total">$10.58</p>
      </div>
      <div class="product">
        <img src="../assets/images/products/bakery/chocolate-chip-cookies.jpeg"/>
        <div class="details">
          <div><span class="label">Sku:</span> 00072030001807</div>
          <div><span class="label">Price:</span> $3.79</div>
          <div><span class="label">Qty:</span> 2</div>
          <div><span class="label">Department:</span> Bakery</div>
        </div>
        <p class="line-item-total">$7.58</p>
      </div>
    </div>
    <div class="total">
      <p><strong>Total: </strong> $24.15</p>
      <router-link to="/checkout" tag="button">Checkout</router-link>
    </div>

  </div>
</template>

<script>
export default {
  name: 'shopping-cart',
  data() {
    return {

    }
  }
}
</script>

<style scoped>
.products {
  display: flex;
  flex-direction: column;
}
.product {
  width: 100%;
  border-bottom:1px solid rgb(216, 216, 216);
  padding:5px;
}
.line-item-total {
  padding-right: 50px;
  font-size: 22px;
}
.total {
  padding:10px;
  font-size: 22px;
  text-align: right;
}
</style>
