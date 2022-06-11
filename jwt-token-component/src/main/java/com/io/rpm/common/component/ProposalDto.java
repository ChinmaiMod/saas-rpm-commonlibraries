package com.io.rpm.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProposalDto {
    private Long id;
    private String name;
    private String type;
    private String createBy;
    private Date createDate;
    private String notes;
    private ClientDto clientDto;
    private UserDto assignedTo;
    private List<QuoteDto> quotes;
    private ProductDto product;
    private String stage;
}
