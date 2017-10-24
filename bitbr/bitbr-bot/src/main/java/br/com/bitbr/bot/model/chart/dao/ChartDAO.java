package br.com.bitbr.bot.model.chart.dao;

import com.cf.data.model.poloniex.PoloniexChartData;

import br.com.bitbr.dao.AbstractDAO;

public class ChartDAO extends AbstractDAO {

	/**
	 * Salva as informações para historico
	 * 
	 * @param btcChartData
	 */
	public void save(PoloniexChartData btcChartData) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Obtém o ultimo elemento salvo
	 * 
	 * @return objeto PoloniexChartData;
	 */
	public PoloniexChartData getLastChartData(){
		return null;
	}
	
	

}
