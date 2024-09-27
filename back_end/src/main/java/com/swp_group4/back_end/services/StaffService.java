package com.swp_group4.back_end.services;

import com.swp_group4.back_end.entities.Account;
import com.swp_group4.back_end.enums.Role;
import com.swp_group4.back_end.repositories.AccountRepository;
import com.swp_group4.back_end.repositories.StaffRepository;
import com.swp_group4.back_end.responses.StaffResponse;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StaffService {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    AccountRepository accountRepository;

    public List<StaffResponse> listAllConsultant(){
        List<Account> consultantAccount = accountRepository.findByRole(Role.CONSULTANT);

        return consultantAccount.stream()
                .map(account -> staffRepository.findByAccountId(account.getAccountId())
                        .map(staff -> new StaffResponse(staff.getStaffId(), staff.getStaffName()))
                        .orElseThrow(() -> new RuntimeException("Staff not found for account: " + account.getAccountId())))
                .toList();
    }

    public List<StaffResponse> listAllDesigner(){
        List<Account> designerAccount = accountRepository.findByRole(Role.DESIGNER);

        return designerAccount.stream()
                .map(account -> staffRepository.findByAccountId(account.getAccountId())
                        .map(staff -> new StaffResponse(staff.getStaffId(), staff.getStaffName()))
                        .orElseThrow(() -> new RuntimeException("Staff not found for account: " + account.getAccountId())))
                .toList();
    }

    public List<StaffResponse> listAllConstructor(){
        List<Account> constructorAccount = accountRepository.findByRole(Role.CONSTRUCTOR);

        return constructorAccount.stream()
                .map(account -> staffRepository.findByAccountId(account.getAccountId())
                        .map(staff -> new StaffResponse(staff.getStaffId(), staff.getStaffName()))
                        .orElseThrow(() -> new RuntimeException("Staff not found for account: " + account.getAccountId())))
                .toList();
    }


}
