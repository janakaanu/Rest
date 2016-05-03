/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restadvance;

import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Janaka Anuruddha
 */
@Path("test2")
public class MyResource2 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Date test() {
        return Calendar.getInstance().getTime();

    }

    @GET
    @Produces("text/shortdate")
    public Date test2() {
        return Calendar.getInstance().getTime();

    }

}
