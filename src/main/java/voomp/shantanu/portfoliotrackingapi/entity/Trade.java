package voomp.shantanu.portfoliotrackingapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "trades")
public class Trade {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "action")
    private String action;

    @Column(name = "price")
    private Double price;

    @Column(name = "shares")
    private int shares;

    public Trade() {
    }

    public Trade(String ticker, String action, Double price, int shares) {
        this.ticker = ticker;
        this.action = action;
        this.price = price;
        this.shares = shares;
    }
}
