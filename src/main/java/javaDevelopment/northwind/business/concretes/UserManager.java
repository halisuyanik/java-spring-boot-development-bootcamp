package javaDevelopment.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaDevelopment.northwind.business.abstracts.UserService;
import javaDevelopment.northwind.core.dataAccess.UserDao;
import javaDevelopment.northwind.core.entities.User;
import javaDevelopment.northwind.core.utilities.results.DataResult;
import javaDevelopment.northwind.core.utilities.results.Result;
import javaDevelopment.northwind.core.utilities.results.SuccesResult;
import javaDevelopment.northwind.core.utilities.results.SuccessDataResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccesResult("User added");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"User found");
	}

}
