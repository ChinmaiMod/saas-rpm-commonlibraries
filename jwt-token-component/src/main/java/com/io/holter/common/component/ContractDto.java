package com.io.holter.common.component;

import com.io.holter.common.component.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {

    private Long id;
    private ClientDto client;
    private ProductDto product;
    private Date startDate;
    private Date endDate;
    private Long numberOfDevice;
    private Boolean active;
    private String status;
    private LocalDate createdDate;
    private String createdBy;
    private Long proposalId;
}
