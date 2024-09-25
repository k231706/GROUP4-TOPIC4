package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.Customer;
import com.swp_group4.back_end.enums.Gender;
import com.swp_group4.back_end.exception.AppException;
import com.swp_group4.back_end.exception.ErrorCode;
import com.swp_group4.back_end.repositories.CustomerRepository;
import com.swp_group4.back_end.requests.ServiceRequest;
import com.swp_group4.back_end.requests.UpdateInfoRequest;
import com.swp_group4.back_end.responses.CustomerResponse;
import com.swp_group4.back_end.responses.ServiceResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void createCustomer(String accountId, String firstname) {
        Customer customer = Customer.builder()
                .accountId(accountId)
                .firstname(firstname)
                .build();
        customerRepository.save(customer);
    }

    public CustomerResponse getOwnedInfo(){
        var context = SecurityContextHolder.getContext();
        String accountId = context.getAuthentication().getName();

        Customer customer = customerRepository.findByAccountId(accountId).orElseThrow(()
                -> new AppException(ErrorCode.USER_NOT_EXIST));

        return CustomerResponse.builder()
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .gender(customer.getGender())
                .birthday(customer.getBirthday())
                .build();
    }

    public CustomerResponse updateOwnedInfo(UpdateInfoRequest request) {

        var context = SecurityContextHolder.getContext();
        String accountId = context.getAuthentication().getName();

        Customer customer = customerRepository.findByAccountId(accountId).orElseThrow(()
                -> new AppException(ErrorCode.USER_NOT_EXIST));

        String firstname = request.getFirstname();
        if (!firstname.isEmpty() && !firstname.equals(customer.getFirstname())) {
            customer.setFirstname(firstname);
        }
        String lastname = request.getLastname();
        if (!lastname.isEmpty() && !lastname.equals(customer.getLastname())) {
            customer.setLastname(lastname);
        }
        String phone = request.getPhone();
        if (!phone.isEmpty() && !phone.equals(customer.getPhone())) {
            customer.setPhone(phone);
        }
        String address = request.getAddress();
        if (!address.isEmpty() && !address.equals(customer.getAddress())) {
            customer.setAddress(address);
        }
        Gender gender = request.getGender();
        if (!gender.equals(customer.getGender())) {
            customer.setGender(gender);
        }
        Date birthday = request.getBirthday();
        if (!birthday.equals(customer.getBirthday())) {
            customer.setBirthday(birthday);
        }

        customerRepository.save(customer);

        return CustomerResponse.builder()
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .gender(customer.getGender())
                .birthday(customer.getBirthday())
                .build();
    }

    public ServiceResponse contactUs(ServiceRequest serviceRequest) {

        fillInfoCustomer(serviceRequest);
        var context = SecurityContextHolder.getContext();
        String accountId = context.getAuthentication().getName();

        return ServiceResponse.builder()
                .service(serviceRequest.getService())
                .detail(serviceRequest.getDetail())
                .build();
    }

    // Fill thông tin Customer từ Contact Us
    private void fillInfoCustomer(ServiceRequest serviceRequest) {
        var context = SecurityContextHolder.getContext();
        String accountId = context.getAuthentication().getName();

        Customer customer = customerRepository.findByAccountId(accountId).orElseThrow(()
                -> new AppException(ErrorCode.USER_NOT_EXIST));

        customer.setFirstname(serviceRequest.getFirstname());
        customer.setLastname(serviceRequest.getLastname());
        customer.setPhone(serviceRequest.getPhone());
        customer.setAddress(serviceRequest.getAddress());
        customerRepository.save(customer);

    }

}
