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
public class ProductDto {
    private Long id;
    private String productType;
    private String name;
    private boolean active;

    private SupplierDto manufacturer;
    private String simpleDiscription;
    private String detailDiscription;
    private String unitMesurement;
    private Date activeFrom;
    private Date activeTill;
    private String externalCode;
    private String barcode;
    private String brand;
    private boolean isNew;
    private boolean archive;
    private String artNumber;
    private String productImage;
    private String backImage;
    private String accessories;
    private String background;
    private List<LabelDto> labels;
    private ProductPriceDto productPrice;
}
