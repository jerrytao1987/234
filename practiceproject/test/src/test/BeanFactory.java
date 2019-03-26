package test;
@FunctionalInterface
public interface BeanFactory<T> {
	T get();
}
