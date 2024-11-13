package entelect.training.incubator.spring.notification.sms.client.impl;

import entelect.training.incubator.spring.notification.sms.client.SmsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A custom implementation of a fictional SMS service.
 */
@Service
public class MoloCellSmsClient implements SmsClient {

    private final Logger LOG = LoggerFactory.getLogger(MoloCellSmsClient.class);

    @Override
    public void sendSms(String phoneNumber, String message) {
        LOG.info("Sending SMS, destination='{}', '{}'%n", phoneNumber, message);
    }
}
