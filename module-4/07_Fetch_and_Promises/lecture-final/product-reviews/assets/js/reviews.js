// A variable to hold the array of reviews
let reviews = [];

// When the DOM is loaded
    // Load the reviews using Fetch 
    // display the reviews
    // disable the Load Reviews Button
document.addEventListener('DOMContentLoaded', ()=>{

    const button = document.querySelector('button');
    button.addEventListener('click', (event) =>{
        loadReviews();
        button.disabled = true;
        event.preventDefault();
    });

});

/**
 * This function when invoked will look at an array of reviews
 * and add it to the page by cloning the #review-template
 */
function displayReviews() {
    console.log("Display Reviews...");
  
    // first check to make sure the browser supports templates
    if ('content' in document.createElement('template')) {
        // query the document .reviews and assign to a variable called container
        const container = document.querySelector('.reviews');
        // loop over the reviews array
        reviews.forEach( review => {
            // deep clone the template; add data to each of its elements from the review
            const tmpl = document.getElementById('review-template').content.cloneNode(true);
            tmpl.querySelector('img').setAttribute('src', review.avatar);
            tmpl.querySelector('.username').innerText = review.username;
            tmpl.querySelector('h2').innerText = review.title;
            tmpl.querySelector('.published-date').innerText = review.publishedOn;
            tmpl.querySelector('.user-review').innerText = review.review;
            // append the template to the container
            container.appendChild(tmpl);
        })
    } else {
        // If does not support templates, log an error
        console.error("The browser does not support templates");
    } 
    

}

// Method to load the reviews
function loadReviews() {
    console.log("Load Reviews...");

    // fetch(url)
    // fetch using a remote web api
    // fetch('http://5dd69774ce4c300014403ae7.mockapi.io/productdata')
    
    // fetch using a local file
    fetch('data.json')
        // fetch returns a promise that when successful
        // calls the anonymous function passed in then()
        .then( (response) => {
            // fetch passes the response object as an argument
            // call json() on the response object, which converts
            // the JSON to JavaScript objects, but json() returns
            // a promise
            return response.json();
        })
        // response.json() returns a promise that when successful
        // calls the anonymous function passed in this then()
        .then( (data) => {
            // json() passes the javascript objects that were created
            // from the JSON data as a argument to our method.

            // DO SOMETHING WITH THE RETURNED DATA
            reviews = data;
            //console.table(data);

            // Call display reviews here, because we need to be sure
            // the promise has been fulfilled and the reviews loaded
            displayReviews();
        })
        .catch( err => console.error(err) );

}