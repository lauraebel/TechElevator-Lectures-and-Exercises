<template>
  <header>
    <ol>
      <li v-for="(item, index) in navItems" v-bind:key="index" :class="{active: item.active}">
        {{item.label}}
      </li>
    </ol>
  </header>
</template>

<script>
export default {
  name: 'checkout-header',
  data() {
    return {
      navItems: [
        { label: 'Account', active: false },
        { label: 'Address', active: true },
        { label: 'Payment', active: false },
        { label: 'Review', active: false },
      ]
    }
  }
};
</script>

<style>
header {
  height: 50px;
  background-color: rgb(0, 0, 0);
  margin-bottom: 20px;
  color: white;
  text-align: center;
  padding-top:10px;
}
ol {
  list-style-type: none;
}
ol li {
  counter-increment: step-counter;
  display: inline;
  padding-left: 15px;
  padding-right: 15px;
}

ol li.active::before {
  background-color: #007BFF;
}

ol li::before {
  content: counter(step-counter);
  margin-right: 5px;
  font-size: 80%;
  background-color: rgb(167, 167, 167);
  color: white;
  padding: 4px 8px;
  border-radius: 50%;
}
</style>
