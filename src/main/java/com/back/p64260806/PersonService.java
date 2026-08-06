package com.back.p64260806;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(@Qualifier("personRepository") PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public int count() {
        return personRepository.count();
    }
}