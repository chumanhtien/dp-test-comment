package controller;

import java.sql.SQLException;

import entity.cart.Cart;

/**
 * This class controls the flow of events when users view the Cart
 * @author nguyenlm
 */
public class ViewCartController extends BaseController{
    
    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */

    // Content coupling: Lớp PaymentController truy xuất trực tiếp dữ liệu (cartInstance) của lớp SessionInformation
    // Common coupling
    public void checkAvailabilityOfProduct() throws SQLException{
        SessionInformation.cartInstance.checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    // ???Content coupling: Lớp ViewCartController truy xuất trực tiếp dữ liệu (cartInstance) của lớp SessionInformation
    // Common coupling: Lớp ViewCartController sử dụng dữ liệu global của lớp SessionInformation (cartInstance)
    public int getCartSubtotal(){
        int subtotal = SessionInformation.cartInstance.calSubtotal();
        return subtotal;
    }

}
