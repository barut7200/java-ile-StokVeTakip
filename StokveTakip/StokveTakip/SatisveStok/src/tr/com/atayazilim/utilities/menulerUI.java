package tr.com.atayazilim.utilities;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import tr.com.atayazilim.contract.PersonelContract;
import tr.com.atayazilim.dal.YoneticiDAL;
import tr.com.atayazilim.ui.KategoriDuzenleUI;
import tr.com.atayazilim.ui.KategoriEkleUI;
import tr.com.atayazilim.ui.LoginUI;
import tr.com.atayazilim.ui.MusteriEkleUI;
import tr.com.atayazilim.ui.PersonelDuzenleUI;
import tr.com.atayazilim.ui.PersonelEkleUI;
import tr.com.atayazilim.ui.SifreIslemleriUI;
import tr.com.atayazilim.ui.UrunDuzenleUI;
import tr.com.atayazilim.ui.UrunEkleUI;
import tr.com.atayazilim.ui.YetkiEkleUI;

public class menulerUI {
	
public	static JMenuBar initbar() {
		
	
		JMenuBar bar = new JMenuBar();
		
		
		JMenu dosyaMenu = new JMenu("Dosya");
		bar.add(dosyaMenu);
		JMenuItem cikisItem = new JMenuItem("��k��");
		dosyaMenu.add(cikisItem);
		cikisItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		/*Urunler Menusu*/
		JMenu urunlerMenu = new JMenu("�r�nler");
		bar.add(urunlerMenu);
		JMenuItem urunEkleItem = new JMenuItem("�r�n Ekle");
		urunlerMenu.add(urunEkleItem);
		JMenuItem kategoriEkleItem = new JMenuItem("Kategori Ekle");
		urunlerMenu.add(kategoriEkleItem);
		urunlerMenu.addSeparator();
		JMenuItem urunDuzenleItem = new JMenuItem("�r�n� D�zenle");
		urunlerMenu.add(urunDuzenleItem);
		JMenuItem kategoriDuzenleItem = new JMenuItem("Kategori D�zenle");
		urunlerMenu.add(kategoriDuzenleItem);
		
		/*Personel Menusu*/
		JMenu personellerMenu = new JMenu("Personel ��lemleri");
		bar.add(personellerMenu);
		JMenuItem personelEkleItem = new JMenuItem("Personel Ekle");
		personellerMenu.add(personelEkleItem);
		JMenuItem yetkiEkleItem = new JMenuItem("Yetki Ekle");
		personellerMenu.add(yetkiEkleItem);
		JMenuItem sifreBelirleItem = new JMenuItem("�ifre Belirleme");
		personellerMenu.add(sifreBelirleItem);
		personellerMenu.addSeparator();
		JMenuItem personelDuzenItem = new JMenuItem("Personel D�zenle");
		personellerMenu.add(personelDuzenItem);
		JMenuItem yetkiDuzenlItem = new JMenuItem("Yetki D�zenle");
		personellerMenu.add(yetkiDuzenlItem);
		JMenuItem sifreDuzenleItem = new JMenuItem("�ifre D�zenle");
		personellerMenu.add(sifreDuzenleItem);
		
		/*M��teri Men�s�*/
		JMenu musterilerMenu = new JMenu("M��teriler");
		bar.add(musterilerMenu);
		JMenuItem musteriEkleItem = new JMenuItem("M��teri Ekle");
		musterilerMenu.add(musteriEkleItem);
		musterilerMenu.addSeparator();
		JMenuItem musteriDuzenleItem = new JMenuItem("M��teri D�zenle");
		musterilerMenu.add(musteriDuzenleItem);
		
		PersonelContract contract = (PersonelContract) LoginUI.emailBox.getSelectedItem();
		if(new YoneticiDAL().GetYetkiId(contract.getId()).getYetkiId()==2) {
			
			personellerMenu.hide();
			urunlerMenu.hide();
		}
		
		
		
		
		
		
		urunEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new UrunEkleUI();
						
					}
				});
				
			}
		});
		
		urunDuzenleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {	
						
						new UrunDuzenleUI();
					}
				});
			}
		});
		
		kategoriEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new KategoriEkleUI();
						
						
					
						
					}
				});
				
			}
		});
		
		kategoriDuzenleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new KategoriDuzenleUI();
					}
				});
			}
		});
		
		personelEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new PersonelEkleUI();
						
					}
				});
				
			}
		});
		
		personelDuzenItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonelDuzenleUI();
				
			}
		});
		yetkiEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						
						new YetkiEkleUI();
					}
				});
				
			}
		});
		
		sifreBelirleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new SifreIslemleriUI();
			}
		});
		
		musteriEkleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {

						new MusteriEkleUI();
					}
				});
				
		
				
			}
			
		});
		
		
		return bar;
	}

}
