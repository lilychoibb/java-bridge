package bridge.domain;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.model.BridgeSize;
import bridge.model.Judgement;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public Controller(OutputView outputView, InputView inputView, BridgeMaker bridgeMaker) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void bridgeGameLogic() {
        outputView.startGameMessage();
        System.out.println();

        BridgeSize bridgeSize = inputBridgeSize();

        List<String> resultBridge = bridgeMaker.makeBridge(bridgeSize.getBridgeSize());

        List<List<String>> result = new ArrayList<>();

        Judgement judgement = new Judgement(result);
        int gameTry = gameLoop(resultBridge, judgement);
        int tryCount = 1;

        while (gameTry == 1) {
            tryCount += 1;
            result = new ArrayList<>();
            judgement = new Judgement(result);
            gameTry = gameLoop(resultBridge, judgement);
        }

        if (gameTry == 2) {
            outputView.gameSuccessOrFail("실패");
        }

        if (gameTry == 3) {
            outputView.gameSuccessOrFail("성공");
        }

        outputView.tryCount(tryCount);
    }

    public int gameLoop(List<String> resultBridge, Judgement judgement) {
        for (int i = 0; i < resultBridge.size(); i++) {
            BridgeGame bridgeGame = inputBridgeMoving();
            BridgeGame.move();

            boolean gameResult = judgement.gameResult(resultBridge, bridgeGame);

            if (gameResult) {
                outputView.printMap(judgement);
            }

            if (!gameResult) {
                outputView.printMap(judgement);
                boolean retry = inputRetry(bridgeGame);
                if (retry) {
                    return 1;
                }
                outputView.printResult(judgement);
                return 2;
            }
        }
        outputView.printResult(judgement);
        return 3;
    }

    public boolean inputRetry(BridgeGame bridgeGame) {
        try {
            String retryOrQuit = inputView.readGameCommand();
            return bridgeGame.retry(retryOrQuit);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_VALUE.getErrorMessage());
            return inputRetry(bridgeGame);
        }
    }

    private BridgeSize inputBridgeSize() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            return new BridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.OUT_OF_RANGE.getErrorMessage());
            return inputBridgeSize();
        }
    }

    private BridgeGame inputBridgeMoving() {
        try {
            String bridgeMoving = inputView.readMoving();
            return new BridgeGame(bridgeMoving);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_VALUE.getErrorMessage());
            return inputBridgeMoving();
        }
    }
}