<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style>
ul {
  list-style-type: none;
  margin: 40px 0 0 0;
  padding:0px;
}
li {
  display: inline-block;
  margin:0px;
  padding:0px;
}
li a {
  color: rgb(48, 48, 48);
  background-color: rgb(136, 201, 128);
  padding: 20px;
  text-decoration: none;
  margin:10px;
}
li a:hover {
  background-color: rgb(98, 172, 88);
  transition: 0.5s ease background;
}
</style>
