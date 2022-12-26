package javaDevelopment.northwind.business.abstracts;

import javaDevelopment.northwind.core.entities.User;
import javaDevelopment.northwind.core.utilities.results.DataResult;
import javaDevelopment.northwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
