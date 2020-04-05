<template>
  <div class="personal">
    <h1>Personal</h1>
        <todo-list :todos="[]" />
  </div>
</template>

<script>
  import TodoList from "@/components/TodoList";

  export default {
    name: "personal",
    components: {
        TodoList
    },
    data() {
    return {
      personal: [
        { id: 1, title: 'Drop off dry cleaning' },
        { id: 2, title: 'Put gas in the car' },
        { id: 3, title: 'Call and find out why the cable bill is so high' },
        { id: 4, title: 'Stop by the pharmacy and pickup prescription' },
        { id: 5, title: 'Get the car washed' },
        { id: 6, title: 'Grocery shopping for the week' },
        { id: 7, title: 'Run to target to get a few things' },
        { id: 8, title: 'Pickup dinner for the family' },
        { id: 9, title: 'Order balloons for the party' },
        { id: 10, title: 'Call Mom and wish her a happy birthday' }
      ]
    }
  }
  };
</script>