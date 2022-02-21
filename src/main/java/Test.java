import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Test implements Serializable {
    private String testname;
    private String expectedResult;
    private Object[] params;
    private String result;

    @JsonCreator
    Test(@JsonProperty("testname")String testname, @JsonProperty("expectedResult") String expectedResult, @JsonProperty("params") Object[] params) {
        this.testname = testname;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public Object[] getParams() {
        return params;
    }

    public String getTestname() {
        return testname;
    }

    public String getResult() {
        return result;
    }
}
