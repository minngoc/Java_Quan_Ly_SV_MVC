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
		
		JButton buttonTimKiem = new JButton("Tìm kiếm");
		buttonTimKiem.addActionListener(action);
		buttonTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonTimKiem.setBounds(426, 4, 89, 30);
		contentPane.add(buttonTimKiem);
		
		JButton buttonHuyTim = new JButton("Hủy tìm");
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
				"Mã SV", "Họ và tên", "Quê quán", "Ngày sinh","Giới tính", "Điểm môn 1", "Điểm môn 2", "Điểm môn 3"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 72, 653, 155);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 246, 673, 4);
		contentPane.add(separator_1_1);
		
		JLabel lblThngTinTh = new JLabel("Thông tin thí sinh");
		lblThngTinTh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThngTinTh.setBounds(10, 258, 106, 17);
		contentPane.add(lblThngTinTh);
		
		JLabel labelMASV_1 = new JLabel("Mã sinh viên");
		labelMASV_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMASV_1.setBounds(10, 286, 76, 17);
		contentPane.add(labelMASV_1);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(93, 286, 108, 22);
		contentPane.add(textField_ID);
		
		JLabel labelHovaTen = new JLabel("Họ và tên");
		labelHovaTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelHovaTen.setBounds(9, 324, 60, 17);
		contentPane.add(labelHovaTen);
		
		textFieldHovaTen = new JTextField();
		textFieldHovaTen.setColumns(10);
		textFieldHovaTen.setBounds(92, 324, 108, 22);
		contentPane.add(textFieldHovaTen);
		
		JLabel labelQuequan = new JLabel("Quê quán");
		labelQuequan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelQuequan.setBounds(10, 364, 60, 17);
		contentPane.add(labelQuequan);
		
		JLabel labelNgaySinh = new JLabel("Ngày sinh");
		labelNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelNgaySinh.setBounds(10, 404, 60, 17);
		contentPane.add(labelNgaySinh);
		
		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(93, 404, 108, 22);
		contentPane.add(textFieldNgaySinh);
		
		JLabel labelMon1 = new JLabel("Môn 1");
		labelMon1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMon1.setBounds(324, 326, 38, 17);
		contentPane.add(labelMon1);
		
		textFieldMon1 = new JTextField();
		textFieldMon1.setColumns(10);
		textFieldMon1.setBounds(407, 326, 108, 22);
		contentPane.add(textFieldMon1);
		
		JLabel labelMôn2 = new JLabel("Môn 2");
		labelMôn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMôn2.setBounds(324, 364, 38, 17);
		contentPane.add(labelMôn2);
		
		textFieldMon2 = new JTextField();
		textFieldMon2.setColumns(10);
		textFieldMon2.setBounds(407, 364, 108, 22);
		contentPane.add(textFieldMon2);
		
		JLabel labelMon3 = new JLabel("Môn 3");
		labelMon3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelMon3.setBounds(324, 404, 38, 17);
		contentPane.add(labelMon3);
		
		textFieldMon3 = new JTextField();
		textFieldMon3.setColumns(10);
		textFieldMon3.setBounds(407, 404, 108, 22);
		contentPane.add(textFieldMon3);
		
		JLabel labelGioiTinh = new JLabel("Giới tính");
		labelGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelGioiTinh.setBounds(324, 286, 48, 17);
		contentPane.add(labelGioiTinh);
		
		radionButtonNam = new JRadioButton("Nam");
		radionButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radionButtonNam.setBounds(406, 285, 53, 25);
		contentPane.add(radionButtonNam);
		
		radionButtonNu = new JRadioButton("Nữ");
		radionButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radionButtonNu.setBounds(461, 285, 43, 25);
		contentPane.add(radionButtonNu);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radionButtonNam);
		buttonGroup.add(radionButtonNu);
		JButton buttonThem = new JButton("Thêm");
		buttonThem.addActionListener(action);
		buttonThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonThem.setBounds(10, 449, 89, 30);
		contentPane.add(buttonThem);
		
		JButton buttonXoa = new JButton("Xóa");
		buttonXoa.addActionListener(action);
		buttonXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonXoa.setBounds(127, 449, 89, 30);
		contentPane.add(buttonXoa);
		
		JButton buttonCapnhat = new JButton("Cập nhật");
		buttonCapnhat.addActionListener(action);
		buttonCapnhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonCapnhat.setBounds(242, 449, 108, 30);
		contentPane.add(buttonCapnhat);
		
		JButton buttonLuu = new JButton("Lưu");
		buttonLuu.addActionListener(action);
		buttonLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
		buttonLuu.setBounds(426, 499, 89, 30);
		contentPane.add(buttonLuu);
		
		JButton buttonHuy = new JButton("Hủy bỏ");
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
				  (ts.isGioiTinh()?"Nam":"Nữ"),
				  ts.getDiemMon1()+"",
				  ts.getDiemMon2()+"",
				  ts.getDiemMon3()+"",});
	}

	public void themHoacCapNhatSinhVien(ThiSinh ts) {
		//Lấy data table model ra
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(ts)) {
			System.out.println(this.model.kiemTraTonTai(ts));
			//nếu không tồn tại thì thực hiện thao tác thêm
			this.model.insert(ts);
			this.themMotSinhVienVaoTable(ts);
		}else {
			//Nếu tồn tại thì thực hiện thao tác cập nhật
			this.model.update(ts);
			int soLuongDong= model_table.getRowCount();
			//lôi mã thí sinh ở từng dòng, nếu trùng thì cập nhật tại dòng đó
			for(int i=0;i<soLuongDong;i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(ts.getMaThiSinh()+"")) {
					//cập nhật dòng thứ i, cột thứ 0
					model_table.setValueAt(ts.getMaThiSinh()+"",i,0);
					System.out.println("đã thêm ID");
					model_table.setValueAt(ts.getTenThiSinh()+"",i,1);
					System.out.println("Đã thêm tên");
					model_table.setValueAt(ts.getQueQuan()+"",i,2);
					System.out.println("đã thêm quê quán");
					model_table.setValueAt(ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1990)+"",i,3);
					System.out.println("đã thêm ngày sinh");
					model_table.setValueAt(ts.isGioiTinh()?"Nam":"Nữ"+"",i,4);
					System.out.println("đã thêm giới tính");
					model_table.setValueAt(ts.getDiemMon1()+"",i,5);
					System.out.println("đã thêm môn 1");
					model_table.setValueAt(ts.getDiemMon2()+"",i,6);
					System.out.println("đã thêm môn 2");
					model_table.setValueAt(ts.getDiemMon3()+"",i,7);
					System.out.println("đã thêm môn 3");

				}
			}

		}
		
	}


	public ThiSinh getThiSinhDangChon() {
		//Lấy data table model ra
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
		//Lấy data table model ra
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa sinh viên đã chọn?");
		if(luaChon==JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
		
		System.out.println(model_table.getRowCount());
	}

	public void thucHienThemThiSinh() {
		//get dữ liệu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textFieldHovaTen.getText();
		int queQuan = this.comboBoxQueQuan_1.getSelectedIndex()-1;
		//Lấy tỉnh
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

		//Có hết dữ liệu ở trên rồi mới tạo ra 1 thí sinh mới
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, mon1, mon2, mon3);
		this.themHoacCapNhatSinhVien(ts);
		System.out.println(this.model.kiemTraTonTai(ts));
	}

	public void thucHienTim() {
		//trước khi thực hiện tìm phải gọi hàm hủy tìm kiếm để quay lại trạng thái
		//ban đầu rồi mới đi tìm kiếm
		this.huyTimKiem();
		
		//thực hiện tìm kiếm
		int queQuan = this.comboBoxQueQuan_TimKiem.getSelectedIndex()-1;
		String MaThiSinhTimKiem= this.textFieldMASV_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		//int i_row = table.getSelectedRow();
		int soLuongDong= model_table.getRowCount();
		
		//Đánh dấu thằng nào không thuộc thì xóa
		Set<Integer> idCuaThiSinhCanXoa= new TreeSet<Integer>();
		
		if(queQuan>=0) { //Nếu ngta chọn tỉnh thì mới lấy tỉnh ra
			Tinh tinhDaChon= Tinh.getTinhById(queQuan);
			for(int i=0;i<soLuongDong;i++) {
				String tenTinh = model_table.getValueAt(i, 2)+""; //Dòng thứ i cột thứ 2
				String id = model_table.getValueAt(i, 0)+"";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) { //bằng nhau thì thôi,
												//Không bằng nhau thì xóa dòng đó đi
												//Làm cho table biến đổi liên tục và bị sai
					
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
					//Đánh dấu sinh viên nào ko thuộc tỉnh đã chọn thì xóa
	
				}
			}
		}
		if(MaThiSinhTimKiem.length()>0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(!id.equals(MaThiSinhTimKiem)) {//Nếu mã nó không bằng (!) thì cần xóa nó đi
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong= model_table.getRowCount(); //Khi xóa thì số lượng dòng sẽ thay đổi liên tục nên cần phải lấy ra
			
			//Mỗi 1 bạn SV cần phải kiểm tra xem table có biến đổi số lượng dòng hay không
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable= model_table.getValueAt(i, 0)+"";
				System.out.println("idTrongTable: "+idTrongTable);
				if(idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("đã xóa: "+i);
					//Khi xóa thì có thể phát sinh lỗi ngoại lệ nên cần try catch
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break; //sau mỗi lần xóa đi thì cần break để nó đi ra khỏi vòng for bên trong
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
		//vào model lấy hết tất cả sinh viên rồi add lại vào table
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			//truước khi có thao tác thêm thì phải xóa hết ra khỏi table
			//
			
			this.themMotSinhVienVaoTable(ts);
		}
	}
}
