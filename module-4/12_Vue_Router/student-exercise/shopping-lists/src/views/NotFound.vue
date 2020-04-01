<template>
  <div class="error">
    <img src="../assets/images/error.png"/>
    <p>We are sorry but the page you're looking for was not found.</p>
  </div>
</template>

<script>
export default {
  name: 'not-found'
}
</script>

<style scoped>
.error {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
}
.error p {
  font-size: 24px;
}
</style>
