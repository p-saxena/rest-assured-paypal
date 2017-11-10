package com.paypalexamples.payment.pojo;

import java.util.List;

/**
 * Created by watchmaster on 9/22/17.
 */
public class PaypalPostObj {

    /**
     * following 5 items are different objects within request body
     * Each of the 5 items is listed as a member variable of POJO class
     * note_to_payer and intent are String variables
     * transaction is an array of objects and require a class of its own
     * payer, redirect_urls are objects and defined in class of their own
     * transaction,payer,redirect_urls have children of their own which are added as member varibles in their respective classes
     * this class contains final list of objects sent in request body
     */
    private List<Transactions> transactions;
    private String note_to_payer;
    private Payer payer;
    private Redirect_urls redirect_urls;
    private String intent;

    /**
     * private variables require getters and setters to access them
     */
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public String getNote_to_payer() {
        return note_to_payer;
    }

    public void setNote_to_payer(String note_to_payer) {
        this.note_to_payer = note_to_payer;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public Redirect_urls getRedirect_urls() {
        return redirect_urls;
    }

    public void setRedirect_urls(Redirect_urls redirect_urls) {
        this.redirect_urls = redirect_urls;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }



}
