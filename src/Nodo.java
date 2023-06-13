public class Nodo {
    String pregunta;
    Nodo si;
    Nodo no;
    String personaje;

    Nodo(String pregunta, Nodo si, Nodo no, String personaje) {
        this.pregunta = pregunta;
        this.si = si;
        this.no = no;
        this.personaje = personaje;
    }
}
