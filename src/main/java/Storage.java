import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends AbstractActor {

    private Map<String, ArrayList<Test>> store = new HashMap<>();

    private void input(Test test) {
        String packId = test.getParent().getPackId();

        if (store.containsKey(packId)) {
            store.get(packId).add(test);
        } else {
            ArrayList<Test> tests = new ArrayList<>();
            tests.add(test);
            store.put(packId, tests);
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(Test.class, test -> input(test)).match(String.class, id -> sender().tell());
    }
}
