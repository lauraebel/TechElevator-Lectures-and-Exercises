document.addEventListener('DOMContentLoaded', () => {

    let clicks = 0;

    const inputField = document.getElementById('userinput');
    const inputDiv = document.getElementById('userinputdiv');
    const form = document.querySelector('form');
    const h2 = inputDiv.querySelector('h2');
    const select = inputDiv.querySelector('select');

    /*
     * The focus event occurs when the pointer enters an element
     */
    inputField.addEventListener('focus', (event) => {
        event.target.classList.remove('green-background');
        event.target.classList.add('red-background');
    });

    /*
     * The blue event occurs when the pointer leaves an element
     */
    inputField.addEventListener('blur', (event) => {
        addgreeBackground(event.target);
    });

    inputField.addEventListener('click', (event) => {
        event.stopPropagation();
    });

    /*
     * The keydown event occurs when the user presses a key
     *   It repeats as long as the key is held down
     *
     * WHY USE KEYUP INSTEAD OF KEYUP OR KEYPRESS?
     */
    inputField.addEventListener('keydown', (event) => {
        h2.innerText = inputField.value;
    });

    /*
     * The chnage event occurs when the value of an element changes
     * It only occurs after the change is complete.
     */
    select.addEventListener('change', (event) => {
        h2.innerText = select.value;
    });

    /*
     * The mouseenter event occurs when the mouse crosses the edges 
     * of the elements box into the element
     */
    inputDiv.addEventListener('mouseenter', () => {
        inputDiv.classList.add('thick-border');
    });

    /*
     * The mouseleave event occurs when the mouse crosses the edges 
     * of the elements box out of the element
     */
    inputDiv.addEventListener('mouseleave', () => {
        inputDiv.classList.remove('thick-border');
    });

    /*
     * The click event occurs when the mouse clicks on the element
     *
     * WHY DOES THIS EVENT OCCUR EVEN WHEN THE ELEMENTS IN IT ARE CLICKED?
     * HOW COULD WE STOP IT?
     */
    inputDiv.addEventListener('click', () => {
        inputDiv.classList.remove('red-background');
        inputDiv.classList.remove('green-background');

        clicks++;
        switch (clicks) {
            case 1: 
                inputDiv.classList.add('red-background');
                break;
            case 2:
                inputDiv.classList.add('green-background');
                break;
            default:
                clicks = 0;
                break;
        }
    });

    /*
     * The submit event occurs when a form is submitted.
     * The event should be added to the FORM not the submit
     * buttons click event.
     * 
     * BUT THE FORM STILL SUBMITS, HOW CAN WE STOP IT?
     */
    form.addEventListener('submit', (event) => {
        h2.innerText = "Submitting the form!!!";
        event.preventDefault();
    });

    /*
    * Methods can be called that add event listeners, as long as they are called
    * after the DOM load Event completes
    */
    handleWASD();

});
  
function addgreeBackground(element) {
    element.classList.remove('red-background');
    element.classList.add('green-background');
}

function handleWASD() {
    document.querySelector('body').addEventListener("keydown", (event) => {
        handleWASDKeyPress(container, event);
    });

    document.querySelector('body').addEventListener("keyup", (event) => {
        removeWASDKeyPress();
    });
}

function removeWASDKeyPress() {
    const boxes = container.querySelectorAll('div');
    boxes.forEach((box) => {
        box.classList.remove('red-background');
    });
}

function handleWASDKeyPress(container, event) {
    const w = container.querySelector(".boxW");
    const a = container.querySelector(".boxA");
    const s = container.querySelector(".boxS");
    const d = container.querySelector(".boxD");

    console.log(event.code);
    switch (event.code) {
        case 'KeyW':
            w.classList.add('red-background');
            break;
        case 'KeyA':
             a.classList.add('red-background');
             break;
        case 'KeyS':
            s.classList.add('red-background');
            break;
        case 'KeyD':
            d.classList.add('red-background');
            break;
    }

}