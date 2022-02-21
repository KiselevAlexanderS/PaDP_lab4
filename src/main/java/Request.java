import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Request implements Serializable {
    private String packId;
    private String jsScript;
    private String funcName;
    private String expectedResult;
    private List<Object> params;

    @JsonCreator
    Request(@JsonProperty("packId")String packId, @JsonProperty("jsScript") String jsScript, @JsonProperty("funcName") String funcName, @JsonProperty("tests")ArrayList<Test> tests) {
        this.funcName = funcName;
        this.packId = packId;
        this.jsScript = jsScript;
        this.expectedResult = expectedResult;
        this.params = params;
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
