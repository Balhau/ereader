package org.balhau.books.domain;

import com.google.gson.Gson;

/**
 * Created by vitorfernandes on 10/9/16.
 */
public interface WithSerialization {
    default String toJSON(){
        Gson gs = new Gson();
        return gs.toJson(this);
    }
}
