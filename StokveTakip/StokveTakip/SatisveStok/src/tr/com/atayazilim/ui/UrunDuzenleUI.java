package tr.com.atayazilim.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tr.com.atayazilim.complexcontract.UrunlerContractComplex;
import tr.com.atayazilim.contract.MusteriContract;
import tr.com.atayazilim.contract.UrunlerContract;
import tr.com.atayazilim.dal.MusteriDAL;
import tr.com.atayazilim.dal.UrunlerDAL;
import tr.com.atayazilim.interfaces.uiInterfaces;


public class UrunDuzenleUI extends JDialog implements uiInterfaces {
	public static JComboBox urunlistBox;


	public UrunDuzenleUI() {
		
		initPencere();

	}

	@Override
	public void initPencere() {
		 
		JPanel panel = initPanel();
		add(panel);
		setTitle("�r�n D�zenle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createTitledBorder("�r�n D�zenleme Sayfas�"));
		JPanel ustPanel = new JPanel(new GridLayout(7, 3));
		ustPanel.setBorder(BorderFactory.createTitledBorder("�r�n D�zenle"));
		
		JLabel urunlistLabel = new JLabel("�r�n Listesi", JLabel.RIGHT);
		ustPanel.add(urunlistLabel);
		 urunlistBox = new JComboBox(new UrunlerDAL().GetAll2().toArray());
		ustPanel.add(urunlistBox);
		JLabel urunIdLabel = new JLabel("�r�n Id:", JLabel.RIGHT);
		ustPanel.add(urunIdLabel);
		JTextField urunIdField = new JTextField(10);
		ustPanel.add(urunIdField);

		JLabel urunAdiLabel = new JLabel("�r�n Ad�:", JLabel.RIGHT);
		ustPanel.add(urunAdiLabel);
		JTextField urunAdiField = new JTextField(10);
		ustPanel.add(urunAdiField);

		JLabel urunTarihLabel = new JLabel("Tarih:", JLabel.RIGHT);
		ustPanel.add(urunTarihLabel);
		JDateChooser urunTarihi = new JDateChooser();
		ustPanel.add(urunTarihi);

		JLabel urunFiyatLabel = new JLabel("Fiyat:", JLabel.RIGHT);
		ustPanel.add(urunFiyatLabel);

		JTextField urunFiyatField = new JTextField(10);
		ustPanel.add(urunFiyatField);

		JButton urunUpdateButton = new JButton("D�zenle");
		ustPanel.add(urunUpdateButton);
		urunUpdateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UrunlerContract contract = new UrunlerContract();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String date = format.format(urunTarihi.getDate());
				contract.setAdi(urunAdiField.getText());

				contract.setId(Integer.parseInt(urunIdField.getText()));
				// System.out.println(urunAdiBox.getSelectedItem().toString());
				contract.setFiyat(Float.parseFloat(urunFiyatField.getText()));
				// System.out.println(Float.parseFloat(urunFiyatField.getText()));
				contract.setTarih(date.toString());
				new UrunlerDAL().Update(contract);
				JOptionPane.showMessageDialog(null, "Ba�ar�l� bir �ekilde �r�n g�ncellendi.");
				int satir = urunlistBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					urunlistBox.removeAllItems();
					}
				
				for (UrunlerContractComplex compContract : new UrunlerDAL().GetAll2()){
					urunlistBox.addItem(compContract.getId() +" "+  compContract.getAdi());
					urunlistBox.getSelectedIndex();
				}
			}	
		});

		JButton urunDeleteButton = new JButton("Sil");
		ustPanel.add(urunDeleteButton);
		urunDeleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UrunlerContract contract = new UrunlerContract();
				contract.setId(Integer.parseInt(urunIdField.getText()));
				new UrunlerDAL().Delete(contract);
				JOptionPane.showMessageDialog(null, "Ba�ar�l� bir �ekilde �r�n Silindi");
				int satir = urunlistBox.getItemCount();
				for (int i = 0; i < satir; i++) {
					urunlistBox.removeAllItems();
					}
				
				for (UrunlerContractComplex compContract : new UrunlerDAL().GetAll2()){
					urunlistBox.addItem(compContract.getId() +" "+  compContract.getAdi());
					urunlistBox.getSelectedIndex();
				}
			}
		});
		panel.add(ustPanel);

		return panel;
	}

	@Override
	public JMenuBar initbar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
