package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.QLSVModel;
import Model.ThiSinh;
import Model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import Controler.QLSVControler;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textFieldMASV_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textFieldHovaTen;
	public JTextField textFieldNgaySinh;
	public JTextField textFieldMon1;
	public JTextField textFieldMon2;
	public JTextField textFieldMon3;
	public ButtonGroup buttonGroup;
	public JComboBox comboBoxQueQuan_1;
	public JRadioButton radionButtonNam;
	public JRadioButton radionButtonNu;
	public JComboBox comboBoxQueQuan_TimKiem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model= new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 612);
		
		Action action = new QLSVControler(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuOpen);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuClose);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuExit);
		
		JMenu mnNewMenu = new JMenu("About");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuAbout = new JMenuItem("About Me");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu.add(menuAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelQueQuan = new JLabel("Qu\u00EA Qu\u00E1n");
		labelQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelQueQuan.setBounds(10, 11, 62, 17);
		contentPane.add(labelQueQuan);
		
		JLabel labelMASV = new JLabel("M\u00E3 Sinh Vi\u00EAn");
		labelMASV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMASV.setBounds(210, 11, 76, 17);
		contentPane.add(labelMASV);
		
		textFieldMASV_TimKiem = new JTextField();
		textFieldMASV_TimKiem.setText("");
		textFieldMASV_TimKiem.setBounds(293, 11, 108, 22);
		contentPane.add(textFieldMASV_TimKiem);
		textFieldMASV_TimKiem.setColumns(10);
		
		JButton buttonTimKiem = new JButton("T??m ki???m");
		buttonTimKiem.addActionListener(action);
		buttonTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonTimKiem.setBounds(426, 4, 89, 30);
		contentPane.add(buttonTimKiem);
		
		JButton buttonHuyTim = new JButton("H???y t??m");
		buttonHuyTim.addActionListener(action);
		buttonHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonHuyTim.setBounds(537, 4, 89, 30);
		contentPane.add(buttonHuyTim);
		
		comboBoxQueQuan_TimKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBoxQueQuan_TimKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBoxQueQuan_TimKiem.addItem(tinh.getTenTinh());
		}
		comboBoxQueQuan_TimKiem.setBounds(80, 10, 120, 22);
		contentPane.add(comboBoxQueQuan_TimKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 39, 673, 4);
		contentPane.add(separator_1);
		
		JLabel labelDSSV = new JLabel("Danh s\u00E1ch sinh vi\u00EAn");
		labelDSSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDSSV.setBounds(10, 50, 122, 17);
		contentPane.add(labelDSSV);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M?? SV", "H??? v?? t??n", "Qu?? qu??n", "Ng??y sinh","Gi???i t??nh", "??i???m m??n 1", "??i???m m??n 2", "??i???m m??n 3"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 72, 653, 155);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 246, 673, 4);
		contentPane.add(separator_1_1);
		
		JLabel lblThngTinTh = new JLabel("Th??ng tin th?? sinh");
		lblThngTinTh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThngTinTh.setBounds(10, 258, 106, 17);
		contentPane.add(lblThngTinTh);
		
		JLabel labelMASV_1 = new JLabel("M?? sinh vi??n");
		labelMASV_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMASV_1.setBounds(10, 286, 76, 17);
		contentPane.add(labelMASV_1);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(93, 286, 108, 22);
		contentPane.add(textField_ID);
		
		JLabel labelHovaTen = new JLabel("H??? v?? t??n");
		labelHovaTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelHovaTen.setBounds(9, 324, 60, 17);
		contentPane.add(labelHovaTen);
		
		textFieldHovaTen = new JTextField();
		textFieldHovaTen.setColumns(10);
		textFieldHovaTen.setBounds(92, 324, 108, 22);
		contentPane.add(textFieldHovaTen);
		
		JLabel labelQuequan = new JLabel("Qu?? qu??n");
		labelQuequan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelQuequan.setBounds(10, 364, 60, 17);
		contentPane.add(labelQuequan);
		
		JLabel labelNgaySinh = new JLabel("Ng??y sinh");
		labelNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNgaySinh.setBounds(10, 404, 60, 17);
		contentPane.add(labelNgaySinh);
		
		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(93, 404, 108, 22);
		contentPane.add(textFieldNgaySinh);
		
		JLabel labelMon1 = new JLabel("M??n 1");
		labelMon1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMon1.setBounds(324, 326, 38, 17);
		contentPane.add(labelMon1);
		
		textFieldMon1 = new JTextField();
		textFieldMon1.setColumns(10);
		textFieldMon1.setBounds(407, 326, 108, 22);
		contentPane.add(textFieldMon1);
		
		JLabel labelM??n2 = new JLabel("M??n 2");
		labelM??n2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelM??n2.setBounds(324, 364, 38, 17);
		contentPane.add(labelM??n2);
		
		textFieldMon2 = new JTextField();
		textFieldMon2.setColumns(10);
		textFieldMon2.setBounds(407, 364, 108, 22);
		contentPane.add(textFieldMon2);
		
		JLabel labelMon3 = new JLabel("M??n 3");
		labelMon3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMon3.setBounds(324, 404, 38, 17);
		contentPane.add(labelMon3);
		
		textFieldMon3 = new JTextField();
		textFieldMon3.setColumns(10);
		textFieldMon3.setBounds(407, 404, 108, 22);
		contentPane.add(textFieldMon3);
		
		JLabel labelGioiTinh = new JLabel("Gi???i t??nh");
		labelGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGioiTinh.setBounds(324, 286, 48, 17);
		contentPane.add(labelGioiTinh);
		
		radionButtonNam = new JRadioButton("Nam");
		radionButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radionButtonNam.setBounds(406, 285, 53, 25);
		contentPane.add(radionButtonNam);
		
		radionButtonNu = new JRadioButton("N???");
		radionButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radionButtonNu.setBounds(461, 285, 43, 25);
		contentPane.add(radionButtonNu);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radionButtonNam);
		buttonGroup.add(radionButtonNu);
		JButton buttonThem = new JButton("Th??m");
		buttonThem.addActionListener(action);
		buttonThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonThem.setBounds(10, 449, 89, 30);
		contentPane.add(buttonThem);
		
		JButton buttonXoa = new JButton("X??a");
		buttonXoa.addActionListener(action);
		buttonXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonXoa.setBounds(127, 449, 89, 30);
		contentPane.add(buttonXoa);
		
		JButton buttonCapnhat = new JButton("C???p nh???t");
		buttonCapnhat.addActionListener(action);
		buttonCapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonCapnhat.setBounds(242, 449, 108, 30);
		contentPane.add(buttonCapnhat);
		
		JButton buttonLuu = new JButton("L??u");
		buttonLuu.addActionListener(action);
		buttonLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonLuu.setBounds(426, 499, 89, 30);
		contentPane.add(buttonLuu);
		
		JButton buttonHuy = new JButton("H???y b???");
		buttonHuy.addActionListener(action);
		buttonHuy.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonHuy.setBounds(537, 499, 89, 30);
		contentPane.add(buttonHuy);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 488, 673, 2);
		contentPane.add(separator_2);
		
		comboBoxQueQuan_1 = new JComboBox();
		ArrayList<Tinh> listTinh_1= Tinh.getDSTinh();
		comboBoxQueQuan_1.addItem("");
		for (Tinh tinh : listTinh) {
			comboBoxQueQuan_1.addItem(tinh.getTenTinh());
		}
		comboBoxQueQuan_1.setBounds(93, 363, 107, 22);
		contentPane.add(comboBoxQueQuan_1);
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textFieldHovaTen.setText("");
		textFieldMon1.setText("");
		textFieldMon2.setText("");
		textFieldMon3.setText("");
		textFieldNgaySinh.setText("");
		comboBoxQueQuan_1.setSelectedIndex(-1);
		buttonGroup.clearSelection();

	}
	
	public void themMotSinhVienVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[]{ts.getMaThiSinh()+"",
				  ts.getTenThiSinh(),
				  ts.getQueQuan().getTenTinh(),
				  ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1990),
				  (ts.isGioiTinh()?"Nam":"N???"),
				  ts.getDiemMon1()+"",
				  ts.getDiemMon2()+"",
				  ts.getDiemMon3()+"",});
	}

	public void themHoacCapNhatSinhVien(ThiSinh ts) {
		//L???y data table model ra
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(ts)) {
			System.out.println(this.model.kiemTraTonTai(ts));
			//n???u kh??ng t???n t???i th?? th???c hi???n thao t??c th??m
			this.model.insert(ts);
			this.themMotSinhVienVaoTable(ts);
		}else {
			//N???u t???n t???i th?? th???c hi???n thao t??c c???p nh???t
			this.model.update(ts);
			int soLuongDong= model_table.getRowCount();
			//l??i m?? th?? sinh ??? t???ng d??ng, n???u tr??ng th?? c???p nh???t t???i d??ng ????
			for(int i=0;i<soLuongDong;i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(ts.getMaThiSinh()+"")) {
					//c???p nh???t d??ng th??? i, c???t th??? 0
					model_table.setValueAt(ts.getMaThiSinh()+"",i,0);
					System.out.println("???? th??m ID");
					model_table.setValueAt(ts.getTenThiSinh()+"",i,1);
					System.out.println("???? th??m t??n");
					model_table.setValueAt(ts.getQueQuan()+"",i,2);
					System.out.println("???? th??m qu?? qu??n");
					model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1990)+"",i,3);
					System.out.println("???? th??m ng??y sinh");
					model_table.setValueAt(ts.isGioiTinh()?"Nam":"N???"+"",i,4);
					System.out.println("???? th??m gi???i t??nh");
					model_table.setValueAt(ts.getDiemMon1()+"",i,5);
					System.out.println("???? th??m m??n 1");
					model_table.setValueAt(ts.getDiemMon2()+"",i,6);
					System.out.println("???? th??m m??n 2");
					model_table.setValueAt(ts.getDiemMon3()+"",i,7);
					System.out.println("???? th??m m??n 3");

				}
			}

		}
		
	}


	public ThiSinh getThiSinhDangChon() {
		//L???y data table model ra
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
				
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1)+"";
		Tinh tinh= Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String textNgaySinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(textNgaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float mon1= Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float mon2= Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float mon3= Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, mon1, mon2, mon3);
		return ts;
	}
	
	public void HienThiThongTinThiSinhDaChon() {
		
		ThiSinh ts = getThiSinhDangChon();
		
		this.textField_ID.setText(ts.getMaThiSinh()+"");
		this.textFieldHovaTen.setText(ts.getTenThiSinh()+"");
		this.comboBoxQueQuan_1.setSelectedItem(ts.getQueQuan().getTenTinh());;
		String textNgaySinh = ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900);
		this.textFieldNgaySinh.setText(textNgaySinh+"");
		if(ts.isGioiTinh()) {
			radionButtonNam.setSelected(true);
		}else {
			radionButtonNu.setSelected(true);
		}
		this.textFieldMon1.setText(ts.getDiemMon1()+"");
		this.textFieldMon2.setText(ts.getDiemMon2()+"");
		this.textFieldMon3.setText(ts.getDiemMon3()+"");
		
	}

	public void ThucHienXoa() {
		//L???y data table model ra
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n x??a sinh vi??n ???? ch???n?");
		if(luaChon==JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
		
		System.out.println(model_table.getRowCount());
	}

	public void thucHienThemThiSinh() {
		//get d??? li???u
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textFieldHovaTen.getText();
		int queQuan = this.comboBoxQueQuan_1.getSelectedIndex()-1;
		//L???y t???nh
		Tinh tinh= Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textFieldNgaySinh.getText());
		boolean gioiTinh = true;
		if(this.radionButtonNam.isSelected()) {
			gioiTinh=true;
		}else if(this.radionButtonNu.isSelected()){
			gioiTinh=false;
		}
		float mon1= Float.valueOf(this.textFieldMon1.getText());
		float mon2= Float.valueOf(this.textFieldMon2.getText());
		float mon3= Float.valueOf(this.textFieldMon3.getText());

		//C?? h???t d??? li???u ??? tr??n r???i m???i t???o ra 1 th?? sinh m???i
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, mon1, mon2, mon3);
		this.themHoacCapNhatSinhVien(ts);
		System.out.println(this.model.kiemTraTonTai(ts));
	}

	public void thucHienTim() {
		//tr?????c khi th???c hi???n t??m ph???i g???i h??m h???y t??m ki???m ????? quay l???i tr???ng th??i
		//ban ?????u r???i m???i ??i t??m ki???m
		this.huyTimKiem();
		
		//th???c hi???n t??m ki???m
		int queQuan = this.comboBoxQueQuan_TimKiem.getSelectedIndex()-1;
		String MaThiSinhTimKiem= this.textFieldMASV_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		//int i_row = table.getSelectedRow();
		int soLuongDong= model_table.getRowCount();
		
		//????nh d???u th???ng n??o kh??ng thu???c th?? x??a
		Set<Integer> idCuaThiSinhCanXoa= new TreeSet<Integer>();
		
		if(queQuan>=0) { //N???u ngta ch???n t???nh th?? m???i l???y t???nh ra
			Tinh tinhDaChon= Tinh.getTinhById(queQuan);
			for(int i=0;i<soLuongDong;i++) {
				String tenTinh = model_table.getValueAt(i, 2)+""; //D??ng th??? i c???t th??? 2
				String id = model_table.getValueAt(i, 0)+"";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) { //b???ng nhau th?? th??i,
												//Kh??ng b???ng nhau th?? x??a d??ng ???? ??i
												//L??m cho table bi???n ?????i li??n t???c v?? b??? sai
					
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
					//????nh d???u sinh vi??n n??o ko thu???c t???nh ???? ch???n th?? x??a
	
				}
			}
		}
		if(MaThiSinhTimKiem.length()>0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(!id.equals(MaThiSinhTimKiem)) {//N???u m?? n?? kh??ng b???ng (!) th?? c???n x??a n?? ??i
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong= model_table.getRowCount(); //Khi x??a th?? s??? l?????ng d??ng s??? thay ?????i li??n t???c n??n c???n ph???i l???y ra
			
			//M???i 1 b???n SV c???n ph???i ki???m tra xem table c?? bi???n ?????i s??? l?????ng d??ng hay kh??ng
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable= model_table.getValueAt(i, 0)+"";
				System.out.println("idTrongTable: "+idTrongTable);
				if(idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("???? x??a: "+i);
					//Khi x??a th?? c?? th??? ph??t sinh l???i ngo???i l??? n??n c???n try catch
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break; //sau m???i l???n x??a ??i th?? c???n break ????? n?? ??i ra kh???i v??ng for b??n trong
				}
			}
		}
	}

	
	
	public void huyTimKiem() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong= model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				model_table.removeRow(0);
		}
		//v??o model l???y h???t t???t c??? sinh vi??n r???i add l???i v??o table
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			//tru?????c khi c?? thao t??c th??m th?? ph???i x??a h???t ra kh???i table
			//
			
			this.themMotSinhVienVaoTable(ts);
		}
	}
}
