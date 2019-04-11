package droolstest;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.Arrays;

public class DroolsTest {


    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        StatelessKieSession kSession = kieContainer.newStatelessKieSession();
        Applicant applicant = new Applicant("Mr John Smith", 25);
        Application application = new Application();

        System.out.println(applicant.isValid());
        kSession.execute(Arrays.asList(new Object[] {application, applicant}) );

        System.out.println(applicant.isValid() + " - " + application.isValid());


    }
}
