package com.sir.richard.boss.model.data;

import com.sir.richard.boss.model.types.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Order extends AnyId {

    private Integer orderNo;
    private LocalDate orderDate;
    private OrderTypes orderType;

    private ProductCategory productCategory;
    private OrderSourceTypes sourceType;
    private OrderAdvertTypes advertType;
    private PaymentTypes paymentType;
    private StoreTypes store;
    private OrderStatuses status;
    private OrderEmailStatuses emailStatus;
    private OrderDelivery delivery;
    //private List<OrderExternalCrm> externalCrms;

    private List<OrderStatusItem> statuses;
    private List<OrderItem> items;
    private OrderAmounts amounts;
    private String annotation;
    private LocalDateTime addedDate;
    private LocalDateTime modifiedDate;
    //private Set<Comment> comments;
    //private final OrderOffer offer;


    private AnyCustomer customer;

    public Order() {
        super();

        this.store = StoreTypes.PM;
        this.delivery = new OrderDelivery(this);
        //this.externalCrms = new ArrayList<OrderExternalCrm>();
        this.statuses = new ArrayList<>();
        this.amounts = new OrderAmounts(this);
        //this.comments = new HashSet<Comment>();
        this.items = new ArrayList<>();
        //this.offer = new OrderOffer(this);

    }

}
