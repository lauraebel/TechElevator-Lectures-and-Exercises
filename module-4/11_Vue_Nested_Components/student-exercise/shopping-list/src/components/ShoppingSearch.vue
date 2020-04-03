<template>
    <div class="search">
        <input type="text" id="search" name="search" v-on:keyup="filterNames" placeholder="Search Shopping List..."/>
    </div>
</template>

<script>
export default {
    methods: {
    filterNames() {
    const query = document.getElementById('search').value;
    this.$emit('filter-names', query);
}
    }
}
</script>

<style>
#search {
    width:100%;
    font-size:24px;
    font-family: 'Roboto Condensed', sans-serif;
    padding:10px;
}
</style>