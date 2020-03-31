# Vue Router Student Tutorial

In this tutorial you are going to work on a TodoList project that has a few different lists. This tutorial will be slightly different than the todo tutorials you have worked on before but the concept is the same.

The main objectives of the tutorial are:

- Creating new views
  - Create routes associated with those views
  - Create a component to be used in your views
- Adding routes for different views
  - Using router-link with the desired path
  - Using named links
  - Styling the active route
  - Using the router link tag attribute
- Adding a not found component

## Project Starting code

The starting code for this project can be found in `/src/todo-router`. This is a brand new project created using the Vue CLI and we just cleaned up some of the default code for you. Before diving in and creating any new code this is a good time to examine what Vue Router added for us. Do you know what was added or changed in each of these files?

- src/router.js
- main.js
- src/views
- package.json

As with any JavaScript project that has a `package.json` the first thing you will need todo is run the command `npm install` to install any dependencies.

## Create the views and routes

Now that you are moving from creating single components to entire applications you need to think about what views (or pages) your application will consist of. In this tutorial you will have 3 different pages to display 3 different todo lists. You first task is to create the following 3 files in the `/src/views` folder. These files will be empty for now but don't worry you will come back and fill them in soon.

- Personal.vue
- Work.vue
- House.vue

Now that your views have been created you can set up routes for each of them. Before looking at the answer below try to do this yourself.

In `/src/router.js` you will want to update the routes array to contain 3 new routes for personal, work and house.

```js
import Vue from "vue";
import Router from "vue-router";
import Home from "@/views/Home.vue";
import Personal from "@/views/Personal";
import Work from "@/views/Work";
import House from "@/views/House";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/personal",
      name: "personal",
      component: Personal
    },
    {
      path: "/work",
      name: "work",
      component: Work
    },
    {
      path: "/house",
      name: "house",
      component: House
    }
  ]
});
```

Because there is no actual content in each of your views this might not be that exciting so let's fill those in next.

```html
<template>
  <div class="personal">
    <h1>Personal</h1>
  </div>
</template>

<script>
  export default {
    name: "personal",
    components: {}
  };
</script>
```

```html
<template>
  <div class="work">
    <h1>Work</h1>
  </div>
</template>

<script>
  export default {
    name: "work",
    components: {}
  };
</script>
```

```html
<template>
  <div class="house">
    <h1>House</h1>
  </div>
</template>

<script>
  export default {
    name: "house",
    components: {}
  };
</script>
```

If you run the project (`npm run serve`) you should be able to change the route in the url and see the different headings

- http://localhost:8080/personal
- http://localhost:8080/work
- http://localhost:8080/house

## Create the navigation

Now that you have configured a few routes and have some pages you need a way for your visitors to get to them. You certainly don't want to ask them to remember the route for each of your pages and this is where creating a navigation will help out.

Before looking at the answer below can you solve this on your own? You will want to place this code inside of `App.vue` and you should have an unordered list with 4 list items that link to the following routes.

- Home
- Personal
- Work
- House

If you think you have it working run your application and see if you can navigate to the different pages.

I wrapped my list in a header tag but you should have something like this. If you're already using named routes you're 1 step ahead of me and we will get there in a minute.

```html
<header>
  <ul class="nav">
    <li><router-link to="/">Home</router-link></li>
    <li><router-link to="/personal">Personal</router-link></li>
    <li><router-link to="/work">Work</router-link></li>
    <li><router-link to="/house">House</router-link></li>
  </ul>
</header>
```

While this looks better you still have a problem here. If you hover over the list item `<li>` you get the indication that you can click on the item but you can't.

![](./img/navigation_hover_issue.png)

It isn't until you `mouseover` the word do you get the black text and the ability to click on it and go to that route. This is because there is a `<li>` and an `<a>` tag here.

![](./img/navigation_hover_hit.png)

One way that you could fix this is by using the `<router-link>` tag attribute. If you change the navigation to this

```html
<header>
  <ul class="nav">
    <router-link to="/" tag="li">Home</router-link>
    <router-link to="/personal" tag="li">Personal</router-link>
    <router-link to="/work" tag="li">Work</router-link>
    <router-link to="/house" tag="li">House</router-link>
  </ul>
</header>
```

Now instead of the default `<a>` the router link component will render list items and respond to click events. This is what the rendered markup looks like.

```html
<header>
  <ul class="nav">
    <li class="router-link-exact-active router-link-active">Home</li>
    <li class="">Personal</li>
    <li class="">Work</li>
    <li class="">House</li>
  </ul>
</header>
```

### Current Route

A problem that will come up when building navigation into any application is letting the user know what page (or route) they are currently on.

Did you notice the class for the home page above? If you remember from the documentation you can add some styling so that the user knows what the current active route is.

```css
.router-link-active {
  background-color: rgb(44, 44, 44);
}
```

There is one small issue left, do you know what it is and how to solve it? No matter what page you go to the Home link seems to be active. This is something else you saw in the documentation. An easy fix for this is to add the `exact` attribute to the home link.

