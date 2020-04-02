// https://docs.cypress.io/api/introduction/api.html

describe('Shopping List Tests', () => {

  beforeEach(() => {
    cy.visit('http://localhost:8080')
  })

  it('Page contains a H1 with a value of: Nested Components Exercise', () => {
    cy.contains('h1', 'Nested Components Exercise')
  })

  it('Should contain a input box for searching', () => {
    cy.get('.search').should('exist')
  })

  it('Contains 3 Shopping List Components', () => {
    cy.get('.shopping-list').should('have.length', 3)
  })

  it('3 lists should contain a total of 15 list items',() => {
    cy.get('li').should('have.length',15)
  })

  it('Shopping List titles should be correct',() => {
    cy.get('h2').eq(0).should('contain','Grocery Store')
    cy.get('h2').eq(1).should('contain','Costco')
    cy.get('h2').eq(2).should('contain','Target')
  });

  it('Search for Paper Towels should return 3 items',() => {
    cy.get('#search').type('paper') // Type 'paper' into the 'input'
    cy.get('li').should('have.length',3)
  })

  it('Paper Search Should be case insensitive',() => {
    cy.get('#search').type('PAPER') // Type 'PAPER' into the 'input'
    cy.get('li').should('have.length',3)
  })

  it('Search for l should return 9 items',() => {
    cy.get('#search').type('l')
    cy.get('li').should('have.length',9)
  })

  it('Search for z should return 0 items',() => {
    cy.get('#search').type('z')
    cy.get('li').should('have.length',0)
  })

})
