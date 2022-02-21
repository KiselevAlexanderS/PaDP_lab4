import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
    @JsonProperty("test") private List<> test;
}