```html
<header>
  <ul class="nav">
    <router-link to="/" tag="li" exact>Home</router-link>
    <router-link to="/personal" tag="li">Personal</router-link>
    <router-link to="/work" tag="li">Work</router-link>
    <router-link to="/house" tag="li">House</router-link>
  </ul>
</header>
```

Finally it's best practice to used named routes so if you wanted to change a routes path later you don't have to update it across your entire application.

```html
<header>
  <ul class="nav">
    <router-link :to="{ name: 'home' }" tag="li" exact>Home</router-link>
    <router-link :to="{ name: 'personal' }" tag="li">Personal</router-link>
    <router-link :to="{ name: 'work' }" tag="li">Work</router-link>
    <router-link :to="{ name: 'house' }" tag="li">House</router-link>
  </ul>
</header>
```

## The Todo List component

As you learned in the reading material for this lesson both the `/src/views` & `/src/components` folders contain Vue components. As a convention any components in the `/src/views` folder will have a route associated with it. When you want to create a component that is reusable it will go in the `/src/components` folder.

You have 3 pages that will display 3 different todo lists. While the list of todo's might be different, the way they are displayed is not. This is a good opportunity to create a component that you can use on each of your pages.

Create a new component called `TodoList.vue` in `/src/components`.

```html
<template>
  <div class="todos">
    <ul class="todos">
      <li v-for="todo in todos" :key="todo.id">
        {{ todo.title }}
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: "todo-list",
    props: {
      todos: Array
    }
  };
</script>

<style>
  .todos li {
    padding: 4px;
  }
</style>
```

And import that component into `src/views/Personal.vue`. The Todo List Component accepts a prop called todos that is an array of todos to display. For now this will just be an empty array.

```html
<template>
  <div class="personal">
    <h1>Personal</h1>
    <todo-list :todos="[]" />
  </div>
</template>

<script>
  import TodoList from "@/components/TodoList";

  export default {
    name: "personal",
    components: {
      TodoList
    }
  };
</script>
```

Repeat these same steps for Work and House.

Finally add the following data to each of the views and update the TodoList component to use it as its data.

```javascript
data() {
    return {
      personal: [
        { id: 1, title: 'Drop off dry cleaning' },
        { id: 2, title: 'Put gas in the car' },
        { id: 3, title: 'Call and find out why the cable bill is so high' },
        { id: 4, title: 'Stop by the pharmacy and pickup prescription' },
        { id: 5, title: 'Get the car washed' },
        { id: 6, title: 'Grocery shopping for the week' },
        { id: 7, title: 'Run to target to get a few things' },
        { id: 8, title: 'Pickup dinner for the family' },
        { id: 9, title: 'Order balloons for the party' },
        { id: 10, title: 'Call Mom and wish her a happy birthday' }
      ]
    }
  }
```

```javascript
data() {
    return {
      work: [
        { id: 1, title: '8:00 AM Meeting with Marketing about the new blog post' },
        { id: 2, title: '9:00 AM - 10:00 AM work on the new student book material' },
        { id: 3, title: '10:00 AM Standup' },
        { id: 4, title: '12:00 PM - 1:00 PM Lunch' },
        { id: 5, title: '1:30 PM - 2:30 PM Instructor call'},
        { id: 6, title: '3:00 PM - 4:00 PM Lecture notes for the new content' },
        { id: 7, title: '4:30 PM - 5:30 PM All Team Meeting' }
      ]
    }
  }
```

```js
  data() {
    return {
      house: [
        { id: 1, title: 'Cut the grass and blow off the back patio' },
        { id: 2, title: 'Trim the bushes' },
        { id: 3, title: 'Clean out the garage' },
        { id: 4, title: 'Power wash driveway and house' },
        { id: 5, title: 'Get estimate for a new bathtub in the main bathroom' },
        { id: 6, title: 'Replace carpet in the basement' },
        { id: 7, title: 'Paint the guest bedroom' },
        { id: 8, title: 'Find new indoor / outdoor carpet for the sunroom' }
      ]
    }
  }
```

If you run the application you should see your list of Todos displayed for each page. Just to clean things up a bit you can add a little text to your home page to `/src/views/Home.vue`

```html
<template>
  <div class="home">
    <h1>Home</h1>
    <p>
      This is a tutorial that will display multiple todo lists. The main purpose
      of it is to practice using the vue router.
    </p>
  </div>
</template>
```

How are each of your views displayed in the application? Do you know what component controls this and where it is located? If you said the `<router-view></router-view>` component in `App.vue` you are correct. This is just another component so if you wanted to you could add a class to it to give our content some padding.

```html
<template>
  <div id="app">
    <header>
      <ul class="nav">
        <router-link :to="{ name: 'home' }" tag="li" exact>Home</router-link>
        <router-link :to="{ name: 'personal' }" tag="li">Personal</router-link>
        <router-link :to="{ name: 'work' }" tag="li">Work</router-link>
        <router-link :to="{ name: 'house' }" tag="li">House</router-link>
      </ul>
    </header>
    <router-view class="content" />
  </div>
</template>
```

```css
.content {
  padding: 20px;
}
```
