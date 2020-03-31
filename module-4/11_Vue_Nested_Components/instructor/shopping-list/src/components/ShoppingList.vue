<template>
    <div class="shopping-list">
        <h2>{{title}}</h2>
        <ul>
            <li v-for="item in data" 
                v-bind:key="item.id" 
                v-bind:class="{ completed: item.completed }" 
                v-on:click="changeStatus(item.id,$event)">
                <input type="checkbox"/>
                {{item.name}} 
                <i class="far fa-check-circle" v-bind:class="{ completed: item.completed }"></i>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    name: 'shopping-list',
    props: {

    },
    data() {
        return {
            
        }
    },
    methods: {
        changeStatus(id,event) {
            const arrIndex = this.data.findIndex((item) => item.id == id);
            this.data[arrIndex].completed = !this.data[arrIndex].completed;
            
            // the checkbox might not have been target of the click event
            if( event.target.type != 'checkbox' ) {
                const checkbox = event.target.querySelector('input[type="checkbox"]');
                checkbox.checked = !checkbox.checked;
            }
        }
    },
    computed: {

    }
}
</script>

<style>
.shopping-list {
    width:450px;
    background: #fff;
    margin: 50px auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
h2{
    background:#f2f2f2;
    color:#5c8578;
    padding:10px;
    font-size:24px;
    text-transform: uppercase;
    text-align: center;
    margin: 0px;
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
    cursor: pointer;
}
li:last-child{
    border:0px;
}
li.completed {
    text-decoration: line-through;
    color:darkgrey;
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
