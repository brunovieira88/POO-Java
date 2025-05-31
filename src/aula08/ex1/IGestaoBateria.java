package aula08.ex1;

public interface IGestaoBateria {
    double cargaDisponivel(); // devolve percentagem de carga restante
    void carregar(double percentagem); // acrescenta essa 'percentagem' de carga
    void limitarCargaMaxima(double percentagem); // limita a 'percentagem' de carga
}
