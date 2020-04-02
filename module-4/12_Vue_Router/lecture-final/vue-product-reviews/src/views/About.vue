<template>
  <div class="about">
    <h1>About the Author</h1>
    <author-bio />
  </div>
</template>

<script>
import AuthorBio from '@/components/AuthorBio'

export default {
  name: 'about',
  components: {
    AuthorBio
  }
}
</script>