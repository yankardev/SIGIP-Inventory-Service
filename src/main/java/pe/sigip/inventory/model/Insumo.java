package pe.sigip.inventory.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name="insumos")
public class Insumo {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @NotBlank @Column(nullable=false,length=120) private String nombre;
 @NotBlank @Column(nullable=false,length=40) private String unidadMedida;
 @NotNull @DecimalMin("0.00") @Column(nullable=false,precision=12,scale=2) private BigDecimal stock=BigDecimal.ZERO;
 @NotNull @DecimalMin("0.00") @Column(nullable=false,precision=12,scale=2) private BigDecimal stockMinimo=BigDecimal.ZERO;
 @Column(nullable=false) private LocalDateTime actualizadoEn=LocalDateTime.now();
 public Long getId(){return id;} public String getNombre(){return nombre;} public String getUnidadMedida(){return unidadMedida;} public BigDecimal getStock(){return stock;} public BigDecimal getStockMinimo(){return stockMinimo;} public LocalDateTime getActualizadoEn(){return actualizadoEn;}
 public void setId(Long v){id=v;} public void setNombre(String v){nombre=v;} public void setUnidadMedida(String v){unidadMedida=v;} public void setStock(BigDecimal v){stock=v;} public void setStockMinimo(BigDecimal v){stockMinimo=v;} public void setActualizadoEn(LocalDateTime v){actualizadoEn=v;}
}