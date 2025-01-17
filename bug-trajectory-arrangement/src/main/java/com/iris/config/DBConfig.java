package com.iris.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Component
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.iris"})
public class DBConfig {
    //Here we are connecting to the database through data source method
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		System.out.println("Hello 1");
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		System.out.println("Hello 2");
		return dataSource;
	}
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		System.out.println("Hello 3");
		Properties p=new Properties();
		p.setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		p.setProperty("hibernate.hbm2ddl.auto","update");
		p.setProperty("hibernate.show_sql", "true");
		LocalSessionFactoryBuilder sb=new LocalSessionFactoryBuilder(getDataSource());
		sb.addProperties(p);
		sb.scanPackages("com.iris.models");
		SessionFactory sf=sb.buildSessionFactory();
		System.out.println("Hello 4");
		return sf;
	}
	@Bean(name="HibernateTransaction")
	@Autowired
	
	public HibernateTransactionManager geHibernateTransactionManager(SessionFactory sessionFactory){
		System.out.println("Hello 5");
		HibernateTransactionManager tx=new HibernateTransactionManager(sessionFactory);
		System.out.println("Hello 6");
		return tx;
	}
}
