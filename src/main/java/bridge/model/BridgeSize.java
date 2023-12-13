package bridge.model;

import bridge.domain.ErrorMessage;

public class BridgeSize {
    private final int bridgeSize;

    public BridgeSize(int bridgeSize) {
        validator(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    private void validator(int bridgeSize) {
        if (!isRangeValid(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getErrorMessage());
        }
    }

    private boolean isRangeValid(int bridgeSize) {
        return bridgeSize >= 3 && bridgeSize <= 20;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}