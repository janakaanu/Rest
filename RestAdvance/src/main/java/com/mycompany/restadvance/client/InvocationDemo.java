/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restadvance.client;

import com.mycompany.resttest.model.Message;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Janaka Anuruddha
 */
public class InvocationDemo {

    public static void main(String[] args) {
        InvocationDemo invocationDemo = new InvocationDemo();

        Invocation invocation1 = invocationDemo.prepareRequestByYear(2015);
        Response response1 = invocation1.invoke();
        System.out.println(response1.getStatus());

        Invocation invocation2 = invocationDemo.getMessage(1);
        Response response2 = invocation2.invoke();
        System.out.println(response2.getStatus());
        System.out.println(response2.readEntity(Message.class).getMessage());
    }

    public Invocation prepareRequestByYear(int year) {
        Client client = ClientBuilder.newClient();
        return client.target("http://localhost:8084/RestAdvance/webapi/")
                .path("messages")
                .queryParam("year", year)
                .request(MediaType.APPLICATION_JSON)
                .buildGet();

    }

    public Invocation getMessage(int Id) {
        Client client = ClientBuilder.newClient();
        return client.target("http://localhost:8084/RestAdvance/webapi/")
                .path("messages" + "/" + Id)
                .request(MediaType.APPLICATION_JSON)
                .buildGet();

    }

}
