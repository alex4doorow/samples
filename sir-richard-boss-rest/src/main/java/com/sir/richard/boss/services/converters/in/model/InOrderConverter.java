package com.sir.richard.boss.services.converters.in.model;

import com.sir.richard.boss.bl.entity.*;
import com.sir.richard.boss.bl.jpa.*;
import com.sir.richard.boss.model.data.Order;
import com.sir.richard.boss.model.types.OrderAmountTypes;
import com.sir.richard.boss.model.types.StoreTypes;
import com.sir.richard.boss.services.converters.IOPersistConverter;
import com.sir.richard.boss.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Component
public class InOrderConverter implements IOPersistConverter<Order, TeOrder> {

    @Autowired
    private TeWikiOrderTypeRepository wikiOrderTypeRepository;
    @Autowired
    private TeWikiOrderSourceRepository wikiOrderSourceRepository;
    @Autowired
    private TeWikiOrderAdvertRepository wikiOrderAdvertRepository;
    @Autowired
    private TeWikiOrderPaymentRepository wikiOrderPaymentRepository;
    @Autowired
    private TeWikiOrderStatusRepository wikiOrderStatusRepository;
    @Autowired
    private TeOrderRepository orderRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public TeOrder saveTo(Order inputOrder, TeOrder teSourceOrder) {

        teSourceOrder.setOrderNo(inputOrder.getOrderNo());
        teSourceOrder.setOrderDate(inputOrder.getOrderDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        Optional<TeWikiOrderType> teWikiOrderType = wikiOrderTypeRepository
                .findById(Long.valueOf(inputOrder.getOrderType().getId()));
        teSourceOrder.setOrderType(teWikiOrderType.get());

        Optional<TeWikiOrderSource> teWikiOrderSource = wikiOrderSourceRepository
                .findById(Long.valueOf(inputOrder.getSourceType().getId()));
        teSourceOrder.setSourceType(teWikiOrderSource.get());

        Optional<TeWikiOrderAdvert> teWikiOrderAdvert = wikiOrderAdvertRepository
                .findById(Long.valueOf(inputOrder.getAdvertType().getId()));
        teSourceOrder.setAdvertType(teWikiOrderAdvert.get());

        Optional<TeWikiOrderPayment> teWikiOrderPayment = wikiOrderPaymentRepository
                .findById(Long.valueOf(inputOrder.getPaymentType().getId()));
        teSourceOrder.setPaymentType(teWikiOrderPayment.get());

        Optional<TeWikiOrderStatus> teWikiOrderStatus = wikiOrderStatusRepository
                .findById(Long.valueOf(inputOrder.getStatus().getId()));
        teSourceOrder.setStatus(teWikiOrderStatus.get());

        teSourceOrder.setStoreId(StoreTypes.PM.getId());
        teSourceOrder.setEmailStatus(0);

        teSourceOrder.setOrderSubNo(0);
        teSourceOrder.setOrderYear(DateTimeUtils.dateToLongYear(inputOrder.getOrderDate()));

        teSourceOrder.setAnnotation(inputOrder.getAnnotation());

        // todo change after add spring security
        TeUser user = entityManager.find(TeUser.class, 1L);
        teSourceOrder.setUserAdded(user);

        teSourceOrder.setDateAdded(LocalDateTime.now());
        teSourceOrder.setDateModified(LocalDateTime.now());

        teSourceOrder.setAmountTotal(inputOrder.getAmounts().getValue(OrderAmountTypes.TOTAL));
        teSourceOrder.setAmountTotalWithDelivery(inputOrder.getAmounts().getValue(OrderAmountTypes.TOTAL_WITH_DELIVERY));
        teSourceOrder.setAmountBill(inputOrder.getAmounts().getValue(OrderAmountTypes.BILL));
        teSourceOrder.setAmountSupplier(inputOrder.getAmounts().getValue(OrderAmountTypes.SUPPLIER));
        teSourceOrder.setAmountMargin(inputOrder.getAmounts().getValue(OrderAmountTypes.MARGIN));
        teSourceOrder.setAmountPostpay(inputOrder.getAmounts().getValue(OrderAmountTypes.POSTPAY));

        TeOrder teResultOrder = orderRepository.save(teSourceOrder);
        TeOrderDelivery delivery = new TeOrderDelivery();
        delivery.setOrder(teResultOrder);
        delivery.setPrice(inputOrder.getDelivery().getPrice());
        // ...


        inputOrder.getItems().forEach(item -> {
            TeOrderItem teOrderItem = new TeOrderItem();
            teOrderItem.setNo(item.getNo());
            // ...
        });

        return teResultOrder;


    }
}