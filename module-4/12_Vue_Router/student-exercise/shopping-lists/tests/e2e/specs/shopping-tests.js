// https://docs.cypress.io/api/introduction/api.html

describe('Groceries Online Basic Path Tests', () => {

  it('Visits the home path', () => {
    cy.visit('/')
    cy.contains('h1', 'Online Grocery Shopping')
  })

  it('Visits home page and clicks on the button "SHOP BY DEPARTMENT" and is taken to the products page', () => {
    cy.visit('/')
    cy.get('button').click()
    cy.contains('h1','Shop By Department')
  })

  it('Visits the weekly specials page', () => {
    cy.visit('/on-sale')
    cy.contains('h1', 'Products on Sale')
  })

  it('Visits the shopping cart', () => {
    cy.visit('/cart')
    cy.contains('h1', 'Shopping Cart')
  })

  it('Visits the checkout', () => {
    cy.visit('/checkout')
    cy.contains('h1', 'Checkout')
  })
  
})

describe('Navigation Tests', () => {

  it('Visits the home path and tests the "Home" navigation link', () => {
    cy.visit('/')
    cy.get('a.home').click()
    cy.contains('h1','Online Grocery Shopping')
  })

  it('Visits the home path and tests the "Shop By Department" navigation link', () => {
    cy.visit('/')
    cy.get('a.products').click()
    cy.contains('h1','Shop By Department')
  })

  it('Visits the home path and tests the "On Sale This Week" navigation link', () => {
    cy.visit('/')
    cy.get('a.onsale').click()
    cy.contains('h1','Products on Sale')
  })

  it('Visits the home path and tests the "Shopping Cart" navigation link', () => {
    cy.visit('/')
    cy.get('a.cart').click()
    cy.contains('h1','Shopping Cart')
  })

  it('Visits the home path and tests the "Checkout" navigation link', () => {
    cy.visit('/')
    cy.get('a.checkout').click()
    cy.contains('h1','Checkout')
  })

});


describe('Products Tests', () => {

  it('Visits the products path', () => {
    cy.visit('/products')
    cy.contains('h1', 'Shop By Department')
    cy.get('img').should('have.length', 4)
  });

  it('Visits the products path and clicks through to produce', () => {
    cy.visit('/products')
    cy.get('a.department.produce').click()
    cy.contains('h1','Shop by Department: produce')
  })

  it('Visits the products path and clicks through to dairy', () => {
    cy.visit('/products')
    cy.get('a.department.dairy').click()
    cy.contains('h1','Shop by Department: dairy')
  })

  it('Visits the products path and clicks through to meat and seafood', () => {
    cy.visit('/products')
    cy.get('a.department.meat').click()
    cy.contains('h1','Shop by Department: meat')
  })

  it('Visits the products path and clicks through to bakery', () => {
    cy.visit('/products')
    cy.get('a.department.bakery').click()
    cy.contains('h1','Shop by Department: bakery')
  })

  it('Visits the produce page and clicks on bananas', () => {
    cy.visit('/products/produce')
    cy.get('.item').should('have.length',8)
    cy.get('#00000000040112').click()
    cy.contains('h1','Banana')
  })

  it('Visits the banana product page directly', () => {
    cy.visit('/products/sku/00000000040112')
    cy.contains('h1','Banana')
  })

  it('Visits the eggs product page directly', () => {
    cy.visit('/products/sku/00030034913182')
    cy.contains('h1',"Nature's Basket Large Brown Eggs")
  })

});

describe('Weekly Specials', () => {

  it('Visits the weekly specials page', () => {
    cy.visit('/on-sale')
    cy.contains('h1', 'Products on Sale')
    cy.get('.item').should('have.length',8)
  })

})


