<template>
    <div class="todo-list">
        <h1>My Daily Routine</h1>
        <ul>
            <li v-for="todo in todos" v-bind:key="todo.id" v-bind:class="{'todo-completed': todo.completed}">
                {{todo.task}} <i class="far fa-check-circle" v-bind:class="{completed: todo.completed}"></i>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data() {
        return {
           todos: [
               { task: 'Wake up', completed: false },
               { task: '5 Minute Morning Movement', completed: false },
               { task: 'Meditate', completed: false },
               { task: 'Brush Teeth', completed: false },
               { task: 'Shower', completed: false },
               { task: 'Get Dressed', completed: false },
               { task: 'Drive to work', completed: false },
               { task: 'Complete Work', completed: false },
               { task: 'Drive home from work', completed: false },
               {  task: 'Dinner', completed: false },
               {  task: 'Brush Teeth', completed: false },
               {  task: 'Go to bed', completed: false }
           ]
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
