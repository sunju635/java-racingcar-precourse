package racinggame.domain;

import nextstep.utils.Randoms;

import java.util.Objects;

/**
 * @author 정선주
 * @version 1.0
 * @since 1.0
 */
public class Step {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    private int step;

    public Step(int step) {
        this.step = step;
    }

    public void forward() {
        forward(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
    }

    public void forward(int step) {
        this.step += step;
    }

    public String getResultStep() {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < step; i++) {
            builder.append("-");
        }
        return  builder.toString();
    }

    public int getStep() {
        return step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step1 = (Step) o;
        return step == step1.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(step);
    }

    @Override
    public String toString() {
        return "Step{" +
                "step=" + step +
                '}';
    }
}
