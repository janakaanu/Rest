/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.resttest.resources.beans;

import javax.ws.rs.QueryParam;

/**
 *
 * @author Janaka Anuruddha
 */
public class MessageFilterBeans {

    private @QueryParam("year")
    int year;
    private @QueryParam("start")
    int start;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
