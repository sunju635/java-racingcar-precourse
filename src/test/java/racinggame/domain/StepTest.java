package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StepTest {
    private static final int END_INCLUSIVE = 9;
    private static final int FORWARD_MIN_STEP = 4;

    Step step;

    @BeforeEach
    void setUp() {
        step = new Step(0);
    }

    @Test
    void 멈춤() {
        for(int i = 0; i < FORWARD_MIN_STEP; i++) {
            step.forward(i);
            assertThat(step).isEqualTo(new Step(0));
        }
    }

    @Test
    void 전진() {
        int expectedStep = 0;
        for(int i = FORWARD_MIN_STEP; i <= END_INCLUSIVE; i++) {
            step.forward(i);
            expectedStep ++;
            assertThat(step).isEqualTo(new Step(expectedStep));
        }
    }
}
