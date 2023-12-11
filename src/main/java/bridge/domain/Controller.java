package bridge.domain;

import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;

    public Controller(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void bridgeGameLogic() {
        outputView.startGameMessage();
        System.out.println();

        int bridgeSize = inputView.readBridgeSize();
        bridgeMaker.makeBridge(bridgeSize);
    }
}
