import java.io.Serializable;
import java.util.List;

public class Request implements Serializable {
    private String packId;
    private String jsScript;
    private String funcName;
    private String expectedResult;
    private List<Object> params;


    Request(String packId, String jsScript, String funcName, String expectedResult, List<Object> params) {
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

    public String getExpectedResult() {
        return expectedResult;
    }

    public List<Object> getParams() {
        return params;
    }
}
