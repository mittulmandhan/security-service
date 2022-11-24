package com.liquorstore.client.service;

import com.liquorstore.client.utility.OtpStatus;

public interface TwilioSMSService {

    public OtpStatus sendSMS(String messageBody, String to);

}
