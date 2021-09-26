package voomp.shantanu.portfoliotrackingapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voomp.shantanu.portfoliotrackingapi.dao.SecurityRepository;
import voomp.shantanu.portfoliotrackingapi.dao.TradeRepository;
import voomp.shantanu.portfoliotrackingapi.entity.Holding;
import voomp.shantanu.portfoliotrackingapi.entity.Security;
import voomp.shantanu.portfoliotrackingapi.entity.Trade;

import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService {

    // == Private Fields ==

    private final SecurityRepository repository;
    private final TradeRepository tradeRepository;

    // == Constructor ==

    @Autowired
    public SecurityServiceImpl(SecurityRepository repository, TradeRepository tradeRepository) {
        this.repository = repository;
        this.tradeRepository = tradeRepository;
    }

    // == Public Methods ==

    @Override
    public List<Security> getPortfolio() {
        return repository.findAll();
    }

    @Override
    public String add(Trade trade) {
        Security security = new Security();
        security.setTicker(trade.getTicker());
        security.setShares(trade.getShares());
        security.setAvg_buy_price(trade.getPrice());
        repository.save(security);
        tradeRepository.save(trade);
        return "Added portfolio Successfully";
    }

    @Override
    public String update(Trade trade) {

        Security security = repository.getByTicker(trade.getTicker());
        if(security == null){
            return "No Security Found by Name : " + trade.getTicker() ;
        }
        if (trade.getAction().equals("Buy")){
            security.updateBuy(trade.getPrice(), trade.getShares());
        }else if (repository.getShareCount(trade.getTicker()) > 0){
            security.updateSell(trade.getShares());
        }
        else {
            return "Not Enough Shares of Security : " + trade.getTicker();
        }
        repository.save(security);
        tradeRepository.save(trade);
        return "Updated trades for : " + trade.getTicker();
    }

    @Override
    public String delete(String ticker) {
        if (repository.getByTicker(ticker) == null){
            return "No Security Found";
        }
        else {
            repository.deleteByTicker(ticker);
            tradeRepository.deleteByTicker(ticker);
            return "Deleted All Trades of : " + ticker;
        }
    }

    @Override
    public Double getReturn() {
        return repository.getReturn();
    }

    @Override
    public List<Holding> getHolding() {
        return repository.getHolding();
    }
}
