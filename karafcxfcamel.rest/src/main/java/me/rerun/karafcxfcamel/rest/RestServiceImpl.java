package me.rerun.karafcxfcamel.rest;

import me.rerun.karafcxfcamel.model.AgePhoneResult;
import me.rerun.karafcxfcamel.model.NameEmailResult;
import me.rerun.karafcxfcamel.service.base.AgePhoneService;
import me.rerun.karafcxfcamel.service.base.NameEmailService;
import me.rerun.karafcxfcamel.service.impl.AgePhoneServiceImpl;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RestServiceImpl implements RestService {

    private static Logger logger= LoggerFactory.getLogger(AgePhoneServiceImpl.class);

    private NameEmailService nameEmailService;
    private AgePhoneService agePhoneService;

    public RestServiceImpl(){
    }

    //Do nothing. Camel intercepts and routes the requests
    public String sourceResultsFromTwoSources() {
        return null;
    }


    public NameEmailResult getNameEmailResult(Exchange exchange){
        logger.info("Invoking getNameEmailResult from RestServiceImpl");

        String name=getFirstEntrySafelyFromList(exchange.getProperty("name", List.class));
        String email=getFirstEntrySafelyFromList(exchange.getProperty("email", List.class));

        return nameEmailService.getNameAndEmail(name, email);
    }


    public AgePhoneResult getAgePhoneResult(Exchange exchange){
        logger.info("Invoking getAgePhoneResult from RestServiceImpl");

        String age=getFirstEntrySafelyFromList(exchange.getProperty("age", List.class));
        String phone=getFirstEntrySafelyFromList(exchange.getProperty("phone", List.class));

        return agePhoneService.getAgePhoneResult(age, phone);
    }

    public NameEmailService getNameEmailService() {
        return nameEmailService;
    }

    public AgePhoneService getAgePhoneService() {
        return agePhoneService;
    }

    public void setNameEmailService(NameEmailService nameEmailService) {
        this.nameEmailService = nameEmailService;
    }

    public void setAgePhoneService(AgePhoneService agePhoneService) {
        this.agePhoneService = agePhoneService;
    }

    private String getFirstEntrySafelyFromList(List<String> list){

        if (list!=null && !list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
}
