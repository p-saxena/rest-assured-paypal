package com.paypalexamples.payment.pojo;

import java.util.List;

/**
 * Created by watchmaster on 9/22/17.
 */
public class Item_List {

    /**
     * following 2 items are different objects within item_list object in request body
     * Each of the 2 items is listed as a member variable of POJO class
     * Shipping_address and Items are String variables
     * Both have children of their own which are added as member varibles in their respective classes
     * this class contains final list of objects sent by Item_List object of request body
     */
    private Shipping_address shipping_address;
    private List<Items> items;

    public Shipping_address getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(Shipping_address shipping_address) {
        this.shipping_address = shipping_address;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
