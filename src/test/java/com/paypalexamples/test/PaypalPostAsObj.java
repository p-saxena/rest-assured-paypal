package com.paypalexamples.test;

import com.paypalexamples.base.BaseClass;
import com.paypalexamples.payment.pojo.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Created by watchmaster on 9/23/17.
 */
public class PaypalPostAsObj extends BaseClass {
    static String payment_id;
    /**
     * create object of each class in payment.pojo and set the value
     */
    @Test
    public void createAPayment(){

        Redirect_urls red_url = new Redirect_urls();
        red_url.setCancel_url("http://www.hawaii.com");
        red_url.setReturn_url("http://www.amazon.com");

        Details details = new Details();
        details.setHandling_fee("1.00");
        details.setInsurance("0.01");
        details.setShipping("0.03");
        details.setShipping_discount("-1.00");
        details.setSubtotal("30.00");
        details.setTax("0.07");

        //Create Amount
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setDetails(details);
        amount.setTotal("30.11");

        //Set the shipping address
        Shipping_address shipping_address = new Shipping_address();
        shipping_address.setCity("San Jose");
        shipping_address.setCountry_code("US");
        shipping_address.setLine1("4thFloor");
        shipping_address.setLine2("unit34");
        shipping_address.setPhone("011862212345678");
        shipping_address.setPostal_code("95131");
        shipping_address.setRecipient_name("PAB");
        shipping_address.setState("CA");

        //Set Items
        Items item = new Items();
        item.setCurrency("USD");
        item.setDescription("Brown color hat");
        item.setName("hat");
        item.setPrice("3");
        item.setQuantity("5");
        item.setSku("1");
        item.setTax("0.01");

        Items item2= new Items();
        item2.setCurrency("USD");
        item2.setDescription("Black color hand bag");
        item2.setName("handbag");
        item2.setPrice("15");
        item2.setQuantity("1");
        item2.setSku("product34");
        item2.setTax("0.02");

        List<Items> items= new ArrayList();
        items.add(item);
        items.add(item2);

        //Item List
        Item_List item_list = new Item_List();
        item_list.setShipping_address(shipping_address);
        item_list.setItems(items);

        //Set payment options
        Payment_Options payment_options = new Payment_Options();
        payment_options.setAllowed_payment_method("INSTANT_FUNDING_SOURCE");

        //Set Transactions
        Transactions transaction = new Transactions();
        transaction.setAmount(amount);
        transaction.setCustom("EBAY_EMS_90048630024435");
        transaction.setDescription("This is the payment transaction description.");
        transaction.setInvoice_number("48787589674");
        transaction.setItem_list(item_list);
        transaction.setPayment_options(payment_options);
        transaction.setSoft_descriptor("ECHI5786786");

        List<Transactions> transactions = new ArrayList();
        transactions.add(transaction);

        //Set payer
        Payer payer = new Payer();
        payer.setPayment_method("paypal");

        PaypalPostObj postObj = new PaypalPostObj();
        postObj.setIntent("sale");
        postObj.setNote_to_payer("Contact us");
        postObj.setRedirect_urls(red_url);
        postObj.setPayer(payer);
        postObj.setTransactions(transactions);

        payment_id=given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(accessToken)
                .when()
                .body(postObj)
                .post("/payments/payment")
                .then()
                .log()
                .all()
                .extract()
                .path("id");

    }

    /**
     * get details of a payment based on payment id
     */
    @Test
    public void getPaymentDetails(){
        given()
                .auth()
                .oauth2(accessToken)
                .when()
                .get("/payments/payment/"+payment_id)
                .then()
                .log()
                .all();
    }
}
