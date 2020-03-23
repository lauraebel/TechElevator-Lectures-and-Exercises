/*
* Add Events and functions to move the Ship and Win the game
*/
// Creates the Grid -- this should only occur after the DOM loads
document.addEventListener('DOMContentLoaded', () => {

    createGrid();

    document.querySelector('body').addEventListener('keyup', (event) => {
        if (event.key === 'ArrowRight') {
            moveShipRight();
        }
        if (event.key === 'ArrowLeft') {
            moveShipLeft();
        }
        if (event.key === 'ArrowDown') {
            moveShipDown();
        }
        if (event.key === 'ArrowUp') {
            moveShipUp();
        }
    });

    document.getElementById('resetButton').addEventListener('click', (event) => {
        resetGame();
        event.preventDefault();
    });

});

function moveShipUp() {
    const ship = getShipLocation();
    const up = getElementAtSameIndex(ship, ship.parentElement.previousElementSibling);
    moveShip(ship, up);
}

function moveShipDown() {
    const ship = getShipLocation();
    const down = getElementAtSameIndex(ship, ship.parentElement.nextElementSibling);
    moveShip(ship, down);
}

function getElementAtSameIndex(ship, newElement) {
    if (newElement == null) {
        return null;
    }
    // Get the index of where the ship is in its parent's children
    const index = Array.from(ship.parentNode.children).indexOf(ship);
    // get the element at the same index from the target row
    return newElement.childNodes[index];
}

function moveShipLeft() {
    const ship = getShipLocation();
    const left = ship.previousElementSibling;
    moveShip(ship, left);
}

function moveShipRight() {
    const ship = getShipLocation();
    const right = ship.nextElementSibling;
    moveShip(ship, right);
}

function canMoveToLocation(element) {
    if (element == null || element.classList.contains('pirate')) {
        return false;
    }
    return true;
}

function moveShip(start, end) {
    if (canMoveToLocation(end)) {
        if (isWin(end)) {
            win();
        } else {
            start.classList.remove('boat');
            end.classList.add('boat');
        }
    }
}

function getShipLocation() {
    return document.getElementById('frame').querySelector('.boat');
}

function isWin(nextElement) {
    return nextElement.classList.contains('treasure');
}

function win() {
    const announce = document.querySelector('.announce');
    announce.classList.add('winText');
    announce.innerText = "You Win!";
    getShipLocation().classList.remove('boat');
}

/**
 * Reset the Game
 */
function resetGame() {

    // Remove the ship from its current location
    const ship = getShipLocation();
    if (ship != null) {
        ship.classList.remove('boat');
    }


    // Inform the user they can start
    const announce = document.querySelector('.announce');
    announce.classList.remove('winText');
    announce.innerText = 'Play!';

    // Set the starting locations of the boat and treasure
    const frame = document.getElementById('frame');
    frame.firstElementChild.firstElementChild.classList.add('boat');

    const lastPosition = frame.lastElementChild.lastElementChild;
    // If the last position is a pirate, remove it before adding the treasure
    if ( lastPosition.classList.contains('pirate') ) {
        lastPosition.classList.remove('pirate');
    }
    lastPosition.classList.add('treasure');


}

/**
 * Creates the game grid
 */
function createGrid() {

    const frame = document.getElementById('frame');

    // Add Code to create the game grid
    for (let i = 0; i < 10 ; i++) {
        buildRow(frame); 
    }
    resetGame();
}

/**
 * Builds the grid rows
 * @param {element} frame 
 */
function buildRow(frame) {
    const row = document.createElement('div');
    row.classList.add('row');
    frame.insertAdjacentElement('beforeend', row);
   // Add code to create rows
    for (let i = 0; i < 10 ; i++) {
        buildSquare(row, i); 
    }    
}

/**
 * Builds the grid squares 
 * @param {element} row 
 * @param {int} count 
 */
function buildSquare(row, count) {
   // Add code to create the grid Squares
    const square = document.createElement('div');
    square.classList.add('square');

    // Randomly creates pirates, but not on the first elemment
    if (count > 1) {
        if ((Math.floor(Math.random() * 100) + 1) > 85) {
            // Add the pirates here
            square.classList.add('pirate');
        } 
    }

    row.insertAdjacentElement('beforeend', square);
}



