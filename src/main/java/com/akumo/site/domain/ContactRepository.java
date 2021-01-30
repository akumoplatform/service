package com.akumo.site.domain;

import com.akumo.site.domain.entities.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    public List<Contact> findAll();

}
