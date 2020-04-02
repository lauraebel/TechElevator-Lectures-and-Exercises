<template>
  <div id="app">
    <todo-search v-on:filter-tasks="handleSearch"></todo-search>
    <todo-list title="My Work Todos" v-bind:todos="work" v-bind:search="search" ></todo-list>
    <todo-list title="My Personal Todos" v-bind:todos="personal" v-bind:search="search" ></todo-list>
    <todo-list title="My Household Todos" v-bind:todos="household" v-bind:search="search" ></todo-list>
  </div>
</template>

<script>
import TodoSearch from '@/components/TodoSearch';
import TodoList from '@/components/TodoList';

export default {
  name: 'app',
  components: {
    TodoSearch,
    TodoList
  },
  data() {
    return {
      search: '',
      work: [
        { id: 1, task: 'Create new presentation', completed: false },
        { id: 2, task: 'Add slides to presentation', completed: false },
        { id: 3, task: 'Add images to presentation', completed: false },
        { id: 4, task: 'Add FAQ', completed: false },
        { id: 5, task: 'Add Branded colors to presentation', completed: false },
        { id: 6, task: 'Add About Me Slide', completed: false },
        { id: 7, task: 'Finish presentation', completed: false }
      ],
      personal: [
        { id: 1, task: 'Pick up dry cleaning', completed: false },
        { id: 2, task: 'Grocery Shopping', completed: false },
        { id: 3, task: 'Fill up gas tank', completed: false },
        { id: 4, task: 'Get both cars washed', completed: false },
        { id: 5, task: 'Do laundry', completed: false },
        { id: 6, task: 'Plan party', completed: false },
        { id: 7, task: 'Vacuum entire house', completed: false }
      ],
      household: [
        { id: 1, task: 'Clean up yard', completed: false },
        { id: 2, task: 'Get chimney cleaned', completed: false },
        { id: 3, task: 'New Carpet for entire house', completed: false },
        { id: 4, task: 'New bathtub', completed: false },
        { id: 5, task: 'Paint office', completed: false },
        { id: 6, task: 'Install new TV downstairs', completed: false },
        { id: 7, task: 'New carpet in the sunroom', completed: false }
      ],
    }
  },
  methods: {
    handleSearch(query) {
        console.log('Filter Tasks: ', query);
        this.search = query;
    }
  }
}
</script>

<style>
body {
  background: rgb(74,162,244);
  background: radial-gradient(circle, rgba(74,162,244,1) 0%, rgba(54,131,240,1) 100%);
}

#app {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 20px;
}

.search { 
  grid-column: 2 / 3;
  grid-row: 1;
}
.todo-list {
  grid-row: 2;
}
</style>

