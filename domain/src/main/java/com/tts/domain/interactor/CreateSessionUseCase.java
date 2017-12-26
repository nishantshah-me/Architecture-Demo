package com.tts.domain.interactor;



import com.tts.domain.Session;
import com.tts.domain.repository.SessionRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by user on 18-Oct-17.
 */

public class CreateSessionUseCase extends UseCase<Session,CreateSessionUseCase.Params> {

    private final SessionRepository customerRepository;

    @Inject
    public CreateSessionUseCase(SessionRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    @Override
    Observable<Session> buildUseCaseObservable(Params params) {
        //Place where we decide who is going to execute our request.
        return customerRepository.createSession(params.email,params.password);
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
