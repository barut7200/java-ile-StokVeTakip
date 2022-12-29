package tr.com.atayazilim.interfaces;

import java.util.List;

public interface DALInterfaces<T> { //t�m dal katmanlar�n� tek interface �zerinden yazmak icin generic yapt�k
	
	 void Insert(T entity);
	 List<T> GetAll();
	 void Delete (T entity);
	 void Update(T entity);
	 List<T> GetById(int id);

}
