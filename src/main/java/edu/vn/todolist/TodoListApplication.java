package edu.vn.todolist;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class TodoListApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TodoListApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		// Lấy ra toàn bộ user trong db
		userRepository.findAll()
				.forEach(System.out::println);

		// Lưu user xuống database
		User user = userRepository.save(new User());
		// Khi lưu xong, nó trả về User đã lưu kèm theo Id.
		System.out.println("User had already been saved have ID: " + user.getId());
		Long userId = user.getId();
		// Cập nhật user.
		user.setUsername("DarkStar");
		user.setPassword("123456");
		// Update user
		// Lưu ý, lúc này đối tượng user đã có Id.
		// Nên nó sẽ update vào đối tượng có Id này
		// chứ không insert một bản ghi mới
		userRepository.save(user);

		// Query lấy ra user vừa xong để kiểm tra xem.
		User user2 = userRepository.findById(userId).get();
		System.out.println("User: " + user);
		System.out.println("User2: " + user2);

		// Xóa User khỏi DB
		// userRepository.delete(user);

		// In ra kiểm tra xem userId còn tồn tại trong DB không
		// User user3 = userRepository.findById(userId).orElse(null);
		// System.out.println("User3: " + user3);

		User newUser = userRepository.save(new User());
		newUser.setUsername("DarkStar1");
		newUser.setPassword("12345678");

		userRepository.save(newUser);
		// User usertest = userRepository.findUserByPasswordCustom("123456");
		// System.out.println(usertest);
		List<User> dUser = userRepository.findDistinctUserByUsername("DarkStar");
		for (User item : dUser) {
			System.out.println(item);
		}

	}

}
