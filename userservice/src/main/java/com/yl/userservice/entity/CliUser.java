package com.yl.userservice.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author yangjie
 * 2019/12/15 12:40
 */
public class CliUser implements Serializable {

    private String username;
    private String password;
    private String client_id;
    private String client_secret;
    private String grant_type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CliUser cliUser = (CliUser) o;
        return Objects.equals(username, cliUser.username) &&
                Objects.equals(password, cliUser.password) &&
                Objects.equals(client_id, cliUser.client_id) &&
                Objects.equals(client_secret, cliUser.client_secret) &&
                Objects.equals(grant_type, cliUser.grant_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, client_id, client_secret, grant_type);
    }

    @Override
    public String toString() {
        return "CliUser{" +
                "username='" + username + '\'' +
                ", client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", grant_type='" + grant_type + '\'' +
                '}';
    }
}
