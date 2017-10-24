package br.com.bitbr.bot.task;

import java.util.TimerTask;

import br.com.bitbr.bot.model.trade.bean.TradeBean;
import br.com.bitbr.bot.model.vo.Configuration;
import br.com.bitbr.util.ConfigUtil;

public class TradeTask extends TimerTask {
    public void run() {
    	ConfigUtil instanciaConfig = ConfigUtil.getConfig(ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties"));
    	ConfigUtil config = ConfigUtil.getConfig(instanciaConfig.getConfigValue("pathConfig"));
    	TradeBean.getInstance().executeTrading(getConfiguration(config));
    }

	/**
	 * Carrega o objeto configuration
	 * @param config config do properties
	 * @return Objeto configuration
	 */
	private Configuration getConfiguration(ConfigUtil config) {	
			return new Configuration(config.getConfigValue("txMimSale"),config.getConfigValue("txMaxSale"),config.getConfigValue("txMimPurchase"),config.getConfigValue("txMaxPurchase"));
	}
}