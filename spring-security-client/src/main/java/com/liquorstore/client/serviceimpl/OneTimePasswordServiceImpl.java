package com.liquorstore.client.serviceimpl;

import com.liquorstore.client.entity.OneTimePassword;
import com.liquorstore.client.repository.OneTimePasswordRepository;
import com.liquorstore.client.service.OneTimePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneTimePasswordServiceImpl implements OneTimePasswordService {

    @Autowired
    private OneTimePasswordRepository oneTimePasswordRepository;

    @Override
    public void save(OneTimePassword oneTimePassword) {
        oneTimePasswordRepository.save(oneTimePassword);
    }

}
