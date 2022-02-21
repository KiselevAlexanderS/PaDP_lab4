import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ResultActor extends AbstractActor {

    private ActorRef storage;

    ResultActor(ActorRef storage) {
        this.storage = storage;
    }

    private String run(String funcName, String script, Object... args) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(script);
        Invocable invocable = (Invocable) engine;

        return invocable.invokeFunction(funcName, args).toString();
    }

    private void runTest(Request test) {
        String body;
        try {
            String actualResult = run(test.getFuncName(), test.getJsScript(), test.getParams());
            body = actualResult.equals(test.getExpectedResult()) ? "Answer is right" : "Wrong";
        } catch (ScriptException except) {
            body = "ScriptError :" + except.getLocalizedMessage();
        } catch (NoSuchMethodException except) {
            body = "Method does not exists :" + except.getLocalizedMessage();
        }
        storage.tell(new SingleResult(test.getPackId(), body), ActorRef.noSender());
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(Test.class, func -> storage.tell(check(func), ActorRef.noSender())).build();
    }
}
