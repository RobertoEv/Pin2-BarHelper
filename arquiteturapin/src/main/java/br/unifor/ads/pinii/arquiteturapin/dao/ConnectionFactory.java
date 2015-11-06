package br.unifor.ads.pinii.arquiteturapin.dao;

/**
 * 
 */


import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author adrianopatrick@gmail.com
 * @since 28 de out de 2015
 */
@SuppressWarnings("unused")
public class ConnectionFactory {

	private static Logger logger = Logger.getLogger(ConnectionFactory.class);
	private static final ConnectionFactory connectionFactory = new ConnectionFactory();
	private static HikariDataSource dataSource;

	private ConnectionFactory() {
		HikariConfig config = new HikariConfig();
		//NÃ£o padrao
		config.setJdbcUrl("jdbc:mysql://localhost/barhelper");
		// OR padrao
//		config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
//		config.addDataSourceProperty("databaseName", "arquitetura");
		
		config.setUsername("root");
		config.setPassword("c9p5au8naa");
		config.setMinimumIdle(2);
		config.setMaximumPoolSize(20); //default 10
		config.setConnectionTestQuery("SELECT 1 ");

		dataSource = new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
}
