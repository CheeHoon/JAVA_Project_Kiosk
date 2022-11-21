package Java_day_030_;

import java.awt.*;
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
import java.util.Date;
public class Kiosk {

	public static void main(String[] args) {
		Vending vdm = new Vending();
	}
}
class Vending extends Frame implements ActionListener {
	String name[] = new String[6];
	String count[] = new String[6];
	String price[] = new String[6];
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	int cmTot = 20;		int cmTotm = 2500;	int cm =0;
	int amTot = 20;		int amTotm = 2000;	int am =0;
	int ccTot = 20;		int ccTotm = 4000;	int cc =0;
	int hcTot = 20;		int hcTotm = 2500;	int hc =0;
	int ymTot = 20;		int ymTotm = 3000;	int ym =0;
	int hmTot = 20;		int hmTotm = 2000;	int hm =0;
	int sltTot = 0;		int totBalance = 0;	int payment =0;
	Image imgSel; 	
	Image imgcm;	
	Image imgam;	
	Image imgcc;		
	Image imghc;	
	Image imgym;	
	Image imghm;	
	
	Label lbTitle = new Label("KIOSK");	
	
	Label cmAmount = new Label("수량:"+ cmTot +"개");
	Button cafeMoca = new Button("카페모카");
	Label cafeMocaC = new Label();
	Label cmPrice = new Label(cmTotm+"원");
	
	Label amAmount = new Label("수량:"+amTot+"개");
	Button ameriCano = new Button("아메리카노");
	Label ameriCanoC = new Label();
	Label amPrice = new Label(amTotm+"원");
	
	Label ccAmount = new Label("수량:"+ccTot+"개");
	Button capuCcino = new Button("카푸치노");
	Label capuCcinoC = new Label();
	Label ccPrice = new Label(ccTotm+"원");
	
	Label hcAmount = new Label("수량:"+hcTot+"개");
	Button hotChoco = new Button("핫초코");
	Label hotChocoC = new Label();
	Label hcPrice = new Label(hcTotm+"원");
	
	Label ymAmount = new Label("수량:"+ymTot+"개");
	Button yulMucha = new Button("율무차");
	Label yulMuchaC = new Label();
	Label ymPrice = new Label(ymTotm+"원");
	
	Label hmAmount = new Label("수량:"+hmTot+"개");
	Button hotMilk = new Button("밀크");
	Label hotMilkC = new Label();
	Label hmPrice = new Label(hmTotm+"원");
	
	Label sltTitle = new Label("선택상품");
	Label sltTea = new Label("선택해주세요");
	Label sltAmount = new Label("총수량:"+sltTot+"개");


	Label totAmount = new Label("현재잔액:"+totBalance+"원");
	Label totPayment = new Label("결재금액:"+payment+"원");
	
	Button cash1000 = new Button("1000원");
	Button cash5000 = new Button("5000원");
	Button cash10000 = new Button("10000원");
	Button btnpayment = new Button("결제하기");
	Button manage = new Button("관리자");

