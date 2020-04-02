<template>
  <div id="app">

    <router-view/>
  </div>
</template>

<style>
body {
  margin: 0;
  padding: 0;
}
header {
  background-color: #e34232;
}
.nav {
  margin: 0;
  padding: 0;
  list-style-type: none;
}
.nav li {
  display: inline-block;
  padding: 20px;
  color: #fff;
}
.nav li a {
  color: #fff;
  text-transform: uppercase;
  font-size: 14px;
  text-decoration: none;
}
.nav li:hover {
  background-color: rgb(216, 216, 216);
  cursor: pointer;
  color: rgb(44, 44, 44);
}
.nav li a:hover {
  color: rgb(44, 44, 44);
}
</style>
