package com.rabex.express.dto;

import com.rabex.express.core.dao.RID;
import com.rabex.express.model.UserStatus;

import java.util.List;

public record RegisterRequest(
        String email,
        String fullName,
        List<RID> roleId,
        String password,
        UserStatus userStatus

) {

}
