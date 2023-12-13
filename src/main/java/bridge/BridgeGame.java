package bridge;

import bridge.domain.ErrorMessage;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String moving;
    private static int movingCount;

    public BridgeGame(String moving) {
        validator(moving);
        this.moving = moving;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move() {
        movingCount += 1;
    }

    private void validator(String moving) {
        if (!isValidValue(moving)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VALUE.getErrorMessage());
        }
    }

    private boolean isValidValue(String moving) {
        return Objects.equals(moving, "U") || Objects.equals(moving, "D");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
