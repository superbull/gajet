package com.kasiniu.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.datasource.c3p0.C3p0DataSourceProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by dengzhl9 on 1/29/2016.
 */
public class MyBatisModule extends org.mybatis.guice.MyBatisModule {

    @Override
    protected void initialize() {
        environmentId("development");
        bindDataSourceProviderType(C3p0DataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        Properties props = new Properties();
        try(InputStream resourceStream = getClass().getClassLoader().getResourceAsStream("properties/database.properties")) {
            props.load(resourceStream);
        } catch (IOException e) {

        }

        Names.bindProperties(binder(), props);
    }
}
