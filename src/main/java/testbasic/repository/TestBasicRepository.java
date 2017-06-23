package testbasic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import testbasic.model.User;

@Repository
public interface TestBasicRepository extends JpaRepository<User, Long>{

}
