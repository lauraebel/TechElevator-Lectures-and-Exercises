// https://docs.cypress.io/api/introduction/api.html

describe('Shopping List Tests', () => {

  beforeEach( () => {
    cy.visit('/');
  });

  it('should contain an unordered list', () => {
    cy.get('ul').should('exist');
  });

  it('should contain an unordered list with at least 1 item', () => {
    cy.get('li').should('have.length.above',0);
  });

  it('should contain no list items that are completed when the application loads', () => {
    cy.get('li.completed').should('not.exist');
  });

  it('should accept a click handler on the list item and change the status',() => {
    // get the list item
    const firstItem = cy.get('li').first();

    // the list item should not have the class completed to start
    firstItem.should('not.have.class','completed');

    // click the list item (not the checkbox)
    firstItem.click();

    // the result should be that the class is either added or removed from that list item
    firstItem.should('have.class','completed');
  });

})
