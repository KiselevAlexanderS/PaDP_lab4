import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "packId",
        "jsScript",
        "funcName",
        "test"
})
public class PackageTest {
    @JsonProperty("packId") private String packId;
    @JsonProperty("jsScript") private String jsScript;
    @JsonProperty("funcName") private String funcName;
    @JsonProperty("test") private List<SingleTest> test;
    @JsonIgnore private Map<String,Object> unexpextedProps = new HashMap<>();

    @JsonAnySetter
    public void setUnexpextedProps(Map<String, Object> unexpextedProps) {
        this.unexpextedProps = unexpextedProps;
    }

    @JsonProperty("packId")
    public String getPackId() {
        return packId;
    }

    @JsonProperty("jsScript")
    public String getJsScript() {
        return jsScript;
    }

    @JsonProperty("packId")
    public String getPackId() {
        return packId;
    }

    @JsonProperty("packId")
    public String getPackId() {
        return packId;
    }
}
