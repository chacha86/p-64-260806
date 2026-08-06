package com.back.p64260806;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    @Transactional
    public int count() {
        return 3;
    }
}