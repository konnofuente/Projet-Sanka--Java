package demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class JFrameMain extends JFrame {

	private JPanel buttonQRCode;
	private JTextField textFieldProductId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
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
	public JFrameMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		buttonQRCode = new JPanel();
		buttonQRCode.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(buttonQRCode);
		buttonQRCode.setLayout(null);
		
		textFieldProductId = new JTextField();
		textFieldProductId.setBounds(10, 11, 237, 20);
		buttonQRCode.add(textFieldProductId);
		textFieldProductId.setColumns(10);
		
		JButton btnNewButton = new JButton("QR code");
		btnNewButton.setBounds(20, 42, 89, 23);
		buttonQRCode.add(btnNewButton);
		
		JButton buttonBarCode = new JButton("Bar code");
		buttonBarCode.setBounds(119, 42, 89, 23);
		buttonQRCode.add(buttonBarCode);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 76, 270, 163);
		buttonQRCode.add(lblNewLabel);
	}
}
