<template>
    <div class="books">
        <h1>Related Books</h1>
        <p>This is a lit of other books you might enjoy.</p>
        <books-list />
    </div>
</template>

<script>
import BooksList from '@/components/BooksList';

export default {
    name: 'books',
    components: {
        BooksList
    }    
}
</script>