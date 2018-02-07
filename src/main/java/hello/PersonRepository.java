package hello;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

	List<Person> findByLastName(@Param("name") String name);


	// find city by its name or country with "like
	@Query("SELECT c FROM Person c LEFT JOIN WHERE " +
			"LOWER(c.firstName) LIKE LOWER(CONCAT('%',:searchCity, '%'))")
	public List<Person> findBySearchFirstName(@Param("searchCity") String searchCity);

}
