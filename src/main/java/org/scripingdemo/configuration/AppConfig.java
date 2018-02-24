//package org.scripingdemo.configuration;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.*;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
////@Configuration
////@PropertySource("classpath:db.properties")
////@EnableTransactionManagement
////@ComponentScans(value = {
////    @ComponentScan("com.boraji.tutorial.spring.dao"),
////    @ComponentScan("com.boraji.tutorial.spring.service")
////})
//
//@Configuration
//@PropertySource("classpath:application.properties")
//@EnableTransactionManagement
//@ComponentScans(value = {
//    @ComponentScan("org.scripingdemo")
//})
//public class AppConfig {
//  @Autowired
//  private Environment env;
//
//  @Bean
//  public DataSource getDataSource() {
//    BasicDataSource dataSource = new BasicDataSource();
//    dataSource.setDriverClassName(env.getProperty("db.driver"));
//    dataSource.setUrl(env.getProperty("db.url"));
//    dataSource.setUsername(env.getProperty("db.username"));
//    dataSource.setPassword(env.getProperty("db.password"));
//    return dataSource;
//  }
//
////  @Bean
////  public LocalSessionFactoryBean getSessionFactory() {
////    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
////    factoryBean.setDataSource(getDataSource());
////
////    factoryBean.setHibernateProperties(hibernateProperties());
////    factoryBean.setAnnotatedClasses(Customer.class);
//////    factoryBean.setPackagesToScan(new String[] { "com.websystique.springmvc.model" });
////    return factoryBean;
////  }
//
//  @Bean
//  public LocalSessionFactoryBean sessionFactory() {
//    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//    sessionFactory.setDataSource(getDataSource());
//    sessionFactory.setPackagesToScan(new String[] { "org.scripingdemo" });
//    sessionFactory.setHibernateProperties(hibernateProperties());
//    return sessionFactory;
//  }
//
//  private Properties hibernateProperties() {
//    Properties properties = new Properties();
//    properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
//    properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
//    properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
//    return properties;
//  }
//
//  @Bean
//  public HibernateTransactionManager getTransactionManager() {
//    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//    transactionManager.setSessionFactory(sessionFactory().getObject());
//    return transactionManager;
//  }
//
////  @Bean
////  @Autowired
////  public HibernateTransactionManager transactionManager(SessionFactory s) {
////    HibernateTransactionManager txManager = new HibernateTransactionManager();
////    txManager.setSessionFactory(s);
////    return txManager;
////  }
//}
