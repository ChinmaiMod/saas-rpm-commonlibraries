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
public class QuoteDto {
    public Long id;
    public String name;
    public String quoteStatus;
    public String taxRate;
    public Date createdDate;
    public Date expirationDate;
    public String comment;
    public String conditions;
    public Long leadId;
    public String location;
    public Long numberOfDevice;
    public Long leasePeriodYear;
    public String paymentType;
    public Double estimate;
    public Double percent;
    public Long quoteTotal;
    public Date createDate;
    public Date validTill;
    public String remark;
    public Boolean active;

}
