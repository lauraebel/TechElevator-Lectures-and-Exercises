// https://docs.cypress.io/api/introduction/api.html

describe('My First Test', () => {

  before(() => {
    cy.visit('/');
  })

  it('should have 10 or more shopping list items', () => {
    cy.get('li').should('have.length.above', 9);
  })

  it('when an item is clicked the completed class is added',() => {
    cy.get("li:not('.completed')").first().click().should('have.class','completed');
  })
  
  it('completed item should have a checkbox that is checked',() => {
    cy.get('li.completed > input[type="checkbox"]').first().should('be.checked');
  })

})
