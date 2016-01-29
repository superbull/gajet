package com.kasiniu.resource;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * Created by dengzhl9 on 1/29/2016.
 */
public class UsersResource {
    @Inject
    private static final Logger logger = LoggerFactory.getLogger(UsersResource.class);

    @Context
    UriInfo uriInfo;
}
