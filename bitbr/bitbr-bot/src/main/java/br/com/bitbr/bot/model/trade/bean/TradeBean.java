package br.com.bitbr.bot.model.trade.bean;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

import javax.naming.AuthenticationException;

import com.cf.client.poloniex.PoloniexExchangeService;
import com.cf.data.model.poloniex.PoloniexChartData;

import br.com.bitbr.bot.dao.DAOFactory;
import br.com.bitbr.bot.model.vo.Configuration;

public class TradeBean {
	
	private static TradeBean INSTANCE;

	private static final String apiKey = "PQS9A7ZQ-JWIM3BP9-T7TY3RRN-G8PH9P4O";
	private static final String apiSecret = "f9c65a4be932e9535b4f32684d885e5df5be92f3ad926d6e583cb312257c47aa132fde40ba398516707989d4c2a5e7d2e911313e5666679302876e9d884ff954";

	private PoloniexExchangeService service;
	
	/**
	 * Obtém a instancia do objeto (Singleton)
	 * @return Instancia
	 * @throws AuthenticationException 
	 */
	public static TradeBean getInstance() {
		
		if (INSTANCE == null ){
			INSTANCE = new TradeBean();
		}
		
		return INSTANCE;		
	}
	
	/**
	 * Construtor padrão
	 */
	private TradeBean() {
		 this.service = new PoloniexExchangeService(apiKey, apiSecret);
	}
	
	
	/**
	 * Efetua o trading
	 * 
	 * @param configuration configuration
	 * 
	 * 
	 */
	public void executeTrading(Configuration configuration) {
				
    	List<PoloniexChartData> btcChartData = service.returnChartData("USDT_BTC",86400L,ZonedDateTime.now(ZoneOffset.UTC).minusDays(1).toEpochSecond());
    	if (btcChartData != null && !btcChartData.isEmpty()){
    		
    		if ( isSaleMin(configuration,btcChartData.get(0) ) ){    			
    			//service.buy(currencyPair, buyPrice, amount, fillOrKill, immediateOrCancel, postOnly)
    		} if ( isPurchaseMax(configuration, btcChartData.get(0)) ){
    			//service.sell(currencyPair, sellPrice, amount, fillOrKill, immediateOrCancel, postOnly)
    		}
    		
    		DAOFactory.getChartDAO().save(btcChartData.get(0));	
    	} 	
     	

	}

	/**
	 * Verifica se o valor atingiu o percentual minimo para compra
	 * 
	 * REGRA: É o valor deverá atingir o valor minimo calculado através da porcentagem definida na configuração
	 * 
	 * 
	 * @param configuration
	 * @param poloniexChartData
	 * @return
	 */
	private boolean isSaleMin(Configuration configuration, PoloniexChartData poloniexChartData) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Verifica se o valor atingiu o percentual máximo para venda
	 * 
	 * REGRA: É o valor deverá atingir o valor maximo calculado através da porcentagem definida na configuração
	 * 
	 * 
	 * @param configuration
	 * @param poloniexChartData
	 * @return
	 */
	private boolean isPurchaseMax(Configuration configuration, PoloniexChartData poloniexChartData) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
