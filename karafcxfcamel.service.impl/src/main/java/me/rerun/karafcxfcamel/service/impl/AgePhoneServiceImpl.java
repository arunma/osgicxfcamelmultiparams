package me.rerun.karafcxfcamel.service.impl;

import me.rerun.karafcxfcamel.model.AgePhoneResult;
import me.rerun.karafcxfcamel.service.base.AgePhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgePhoneServiceImpl implements AgePhoneService {

    private static Logger logger= LoggerFactory.getLogger(AgePhoneServiceImpl.class);

    public AgePhoneServiceImpl() {
    }

    public AgePhoneResult getAgePhoneResult(String age, String phone){

        logger.info("before Returning Age Phone Result ");
        return new AgePhoneResult(age, phone);
    }
}
