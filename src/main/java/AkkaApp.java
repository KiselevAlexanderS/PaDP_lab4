import akka.actor.Actor;
import akka.actor.ActorSystem;
import akka.actor.ActorSystemImpl;
import akka.http.javadsl.server.AllDirectives;

public class AkkaApp extends AllDirectives {
    public static void main(String[] args) {
        ActorSystem actorsystem = ActorSystem.create("AkkaApp");

    }
}
