package codingon.codingonspringbootjpa.repository;

import codingon.codingonspringbootjpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// JpaRepository
// - 인터페이스
// - JpaRepository<Type, ID>
// - T: 테이블에 매핑될 엔티티 클래스
// - ID: 엔티티의 기본 키 (primary key) 타입

// Repository: 
// - Entity 에 의해 생성된 DB 에 접근하는 메소드를 사용하기 위한 인터페이스
@Repository // Repository 계층임을 명시하는 클래스
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // 1)
    // existsByXXX()
    // - XXX: 컬럼명 UPPERCASE
    // - XXX 과 일치하는 컬럼이 있는지 boolean 반환
    boolean existsByName(String name);

    // 2)
    // findByXXX()
    // - XXX: 컬럼명 UPPERCASE
    List<UserEntity> findByName(String name);
    List<UserEntity> findByNameOrNickname(String name, String nickname);
    
    // 반환 형식은 Entity, List<Entity> 모두 가능
    // 단, 반환 된 값이 1개를 넘는데 Entity 로 넣으려고 하면 문제 발생

    Optional<UserEntity> findById(int id);

    // Query 어노테이션
    // - JpaRepository 인터페이스에 내장된 메소드만으로 해결이 안되는 경우, raw query 작성하게 해주는 어노테이션
    // - sql 문이 조금 다르다!
    // JPA 는 테이블이 아닌 객체 위주로 돌아가기 때문에 객체 (Entity) 이름으로 사용해야 함
    // ex. @Query("SELECT u FROM UserEntity u WHERE u.name=:name and u.nickname=:nickname")
    // - nativeQuery 옵션을 사용하면 찐 raw sql 사용 가능 -> DBMS 종속적이지 않은 ORM 특징을 살릴 수 없음
    // ex. @Query(nativeQuery = true, value="SELECT * from user WHERE u.name=:name and u.nickname=:nickname")
    @Query("select u from UserEntity u where u.name = :name") // UserEntity == u. 즉 UserEntity의 모든 필드 가져오겠다는 말
    UserEntity findName(String name);
    
}
