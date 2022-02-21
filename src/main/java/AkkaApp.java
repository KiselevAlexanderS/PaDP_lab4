import akka.NotUsed;
import akka.actor.*;
import akka.http.javadsl.Http;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.StreamRefMessages;
import akka.stream.javadsl.Flow;

public class AkkaApp extends AllDirectives {
    public static void main(String[] args) {
        ActorSystem actorsystem = ActorSystem.create("AkkaApp");
        final Http http = Http.get(actorsystem);
        final ActorMaterializer materia = ActorMaterializer.create(actorsystem);
        AkkaApp akkaApp = new AkkaApp();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = akkaApp.createRoute()
    }

    private Route createRoute(ActorSystem system) {
        ActorRef testsRouter = system.actorOf(Props.create(Router.class, Router::new));
        return route(
                post(() ->
                        entity(Jackson.unmarshaller(PackageTest.class), msg -> {
                            testsRouter.tell(msg, ActorRef.noSender());
                            return complete("Test started\n");
                        })),
                get(() ->
                        parameter("packId", packId -> {
                            Future<Object>
                        }))
        );
    }
}
