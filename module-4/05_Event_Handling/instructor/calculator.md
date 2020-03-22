# Calculator Event Handling Exercise

In this exercise you will be building a simple calculator. This calculator will handle basic operations like addition, subtraction, multiplication, and division. The user interface for this project has already been created so that your focus will be on making it functional.

## Exercise Instructions

To get started with the exercise you will need to open up `/js/calculator.js` and scroll down to the following line of code.

```js
document.addEventListener('LOADED_EVENT_GOES_HERE', () => {
```

The first thing you will need to do is to replace `LOADED_EVENT_GOES_HERE` with the appropriate event that will notify when the DOM content is ready to go. Inside of the anonymous function on that event listener is a series of comments. Follow the comments in order and when completed the basic functions of a calculator should work.

## Running the Exercise Tests

To run the exercise tests you  will need to run `npm install` to install the required dependencies.If you look in the `package.json` you will see 2 scripts for running the tests, test & test-headless.

If you would like to run the tests in a UI mode you can run the command `npm run test`. If you would like the tests to run from the command line you can run the command `npm run test-headless`. When your tests are complete you can hit `ctrl+c` to stop the integrated http server and stop the script.

If you would like to see the tests for this exercise they are located in `cypress/integration/calculator_spec.js`
