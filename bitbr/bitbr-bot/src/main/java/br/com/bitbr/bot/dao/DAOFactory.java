package br.com.bitbr.bot.dao;

import br.com.bitbr.bot.model.chart.dao.ChartDAO;

/**
 * Classe abstrata dao.
 *
 */
public class DAOFactory {
	
	
	/**
	 * Retorna o DAO ChartDAO
	 * @return retorna ChartDAO
	 */
	public static ChartDAO getChartDAO(){
		return new ChartDAO();
	}
	



}
