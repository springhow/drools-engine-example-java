package com.springhow.examples.drools;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class DroolsUtil {

    private static final KieServices kieServices = KieServices.Factory.get();

    private static KieContainer loanApplicationKieContainer;

    static {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("loanApplication.drl"));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        loanApplicationKieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
    }

    public static KieSession getNewKieSessionForLoanApplication() {
        return loanApplicationKieContainer.newKieSession();
    }

    public static LoanApplication validateLoanApplication(LoanApplication loanApplication) {
        KieSession newKieSessionForLoanApplication = getNewKieSessionForLoanApplication();
        newKieSessionForLoanApplication.insert(loanApplication);
        newKieSessionForLoanApplication.fireAllRules();
        newKieSessionForLoanApplication.dispose();
        return loanApplication;
    }

}
