package Java_day_030_;

import java.awt.*;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Vending_manager extends Frame implements ActionListener{
	
	String name[] = new String[6];
	String count[] = new String[6];
	String price[] = new String[6];
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	Label lbTitle = new Label("VENDINGM_MANAGER");
	Label name1 = new Label("상품1 명 :");
	Label name2 = new Label("상품2 명 :");
	Label name3 = new Label("상품3 명 :");
	Label name4 = new Label("상품4 명 :");
	Label name5 = new Label("상품5 명 :");
	Label name6 = new Label("상품6 명 :");
	Label Count1 = new Label("수량 :");
	Label Count2 = new Label("수량 :");
	Label Count3 = new Label("수량 :");
	Label Count4 = new Label("수량 :");
	Label Count5 = new Label("수량 :");
	Label Count6 = new Label("수량 :");
	Label price1 = new Label("가격 :");
	Label price2 = new Label("가격 :");
	Label price3 = new Label("가격 :");
	Label price4 = new Label("가격 :");
	Label price5 = new Label("가격 :");
	Label price6 = new Label("가격 :");

	TextField tfname1 = new TextField();
	TextField tfname2 = new TextField();
	TextField tfname3 = new TextField();
	TextField tfname4 = new TextField();
	TextField tfname5 = new TextField();
	TextField tfname6 = new TextField();
	TextField tfCount1 = new TextField();
	TextField tfCount2 = new TextField();
	TextField tfCount3 = new TextField();
	TextField tfCount4 = new TextField();
	TextField tfCount5 = new TextField();
	TextField tfCount6 = new TextField();
	TextField tfprice1 = new TextField();
	TextField tfprice2 = new TextField();
	TextField tfprice3 = new TextField();
	TextField tfprice4 = new TextField();
	TextField tfprice5 = new TextField();
	TextField tfprice6 = new TextField();
	
	Button btn1 = new Button("적용");
	Button btn2 = new Button("적용");
	Button btn3 = new Button("적용");
	Button btn4 = new Button("적용");
	Button btn5 = new Button("적용");
	Button btn6 = new Button("적용");
	Button btn7 = new Button("메인화면");
	
	Vending_manager() {
		super("manager");
		this.init();
		this.start();		
		this.setSize(750, 600);	
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		getData();
}

	void init() {
		Font font40 = new Font("SansSerif", Font.BOLD, 40);
		Font font30 = new Font("SansSerif", Font.BOLD, 30);
		Font font20b = new Font("SansSerif", Font.BOLD, 20);
		Font font20 = new Font("SansSerif", Font.PLAIN, 20);
		Font font15 = new Font("SansSerif", Font.PLAIN, 15);
		
		this.setLayout(null);	this.add(lbTitle);
		this.add(name1);		this.add(tfname1);		this.add(Count1);		this.add(tfCount1);
		this.add(price1);		this.add(tfprice1);		this.add(btn1);
		this.add(name2);		this.add(tfname2);		this.add(Count2);		this.add(tfCount2);
		this.add(price2);		this.add(tfprice2);		this.add(btn2);
		this.add(name3);		this.add(tfname3);		this.add(Count3);		this.add(tfCount3);
		this.add(price3);		this.add(tfprice3);		this.add(btn3);
		this.add(name4);		this.add(tfname4);		this.add(Count4);		this.add(tfCount4);
		this.add(price4);		this.add(tfprice4);		this.add(btn4);
		this.add(name5);		this.add(tfname5);		this.add(Count5);		this.add(tfCount5);
		this.add(price5);		this.add(tfprice5);		this.add(btn5);
		this.add(name6);		this.add(tfname6);		this.add(Count6);		this.add(tfCount6);
		this.add(price6);		this.add(tfprice6);		this.add(btn6);
		this.add(btn7);
		
		lbTitle.setBounds(50, 35, 600, 40);lbTitle.setFont(font40);
		
		name1.setBounds(50, 110, 95, 25);name1.setFont(font20b);
		tfname1.setBounds(155, 110, 120, 25);tfname1.setFont(font20b);
		Count1.setBounds(285, 110, 55, 25);Count1.setFont(font20b);
		tfCount1.setBounds(350, 110, 55, 25);tfCount1.setFont(font20b);
		price1.setBounds(415, 110, 55, 25);price1.setFont(font20b);
		tfprice1.setBounds(480, 110, 100, 25);tfprice1.setFont(font20b);
		btn1.setBounds(610, 110, 80, 25);btn1.setFont(font20b);
		
		name2.setBounds(50, 170, 95, 25);name2.setFont(font20b);
		tfname2.setBounds(155, 170, 120, 25);tfname2.setFont(font20b);
		Count2.setBounds(285, 170, 55, 25);Count2.setFont(font20b);
		tfCount2.setBounds(350, 170, 55, 25);tfCount2.setFont(font20b);
		price2.setBounds(415, 170, 55, 25);price2.setFont(font20b);
		tfprice2.setBounds(480, 170, 100, 25);tfprice2.setFont(font20b);
		btn2.setBounds(610, 170, 80, 25);btn2.setFont(font20b);
		
		name3.setBounds(50, 230, 95, 25);name3.setFont(font20b);
		tfname3.setBounds(155, 230, 120, 25);tfname3.setFont(font20b);
		Count3.setBounds(285, 230, 55, 25);Count3.setFont(font20b);
		tfCount3.setBounds(350, 230, 55, 25);tfCount3.setFont(font20b);
		price3.setBounds(415, 230, 55, 25);price3.setFont(font20b);
		tfprice3.setBounds(480, 230, 100, 25);tfprice3.setFont(font20b);
		btn3.setBounds(610, 230, 80, 25);btn3.setFont(font20b);
		
		name4.setBounds(50, 290, 95, 25);name4.setFont(font20b);
		tfname4.setBounds(155, 290, 120, 25);tfname4.setFont(font20b);
		Count4.setBounds(285, 290, 55, 25);Count4.setFont(font20b);
		tfCount4.setBounds(350, 290, 55, 25);tfCount4.setFont(font20b);
		price4.setBounds(415, 290, 55, 25);price4.setFont(font20b);
		tfprice4.setBounds(480, 290, 100, 25);tfprice4.setFont(font20b);
		btn4.setBounds(610, 290, 80, 25);btn4.setFont(font20b);
		
		name5.setBounds(50, 350, 95, 25);name5.setFont(font20b);
		tfname5.setBounds(155, 350, 120, 25);tfname5.setFont(font20b);
		Count5.setBounds(285, 350, 55, 25);Count5.setFont(font20b);
		tfCount5.setBounds(350, 350, 55, 25);tfCount5.setFont(font20b);
		price5.setBounds(415, 350, 55, 25);price5.setFont(font20b);
		tfprice5.setBounds(480, 350, 100, 25);tfprice5.setFont(font20b);
		btn5.setBounds(610, 350, 80, 25);btn5.setFont(font20b);
		
		name6.setBounds(50, 410, 95, 25);name6.setFont(font20b);
		tfname6.setBounds(155, 410, 120, 25);tfname6.setFont(font20b);
		Count6.setBounds(285, 410, 55, 25);Count6.setFont(font20b);
		tfCount6.setBounds(350, 410, 55, 25);tfCount6.setFont(font20b);
		price6.setBounds(415, 410, 55, 25);price6.setFont(font20b);
		tfprice6.setBounds(480, 410, 100, 25);tfprice6.setFont(font20b);
		btn6.setBounds(610, 410, 80, 25);btn6.setFont(font20b);
		btn7.setBounds(550, 470, 140, 35);btn7.setFont(font20b);
	}

	void start() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name1 = tfname1.getText();
		String name2 = tfname2.getText();
		String name3 = tfname3.getText();
		String name4 = tfname4.getText();
		String name5 = tfname5.getText();
		String name6 = tfname6.getText();
		
		String Count1 = tfCount1.getText();
		String Count2 = tfCount2.getText();
		String Count3 = tfCount3.getText();
		String Count4 = tfCount4.getText();
		String Count5 = tfCount5.getText();
		String Count6 = tfCount6.getText();
		
		String price1 = tfprice1.getText();
		String price2 = tfprice2.getText();
		String price3 = tfprice3.getText();
		String price4 = tfprice4.getText();
		String price5 = tfprice5.getText();
		String price6 = tfprice6.getText();
		if(e.getSource() == btn7) {
			Vending vdm = new Vending();
		}
		
		
		if(e.getSource() == btn1){
			if(spaceCheck(name1, Count1, price1))
			{
				return;
			}
			if(!spaceCheck(name1, Count1, price1))
			{
				update(1,name1, Count1, price1);
			}
		}
		if(e.getSource() == btn2){
			if(spaceCheck(name2, Count2, price2))
			{
				return;
			}
			if(!spaceCheck(name2, Count2, price2))
			{
				update(2,name2, Count2, price2);
			}
		}
		if(e.getSource() == btn3){
			if(spaceCheck(name3, Count3, price3))
			{
				return;
			}
			if(!spaceCheck(name3, Count3, price3))
			{
				update(3,name3, Count3, price3);
			}
		}
		if(e.getSource() == btn4){
			if(spaceCheck(name4, Count4, price4))
			{
				return;
			}
			if(!spaceCheck(name4, Count4, price4))
			{
				update(4,name4, Count4, price4);
			}
		}
		if(e.getSource() == btn5){
			if(spaceCheck(name5, Count5, price5))
			{
				return;
			}
			if(!spaceCheck(name5, Count5, price5))
			{
				update(5,name5, Count5, price5);
			}
		}
		if(e.getSource() == btn6){
			if(spaceCheck(name6, Count6, price6))
			{
				return;
			}
			if(!spaceCheck(name6, Count6, price6))
			{
				update(6,name6, Count6, price6);
			}
		}
	}
	boolean spaceCheck(String name, String count, String price)	
	{
		if(name.equals("")) {msg("커피명을 적어주세요."); return true;}
		if(count.equals("")) {msg("수량을 적어주세요.");   return true;}
		if(price.equals("")) {msg("가격을 적어주세요."); return true;}
		
		//여기까지왔다는건 공백이 아니라서 false~
		return false;
	}
	void getData() {
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"+ "useUnicode=true&characterEncoding=utf8";				
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select * from vanding_manage";
		try {
			conn = (Connection) DriverManager.getConnection(url, id, pass);
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(query);
			String result="";
			int coun=0;
			while (rs.next()) {
				
				name[coun] = rs.getString("name");
				count[coun] = rs.getString("count");
				price[coun] = rs.getString("price");				
				coun++;
			}
			tfname1.setText(name[0]);
			tfCount1.setText(count[0]);
			tfprice1.setText(price[0]);
			
			tfname2.setText(name[1]);
			tfCount2.setText(count[1]);
			tfprice2.setText(price[1]);
			
			tfname3.setText(name[2]);
			tfCount3.setText(count[2]);
			tfprice3.setText(price[2]);
			
			tfname4.setText(name[3]);
			tfCount4.setText(count[3]);
			tfprice4.setText(price[3]);
			
			tfname5.setText(name[4]);
			tfCount5.setText(count[4]);
			tfprice5.setText(price[4]);
			
			tfname6.setText(name[5]);
			tfCount6.setText(count[5]);
			tfprice6.setText(price[5]);
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}		
	}
	boolean update(int idx, String name, String count, String price)
	{
		Connection dc=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {		
		}
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+ "useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pass = "qwer";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
		
		String query = "update vanding_manage set name = ?, count = ?, price = ? where idx = ?";
	
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, count);
			pstmt.setString(3, price);
			pstmt.setInt(4, idx);			
			pstmt.executeUpdate();
			pstmt.close();
			msg("정보수정완료!");
		} catch (SQLException ee) {
			System.err.println("정보수정 실패!!:"+ee.getMessage());
			return false;
		}
		return true;
	}
	void msg(String msg) {
		
		final Dialog dlg = new Dialog(this, "알림", true);
		dlg.setLayout(null);	
		
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
		
		Label lbTitle = new Label(msg);	
		
		Button bt = new Button("확인");
		Panel pp = new Panel(new FlowLayout());
		pp.add(bt);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});		
		dlg.add(lbTitle);
		lbTitle.setBounds(10, 50, 280, 30);	
		lbTitle.setAlignment(Label.CENTER);
		lbTitle.setFont(font15);
			
		dlg.add(bt);
		bt.setBounds(100, 90, 100, 30);		
		bt.setFont(font15);
		
		dlg.setSize(300, 150);
		Dimension dimen2 =dlg.getSize();
		int xpos2 = (int) (dimen.getWidth() / 2- dimen2.getWidth() / 2);
		int ypos2 = (int) (dimen.getHeight() / 2 - dimen2.getHeight() / 2);
		dlg.setLocation(xpos2, ypos2);
		dlg.setVisible(true);	
	}



}
