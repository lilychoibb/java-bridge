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

    public boolean gameResult(List<String> resultBridge, BridgeGame bridgeGame) {
        if (isMovingMatch(resultBridge, bridgeGame)) {
            processMatchingMove(bridgeGame);
            return true;
        } else {
            processNonMatchingMove(bridgeGame);
            return false;
        }
    }

    private boolean isMovingMatch(List<String> resultBridge, BridgeGame bridgeGame) {
        return Objects.equals(resultBridge.get(bridgeGame.getMovingCount() - 1), bridgeGame.getMoving());
    }

    private void processMatchingMove(BridgeGame bridgeGame) {
        if (Objects.equals(bridgeGame.getMoving(), "U")) {
            upBridge.add("O");
            downBridge.add(" ");
        }

        if (Objects.equals(bridgeGame.getMoving(), "D")) {
            upBridge.add(" ");
            downBridge.add("O");
        }
    }

    private void processNonMatchingMove(BridgeGame bridgeGame) {
        if (Objects.equals(bridgeGame.getMoving(), "U")) {
            upBridge.add("X");
            downBridge.add(" ");
        }

        if (Objects.equals(bridgeGame.getMoving(), "D")) {
            upBridge.add(" ");
            downBridge.add("X");
        }
    }

    public List<List<String>> getResult() {
        return result;
    }
}