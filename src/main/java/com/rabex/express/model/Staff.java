package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Staff {
    private RID id;
    private Post post;
    private String position;
    private String phoneNumber;




}
