package voomp.shantanu.portfoliotrackingapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import voomp.shantanu.portfoliotrackingapi.entity.Trade;

import javax.transaction.Transactional;

public interface TradeRepository extends JpaRepository<Trade, Integer> {

    @Transactional
    void deleteByTicker(String ticker);

}
