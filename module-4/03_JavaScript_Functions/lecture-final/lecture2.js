// variable in global scope
let name = 'John';

function greeting(nameToGreet) {
    console.log(nameToGreet);
}



/* Spread Operator */
function multipleWithSpread( x, y , z) {
    return x * y * z;
}

let args = [1, 2, 3];
console.log( multipleWithSpread(...args) );

function addWithSpread(a, b, c) {
    return a + b + c;
}
let str = "Tech Elevator";
console.log( addWithSpread(...str) );


/* Anonymous Functions */

// declare using the function keyword
const doubleSum = function (x, y) {
    return (x + y) * 2;
}

let y = doubleSum;

// declare using the arrow operator
const trippleSum = (x, y) => {
    return (x + y) * 3;
}

y = trippleSum;

/* Array Reduce() function */
const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9 , 10];

let sum = arr.reduce( (sum, value) => {
    return sum + value;
});

console.log( "reduced: " + sum );

    // The above reduce is equivalent to:
    function sumNumbersInArray( arrToSum ) {
        let sum = 0;
        for ( let i = 0; i < arrToSum.length; i++) {
            sum = sum + arrToSum[i];
        }
        return sum;
    }

const instructors = ["John", "Andrew", "Steve", "Rachelle"];

let list = instructors.reduce( (newStr, value) => {
    return newStr + ", " + value;
});
console.log( list );

/* Array filter() function */
let filteredArray = arr.filter( number => {
    return number % 3 === 0;
});
console.table(filteredArray);

let filteredInstructors = instructors.filter( name => {
    return name.length > 5;
});
console.table(filteredInstructors);

/* Array map() function */
let mappedToDouble = arr.map( number => {
    return number * 2;
});
console.table(mappedToDouble);

let longNames = instructors.map( name => {
    if (name.length > 5) {
        return name;
    }
    return "";
});
console.table( longNames );

/* Using Anonymous functions as parameters */

function doMath(x, y, func) {
    const result = func(x, y);
    console.log("The result is " + result);
}

doMath(2, 3, (x, y) => {
    return x * y;
});

const add = (x, y) => { return x + y; };
const subtract = (x, y) => { return x - y; };

doMath(10, 5, add);
doMath(10, 5, subtract);

doMath(-20, 5, (x, y) => {
    const distance = Math.abs(x - y);
    return Math.pow(distance, 3);
});

function functionAsParameter(array, filterFunc) {
    return array.filter(filterFunc).map( x => {
        return 'A' + x;
    });
}

console.table( functionAsParameter( arr, num => { return num % 2 === 0; }));
console.table( functionAsParameter( arr, num => { return num % 2 !== 0; }));
console.table( functionAsParameter( instructors, i  => { return i.length < 5 }));