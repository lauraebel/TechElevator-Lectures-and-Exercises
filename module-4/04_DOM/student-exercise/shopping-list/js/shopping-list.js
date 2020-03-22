// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
const groceries = ['bread', 'milk', 'butter', 'eggs', 'cereal', 'pasta', 'chicken', 'coffee', 'rice', 'beans'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;
}
/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
const main = document.getElementById('groceries');

groceries.forEach(item => {
  const container = document.createElement('div');
  container.classList.add('item');

  addItem(container, item);

  main.insertAdjacentElement('beforeend', container);
}
  )
}

function addItem(parent, item) {
  const items = document.createElement('h4');
  items.innerText = item;
  parent.appendChild(items);
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
