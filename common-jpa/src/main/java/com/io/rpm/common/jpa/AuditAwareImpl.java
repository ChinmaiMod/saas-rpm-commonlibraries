package com.io.rpm.common.jpa;

import com.io.rpm.common.component.TokenContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component(value = "auditAware")
public class AuditAwareImpl implements AuditorAware<Long> {
    @Autowired
    private TokenContext tokenContext;
    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.of(tokenContext.getUserId());
    }
}
