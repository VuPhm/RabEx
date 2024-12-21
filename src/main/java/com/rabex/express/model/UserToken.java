package com.rabex.express.model;

import com.rabex.express.core.dao.RID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserToken {
    private RID id;
    private Token verify;
    private Token resetPassword;

    public UserToken(RID id, Token verify, Token resetPassword) {
        this.id = id;
        this.verify = verify;
        this.resetPassword = resetPassword;
    }

    UserToken() {


    }

    public static final class UserTokenBuilder {
        private RID id;
        private Token verify;
        private Token resetPassword;

        private UserTokenBuilder() {
        }

        public static UserTokenBuilder anUserToken() {
            return new UserTokenBuilder();
        }

        public UserTokenBuilder id(RID id) {
            this.id = id;
            return this;
        }

        public UserTokenBuilder verify(Token verify) {
            this.verify = verify;
            return this;
        }

        public UserTokenBuilder resetPassword(Token resetPassword) {
            this.resetPassword = resetPassword;
            return this;
        }

        public UserToken build() {
            UserToken userToken = new UserToken();
            userToken.setId(id);
            userToken.setVerify(verify);
            userToken.setResetPassword(resetPassword);
            return userToken;
        }
    }
}
