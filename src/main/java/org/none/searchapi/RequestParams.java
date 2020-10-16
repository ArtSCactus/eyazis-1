package org.none.searchapi;

import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * @author ArtSCactus
 * @version 1.0
 */
public class RequestParams {
    private String query;
    @Nullable
    private String token;
    @Nullable
    private Integer num;

    public RequestParams() {
    }

    public RequestParams(String query, @Nullable String token, Integer num) {
        this.query = query;
        this.token = token;
        this.num = num;
    }

    @Override
    public String toString() {
        return "RequestParams{" +
                "query='" + query + '\'' +
                ", token='" + token + '\'' +
                ", num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestParams)) return false;
        RequestParams that = (RequestParams) o;
        return getNum() == that.getNum() &&
                Objects.equals(getQuery(), that.getQuery()) &&
                Objects.equals(getToken(), that.getToken());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuery(), getToken(), getNum());
    }

    @Nullable
    public String getToken() {
        return token;
    }

    public void setToken(@Nullable String token) {
        this.token = token;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}
