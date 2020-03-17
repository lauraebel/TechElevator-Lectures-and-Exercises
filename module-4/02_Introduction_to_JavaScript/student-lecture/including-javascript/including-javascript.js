// Code declared outside of a function is run when the page
// is loaded, even if it is in a script file
console.log("Hello from the Script File");

/*
 Code declared in a function is called when the function is called
*/
function showHello() {
    console.log("Hello from the Script file function")
}