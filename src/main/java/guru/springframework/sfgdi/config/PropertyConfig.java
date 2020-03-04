package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.examplebeans.FakeDataSource;
import guru.springframework.sfgdi.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * Created by morgan on 04.03.2020
 */
@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${guru.user}")
    private String user;
    @Value("${guru.password}")
    private String password;
    @Value("${guru.dburl}")
    private String url;

    @Value("${guru.jms.user}")
    private String jmsuser;
    @Value("${guru.jms.password}")
    private String jmspassword;
    @Value("${guru.jms.url}")
    private String jmsurl;

    @Bean
    public FakeDataSource fakeDataSource() {
        var dataSource = new FakeDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(env.getProperty("USERNAME"));
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        return new FakeJmsBroker(
                jmsuser,
                jmspassword,
                jmsurl
        );
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
