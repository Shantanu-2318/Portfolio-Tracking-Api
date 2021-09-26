# Portfolio-Tracking-Api

This api is maid to keep track of all trades and securities and maintain a portfolio

Entities : 
-Security
-Trade


End points :

-portfolio-tracker-api/addTrade     : Add a new security and its first trade

-portfolio-tracker-api/updateTrade  : update/place a trade on a specified security

-portfolio-tracker-api/deleteTrade  : delete a security from portfolio and all trades relating to it

-portfolio-tracker-api/getPortfolio : retrieve portfolio

-portfolio-tracker-api/getHolding   : retrieve number of shares and averaage buy price corresponding to each security

-portfolio-tracker-api/getReturn    : get cumulative return

