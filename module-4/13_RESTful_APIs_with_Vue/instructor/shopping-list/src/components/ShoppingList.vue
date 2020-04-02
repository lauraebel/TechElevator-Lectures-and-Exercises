<template>
  <div class="shopping-list">
    <h1>My Shopping List</h1>
    <ul>
      <li
          v-for="item in groceries"
          v-bind:key="item.id"
          v-bind:class="{ completed: item.completed }"
          v-on:click="changeStatus(item.id,$event)">
        <input type="checkbox" :checked="item.completed">
        {{item.name}}
        <i class="far fa-check-circle"></i>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
    data() {
        return {
            groceries: []
        }
    },
    methods: {
        changeStatus(id,event) {
            const arrIndex = this.groceries.findIndex((item) => item.id == id);
            this.groceries[arrIndex].completed = !this.groceries[arrIndex].completed;
            
            // the checkbox might not have been target of the click event
            // If the user clicks on the list item we still want to check the checkbox
            if( event.target.type != 'checkbox' ) {
                const checkbox = event.target.querySelector('input[type="checkbox"]');
                checkbox.checked = !checkbox.checked;
            }
        }
    }
}
</script>

<style>
.shopping-list {
  width: 450px;
  background: #fff;
  margin: 50px auto;
  font-family: "Roboto Condensed", sans-serif;
  border-radius: 10px;
}
h1 {
  background: #f2f2f2;
  color: #5c8578;
  padding: 10px;
  font-size: 24px;
  text-transform: uppercase;
  text-align: center;
  margin-bottom: 0px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
ul {
  list-style-type: none;
  margin: 0px;
  padding: 0px;
}
li {
  font-size: 24px;
  border-bottom: 1px solid #f2f2f2;
  padding: 10px 20px;
  cursor: pointer;
}
li:last-child {
  border: 0px;
}
li.completed {
  text-decoration: line-through;
  color: darkgrey;
}
i.far.fa-check-circle {
  float: right;
  color: darkgray;
}

i.far.fa-check-circle.completed {
  color: green;
}
input[type="checkbox"] {
  font-size: 40px;
  vertical-align: middle;
  margin-top: 0px;
}
</style>
