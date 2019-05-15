package com.omnicuris.assignment.omnicuris.orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderService extends JpaRepository<Order, Long>{

}
