package org.gradle;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.gradle.dto.Person;
import org.gradle.service.PersonService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import javax.swing.JEditorPane;

public class Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JButton btn=new JButton("버튼");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				ShowReport();
				revalidate();
				
				setSize(700, 700);
				
				revalidate();
				repaint();
				
			}
		});
		contentPane.add(btn, BorderLayout.NORTH);
		setVisible(true);
	}
	private void ShowReport(){
		try {
			List<Person> list=PersonService.getInstance().selectAll();
			List<Map<String, ?>>dataSource=new ArrayList<>();
			for (Person person : list) {
				Map<String, Object> m=new HashMap<>();
				m.put("no",	person.getNo());
				m.put("name",person.getName());
				dataSource.add(m);
			}
			JRDataSource jrDataSource=new JRBeanCollectionDataSource(dataSource);
			String sourceName="E://workspace//workspace-java//jasperreportTest//personReport.jrxml";
			
			JasperReport report=JasperCompileManager.compileReport(sourceName);
			JasperPrint filledReport=JasperFillManager.fillReport(report, null,jrDataSource);
			this.getContentPane().add(new JRViewer(filledReport));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

}
