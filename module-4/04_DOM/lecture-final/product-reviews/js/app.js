const name = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Gladwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add our product name to the page title
 * Get our page page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = name;
}

/**
 * Add our product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * I will display all of the reviews on the page.
 * I will loop over the array of reviews and use some helper functions
 * to create the elements needed for our markup and add them to the DOM
 */
function displayReviews() {

  // Get a reference to the div where the reviews will be added
  const main = document.getElementById('main');

  // Loop through each review
  reviews.forEach( review => {

    // Create a parent div for the review
    const container = document.createElement('div');

    // Adding the review class to the div :  <div class="review">
    //container.setAttribute('class', 'review');
    container.classList.add('review');

    // reviewer
    addReviewer(container, review.reviewer);
    // rating
    addRating(container, review.rating);
    // title
    addTitle(container, review.title);
    // review
    addReview(container, review.review);

    // Insert the review as the last child of the parent div (main)
    main.insertAdjacentElement('beforeend', container);
  });

}

/**
 * I will creating a new h4 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} el: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const reviewer = document.createElement('h4');
  reviewer.innerText = name;
  parent.appendChild(reviewer);
}

/**
 * I will add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {

  // create the div <div>
  const rating = document.createElement('div');
  // set the class="rating" : <div class="rating">
  rating.classList.add('rating');

  // Loop the number of times in numberOfStars
  for (let i = 0; i < numberOfStars; i++) {
    // create an <img>
    const star = document.createElement('img');
    // set the class to ratingStar ; <img class="ratingStar">
    star.classList.add('ratingStar');
    // set the src of the img:  <img src="img/star.png" class="ratingStar" />
    star.src = 'img/star.png';
    // Add the img to the rating div
    rating.appendChild(star);
  }

  // Add the rating div to the parent container (review div)
  parent.appendChild(rating);



}

/**
 * I will add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  // Create an h3 element
  const h3 = document.createElement('h3');
  // Set the text on the element
  h3.innerText = title;
  // append it to the review div
  parent.appendChild(h3);

}

/**
 * I will add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  // create a paragraph tag
  const p = document.createElement('p');
  // set the text of the paragraph
  p.innerText = review;
  // append the paragraph to the review div
  parent.appendChild(p);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on our page
displayReviews();
