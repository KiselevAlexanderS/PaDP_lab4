import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends AbstractActor {

    private Map<String, ArrayList<Test>> store = new HashMap<>();

    private void input(Test test) {
        String packId = test.getParent().getPackId();

        
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
