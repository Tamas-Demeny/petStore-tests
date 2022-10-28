package org.example;

import io.restassured.response.Response;
import org.example.entities.StoreOrder;
import org.example.steps.OrderServiceSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PetStoreOrderTests {

    @Test
    public void getInventory() {
        OrderServiceSteps.getInventory();
    }

    @Test
    public void placeOrder() {
        StoreOrder ourOrder = createOrder();
        Response response = OrderServiceSteps.placeOrder(ourOrder);
        Assert.assertEquals(response.as(StoreOrder.class).getId(), ourOrder.getId());
    }

    @Test
    public void getOrderById() {
        Response response = OrderServiceSteps.getOrderById();
    }

    private StoreOrder createOrder() {
        Random random = new Random();
        return new StoreOrder().setId(random.nextInt(10))
                .setPetId(random.nextInt(10))
                .setQuantity(random.nextInt(10))
                .setShipDate("2022-10-26T09:32:24.876Z")
                .setStatus("placed")
                .setComplete(true);
    }
}
