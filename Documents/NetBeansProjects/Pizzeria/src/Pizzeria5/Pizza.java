package Pizzeria5;

import pizzeria3.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.swing.JFileChooser;

/*
 Crea una clase Pizza con:
 - atributos: masa, tipo, tama?o y lista de ingredientes.
 - constantes (atributos private final ): uno por cada precio de los diferentes elementos
 - Define el constructor con los cuatro atributos.
 - métodos get/set correspondientes.
 */
public class Pizza implements Serializable {

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
    private final double IOLIVAS = 1;
    private final double TMEDIANA = 1.15;
    private final double TFAMILIAR = 1.30;
    private double ptotal = 0;
    private double pmasa = 0;
    private double ptipo = 0;
    private double pingrediente = 0;
   private int id=0;

    public Pizza(String masa, String tipo, List<String> listaIngredientes, String tamanio) {
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

    public double calcularPrecio() {
        //Masa
        pmasa=0;
        pmasa = MNORMAL;

        if (masa.equalsIgnoreCase("integral")) {
            pmasa = MINTEGRAL;
        }

        //Tipo
        ptipo=0;
        if (tipo.equalsIgnoreCase("barbacoa")) {
            ptipo += TBARBACOA;
        } else if (tipo.equalsIgnoreCase("Cuatro Quesos")) {
            ptipo += TCUATROQUESOS;
        } else if (tipo.equalsIgnoreCase("Mexicana")) {
            ptipo += TMEXICANA;
        } else {
            ptipo += TBASICA;
        }

        //Ingredientes
        pingrediente=0;
        for (String s : listaIngredientes) {
            if (s.equalsIgnoreCase("ninguno")) {
                pingrediente = 0;
            } else {
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
                if (s.equalsIgnoreCase("Jamón")) {
                    pingrediente += IJAMON;
                }
            }
        }

        //Tama?o
                ptotal = (pmasa + ptipo + pingrediente);
        if (tamanio.equalsIgnoreCase("mediana")) {
            ptotal = ptotal * TMEDIANA;
        } else if (tamanio.equalsIgnoreCase("familiar")) {
            ptotal = ptotal * TFAMILIAR;
        }

        return ptotal;
    }

    public String pedido() {
        double total;
        total=Math.rint(this.calcularPrecio()*100)/100;
        return    "Masa: " + getMasa() + "\t\t\t" + pmasa + "€\n"
                + "Tipo: " + getTipo() + "\t\t\t" + ptipo + "€\n"
                + "Ingredientes extra: " + getListaIngredientes() + "\t\t" + pingrediente + "€\n"
                + "Tamano: "+ "\t\t\t" +tamanio + "\n\n"
                + "TOTAL: "+ "\t\t\t" + total + "€";
    }
    
    public boolean generarTicket(){
        boolean respuesta=true;
        id++;
          try (FileWriter f = new FileWriter("Ticket "+Integer.toString(id)+".txt", true);
             PrintWriter pw = new PrintWriter(f)) {
            pw.println(this.pedido());
            

        } catch (IOException ex) {
            System.out.println("Error al abrir el fichero");
        }
          return respuesta;
    }}
  
    
