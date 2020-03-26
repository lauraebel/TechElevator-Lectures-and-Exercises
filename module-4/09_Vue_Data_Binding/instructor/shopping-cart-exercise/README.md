# Shopping Cart Checkout Exercise

In a typical shopping cart you have the option to checkout and then are taken through a series of steps. In this exercise you are going to be working with the step that collects the shipping and billing addresses from the user.

## Install Dependencies

The first thing you will need to do is install any dependencies by running the command `npm install` from the command line.

## Shipping and Billing variables

The first thing you need to do is to setup a couple of variables to hold your form data. Add the following objects and properties.

- shipping
  - address
  - address2
  - city
  - state
  - zip
  - deliverto
- billing
  - address
  - address2
  - city
  - state
  - zip

The fields are all strings so you can initialize them to empty strings.

## Data Binding with Input Elements

Now that you have your shipping and billing variables setup you need to somehow bind them to their corresponding form fields. There is a way to do this in Vue and if you forget please go back through the student book.

Now that you have data binding setup with your input elements you need to be able to display them on the right side of the page. If you look in the markup for the `AddressInfo` component you will see some code that looks like this:

```html
<h3>Shipping Address</h3>
<div class="line-item">
  Address:
  <span class="shipping-address"></span>
</div>
<div class="line-item">
  Address 2:
  <span class="shipping-address2"></span>
</div>
<div class="line-item">
  City:
  <span class="shipping-city"></span>
</div>
<div class="line-item">
  State:
  <span class="shipping-state"></span>
</div>
<div class="line-item">
  Zip:
  <span class="shipping-zip"></span>
</div>
<div class="line-item">
  Deliver to:
  <span class="shipping-deliverto"></span>
</div>
```

You will need to go through and display each of the object properties for both shipping and billing.

## Methods

Now that you have data binding working there is one more thing you need to do. There are 2 methods defined along with some instructions on what you need to do to make them work.

## Tests

To consider your exercise a success we will run automated tests against it. Those tests will check for the following criteria.

- When you fill out a form field it's value is displayed in the right results pane.
- When you fill out all of the shipping form fields and check the checkbox "Billing Same as Shipping"
  - All form field values are copied to billing and displayed in the right results pane.

To check your work you run the tests by running the following command from the command line:

```bash
npm run test:e2e
```

The command above will open up the Cypress tests in a UI and can be time consuming. If you would rather run them all from the command prompt you can use the following command:

```bash
npm run test:e2e-headless
```

## Extra Credit

If everything is working there is one more issue with your application that should get fixed. If you enter whitespace before or after any text in one of your inputs it will cause a problem. You might not notice the problem because if you look in the right results pane everything looks fine. If you open up the Vue Devtools though you will see there is in fact spaces before and after the value. There is a way to fix this and it was mentioned in the student book. You will want to make this correction for every field that accepts user input.
