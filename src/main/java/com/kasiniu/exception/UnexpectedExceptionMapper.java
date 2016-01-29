package com.kasiniu.exception;

import com.sun.jersey.api.MessageException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by dengzhl9 on 1/29/2016.
 */
public class UnexpectedExceptionMapper implements ExceptionMapper<MessageException> {

    @Override
    public Response toResponse(final MessageException exception)
    {
        return Response.status(Response.Status.BAD_REQUEST).entity(defaultJSON(exception)).build();
    }

    private Object defaultJSON(final MessageException exception)
    {
        return new ErrorInfo(exception.getMessage());
    }
}
