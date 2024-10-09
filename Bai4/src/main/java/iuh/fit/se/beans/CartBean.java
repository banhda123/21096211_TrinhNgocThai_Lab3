package iuh.fit.se.beans;

import java.util.ArrayList;

public class CartBean {
	private ArrayList<CartItemBean> cartItems = new ArrayList<CartItemBean>();
	private double orderTotal;

	public ArrayList<CartItemBean> getCartItems() {
		return cartItems;
	}

	public void setCartItems(ArrayList<CartItemBean> cartItems) {
		this.cartItems = cartItems;
	}

	public double getorderTotal() {
		return orderTotal;
	}

	public void setorderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getLineItemCount() {
		return cartItems.size();
	}

	public void deleteCartItem(String itemIndex) {
		int index = 0;
		try {
			index = Integer.parseInt(itemIndex);
				cartItems.remove(index);
					
			calculateOrderTotal();
		} catch (NumberFormatException nfe) {
			System.out.println("Error while deleting cart item: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	public void updateCartItem(String itemIndex, String strQuantity) {
		double totalCost = 0.0;
		double unitCost = 0.0;
		int quantity = 0;
		int index = 0;
		CartItemBean cartItem = null;
		try {
			index = Integer.parseInt(itemIndex);
			quantity = Integer.parseInt(strQuantity);
			if (quantity > 0) {
				cartItem = cartItems.get(index);
				unitCost = cartItem.getUnitCost();
				totalCost = unitCost * quantity;
				cartItem.setQuantity(quantity);
				cartItem.setTotalCost(totalCost);
				calculateOrderTotal();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Error while deleting cart item: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	protected void calculateOrderTotal() {
		double total = 0;
		for (int i = 0; i < cartItems.size(); i++) {
			CartItemBean cartItem = cartItems.get(i);
			total += cartItem.getTotalCost();
		}
		setorderTotal(total);
	}

	public CartItemBean getCartItem(int itemIndex) {
		CartItemBean cartItem = null;
		if (cartItems.size() > itemIndex) {
			cartItem = cartItems.get(itemIndex);
		}
		return cartItem;
	}

	public void addCartItem(String modelNo, String description, String strUnitCost, String strQuantity) {
	    double totalCost = 0.0;
	    double unitCost = 0.0;
	    int quantity = 0;
	    try {
	        unitCost = Double.parseDouble(strUnitCost);
	        quantity = Integer.parseInt(strQuantity);
	        if (quantity > 0) {
	            boolean itemExists = false;
	            for (CartItemBean cartItem : cartItems) {
	                if (cartItem.getPartNumber().equals(modelNo)) {
	                    int newQuantity = cartItem.getQuantity() + quantity;
	                    cartItem.setQuantity(newQuantity);
	                    cartItem.setTotalCost(cartItem.getUnitCost() * newQuantity);
	                    itemExists = true;
	                    break;
	                }
	            }

	            if (!itemExists) {
	                CartItemBean cartItem = new CartItemBean();
	                totalCost = unitCost * quantity;
	                cartItem.setTotalCost(totalCost);
	                cartItem.setModelDescription(description);
	                cartItem.setPartNumber(modelNo);
	                cartItem.setQuantity(quantity);
	                cartItem.setUnitCost(unitCost);
	                cartItems.add(cartItem);
	            }

	            calculateOrderTotal();                
	        }
	    } catch (NumberFormatException nfe) {
	        System.out.println("Error while parsing from String to primitive types: " + nfe.getMessage());
	        nfe.printStackTrace();
	    }
	}


	public void addCartItem(CartItemBean cartItem) {
		cartItems.add(cartItem);
	}
}