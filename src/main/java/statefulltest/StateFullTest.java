package statefulltest;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.HashMap;
import java.util.Map;

public class StateFullTest {

    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession();

        String[] names = new String[]{"kitchen", "bedroom", "office", "livingroom"};
        Map<String,Room> name2room = new HashMap<String,Room>();
        for( String name: names ){
            Room room = new Room( name );
            name2room.put( name, room );
            ksession.insert( room );
            if (name.equals("kitchen")) {
                Fire fire = new Fire(room);
                ksession.insert(fire);
            }
            Sprinkler sprinkler = new Sprinkler( room );
            ksession.insert( sprinkler );
        }

        ksession.fireAllRules();
    }
}
