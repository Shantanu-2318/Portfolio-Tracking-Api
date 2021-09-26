package voomp.shantanu.portfoliotrackingapi.entity;


public interface Holding {
    String ticker = null;
    Double avg_buy_price = null;
    Integer shares = null;
    String getTicker();
    Double getAvg_buy_price();
    Integer getShares();
}
