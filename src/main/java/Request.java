import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    private String packId;
    private String jsScript;
    private String funcName;
    private ArrayList<Test> tests;

    @JsonCreator
    Request(@JsonProperty("packId")String packId, @JsonProperty("jsScript") String jsScript, @JsonProperty("funcName") String funcName, @JsonProperty("tests")ArrayList<Test> tests) {
        this.funcName = funcName;
        this.packId = packId;
        this.jsScript = jsScript;
        this.tests = tests;
    }

    public String getFuncName() {
        return funcName;
    }

    public String getPackId() {
        return packId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public ArrayList<Test> getTests() {
        return tests;
    }
}
