package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.Account;
import com.swp_group4.back_end.entities.ConstructionOrder;
import com.swp_group4.back_end.entities.Customer;
import com.swp_group4.back_end.enums.ConstructionOrderStatus;
import com.swp_group4.back_end.enums.Role;
import com.swp_group4.back_end.mapper.ConstructionOrderMapper;
import com.swp_group4.back_end.repositories.ConstructOrderRepository;
import com.swp_group4.back_end.repositories.CustomerRepository;
import com.swp_group4.back_end.requests.ServiceRequest;
import com.swp_group4.back_end.responses.ConstructOrderResponse;
import com.swp_group4.back_end.responses.ConsultConstructResponse;
import com.swp_group4.back_end.responses.ServiceResponse;
import com.swp_group4.back_end.responses.StaffResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConstructOrderService {

    @Autowired
    ConstructOrderRepository constructOrderRepository;
    @Autowired
    ConstructionOrderMapper constructionOrderMapper;
    @Autowired
    CustomerRepository customerRepository;

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

    public List<ConsultConstructResponse> listAllConsult() {
        List<ConstructionOrderStatus> statusList = new ArrayList<>();
        statusList.add(ConstructionOrderStatus.REQUESTED);
        statusList.add(ConstructionOrderStatus.CONSULTING);
        statusList.add(ConstructionOrderStatus.QUOTATION);

        List<ConstructionOrder> constructionOrders = constructOrderRepository.findByStatusIn(statusList);

        return constructionOrders.stream()
                .map(order -> {Customer customer = customerRepository.findById(order.getCustomerId())
                        .orElseThrow(() -> new RuntimeException("Customer not found for id: " + order.getCustomerId()));
                    return ConsultConstructResponse.builder()
                            .constructionOrderId(order.getConstructionOrderId())
                            .customerName(customer.getFirstname() + " " + customer.getLastname())
                            .startDate(order.getStartDate())
                            .phone(customer.getPhone())
                            .address(customer.getAddress())
                            .status(order.getStatus())
                            .build();
                })
                .toList();

    }


//    public ServiceResponse<MaintenanceOrderResponse> contactUsForMaintenance(ServiceRequest serviceRequest) {
//        // Your logic for maintenance service...
//    }
}
