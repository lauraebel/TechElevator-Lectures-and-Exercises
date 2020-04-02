<template>
  <div class="home">
    <div class="hero">
      <div class="welcome">
        <h1>Online Grocery Shopping</h1>
        <p>Lemon drops jelly powder donut candy jelly-o chupa chups. Topping toffee gingerbread pudding. Icing tootsie roll cake lemon drops biscuit cake jelly-o marzipan cake. Carrot cake oat cake candy marzipan cupcake soufflé. Cookie caramels chupa chups wafer bear claw dragée caramels dessert. Ice cream tiramisu pastry sugar plum. Chocolate bar topping oat cake lemon drops gummi bears. Jujubes bear claw ice cream halvah cotton candy sweet. Wafer toffee lemon drops donut. Icing oat cake marshmallow pudding gingerbread dragée.</p>
        <button>Shop By Department</button>
      </div>
      <div class="cover">
        <img src="../assets/images/undraw_addtocart.png" width="100%"/>
      </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.hero {
  display: flex;
  padding: 20px 0 0 0;
}
.welcome {
  flex: 1
}
.cover {
  flex: 1
}
.welcome p {
  line-height: 2em;
}
button {
  padding: 10px;
  font-size: 15px;
  font-weight: 400;
  border-radius: 8px;
  background-color: #027BFF;
  color: white;
  cursor: pointer;
  float: right;
  border:none;
  outline: none;
  width: 200px;
}
</style>
