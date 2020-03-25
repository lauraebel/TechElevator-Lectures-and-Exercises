let groceries = [];

document.addEventListener('DOMContentLoaded', ()=> {
    const button = document.querySelector('.loadingButton');
    button.addEventListener('click', (event) => {
        loadGroceries();
        button.disabled = true;
        event.preventDefault();
    });
});

// if('content' in document.createElement('template')) {
//     const container = document.querySelector('ul');
//     groceries.forEach(item => {
//         const template = document.getElementById('shopping-list-item-template').content.cloneNode(true);
//         template.querySelector('li').innerText = item.name;
//         if(item.completed) {
//         template.querySelector('i').classList.add('completed');
//         }
//         container.appendChild(template);

//     })
// } else {
// console.error("The browser does not support templates");
// } 
// }

function displayGroceries() {
    if('content' in document.createElement('template')) {
        const container = document.querySelector('ul');
        groceries.forEach(item => {
            const template = document.getElementById('shopping-list-item-template').content.cloneNode(true);
            template.querySelector('li').insertAdjacentText('afterbegin', item.name);
            if(item.completed) {
            template.querySelector('i').classList.add('completed');
            }
            container.appendChild(template);
        })
} else {
    console.error("The browser does not support templates");
} 
}

function loadGroceries() {
    fetch('assets/data/shopping-list.json')
    .then((response) => {
        return response.json();
    })
    .then((data) => {
        groceries = data;
        displayGroceries();
    })
}


    

