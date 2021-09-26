package voomp.shantanu.portfoliotrackingapi.entity;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "portfolio")

public class Security {

    // == Private fields ==

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "avg_buy_price")
    private double avg_buy_price;

    @Column(name = "current_price")
    private int current_price = 100;

    @Column(name = "shares")
    private int shares;


    // == Constructors ==

    public Security() {

    }

    public Security(int id, String ticker, double avg_buy_price, int shares) {
        this.id = id;
        this.ticker = ticker;
        this.avg_buy_price = avg_buy_price;
        this.shares = shares;
    }

    public void updateBuy(Double price, int buyShares){
        avg_buy_price = ((avg_buy_price * shares) + (price * buyShares))/(shares + buyShares);
        shares += buyShares;
    }
    
    public void updateSell(int sellShares){
        shares -= sellShares;
    }

}
