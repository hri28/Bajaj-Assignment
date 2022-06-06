describe('launch my app', ()=>{
    it('app testing', ()=>{
        cy.visit('https://www.freshworks.com/') /* cy is an object */
        cy.contains('Customers');
        cy.contains('Customers').click();
        cy.url().should('include', '/customers')

    })

});