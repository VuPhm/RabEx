package com.rabex.express.dao.mapper;

import com.rabex.express.core.dao.Convertor;
import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.core.dao.StringToRidConvertor;
import com.rabex.express.model.Token;
import com.rabex.express.model.UserToken;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTokenMapper implements RowMapper<UserToken> {

    private final String prefix;
    private final Convertor<String, RID> ridConvertor;

    public UserTokenMapper(String prefix) {
        this.prefix = prefix;
        ridConvertor = new StringToRidConvertor();
    }

    @Override
    public UserToken mapRow(ResultSet rs, int row) throws SQLException {
        Token resetPasswordToken = null;
        Token verifyToken = null;

        String resetPasswordTokenValue = rs.getString(getPrefix() + "reset_password_token");
        String verifyTokenValue = rs.getString(getPrefix() + "verify_token");

        if (resetPasswordTokenValue != null) resetPasswordToken = new Token(resetPasswordTokenValue, rs.getTimestamp(getPrefix() + "reset_password_token_expired_at"));
        if (verifyTokenValue != null)verifyToken = new Token(resetPasswordTokenValue, rs.getTimestamp(getPrefix() + "verify_token_expired_at"));

        return UserToken.UserTokenBuilder.anUserToken()
                .id(ridConvertor.convert(rs.getString(prefix + "id")))
                .resetPassword(resetPasswordToken)
                .verify(verifyToken)
                .build();
    }

    @Override
    public String getPrefix() {
        return prefix;
    }
}
