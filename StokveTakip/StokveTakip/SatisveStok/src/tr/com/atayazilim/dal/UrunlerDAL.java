package tr.com.atayazilim.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.atayazilim.core.ObjectHelper;
import tr.com.atayazilim.interfaces.DALInterfaces;
import tr.com.atayazilim.complexcontract.UrunlerContractComplex;
import tr.com.atayazilim.contract.KategoriContract;
import tr.com.atayazilim.contract.UrunlerContract;

public class UrunlerDAL extends ObjectHelper implements DALInterfaces<UrunlerContract> {

	@Override
	public void Insert(UrunlerContract entity) {

		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Urunler(Adi, KategoriId, Tarih, fiyat)" 
			+ "VALUES('" + entity.getAdi()
			+ "', " + entity.getKategoriId() + ",'" + entity.getTarih() + "'," + entity.getFiyat() + ")");
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UrunlerContract> GetAll() {
List<UrunlerContract> datacontract = new ArrayList<UrunlerContract>();
		
		Connection connection = getConnection();
		UrunlerContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Urunler");
			while(resultSet.next()) {
				contract = new UrunlerContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setKategoriId(resultSet.getInt("KategoriId"));
				contract.setTarih(resultSet.getString("Tarih"));
				datacontract.add(contract);
				System.out.println(resultSet.getString("Adi"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
	}
	
	public List<UrunlerContractComplex> GetAll2(){
		List<UrunlerContractComplex> datacontract = new ArrayList<UrunlerContractComplex>();
		Connection connection = getConnection();
		UrunlerContractComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Urunler");
			while(resultSet.next()) {
				contract = new UrunlerContractComplex();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setKategoriId(resultSet.getInt("KategoriId"));
				contract.setTarih(resultSet.getString("Tarih"));
				datacontract.add(contract);
				System.out.println(resultSet.getString("Adi"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return datacontract;
		
	}
	

	@Override
	public void Delete(UrunlerContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			System.out.println(entity.getId());
			String sorgu = "Delete from urunler where Id=" + entity.getId();
			statement.executeUpdate(sorgu);
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Update(UrunlerContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			String sorgu = "Update urunler set Fiyat='" + entity.getFiyat() + "',Adi='" + entity.getAdi() + "',Tarih='"
					+ entity.getTarih() + "' where Id=" + entity.getId();
			statement.executeUpdate(sorgu);

			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<UrunlerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
