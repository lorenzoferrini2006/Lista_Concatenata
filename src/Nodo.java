public class Nodo {
    private Nodo previous;
    private Nodo next;
    private Persona info;

    public Nodo(Persona info){
        previous = null;
        next = null;
        this.info = info;
    }

    public Nodo getNext() {
        return next;
    }

    public Nodo getPrevious() {
        return previous;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
}