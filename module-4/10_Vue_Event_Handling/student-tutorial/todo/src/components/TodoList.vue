<template>
    <div class="todo-list">
        <h1>My Daily Routine</h1>
        <ul>
            <li v-for="todo in todos" v-bind:key="todo.id" :class="{'todo-completed': todo.completed}">
            <input type="checkbox" v-on:click="changeStatus(todo.id)"/>
                {{todo.task}} <i class="far fa-check-circle" :class="{completed: todo.completed}"></i>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data() {
        return {
           todos: [
            { id: 1, task: 'Wake up', completed: false },
            { id: 2, task: '5 Minute Morning Movement', completed: false },
            { id: 3, task: 'Meditate', completed: false },
            { id: 4, task: 'Brush Teeth', completed: false },
            { id: 5, task: 'Shower', completed: false },
            { id: 6, task: 'Get Dressed', completed: false },
            { id: 7, task: 'Drive to work', completed: false },
            { id: 8, task: 'Complete Work', completed: false },
            { id: 9, task: 'Drive home from work', completed: false },
            { id: 10, task: 'Dinner', completed: false },
            { id: 11, task: 'Brush Teeth', completed: false },
            { id: 12, task: 'Go to bed', completed: false }
           ]
        }
    },
    methods: {
    changeStatus(id) {
    const arrIndex = this.todos.findIndex((todo) => todo.id == id);
    this.todos[arrIndex].completed = !this.todos[arrIndex].completed;
    }
}
}
</script>

<style>
.todo-list {
    width:450px;
    background: #fff;
    margin: 50px auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
h1 {
    background:#f2f2f2;
    color:#4b86A6;
    padding:10px;
    font-size:24px;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 0px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
ul {
    list-style-type: none;
    margin:0px;
    padding:0px;
}
li {
    font-size: 24px;
    border-bottom:1px solid #f2f2f2;
    padding:10px 20px;
}
li:nth-child(odd) {
    /* background-color: rgb(129, 182, 129); */
}
li:last-child{
    border:0px;
}
li.todo-completed {
    text-decoration: line-through;
    color: darkgray;
}
i.far.fa-check-circle { 
    float:right;
    color: darkgray;
}

i.far.fa-check-circle.completed {
    color:green;
}
input[type="checkbox"] {
    font-size:40px;
    vertical-align: middle;
    margin-top:0px;
}
</style>
