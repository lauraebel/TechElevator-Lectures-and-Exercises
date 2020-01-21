# Collections - Part 1

The purpose of this exercise is to gain experience using Lists to better understand how Lists can be used to solve problems.

## Learning Objectives

After completing this exercise, students will understand:

* How to declare and create instances of List objects.
* How to iterate (loop through) Lists.
* How to add items to Lists.
* How to remove items from Lists.
* How to access items in a list by a specified index.
* How to navigate the List API documentation.
* The differences between arrays and Lists.

## Evaluation Criteria & Functional Requirements

* Lists should be used rather than arrays.
* The project must not have any build errors.
* Unit tests pass as expected.
* Appropriate variable names and data types are being used.
* Code is presented in a clean, organized format.

## Getting Started

* Import the collections-part1-exercises project into Eclipse.
* Right-click on the project, and select the **Run As -> JUnit Test** menu option.
* Click on the **JUnit** tab to see the results of your tests and which passed / failed.
* Provide enough code to get a test passing.
* Repeat until all tests are passing.

## Tips and Tricks

* **Note, If you find yourself stuck on a problem for longer than fifteen minutes, move onto the next, and try again later.**
* As a developer, you will find documentation for classes and libraries to be invaluable resources when completing your work. Get into the habit of reading and understanding documentation now to level up more quickly on your journey as a developer. For instance, the [List interface][java-list-api-docs] (which you will be using for this exercise) is well documented.
* Before each method, there is a description of the problem that needs to be solved, as well as examples with expected output. Use these examples to get an idea of the values you need to write your code around. For example, in the comments above the `array2List` method, there is a section that includes the method name, as well as the expected value that will be returned for each method call. The following example signifies that when the method is called with `{"Apple", "Orange", "Banana"}`, it will return a `List<String>` that contains three elements ("Apple", "Orange", and "Banana").:
    ```
    array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
    ```
* When you are trying to solve these sorts of problems, it is often helpful to keep track of the state of variables on a piece of paper as you are working through your code.
* The output of the test run can provide helpful clues as to why the tests are failing. Try reading the output of a failing test for more information that could be valuable when troubleshooting.
* You can also run the tests in debug mode when executing the tests. This will allow you to set a "breakpoint", which will then halt the code at certain points in the editor. You can then look at the values of variables while the test is executing, and can also see what code is currently being executed. Don't hesitate to use the debugging capabilities in Visual Studio to help resolve issues.

---

[java-list-api-docs]: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
