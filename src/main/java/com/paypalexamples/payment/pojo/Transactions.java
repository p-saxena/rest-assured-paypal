package com.paypalexamples.payment.pojo;

/**
 * Created by watchmaster on 9/22/17.
 */
public class Transactions {

    /**
     * following 7 items are different objects within transactions object in request body
     * Each of the 7 items is listed as a member variable of POJO class
     * description,soft_descriptor,invoice_number and custom are String variables
     * Amount,Payment_Options and Item_List are an array of objects and require a class of their own
     * Amount,Payment_Options,Item_List have children of their own which are added as member varibles in their respective classes
     * this class contains final list of objects sent by transactions object of request body
     */
    private Amount amount;
    private Payment_Options payment_options;
    private Item_List item_list;
    private String description;
    private String soft_descriptor;
    private String invoice_number;
    private String custom;

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public Payment_Options getPayment_options() {
        return payment_options;
    }

    public void setPayment_options(Payment_Options payment_options) {
        this.payment_options = payment_options;
    }

    public Item_List getItem_list() {
        return item_list;
    }

    public void setItem_list(Item_List item_list) {
        this.item_list = item_list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSoft_descriptor() {
        return soft_descriptor;
    }

    public void setSoft_descriptor(String soft_descriptor) {
        this.soft_descriptor = soft_descriptor;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }
}
