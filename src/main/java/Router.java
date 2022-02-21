import akka.actor.*;
import akka.routing.RoundRobinPool;
import scala.sys.Prop;


public class Router extends AbstractActor {

    private final ActorRef storageActor;
    private final ActorRef testActor;
    private SupervisorStrategy supervisorStrategy;


    Router() {
        this.storageActor = getContext().actorOf(Props.create(Storage.class, Storage::new), "Storage");
        this.testActor = getContext().actorOf(new RoundRobinPool(5).props(Props.create(ResultActor.class, storageActor)), "router");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().match(ResultRequest.class, this::receiveResultRequest).match(PackageTest.class, this::receivePackageTest).build();
    }

    private void receiveResultRequest(ResultRequest resultRequest) {
        this.storageActor.tell(resultRequest, getSender());
    }

    private void receivePackageTest(PackageTest tests) {
        tests.getTest().stream().map(test -> new Request(tests.getPackId(), tests.getFuncName(), tests.getJsScript(), test.getExpectedResult(), test.getParams())).forEach(msg -> this.testActor.tell(msg, this.storageActor));
    }
}
