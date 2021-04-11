package com.hideoutlabs.inahurry.exceptions;


public interface CustomException<T,R> {
    R apply(T t) throws Exception;


}
