package javaDevelopment.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaDevelopment.northwind.business.abstracts.ProductService;
import javaDevelopment.northwind.core.utilities.results.DataResult;
import javaDevelopment.northwind.core.utilities.results.Result;
import javaDevelopment.northwind.core.utilities.results.SuccesResult;
import javaDevelopment.northwind.core.utilities.results.SuccessDataResult;
import javaDevelopment.northwind.dataAccess.abstracts.ProductDao;
import javaDevelopment.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {
	
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {	
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "is listed");		
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccesResult("product is added");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "is listed");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory(productName, categoryId), "is listed");	
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory(productName, categoryId), "is listed");	
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories), "is listed");	
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "is listed");	
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "is listed");	
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId), "is listed");	
	}

}
