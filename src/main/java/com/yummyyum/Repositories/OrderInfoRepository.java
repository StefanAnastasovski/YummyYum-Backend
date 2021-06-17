package com.yummyyum.Repositories;

import com.yummyyum.Model.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

    @Query(value = "SELECT * FROM order_info WHERE order_id LIKE %:orderId%",
            nativeQuery = true)
    Optional<OrderInfo> getOrderInfoByOrderId(String orderId);

    @Query(value = "SELECT * FROM order_info WHERE order_date LIKE %:date%",
            nativeQuery = true)
    List<OrderInfo> getOrderInfoByOrderDate(String date);

//    SELECT * FROM order_info as oi WHERE DATE_FORMAT(oi.order_date,'%Y-%m-%d') BETWEEN '2021-06-10' AND '2021-06-14'


    @Query(value = "SELECT * FROM order_info as oi WHERE DATE_FORMAT(oi.order_date,'%Y-%m-%d') BETWEEN :startDate AND :endDate",
            nativeQuery = true)
    List<OrderInfo> getOrderInfoByStartAndEndDates(String startDate, String endDate);


}

