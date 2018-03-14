package ru.gnkoshelev.j4net.sample.hash.spring.service.dto;

/**
 * Created by kgn on 14.03.2018.
 */
public class HashResponse {
    private final String hash;
    private final boolean success;

    public HashResponse(String hash, boolean success) {
        this.hash = hash;
        this.success = success;
    }

    public String getHash() {
        return hash;
    }

    public boolean isSuccess() {
        return success;
    }

    public static HashResponse ok(String hash) {
        return new HashResponse(hash, true);
    }

    public static HashResponse error() {
        return new HashResponse(null, false);
    }
}
