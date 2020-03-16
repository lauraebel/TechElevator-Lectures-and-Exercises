/* SET YOUR API ENDPOINT HERE */
//const API_URL = 'http://5ddbefaa041ac10014de18e9.mockapi.io/api/reviews'
const API_URL = 'http://localhost:8080/m4-product-reviews-api-final/api/reviews'

let reviews = [];
let workingReview = null; 

document.addEventListener('DOMContentLoaded', () => {
    loadReviews();
    const button = document.querySelector('.loadReview');
    button.addEventListener('click', () => {
        reloadReviews();
    });

    const addReviewForm = document.getElementById('addReviewDiv');
    document.querySelector('.addReview').addEventListener('click', () => {
        swapHidden(addReviewForm);
    });

    document.getElementById('submitButton').addEventListener('click', (event) => {
        event.preventDefault();
        
        if (!workingReview) {
            saveReview();
        } else {
            updateReview();
        }
        
        swapHidden(addReviewForm);
    });

    document.querySelector('.reviews').addEventListener('click' , (event) => {
        if (event.target.classList.contains('editButton')) {
            const id = event.target.dataset.id;
            workingReview = getReviewFromList(id);
            showAndPopulateEditFormFromWorkingReview();
            event.preventDefault();
        }
        if (event.target.classList.contains('deleteButton')) {
            const id = event.target.dataset.id;
            deleteReview(id);
            event.preventDefault();
        }
    })

});

function showAndPopulateEditFormFromWorkingReview() {
    document.getElementById('name').value = workingReview.name;
    document.getElementById('title').value = workingReview.title;
    document.getElementById('reviewText').value = workingReview.review;
    swapHidden(document.getElementById('addReviewDiv'));
}

function getReviewFromList(id) {
    return reviews.find(obj => obj.id == id);
}

function reloadReviews() {
    clearReviews();
    loadReviews();
    displayReviews();
}

function clearReviews() {
    const reviewDivs = document.querySelectorAll('.review');

    for (let i = 0; i < reviewDivs.length; i++) {
        reviewDivs[i].parentNode.removeChild(reviewDivs[i]);
    }
    reviews = [];
}

/**
 * This function when invoked will look at an array of reviews
 * and add it to the page by cloning the #review-template
 */
function displayReviews() {
    console.log("Display Reviews...");
    
    // first check to make sure the browsers supports templates
    if ('content' in document.createElement('template')) {
        // query the document for .reviews and put it in a variable called container
        const container = document.querySelector('.reviews');
        // loop over the reviews array
        reviews.forEach( (review) => {
            // get the template, clone it, find all the elements and assign data to them
            const tmpl = document.getElementById('review-template').content.cloneNode(true);
            tmpl.querySelector('img').setAttribute('src', review.avatar);
            tmpl.querySelector('.username').innerText = review.name;
            tmpl.querySelector('h2').innerText = review.title;
            tmpl.querySelector('.published-date').innerText = review.createdAt;
            tmpl.querySelector('.user-review').innerText = review.review;
            tmpl.querySelector('.editButton').dataset.id = review.id;
            tmpl.querySelector('.deleteButton').dataset.id = review.id;
            // append the template to the DOM
            container.appendChild(tmpl);
        });

    } else {
        console.error("You need a better browser!");
    }
}

function swapHidden(element) {
    if (element.classList.contains('hide')) {
        element.classList.remove('hide');
        element.classList.add('show');
    }  else {
        clearForm();
        element.classList.remove('show');
        element.classList.add('hide');
        
    }
}

function clearForm() {
    const inputs = Array.from(document.querySelectorAll('.inputField'));
    inputs.forEach( (field) => {
        field.value = '';
    });
    workingReview = null;
}

function getReviewObjectForSave() {
    const reviewName = document.getElementById('name').value;
    const reviewTitle = document.getElementById('title').value;
    const reviewText = document.getElementById('reviewText').value;

    const review = {
        name: reviewName,
        title: reviewTitle,
        avatar: 'https://s3.amazonaws.com/uifaces/faces/twitter/joelhelin/128.jpg',
        review: reviewText
    };

    return review;
}

function updateWorkingReviewFromForm(){
    workingReview.name = document.getElementById('name').value;
    workingReview.title = document.getElementById('title').value;
    workingReview.review = document.getElementById('reviewText').value;
}

/*
 * LECTURE CODE STARTS HERE 
 */

/* GET */
function loadReviews() {
    console.log("Load Reviews...");

    fetch(API_URL)
        .then( (response) => {
            return response.json();
        })
        .then( (data) => {
            reviews = data;
            displayReviews();
        })
        .catch( (err) => {
            console.error(err);
        });

}

/* POST */
function saveReview() {
    console.log("Save Reviews...");

    const review = getReviewObjectForSave();

    fetch(API_URL, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(review)
    })
    .then((response) => {
        if (response.ok) {
            reloadReviews();
        } else {
            console.error(`Post failed ${response}`);
        }
    })
    .catch (err => console.error(err));




}

/* PUT */
function updateReview() {

    console.log("Update Review...");

    updateWorkingReviewFromForm();

    fetch(`${API_URL}/${workingReview.id}`, {
        method: 'PUT',
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(workingReview)
    })
    .then ( response => {
        if (response.ok) {
            reloadReviews();
        }
    })
    .catch ( err => console.error(err) );


}

/* DELETE */
function deleteReview(id) {

    console.log("Delete Review...");

    fetch(`${API_URL}/${id}`, {
    method: 'DELETE',
    headers: {
        "Content-Type": "application/json"
        }
    })
    .then( response => {
        if (response.ok) {
            reloadReviews();
        }
    })
    .catch( err => console.error(err) );
   


}

