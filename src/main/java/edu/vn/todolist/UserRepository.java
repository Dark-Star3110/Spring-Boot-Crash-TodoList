package edu.vn.todolist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);

  User findByPassword(String password);

  List<User> findAllByUsername(String username);

  User findByUsernameAndPassword(String username, String password);

  // findDistinct là tìm kiếm và loại bỏ đi các đối tượng trùng nhau
  // trong trường hợp này để username là unique => thừa thãi => ngu
  List<User> findDistinctUserByUsername(String username);

  // IgnoreCase là tìm kiếm không phân biệt hoa thường, ví dụ ở đây tìm kiếm
  // lastname
  // username sẽ không phân biệt hoa thường
  List<User> findByUsernameIgnoreCase(String username);

  // AllIgnoreCase là không phân biệt hoa thường cho tất cả thuộc tính
  List<User> findByUsernameAndPasswordAllIgnoreCase(String username, String password);

  // OrderBy là cách sắp xếp thứ tự trả về
  // Sắp xếp theo Firstname ASC
  List<User> findByUsernameOrderByUsernameAsc(String username);

  // Sắp xếp theo Firstname Desc
  List<User> findByUsernameOrderByUsernameDesc(String username);

  // @Query("select u from users u where u.password = '123456'")
  // User findUserByPasswordCustom();
}
