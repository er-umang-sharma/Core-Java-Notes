package test;

@FunctionalInterface
public interface Convertable<F, T> {
    public T convert(F from);
}
