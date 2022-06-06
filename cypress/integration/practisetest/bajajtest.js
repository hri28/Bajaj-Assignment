describe('bajaj website test',()=>{
    it('search test',()=>{
        cy.visit('https://www.google.com');
        cy.get('input[name="q"]').type("Bajaj Finserv Health Limited{enter}");

        cy.get('#rso > div:nth-child(1) > div > div > div.NJo7tc.Z26q7c.jGGQ5e > div > a').click();
    })

    it('book appointment test',()=>{
        cy.get('#searchBarInput').type("Doctor");
        cy.get('#searchBarWrapperContainer > div > div.css-eie7o > div > div.css-7cfvtj.css-1ladu4g > p').click();
        
        cy.get('#__next > div.css-h2q09c > div > div:nth-child(5) > div.docProfileContainer > section:nth-child(3) > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-3 > div > div > div.MuiCardContent-root.css-145j55m > div.flex-column > div:nth-child(2) > div:nth-child(3) > div.slotTimeContainer > a:nth-child(5)').click();
    })
})

const resizeObserverLoopErrRe = /^[^(ResizeObserver loop limit exceeded)]/
Cypress.on('uncaught:exception', (err) => {
    /* returning false here prevents Cypress from failing the test */
    if (resizeObserverLoopErrRe.test(err.message)) {
        return false
    }
})