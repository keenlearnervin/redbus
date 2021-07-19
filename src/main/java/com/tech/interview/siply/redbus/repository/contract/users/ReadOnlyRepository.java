package com.tech.interview.siply.redbus.repository.contract.users;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.util.List;

@NoRepositoryBean
public interface ReadOnlyRepository<T, ID> extends JpaRepository<T, ID> {
    @NonNull
    List<T> findAll();

    @NonNull
    List<T> findAll(Sort var1);

    @NonNull
    List<T> findAllById(@NonNull Iterable<ID> var1);

    @NonNull
    T getById(ID var1);

}
