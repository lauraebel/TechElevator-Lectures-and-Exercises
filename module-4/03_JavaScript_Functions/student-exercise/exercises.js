/*
 * Document this function
 */

 /**
  * 
  * @param {number} month which month of the year it is 
  * @param {number} [day=1] which day of the month it is
  * @param {string} [hemisphere='northern'] whether the location is north or south of equator
  * @returns {string} which hemisphere it is
  */
function isSummer(month, day = 1, hemisphere = 'northern') {
  if (month === 7 || month === 8) {
    return hemisphere === 'northern';
  } else if (month === 6 && day >= 20) {
    return hemisphere === 'northern';
  } else if (month === 9 && day <= 20) {
    return hemisphere === 'northern';
  } else if (month === 1 || month === 2) {
    return hemisphere === 'southern';
  } else if (month === 12 && day >= 20) {
    return hemisphere === 'southern';
  } else if (month === 3 && day <= 20) {
    return hemisphere === 'southern';
  } else {
    return false;
  }
}

/**
 * Write a function called isAdmitted. It will check entrance
 * scores and return true if the students is admitted and
 * false if rejected. It takes three parameters:
 *
 *     * gpa
 *     * satScore (optional)
 *     * recommendation (optional)
 *
 * We admit them--return true--if:
 * gpa is above 4.0 OR
 * SAT score is above 1300 OR
 * gpa above 3.0 and they have a recommendation OR
 * SAT score is above 1200 and they have a recommendation
 * OTHERWISE reject it
 *
 * @param {number} gpa the GPA of the student, between 4.2 and 1.0
 * @param {number} [satScore=0] the student's SAT score
 * @param {boolean} [recommendation=false] does the student have a recommendation
 * @returns {boolean} true if they are admitted
 */

 function isAdmitted(gpa, satScore=0, recommendation=false) {
    if(gpa > 4.0) {
      return true;
    }
    if(satScore > 1300) {
      return true;
    }
    if(gpa > 3.0 && recommendation == true) {
      return true;
    }
    if(satScore > 1200 && recommendation == true) {
      return true;
    } else {
      return false;
    }
 }

/**
 * Write a function called useParameterToFilterArray so that it takes an anonymous
 * function and uses that in `unfilteredArray` filter function. Return the result.
 *
 * @param {function} filterFunction the function to filter with
 * @returns {number[]} the filtered array
 */
let unfilteredArray = [1, 2, 3, 4, 5, 6];

 function useParameterToFilterArray(filterFunction) {
   return unfilteredArray.filter(filterFunction);
 }

/**
 * Write a function called makeNumber to take two strings
 * of digits, concatenate them together, and then return
 * the value back as a number.
 *
 * So if two strings are passed in "42293" and "443", then this function
 * should return the number 42293443.
 *
 * @param {string} first the first string of digits to concatenate
 * @param {string} [second=''] the second string of digits to concatenate
 * @returns {number} the resultant number
 */

 function makeNumber(first, second='') {
   return parseInt(first.concat(second));
   
 }

/**
 * Write a function called addAll that takes an unknown number of parameters
 * and adds them all together. Return the result.
 *
 * @param {...number} num a series of numbers to add together
 * @returns {number} the sum of all the parameters (or arguments)
 */

 function addAll() {
   return Array.from(arguments).reduce((sum, value) => {  
    return sum + value; 
    },0)
  }
    
/*
 * Write and document a function called makeHappy that takes
 * an array and prepends 'Happy ' to the beginning of all the
 * words and returns them as a new array. Use the `map` function.
 */
/**
 * @param {string[]} stringArray strings to add 'Happy' to
 * @returns {string[]} new array with happy in front of each element
 */

 function makeHappy(stringArray) {
  let happy = 'Happy ';
  return stringArray.map((element) => {
      return happy + element;
   })
 }

/*
 * Write and document a function called getFullAddressesOfProperties
 * that takes an array of JavaScript objects containing the
 * following keys:
 *     * streetNumber
 *     * streetName
 *     * streetType
 *     * city
 *     * state
 *     * zip
 *
 * and returns an array of strings that turns the JavaScript objects
 * into mailing addresses in the form of:
 *     streetNumber streetName streetType city state zip
 *
 * Use `map` and an anonymous function.
 */
/**
 * @param {object[]} addresses string array of full addresses
 * @param {string|number} addresses[].streetNumber the street number of the address being listed
 * @param {string} addresses[].streetName the name of the street of the address being listed
 * @param {string} addresses[].streetType the type of street of the address being listed
 * @param {string} addresses[].city the city where the address is located
 * @param {string} addresses[].state the state where the address is located
 * @param {string} addresses[].zip the postal code where the address is located
 * @returns {string[]} the full addresses
 */
 function getFullAddressesOfProperties(addresses) {
  return addresses.map((address) => {
    return [address.streetNumber, address.streetName, address.streetType, address.city, address.state, address.zip].join(' ');
  })
}

/*
 * Create and document a function called findLargest.
 *
 * Using `forEach`, find the largest element in an array.
 * It should work for strings and numbers.
 */
/**
 * @param {string[]|number[]} arr 
 * @returns {string|number} largest
 */
function findLargest(arr) {
  let largest = '';
  arr.forEach((element) => {
    if (element > largest) {
      largest = element;
    }
  })
  return largest;
}
 

/*
 * CHALLENGE
 * Create and document a function called getSumOfSubArrayValues.
 *
 * Take an array of arrays and add up all sub values and return
 * the sum. For instance, if you got this array as a parameter:
 * [
 *   [1, 2, 3],
 *   [2, 4, 6],
 *   [5, 10, 15]
 * ];
 *
 * You would return 48. To do this, you will use two nested `reduce`
 * calls with two anonymous functions.
 *
 * Read the tests to verify you have the correct behavior.
 */
