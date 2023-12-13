package bridge.model;

import bridge.BridgeGame;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Judgement {
    private final List<List<String>> result;
    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    public Judgement(List<List<String>> result) {
        this.result = result;
        result.add(upBridge);
        result.add(downBridge);
    }
    private boolean isMovingMatch(List<String> resultBridge, BridgeGame bridgeGame) {
        return Objects.equals(resultBridge.get(bridgeGame.getMovingCount() - 1), bridgeGame.getMoving());
    }
}