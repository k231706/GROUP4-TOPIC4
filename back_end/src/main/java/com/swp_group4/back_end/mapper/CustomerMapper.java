package com.swp_group4.back_end.mapper;

import com.swp_group4.back_end.entities.Customer;
import com.swp_group4.back_end.requests.ServiceRequest;
import com.swp_group4.back_end.requests.UpdateInfoRequest;
import com.swp_group4.back_end.responses.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer serviceRequestToCustomer(ServiceRequest request, @MappingTarget Customer customer);
    Customer updateInfoToCustomer(UpdateInfoRequest request, @MappingTarget Customer customer);
    CustomerResponse customerToResponse(Customer customer, @MappingTarget CustomerResponse customerResponse);

}
