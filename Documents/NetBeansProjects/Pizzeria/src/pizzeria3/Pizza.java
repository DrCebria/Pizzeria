package pizzeria3;


import java.util.ArrayList;
import java.util.List;

/*
Crea una clase Pizza con:
- atributos: masa, tipo, tama?o y lista de ingredientes.
- constantes (atributos private final ): uno por cada precio de los diferentes elementos
- Define el constructor con los cuatro atributos.
- métodos get/set correspondientes.

- método String pedido() que crea en una cadena de texto la composición del pedido junto a los
precios parciales y el precio total.
Basándote en un objeto pizza creado en tu ventana, utiliza el método calcularPrecio() para obtener el
precio final y mostrarlo en pantalla. Cambia las etiquetas del pedido por un JTextArea donde volcarás lo
devuelto por pedido()
 */

public class Pizza {
    private String masa;
    private String tipo;
    private String tamanio;
    private List<String> listaIngredientes;
    
    private final double mNormal=9.00;
    private final double mIntegral=9.5;
    private final double tBasica=3;
    private final double tCuatroQuesos=5;
    private final double tBarbacoa=7;
    private final double tMexicana=8.5;
    private final double iJamon=0.5;
    private final double iQueso=0.75;
    private final double iTomate=1.5;
    private final double iCebolla=2.5;
    private final double iOlivas=1;
    private final double tMediana=15/100;
    private final double tFamiliar=30/100;

    public Pizza(String masa, String tipo, String tamanio, List<String> listaIngredientes) {
        this.masa = masa;
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.listaIngredientes = listaIngredientes;
    }
    
    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public List<String> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(List<String> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

   

//- método Double calcularPrecio() que en función de los valores de los atributos calcule y
//devuelva el precio final de la pizza.
    
    public double calcularPrecio(String masa, String tipo, List<String> listaIngredientes, String tamanio){
        double precio=0;
          if (masa.equalsIgnoreCase("normal")){
              precio=mNormal;
          } else precio = mIntegral;
          
          if (tipo.equalsIgnoreCase("barbacoa")){
              precio=tBarbacoa;
          } else if (tipo.equalsIgnoreCase("Cuatro Quesos")){
              precio = tCuatroQuesos;
          } else if (tipo.equalsIgnoreCase("Mexicana")){
              precio= tMexicana;
          } else precio = tBasica;
          
          //Implementar esto mejor, falta la suma total y cero si esta seleccionado ninguno.
          for (String s : listaIngredientes) {
          if(s.equalsIgnoreCase("ninguno")){
              precio=precio+ 0;
          }
            if (s.equalsIgnoreCase("Tomate")){
              precio=precio + iTomate;
          } if (s.equalsIgnoreCase("Queso")){
              precio = precio + iQueso;
          } if (s.equalsIgnoreCase("Cebolla")){ 
              precio = precio + iCebolla;
          } if (s.equalsIgnoreCase("Olivas")){
              precio = precio +iOlivas;
          } if (s.equalsIgnoreCase("Tomate")){
              precio = precio + iJamon;
          }
          else {
              return precio= precio+0;
          }
          }  
          return precio;
    }
    


}
