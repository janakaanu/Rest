/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restadvance.client;

import com.mycompany.resttest.model.Message;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Janaka Anuruddha
 */
public class GenericDemo {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
       List<Message> messageList = client.target("http://localhost:8084/RestAdvance/webapi/")
                .path("messages")
                .queryParam("year", 2015)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>() {});
        System.out.println(messageList.get(0).getMessage());
        
        //Using Invocation
        GenericDemo genericDemo = new GenericDemo();
        Invocation invocation = genericDemo.prepareRequestByYear(2015);
        Response response = invocation.invoke();
        List<Message> messageList2 = response.readEntity(new GenericType<List<Message>>() {});
        System.out.println(messageList2.get(0).getMessage());
    }
    
    public Invocation prepareRequestByYear(int year) {
        Client client = ClientBuilder.newClient();
        return client.target("http://localhost:8084/RestAdvance/webapi/")
                .path("messages")
                .queryParam("year", year)
                .request(MediaType.APPLICATION_JSON)
                .buildGet();

    }

}
