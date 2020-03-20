package com.example.sitchosen.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Description:
 * @Auther: zhaodx
 * @Date: 2020/2/25 19:07
 */
@Configuration
public class SessionFactoryConfiguration{
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${entity_package}")
    private String entityPackage;
    @Value("${mapper_path}")
    private String mapperPath;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sb = new SqlSessionFactoryBean();
        sb.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        sb.setMapperLocations(resolver.getResources(packageSearchPath));
        sb.setDataSource(dataSource);
        sb.setTypeAliasesPackage(entityPackage);
        return sb;
    }
}
