package com.kasiniu;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceFilter;
import com.kasiniu.module.MyBatisModule;
import com.kasiniu.module.RestModule;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.mybatis.guice.datasource.c3p0.C3p0DataSourceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Properties;

/**
 * Created by dengzhl9 on 1/29/2016.
 */
public class ServiceMain {
    @Inject
    private static final Logger logger = LoggerFactory.getLogger(ServiceMain.class);

    public static void main(String[] args) throws Exception {

        // Think of the RestModule as an in-code replacement for the web.xml deployment descriptor.
        Injector injector = Guice.createInjector(
                Stage.PRODUCTION,
                new MyBatisModule(),
                new RestModule()
        );

        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        context.addFilter(
                GuiceFilter.class,
                "/*",
                EnumSet.<javax.servlet.DispatcherType>of(
                        javax.servlet.DispatcherType.REQUEST,
                        javax.servlet.DispatcherType.ASYNC
                )
        );
        context.addServlet(DefaultServlet.class, "/*");

        server.start();

        logger.info("Server started......");

        server.join();
    }
}
