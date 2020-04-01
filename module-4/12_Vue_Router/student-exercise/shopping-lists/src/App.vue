<template>
  <div id="app">
    <header>
      <ul class="nav">
        <li><i class="fas fa-home"></i>Home</li>
        <li><i class="fas fa-shopping-basket"></i>Shop By Department</li>
        <li><i class="fas fa-coins"></i>On Sale This Week</li>
      </ul>
      <ul class="nav-right">
        <li><i class="fas fa-shopping-cart"></i>Shopping Cart</li>
        <li><i class="fas fa-cash-register"></i>Checkout</li>
      </ul>
    </header>
    <div class="content">
      <router-view />
    </div>
  </div>
</template>

<style>
body {
  margin: 0;
  padding: 0;
  width: 100vw;
  height: 100%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  background-image: linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%);
  font-family: 'Roboto', sans-serif;
}
#app {
  width: 80vw;
  height: 100%;
  background-color: white;
}
header {
  height: 50px;
  width: 100%;
  display: flex;
  flex-direction: row;
  background-color: rgb(247, 247, 247);

}
.nav {
  padding:14px;
  margin:0;
  flex:1;
  list-style-type: none;
}
.nav li {
  display: inline;
  padding-right: 20px;
}
.nav li a, .nav li a:visited {
  text-decoration: none;
  color: rgb(56, 56, 146);
  text-transform: uppercase;
  font-size: 13px;
}
.nav li a:hover {
  text-decoration: underline;
}
.nav-right {
  flex: 1;
  list-style-type: none;
  padding: 14px;
  margin: 0;
  text-align: right;
}
.nav-right li {
  display: inline;
  padding-right: 20px;
  vertical-align: middle;
}
.nav-right li a, .nav-right li a:visited {
  text-decoration: none;
  color: rgb(56, 56, 146);
  text-transform: uppercase;
  font-size: 13px;
}
.nav-right li a:hover {
  text-decoration: underline;
}
.fas {
  margin-right: 4px;
}
.content {
  padding: 20px;
}
</style>
