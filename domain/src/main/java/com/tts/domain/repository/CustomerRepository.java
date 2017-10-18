package com.tts.domain.repository;



import com.tts.domain.Customer;

import io.reactivex.Observable;

/**
 * Created by user on 18-Oct-17.
 */

public interface CustomerRepository {

    /**
     * Get an {@link Observable} which will emit a {@link Customer}.
     *
     * @param emailId The email id used to retrieve user data.
     * @param password The password used to retrieve user data.
     */
    Observable<Customer> user(String emailId, String password);
}
