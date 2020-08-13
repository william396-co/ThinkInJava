package Enumerated;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T Competitor);
}
