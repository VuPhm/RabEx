package com.rabex.express.services;

import com.rabex.express.core.dao.RID;
import com.rabex.express.dao.UserDao;
import com.rabex.express.dao.UserTokenDao;
import com.rabex.express.dto.RegisterRequest;
import com.rabex.express.exceptions.BadCredentialsException;
import com.rabex.express.exceptions.UnVerifyUserException;
import com.rabex.express.model.Token;
import com.rabex.express.model.User;
import com.rabex.express.model.UserStatus;
import com.rabex.express.model.UserToken;
import com.rabex.express.security.Authentication;
import com.rabex.express.security.DefaultAuthentication;
import com.rabex.express.security.Principal;
import com.rabex.express.security.UserPrincipal;
import jakarta.inject.Inject;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultAuthService implements AuthService{
    @Inject
    private UserDao userDao;
    @Inject
    private UserTokenDao userTokenDao;
    @Inject
    private PasswordEncoder encoder;

    public DefaultAuthService(UserDao userDao, UserTokenDao userTokenDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.userTokenDao = userTokenDao;
        this.encoder = encoder;
    }

    public DefaultAuthService() {
    }

    private static final int TOKEN_AGE = 3;
    private static final ChronoUnit TOKEN_AGE_UNIT = ChronoUnit.HOURS;

    @Override
    public Authentication authenticate(String email, String password) {
        User user = userDao.findByEmail(email).orElse(null);
        if (user == null) return null;
        Principal principal = new UserPrincipal();




        return new DefaultAuthentication(principal);
    }

    private Authentication authenticate(User user, String password) {
        if (user.getVerifiedAt() == null) throw new UnVerifyUserException();
        if (!encoder.match(user.getHashPassword(), password)) throw new BadCredentialsException();
        return null;
    }

    @Override
    public boolean register(RegisterRequest request) {
        User user = User.builder()
                .id(RID.fast())
                .email(request.email())
                .hashPassword(encoder.encode(request.password()))
                .status(UserStatus.ACTIVE)
                .build();

        return userDao.insert(user);
    }

    @Override
    public boolean requestPasswordCode(String email) {
        User user = userDao.findByEmail(email).orElse(null);
        if (user == null) return false;

        UserToken token = userTokenDao.findById(user.getId()).orElseGet(() -> {
            UserToken t = UserToken.builder()
                    .id(user.getId())
                    .build();

            userTokenDao.insert(t);
            return t;

        });

        LocalDateTime expiredAt = LocalDateTime.now().plus(TOKEN_AGE, TOKEN_AGE_UNIT);
        token.setResetPassword(new Token(RID.fast().toString(), Timestamp.valueOf(expiredAt)));

        userTokenDao.update(token.getId(), token);
        return true;
    }

    @Override
    public boolean requestVerifyCode(String email) {
        User user = userDao.findByEmail(email).orElse(null);
        if (user == null) return false;

        UserToken token = userTokenDao.findById(user.getId()).orElseGet(() -> {
            UserToken t = UserToken.builder()
                    .id(user.getId())
                    .build();

            userTokenDao.insert(t);
            return t;

        });

        LocalDateTime expiredAt = LocalDateTime.now().plus(TOKEN_AGE, TOKEN_AGE_UNIT);
        token.setVerify(new Token(generateTokeValue() ,Timestamp.valueOf(expiredAt)));

        userTokenDao.update(token.getId(), token);
        return true;
    }

    @Override
    public boolean verify(String email, String tokenValue) {
        User user = userDao.findByEmail(email).orElse(null);
        if (user == null) return false;
        UserToken token = userTokenDao.findById(user.getId()).orElse(null);
        if (token == null) return false;
        if (token.getVerify() == null) return false;
        if (token.getVerify().validate(tokenValue)){
            user.setVerifiedAt(Timestamp.valueOf(LocalDateTime.now()));
            user.setStatus(UserStatus.ACTIVE);
            token.setVerify(null);
            userTokenDao.update(token.getId(), token);
            userDao.update(user.getId(),user);
            return true;
        }
        return false;
    }

    @Override
    public boolean resetPassword(String email, String tokenValue, String password) {
        User user = userDao.findByEmail(email).orElse(null);
        if (user == null) return false;
        UserToken token = userTokenDao.findById(user.getId()).orElse(null);
        if (token == null) return false;
        if (token.getResetPassword() == null) return false;
        if (token.getResetPassword().validate(tokenValue)){
            user.setHashPassword(encoder.encode(password));
            userTokenDao.update(user.getId(), token);
            return true;
        }
        return false;
    }

    private String generateTokeValue(){
        return RID.fast() + RID.fast().toString() + RID.fast();
    }
}
