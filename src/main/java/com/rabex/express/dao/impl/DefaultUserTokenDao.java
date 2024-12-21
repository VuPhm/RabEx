package com.rabex.express.dao.impl;

import com.rabex.express.core.dao.RID;
import com.rabex.express.core.dao.RowMapper;
import com.rabex.express.dao.TemplateDao;
import com.rabex.express.dao.UserTokenDao;
import com.rabex.express.dao.mapper.UserTokenMapper;
import com.rabex.express.model.UserToken;

import java.sql.Timestamp;

public class DefaultUserTokenDao extends TemplateDao<UserToken> implements UserTokenDao {
    private static final String USER_TOKEN_PREFIX = "ut_";
    private static final String QUERY_SQL = "SELECT this.id AS ut_id, this.reset_password_token AS ut_reset_password_token, this.reset_password_token_expired_at AS reset_password_token_expired_at, this.verify_token AS ut_verify_token, this.verify_token_expired_at AS ut_verify_token_expired_at FROM users_tokens this";

    private RowMapper<UserToken> rowMapper;

    @Override
    protected RowMapper<UserToken> rowMapper() {
        if (rowMapper == null)
            rowMapper = new UserTokenMapper(USER_TOKEN_PREFIX);
        return rowMapper;
    }

    @Override
    protected String table() {
        return "users_tokens";
    }

    @Override
    protected String querySql() {
        return QUERY_SQL;
    }

    @Override
    public boolean insert(UserToken request) {
        String verifyToken = null;
        Timestamp verifyTokenExpiredAt = null;
        String resetToken = null;
        Timestamp resetTokenExpiredAt = null;
        if (request.getResetPassword() != null) {
            resetToken = request.getResetPassword().value();
            resetTokenExpiredAt = request.getResetPassword().expiredAt();
        }

        if (request.getVerify() != null) {
            verifyToken = request.getVerify().value();
            verifyTokenExpiredAt = request.getVerify().expiredAt();
        }
        String sql = "INSERT INTO users_tokens(id, verify_token, reset_password_token, verify_token_expired_at, reset_password_token_expired_at) VALUE (?, ? ,? ,? , ?)";
        return insert(sql, request.getId(), verifyToken, verifyTokenExpiredAt, resetToken, resetTokenExpiredAt);
    }

    @Override
    public boolean update(RID id, UserToken request) {
        String verifyToken = null;
        Timestamp verifyTokenExpiredAt = null;
        String resetToken = null;
        Timestamp resetTokenExpiredAt = null;
        if (request.getResetPassword() != null) {
            resetToken = request.getResetPassword().value();
            resetTokenExpiredAt = request.getResetPassword().expiredAt();
        }

        if (request.getVerify() != null) {
            verifyToken = request.getVerify().value();
            verifyTokenExpiredAt = request.getVerify().expiredAt();
        }
        String sql = "UPDATE users_tokens SET verify_token = ?, verify_token_expired_at = ?, reset_password_token = ?, reset_password_token_expired_at = ? WHERE id = ?";
        return update(sql, verifyToken, verifyTokenExpiredAt, resetToken, verifyTokenExpiredAt, id);
    }
}
