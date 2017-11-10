package com.paypalexamples.payment.pojo;

/**
 * Created by watchmaster on 9/22/17.
 */
public class Amount {

    /**
     * following 3 items are different objects within transactions object in request body
     * Each of the 3 items is listed as a member variable of POJO class
     * total and currency are String variables
     * Details an array of objects and require a class of its own
     * Details object has children of its own which are added as member varibles in their respective classes
     * this class contains final list of objects sent by Amount object of request body
     */
    private String total;
    private Details details;
    private String currency;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
