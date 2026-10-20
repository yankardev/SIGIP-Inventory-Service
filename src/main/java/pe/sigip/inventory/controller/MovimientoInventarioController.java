package pe.sigip.inventory.controller;
import jakarta.validation.Valid;
import pe.sigip.inventory.model.Insumo;
import pe.sigip.inventory.model.MovimientoInventario;
import pe.sigip.inventory.repository.InsumoRepository;
import pe.sigip.inventory.repository.MovimientoInventarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/inventario/movimientos")
@CrossOrigin(origins="http://localhost:4200")
public class MovimientoInventarioController {
 private final MovimientoInventarioRepository movimientos;
 private final InsumoRepository insumos;
 public MovimientoInventarioController(MovimientoInventarioRepository movimientos, InsumoRepository insumos){this.movimientos=movimientos;this.insumos=insumos;}
 @GetMapping public List<MovimientoInventario> listar(){return movimientos.findAll();}
 @GetMapping("/insumo/{id}") public List<MovimientoInventario> porInsumo(@PathVariable Long id){if(!insumos.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Insumo no encontrado");return movimientos.findByInsumoIdOrderByFechaDesc(id);}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) @Transactional
 public MovimientoInventario crear(@Valid @RequestBody MovimientoInventario m){
  Insumo i=insumos.findById(m.getInsumoId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Insumo no encontrado"));
  if(!"ENTRADA".equals(m.getTipo()) && !"SALIDA".equals(m.getTipo())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Tipo debe ser ENTRADA o SALIDA");
  if("SALIDA".equals(m.getTipo()) && i.getStock().compareTo(m.getCantidad())<0) throw new ResponseStatusException(HttpStatus.CONFLICT,"Stock insuficiente");
  if("ENTRADA".equals(m.getTipo())) i.setStock(i.getStock().add(m.getCantidad())); else i.setStock(i.getStock().subtract(m.getCantidad()));
  i.setActualizadoEn(LocalDateTime.now()); insumos.save(i);
  m.setId(null); m.setFecha(LocalDateTime.now()); return movimientos.save(m);
 }
}