package FabricaDeTrajes;
/**
 *
 * @author JulianAndresGuzmanCuellar 20232215518
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;

//Se implemento IGestorDeArchivos para poder modificar los componentes añadidos

public class Componente implements IGestorDeArchivos<Componente> {
//Colocamos los atributos en protected
     int id;
    protected String nombre;
    protected String talla;
    protected String color;
    protected boolean escomunitario;
    protected  double precio;

    public Componente(int id, String nombre, String talla, String color, boolean escomunitario, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.escomunitario = escomunitario;
        this.precio = precio;
    }
    
    //Se crea un nuevo metodo que permite poder modificar los componentes creados
    
public void actualizar(Componente nuevoComponente) {
    this.setNombre(nuevoComponente.getNombre());
    this.setTalla(nuevoComponente.getTalla());
    this.setColor(nuevoComponente.getColor());
    this.setEscomunitario(nuevoComponente.isEscomunitario());
    this.setPrecio(nuevoComponente.getPrecio());
}

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEscomunitario() {
        return escomunitario;
    }

    public void setEscomunitario(boolean escomunitario) {
        this.escomunitario = escomunitario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return " Nombre:" + nombre + "         id:" + id + "        talla:" + 
                talla + "           color:" + color + "         es comunitario:" + 
                escomunitario + "         precio:" +  precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Componente otro) {
        return Integer.compare(this.id, otro.id);
    }
    
    //En esta parte de componente se actualiza unos cambios para que los metodos puedan actualizar y borrar componente
    
    
    public void guardarObjeto(Componente objeto) throws IOException {
        try (FileWriter writer = new FileWriter("componentes.txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            printWriter.println(objeto.getId() + "," + objeto.getNombre() + "," + objeto.getTalla() + "," + objeto.getColor() + "," + objeto.isEscomunitario() + "," + objeto.getPrecio());
        }
    }

    public List<Componente> obtenerTodosLosObjetos() {
    List<Componente> componentes = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("componentes.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] partes = line.split(",");
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String talla = partes[2];
            String color = partes[3];
            boolean escomunitario = Boolean.parseBoolean(partes[4]);
            double precio = Double.parseDouble(partes[5]);
            Componente componente = new Componente(id, nombre, talla, color, escomunitario, precio);
            componentes.add(componente);
        }
    } catch (FileNotFoundException e) {
        System.out.println("El archivo componentes.txt no existe. Creando archivo...");
        // Aquí puedes agregar código para crear el archivo si no existe
    } catch (IOException e) {
        e.printStackTrace();
    }
    return componentes;
}
///////////////////////////////////////////////////////////////////////////////7
    
    
    
    public Optional<Componente> obtenerObjeto(Predicate<Componente> criterio) {
        List<Componente> componentes = obtenerTodosLosObjetos();
        return componentes.stream().filter(criterio).findFirst();
    }

   public void actualizarObjeto(Componente objetoAntiguo, Componente objetoNuevo) {
    List<Componente> componentes = obtenerTodosLosObjetos();
    for (int i = 0; i < componentes.size(); i++) {
        if (componentes.get(i).getId() == objetoAntiguo.getId()) {
            componentes.set(i, objetoNuevo);
            break;
        }
    }
    guardarLista(componentes);
}

   public void eliminarObjeto(Componente objeto) {
    List<Componente> componentes = obtenerTodosLosObjetos();
    componentes.removeIf(c -> c.getId() == objeto.getId());
    guardarLista(componentes);
}

    private void guardarLista(List<Componente> componentes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("componentes.txt"))) {
            for (Componente componente : componentes) {
                writer.println(componente.getId() + "," + componente.getNombre() + "," + componente.getTalla() + "," + componente.getColor() + "," + componente.isEscomunitario() + "," + componente.getPrecio());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void setEsComunitario(boolean parseBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

 


