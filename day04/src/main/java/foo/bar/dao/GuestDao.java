package foo.bar.dao;

import foo.bar.model.GuestInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by blvp on 10.04.15.
 */
@Repository
public interface GuestDao extends CrudRepository<GuestInfo, Long> {
}
