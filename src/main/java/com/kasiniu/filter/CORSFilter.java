package com.kasiniu.filter;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * Created by dengzhl9 on 1/29/2016.
 */
public class CORSFilter implements ContainerResponseFilter {
    @Override
    public ContainerResponse filter(
            ContainerRequest request,
            ContainerResponse response
    ) {
        response.getHttpHeaders().add(
                "Access-Control-Allow-Origin",
                "*"
        );
        response.getHttpHeaders().add(
                "Access-Control-Allow-Headers",
                "origin, content-type, accept, authorization"
        );
        response.getHttpHeaders().add(
                "Access-Control-Allow-Credentials",
                "true"
        );
        response.getHttpHeaders().add(
                "Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS, HEAD"
        );
        response.getHttpHeaders().add(
                "Access-Control-Expose-Headers",
                "Link,X-Pagination-Page-Next,X-Pagination-Page-Prev"
        );

        return response;
    }
}
