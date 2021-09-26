package voomp.shantanu.portfoliotrackingapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import voomp.shantanu.portfoliotrackingapi.entity.Holding;
import voomp.shantanu.portfoliotrackingapi.entity.Security;
import voomp.shantanu.portfoliotrackingapi.entity.Trade;
import voomp.shantanu.portfoliotrackingapi.service.SecurityService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/portfolio-tracker-api")
public class SecurityRest {

    // == Private Fields ==
    private final SecurityService service;

    // == Constructor ==
    public SecurityRest (SecurityService service) {
        this.service = service;
    }

    @GetMapping("/getPortfolio")
    public List<Security> getPortfolio(){
        log.info("Getting Portfolio");
        return service.getPortfolio();
    }

    @GetMapping("/getHolding")
    public List<Holding> getHolding(){
        log.info("Getting Holdings");
        return service.getHolding();
    }

    @GetMapping("/getReturn")
    public Double getReturn(){
        log.info("Getting Returns");
        return service.getReturn();
    }

    @PostMapping("/addTrade")
    @ResponseBody
    public String add (@RequestBody Trade trade) {
        log.info("Adding A Trade");
        return service.add(trade);
    }

    @PutMapping("/updateTrade")
    @ResponseBody
    public String update (@RequestBody Trade trade) {
        log.info("Updating A Trade");
        return service.update(trade);
    }

    @DeleteMapping("/deleteTrade/{ticker}")
    @ResponseBody
    public String delete(@PathVariable String ticker) {
        log.info("In Delete Path");
        return service.delete(ticker);
    }

}
