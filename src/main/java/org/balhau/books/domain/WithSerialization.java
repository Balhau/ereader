package org.balhau.books.domain;

import com.google.gson.Gson;

/**
 * This enriches implementations with a default toString serialization mechanism
 */
public interface WithSerialization {
    default String toJSON(){
        Gson gs = new Gson();
        return gs.toJson(this);
    }
}
