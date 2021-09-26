package voomp.shantanu.portfoliotrackingapi.service;

import voomp.shantanu.portfoliotrackingapi.entity.Holding;
import voomp.shantanu.portfoliotrackingapi.entity.Security;
import voomp.shantanu.portfoliotrackingapi.entity.Trade;

import java.util.List;

public interface SecurityService {

    List<Security> getPortfolio();

    String add(Trade trade);

    String update(Trade trade);

    String delete(String ticker);

    Double getReturn();

    List<Holding> getHolding();

}
