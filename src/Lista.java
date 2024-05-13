public class Lista {
    private Nodo head;
    private Nodo tail;

    public Lista() {
        this.head = null;
        this.tail = null;
    }

    // ricerca
    public Nodo search(Nodo nodoCerc){
        if(head == null || head.getNext() == tail){
            return null;
        }
        Nodo curNodo = head;
        while(!curNodo.getNext().equals(tail)){
            if(curNodo.equals(nodoCerc)){
                return curNodo;
            }
            curNodo = curNodo.getNext();
        }
        return null;
    }

    // inserimento
    public void insInTesta(Nodo nuovoNodo) {
        if(head == null || head.getNext() == tail){
            head.setNext(nuovoNodo);
            nuovoNodo.setNext(tail);
            return;
        }
        nuovoNodo.setPrevious(null);
        nuovoNodo.setNext(head.getNext());

        head.setNext(nuovoNodo);
        nuovoNodo.getNext().setPrevious(nuovoNodo);
    }

    public void insInMezzo(Nodo nuovoNodo, Nodo nodoPrev){
        if(head == null || head.getNext() == tail){
            head.setNext(nuovoNodo);
            nuovoNodo.setNext(tail);
            return;
        }

        nuovoNodo.setPrevious(nodoPrev);
        nuovoNodo.setNext(nodoPrev.getNext());
        nodoPrev.setNext(nuovoNodo);
        nodoPrev.getNext().setPrevious(nuovoNodo);
    }

    public void insInCoda(Nodo nuovoNodo){
        if(head == null || head.getNext() == tail){
            head.setNext(nuovoNodo);
            nuovoNodo.setNext(tail);
            return;
        }
        nuovoNodo.setPrevious(tail.getPrevious());
        nuovoNodo.setNext(tail);
        tail.getPrevious().setNext(nuovoNodo);
    }

    // cancellazione
    public boolean cancInTesta(){
        if(head == null || head.getNext() == tail){
            return false;
        }
        head.setNext(head.getNext().getNext());
        head.getNext().getNext().setPrevious(null);
        return true;
    }

    public boolean cancInMezzo(Nodo nodoCerc){
        if(head == null || head.getNext() == tail){
            return false;
        }
        if(search(nodoCerc) == null){
            return false;
        }
        nodoCerc.getPrevious().setNext(nodoCerc.getNext());
        nodoCerc.getNext().setPrevious(nodoCerc.getPrevious());
        return true;
    }

    public boolean cancInCoda(){
        if(head == null || head.getNext() == tail){
            return false;
        }
        tail.setPrevious(tail.getPrevious().getPrevious());
        tail.getPrevious().getPrevious().setNext(tail);
        return true;
    }
}