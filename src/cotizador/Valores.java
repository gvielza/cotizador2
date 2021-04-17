package cotizador;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.apache.xmlbeans.impl.jam.JParameter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.x.ReusableInputStream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.Box;

public class Valores extends JFrame {

	private JPanel contentPane;
	private JTextField tfpolbsas;
	private JTextField tfpolicaba;
	private JTextField tfpolineu;
	private JTextField tfpolistac;
	private JTextField tfpolistaf;
	private JTextField apartic;
	private JTextField operario;
	JTextField[] arrayacompa = { tfpolbsas, tfpolicaba, tfpolineu, tfpolistac, tfpolistaf, apartic, operario };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Valores frame = new Valores();
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
	Connection con;
	static ResultSet resultado;
	static ResultSet resultadoacompa;
	private JTextField F30;
	private JTextField F45;
	private JTextField F60;
	private JTextField F90;
	private JTextField F130;
	private JTextField F170;
	private JTextField F300;
	private JTextField F370;
	private JTextField F450;
	private JTextField F500;
	private JTextField S30_20T;
	private JTextField S45_20T;
	private JTextField S60_20T;
	private JTextField S90_20T;
	private JTextField S130_20T;
	private JTextField S170_20T;
	private JTextField S30_28T;
	private JTextField S170_28T;
	private JTextField S130_28T;
	private JTextField S90_28T;
	private JTextField S60_28T;
	private JTextField S45_28T;
	private JTextField S30_20TRT;
	private JTextField S170_20TRT;
	private JTextField S130_20TRT;
	private JTextField S90_20TRT;
	private JTextField S60_20TRT;
	private JTextField S45_20TRT;
	private JTextField S30_28TRT;
	private JTextField S170_28TRT;
	private JTextField S130_28TRT;
	private JTextField S90_28TRT;
	private JTextField S60_28TRT;
	private JTextField S45_28TRT;
	private JLabel lblNewLabel_11_1_5;
	private JLabel lblNewLabel_11_1_8;
	private JLabel lblNewLabel_11_1_6;
	private JLabel lblNewLabel_11_1_7;
	private JLabel lblNewLabel_11_1_9;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField CM20T330;
	private JTextField CM60T330;
	private JTextField CM50T330;
	private JTextField CM40T330;
	private JTextField CM30T330;
	private JTextField CM20T365;
	private JTextField CM60T365;
	private JTextField CM50T365;
	private JTextField CM40T365;
	private JTextField CM30T365;
	private JTextField CM20T365x360;
	private JTextField CM60T365x360;
	private JTextField CM50T365x360;
	private JTextField CM40T365x360;
	private JTextField CM30T365x360;
	private JTextField CM20T390;
	private JTextField CM60T390;
	private JTextField CM50T390;
	private JTextField CM40T390;
	private JTextField CM30T390;
	private JTextField CM20T420;
	private JTextField CM60T420;
	private JTextField CM50T420;
	private JTextField CM40T420;
	private JTextField CM30T420;
	private JTextField CM20T500;
	private JTextField CM60T500;
	private JTextField CM50T500;
	private JTextField CM40T500;
	private JTextField CM30T500;
	private JTextField CM20T500x460;
	private JTextField CM60T500x460;
	private JTextField CM50T500x460;
	private JTextField CM40T500x460;
	private JTextField CM30T500x460;
	private JTextField EXT_1;
	private JTextField M1;
	private JTextField S220_20T;
	private JTextField S500_20T;
	private JTextField S450_20T;
	private JTextField S370_20T;
	private JTextField S300_20T;
	private JTextField S220_28T;
	private JTextField S500_28T;
	private JTextField S450_28T;
	private JTextField S370_28T;
	private JTextField S300_28T;
	private JTextField S220_20TRT;
	private JTextField S500_20TRT;
	private JTextField S450_20TRT;
	private JTextField S370_20TRT;
	private JTextField S300_20TRT;
	private JTextField S220_28TRT;
	private JTextField S500_28TRT;
	private JTextField S450_28TRT;
	private JTextField S370_28TRT;
	private JTextField S300_28TRT;
	private JTextField F220;
	public int[] valoracompa = new int[7];

	public Valores() {
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 12));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		setBounds(1, 1, 998, 742);
		getContentPane().setLayout(null);
