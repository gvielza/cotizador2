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

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.protocol.x.ReusableInputStream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class Valores extends JFrame {

	private JPanel contentPane;
	private JTextField tfpolbsas;
	private JTextField tfpolicaba;
	private JTextField tfpolineu;
	private JTextField tfpolistac;
	private JTextField tfpolistaf;

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
	private JTextField apartic;
	private JTextField operario;
	private JTextField F30;
	private JTextField F45;
	private JTextField F60;
	private JTextField F90;
	private JTextField F130;
	private JTextField F170;
	private JTextField F220;
	private JTextField F300;
	private JTextField F370;
	private JTextField F450;
	private JTextField F500;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JLabel lblNewLabel_11_1_5;
	private JLabel lblNewLabel_11_1_8;
	private JLabel lblNewLabel_11_1_6;
	private JLabel lblNewLabel_11_1_7;
	private JLabel lblNewLabel_11_1_9;

	public Valores() {

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 207, 50, 20);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_4 = new JLabel("20T");
		lblNewLabel_4.setBounds(132, 186, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 229, 50, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(132, 251, 50, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(132, 273, 50, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(132, 295, 50, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(132, 317, 50, 20);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("28T");
		lblNewLabel_4_1.setBounds(192, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("20TRT");
		lblNewLabel_4_2.setBounds(248, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("28TRT");
		lblNewLabel_4_3.setBounds(304, 186, 46, 14);
		getContentPane().add(lblNewLabel_4_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(188, 208, 50, 20);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(188, 317, 50, 20);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(188, 295, 50, 20);
		getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(188, 273, 50, 20);
		getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(188, 251, 50, 20);
		getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(188, 229, 50, 20);
		getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(244, 207, 50, 20);
		getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(244, 317, 50, 20);
		getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(244, 295, 50, 20);
		getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(244, 273, 50, 20);
		getContentPane().add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(244, 251, 50, 20);
		getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(244, 229, 50, 20);
		getContentPane().add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(300, 207, 50, 20);
		getContentPane().add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(300, 317, 50, 20);
		getContentPane().add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(300, 295, 50, 20);
		getContentPane().add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(300, 273, 50, 20);
		getContentPane().add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(300, 251, 50, 20);
		getContentPane().add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(300, 229, 50, 20);
		getContentPane().add(textField_23);
		
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
		System.out.println(ultimo);
	}
}
