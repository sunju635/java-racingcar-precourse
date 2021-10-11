package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StepTest {
    Step step;

    @BeforeEach
    void setUp() {
        step = new Step(0);
    }

    @Test
    void 전진() {
        int expectedStep = 0;
        for(int i = 0; i < 5; i++) {
            step.forward(i);
            expectedStep += i;
            assertThat(step).isEqualTo(new Step(expectedStep));
        }
    }
}
