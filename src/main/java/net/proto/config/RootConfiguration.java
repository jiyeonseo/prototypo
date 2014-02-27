package net.proto.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: jiyeonseo
 * Date: 14. 1. 28.
 * Time: 오후 3:33
 * To change this template use File | Settings | File Templates.
 */
@Configuration

//@EnableTransactionManagement
//@PropertySource(value = "classpath:hibernate/jdbc.properties")
public class RootConfiguration {
//    @Autowired
//    Environment env;
//
//    @Bean(name="dataSource")
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("db.driverclass"));
//        dataSource.setUrl(env.getProperty("db.url"));
//        dataSource.setUsername(env.getProperty("db.username"));
//        dataSource.setPassword(env.getProperty("db.password"));
//        return dataSource;
//    }
//
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(){
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(new String[] { "net.jiyeon" });
//
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.put("hibernate.dialect", env.getProperty("db.dialect"));
//        hibernateProperties.put("hibernate.show_sql", true);
//        sessionFactory.setHibernateProperties(hibernateProperties);
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager hibernateTransactionManager() throws Exception{
//        HibernateTransactionManager manager = new HibernateTransactionManager();
//        manager.setSessionFactory(sessionFactory().getObject());
//        return manager;
//    }
}
