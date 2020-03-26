describe('Shopping Cart Tests', () => {

  before(() => {
    cy.visit('/');
  });

  describe('check default values', () => {
    
    it('check that all of the inputs are empty by default', () => {
      const fields = [
        'shippingAddress', 'shippingAddress2','shippingCity', 'shippingState', 'shippingZip',
        'delivertoFrontDoor', 'delivertoSideDoor', 'delivertoBackDoor',
        'billingAddress', 'billingAddress2', 'billingCity', 'billingState', 'billingZip'
      ];
  
      fields.forEach(field => {
        if( field.includes('State') ) {
          cy.get('#' + field).should('have.value','');
        } else {
          cy.get('#' + field).should('be.empty');
        }
      });
      
    });
  
    it('billing same as shipping checkbox should NOT be checked by default', () => {
        cy.get('#billingSameCheckbox').should('not.be.checked');
    });

  });

  describe('shipping address values',() => {

    it('shipping address entered is displayed in the results pane', () => {
      const address = '7100 Euclid Ave';
      cy.get('#shippingAddress').type(address);
      cy.get('#shippingAddress').should('have.value', address);
      cy.get('.shipping-address').should('have.text', address);
    });

    it('shipping address 2 entered is displayed in the results pane', () => {
      const address2 = '#140';
      cy.get('#shippingAddress2').type(address2);
      cy.get('#shippingAddress2').should('have.value', address2);
      cy.get('.shipping-address2').should('have.text', address2);
    });

    it('shipping city entered is displayed in the results pane', () => {
      const city = 'Cleveland';
      cy.get('#shippingCity').type(city);
      cy.get('#shippingCity').should('have.value', city);
      cy.get('.shipping-city').should('have.text', city);
    });

    it('shipping state selected is displayed in the results pane', () => {
      const state = 'OH';
      cy.get('#shippingState').select('OH')
      cy.get('#shippingState').should('have.value', state);
      cy.get('.shipping-state').should('have.text', state);
    });

    it('shipping zip entered is displayed in the results pane', () => {
      const zip = '44103';
      cy.get('#shippingZip').type(zip);
      cy.get('#shippingZip').should('have.value', zip);
      cy.get('.shipping-zip').should('have.text', zip);
    });

    it('shipping deliverto selected is displayed in the results pane', () => {
      const deliverto = 'Front Door';
      cy.get('#delivertoFrontDoor').check();
      cy.get('#delivertoFrontDoor').should('be.checked');
      cy.get('.shipping-deliverto').should('have.text', deliverto);
    });

  });

  describe('billing address values',() => {

    it('billing address entered is displayed in the results pane', () => {
      const address = '7100 Euclid Ave';
      cy.get('#billingAddress').type(address);
      cy.get('#billingAddress').should('have.value', address);
      cy.get('.billing-address').should('have.text', address);
    });

    it('billing address 2 entered is displayed in the results pane', () => {
      const address2 = '#140';
      cy.get('#billingAddress2').type(address2);
      cy.get('#billingAddress2').should('have.value', address2);
      cy.get('.billing-address2').should('have.text', address2);
    });

    it('billing city entered is displayed in the results pane', () => {
      const city = 'Cleveland';
      cy.get('#billingCity').type(city);
      cy.get('#billingCity').should('have.value', city);
      cy.get('.billing-city').should('have.text', city);
    });

    it('billing state selected is displayed in the results pane', () => {
      const state = 'OH';
      cy.get('#billingState').select('OH')
      cy.get('#billingState').should('have.value', state);
      cy.get('.billing-state').should('have.text', state);
    });

    it('billing zip entered is displayed in the results pane', () => {
      const zip = '44103';
      cy.get('#billingZip').type(zip);
      cy.get('#billingZip').should('have.value', zip);
      cy.get('.billing-zip').should('have.text', zip);
    });

  });

  describe('same as shipping test', () => {

    it('billing address should be the same as shipping when checkbox is checked', () => {
      // we need to clear out the inputs, we could do this manually but a refresh will fix this.
      cy.visit('/');
      const address = '7100 Euclid Ave';
      const address2 = '#140';
      const city = 'Cleveland';
      const state = 'OH';
      const zip = '44103';

      // setup and fill in shipping address 
      cy.get('#shippingAddress').type(address);
      cy.get('#shippingAddress2').type(address2);
      cy.get('#shippingCity').type(city);
      cy.get('#shippingState').select(state);
      cy.get('#shippingZip').type(zip);

      // check same as shipping checkbox
      cy.get('#billingSameCheckbox').check();

      // assert billing fields are the same as shipping
      cy.get('.billing-address').should('have.text', address);
      cy.get('.billing-address2').should('have.text', address2);
      cy.get('.billing-city').should('have.text', city);
      cy.get('.billing-state').should('have.text', state);
      cy.get('.billing-zip').should('have.text', zip);
    });

  });

});