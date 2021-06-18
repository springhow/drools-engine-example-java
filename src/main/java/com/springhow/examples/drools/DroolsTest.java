package com.springhow.examples.drools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroolsTest {
    private static final Logger log = LoggerFactory.getLogger(DroolsTest.class);

    public static void main(String[] args) {

        LoanApplication loanApplication = new LoanApplication("John Doe", 19, 10000);
        log.info("Application status : {}", loanApplication.isApproved());
        DroolsUtil.validateLoanApplication(loanApplication);
        log.info("Application Approved? : {}", loanApplication.isApproved());
    }
}
