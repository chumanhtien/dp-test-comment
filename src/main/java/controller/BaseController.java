package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartItem;
import entity.media.Media;

/**
 * This class is the base controller for our AIMS project
 * @author nguyenlm
 */
public class BaseController {
    
    /**
     * The method checks whether the Media in Cart, if it were in, we will return the CartMedia else return null
     * @param media
     * @return CartMedia or null
     */

    // ???Content coupling: Lớp BaseController truy xuất trực tiếp dữ liệu (cartInstance) của lớp SessionInformation
    // Common coupling: Lớp BaseController sử dụng biến global của lớp SessionInformation (cartInstance)
    public CartItem checkMediaInCart(Media media){
        return SessionInformation.cartInstance.checkMediaInCart(media);
    }

    /**
     * This method gets the list of items in cart
     * @return List[CartMedia]
     */

    // ???Content coupling: Lớp BaseController truy xuất trực tiếp dữ liệu (cartInstance) của lớp SessionInformation
    // Common coupling: Lớp BaseController sử dụng biến global của lớp SessionInformation (cartInstance)
    public List getListCartMedia(){
        return SessionInformation.cartInstance.getListMedia();
    }
}
