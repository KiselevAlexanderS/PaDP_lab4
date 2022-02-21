import java.io.Serializable;
import java.util.ArrayList;

public class Result implements Serializable {
    private String packId;
    private ArrayList<String> results;

    public Result(String packId, ArrayList<String> results) {
        this.packId = packId;
        this.results = results;
    }

    public String getPackId() {
        return packId;
    }

    public ArrayList<String> getResults() {
        return results;
    }
}
