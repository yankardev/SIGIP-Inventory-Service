package pe.sigip.inventory.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
@RestController
public class InventoryHealthController {
 @GetMapping("/api/inventory/health")
 public Map<String,String> health(){return Map.of("servicio","SIGIP Inventory Service","estado","activo");}
}