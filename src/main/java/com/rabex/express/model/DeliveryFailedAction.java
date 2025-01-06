package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeliveryFailedAction {
    private RID id;
    private String name;
    private String description;
}
