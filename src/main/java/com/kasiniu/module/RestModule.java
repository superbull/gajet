package com.kasiniu.module;

import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.ServletModule;
import com.kasiniu.exception.UnexpectedExceptionMapper;
import com.kasiniu.filter.CORSFilter;
import com.kasiniu.resource.UsersResource;
import com.kasiniu.util.GsonProvider;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.eclipse.jetty.servlet.DefaultServlet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dengzhl9 on 1/29/2016.
 */
public class RestModule extends ServletModule {

    @Override
    protected void configureServlets() {
        super.configureServlets();

        bind(GsonProvider.class).in(Singleton.class);
        bind(DefaultServlet.class).in(Singleton.class);
        bind(UsersResource.class);
        bind(CORSFilter.class).in(Singleton.class);
        bind(UnexpectedExceptionMapper.class);

        filter("/*").through(PersistFilter.class);

        Map<String, String> params = new HashMap<String, String>();
        params.put(
                "com.sun.jersey.spi.container.ContainerResponseFilters",
                "com.liuduapp.tools.filters.CORSFilter"
        );

        serve("/*").with(GuiceContainer.class, params);
    }
}
