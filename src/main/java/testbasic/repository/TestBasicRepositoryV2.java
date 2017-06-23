/**
 * This is the Spring Boot POC using Spring boot, Spring Secure, and AWS 
 */
package testbasic.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import testbasic.model.User;
/**
 * @author x3fm
 *
 */
@Repository
public interface TestBasicRepositoryV2 extends CrudRepository<User, Long>{

}
