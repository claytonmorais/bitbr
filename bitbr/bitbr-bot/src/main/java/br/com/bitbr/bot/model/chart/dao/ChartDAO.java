package br.com.bitbr.bot.model.chart.dao;

import com.cf.data.model.poloniex.PoloniexChartData;

import br.com.bitbr.dao.AbstractDAO;

public class ChartDAO extends AbstractDAO {

	/**
	 * Salva as informa��es para historico
	 * 
	 * @param btcChartData
	 */
	public void save(PoloniexChartData btcChartData) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Obt�m o ultimo elemento salvo
	 * 
	 * @return objeto PoloniexChartData;
	 */
	public PoloniexChartData getLastChartData(){
		return null;
	}
	
	

}
