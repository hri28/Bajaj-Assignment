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
            cy.get("div.s-product-image-container > div > span > a")
            .first()
            .invoke("removeAttr", "target")
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