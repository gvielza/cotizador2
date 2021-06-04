package cotizador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Position;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpbf.model.MainContents;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;

import com.mysql.cj.x.protobuf.MysqlxSession.Reset;
import com.mysql.cj.xdevapi.JsonParser;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Checkbox;
import java.awt.Choice;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import javax.swing.JMenuBar;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class Inicio extends JFrame {

	public JTextField textField_origen;
	private JTextField textField_destino;
	private JTextField tf_kmrec;
	private JTextField textFDIAS_OPER;
	private JTextField textFDiasR;
	private JTextField textField_diasC;
	private JTextField textField_dBSAS;
	private JTextField textField_dCABA;
	private JTextField textField_dNE;
	private JTextField textField_SCRUZ;
	private JTextField textField_dSFE;
	private ButtonGroup acompapoli = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();
	private ButtonGroup bg3 = new ButtonGroup();
	private JTextField textField_4;
	private ButtonGroup SEMI_KMTROS = new ButtonGroup();
	private ButtonGroup SEMI_FM = new ButtonGroup();
	private ButtonGroup CARM_AXH = new ButtonGroup();
	private ButtonGroup EXT_MET = new ButtonGroup();
	private ButtonGroup EXT_AXH = new ButtonGroup();
	private JTextField textField;
	private ButtonGroup tipocliente = new ButtonGroup();
	public double[] arraysemis = new double[55];

	public double[][] arraycmecanico = new double[5][7];
	public double[][][] arrayextensible = new double[3][5][6];
	public double[] arraymodloh = new double[6];
	public double[] arrayacompa = new double[7];
	public double [] arraypermisos=new double [5];
	  boolean permiso0,permiso1, permiso2, permiso3, permiso4=false;

	public void AgregarValoresDeSemis(double[] a) {
		Workbook w;
		int i = 0;
		try {
			w = WorkbookFactory.create(new File("datos.xlsx"));
			Sheet hoja = w.getSheetAt(0);
			Iterator<Row> col = hoja.rowIterator();
			while (col.hasNext()) {
				Row row = (Row) col.next();
				String cellValue = String.valueOf(row.getCell(1));
				arraysemis[i] = Double.parseDouble(cellValue);
				i++;
			}
			w.close();
			AgregarValoresDeSemisFueraMedida(arraysemis);
			AgregarValoresDeAcompa(arrayacompa);
			AgregarValoresDeMec(arraycmecanico);
			AgregarValoresDeExtensible(arrayextensible);
			AgregarValoresDemoduloHidra(arraymodloh);
			AgregarValoresDepermiso(arraypermisos);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void AgregarValoresDeSemisFueraMedida(double[] a) {
		Workbook w;
		int i = 44;
		try {
			w = WorkbookFactory.create(new File("datos.xlsx"));
			Sheet hoja = w.getSheetAt(1);
			Iterator<Row> col = hoja.rowIterator();
			while (col.hasNext()) {
				Row row = (Row) col.next();
				String cellValue = String.valueOf(row.getCell(1));
				arraysemis[i] = Double.parseDouble(cellValue);
				i++;
			}
			w.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void AgregarValoresDepermiso(double[] a) {
		Workbook w;
		int i = 0;
		try {
			w = WorkbookFactory.create(new File("datos.xlsx"));
			Sheet hoja = w.getSheetAt(6);
			Iterator<Row> col = hoja.rowIterator();
			while (col.hasNext()) {
				Row row = (Row) col.next();
				String cellValue = String.valueOf(row.getCell(1));
				a[i] = Double.parseDouble(cellValue);
				i++;
			}
			w.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void AgregarValoresDemoduloHidra(double[] a) {
		Workbook w;
		int i = 0;
		try {
			w = WorkbookFactory.create(new File("datos.xlsx"));
			Sheet hoja = w.getSheetAt(4);
			Iterator<Row> col = hoja.rowIterator();
			while (col.hasNext()) {
				Row row = (Row) col.next();
				String cellValue = String.valueOf(row.getCell(1));
				a[i] = Double.parseDouble(cellValue);
				i++;
			}
			w.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void AgregarValoresDeAcompa(double[] a) {
		Workbook w;
		int i = 0;
		try {
			w = WorkbookFactory.create(new File("datos.xlsx"));
			Sheet hoja = w.getSheetAt(5);
			Iterator<Row> col = hoja.rowIterator();
			while (col.hasNext()) {
				Row row = (Row) col.next();
				String cellValue = String.valueOf(row.getCell(1));
				arrayacompa[i] = Double.parseDouble(cellValue);
				i++;
			}
			w.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void AgregarValoresDeMec(double[][] a) {
		Workbook w;
		try {
			w = WorkbookFactory.create(new File("datos.xlsx"));
			Sheet hoja = w.getSheetAt(2);
			Iterator<Row> col = hoja.rowIterator();

			while (col.hasNext()) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 7; j++) {
						Row row = (Row) col.next();
						String cellValue = String.valueOf(row.getCell(1));
						a[i][j] = Double.parseDouble(cellValue);
					}
				}
			}
			w.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void AgregarValoresDeExtensible(double[][][] a) {
		Workbook w;
		try {
			w = WorkbookFactory.create(new File("datos.xlsx"));
			Sheet hoja = w.getSheetAt(3);
			Iterator<Row> col = hoja.rowIterator();
			while (col.hasNext()) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 5; j++) {
						for (int k = 0; k < 6; k++) {
							Row row = (Row) col.next();
							String cellValue = String.valueOf(row.getCell(1));
							a[i][j][k] = Double.parseDouble(cellValue);
						}
					}
				}
			}
			w.close();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	boolean acompañamientopolicial = false;
	boolean acompañamientoparticular = false;
	boolean operario = false;
	boolean pagoaccesible, pagomas60 = false;

	private JTextField tfValorXkm;
	private JTextField textFieldcarga;
	private JTextField textFieldDimens;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		getContentPane().setBackground(SystemColor.menu);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Cotizador TRANSPORTE EL TENAZ \uD83D\uDE9Awww.transporteseltenaz.com.ar\uD83D\uDE9A");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\tenaz.png"));
		getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().setForeground(Color.WHITE);
		setBounds(1, 1, 1000, 1000);
		getContentPane().setLayout(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		JLabel lblNewLabel = new JLabel("ORIGEN:");
		lblNewLabel.setBounds(48, 28, 52, 14);
		getContentPane().add(lblNewLabel);
		textField_origen = new JTextField();
		textField_origen.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField_origen.setBackground(new Color(255, 255, 240));
		textField_origen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField_origen.setForeground(new Color(0, 0, 0));
		textField_origen.setSelectionColor(new Color(0, 120, 215));
		textField_origen.setBounds(100, 25, 203, 20);
		getContentPane().add(textField_origen);
		textField_origen.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("DESTINO: ");
		lblNewLabel_1.setBounds(370, 28, 61, 14);
		getContentPane().add(lblNewLabel_1);

		textField_destino = new JTextField();
		textField_destino.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField_destino.setBounds(440, 25, 193, 20);
		getContentPane().add(textField_destino);
		textField_destino.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("KM RECORRIDOS:");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(48, 103, 103, 14);
		getContentPane().add(lblNewLabel_2);

		tf_kmrec = new JTextField();
		tf_kmrec.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		tf_kmrec.setBounds(165, 100, 52, 20);
		getContentPane().add(tf_kmrec);
		tf_kmrec.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("DIAS OPERATIVOS: ");
		lblNewLabel_3.setBounds(48, 78, 118, 14);
		getContentPane().add(lblNewLabel_3);

		textFDIAS_OPER = new JTextField();
		textFDIAS_OPER.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textFDIAS_OPER.setBounds(165, 75, 52, 20);
		getContentPane().add(textFDIAS_OPER);
		textFDIAS_OPER.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("DIAS RETORNOS: ");
		lblNewLabel_4.setBounds(277, 78, 103, 14);
		getContentPane().add(lblNewLabel_4);

		textFDiasR = new JTextField();
		textFDiasR.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textFDiasR.setBounds(379, 75, 52, 20);
		getContentPane().add(textFDiasR);
		textFDiasR.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("D\u00CDAS CARGA Y DESCARGA: ");
		lblNewLabel_5.setBounds(454, 78, 155, 14);
		getContentPane().add(lblNewLabel_5);

		textField_diasC = new JTextField();
		textField_diasC.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField_diasC.setBounds(608, 75, 43, 20);
		getContentPane().add(textField_diasC);
		textField_diasC.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("ACOMPA\u00D1AMIENTO POLICIAL :");
		lblNewLabel_6.setBackground(Color.DARK_GRAY);
		lblNewLabel_6.setBounds(48, 124, 193, 26);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("ACOMPA\u00D1AMIENTO PARTICULAR: ");
		lblNewLabel_7.setBounds(389, 127, 220, 20);
		getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("D\u00CDAS EN BS AS: ");
		lblNewLabel_8.setBounds(48, 161, 90, 14);
		getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_8_1 = new JLabel("D\u00CDAS EN C.A.B.A.: ");
		lblNewLabel_8_1.setBounds(48, 180, 103, 14);
		getContentPane().add(lblNewLabel_8_1);

		JLabel lblNewLabel_8_2 = new JLabel("D\u00CDAS EN NEUQUEN: ");
		lblNewLabel_8_2.setBounds(48, 200, 118, 14);
		getContentPane().add(lblNewLabel_8_2);

		JLabel lblNewLabel_8_3 = new JLabel("D\u00CDAS EN STA CRUZ: ");
		lblNewLabel_8_3.setBounds(48, 221, 118, 14);
		getContentPane().add(lblNewLabel_8_3);

		JLabel lblNewLabel_8_4 = new JLabel("D\u00CDAS EN STA FE: ");
		lblNewLabel_8_4.setBounds(48, 243, 103, 14);
		getContentPane().add(lblNewLabel_8_4);

		textField_dBSAS = new JTextField();
		textField_dBSAS.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField_dBSAS.setBounds(165, 156, 52, 20);
		getContentPane().add(textField_dBSAS);
		textField_dBSAS.setColumns(10);

		textField_dCABA = new JTextField();
		textField_dCABA.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField_dCABA.setColumns(10);
		textField_dCABA.setBounds(165, 176, 52, 20);
		getContentPane().add(textField_dCABA);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("PERMISO P.");
		rdbtnmntmNewRadioItem.setName("0");
		rdbtnmntmNewRadioItem.setBounds(247, 156, 133, 19);
		getContentPane().add(rdbtnmntmNewRadioItem);

		textField_dNE = new JTextField();
		textField_dNE.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField_dNE.setColumns(10);
		textField_dNE.setBounds(165, 196, 52, 20);
		getContentPane().add(textField_dNE);

		textField_SCRUZ = new JTextField();
		textField_SCRUZ.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField_SCRUZ.setColumns(10);
		textField_SCRUZ.setBounds(165, 216, 52, 20);
		getContentPane().add(textField_SCRUZ);

		textField_dSFE = new JTextField();
		textField_dSFE.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField_dSFE.setColumns(10);
		textField_dSFE.setBounds(165, 236, 52, 20);
		getContentPane().add(textField_dSFE);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("PERMISO P.");
		rdbtnmntmNewRadioItem_1.setBorder(null);
		rdbtnmntmNewRadioItem_1.setName("1");
		rdbtnmntmNewRadioItem_1.setBounds(247, 175, 133, 19);
		getContentPane().add(rdbtnmntmNewRadioItem_1);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("PERMISO P.");
		rdbtnmntmNewRadioItem_2.setName("2");
		rdbtnmntmNewRadioItem_2.setBounds(247, 195, 133, 19);
		getContentPane().add(rdbtnmntmNewRadioItem_2);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_3 = new JRadioButtonMenuItem("PERMISO P.");
		rdbtnmntmNewRadioItem_3.setName("3");
		rdbtnmntmNewRadioItem_3.setBounds(247, 216, 133, 19);
		getContentPane().add(rdbtnmntmNewRadioItem_3);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_4 = new JRadioButtonMenuItem("PERMISO P.");
		rdbtnmntmNewRadioItem_4.setName("4");
		rdbtnmntmNewRadioItem_4.setBounds(247, 238, 133, 19);
		getContentPane().add(rdbtnmntmNewRadioItem_4);

		JRadioButton policialsi = new JRadioButton("SI");
		policialsi.setBackground(Color.LIGHT_GRAY);
		policialsi.setBounds(247, 124, 43, 23);
		getContentPane().add(policialsi);

		JRadioButton policialno = new JRadioButton("NO");
		policialno.setBackground(Color.LIGHT_GRAY);
		policialno.setBounds(287, 124, 43, 23);
		getContentPane().add(policialno);

		JRadioButton particularsi = new JRadioButton("SI");
		particularsi.setBackground(Color.LIGHT_GRAY);
		particularsi.setBounds(608, 124, 43, 23);
		getContentPane().add(particularsi);

		JRadioButton particularno = new JRadioButton("NO");
		particularno.setBackground(Color.LIGHT_GRAY);
		particularno.setBounds(655, 124, 43, 23);
		getContentPane().add(particularno);

		JLabel lblNewLabel_9 = new JLabel("OPERARIO: ");
		lblNewLabel_9.setBounds(448, 161, 95, 14);
		getContentPane().add(lblNewLabel_9);

		JRadioButton operariosi = new JRadioButton("SI");
		operariosi.setToolTipText("");
		operariosi.setBounds(524, 157, 109, 23);
		getContentPane().add(operariosi);

		JRadioButton operariono = new JRadioButton("NO");
		operariono.setBounds(524, 180, 109, 23);
		getContentPane().add(operariono);

		acompapoli.add(policialsi);
		acompapoli.add(policialno);
		bg2.add(particularsi);
		bg2.add(particularno);
		bg3.add(operariosi);
		bg3.add(operariono);

		JLabel lblNewLabel_10 = new JLabel("CTDAD D\u00CDAS:");
		lblNewLabel_10.setBounds(446, 221, 84, 17);
		getContentPane().add(lblNewLabel_10);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(523, 218, 86, 20);
		textField_4.setText(textFDIAS_OPER.getText());

		getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("SEMI 30KM");
		lblNewLabel_11.setForeground(new Color(128, 0, 0));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(48, 269, 73, 14);
		getContentPane().add(lblNewLabel_11);

		JLabel lblNewLabel_11_1 = new JLabel("SEMI 45KM");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1.setBounds(48, 290, 73, 14);
		getContentPane().add(lblNewLabel_11_1);

		JLabel lblNewLabel_11_1_1 = new JLabel("SEMI 60KM");
		lblNewLabel_11_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_1.setBounds(48, 309, 73, 14);
		getContentPane().add(lblNewLabel_11_1_1);

		JLabel lblNewLabel_11_1_2 = new JLabel("SEMI 90KM");
		lblNewLabel_11_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_2.setBounds(48, 328, 73, 14);
		getContentPane().add(lblNewLabel_11_1_2);

		JLabel lblNewLabel_11_1_3 = new JLabel("SEMI 130KM");
		lblNewLabel_11_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_3.setBounds(48, 348, 73, 14);
		getContentPane().add(lblNewLabel_11_1_3);

		JLabel lblNewLabel_11_1_4 = new JLabel("SEMI 170KM");
		lblNewLabel_11_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_4.setBounds(48, 371, 73, 14);
		getContentPane().add(lblNewLabel_11_1_4);

		JLabel lblNewLabel_11_1_5 = new JLabel("SEMI 220KM");
		lblNewLabel_11_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_5.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_5.setBounds(431, 269, 90, 14);
		getContentPane().add(lblNewLabel_11_1_5);

		JLabel lblNewLabel_11_1_6 = new JLabel("SEMI 300KM");
		lblNewLabel_11_1_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_6.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_6.setBounds(431, 288, 90, 14);
		getContentPane().add(lblNewLabel_11_1_6);

		JLabel lblNewLabel_11_1_7 = new JLabel("SEMI 370KM");
		lblNewLabel_11_1_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_7.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_7.setBounds(431, 307, 90, 14);
		getContentPane().add(lblNewLabel_11_1_7);

		JLabel lblNewLabel_11_1_8 = new JLabel("SEMI 450KM");
		lblNewLabel_11_1_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_8.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_8.setBounds(431, 327, 90, 14);
		getContentPane().add(lblNewLabel_11_1_8);

		JLabel lblNewLabel_11_1_8_1 = new JLabel("SEMI 500KM");
		lblNewLabel_11_1_8_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11_1_8_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_11_1_8_1.setBounds(431, 348, 90, 14);
		getContentPane().add(lblNewLabel_11_1_8_1);

		JRadioButton S30_20T = new JRadioButton("20T");
		S30_20T.setName("1");
		S30_20T.setBounds(138, 264, 63, 23);
		getContentPane().add(S30_20T);

		JRadioButton S45_20T = new JRadioButton("20T");
		S45_20T.setName("2");
		S45_20T.setBounds(138, 285, 63, 23);
		getContentPane().add(S45_20T);

		JRadioButton S60_20T = new JRadioButton("20T");
		S60_20T.setName("3");
		S60_20T.setBounds(138, 304, 63, 23);
		getContentPane().add(S60_20T);

		JRadioButton S90_20T = new JRadioButton("20T");
		S90_20T.setName("4");
		S90_20T.setBounds(138, 324, 61, 23);
		getContentPane().add(S90_20T);

		JRadioButton S130_20T = new JRadioButton("20T");
		S130_20T.setName("5");
		S130_20T.setBounds(138, 343, 63, 23);
		getContentPane().add(S130_20T);

		JRadioButton S170_20T = new JRadioButton("20T");
		S170_20T.setName("6");
		S170_20T.setBounds(138, 366, 63, 23);
		getContentPane().add(S170_20T);

		JRadioButton S30_28T = new JRadioButton("28T");
		S30_28T.setName("12");
		S30_28T.setBounds(201, 265, 63, 23);
		getContentPane().add(S30_28T);

		JRadioButton S45_28T = new JRadioButton("28T");
		S45_28T.setName("13");
		S45_28T.setBounds(201, 286, 63, 23);
		getContentPane().add(S45_28T);

		JRadioButton S60_28T = new JRadioButton("28T");
		S60_28T.setName("14");
		S60_28T.setBounds(201, 305, 63, 23);
		getContentPane().add(S60_28T);

		JRadioButton S130_28T = new JRadioButton("28T");
		S130_28T.setName("16");
		S130_28T.setBounds(201, 344, 63, 23);
		getContentPane().add(S130_28T);

		JRadioButton S90_28T = new JRadioButton("28T");
		S90_28T.setName("15");
		S90_28T.setBounds(201, 324, 63, 23);
		getContentPane().add(S90_28T);

		JRadioButton S170_28T = new JRadioButton("28T");
		S170_28T.setName("17");
		S170_28T.setBounds(201, 367, 63, 23);
		getContentPane().add(S170_28T);

		JRadioButton S30_20TRT = new JRadioButton("20T RT");
		S30_20TRT.setName("23");
		S30_20TRT.setBounds(267, 265, 73, 23);
		getContentPane().add(S30_20TRT);

		JRadioButton S45_20TRT = new JRadioButton("20T RT");
		S45_20TRT.setName("24");
		S45_20TRT.setBounds(266, 286, 73, 23);
		getContentPane().add(S45_20TRT);

		JRadioButton S60_20TRT = new JRadioButton("20T RT");
		S60_20TRT.setName("25");
		S60_20TRT.setBounds(266, 305, 73, 23);
		getContentPane().add(S60_20TRT);

		JRadioButton S90_20TRT = new JRadioButton("20T RT");
		S90_20TRT.setName("26");
		S90_20TRT.setBounds(266, 324, 73, 23);
		getContentPane().add(S90_20TRT);

		JRadioButton S130_20TRT = new JRadioButton("20T RT");
		S130_20TRT.setName("27");
		S130_20TRT.setBounds(267, 344, 73, 23);
		getContentPane().add(S130_20TRT);

		JRadioButton S170_20TRT = new JRadioButton("20T RT");
		S170_20TRT.setName("28");
		S170_20TRT.setBounds(266, 367, 73, 23);
		getContentPane().add(S170_20TRT);

		JRadioButton S30_28TRT = new JRadioButton("28T RT");
		S30_28TRT.setName("34");
		S30_28TRT.setBounds(342, 265, 73, 23);
		getContentPane().add(S30_28TRT);

		JRadioButton S45_28TRT = new JRadioButton("28T RT");
		S45_28TRT.setName("35");
		S45_28TRT.setBounds(342, 286, 73, 23);
		getContentPane().add(S45_28TRT);

		JRadioButton S60_28TRT = new JRadioButton("28T RT");
		S60_28TRT.setName("36");
		S60_28TRT.setBounds(341, 305, 73, 23);
		getContentPane().add(S60_28TRT);

		JRadioButton S90_28TRT = new JRadioButton("28T RT");
		S90_28TRT.setName("37");
		S90_28TRT.setBounds(342, 324, 73, 23);
		getContentPane().add(S90_28TRT);

		JRadioButton S130_28TRT = new JRadioButton("28T RT");
		S130_28TRT.setName("38");
		S130_28TRT.setBounds(341, 344, 73, 23);
		getContentPane().add(S130_28TRT);

		JRadioButton S170_28TRT = new JRadioButton("28T RT");
		S170_28TRT.setName("39");
		S170_28TRT.setBounds(342, 367, 73, 23);
		getContentPane().add(S170_28TRT);

		JRadioButton S220_20T = new JRadioButton("20T");
		S220_20T.setName("7");
		S220_20T.setBounds(521, 264, 63, 23);
		getContentPane().add(S220_20T);

		JRadioButton S300_20T = new JRadioButton("20T");
		S300_20T.setName("8");
		S300_20T.setBounds(521, 285, 63, 23);
		getContentPane().add(S300_20T);

		JRadioButton S370_20T = new JRadioButton("20T");
		S370_20T.setName("9");
		S370_20T.setBounds(521, 304, 63, 23);
		getContentPane().add(S370_20T);

		JRadioButton S450_20T = new JRadioButton("20T");
		S450_20T.setName("10");
		S450_20T.setBounds(521, 324, 61, 23);
		getContentPane().add(S450_20T);

		JRadioButton S500_20T = new JRadioButton("20T");
		S500_20T.setName("11");
		S500_20T.setBounds(521, 343, 63, 23);
		getContentPane().add(S500_20T);

		JRadioButton S220_28T = new JRadioButton("28T");
		S220_28T.setName("18");
		S220_28T.setBounds(584, 265, 63, 23);
		getContentPane().add(S220_28T);

		JRadioButton S370_28T = new JRadioButton("28T");
		S370_28T.setName("20");
		S370_28T.setBounds(584, 305, 63, 23);
		getContentPane().add(S370_28T);

		JRadioButton S300_28T = new JRadioButton("28T");
		S300_28T.setName("19");
		S300_28T.setBounds(584, 286, 63, 23);
		getContentPane().add(S300_28T);

		JRadioButton S450_28T = new JRadioButton("28T");
		S450_28T.setName("21");
		S450_28T.setBounds(584, 324, 63, 23);
		getContentPane().add(S450_28T);

		JRadioButton S500_28T = new JRadioButton("28T");
		S500_28T.setName("22");
		S500_28T.setBounds(584, 344, 63, 23);
		getContentPane().add(S500_28T);

		JRadioButton S220_20TRT = new JRadioButton("20T RT");
		S220_20TRT.setName("29");
		S220_20TRT.setBounds(650, 265, 73, 23);
		getContentPane().add(S220_20TRT);

		JRadioButton S220_28TRT = new JRadioButton("28T RT");
		S220_28TRT.setName("40");
		S220_28TRT.setBounds(725, 265, 73, 23);
		getContentPane().add(S220_28TRT);

		JRadioButton S300_28TRT = new JRadioButton("28T RT");
		S300_28TRT.setName("41");
		S300_28TRT.setBounds(725, 286, 73, 23);
		getContentPane().add(S300_28TRT);

		JRadioButton S300_20TRT = new JRadioButton("20T RT");
		S300_20TRT.setName("30");
		S300_20TRT.setBounds(649, 286, 73, 23);
		getContentPane().add(S300_20TRT);

		JRadioButton S370_20TRT = new JRadioButton("20T RT");
		S370_20TRT.setName("31");
		S370_20TRT.setBounds(649, 305, 73, 23);
		getContentPane().add(S370_20TRT);

		JRadioButton S370_28TRT = new JRadioButton("28T RT");
		S370_28TRT.setName("42");
		S370_28TRT.setBounds(724, 305, 73, 23);
		getContentPane().add(S370_28TRT);

		JRadioButton S450_28TRT = new JRadioButton("28T RT");
		S450_28TRT.setName("43");
		S450_28TRT.setBounds(725, 324, 73, 23);
		getContentPane().add(S450_28TRT);

		JRadioButton S450_20TRT = new JRadioButton("20T RT");
		S450_20TRT.setName("32");
		S450_20TRT.setBounds(649, 324, 73, 23);
		getContentPane().add(S450_20TRT);

		JRadioButton S500_20TRT = new JRadioButton("20T RT");
		S500_20TRT.setName("33");
		S500_20TRT.setBounds(650, 344, 73, 23);
		getContentPane().add(S500_20TRT);

		JRadioButton S500_28TRT = new JRadioButton("28T RT");
		S500_28TRT.setName("44");
		S500_28TRT.setBounds(724, 344, 73, 23);
		getContentPane().add(S500_28TRT);

		SEMI_KMTROS.add(S30_20T);
		SEMI_KMTROS.add(S30_28T);
		SEMI_KMTROS.add(S30_28TRT);
		SEMI_KMTROS.add(S30_20TRT);

		SEMI_KMTROS.add(S45_20T);
		SEMI_KMTROS.add(S45_28T);
		SEMI_KMTROS.add(S45_28TRT);
		SEMI_KMTROS.add(S45_20TRT);

		SEMI_KMTROS.add(S60_20T);
		SEMI_KMTROS.add(S60_28T);
		SEMI_KMTROS.add(S60_28TRT);
		SEMI_KMTROS.add(S60_20TRT);

		SEMI_KMTROS.add(S90_20T);
		SEMI_KMTROS.add(S90_28T);
		SEMI_KMTROS.add(S90_28TRT);
		SEMI_KMTROS.add(S90_20TRT);

		SEMI_KMTROS.add(S130_20T);
		SEMI_KMTROS.add(S130_28T);
		SEMI_KMTROS.add(S130_28TRT);
		SEMI_KMTROS.add(S130_20TRT);

		SEMI_KMTROS.add(S170_20T);
		SEMI_KMTROS.add(S170_28T);
		SEMI_KMTROS.add(S170_28TRT);
		SEMI_KMTROS.add(S170_20TRT);

		SEMI_KMTROS.add(S220_20T);
		SEMI_KMTROS.add(S220_28T);
		SEMI_KMTROS.add(S220_28TRT);
		SEMI_KMTROS.add(S220_20TRT);

		SEMI_KMTROS.add(S300_20T);
		SEMI_KMTROS.add(S300_28T);
		SEMI_KMTROS.add(S300_28TRT);
		SEMI_KMTROS.add(S300_20TRT);

		SEMI_KMTROS.add(S370_20T);
		SEMI_KMTROS.add(S370_28T);
		SEMI_KMTROS.add(S370_28TRT);
		SEMI_KMTROS.add(S370_20TRT);

		SEMI_KMTROS.add(S450_20T);
		SEMI_KMTROS.add(S450_28T);
		SEMI_KMTROS.add(S450_28TRT);
		SEMI_KMTROS.add(S450_20TRT);

		SEMI_KMTROS.add(S500_20T);
		SEMI_KMTROS.add(S500_28T);
		SEMI_KMTROS.add(S500_28TRT);
		SEMI_KMTROS.add(S500_20TRT);

		JLabel SFM = new JLabel("SFM(15 X 2.90 X 2.90 X 26T)KM");
		SFM.setForeground(new Color(128, 0, 0));
		SFM.setFont(new Font("Tahoma", Font.BOLD, 11));
		SFM.setBounds(48, 396, 193, 14);
		getContentPane().add(SFM);

		JRadioButton SFM30 = new JRadioButton("30");
		SFM30.setName("45");
		SFM30.setBounds(225, 393, 39, 23);
		getContentPane().add(SFM30);

		JRadioButton SFM45 = new JRadioButton("45");
		SFM45.setName("46");
		SFM45.setBounds(277, 393, 43, 23);
		getContentPane().add(SFM45);

		JRadioButton SFM60 = new JRadioButton("60");
		SFM60.setName("47");
		SFM60.setBounds(322, 393, 43, 23);
		getContentPane().add(SFM60);

		JRadioButton SFM90 = new JRadioButton("90");
		SFM90.setName("48");
		SFM90.setBounds(370, 393, 45, 23);
		getContentPane().add(SFM90);

		JRadioButton SFM130 = new JRadioButton("130");
		SFM130.setName("49");
		SFM130.setBounds(417, 392, 52, 23);
		getContentPane().add(SFM130);

		JRadioButton SFM170 = new JRadioButton("170");
		SFM170.setName("50");
		SFM170.setBounds(471, 392, 52, 23);
		getContentPane().add(SFM170);

		JRadioButton SFM220 = new JRadioButton("220");
		SFM220.setName("51");
		SFM220.setBounds(524, 392, 52, 23);
		getContentPane().add(SFM220);

		JRadioButton SFM300 = new JRadioButton("300");
		SFM300.setName("52");
		SFM300.setBounds(584, 392, 52, 23);
		getContentPane().add(SFM300);

		JRadioButton SFM370 = new JRadioButton("370");
		SFM370.setName("53");
		SFM370.setBounds(632, 392, 52, 23);
		getContentPane().add(SFM370);

		JRadioButton SFM450 = new JRadioButton("450");
		SFM450.setName("54");
		SFM450.setBounds(684, 392, 52, 23);
		getContentPane().add(SFM450);

		JRadioButton SFM500 = new JRadioButton("500");
		SFM500.setName("55");
		SFM500.setBounds(735, 392, 52, 23);
		getContentPane().add(SFM500);

		SEMI_KMTROS.add(SFM30);
		SEMI_KMTROS.add(SFM45);
		SEMI_KMTROS.add(SFM60);
		SEMI_KMTROS.add(SFM90);
		SEMI_KMTROS.add(SFM130);
		SEMI_KMTROS.add(SFM170);
		SEMI_KMTROS.add(SFM220);
		SEMI_KMTROS.add(SFM300);
		SEMI_KMTROS.add(SFM370);
		SEMI_KMTROS.add(SFM450);
		SEMI_KMTROS.add(SFM500);

		JLabel CARM = new JLabel("CARRETON MEC:");
		CARM.setForeground(new Color(128, 0, 0));
		CARM.setFont(new Font("Tahoma", Font.BOLD, 11));
		CARM.setBounds(93, 421, 106, 14);
		getContentPane().add(CARM);

		JLabel AnchoXAlt = new JLabel("ANCHO X ALT:");
		AnchoXAlt.setForeground(new Color(128, 0, 0));
		AnchoXAlt.setFont(new Font("Tahoma", Font.BOLD, 11));
		AnchoXAlt.setBounds(267, 421, 106, 14);
		getContentPane().add(AnchoXAlt);

		JRadioButton CM20T = new JRadioButton("20T");
		CM20T.setName("0");
		CM20T.setBounds(103, 437, 52, 20);
		getContentPane().add(CM20T);

		JRadioButton CM30T = new JRadioButton("30T");
		CM30T.setName("1");
		CM30T.setBounds(103, 460, 52, 20);
		getContentPane().add(CM30T);

		JRadioButton CM40T = new JRadioButton("40T");
		CM40T.setName("2");
		CM40T.setBounds(103, 482, 52, 20);
		getContentPane().add(CM40T);

		JRadioButton CM50T = new JRadioButton("50T");
		CM50T.setName("3");
		CM50T.setBounds(165, 437, 52, 20);
		getContentPane().add(CM50T);

		JRadioButton CM60T = new JRadioButton("60T");
		CM60T.setName("4");
		CM60T.setBounds(165, 460, 52, 20);
		getContentPane().add(CM60T);

		JRadioButton A330X330 = new JRadioButton("330X330");
		A330X330.setName("0");
		A330X330.setBounds(271, 436, 78, 23);
		getContentPane().add(A330X330);

		JRadioButton A365X330 = new JRadioButton("365X330");
		A365X330.setName("1");
		A365X330.setBounds(271, 459, 78, 23);
		getContentPane().add(A365X330);

		JRadioButton A365X360 = new JRadioButton("365X360");
		A365X360.setName("2");
		A365X360.setBounds(271, 482, 78, 23);
		getContentPane().add(A365X360);

		JRadioButton A390X360 = new JRadioButton("390X360");
		A390X360.setName("3");
		A390X360.setBounds(360, 436, 78, 23);
		getContentPane().add(A390X360);

		JRadioButton A420X360 = new JRadioButton("420X360");
		A420X360.setName("4");
		A420X360.setBounds(360, 459, 78, 23);
		getContentPane().add(A420X360);

		JRadioButton A500X400 = new JRadioButton("500X400");
		A500X400.setName("5");
		A500X400.setBounds(360, 482, 78, 23);
		getContentPane().add(A500X400);

		JRadioButton A500X460 = new JRadioButton("500X460");
		A500X460.setName("6");
		A500X460.setBounds(452, 436, 78, 23);
		getContentPane().add(A500X460);

		JLabel EXTENSIBLE = new JLabel("EXTENSIBLE:");
		EXTENSIBLE.setForeground(new Color(128, 0, 0));
		EXTENSIBLE.setFont(new Font("Tahoma", Font.BOLD, 11));
		EXTENSIBLE.setBounds(93, 504, 106, 14);
		getContentPane().add(EXTENSIBLE);

		JRadioButton EXT20T = new JRadioButton("EXT20T");
		EXT20T.setName("0");
		EXT20T.setBounds(100, 518, 73, 23);
		getContentPane().add(EXT20T);

		JRadioButton EXT28T = new JRadioButton("EXT28T");
		EXT28T.setName("1");
		EXT28T.setBounds(100, 538, 73, 23);
		getContentPane().add(EXT28T);

		JRadioButton EXT35T = new JRadioButton("EXT35T");
		EXT35T.setName("2");
		EXT35T.setBounds(100, 558, 73, 23);
		getContentPane().add(EXT35T);

		JRadioButton EXT18M = new JRadioButton("EXT18M");
		EXT18M.setName("0");
		EXT18M.setBounds(231, 518, 73, 23);
		getContentPane().add(EXT18M);

		JRadioButton EXT20M = new JRadioButton("EXT20M");
		EXT20M.setName("1");
		EXT20M.setBounds(230, 538, 73, 23);
		getContentPane().add(EXT20M);

		JRadioButton EXT22M = new JRadioButton("EXT22M");
		EXT22M.setName("2");
		EXT22M.setBounds(231, 558, 73, 23);
		getContentPane().add(EXT22M);

		JRadioButton EXT24M = new JRadioButton("EXT24M");
		EXT24M.setName("3");
		EXT24M.setBounds(307, 518, 73, 23);
		getContentPane().add(EXT24M);

		JRadioButton EXT26M = new JRadioButton("EXT26M");
		EXT26M.setName("4");
		EXT26M.setBounds(307, 538, 73, 23);
		getContentPane().add(EXT26M);

		JRadioButton EXT260X260 = new JRadioButton("260X260");
		EXT260X260.setName("0");
		EXT260X260.setBounds(454, 518, 89, 23);
		getContentPane().add(EXT260X260);

		JRadioButton EXT300X300 = new JRadioButton("300X300");
		EXT300X300.setName("1");
		EXT300X300.setBounds(454, 538, 89, 23);
		getContentPane().add(EXT300X300);

		JRadioButton EXT330X330 = new JRadioButton("330X330");
		EXT330X330.setName("2");
		EXT330X330.setBounds(454, 558, 89, 23);
		getContentPane().add(EXT330X330);

		JRadioButton EXT365X330 = new JRadioButton("365X330");
		EXT365X330.setName("3");
		EXT365X330.setBounds(545, 518, 89, 23);
		getContentPane().add(EXT365X330);

		JRadioButton EXT365X360 = new JRadioButton("365X360");
		EXT365X360.setName("4");
		EXT365X360.setBounds(545, 538, 89, 23);
		getContentPane().add(EXT365X360);

		JRadioButton EXT365X380 = new JRadioButton("365X380");
		EXT365X380.setName("5");
		EXT365X380.setBounds(544, 558, 89, 23);
		getContentPane().add(EXT365X380);

		SEMI_KMTROS.add(CM20T);
		SEMI_KMTROS.add(CM30T);
		SEMI_KMTROS.add(CM40T);
		SEMI_KMTROS.add(CM50T);
		SEMI_KMTROS.add(CM60T);
		SEMI_KMTROS.add(EXT20T);
		SEMI_KMTROS.add(EXT28T);
		SEMI_KMTROS.add(EXT35T);

		CARM_AXH.add(A330X330);
		CARM_AXH.add(A365X330);
		CARM_AXH.add(A365X360);
		CARM_AXH.add(A390X360);
		CARM_AXH.add(A420X360);
		CARM_AXH.add(A500X400);
		CARM_AXH.add(A500X460);

		EXT_MET.add(EXT18M);
		EXT_MET.add(EXT20M);
		EXT_MET.add(EXT22M);
		EXT_MET.add(EXT24M);
		EXT_MET.add(EXT26M);

		EXT_AXH.add(EXT260X260);
		EXT_AXH.add(EXT300X300);
		EXT_AXH.add(EXT330X330);
		EXT_AXH.add(EXT365X330);
		EXT_AXH.add(EXT365X360);
		EXT_AXH.add(EXT365X380);

		JRadioButton T_ACCESIBLE = new JRadioButton("TARIFA ACCESIBLE:");
		T_ACCESIBLE.setForeground(new Color(0, 0, 205));
		T_ACCESIBLE.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		T_ACCESIBLE.setBounds(608, 631, 155, 23);
		getContentPane().add(T_ACCESIBLE);

		JRadioButton T_ESTANDAR = new JRadioButton("TARIFA ESTANDAR:");
		T_ESTANDAR.setSelected(true);
		T_ESTANDAR.setForeground(new Color(0, 0, 205));
		T_ESTANDAR.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		T_ESTANDAR.setBounds(608, 606, 155, 23);
		getContentPane().add(T_ESTANDAR);

		JRadioButton PAGOMASDIAS = new JRadioButton("PAGO>60 DIAS:");
		PAGOMASDIAS.setForeground(new Color(0, 0, 205));
		PAGOMASDIAS.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		PAGOMASDIAS.setBounds(608, 657, 166, 23);
		getContentPane().add(PAGOMASDIAS);

		JButton btnCotizar = new JButton("COTIZAR \uD83D\uDCC3");
		btnCotizar.setBackground(SystemColor.textHighlight);
		btnCotizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnmntmNewRadioItem.isSelected()) {
					permiso0=true;
				}
				if(rdbtnmntmNewRadioItem_1.isSelected()) {
					permiso1=true;
				}
				if(rdbtnmntmNewRadioItem_2.isSelected()) {
					permiso2=true;
				}
				if(rdbtnmntmNewRadioItem_3.isSelected()) {
					permiso3=true;
				}
				if(rdbtnmntmNewRadioItem_4.isSelected()) {
					permiso4=true;
				}
				
				

				if (policialsi.isSelected()) {
					acompañamientopolicial = true;
				}
				if (particularsi.isSelected()) {
					acompañamientoparticular = true;
				}
				if (operariosi.isSelected()) {
					operario = true;
				}
				if (T_ACCESIBLE.isSelected()) {
					pagoaccesible = true;
				}
				if (PAGOMASDIAS.isSelected()) {
					pagomas60 = true;
				}
				try {
					AgregarValoresDeSemis(arraysemis);
					crearWord();
					JOptionPane.showConfirmDialog(null,
							"Se ha generado su presupuesto en formato docx con el nombre presupuesto " + FechaActual());
				} catch (IOException e1) {
				JOptionPane.showInternalMessageDialog(null, "mal");
					e1.printStackTrace();
				}

			}
		});
		btnCotizar.setBounds(808, 631, 118, 23);
		getContentPane().add(btnCotizar);

		JLabel lblModeloHidra = new JLabel("MODULO HIDRAULICO:");
		lblModeloHidra.setForeground(new Color(128, 0, 0));
		lblModeloHidra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModeloHidra.setBounds(95, 588, 146, 14);
		getContentPane().add(lblModeloHidra);

		JLabel lblNewLabel_3_1 = new JLabel("CTDAD LINEAS:");
		lblNewLabel_3_1.setBounds(93, 610, 95, 14);
		getContentPane().add(lblNewLabel_3_1);

		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textField.setColumns(10);
		textField.setBounds(181, 607, 52, 20);
		getContentPane().add(textField);

		JRadioButton H330X330X15 = new JRadioButton("330X330X15");
		H330X330X15.setName("0");
		H330X330X15.setBounds(93, 631, 115, 23);
		getContentPane().add(H330X330X15);

		JRadioButton H330X330X22 = new JRadioButton("330X330X22");
		H330X330X22.setName("1");
		H330X330X22.setBounds(93, 657, 115, 23);
		getContentPane().add(H330X330X22);

		JRadioButton H330X365X22 = new JRadioButton("330X365X22");
		H330X365X22.setName("2");
		H330X365X22.setBounds(93, 683, 124, 23);
		getContentPane().add(H330X365X22);

		JRadioButton H390X365X24 = new JRadioButton("390X365X24");
		H390X365X24.setName("3");
		H390X365X24.setBounds(241, 634, 99, 23);
		getContentPane().add(H390X365X24);

		JRadioButton H410X360X30 = new JRadioButton("410X360X30");
		H410X360X30.setName("4");
		H410X360X30.setBounds(241, 657, 99, 23);
		getContentPane().add(H410X360X30);

		JRadioButton H410X360X35 = new JRadioButton("410X360X35");
		H410X360X35.setName("5");
		H410X360X35.setBounds(241, 683, 99, 23);
		getContentPane().add(H410X360X35);

		SEMI_KMTROS.add(H410X360X35);
		SEMI_KMTROS.add(H330X330X15);
		SEMI_KMTROS.add(H330X330X22);
		SEMI_KMTROS.add(H330X365X22);
		SEMI_KMTROS.add(H390X365X24);
		SEMI_KMTROS.add(H410X360X30);

		tipocliente.add(T_ACCESIBLE);
		tipocliente.add(T_ESTANDAR);
		tipocliente.add(PAGOMASDIAS);

		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("src\\imagenes\\tenaz.png"));
		lblNewLabel_12.setBounds(907, 40, 172, 135);
		getContentPane().add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("VALOR X KM:");
		lblNewLabel_13.setForeground(Color.BLUE);
		lblNewLabel_13.setBounds(287, 103, 75, 14);
		getContentPane().add(lblNewLabel_13);

		tfValorXkm = new JTextField();
		tfValorXkm.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		tfValorXkm.setBounds(379, 100, 52, 20);
		getContentPane().add(tfValorXkm);
		tfValorXkm.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("CARGA:");
		lblNewLabel_14.setBounds(48, 53, 43, 14);
		getContentPane().add(lblNewLabel_14);

		textFieldcarga = new JTextField();
		textFieldcarga.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textFieldcarga.setColumns(10);
		textFieldcarga.setBounds(100, 50, 203, 20);
		getContentPane().add(textFieldcarga);

		JLabel lblNewLabel_14_1 = new JLabel("DIMENSION:");
		lblNewLabel_14_1.setBounds(370, 53, 68, 14);
		getContentPane().add(lblNewLabel_14_1);

		textFieldDimens = new JTextField();
		textFieldDimens.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		textFieldDimens.setColumns(10);
		textFieldDimens.setBounds(440, 50, 93, 20);
		getContentPane().add(textFieldDimens);
	}

	public JRadioButton getSelection(ButtonGroup group) {
		for (Enumeration<AbstractButton> e = group.getElements(); e.hasMoreElements();) {
			JRadioButton b = (JRadioButton) e.nextElement();
			if (b.getModel() == group.getSelection()) {
				return b;
			}
		}

		return null;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void crearWord() throws IOException {
		XWPFDocument documento = new XWPFDocument();

		Font fuente2 = new Font("Times New Roman", Font.PLAIN, 10);
		XWPFParagraph parrafo = documento.createParagraph();
		XWPFParagraph parrafo2 = documento.createParagraph();
		XWPFParagraph parrafo3 = documento.createParagraph();
		XWPFParagraph parrafo33 = documento.createParagraph();
		XWPFParagraph parrafo4 = documento.createParagraph();
		XWPFParagraph parrafo5 = documento.createParagraph();
		XWPFParagraph parrafo6 = documento.createParagraph();
		XWPFParagraph parrafo7 = documento.createParagraph();
		XWPFParagraph parrafo8 = documento.createParagraph();
		XWPFParagraph parrafo9 = documento.createParagraph();
		XWPFParagraph parrafo10 = documento.createParagraph();
		XWPFParagraph parrafo11 = documento.createParagraph();
		XWPFParagraph parrafo12 = documento.createParagraph();
		XWPFParagraph parrafo13 = documento.createParagraph();
		XWPFParagraph parrafo14 = documento.createParagraph();
		XWPFParagraph parrafo15 = documento.createParagraph();
		XWPFParagraph parrafo16 = documento.createParagraph();
		XWPFParagraph parrafo17 = documento.createParagraph();
		XWPFParagraph parrafo18 = documento.createParagraph();

		XWPFRun temprun = parrafo.createRun();
		XWPFRun temprun2 = parrafo2.createRun();
		XWPFRun tempEstimad = parrafo3.createRun();
		XWPFRun tempOriyD = parrafo4.createRun();
		XWPFRun tempDIME = parrafo33.createRun();
		XWPFRun tempservT = parrafo5.createRun();
		XWPFRun tempunidad = parrafo6.createRun();
		XWPFRun tempvalor = parrafo7.createRun();
		XWPFRun tempcondiciones = parrafo8.createRun();
		XWPFRun tempcond1 = parrafo9.createRun();
		XWPFRun tempcond2 = parrafo10.createRun();
		XWPFRun tempcond3 = parrafo11.createRun();
		XWPFRun tempcond4 = parrafo12.createRun();
		XWPFRun tempcond5 = parrafo13.createRun();
		XWPFRun tempcond6 = parrafo14.createRun();
		XWPFRun tempcond7 = parrafo15.createRun();
		XWPFRun tempcond8 = parrafo16.createRun();
		XWPFRun tempcond9 = parrafo17.createRun();
		XWPFRun tempcond10 = parrafo18.createRun();
		InputStream pic = new FileInputStream(
				"src\\imagenes\\tenazw.png");
		try {
			temprun.addPicture(pic, XWPFDocument.PICTURE_TYPE_JPEG, "3", Units.toEMU(370), Units.toEMU(70));
		} catch (InvalidFormatException | IOException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		FileOutputStream out = new FileOutputStream(new File("presupuesto " + FechaActual() + ".docx"));
		temprun.setText(
				"                                                                                                                                   "
						+ "" + "                                           Buenos Aires, " + FechaActual());
		temprun.setFontFamily("Times New Roman");
		temprun.setBold(true);
		temprun.addBreak(BreakType.TEXT_WRAPPING);
		temprun.setFontSize(12);
		temprun.setColor("6A5ACD");
		temprun2.setText("                                       PRESUPUESTO DE TRANSPORTE");
		temprun2.setFontSize(14);
		temprun2.setCharacterSpacing(WIDTH);

		temprun2.setEmbossed(true);
		temprun2.setImprinted(true);
		tempEstimad.setText("Estimado(a), por medio del presente detallo el presupuesto de transporte:");
		tempOriyD.setText("ORIGEN: " + textField_origen.getText() + "" + "     " + "                             "
				+ "DESTINO: " + textField_destino.getText());
		tempOriyD.setColor("FF0000");
		// DIMENSION
		tempDIME.setText("Carga: " + textFieldcarga.getText() + " con dimensión: " + textFieldDimens.getText());
		tempservT.setText("Servicio de Transporte: ");
		tempservT.setTextHighlightColor("green");
		tempunidad.setText("Unidad: " + DimeUnidad(SEMI_KMTROS));
		tempvalor.setText("VALOR DEL SERVICIO: " + ValorServicio() + " $");
		tempcondiciones.setText("                                                           CONDICIONES: ");
		tempcondiciones.setBold(true);
		tempcond1.setText("1- El presente presupuesto tiene una validez de 25 días.");
		tempcond2.setText(
				"2- Está basado según dimensiones, lugar de carga y descarga, en caso de ser modificado se deberá realizar otro presupuesto.");
		tempcond3.setText(
				"3- En caso de cancelación de servicio 24hs antes de la fecha confirmada se deberá abonar el 50% del valor de estadía. En caso de "
						+ "no realizarse la carga estando el equipo a disposición para cargar, se deberá abonar el valor de una estadía en concepto de movilización de la unidad.");
		tempcond4.setText("4- Condición de pago: \r\n"
				+ "Servicios locales/larga distancia semirremolques: contra entrega de factura hasta 30 días.\r\n"
				+ "Servicios de carretón larga distancia: 25% de adelanto, saldo restante contra entrega de factura hasta 35 días.\r\n"
				+ "");
		tempcond5.setText("5- La solicitud y confirmación del servicio debe ser con un mínimo de:\r\n"
				+ "Servicios de semirremolques/hidrogrúa/grúa: 48hs hábiles.\r\n"
				+ "Servicios locales sobredimensionado hasta 45 ton: 72hs hábiles.\r\n"
				+ "Servicios mayores a 450 km sobredimensionado hasta 45 ton: 4 días hábiles.\r\n"
				+ "Servicios mayores a 450 km sobredimensionado mayores a 45 ton: 8 días hábiles.\r\n" + "");
		tempcond6.setText(
				"6- El precio incluye: servicio de transporte y permisos de vialidad (en caso de corresponder). No incluye: carga, descarga, ni seguro de transporte.");
		tempcond7.setText(
				"7- La solicitud de los requisitos de documentación debe ser con un mínimo de 3 días hábiles, en caso de no ser así y se generen demoras para el ingreso "
						+ "a planta por falta de ésta, se deberán contemplar un valor de estadía diaria por cada día demorado.");
		tempcond8.setText("8- Franquicias:\r\n "
				+ "Servicios de semirremolques locales (hasta 200km): en el término del día.\r\n"
				+ "Servicios locales sobredimensionado hasta 45 ton (hasta 200Km): en el término del día.\r\n"
				+ "Servicios mayores a 200 km: 6hs para la carga y 6hs para la descarga.\r\n"
				+ "Servicios mayores a 500 km: 8 hs para la carga y 8 para la descarga.\r\n"
				+ "Servicio de hidrogrúa: 4hs mínimo.\r\n" + "Servicio de grúa: 8 hs mínimo.\r\n" + "\r\n"
				+ "-	En caso de superar dicho plazo se deberá adicionar un valor de estadía cada 24hs.\r\n" + "");
		tempcond9.setText("9- Todos los valores son más IVA.");
		tempcond9.setBold(true);
		tempcond10.setText(
				"10- Para aquellas cargas mayores o iguales a un alto/ancho de 4,00m. Los valores mencionados quedan sujetos a costo resultante por remoción de obstáculos."
						+ " En caso de ser adjudicados con la contratación se realizará un relevamiento de ruta en donde se indicará si será necesario y en caso de "
						+ "serlo el costo del mismo.");
		documento.write(out);
		out.close();
		pic.close();

	}

	public String DimeUnidad(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton boton = buttons.nextElement();
			if (boton.isSelected()) {
				return boton.getText();
			}
		}

		String unidad = "";

		return unidad;
	}
	public double valordepermiso() {
		
		return 0;
	}

	public double ValorServicio() {
		double result = 0;
		double permiso=0;
		double mas500=0;
		if(!tf_kmrec.getText().equals("")&&!tfValorXkm.getText().equals("")) {
			mas500=Double.parseDouble(tf_kmrec.getText())*Double.parseDouble(tfValorXkm.getText());
		}
		if(permiso0) {
			permiso+=arraypermisos[0];
		}
		if(permiso1) {
			permiso+=arraypermisos[1];
		}
		if(permiso2) {
			permiso+=arraypermisos[2];
		}
		if(permiso3) {
			permiso+=arraypermisos[3];
		}
		if(permiso4) {
			permiso+=arraypermisos[4];
		}

		int A = Integer.parseInt(textFDIAS_OPER.getText());
		int B = Integer.parseInt(textFDiasR.getText());
		int C = Integer.parseInt(textField_diasC.getText());
		int diasBS = 0, dcaba = 0, dne = 0, dc = 0, dsfe = 0, acompaparticular = 0, operar = 0;

		if (acompañamientopolicial) {
			if (!textField_dBSAS.getText().equals("")) {
				diasBS = Integer.parseInt(textField_dBSAS.getText());

			}
			if (!textField_dCABA.getText().equals("")) {
				dcaba = Integer.parseInt(textField_dCABA.getText());
			}
			if (!textField_dNE.getText().equals("")) {
				dne = Integer.parseInt(textField_dNE.getText());
			}
			if (!textField_diasC.getText().equals("")) {
				dc = Integer.parseInt(textField_diasC.getText());
			}
			if (!textField_dSFE.getText().equals("")) {
				dsfe = Integer.parseInt(textField_dSFE.getText());
			}
		}
		if (acompañamientoparticular) {
			acompaparticular = (A + 1) * (int) Math.round(arrayacompa[5]);
		}
		if (operario) {
			operar = (A + 1) * (int) Math.round(arrayacompa[6]);
		}
//accesible 10%menos y >60 5% +
		int b = (((A + B + C) * dimevalorXcarreton()) + (diasBS * (int) Math.round(arrayacompa[0])
				+ dcaba * (int) Math.round(arrayacompa[1]) + dne * (int) Math.round(arrayacompa[2])
				+ dc * (int) Math.round(arrayacompa[3]) + dsfe * (int) Math.round(arrayacompa[4])) + acompaparticular
				+ operar);
		if (pagoaccesible) {
			return result = b - ((((A + B) * dimevalorXcarreton()) + (diasBS * (int) Math.round(arrayacompa[0])
					+ dcaba * (int) Math.round(arrayacompa[1]) + dne * (int) Math.round(arrayacompa[2])
					+ dc * (int) Math.round(arrayacompa[3]) + dsfe * (int) Math.round(arrayacompa[4]))
					+ acompaparticular + operar) * 0.1)+permiso+mas500;
		}
		if (pagomas60) {
			return result = ((((A + B + C) * dimevalorXcarreton()) + (diasBS * (int) Math.round(arrayacompa[0])
					+ dcaba * (int) Math.round(arrayacompa[1]) + dne * (int) Math.round(arrayacompa[2])
					+ dc * (int) Math.round(arrayacompa[3]) + dsfe * (int) Math.round(arrayacompa[4]))
					+ acompaparticular + operar) * 0.05) + b+permiso+mas500;
		} else {
			return (((A + B + C) * dimevalorXcarreton()) + (diasBS * (int) Math.round(arrayacompa[0])
					+ dcaba * (int) Math.round(arrayacompa[1]) + dne * (int) Math.round(arrayacompa[2])
					+ dc * (int) Math.round(arrayacompa[3]) + dsfe * (int) Math.round(arrayacompa[4]))
					+ acompaparticular + operar)+permiso+mas500;
		}
	}

	public int dimevalorXcarreton() {
		JRadioButton radio = getSelection(SEMI_KMTROS);
		if(!textField.getText().equals("")) {
						return Integer.parseInt(textField.getText())*(int)Math.round(arraymodloh[Integer.parseInt(radio.getName())]);
		}
				try {
			JRadioButton ext = getSelection(EXT_MET);
			JRadioButton ext2 = getSelection(EXT_AXH);
			if (ext2.isSelected()) {
				return (int) Math.round(
						arrayextensible[Integer.parseInt(radio.getName())][Integer.parseInt(ext.getName())][Integer
								.parseInt(ext2.getName())]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			JRadioButton carm = getSelection(CARM_AXH);
			if (carm.isSelected()) {
				return (int) Math
						.round(arraycmecanico[Integer.parseInt(radio.getName())][Integer.parseInt(carm.getName())]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (int) Math.round(arraysemis[Integer.parseInt(radio.getName()) - 1]);
	}

	public String FechaActual() {
		Date fech = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");
		return format.format(fech);
	}
}
//3 numeros sumados * precio*ctdad de lineas
