package tr.com.atayazilim.complexcontract;

import java.util.Date;

public class SatisContractComplex {

	private int id;
	private String MusteriAdi;
	private String PersonelAdi;
	private String UrunAdi;
	private int adet;
	private String tarih;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMusteriAdi() {
		return MusteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		MusteriAdi = musteriAdi;
	}

	public String getPersonelAdi() {
		return PersonelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		PersonelAdi = personelAdi;
	}

	public String getUrunAdi() {
		return UrunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		UrunAdi = urunAdi;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	
	public Object[] getVeriler() {
		
		Object[] veriler = {id,MusteriAdi,PersonelAdi,UrunAdi,adet,tarih};
		return veriler;
	}
	
	@Override
	public String toString() {
		
		return MusteriAdi+""+PersonelAdi+""+UrunAdi;
	}
}
