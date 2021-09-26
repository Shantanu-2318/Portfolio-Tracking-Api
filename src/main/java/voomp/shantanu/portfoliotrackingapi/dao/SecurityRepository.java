package voomp.shantanu.portfoliotrackingapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import voomp.shantanu.portfoliotrackingapi.entity.Holding;
import voomp.shantanu.portfoliotrackingapi.entity.Security;

import javax.transaction.Transactional;
import java.util.List;

public interface SecurityRepository extends JpaRepository <Security, Integer> {

    @Query(value = "select SUM((current_price - avg_buy_price) * shares) as Returns from portfolio", nativeQuery = true)
    Double getReturn();

    @Query(value = "select ticker, avg_buy_price, shares from portfolio", nativeQuery = true)
    List<Holding> getHolding();

    @Transactional
    void deleteByTicker(String ticker);

    Security getByTicker(String ticker);

    @Query(value = "select count(shares) from portfolio where ticker = ?1", nativeQuery = true)
    int getShareCount(String ticker);
}

