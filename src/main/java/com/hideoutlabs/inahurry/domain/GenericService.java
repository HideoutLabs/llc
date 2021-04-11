package com.hideoutlabs.inahurry.domain;


import com.hideoutlabs.inahurry.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * @author Mohaemd Buhary
 * @since 05-04-2007
 */

public interface GenericService<T extends Object> {

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    void delete(Long id);

    void deleteInBatch(List<T> entities);

    T find(Long id) throws ResourceNotFoundException;

    List<T> findAll();
}