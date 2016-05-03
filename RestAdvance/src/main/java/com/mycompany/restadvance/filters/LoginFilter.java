/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restadvance.filters;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.internal.util.Base64;

/**
 *
 * @author Janaka Anuruddha
 */
@Provider
public class LoginFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final String AUTHRIZATION_HEADER = "Authorization";
    private static final String AUTHRIZATION_HEADER_PREFIX = "Basic ";
    private static final String SECURED_URI_PREFIX = "secured";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        if (requestContext.getUriInfo().getPath().contains(SECURED_URI_PREFIX)) {
            List<String> authHeader = requestContext.getHeaders().get(AUTHRIZATION_HEADER);

            if (authHeader != null && authHeader.size() > 0) {
                String authToken = authHeader.get(0);
                authToken = authToken.replace(AUTHRIZATION_HEADER_PREFIX, "");
                String decodeString = Base64.decodeAsString(authToken);
                StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
                String userName = tokenizer.nextToken();
                String passWord = tokenizer.nextToken();

                if ("user".equalsIgnoreCase(userName) && "passwod".equalsIgnoreCase(passWord)) {
                    System.out.println("Request " + requestContext.getHeaders());
                    return;
                }
            }

            Response unauthorizedStatus = Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot access the resource")
                    .build();

            requestContext.abortWith(unauthorizedStatus);
        }

    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        System.out.println("Response " + responseContext.getHeaders());
    }
}
