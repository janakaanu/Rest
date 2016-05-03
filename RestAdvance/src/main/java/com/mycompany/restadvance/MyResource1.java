/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restadvance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Janaka Anuruddha
 */
@Path("{pathParam}/test")
public class MyResource1 {

    @PathParam("pathParam")
    private String pathParama;
    @QueryParam("query")
    private String queryParam;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(@PathParam("pathParam") String pathParama1,
            @QueryParam("query") String queryParam2) {
        return "PATH = " + pathParama + " Query=" + queryParam;
    }

}
