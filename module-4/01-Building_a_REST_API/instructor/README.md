# Creating APIs Exercise

In this exercise you are going to take the shopping list exercise and build your own API. In this directory you will find the folder `shopping-list` that contains the starting code for this exercise.  After you create the API you will need to update the methods in this file for each web method.

## Building your own API

In this exercise you are going to be responsible for building an API that can retrieve a list of groceries.

Everything you need to build your API is in this project. There is a data access layer that uses an in memory representation of a shopping list item. This is very similar to what you did lecture today. What you will need to do is build out the controller and that controller can use the data access layer to perform CRUD operations on the list of groceries.

### Requirements

* The endpoint for your API should be /api/groceries
* You should have at least 10 items in your list of groceries when the application loads.
* When you click on an item it should update the status of that item to completed
* When you double click on an item that is completed it should reset it to incomplete
* When you click the X icon on a row it should delete the item
* When you click the Add Item button, fill in the form, and press enter the item should be saved to your list
    * Pressing Enter when the Item Input has focus will cause it to save the item
    * Pressing ESC when the Item Input has focus will cancel the add

## Updating the API end code

You will need to build a REST controller for the shopping lists with the following endpoints:

1. `/api/groceries`  
    * Description: Retrieves a list of the Grocery Item objects

2. `/api/groceries`  
    * Description: Adds a grocery item to the list  

3. `/api/groceries/:id`  
    * Description: Updates an existing item using the id in the path

4. `/api/groceries/:id`  
    * Description: Deletes an item from the list


## Tests

No unit tests have been provided for this exercise, and therefore will require manual testing to make sure all functionality works as expected.  