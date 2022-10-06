package Model.Interfaces.util;

public interface IObservable<T> {
    void subscribe(IObserver<T> observer);
    void notifyObservers(T t);
}
