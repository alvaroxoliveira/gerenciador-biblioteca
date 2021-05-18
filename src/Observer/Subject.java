package Observer;

public interface Subject {
        public void adicionarObserver(Observer observer);
        public void notificarObserver();
}
