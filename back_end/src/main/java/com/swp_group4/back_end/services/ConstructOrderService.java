package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.ConstructionOrder;
import com.swp_group4.back_end.entities.Customer;
import com.swp_group4.back_end.enums.ConstructionOrderStatus;
import com.swp_group4.back_end.mapper.ConstructionOrderMapper;
import com.swp_group4.back_end.repositories.ConstructOrderRepository;
import com.swp_group4.back_end.requests.ServiceRequest;
import com.swp_group4.back_end.responses.ConstructOrderResponse;
import com.swp_group4.back_end.responses.ServiceResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConstructOrderService {

    @Autowired
    ConstructOrderRepository constructOrderRepository;
    @Autowired
    ConstructionOrderMapper constructionOrderMapper;

    public ConstructionOrder createOrder(ServiceRequest request, Customer customer) {
        ConstructionOrder constructionOrder = ConstructionOrder.builder()
                .customerId(customer.getCustomerId())
                .customerRequest(request.getCustomerRequest())
                .startDate(ZonedDateTime.now())
                .status(ConstructionOrderStatus.REQUESTED)
                .build();
        return constructOrderRepository.save(constructionOrder);
    }

    ServiceResponse<ConstructOrderResponse> contactUsForConstruction(ServiceRequest serviceRequest, ConstructionOrder constructionOrder) {
        ConstructOrderResponse response = new ConstructOrderResponse();
        constructionOrderMapper.constructOrderResponse(constructionOrder, response);
        return ServiceResponse.<ConstructOrderResponse>builder()
                .service(serviceRequest.getService())
                .data(response)
                .build();
    }

//    public ServiceResponse<MaintenanceOrderResponse> contactUsForMaintenance(ServiceRequest serviceRequest) {
//        // Your logic for maintenance service...
//    }
}
