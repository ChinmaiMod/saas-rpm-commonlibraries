package com.io.rpm.pageble;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = PageableQueryEncoder.class)
interface PageMixIn { }
