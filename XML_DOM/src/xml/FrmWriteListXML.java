package xml;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class FrmWriteListXML extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmWriteListXML frame = new FrmWriteListXML();
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
	public FrmWriteListXML() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt1 = new JTextField();
		txt1.setBounds(113, 32, 164, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(113, 73, 164, 20);
		contentPane.add(txt2);
		
		JButton btn = new JButton("ghi");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				try {
					DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
					File file = new File("src/xml/dskhoa2.xml");
					// muc dich ghi them vao file , tat nhien ban dau se chua co file
					Document  doc;
					if(file.isFile()) {
						doc=db.parse(file);// toi lam viec tren file nay da co data
					}else doc= db.newDocument();// neeus khong co file thi toi tao moi thoi
					// check thanh phan trong file xml da ton tai chua
					Element e = doc.getDocumentElement();
					if(e==null) {
						e = doc.createElement("dskhoa");// neu e ko null tuc da co dskhoa trong file nen khong tao nua chi tien hanh ghi them cac element childs moi vao thoi	
						doc.appendChild(e);
					}
                 Element e1 = doc.createElement("makh");
                 e.appendChild(e1);
                 Text t1 = doc.createTextNode(txt1.getText().toString());
                 e1.appendChild(t1);
                 Element e2 = doc.createElement("tenkh");
                 e.appendChild(e2);
                 Text t2 = doc.createTextNode(txt2.getText().toString());
                 e2.appendChild(t2);
                 
                 TransformerFactory tff =TransformerFactory.newInstance();
                 Transformer tf = tff.newTransformer();
                 DOMSource s = new DOMSource(doc);
                 Result rs = new StreamResult(file);
                 tf.transform(s, rs);
					
				} catch (ParserConfigurationException | SAXException | IOException| TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btn.setBounds(140, 139, 89, 23);
		contentPane.add(btn);
	}
}
