package api.supplier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

/**
 * @author codenozzle
 *
 */
@Transactional
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    List<Supplier> findByName(String title);
}
