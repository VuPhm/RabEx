package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserToken {
    private RID id;
    private Token verify;
    private Token resetPassword;

    public UserToken(RID id, Token verify, Token resetPassword) {
        this.id = id;
        this.verify = verify;
        this.resetPassword = resetPassword;
    }


}
