package com.tts.data.repository;

import com.tts.data.repository.datasource.CloudDataSource;
import com.tts.domain.Customer;
import com.tts.domain.interactor.DefaultErrorConsumer;
import com.tts.domain.repository.CustomerRepository;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 18-Oct-17.
 */

public class CustomerDataRepository implements CustomerRepository {

    private final CloudDataSource cloudDataSource;

    public CustomerDataRepository(CloudDataSource cloudDataSource) {
        this.cloudDataSource = cloudDataSource;
    }

    @Override
    public Observable<Customer> user(String emailId, String password) {
        return cloudDataSource
                .login(emailId, password, true);
    }
}
