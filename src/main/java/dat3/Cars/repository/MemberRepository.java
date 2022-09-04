package dat3.Cars.repository;

import dat3.Cars.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
