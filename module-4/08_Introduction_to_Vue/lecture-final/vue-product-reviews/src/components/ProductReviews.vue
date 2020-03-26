<template>
    <div class="main">
        <h2>Product Reviews for {{ reviewName }}</h2>
        <p class="description"> {{ description }} </p>
    </div>
</template>

<script>
export default {
    name: 'product-reviews',
    data() {
        return {
            reviewName: 'Cigar Parties for Dummies',
            description: 'Hsot and plan a perfect blah blah blah....'
        }
    }
}
</script>


<style scoped>
div.main {
    margin: 1rem 0;
}
</style>