package modelo;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "marcas")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    /// relacion de empresa 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    
    ///  relacion de 1 a muchos
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Producto> productos = new ArrayList<>();

    public Marca() {}

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public Empresa getEmpresa() { return empresa; }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    public void addProducto(Producto p) {
        productos.add(p);
        p.setMarca(this);
    }
    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}