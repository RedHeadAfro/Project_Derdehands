package be.ehb.taak_v1.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataAO extends CrudRepository<Data, Integer> {
}
