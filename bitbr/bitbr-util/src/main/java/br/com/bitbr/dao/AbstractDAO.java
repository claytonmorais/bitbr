package br.com.bitbr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.bitbr.database.JDBCConnection;

/**
 * Class abstrata
 *
 */
public abstract class AbstractDAO {
	

	
	/**
	 * Obtém a conexão 
	 * @return Objeto connection
	 * @throws SQLException
	 */
	protected Connection getConnection() throws SQLException{
		return JDBCConnection.getConnection();
	}
		

	/**
	 * Fecha o objeto statement
	 * @param statement objeto para ser encerrado
	 * @throws SQLException
	 */
	protected void closeStatment(Statement statement) throws SQLException{
		if (statement != null){
			statement.close();
		}
	}
	
	/**
	 * Fecha o objeto resultSet
	 * @param resultSet objeto para ser encerrado
	 * @throws SQLException
	 */
	protected void closeResultSet(ResultSet resultSet) throws SQLException{
		if (resultSet != null){
			resultSet.close();
		}
	}
	
	/**
	 * Fecha o objeto connection
	 * @param connection objeto para ser encerrado
	 * @throws SQLException
	 */
	protected void closeConnection(Connection connection) throws SQLException{
		if (connection != null){
			connection.close();
		}
	}	
	

}
