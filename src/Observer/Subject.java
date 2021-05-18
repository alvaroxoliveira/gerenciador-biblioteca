package Observer;

public interface Subject {
        void adicionarObserver(Observer observer);
        void notificarObserver();
}
