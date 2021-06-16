package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl.Protien;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
public class OrdersMapImpl implements Orders 
{
	private HashMap <String, ArrayList<TacoImpl>> orders = new HashMap<>();
	 /**
     * Creates an order based on the order ID. Note that you will need to create an empty array list to put in the map.
     *
     * @param orderid The Id of the order.
     */
    @Override
    public void createOrder(final String orderid) 
    {
    	ArrayList<TacoImpl> orderIndiv = new ArrayList<>();
    	orders.put(orderid, orderIndiv);
    }

    /**
     * Adds an taco to the orders
     *
     * @param orderid The order id
     * @param taco - The taco to add.
     */
    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException 
    {
    	ArrayList<TacoImpl> orderIndiv = orders.get(orderid);
    	if (orderIndiv == null) {
    		throw new OrderDoesNotExistException(orderid);
    	}
    	orderIndiv.add(taco);
    	
    }
    /**
     * True if more tacos remain, else false.
     * @return
     */
    @Override
    public boolean hasNext() 
    {
        return orders.size() > 0;
    }
    /**
     * Note that this method will remove the order baseed on the orderid and return it.
     *
     * Once returned it should be permenantly removed.
     *
     * Outcome
     * ========
     * It will remove and return the list of Tacos.
     *
     * @param orderid  for the list of tacos.
     * @return The taco.
     */
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException 
    {
    	ArrayList<TacoImpl> orderIndiv = orders.get(orderid);
    	if (orderIndiv == null) {
    		throw new OrderDoesNotExistException(orderid);
    	}
    	orders.remove(orderid);
        return orderIndiv;
    }
    /**
     * How many order remain in the tacoQueue
     *
     * @return How many orders are in the queue
     */
    @Override
    public int howManyOrders()
    {
        return orders.size();
    }
    /**
     * Fetches the list of tacos associated with an order, however, it does not remove them.
     *
     * @param orderid The orderid to get.
     * @return The list of tacos.
     */
    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException 
    {
    	ArrayList<TacoImpl> orderIndiv = orders.get(orderid);
    	if (orderIndiv == null) {
    		throw new OrderDoesNotExistException(orderid);
    	}
        return orderIndiv;
    }
}
