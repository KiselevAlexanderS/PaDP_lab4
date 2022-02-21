import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    private String packId;
    private String jsScript;
    private String funcName;
    private ArrayList<Test> tests;
}
