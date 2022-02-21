import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Storage extends AbstractActor {

    private Map<String, ArrayList<String>> store = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().
    }

    private void getSingleResult(SingleResult singleResult) {
        String packId = singleResult.getPackId();
        String result = singleResult.getResult();
        if (store.containsKey(packId)) {
            store.get(packId).add(result);
        } else {
            ArrayList<String> results = new ArrayList<>();
            results.add(result);
            store.put(packId, results);
        }
    }

    private void sendPackageResult(ResultRequest resultRequest) {
        String packId = resultRequest.getPackId();
    }
}
