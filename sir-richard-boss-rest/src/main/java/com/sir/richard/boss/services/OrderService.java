package com.sir.richard.boss.services;

import com.sir.richard.boss.bl.core.CoreException;
import com.sir.richard.boss.bl.entity.TeOrder;
import com.sir.richard.boss.bl.jpa.TeCustomerRepository;
import com.sir.richard.boss.bl.jpa.TeOrderRepository;
import com.sir.richard.boss.model.data.Order;
import com.sir.richard.boss.rest.dto.DtoOrder;
import com.sir.richard.boss.services.converters.in.dto.InDtoOrderConverter;
import com.sir.richard.boss.services.converters.in.model.InOrderConverter;
import com.sir.richard.boss.services.converters.out.dto.OutDtoOrderConverter;
import com.sir.richard.boss.services.converters.out.model.OutOrderConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TeCustomerRepository customerRepository;

    @Autowired
    private TeOrderRepository orderRepository;
    @Autowired
    private OutOrderConverter outOrderConverter;
    @Autowired
    private OutDtoOrderConverter outDtoOrderConverter;
    @Autowired
    private InDtoOrderConverter inDtoOrderConverter;
    @Autowired
    private InOrderConverter inOrderConverter;


    public Optional<DtoOrder> findById(Long id) {
        Optional<TeOrder> teOptionalOrder = orderRepository.findById(id);
        if (teOptionalOrder.isEmpty()) {
            return Optional.empty();
        }
        Order order = outOrderConverter.convertTo(teOptionalOrder.get());
        DtoOrder dtoOrder = outDtoOrderConverter.convertTo(order);
        return Optional.of(dtoOrder);
    }

    public Long add(DtoOrder dtoOrder) throws CoreException {
        Order order = inDtoOrderConverter.convertTo(dtoOrder);
        log.info("{}", order);

        TeOrder teOrder = new TeOrder();
        teOrder = inOrderConverter.saveTo(order, teOrder);

        orderRepository.save(teOrder);
        return teOrder.getId();
    }

    public void update(DtoOrder dtoOrder) throws CoreException {
        Order order = inDtoOrderConverter.convertTo(dtoOrder);

        Optional<TeOrder> teCurrentOrder = orderRepository.findById(order.getId());
        if (teCurrentOrder.isEmpty()) {
            throw new CoreException(CoreException.RECORD_WITH_ID_NOT_FOUND);
        }
        TeOrder teOrder = inOrderConverter.saveTo(order, teCurrentOrder.get());
        orderRepository.save(teOrder);

        log.info("saved: {}", teOrder);
    }
}
