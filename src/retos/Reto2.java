package retos;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Oscar Garzon
 */
class Reto2 {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Este método es usado para solicitar datos al usuario
     *
     * @return Lectura de la siguiente linea del teclado
     */
    public String read() {
        return this.scanner.nextLine();
    }

    /**
     * método principal
     */
    public void run() {

        DBProduc db = new DBProduc();

        db.addProduc(new Producto(1, "manzanas", 5000, 25));
        db.addProduc(new Producto(2, "limones", 2300, 15));
        db.addProduc(new Producto(3, "peras", 2700, 33));
        db.addProduc( new Producto(4, "arandanos", 9300, 5));
        db.addProduc( new Producto(5, "tomates", 2100, 42));
        db.addProduc( new Producto(6, "fresas", 4100, 3));
        db.addProduc( new Producto(7, "helado", 4500, 41));
        db.addProduc( new Producto(8, "galletass", 500, 8));
        db.addProduc( new Producto(9, "chocolates", 3500, 80));
        db.addProduc( new Producto(10, "jamon", 15000, 10));

        String menu = read();
        String[] textProduc = read().split(" ");

        Producto produc = new Producto(Integer.parseInt(textProduc[0]), textProduc[1],
                Double.parseDouble(textProduc[2]), Integer.parseInt(textProduc[3]));

        switch (menu) {
            case "AGREGAR":
                System.out.println(db.addProduc(produc));
                break;
            case "BORRAR":
                System.out.println(db.deleteProduc(produc));
                break;
            case "ACTUALIZAR":
                System.out.println(db.UpdateProduc(produc));
                break;
        }
    }
}

class Producto {

    private int codigo;
    private String nombre;
    private double precio;
    private int inventario;

    public Producto(int codigo, String nombre, double precio, int inventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

}

class DBProduc {

    HashMap<Integer, Producto> listaproduc = new HashMap<>();

    public String addProduc(Producto produc) {
        if (VerifyExist(produc)) {
            return "ERROR";
        } else {
            listaproduc.put(produc.getCodigo(), produc);
            return resultado() + "";
        }
    }

    public String deleteProduc(Producto produc) {
        if (VerifyExist(produc)) {
            listaproduc.remove(produc.getCodigo());
            return resultado() + "";
        } else {
            return "ERROR";
        }
    }

    public String UpdateProduc(Producto produc) {
        if (VerifyExist(produc)) {
            listaproduc.replace(produc.getCodigo(), produc);
            return resultado() + "";
        } else {
            return "ERROR";
        }
    }

    public double resultado() {
        double total = 0;

        for (Producto producto : listaproduc.values()) {

            total += (producto.getPrecio() * producto.getInventario());
        }
        return total;
    }

    public boolean VerifyExist(Producto produc) {
        if (listaproduc.containsKey(produc.getCodigo())) {
            return true;
        } else {
            return false;
        }
    }
}
