import akka.NotUsed;
import akka.actor.Actor;
import akka.actor.ActorSystem;
import akka.actor.ActorSystemImpl;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class AkkaApp extends AllDirectives {
    public static void main(String[] args) {
        ActorSystem actorsystem = ActorSystem.create("AkkaApp");
        final Http http = Http.get(actorsystem);
        final ActorMaterializer materia = ActorMaterializer.create(actorsystem);
        AkkaApp akkaApp = new AkkaApp();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = akkaApp.c
    }
}
