package pizzeria3;

import java.util.ArrayList;
import java.util.List;

/*
 Crea una clase Pizza con:
 - atributos: masa, tipo, tama?o y lista de ingredientes.
 - constantes (atributos private final ): uno por cada precio de los diferentes elementos
 - Define el constructor con los cuatro atributos.
 - métodos get/set correspondientes.
*/

public class Pizza {

    private String masa;
    private String tipo;
    private String tamanio;
    private List<String> listaIngredientes;

    private final double MNORMAL = 9.00;
    private final double MINTEGRAL = 9.5;
    private final double TBASICA = 3;
    private final double TCUATROQUESOS = 5;
    private final double TBARBACOA = 7;
    private final double TMEXICANA = 8.5;
    private final double IJAMON = 0.5;
    private final double IQUESO = 0.75;
    private final double ITOMATE = 1.5;
    private final double ICEBOLLA = 2.5;
    private final double IOLIVAS= 1;
    private final double TMEDIANA = 15 / 100;
    private final double TFAMILIAR = 30 / 100;

    public Pizza(String masa, String tipo,  List<String> listaIngredientes, String tamanio) {
        this.masa = masa;
        this.tipo = tipo;
        this.listaIngredientes = listaIngredientes;
        this.tamanio = tamanio;
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
    public double calcularPrecio() {
        double ptotal=0, pmasa = 0, ptipo=0, pingrediente=0;
         pmasa = MNORMAL;

        if (masa.equalsIgnoreCase("integral")) {
            pmasa = MINTEGRAL;
        }
        if (tipo.equalsIgnoreCase("barbacoa")) {
            ptipo += TBARBACOA;
        } else if (tipo.equalsIgnoreCase("Cuatro Quesos")) {
            ptipo += TCUATROQUESOS;
        } else if (tipo.equalsIgnoreCase("Mexicana")) {
            ptipo += TMEXICANA;
        } else {
            ptipo += TBASICA;
        }

        //Implementar esto mejor, falta la suma total y cero si esta seleccionado ninguno.
        for (String s : listaIngredientes) {
            if (s.equalsIgnoreCase("ninguno")) {
                pingrediente = 0;
            }else{
            if (s.equalsIgnoreCase("Tomate")) {
                pingrediente += ITOMATE;
            }
            if (s.equalsIgnoreCase("Queso")) {
                pingrediente += IQUESO;
            }
            if (s.equalsIgnoreCase("Cebolla")) {
                pingrediente += ICEBOLLA;
            }
            if (s.equalsIgnoreCase("Olivas")) {
                pingrediente += IOLIVAS;
            }
            if (s.equalsIgnoreCase("Tomate")) {
                pingrediente += IJAMON;
            }
            }
        }
        ptotal = pmasa+ptipo+pingrediente ;
        if (tamanio.equalsIgnoreCase("mediana")) {
             
            return ptotal= ptotal+(ptotal * 15 / 100) ;
            
        } else if (tamanio.equalsIgnoreCase("familiar")) {
            
            return ptotal= ptotal+(ptotal * 15 / 100) ;
            
        }
        
        return ptotal;
    }
 /*- método String pedido() que crea en una cadena de texto la composición del pedido junto a los
 precios parciales y el precio total.
 Basándote en un objeto pizza creado en tu ventana, utiliza el método calcularPrecio() para obtener el
 precio final y mostrarlo en pantalla. Cambia las etiquetas del pedido por un JTextArea donde volcarás lo
 devuelto por pedido()
 */
    public String pedido(){
        return "Masa: "+masa+"\n"+
                "Tipo: "+ tipo+"\n"+
                "Ingredientes: "+listaIngredientes.toString()+"\n"+
                "Tama?o: "+tamanio+"\n";    
                }


}
