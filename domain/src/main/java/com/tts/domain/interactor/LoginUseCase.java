package com.tts.domain.interactor;



import com.tts.domain.Customer;
import com.tts.domain.repository.CustomerRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by user on 18-Oct-17.
 */

public class LoginUseCase extends UseCase<Customer,LoginUseCase.Params> {

    private final CustomerRepository customerRepository;

    @Inject
    public LoginUseCase(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    Observable<Customer> buildUseCaseObservable(Params params) {
        //Place where we decide who is going to execute our request.
        return customerRepository.user(params.email,params.password);
    }

    public static final class Params {

        private final String email;
        private final String password;

        public Params(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public static Params forUser(String email,String password) {
            return new Params(email,password);
        }
    }
}
