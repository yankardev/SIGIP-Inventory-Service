package pe.sigip.inventory.controller;
import jakarta.validation.Valid;
import pe.sigip.inventory.model.Insumo;
import pe.sigip.inventory.repository.InsumoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/inventario/insumos")
@CrossOrigin(origins="http://localhost:4200")
public class InsumoController {
 private final InsumoRepository repo;
 public InsumoController(InsumoRepository repo){this.repo=repo;}
 @GetMapping public List<Insumo> listar(){return repo.findAll();}
 @GetMapping("/{id}") public Insumo buscar(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Insumo no encontrado"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Insumo crear(@Valid @RequestBody Insumo i){i.setId(null);i.setActualizadoEn(LocalDateTime.now());return repo.save(i);}
 @PutMapping("/{id}") public Insumo actualizar(@PathVariable Long id,@Valid @RequestBody Insumo datos){Insumo i=buscar(id);i.setNombre(datos.getNombre());i.setUnidadMedida(datos.getUnidadMedida());i.setStockMinimo(datos.getStockMinimo());i.setActualizadoEn(LocalDateTime.now());return repo.save(i);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void eliminar(@PathVariable Long id){if(!repo.existsById(id))throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Insumo no encontrado");repo.deleteById(id);}
}