	TextArea ta = new TextArea();
	Label er = new Label();
	Label er1 = new Label();
	Vending() {
		super("키오스크");
		
		this.init();
		this.start();		
		this.setSize(750, 600);	
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		this.setVisible(true);
		
	}
	void init() {
		getData();
		cafeMoca.setLabel(name[0]);
		cmAmount.setText("수량:"+ count[0] +"개");
		cmPrice.setText(price[0]+"원");
		
		ameriCano.setLabel(name[1]);
		amAmount.setText("수량 "+count[1]+"개");
		amPrice.setText(price[1]+"원");
		
		capuCcino.setLabel(name[2]);
		ccAmount.setText("수량 "+count[2]+"개");
		ccPrice.setText(price[2]+"원");
		
		hotChoco.setLabel(name[3]);
		hcAmount.setText("수량 "+count[3]+"개");
		hcPrice.setText(price[3]+"원");
		
		yulMucha.setLabel(name[4]);
		ymAmount.setText("수량 "+count[4]+"개");
		ymPrice.setText(price[4]+"원");
		
		hotMilk.setLabel(name[5]);
		hmAmount.setText("수량 "+count[5]+"개");
		hmPrice.setText(price[5]+"원");
		
		cmTot=Integer.parseInt(count[0]);
		amTot=Integer.parseInt(count[1]);
		ccTot=Integer.parseInt(count[2]);
		hcTot=Integer.parseInt(count[3]);
		ymTot=Integer.parseInt(count[4]);
		hmTot=Integer.parseInt(count[5]);
		cmTotm=Integer.parseInt(price[0]);
		amTotm=Integer.parseInt(price[1]);
		ccTotm=Integer.parseInt(price[2]);
		hcTotm=Integer.parseInt(price[3]);
		ymTotm=Integer.parseInt(price[4]);
		hmTotm=Integer.parseInt(price[5]);
		
		Font font40 = new Font("SansSerif", Font.BOLD, 40);
		Font font30 = new Font("SansSerif", Font.BOLD, 30);
		Font font20b = new Font("SansSerif", Font.BOLD, 20);
		Font font20 = new Font("SansSerif", Font.PLAIN, 20);
		Font font15 = new Font("SansSerif", Font.PLAIN, 15);
		
		this.setLayout(null);	this.add(lbTitle);
		this.add(cmAmount);		this.add(cafeMocaC);	this.add(cafeMoca);		this.add(cmPrice);
		this.add(amAmount);		this.add(ameriCanoC);	this.add(ameriCano);	this.add(amPrice);
		this.add(ccAmount);		this.add(capuCcinoC);	this.add(capuCcino);	this.add(ccPrice);	
		this.add(hcAmount);		this.add(hotChocoC);	this.add(hotChoco);		this.add(hcPrice);	
		this.add(ymAmount);		this.add(yulMuchaC);	this.add(yulMucha);		this.add(ymPrice);	
		this.add(hmAmount);		this.add(hotMilkC);		this.add(hotMilk);		this.add(hmPrice);	
		this.add(sltTitle);		this.add(sltTea);		this.add(sltAmount);	this.add(manage);

		this.add(totAmount);this.add(totPayment);
		this.add(cash1000);this.add(cash5000);this.add(cash10000);this.add(btnpayment);
		this.add(er);this.add(er1);this.add(ta);
		
		lbTitle.setBounds(195, 35, 140, 40);lbTitle.setFont(font40);
		
		cmPrice.setBounds(80, 160, 60, 20);cmPrice.setFont(font15);
		cmPrice.setAlignment(Label.CENTER);
		cmAmount.setBounds(50, 180, 120, 20);cmAmount.setFont(font15);
		cmAmount.setAlignment(Label.CENTER);
		cafeMoca.setBounds(50, 210, 120, 20);cafeMoca.setFont(font15);
		cafeMocaC.setBounds(57, 217, 6, 6);
		cafeMocaC.setBackground(Color.green);
		
		amPrice.setBounds(230, 160, 60, 20);amPrice.setFont(font15);
		amPrice.setAlignment(Label.CENTER);
		amAmount.setBounds(200, 180, 120, 20);amAmount.setFont(font15);
		amAmount.setAlignment(Label.CENTER);
		ameriCano.setBounds(200, 210, 120, 20);ameriCano.setFont(font15);
		ameriCanoC.setBounds(207, 217, 6, 6);
		ameriCanoC.setBackground(Color.green);
		
		ccPrice.setBounds(380, 160, 60, 20);ccPrice.setFont(font15);
		ccPrice.setAlignment(Label.CENTER);
		ccAmount.setBounds(350, 180, 120, 20);ccAmount.setFont(font15);
		ccAmount.setAlignment(Label.CENTER);
		capuCcino.setBounds(350, 210, 120, 20);capuCcino.setFont(font15);
		capuCcinoC.setBounds(357, 217, 6, 6);
		capuCcinoC.setBackground(Color.green);
		
		hcPrice.setBounds(80, 340, 60, 20);hcPrice.setFont(font15);
		hcPrice.setAlignment(Label.CENTER);
		hcAmount.setBounds(50, 360, 120, 20);hcAmount.setFont(font15);
		hcAmount.setAlignment(Label.CENTER);
		hotChoco.setBounds(50, 390, 120, 20);hotChoco.setFont(font15);
		hotChocoC.setBounds(57, 397,6, 6);
		hotChocoC.setBackground(Color.green);
		
		ymPrice.setBounds(230, 340, 60, 20);ymPrice.setFont(font15);
		ymPrice.setAlignment(Label.CENTER);
		ymAmount.setBounds(200, 360, 120, 20);ymAmount.setFont(font15);
		ymAmount.setAlignment(Label.CENTER);
		yulMucha.setBounds(200, 390, 120, 20);yulMucha.setFont(font15);
		yulMuchaC.setBounds(207, 397, 6, 6);
		yulMuchaC.setBackground(Color.green);
		
		hmPrice.setBounds(380, 340, 60, 20);hmPrice.setFont(font15);
		hmPrice.setAlignment(Label.CENTER);
		hmAmount.setBounds(350, 360, 120, 20);hmAmount.setFont(font15);
		hmAmount.setAlignment(Label.CENTER);
		hotMilk.setBounds(350, 390, 120, 20);hotMilk.setFont(font15);
		hotMilkC.setBounds(357, 397, 6, 6);
		hotMilkC.setBackground(Color.green);
		
		sltTitle.setBounds(520,70, 180, 40);sltTitle.setFont(font30);
		sltTitle.setAlignment(Label.CENTER);
		sltTea.setBounds(560, 230, 100, 20);sltTea.setFont(font15);
		sltTea.setAlignment(Label.CENTER);
		sltAmount.setBounds(580, 370, 100, 20);sltAmount.setFont(font15);
	
		cash1000.setBounds(50, 500, 110, 40);cash1000.setFont(font15);
		cash5000.setBounds(180, 500, 110, 40);cash5000.setFont(font15);
		cash10000.setBounds(310, 500,110, 40);cash10000.setFont(font15);
	
		totAmount.setBounds(50, 440, 200, 40);totAmount.setFont(font20b);
		totPayment.setBounds(520, 440, 180, 40);totPayment.setFont(font20b);
		
		btnpayment.setBounds(520, 480, 180, 60);btnpayment.setFont(font20b);
		ta.setBounds(520, 260, 180, 150);ta.setFont(font15);
		er.setBounds(522, 390, 175, 17);ta.setFont(font15);
		er1.setBounds(677, 262, 20, 144);ta.setFont(font15);
		
		manage.setBounds(640, 35, 100, 20);manage.setFont(font20);
		imgcm = Toolkit.getDefaultToolkit().getImage("imgcafemoca.jpg");	
		imgam = Toolkit.getDefaultToolkit().getImage("imgamericano.jpg");	
		imgcc = Toolkit.getDefaultToolkit().getImage("imgcappuccino.jpg");	
		imghc = Toolkit.getDefaultToolkit().getImage("imghotchoco.jpg");	
		imgym = Toolkit.getDefaultToolkit().getImage("imgyulmu.jpg");		
		imghm = Toolkit.getDefaultToolkit().getImage("imgmilk.jpg");		
		
		imgSel = Toolkit.getDefaultToolkit().getImage("sltnone.jpg");
	}
	void start() {
		cafeMoca.addActionListener(this);
		ameriCano.addActionListener(this);
		capuCcino.addActionListener(this);
		hotChoco.addActionListener(this);
		yulMucha.addActionListener(this);
		hotMilk.addActionListener(this);
		cash1000.addActionListener(this);
		cash5000.addActionListener(this);
		cash10000.addActionListener(this);
		btnpayment.addActionListener(this);
		manage.addActionListener(this);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}
	public void paint(Graphics g) {
		
		g.drawImage(imgcm,50, 90, 120, 80, this);		
		g.drawImage(imgam,200, 90, 120, 80, this);
		g.drawImage(imgcc,350, 90, 120, 80, this);
		g.drawImage(imghc,50, 270, 120, 80, this);
		g.drawImage(imgym,200, 270, 120, 80, this);
		g.drawImage(imghm,350, 270, 120, 80, this);
		g.drawImage(imgSel,520,120, 180, 120, this);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==manage) {
			Vending_manager manage = new Vending_manager();
		}
		if(e.getSource()==cafeMoca) {
			cm++;
			sltTot++;
			cmTot--;
			payment+=cmTotm;
			sltTea.setText("카페모카");
			cmAmount.setText("수량:"+cmTot+"개");
			imgSel = Toolkit.getDefaultToolkit().getImage("imgcafemoca.jpg");
			this.repaint();
			if(cmTot==0) {
				imgcm = Toolkit.getDefaultToolkit().getImage("imgSOcafemoca.jpg");
				this.repaint();
				cafeMocaC.setBackground(Color.red);
				cmAmount.setText("품절");
				cafeMoca.setEnabled(false);
			}				
		}
		if(e.getSource()==ameriCano) {
			sltTot++;
			am++;
			amTot--;
			payment+=amTotm;
			sltTea.setText("아메리카노");
			amAmount.setText("수량:"+amTot+"개");			
			imgSel = Toolkit.getDefaultToolkit().getImage("imgamericano.jpg");
			this.repaint();
			if(amTot==0) {
				imgam = Toolkit.getDefaultToolkit().getImage("imgSOamericano.jpg");
				this.repaint();
				amAmount.setText("품절");
				ameriCanoC.setBackground(Color.red);
				ameriCano.setEnabled(false);
			}
		}
		if(e.getSource()==capuCcino) {
			sltTot++;
			cc++;
			ccTot--;
			payment+=ccTotm;
			sltTea.setText("카푸치노");
			ccAmount.setText("수량:"+ccTot+"개");			
			imgSel = Toolkit.getDefaultToolkit().getImage("imgcappuccino.jpg");
			this.repaint();
			if(ccTot==0) {
				imgcc = Toolkit.getDefaultToolkit().getImage("imgSOcappuccino.jpg");
				this.repaint();
				ccAmount.setText("품절");
				capuCcinoC.setBackground(Color.red);
				capuCcino.setEnabled(false);
			}
		}
		if(e.getSource()==hotChoco) {
			sltTot++;
			hc++;
			hcTot--;
			payment+=hcTotm;
			sltTea.setText("핫초코");
			hcAmount.setText("수량:"+hcTot+"개");			
			imgSel = Toolkit.getDefaultToolkit().getImage("imghotchoco.jpg");
			this.repaint();
			if(hcTot==0) {
				imghc = Toolkit.getDefaultToolkit().getImage("imgSOhotchoco.jpg");
				this.repaint();
				hcAmount.setText("품절");
				hotChocoC.setBackground(Color.red);
				hotChoco.setEnabled(false);
			}
		}
		if(e.getSource()==yulMucha) {
			sltTot++;
			ym++;
			ymTot--;
			payment+=ymTotm;
			sltTea.setText("율무차");
			ymAmount.setText("수량:"+ymTot+"개");			
			imgSel = Toolkit.getDefaultToolkit().getImage("imgyulmu.jpg");
			this.repaint();
			if(ymTot<=0) {
				imgym = Toolkit.getDefaultToolkit().getImage("imgSOyulmu.jpg");
				this.repaint();
				ymAmount.setText("품절");
				yulMuchaC.setBackground(Color.red);
				yulMucha.setEnabled(false);
			}
		}
		if(e.getSource()==hotMilk) {
			sltTot++;
			hm++;
			hmTot--;
			payment+=hmTotm;
			sltTea.setText("밀크");
			hmAmount.setText("수량:"+hmTot+"개");			
			imgSel = Toolkit.getDefaultToolkit().getImage("imgmilk.jpg");
			this.repaint();
			if(hmTot==0) {
				imghm = Toolkit.getDefaultToolkit().getImage("imgSOmilk.jpg");
				this.repaint();
				hmAmount.setText("품절");
				hotMilkC.setBackground(Color.red);
				hotMilk.setEnabled(false);
			}
		}
		if(e.getSource()==cash1000) {
			totBalance=totBalance+1000;
			totAmount.setText("현재잔액:"+totBalance+"원");	
		}
		if(e.getSource()==cash5000) {
			totBalance=totBalance+5000;
			totAmount.setText("현재잔액:"+totBalance+"원");	
		}
		if(e.getSource()==cash10000) {
			totBalance=totBalance+10000;
			totAmount.setText("현재잔액:"+totBalance+"원");	
		}
		if(e.getSource()==btnpayment) {
			if(totBalance>=payment&&payment>0&&sltTot>0) {
				int tot =totBalance-payment;
				dlgMsg("결재 되었습니다.잠시 대기 해주세요");
				totBalance = tot;
				totAmount.setText("현재잔액:"+totBalance+"원");
				int[]countt= {cmTot, amTot, ccTot, hcTot, ymTot,hmTot};
				for(int i=0; i<6;i++) {
				update(i+1, countt[i]);
				}

				 reset();return;
			}
			if(totBalance<payment) {
				dlgMsg("잔액이 부족합니다");
			}
			if(sltTot==0) {
				dlgMsg("제품을 선택해주세요");
			}			
		}
		sltAmount.setText("총수량:"+sltTot+"개");
		totPayment.setText("결재금액:"+payment+"원");
		ta.setText("*카페모카:    "+cm+"개\n"+"*아메리카노: "+am+"개\n"+"*카푸치노:    "+cc+"개\n"
				+"*핫초코:       "+hc+"개\n"+"*율무차:       "+ym+"개\n"+"*밀크:          "+hm+"개");
		
	}
	boolean update(int idx, int countt)
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
		
		String query = "update vanding_manage set count = ? where idx = ?";
	
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setInt(1, countt);
			pstmt.setInt(2, idx);			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException ee) {
			System.err.println("정보수정 실패!!:"+ee.getMessage());
			return false;
		}
		return true;
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
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}		
	}
	void dlgMsg(String msg) {
		
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
	void reset() {
		payment=0;sltTot=0; sltTea.setText("선택해주세요");
		sltAmount.setText("총수량:"+sltTot+"개");
		totPayment.setText("결재금액:"+payment+"원");
		cm =0; am =0;cc =0;hc =0;ym =0;hm =0;
		ta.setText("*카페모카:    "+cm+"개\n"+"*아메리카노: "+am+"개\n"+"*카푸치노:    "+cc+"개\n"
		+"*핫초코:       "+hc+"개\n"+"*율무차:       "+ym+"개\n"+"*밀크:          "+hm+"개");
		
		cmAmount.setText("수량:"+cmTot+"개"); cafeMoca.setEnabled(true);
		amAmount.setText("수량:"+amTot+"개");ameriCano.setEnabled(true);
		ccAmount.setText("수량:"+ccTot+"개");capuCcino.setEnabled(true);
		hcAmount.setText("수량:"+hcTot+"개");hotChoco.setEnabled(true);
		ymAmount.setText("수량:"+ymTot+"개");yulMucha.setEnabled(true);
		hmAmount.setText("수량:"+hmTot+"개");hotMilk.setEnabled(true);
		imgcm = Toolkit.getDefaultToolkit().getImage("imgcafemoca.jpg");this.repaint();
		imgam = Toolkit.getDefaultToolkit().getImage("imgamericano.jpg");this.repaint();
		imgcc = Toolkit.getDefaultToolkit().getImage("imgcappuccino.jpg");this.repaint();
		imghc = Toolkit.getDefaultToolkit().getImage("imghotchoco.jpg");this.repaint();
		imgym = Toolkit.getDefaultToolkit().getImage("imgyulmu.jpg");this.repaint();
		imghm = Toolkit.getDefaultToolkit().getImage("imgmilk.jpg");this.repaint();
		imgSel = Toolkit.getDefaultToolkit().getImage("sltnone.jpg");this.repaint();
		cafeMocaC.setBackground(Color.green);
		ameriCanoC.setBackground(Color.green);
		capuCcinoC.setBackground(Color.green);
		hotChocoC.setBackground(Color.green);
		yulMuchaC.setBackground(Color.green);
		hotMilkC.setBackground(Color.green);
	}
	
}
