package Observer;

/*
* Interface Padrão de Projeto Observer
* */

public interface Subject {
    void adicionarObserver(Observer observer);
    void notificarObserver();
}
