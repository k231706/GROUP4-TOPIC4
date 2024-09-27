package com.swp_group4.back_end.responses;

import com.swp_group4.back_end.enums.ConstructionOrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ConsultConstructResponse {

    String constructionOrderId;
    String customerName;
    ZonedDateTime startDate;
    String phone;
    String address;
    ConstructionOrderStatus status;

}
