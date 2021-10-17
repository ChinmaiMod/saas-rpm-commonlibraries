
package com.io.holter.common.component.reports;

@lombok.Data
public class Rr {

    private Integer min;
    private Integer mean;
    private Integer max;
    private java.util.List<DataValue> data;


}
