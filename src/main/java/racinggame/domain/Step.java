package racinggame.domain;

import java.util.Objects;

public class Step {

    private int step;

    public Step(int step) {
        this.step = step;
    }

    public void forward() {
    }

    public void forward(int step) {
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
}
