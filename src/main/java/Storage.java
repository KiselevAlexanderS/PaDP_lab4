import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends AbstractActor {

    private Map<String, ArrayList<Test>> store = new HashMap<>();


    @Override
    public Receive createReceive() {
        return null;
    }
}
