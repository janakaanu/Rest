/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resttest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Janaka Anuruddha
 */
@Path("demo")
@Consumes(MediaType.TEXT_PLAIN)//These annotation can use in class level or method level
@Produces(MediaType.TEXT_PLAIN)
public class DemoResource {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotation(@HeaderParam("userName") String userName, @MatrixParam("param") String param1) {
        return "Test" + userName;
    }
    
    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders) {
        return "Test" + uriInfo.getPath();
    }

}
