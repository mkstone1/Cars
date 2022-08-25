package dat3.Cars.repository;

import dat3.Cars.entity.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {
}
