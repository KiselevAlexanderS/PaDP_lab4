public class SingleResult {
    private String packId;
    private String result;

    public SingleResult(String packId, String result) {
        this.packId = packId;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getPackId() {
        return packId;
    }
}
