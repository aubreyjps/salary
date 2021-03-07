package jsu.lj.salary.repository;

import jsu.lj.salary.pojo.User;
import jsu.lj.salary.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserRepository extends JpaRepository<User,String> {

    User findByPhonenum(String phonenum);

//    @Query("select phonenum,name from user")
//    List<UserInfo> findPhonenumAndName();
    @Query(value = "select name from user where phonenum=?1",nativeQuery = true)
    String findNameByPhonenum(String phonenum);


}
