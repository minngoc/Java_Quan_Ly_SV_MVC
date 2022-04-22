package Controler;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import Model.ThiSinh;
import Model.Tinh;
import View.QLSVView;

public class QLSVControler implements Action{
	QLSVView View;

	public QLSVControler(QLSVView view) {
		this.View = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		//JOptionPane.showMessageDialog(View,"Thêm sinh viên thành công!");
		
		if(actionCommand.equals("Thêm")) {
			this.View.xoaForm();
			this.View.model.setLuaChon("Thêm");
		}else if(actionCommand.equals("Lưu")) {
			
			try {
				this.View.thucHienThemThiSinh();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if (actionCommand.equals("Cập nhật")) {
			this.View.HienThiThongTinThiSinhDaChon();
		}else if (actionCommand.equals("Xóa")) {
			this.View.ThucHienXoa();
		}else if (actionCommand.equals("Hủy bỏ")) {
			this.View.xoaForm();
		}else if (actionCommand.equals("Tìm kiếm")) {
			this.View.thucHienTim();
		}else if (actionCommand.equals("Hủy tìm")) {
			this.View.huyTimKiem();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	
	
}
