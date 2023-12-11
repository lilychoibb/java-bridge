package bridge;

import bridge.domain.Controller;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), new BridgeMaker(new BridgeRandomNumberGenerator()));
        controller.bridgeGameLogic();
    }
}
