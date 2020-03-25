# Fetch & Promises Exercise

In this exercise you will take a lot of the lesson you learned in the tutorial and lecture and build your own shopping list application. 

The list of items is not loaded by default. You will need to click on the load list button, fetch the items from a JSON file and then display them on the page. When you are done you should end up with a solution that looks something like this. 

![Shopping List Solution](img/shopping-list-solution.png)

## Setup

The starter code for this project is located in the `shopping-list` folder located in this directory. This project uses npm for its dependencies so before you do anything you will need to `cd shopping-list` and run `npm install`.

### Automated Tests

The only dependency you are pulling in is cypress which is an end to end testing framework. This was mentioned during testing Vue components but we didn't have a chance to cover it. Not to worry though, all you need it for is to verify that your exercise is doing what it should. 

If you run the command `npm run test` from the command line you will see a single integration test for this project `shopping-list-spec.js`. 

![Shopping List Spec](img/cypress-open.png)

If you click on it you should see 3 tests pass and the final 2 fail.

![Shopping List Tests](img/test-runner.png)

## Instructions 

To make this application work you will need to the following:

* When a user clicks the load list button
    * fetch the list of groceries from `assets/data/shopping-list.json`
* iterate over the array of groceries and apply the following data to the `<template>`
    * name: Add the name to the list item
    * completed: If the item is completed add the completed class to the circle icon.
    * append the template to the `<ul>` on your page

## Bug Fix

You might have noticed this already but there is a problem with your application. If everything is working ok you can click on the load list button and the shopping list is loaded. What happens if you click on the button again? How can you fix this? There is no one right answer here so think through your solution and add comments where you can. 

