package com.rabex.express.model;
import com.rabex.express.core.dao.RID;

import java.sql.Timestamp;
import java.util.List;

public class User {
    private RID id;                // binary(16)
    private String hashPassword;      // varchar(45)
    private String fullName;          // varchar(45)
    private boolean deleted;          // boolean
    private short status;             // smallint
    private Timestamp createdAt;      // timestamp
    private Timestamp modifiedAt;     // timestamp
    private String email;             // varchar(320)
    private Timestamp verifiedAt;     // timestamp (nullable)
    private String refreshToken;      // varchar(45)
    private String avatar;            // string
    private List<Role> roles;
    public User() {
    }

    public User(RID id, String hashPassword, String fullName, boolean deleted, short status,
                Timestamp createdAt, Timestamp modifiedAt, String email, Timestamp verifiedAt,
                String refreshToken, String avatar) {
        this.id = id;
        this.hashPassword = hashPassword;
        this.fullName = fullName;
        this.deleted = deleted;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.email = email;
        this.verifiedAt = verifiedAt;
        this.refreshToken = refreshToken;
        this.avatar = avatar;
    }



    // Getter và Setter cho từng thuộc tính
    public RID getId() {
        return id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setId(RID id) {
        this.id = id;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getVerifiedAt() {
        return verifiedAt;
    }

    public void setVerifiedAt(Timestamp verifiedAt) {
        this.verifiedAt = verifiedAt;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", hashPassword='" + hashPassword + '\'' +
                ", fullName='" + fullName + '\'' +
                ", deleted=" + deleted +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", email='" + email + '\'' +
                ", verifiedAt=" + verifiedAt +
                ", refreshToken='" + refreshToken + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }


    public static final class UserBuilder {
        private RID id;
        private String hashPassword;
        private String fullName;
        private boolean deleted;
        private short status;
        private Timestamp createdAt;
        private Timestamp modifiedAt;
        private String email;
        private Timestamp verifiedAt;
        private String refreshToken;
        private String avatar;
        private List<Role> roles;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder id(RID id) {
            this.id = id;
            return this;
        }

        public UserBuilder hashPassword(String hashPassword) {
            this.hashPassword = hashPassword;
            return this;
        }

        public UserBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public UserBuilder deleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public UserBuilder status(short status) {
            this.status = status;
            return this;
        }

        public UserBuilder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public UserBuilder modifiedAt(Timestamp modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder verifiedAt(Timestamp verifiedAt) {
            this.verifiedAt = verifiedAt;
            return this;
        }

        public UserBuilder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public UserBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public UserBuilder roles(List<Role> roles) {
            this.roles = roles;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setHashPassword(hashPassword);
            user.setFullName(fullName);
            user.setDeleted(deleted);
            user.setStatus(status);
            user.setCreatedAt(createdAt);
            user.setModifiedAt(modifiedAt);
            user.setEmail(email);
            user.setVerifiedAt(verifiedAt);
            user.setRefreshToken(refreshToken);
            user.setAvatar(avatar);
            user.setRoles(roles);
            return user;
        }
    }
}

