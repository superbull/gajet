package com.kasiniu.resource;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by dengzhl9 on 1/29/2016.
 */
@Path("users")
public class UsersResource {
    @Inject
    private static final Logger logger = LoggerFactory.getLogger(UsersResource.class);

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response fetchAll() {
        return Response
                .ok()
                .entity("{\"message\": \"Hello world\"}")
                .build();
    }
}
