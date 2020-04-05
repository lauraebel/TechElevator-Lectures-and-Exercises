<template>
  <div class="todos">
    <ul class="todos">
      <li v-for="todo in todos" :key="todo.id">
        {{ todo.title }}
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: "todo-list",
    props: {
      todos: Array
    }
    
  };
</script>

<style>
  .todos li {
    padding: 4px;
  }
</style>
