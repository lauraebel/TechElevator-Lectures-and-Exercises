<template>
  <div class="books-list">
    <div class="book" v-for="book in books" :key="book.id">
      <img :src="require(`@/assets/book-covers/${book.img}`)" class="cover"/>
      <div class="title">{{book.title}}</div>
      <div class="author">by {{book.author}}</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'books-list',
  data() {
    return {
      books: [
        { id: 1, title: 'Crushing It', author: 'Gary Vaynerchuk', img: 'crushingit.jpg' },
        { id: 2, title: 'Jab, Jab, Jab.', author: 'Gary Vaynerchuk', img: 'jabjabjab.jpg' },
        { id: 3, title: 'The 4 Hour Work Week', author: 'Timothy Ferriss', img: '4hourworkweek.jpg' },
        { id: 4, title: 'Tools of Titans', author: 'Timothy Ferriss', img: 'toolsoftitans.jpg' },
        { id: 5, title: 'I will teach you to be rich', author: 'Ramit Sethi', img: 'iwillteachyou.jpg' },
        { id: 6, title: 'You Move', author: 'Ramit Sethi', img: 'yourmove.jpg' },
        { id: 7, title: 'Talking to Strangers', author: 'Malcolm Gladwell ', img: 'talkingtostrangers.jpg' },
        { id: 8, title: 'Outliers', author: 'Malcolm Gladwell ', img: 'outliers.jpg' },
        { id: 9, title: 'The Tipping Point', author: 'Malcolm Gladwell ', img: 'thetippingpoint.jpg' },
      ]
    }
  },
  methods: {

  }
}
</script>

<style>
.books-list {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 10px;
  margin-bottom: 40px;
}
.book {
  text-align: center;
  margin-bottom: 20px;
}
.cover {
  width: 175px;
}
.title {
  font-size: 21px;
  font-weight: 700;
  margin: 5px 0px;
}
.author {
  font-size:12px;
  font-style: italic;
}
</style>
