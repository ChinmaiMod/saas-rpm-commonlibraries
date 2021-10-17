package com.io.holter.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceDto {
    private Long id;
    private Double baseUnitPrice;
    private Double unitMontlyRental;
    private Double unitAnualRental;
    private String currency;
    private Date lastUpdate;
}