//this.setExtendedState(MAXIMIZED_BOTH);
		JLabel lblNewLabel = new JLabel("ACTUALIZAR VALORES:");
		lblNewLabel.setBounds(274, 11, 163, 14);
		getContentPane().add(lblNewLabel);

		JLabel Apolbsas = new JLabel("A Policial BS AS:");
		Apolbsas.setBounds(31, 43, 97, 14);
		getContentPane().add(Apolbsas);

		tfpolbsas = new JTextField();
		tfpolbsas.setBounds(132, 40, 50, 20);
		getContentPane().add(tfpolbsas);
		tfpolbsas.setColumns(10);

		JButton btnNewButton = new JButton("ACTUALIZAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/cotizador", "root", "");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("INSERT INTO acompapolicial VALUES('" + tfpolbsas.getText() + "','"
							+ tfpolicaba.getText() + "','" + tfpolineu.getText() + "','" + tfpolistac.getText() + "','"
							+ tfpolistaf.getText() + "','" + apartic.getText() + "','" + operario.getText() + "')");

					/*
					 * stmt.executeUpdate("INSERT INTO semifueramedida VALUES('" + F30.getText() +
					 * "','" + F45.getText() + "','" + F60.getText() + "','" + F90.getText() + "','"
					 * + F130.getText() + "','" + F170.getText() + "','" + F220.getText() + "','" +
					 * F300.getText() + "','" + F370.getText() + "','" + F450.getText() + "','" +
					 * F500.getText() + "')");
					 * 
					 * stmt.executeUpdate("INSERT INTO semis VALUES('" + S30_20T.getText() + "','" +
					 * S45_20T.getText() + "','" + S60_20T.getText() + "','" + S90_20T.getText() +
					 * "','" + S130_20T.getText() + "','" + S170_20T.getText() + "','" +
					 * S220_20T.getText() + "','" + S300_20T.getText() + "','" + S370_20T.getText()
					 * + "','" + S450_20T.getText() + "','" + S500_20T.getText() + "','" +
					 * S30_28T.getText() + "','" + S45_28T.getText() + "','" + S60_28T.getText() +
					 * "','" + S90_28T.getText() + "','" + S130_28T.getText() + "','" +
					 * S170_28T.getText() + "','" + S220_28T.getText() + "','" + S300_28T.getText()
					 * + "','" + S370_28T.getText() + "','" + S450_28T.getText() + "','" +
					 * S500_28T.getText() + "','" + S30_20TRT.getText() + "','" +
					 * S45_20TRT.getText() + "','" + S60_20TRT.getText() + "','" +
					 * S90_20TRT.getText() + "','" + S130_20TRT.getText() + "','" +
					 * S170_20TRT.getText() + "','" + S220_20TRT.getText() + "','" +
					 * S300_20TRT.getText() + "','" + S370_20TRT.getText() + "','" +
					 * S450_20TRT.getText() + "','" + S500_20TRT.getText() + "','" +
					 * S30_28TRT.getText() + "','" + S45_20TRT.getText() + "','" +
					 * S60_20TRT.getText() + "','" + S90_20TRT.getText() + "','" +
					 * S130_28TRT.getText() + "','" + S170_28TRT.getText() + "','" +
					 * S220_28TRT.getText() + "','" + S300_28TRT.getText() + "','" +
					 * S370_28TRT.getText() + "','" + S450_28TRT.getText() + "','" +
					 * S500_28TRT.getText() + "')");
					 * 
					 * stmt.executeUpdate("INSERT INTO carretonesmecanicos VALUES('" +
					 * CM20T330.getText() + "','" + CM30T330.getText() + "','" + CM40T330.getText()
					 * + "','" + CM50T330.getText() + "','" + CM60T330.getText() + "','" +
					 * CM20T365.getText() + "','" + CM30T365.getText() + "','" + CM40T365.getText()
					 * + "','" + CM50T365.getText() + "','" + CM60T365.getText() + "','" +
					 * CM20T365x360.getText() + "','" + CM30T365x360.getText() + "','" +
					 * CM40T365x360.getText() + "','" + CM50T365x360.getText() + "','" +
					 * CM60T365x360.getText() + "','" + CM20T390.getText() + "','" +
					 * CM30T390.getText() + "','" + CM40T390.getText() + "','" + CM50T390.getText()
					 * + "','" + CM60T390.getText() + "','" + CM20T420.getText() + "','" +
					 * CM30T420.getText() + "','" + CM40T420.getText() + "','" + CM50T420.getText()
					 * + "','" + CM60T420.getText() + "','" + CM20T500.getText() + "','" +
					 * CM30T500.getText() + "','" + CM40T500.getText() + "','" + CM50T500.getText()
					 * + "','" + CM60T500.getText() + "','" + CM20T500x460.getText() + "','" +
					 * CM30T500x460.getText() + "','" + CM40T500x460.getText() + "','" +
					 * CM50T500x460.getText() + "','" + CM60T500x460.getText() + "','" +
					 * M1.getText() + "','" + EXT_1.getText() + "')");
					 */
					llenaracompa();
					Buscar(operario);
					JOptionPane.showMessageDialog(null, "se actualizaron los datos correctamente");
					Valores.this.setVisible(false);
				} catch (SQLException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "no se conecta puto");
				}

			}

		});
		btnNewButton.setBounds(839, 669, 110, 23);
		getContentPane().add(btnNewButton);

		JLabel apolcaba = new JLabel("A Polic CABA:");
		apolcaba.setBounds(31, 65, 87, 14);
		getContentPane().add(apolcaba);

		tfpolicaba = new JTextField();
		tfpolicaba.setBounds(132, 62, 50, 20);
		getContentPane().add(tfpolicaba);
		tfpolicaba.setColumns(10);

		JLabel Apolneuquen = new JLabel("A Policial Neu:");
		Apolneuquen.setBounds(31, 87, 87, 14);
		getContentPane().add(Apolneuquen);

		JLabel Apolsantac = new JLabel("A Policial StaC:");
		Apolsantac.setBounds(31, 109, 87, 14);
		getContentPane().add(Apolsantac);

		JLabel ApolsantaF = new JLabel("A Policial Sta F:");
		ApolsantaF.setBounds(31, 131, 87, 14);
		getContentPane().add(ApolsantaF);

		tfpolineu = new JTextField();
		tfpolineu.setColumns(10);
		tfpolineu.setBounds(132, 84, 50, 20);
		getContentPane().add(tfpolineu);

		tfpolistac = new JTextField();
		tfpolistac.setColumns(10);
		tfpolistac.setBounds(132, 106, 50, 20);
		getContentPane().add(tfpolistac);

		tfpolistaf = new JTextField();
		tfpolistaf.setColumns(10);
		tfpolistaf.setBounds(132, 128, 50, 20);
		getContentPane().add(tfpolistaf);

		JLabel aparti = new JLabel("A partic:");
		aparti.setBounds(199, 43, 58, 14);
		getContentPane().add(aparti);

		apartic = new JTextField();
		apartic.setBounds(267, 40, 50, 20);
		getContentPane().add(apartic);
		apartic.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Operario:");
		lblNewLabel_1.setBounds(199, 65, 58, 14);
		getContentPane().add(lblNewLabel_1);

		operario = new JTextField();
		operario.setBounds(267, 62, 50, 20);
		getContentPane().add(operario);
		operario.setColumns(10);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Semi Fuera de Medida(KM):");
		lblNewLabel_2.setBounds(389, 37, 180, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("30:");
		lblNewLabel_3.setBounds(399, 65, 32, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("45:");
		lblNewLabel_3_1.setBounds(399, 87, 32, 14);
		getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("60:");
		lblNewLabel_3_2.setBounds(399, 109, 32, 14);
		getContentPane().add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("90:");
		lblNewLabel_3_3.setBounds(399, 131, 32, 14);
		getContentPane().add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("130:");
		lblNewLabel_3_4.setBounds(526, 65, 32, 14);
		getContentPane().add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_5 = new JLabel("170:");
		lblNewLabel_3_5.setBounds(526, 87, 32, 14);
		getContentPane().add(lblNewLabel_3_5);

		JLabel lblNewLabel_3_6 = new JLabel("220:");
		lblNewLabel_3_6.setBounds(526, 109, 32, 14);
		getContentPane().add(lblNewLabel_3_6);

		JLabel lblNewLabel_3_7 = new JLabel("300:");
		lblNewLabel_3_7.setBounds(526, 131, 32, 14);
		getContentPane().add(lblNewLabel_3_7);

		JLabel lblNewLabel_3_8 = new JLabel("370:");
		lblNewLabel_3_8.setBounds(624, 65, 32, 14);
		getContentPane().add(lblNewLabel_3_8);

		JLabel lblNewLabel_3_9 = new JLabel("450:");
		lblNewLabel_3_9.setBounds(624, 87, 32, 14);
		getContentPane().add(lblNewLabel_3_9);

		JLabel lblNewLabel_3_10 = new JLabel("500:");
		lblNewLabel_3_10.setBounds(624, 109, 32, 14);
		getContentPane().add(lblNewLabel_3_10);

		F30 = new JTextField();
		F30.setColumns(10);
		F30.setBounds(430, 62, 50, 20);
		getContentPane().add(F30);

		F45 = new JTextField();
		F45.setColumns(10);
		F45.setBounds(430, 84, 50, 20);
		getContentPane().add(F45);

		F60 = new JTextField();
		F60.setColumns(10);
		F60.setBounds(430, 106, 50, 20);
		getContentPane().add(F60);

		F90 = new JTextField();
		F90.setColumns(10);
		F90.setBounds(430, 128, 50, 20);
		getContentPane().add(F90);

		F130 = new JTextField();
		F130.setColumns(10);
		F130.setBounds(568, 62, 50, 20);
		getContentPane().add(F130);

		F170 = new JTextField();
		F170.setColumns(10);
		F170.setBounds(568, 84, 50, 20);
		getContentPane().add(F170);

		F220 = new JTextField();
		F220.setColumns(10);
		F220.setBounds(568, 106, 50, 20);
		getContentPane().add(F220);

		F300 = new JTextField();
		F300.setColumns(10);
		F300.setBounds(568, 128, 50, 20);
		getContentPane().add(F300);

		F370 = new JTextField();
		F370.setColumns(10);
		F370.setBounds(661, 62, 50, 20);
		getContentPane().add(F370);

		F450 = new JTextField();
		F450.setColumns(10);
		F450.setBounds(661, 84, 50, 20);
		getContentPane().add(F450);

		F500 = new JTextField();
		F500.setColumns(10);
		F500.setBounds(661, 106, 50, 20);
		getContentPane().add(F500);

		JLabel SEMI = new JLabel("SEMI:");
		SEMI.setForeground(Color.RED);
		SEMI.setBounds(96, 173, 46, 14);
		SEMI.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(SEMI);

		JLabel lblNewLabel_11 = new JLabel("SEMI 30KM");
		lblNewLabel_11.setForeground(new Color(128, 0, 0));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(31, 210, 73, 14);
		getContentPane().add(lblNewLabel_11);

		JLabel lblNewLabel_11_1_4 = new JLabel("SEMI 170KM");
		lblNewLabel_11_1_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_4.setBounds(31, 320, 73, 14);
		getContentPane().add(lblNewLabel_11_1_4);

		JLabel lblNewLabel_11_1 = new JLabel("SEMI 45KM");
		lblNewLabel_11_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1.setBounds(31, 232, 73, 14);
		getContentPane().add(lblNewLabel_11_1);

		JLabel lblNewLabel_11_1_1 = new JLabel("SEMI 60KM");
		lblNewLabel_11_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_1.setBounds(31, 254, 73, 14);
		getContentPane().add(lblNewLabel_11_1_1);

		JLabel lblNewLabel_11_1_2 = new JLabel("SEMI 90KM");
		lblNewLabel_11_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_2.setBounds(31, 276, 73, 14);
		getContentPane().add(lblNewLabel_11_1_2);

		JLabel lblNewLabel_11_1_3 = new JLabel("SEMI 130KM");
		lblNewLabel_11_1_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_3.setBounds(31, 298, 73, 14);
		getContentPane().add(lblNewLabel_11_1_3);

		S30_20T = new JTextField();
		S30_20T.setColumns(10);
		S30_20T.setBounds(132, 207, 50, 20);
		getContentPane().add(S30_20T);

		JLabel lblNewLabel_4 = new JLabel("20T");
		lblNewLabel_4.setBounds(132, 186, 46, 14);
		getContentPane().add(lblNewLabel_4);

		S45_20T = new JTextField();
		S45_20T.setColumns(10);
		S45_20T.setBounds(132, 229, 50, 20);
		getContentPane().add(S45_20T);

		S60_20T = new JTextField();
		S60_20T.setColumns(10);
		S60_20T.setBounds(132, 251, 50, 20);
		getContentPane().add(S60_20T);

		S90_20T = new JTextField();
		S90_20T.setColumns(10);
		S90_20T.setBounds(132, 273, 50, 20);
		getContentPane().add(S90_20T);

		S130_20T = new JTextField();
		S130_20T.setColumns(10);
		S130_20T.setBounds(132, 295, 50, 20);
		getContentPane().add(S130_20T);

		S170_20T = new JTextField();
		S170_20T.setColumns(10);
		S170_20T.setBounds(132, 317, 50, 20);
		getContentPane().add(S170_20T);

		JLabel lblNewLabel_4_1 = new JLabel("28T");
		lblNewLabel_4_1.setBounds(192, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("20TRT");
		lblNewLabel_4_2.setBounds(248, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_3 = new JLabel("28TRT");
		lblNewLabel_4_3.setBounds(304, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_3);

		S30_28T = new JTextField();
		S30_28T.setColumns(10);
		S30_28T.setBounds(188, 208, 50, 20);
		getContentPane().add(S30_28T);

		S170_28T = new JTextField();
		S170_28T.setColumns(10);
		S170_28T.setBounds(188, 317, 50, 20);
		getContentPane().add(S170_28T);

		S130_28T = new JTextField();
		S130_28T.setColumns(10);
		S130_28T.setBounds(188, 295, 50, 20);
		getContentPane().add(S130_28T);

		S90_28T = new JTextField();
		S90_28T.setColumns(10);
		S90_28T.setBounds(188, 273, 50, 20);
		getContentPane().add(S90_28T);

		S60_28T = new JTextField();
		S60_28T.setColumns(10);
		S60_28T.setBounds(188, 251, 50, 20);
		getContentPane().add(S60_28T);

		S45_28T = new JTextField();
		S45_28T.setColumns(10);
		S45_28T.setBounds(188, 229, 50, 20);
		getContentPane().add(S45_28T);

		S30_20TRT = new JTextField();
		S30_20TRT.setColumns(10);
		S30_20TRT.setBounds(244, 207, 50, 20);
		getContentPane().add(S30_20TRT);

		S170_20TRT = new JTextField();
		S170_20TRT.setColumns(10);
		S170_20TRT.setBounds(244, 317, 50, 20);
		getContentPane().add(S170_20TRT);

		S130_20TRT = new JTextField();
		S130_20TRT.setColumns(10);
		S130_20TRT.setBounds(244, 295, 50, 20);
		getContentPane().add(S130_20TRT);

		S90_20TRT = new JTextField();
		S90_20TRT.setColumns(10);
		S90_20TRT.setBounds(244, 273, 50, 20);
		getContentPane().add(S90_20TRT);

		S60_20TRT = new JTextField();
		S60_20TRT.setColumns(10);
		S60_20TRT.setBounds(244, 251, 50, 20);
		getContentPane().add(S60_20TRT);

		S45_20TRT = new JTextField();
		S45_20TRT.setColumns(10);
		S45_20TRT.setBounds(244, 229, 50, 20);
		getContentPane().add(S45_20TRT);

		S30_28TRT = new JTextField();
		S30_28TRT.setColumns(10);
		S30_28TRT.setBounds(300, 207, 50, 20);
		getContentPane().add(S30_28TRT);

		S170_28TRT = new JTextField();
		S170_28TRT.setColumns(10);
		S170_28TRT.setBounds(300, 317, 50, 20);
		getContentPane().add(S170_28TRT);

		S130_28TRT = new JTextField();
		S130_28TRT.setColumns(10);
		S130_28TRT.setBounds(300, 295, 50, 20);
		getContentPane().add(S130_28TRT);

		S90_28TRT = new JTextField();
		S90_28TRT.setColumns(10);
		S90_28TRT.setBounds(300, 273, 50, 20);
		getContentPane().add(S90_28TRT);

		S60_28TRT = new JTextField();
		S60_28TRT.setColumns(10);
		S60_28TRT.setBounds(300, 251, 50, 20);
		getContentPane().add(S60_28TRT);

		S45_28TRT = new JTextField();
		S45_28TRT.setColumns(10);
		S45_28TRT.setBounds(300, 229, 50, 20);
		getContentPane().add(S45_28TRT);

		lblNewLabel_11_1_5 = new JLabel("SEMI 220KM");
		lblNewLabel_11_1_5.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_5.setBounds(399, 210, 90, 14);
		getContentPane().add(lblNewLabel_11_1_5);

		lblNewLabel_11_1_8 = new JLabel("SEMI 500KM");
		lblNewLabel_11_1_8.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_8.setBounds(399, 289, 90, 14);
		getContentPane().add(lblNewLabel_11_1_8);

		lblNewLabel_11_1_6 = new JLabel("SEMI 450KM");
		lblNewLabel_11_1_6.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_6.setBounds(399, 268, 90, 14);
		getContentPane().add(lblNewLabel_11_1_6);

		lblNewLabel_11_1_7 = new JLabel("SEMI 370KM");
		lblNewLabel_11_1_7.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_7.setBounds(399, 248, 90, 14);
		getContentPane().add(lblNewLabel_11_1_7);

		lblNewLabel_11_1_9 = new JLabel("SEMI 300KM");
		lblNewLabel_11_1_9.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_9.setBounds(399, 229, 90, 14);
		getContentPane().add(lblNewLabel_11_1_9);

		JLabel CARM = new JLabel("CARRETON MEC:");
		CARM.setForeground(Color.RED);
		CARM.setFont(new Font("Tahoma", Font.BOLD, 11));
		CARM.setBounds(96, 359, 106, 14);
		getContentPane().add(CARM);

		lblNewLabel_5 = new JLabel("CM20T:");
		lblNewLabel_5.setBounds(31, 410, 46, 14);
		getContentPane().add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("330X330");
		lblNewLabel_6.setBounds(96, 385, 50, 14);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("365X330");
		lblNewLabel_6_1.setBounds(152, 385, 50, 14);
		getContentPane().add(lblNewLabel_6_1);

		JLabel lblNewLabel_6_2 = new JLabel("365X360");
		lblNewLabel_6_2.setBounds(208, 385, 50, 14);
		getContentPane().add(lblNewLabel_6_2);

		JLabel lblNewLabel_6_3 = new JLabel("390X360");
		lblNewLabel_6_3.setBounds(264, 385, 50, 14);
		getContentPane().add(lblNewLabel_6_3);

		JLabel lblNewLabel_6_4 = new JLabel("420X360");
		lblNewLabel_6_4.setBounds(320, 385, 50, 14);
		getContentPane().add(lblNewLabel_6_4);

		JLabel lblNewLabel_6_5 = new JLabel("500X400");
		lblNewLabel_6_5.setBounds(376, 385, 50, 14);
		getContentPane().add(lblNewLabel_6_5);

		JLabel lblNewLabel_6_5_1 = new JLabel("500X460");
		lblNewLabel_6_5_1.setBounds(432, 385, 50, 14);
		getContentPane().add(lblNewLabel_6_5_1);

		JLabel lblNewLabel_5_1 = new JLabel("CM30T:");
		lblNewLabel_5_1.setBounds(31, 432, 46, 14);
		getContentPane().add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("CM50T:");
		lblNewLabel_5_2.setBounds(31, 478, 46, 14);
		getContentPane().add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("CM40T:");
		lblNewLabel_5_3.setBounds(31, 456, 46, 14);
		getContentPane().add(lblNewLabel_5_3);

		JLabel lblNewLabel_5_4 = new JLabel("CM60T:");
		lblNewLabel_5_4.setBounds(31, 500, 46, 14);
		getContentPane().add(lblNewLabel_5_4);

		CM20T330 = new JTextField();
		CM20T330.setColumns(10);
		CM20T330.setBounds(96, 410, 50, 20);
		getContentPane().add(CM20T330);

		CM60T330 = new JTextField();
		CM60T330.setColumns(10);
		CM60T330.setBounds(96, 498, 50, 20);
		getContentPane().add(CM60T330);

		CM50T330 = new JTextField();
		CM50T330.setColumns(10);
		CM50T330.setBounds(96, 476, 50, 20);
		getContentPane().add(CM50T330);

		CM40T330 = new JTextField();
		CM40T330.setColumns(10);
		CM40T330.setBounds(96, 454, 50, 20);
		getContentPane().add(CM40T330);

		CM30T330 = new JTextField();
		CM30T330.setColumns(10);
		CM30T330.setBounds(96, 432, 50, 20);
		getContentPane().add(CM30T330);

		CM20T365 = new JTextField();
		CM20T365.setColumns(10);
		CM20T365.setBounds(152, 410, 50, 20);
		getContentPane().add(CM20T365);

		CM60T365 = new JTextField();
		CM60T365.setColumns(10);
		CM60T365.setBounds(152, 498, 50, 20);
		getContentPane().add(CM60T365);

		CM50T365 = new JTextField();
		CM50T365.setColumns(10);
		CM50T365.setBounds(152, 476, 50, 20);
		getContentPane().add(CM50T365);

		CM40T365 = new JTextField();
		CM40T365.setColumns(10);
		CM40T365.setBounds(152, 454, 50, 20);
		getContentPane().add(CM40T365);

		CM30T365 = new JTextField();
		CM30T365.setColumns(10);
		CM30T365.setBounds(152, 432, 50, 20);
		getContentPane().add(CM30T365);

		CM20T365x360 = new JTextField();
		CM20T365x360.setColumns(10);
		CM20T365x360.setBounds(207, 410, 50, 20);
		getContentPane().add(CM20T365x360);

		CM60T365x360 = new JTextField();
		CM60T365x360.setColumns(10);
		CM60T365x360.setBounds(207, 498, 50, 20);
		getContentPane().add(CM60T365x360);

		CM50T365x360 = new JTextField();
		CM50T365x360.setColumns(10);
		CM50T365x360.setBounds(207, 476, 50, 20);
		getContentPane().add(CM50T365x360);

		CM40T365x360 = new JTextField();
		CM40T365x360.setColumns(10);
		CM40T365x360.setBounds(207, 454, 50, 20);
		getContentPane().add(CM40T365x360);

		CM30T365x360 = new JTextField();
		CM30T365x360.setColumns(10);
		CM30T365x360.setBounds(207, 432, 50, 20);
		getContentPane().add(CM30T365x360);

		CM20T390 = new JTextField();
		CM20T390.setColumns(10);
		CM20T390.setBounds(264, 410, 50, 20);
		getContentPane().add(CM20T390);

		CM60T390 = new JTextField();
		CM60T390.setColumns(10);
		CM60T390.setBounds(264, 498, 50, 20);
		getContentPane().add(CM60T390);

		CM50T390 = new JTextField();
		CM50T390.setColumns(10);
		CM50T390.setBounds(264, 476, 50, 20);
		getContentPane().add(CM50T390);

		CM40T390 = new JTextField();
		CM40T390.setColumns(10);
		CM40T390.setBounds(264, 454, 50, 20);
		getContentPane().add(CM40T390);

		CM30T390 = new JTextField();
		CM30T390.setColumns(10);
		CM30T390.setBounds(264, 432, 50, 20);
		getContentPane().add(CM30T390);

		CM20T420 = new JTextField();
		CM20T420.setColumns(10);
		CM20T420.setBounds(320, 410, 50, 20);
		getContentPane().add(CM20T420);

		CM60T420 = new JTextField();
		CM60T420.setColumns(10);
		CM60T420.setBounds(320, 498, 50, 20);
		getContentPane().add(CM60T420);

		CM50T420 = new JTextField();
		CM50T420.setColumns(10);
		CM50T420.setBounds(320, 476, 50, 20);
		getContentPane().add(CM50T420);

		CM40T420 = new JTextField();
		CM40T420.setColumns(10);
		CM40T420.setBounds(320, 454, 50, 20);
		getContentPane().add(CM40T420);

		CM30T420 = new JTextField();
		CM30T420.setColumns(10);
		CM30T420.setBounds(320, 432, 50, 20);
		getContentPane().add(CM30T420);

		CM20T500 = new JTextField();
		CM20T500.setColumns(10);
		CM20T500.setBounds(376, 410, 50, 20);
		getContentPane().add(CM20T500);

		CM60T500 = new JTextField();
		CM60T500.setColumns(10);
		CM60T500.setBounds(376, 498, 50, 20);
		getContentPane().add(CM60T500);

		CM50T500 = new JTextField();
		CM50T500.setColumns(10);
		CM50T500.setBounds(376, 476, 50, 20);
		getContentPane().add(CM50T500);

		CM40T500 = new JTextField();
		CM40T500.setColumns(10);
		CM40T500.setBounds(376, 454, 50, 20);
		getContentPane().add(CM40T500);

		CM30T500 = new JTextField();
		CM30T500.setColumns(10);
		CM30T500.setBounds(376, 432, 50, 20);
		getContentPane().add(CM30T500);

		CM20T500x460 = new JTextField();
		CM20T500x460.setColumns(10);
		CM20T500x460.setBounds(430, 410, 50, 20);
		getContentPane().add(CM20T500x460);

		CM60T500x460 = new JTextField();
		CM60T500x460.setColumns(10);
		CM60T500x460.setBounds(430, 498, 50, 20);
		getContentPane().add(CM60T500x460);

		CM50T500x460 = new JTextField();
		CM50T500x460.setColumns(10);
		CM50T500x460.setBounds(430, 476, 50, 20);
		getContentPane().add(CM50T500x460);

		CM40T500x460 = new JTextField();
		CM40T500x460.setColumns(10);
		CM40T500x460.setBounds(430, 454, 50, 20);
		getContentPane().add(CM40T500x460);

		CM30T500x460 = new JTextField();
		CM30T500x460.setColumns(10);
		CM30T500x460.setBounds(430, 432, 50, 20);
		getContentPane().add(CM30T500x460);

		JLabel EXTENSIBLE = new JLabel("EXTENSIBLE:");
		EXTENSIBLE.setForeground(new Color(128, 0, 0));
		EXTENSIBLE.setFont(new Font("Tahoma", Font.BOLD, 11));
		EXTENSIBLE.setBounds(568, 456, 106, 14);
		getContentPane().add(EXTENSIBLE);

		EXT_1 = new JTextField();
		EXT_1.setBounds(592, 475, 65, 20);
		getContentPane().add(EXT_1);
		EXT_1.setColumns(10);

		JLabel lblModeloHidra = new JLabel("MODULO HIDRAULICO:");
		lblModeloHidra.setForeground(new Color(128, 0, 0));
		lblModeloHidra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModeloHidra.setBounds(565, 410, 146, 14);
		getContentPane().add(lblModeloHidra);

		M1 = new JTextField();
		M1.setColumns(10);
		M1.setBounds(592, 429, 65, 20);
		getContentPane().add(M1);

		JLabel lblNewLabel_7 = new JLabel(
				"Para que se puedan actualizar los datos es necesario llenar todos los campos.");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(31, 557, 538, 32);
		getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_4_4 = new JLabel("20T");
		lblNewLabel_4_4.setBounds(493, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_4);

		JLabel lblNewLabel_4_1_1 = new JLabel("28T");
		lblNewLabel_4_1_1.setBounds(553, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_1_1);

		JLabel lblNewLabel_4_2_1 = new JLabel("20TRT");
		lblNewLabel_4_2_1.setBounds(609, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_2_1);

		JLabel lblNewLabel_4_3_1 = new JLabel("28TRT");
		lblNewLabel_4_3_1.setBounds(674, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_3_1);

		S220_20T = new JTextField();
		S220_20T.setColumns(10);
		S220_20T.setBounds(489, 204, 50, 20);
		getContentPane().add(S220_20T);

		S500_20T = new JTextField();
		S500_20T.setColumns(10);
		S500_20T.setBounds(489, 292, 50, 20);
		getContentPane().add(S500_20T);

		S450_20T = new JTextField();
		S450_20T.setColumns(10);
		S450_20T.setBounds(489, 270, 50, 20);
		getContentPane().add(S450_20T);

		S370_20T = new JTextField();
		S370_20T.setColumns(10);
		S370_20T.setBounds(489, 248, 50, 20);
		getContentPane().add(S370_20T);

		S300_20T = new JTextField();
		S300_20T.setColumns(10);
		S300_20T.setBounds(489, 226, 50, 20);
		getContentPane().add(S300_20T);

		S220_28T = new JTextField();
		S220_28T.setColumns(10);
		S220_28T.setBounds(549, 204, 50, 20);
		getContentPane().add(S220_28T);

		S500_28T = new JTextField();
		S500_28T.setColumns(10);
		S500_28T.setBounds(549, 292, 50, 20);
		getContentPane().add(S500_28T);

		S450_28T = new JTextField();
		S450_28T.setColumns(10);
		S450_28T.setBounds(549, 270, 50, 20);
		getContentPane().add(S450_28T);

		S370_28T = new JTextField();
		S370_28T.setColumns(10);
		S370_28T.setBounds(549, 248, 50, 20);
		getContentPane().add(S370_28T);

		S300_28T = new JTextField();
		S300_28T.setColumns(10);
		S300_28T.setBounds(549, 226, 50, 20);
		getContentPane().add(S300_28T);

		S220_20TRT = new JTextField();
		S220_20TRT.setColumns(10);
		S220_20TRT.setBounds(609, 204, 50, 20);
		getContentPane().add(S220_20TRT);

		S500_20TRT = new JTextField();
		S500_20TRT.setColumns(10);
		S500_20TRT.setBounds(609, 292, 50, 20);
		getContentPane().add(S500_20TRT);

		S450_20TRT = new JTextField();
		S450_20TRT.setColumns(10);
		S450_20TRT.setBounds(609, 270, 50, 20);
		getContentPane().add(S450_20TRT);

		S370_20TRT = new JTextField();
		S370_20TRT.setColumns(10);
		S370_20TRT.setBounds(609, 248, 50, 20);
		getContentPane().add(S370_20TRT);

		S300_20TRT = new JTextField();
		S300_20TRT.setColumns(10);
		S300_20TRT.setBounds(609, 226, 50, 20);
		getContentPane().add(S300_20TRT);

		S220_28TRT = new JTextField();
		S220_28TRT.setColumns(10);
		S220_28TRT.setBounds(670, 204, 50, 20);
		getContentPane().add(S220_28TRT);

		S500_28TRT = new JTextField();
		S500_28TRT.setColumns(10);
		S500_28TRT.setBounds(670, 292, 50, 20);
		getContentPane().add(S500_28TRT);

		S450_28TRT = new JTextField();
		S450_28TRT.setColumns(10);
		S450_28TRT.setBounds(670, 270, 50, 20);
		getContentPane().add(S450_28TRT);

		S370_28TRT = new JTextField();
		S370_28TRT.setColumns(10);
		S370_28TRT.setBounds(670, 248, 50, 20);
		getContentPane().add(S370_28TRT);

		S300_28TRT = new JTextField();
		S300_28TRT.setColumns(10);
		S300_28TRT.setBounds(670, 226, 50, 20);
		getContentPane().add(S300_28TRT);
	}

	public void Buscar(JTextField x) {
		int ultimo = 0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/cotizador", "root", "");
			Statement stmt = con.createStatement();
			String q = "SELECT " + x.getText() + " FROM acompapolicial";
			resultado = stmt.executeQuery(q);
			while (resultado.next()) {
				int a = resultado.getInt(x.getText());
				ultimo = a;

			}

		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

	public void llenaracompa() {

		int result = 0;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/cotizador", "root", "");
			Statement stmt = con.createStatement();
			for (int i = 0; i < valoracompa.length; i++) {
				String q = "SELECT  " + arrayacompa[i].getText() + "  FROM acompapolicial";
				resultadoacompa = stmt.executeQuery(q);
				if (resultadoacompa.next())
					result = resultadoacompa.getInt(apartic.getText());
				valoracompa[i] = result;
				System.out.println(result);
			}
			System.out.println(valoracompa);
			System.out.println(apartic.getText());
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}
}
