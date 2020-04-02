<template>
    <div class="todo-list">
        <h1>{{this.title}}</h1>
        <ul>
            <li v-for="todo in todos" 
                v-bind:key="todo.id" 
                v-bind:class="{'todo-completed': todo.completed}" 
                v-on:click="changeStatus(todo.id, $event)">
                <input type="checkbox"/>
                {{todo.task}} <i class="far fa-check-circle" v-bind:class="{completed: todo.completed}"></i>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    props: {
        title: String,
        search: String,
        todos: Array
    },
    methods: {
        changeStatus(id,event) {
            const arrIndex = this.todos.findIndex((todo) => todo.id == id);
            this.todos[arrIndex].completed = !this.todos[arrIndex].completed;
           
            // the checkbox might not have been target of the click event
            if( event.target.type != 'checkbox' ) {
                const checkbox = event.target.querySelector('input[type="checkbox"]');
                checkbox.checked = !checkbox.checked;
            }
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
    margin:0px;
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
    cursor:pointer;
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
