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

    private String runTest(Test test) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(test.getParent().getJsScript());
        Invocable invocable = (Invocable) engine;

        return invocable.invokeFunction(test.getParent().getFuncName(), test.getParams()).toString();
    }

    private Test check(Test test) throws ScriptException, NoSuchMethodException {
        String result = runTest(test);
        test.setResult(result);

        return test;
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(Test.class, func -> storage.tell(check(func), ActorRef.noSender())).build();
    }
}
