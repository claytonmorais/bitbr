package br.com.bitbr.test;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import br.com.bitbr.database.JDBCConnection;


public class ConnectTest {

	@Test
	public void testConnection(){
		try {
			Connection connection = JDBCConnection.getConnection();
			Assert.assertTrue( connection != null);
		} catch (Exception e) {
			Assert.fail("Erro ao conectar no IDMS:"+ e.getMessage() );
		}
	}


}
