package Model.Interfaces.util;

/**
 * Interface for the Observable class
 */
public interface IObservable<T> {
    void subscribe(IObserver<T> observer);
    void notifyObservers(T t);
}
