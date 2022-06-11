package com.io.rpm.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuotePdfDto {
    private String companyName;
    private String quoteName;
    private String companyAddress;
    private String companyWebsite;
    private String companyEmail;
    private String companyPhone;
    private String billTo;
    private String shipTo;
    private String quoteNo;
    private String contactName;
    private  String deptName;
    private  String date;
    private String billToCompanyName;
    private String shipToCompanyName;
    private String validfor;
    private String billToAddress;
    private String shipToAddress;
    private String billToPhone;
    private  String shipToPhone;
    private  String email;

    private String description;
    private Double quantity;
    private Double unitPrice;
    private Double total;
    private Double subtotal;
    private Double discount;
    private Double subtotalLessDiscount;
    private Double taxRate;
    private Double totalTax;
    private  Double shipping;
    private Double totalDue;


}
