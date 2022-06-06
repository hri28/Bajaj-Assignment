/*to get an element cy.get is used */
/* to give an input .type is used */
/* to click on something .click() is used */
 describe('amazon shopping', ()=>{
     it('login test',()=>{
         cy.visit('https://www.amazon.in');
         cy.get('#nav-signin-tooltip > a > span').click();
         //user authentication - add email and password before running this test!
         cy.get('input[name="email"]').type('hrishita28@icloud.com');
         cy.get('#continue').click();
         cy.get('input[name="password"]').type('Hrish_1297');
         cy.get('#signInSubmit').click();
        })

        it('search product',()=>{
            cy.get('#searchDropdownBox').select('Electronics',{force: true});
            cy.get('input[name="field-keywords"]').type("iphone 12");
            cy.get('#nav-search-submit-button').click();
        })

        it('add to cart',()=>{
            cy.get('#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(11) > div > div > div > div > div > div.sg-col.sg-col-4-of-12.sg-col-8-of-16.sg-col-12-of-20.s-list-col-right > div > div > div.a-section.a-spacing-none.s-padding-right-small.s-title-instructions-style > h2 > a')
            .invoke('removeAttr','target') //remove the target attribute so the page loads on the same tab
            .click();
            cy.get('input[name="submit.add-to-cart"]').click();
            cy.get('#attach-sidesheet-view-cart-button > span > input').click();
        })
 })

 const resizeObserverLoopErrRe = /^[^(ResizeObserver loop limit exceeded)]/
Cypress.on('uncaught:exception', (err) => {
    /* returning false here prevents Cypress from failing the test */
    if (resizeObserverLoopErrRe.test(err.message)) {
        return false
    }
})