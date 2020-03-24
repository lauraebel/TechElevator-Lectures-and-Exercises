describe('My first test', () => {

  before(() => {
    cy.visit('/');
  })

  it('should have a heading with the text My Shopping List', () => {
    cy.get('h1').contains('My Shopping List');
  })

  it('should have no list items until the load list button is clicked',() => {
    cy.get('li').should('have.length',0);
  })

  it('load list button should be visible',() => {
    cy.get('.loadingButton').should('be.visible')
  })

  it('clicking the load list button should display 9 list items',() => {
    cy.get('.loadingButton').click();
    cy.get('li').should('have.length',9);
  })

  it('should find 4 items that have a class of completed',() => {
    cy.get('.completed').should('have.length',4);
  })

});