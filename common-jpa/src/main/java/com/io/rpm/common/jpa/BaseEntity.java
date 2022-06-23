package com.io.rpm.common.jpa;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(name="CREATED_DATE")
    private Date createdDate;
    @LastModifiedDate
    @Column(name="LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @CreatedBy
    @Column(name="CREATED_BY")
    private Long createdBy;
    @LastModifiedBy
    @Column(name="LAST_UPDATED_BY")
    private Long lastModifiedBy;
}
