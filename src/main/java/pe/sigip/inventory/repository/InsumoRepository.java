package pe.sigip.inventory.repository;
import pe.sigip.inventory.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InsumoRepository extends JpaRepository<Insumo,Long> {}