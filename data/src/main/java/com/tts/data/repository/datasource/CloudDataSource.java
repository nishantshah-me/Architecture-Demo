package com.tts.data.repository.datasource;


import com.tts.data.entity.CustomerEntity;
import com.tts.domain.Customer;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by webwerks1 on 11/7/17.
 */

public interface CloudDataSource {

    String BASE_URL = "http://xxx/";


    @FormUrlEncoded
    @POST("Login")
    Observable<Customer>
    login(@Field("email") String email,
          @Field("password") String password,
          @Field("remember_me") boolean remember_me);



}
