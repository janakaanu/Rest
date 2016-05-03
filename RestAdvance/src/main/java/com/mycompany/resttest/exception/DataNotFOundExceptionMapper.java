/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resttest.exception;

import com.mycompany.resttest.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Janaka Anuruddha
 */
@Provider
public class DataNotFOundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    
    @Override
    public Response toResponse(DataNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 404, "http://www.google.com");
        return Response.status(Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
}
