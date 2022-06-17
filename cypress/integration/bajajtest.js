describe('bajaj website test',()=>{
    it('search test',()=>{
        cy.visit('https://www.google.com');
        cy.get('input[name="q"]').type("Bajaj Finserv Health Limited{enter}");

        cy.get('#rso > div:nth-child(1) > div > div > div > div > div > div > div.yuRUbf > a').click();
    })

    it('book appointment test',()=>{
        cy.get('#searchBarInput').type("Doctor");
        cy.get('#searchBarWrapperContainer > div > div.css-eie7o > div > div.css-7cfvtj.css-1ladu4g > p').click();
        
        cy.get('#__next > div.css-1wea1u8 > div > div:nth-child(5) > div.docProfileContainer > section:nth-child(3) > div.css-w3dfjy > div > div.css-1vjdln7 > div:nth-child(5) > div.css-uvjnz5 > a:nth-child(9)').click();
    })
})

const resizeObserverLoopErrRe = /^[^(ResizeObserver loop limit exceeded)]/
Cypress.on('uncaught:exception', (err) => {
    /* returning false here prevents Cypress from failing the test */
    if (resizeObserverLoopErrRe.test(err.message)) {
        return false
    }
})