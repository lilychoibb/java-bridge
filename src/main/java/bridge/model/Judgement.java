package bridge.model;
import java.util.ArrayList;
import java.util.List;
public class Judgement {
    private final List<List<String>> result;
    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    public Judgement(List<List<String>> result) {
        this.result = result;
        result.add(upBridge);
        result.add(downBridge);
    }
}