package com.ahanab.simpleapp.data;


import com.ahanab.simpleapp.Order;

public interface OrderRepository {

  Order save(Order order);
  
}
