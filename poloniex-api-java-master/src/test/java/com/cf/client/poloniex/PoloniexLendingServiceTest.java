package com.cf.client.poloniex;

import com.cf.data.model.poloniex.PoloniexChartData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author cheolhee
 */
public class PoloniexLendingServiceTest
{
    static final String apiKey = "PQS9A7ZQ-JWIM3BP9-T7TY3RRN-G8PH9P4O";
    static final String apiSecret = "f9c65a4be932e9535b4f32684d885e5df5be92f3ad926d6e583cb312257c47aa132fde40ba398516707989d4c2a5e7d2e911313e5666679302876e9d884ff954";

    ObjectMapper mapper = new ObjectMapper();
    String res = "";
    BigDecimal sum = BigDecimal.ZERO;

    PoloniexLendingService service = new PoloniexLendingService(apiKey, apiSecret);

    @Test
    public void returnActiveLoans() throws Exception
    {
    	
    	System.out.println(service.returnActiveLoans());
    }

    @Test
    public void returnLendingHistory() throws Exception
    {
    	System.out.println(service.returnLendingHistory(40, 50));
    }

    @Test
    public void createLoanOffer() throws Exception
    {
    	System.out.println(service.returnOpenLoanOffers("BTC"));
    }

    @Test
    public void returnAllMarkets() throws Exception{
    	PoloniexExchangeService service = new PoloniexExchangeService(apiKey, apiSecret);
    	List<String> marketsList = service.returnAllMarkets();
    	System.out.println(marketsList);
    }
    
    
    @Test
    public void returnChartData() throws Exception{
    	PoloniexExchangeService service = new PoloniexExchangeService(apiKey, apiSecret);
    	List<PoloniexChartData> btcDailyChartDataStartingFromYesterday = 
    			  service.returnChartData("USDT_BTC",86400L,ZonedDateTime.now(ZoneOffset.UTC).minusDays(1).toEpochSecond());
    	System.out.println(btcDailyChartDataStartingFromYesterday);
    }
}