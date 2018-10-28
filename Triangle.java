package OlaMundoJavaFX;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Triangle extends JFrame 
{	private JPanel contentPane;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblResult;
	private JSlider slider1;
	private JSlider slider2;
	private JSlider slider3;
	/*Launch the application.*/
	public static void main(String[] args) 
	{	EventQueue.invokeLater(new Runnable() 
		{	public void run() 
			{	try 
				{	Triangle frame = new Triangle();
					frame.setVisible(true);
				} 
				catch (Exception e) {e.printStackTrace();}
			}
		});
	}
	/*Create the frame.*/
	public Triangle() 
	{
		setResizable(false);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		slider1 = new JSlider();
		slider1.setMajorTickSpacing(5);
		slider1.setForeground(Color.BLACK);
		slider1.setMaximum(30);
		slider1.setSnapToTicks(true);
		slider1.setPaintLabels(true);
		slider1.setValue(0);
		slider1.setPaintTicks(true);
		slider1.setMinorTickSpacing(2);
		sl_contentPane.putConstraint(SpringLayout.WEST, slider1, 10, SpringLayout.WEST, contentPane);
		slider1.setFont(new Font("Arial", Font.BOLD, 13));
		contentPane.add(slider1);
		slider1.addChangeListener(new ChangeListener() 
		{	public void stateChanged(ChangeEvent arg0) 
			{lblA.setText(String.valueOf(slider1.getValue()));}
		});
		
		
		slider2 = new JSlider();
		slider2.setMinorTickSpacing(2);
		slider2.setMaximum(30);
		slider2.setSnapToTicks(true);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		slider2.setMajorTickSpacing(5);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, slider1, -37, SpringLayout.NORTH, slider2);
		sl_contentPane.putConstraint(SpringLayout.WEST, slider2, 0, SpringLayout.WEST, slider1);
		slider2.setFont(new Font("Arial", Font.BOLD, 13));
		slider2.setValue(0);
		contentPane.add(slider2);
		slider2.addChangeListener(new ChangeListener() 
		{	public void stateChanged(ChangeEvent arg0) 
			{lblB.setText(String.valueOf(slider2.getValue()));}
		});
		
		slider3 = new JSlider();
		slider3.setMaximum(30);
		slider3.setMinorTickSpacing(2);
		slider3.setSnapToTicks(true);
		slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
		slider3.setMajorTickSpacing(5);
		sl_contentPane.putConstraint(SpringLayout.NORTH, slider3, 165, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, slider2, -33, SpringLayout.NORTH, slider3);
		sl_contentPane.putConstraint(SpringLayout.WEST, slider3, 0, SpringLayout.WEST, slider1);
		slider3.setFont(new Font("Arial", Font.BOLD, 13));
		slider3.setValue(0);
		contentPane.add(slider3);
		slider3.addChangeListener(new ChangeListener() 
		{	public void stateChanged(ChangeEvent arg0) 
			{lblC.setText(String.valueOf(slider3.getValue()));}
		});
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() 
		{	public void actionPerformed(ActionEvent arg0) 
			{	if((Integer.parseInt(lblA.getText())<Integer.parseInt(lblB.getText())+Integer.parseInt(lblC.getText()))&&(Integer.parseInt(lblB.getText())<Integer.parseInt(lblA.getText())+Integer.parseInt(lblC.getText()))&&(Integer.parseInt(lblC.getText())<Integer.parseInt(lblB.getText())+Integer.parseInt(lblA.getText())))
				{	if(lblA.getText().equals(lblB.getText())&&lblB.getText().equals(lblC.getText())) lblResult.setText("Triângulo Equilátero!");
					else if(lblA.getText().equals(lblB.getText())||lblA.getText().equals(lblC.getText())||lblB.getText().equals(lblC.getText())) lblResult.setText("Triângulo Isósceles!");
					else lblResult.setText("Triãngulo Escaleno!");
				}
				else lblResult.setText("Triângulo não existe!");
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, slider1);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(btnNewButton);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblResult, 143, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblResult, -44, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, lblResult);
		lblResult.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblResult);
		
		JLabel lblImage = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblImage, 30, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblImage, 0, SpringLayout.EAST, contentPane);
		lblImage.setIcon(new ImageIcon("C:\\Users\\eduardowmu\\Desktop\\meusdoc\\EMULADORES\\SOFTWARES\\ECLIPSE-JAVA\\TESTES\\JavaFX\\src\\OlaMundoJavaFX\\imagens\\triangleABC.png"));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImage);
		
		lblA = new JLabel("0");
		lblA.setFont(new Font("Arial", Font.BOLD, 15));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblA, 0, SpringLayout.NORTH, lblImage);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblA, 20, SpringLayout.EAST, slider1);
		contentPane.add(lblA);
		
		lblB = new JLabel("0");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblB, 0, SpringLayout.WEST, lblA);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblB, 0, SpringLayout.SOUTH, slider2);
		lblB.setHorizontalAlignment(SwingConstants.CENTER);
		lblB.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblB);
		
		lblC = new JLabel("0");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblC, 27, SpringLayout.NORTH, slider3);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblC, 0, SpringLayout.WEST, lblA);
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblC);
	}
}
