package com.tts.presentation.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by user on 04-Aug-17.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}

