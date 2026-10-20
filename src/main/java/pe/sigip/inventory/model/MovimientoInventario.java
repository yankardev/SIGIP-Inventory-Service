package pe.sigip.inventory.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name="movimientos_inventario")
public class MovimientoInventario {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotNull @Column(nullable=false) private Long insumoId;
 @NotBlank @Column(nullable=false,length=10) private String tipo;
 @NotNull @DecimalMin("0.01") @Column(nullable=false,precision=12,scale=2) private BigDecimal cantidad;
 @Column(length=250) private String observacion;
 @Column(nullable=false) private LocalDateTime fecha=LocalDateTime.now();
 public Long getId(){return id;} public Long getInsumoId(){return insumoId;} public String getTipo(){return tipo;} public BigDecimal getCantidad(){return cantidad;} public String getObservacion(){return observacion;} public LocalDateTime getFecha(){return fecha;}
 public void setId(Long v){id=v;} public void setInsumoId(Long v){insumoId=v;} public void setTipo(String v){tipo=v;} public void setCantidad(BigDecimal v){cantidad=v;} public void setObservacion(String v){observacion=v;} public void setFecha(LocalDateTime v){fecha=v;}
}