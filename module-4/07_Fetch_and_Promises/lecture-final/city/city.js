document.addEventListener('DOMContentLoaded', ()=> {
    loadCities();
});


function loadCities() {
    
    fetch('data/city.json')
        .then( resp => {
            return resp.json();
        })
        .then( cities => {
            //console.table(cities);
            displayCities(cities);
        })
        .catch ( err => console.error(err) );

}

function displayCities(cities) {
    //console.table(cities);

    if ('content' in document.createElement('template')) {
        const container = document.getElementById('cities');

        cities.forEach( city => {
            const tmpl = document.getElementById('city-template').content.cloneNode(true);
            tmpl.querySelector('h2').innerText = city.name;
            tmpl.querySelector('.location').innerText = `${city.district}, ${city.countryCode}`; 
            tmpl.querySelector('.population').innerText = city.population;
            container.appendChild(tmpl);
        })
  

    } else {
        console.error("You need a newer browser!")
    }
}