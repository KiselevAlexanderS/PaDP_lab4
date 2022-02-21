import akka.actor.*;
import akka.routing.RoundRobinPool;
import scala.sys.Prop;


public class Router extends AbstractActor {

    private ActorRef storageActor;
    private ActorRef testActor;
    private SupervisorStrategy supervisorStrategy;


    Router() {
        this.storageActor = getContext().actorOf(Props.create(Storage.class, Storage::new), "Storage");
        this.testActor = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ResultActor.class, storageActor)), "router");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(ResultRequest.class, this::receiveResultRequest).match(PackageTest);
    }

    private void receiveResultRequest(ResultRequest resultRequest) {
        this.storageActor.tell(resultRequest, getSender());
    }
}
