package foo.bar.dao;

import foo.bar.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by blvp on 10.04.15.
 */
@Repository
public interface EventDao extends CrudRepository<Event, Long> {
}
