package pekan7_2511532017;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class InsertionGUI_2511532017 extends JFrame {
	private static final long serialVersionUID = 1L;
	private int[] array_2017;
	private JLabel[] labelArray_2017;
	private JButton stepButton_2017, resetButton_2017, setButton_2017;
	private JTextField inputField_2017;
	private JPanel panelArray_2017;
	private JTextArea stepArea_2017;
	private JPanel contentPane_2017;
	
	private int i_2017 = 1, j_2017;
	private boolean sorting_2017 = false;
	private int stepCount_2017 = 1;


	/**
	 * Create the frame.
	 */
	public InsertionGUI_2511532017() {
		setTitle ("Insertion Sort Langkah Per Langkah");
		setSize(750, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout (new BorderLayout());
		
		//panel input
		JPanel inputPanel_2017 = new JPanel (new FlowLayout());
		inputField_2017 = new JTextField(30);
		setButton_2017 = new JButton ("Set Array");
		inputPanel_2017.add(new JLabel("Masukkan angka (pisahkan dengan koma:"));
		inputPanel_2017.add(inputField_2017);
		inputPanel_2017.add(setButton_2017);
		
		//Panel Array visual
		panelArray_2017 = new JPanel();
		panelArray_2017.setLayout(new FlowLayout());
		
		
		//panel kontrol
		JPanel controlPanel_2017 = new JPanel();
		stepButton_2017 = new JButton ("langkah selanjutnya");
		resetButton_2017 = new JButton ("reset");		
		stepButton_2017.setEnabled(false);
		controlPanel_2017.add(stepButton_2017);
		controlPanel_2017.add(resetButton_2017);
		
		//area teks untuk log langkah-langkah
		stepArea_2017 = new JTextArea (8, 60);
		stepArea_2017.setEditable(false);
		stepArea_2017.setFont(new Font("Monospaced", Font.PLAIN,14));
		JScrollPane scrollPane_2017 = new JScrollPane (stepArea_2017);
		
		//tambahkan panel ke frame
		getContentPane().add(inputPanel_2017, BorderLayout.NORTH);
		getContentPane().add(panelArray_2017, BorderLayout.WEST);
		getContentPane().add(controlPanel_2017, BorderLayout.SOUTH);
		getContentPane().add(scrollPane_2017, BorderLayout.EAST);
		
		//event set array
		setButton_2017.addActionListener(e -> setArrayFromInput_2017());
		
		//event langkah selanjutnya
		stepButton_2017.addActionListener(e -> performStep_2017());
		
		//event reset
		resetButton_2017.addActionListener(e -> reset_2017());
		
	}
	
	private void setArrayFromInput_2017() {
		String text = inputField_2017.getText().trim();
		if (text.isEmpty()) return;
		String[] parts = text.split(",");
		array_2017 = new int [parts.length];
		try {
			for ( int k = 0; k < parts.length; k++ ) {
				array_2017 [k] = Integer.parseInt(parts[k].trim());
				}
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog (this, "Masukkan hanya angka yang dipisahkan "+ "dengan koma! ", "Error", JOptionPane.ERROR_MESSAGE);
					return; 
				}
		i_2017 = 1;
		stepCount_2017 = 1;
		sorting_2017 = true;
		stepButton_2017.setEnabled(true);
		stepArea_2017.setText("");
		panelArray_2017.removeAll();
		labelArray_2017 = new JLabel [array_2017.length];
		for (int k_2017 = 0; k_2017 < array_2017.length; k_2017++) {
			labelArray_2017[k_2017] = new JLabel (String.valueOf(array_2017[k_2017]));
			labelArray_2017[k_2017].setFont(new Font ("Arial", Font.BOLD,24));
			labelArray_2017[k_2017].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labelArray_2017[k_2017].setPreferredSize(new Dimension (50,50));
			labelArray_2017[k_2017].setHorizontalAlignment(SwingConstants.CENTER);
			panelArray_2017.add(labelArray_2017[k_2017]);
		
		}
		panelArray_2017.revalidate();
		panelArray_2017.repaint();
	}
	
	private void performStep_2017() {
		if (i_2017 < array_2017.length && sorting_2017) {
			int key_2017 = array_2017[i_2017];
			j_2017 = i_2017 - 1;
			
			StringBuilder stepLog_2017 = new StringBuilder();
			stepLog_2017.append("langkah ").append(stepCount_2017).append(" : Memasukkan ").append(key_2017).append("\n");
			
			while (j_2017 >= 0 && array_2017[j_2017] > key_2017) {
				array_2017[j_2017 + 1] = array_2017 [j_2017];
				j_2017--;
			}
			array_2017 [j_2017 + 1] = key_2017;
			
			updateLabels_2017();
			stepLog_2017.append("Hasil: ").append(arrayToString_2017(array_2017)).append("\n\n");
			stepArea_2017.append(stepLog_2017.toString());
			
			i_2017++;
			stepCount_2017++;
			
			if (i_2017 == array_2017.length) {
				sorting_2017 = false;
				stepButton_2017.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Sorting selesai");
			}
		}
	}
	public void updateLabels_2017() {
		for (int k_2017 = 0; k_2017 < array_2017.length; k_2017++) {
			labelArray_2017[k_2017].setText(String.valueOf(array_2017[k_2017]));
		}
	}
	
	private void reset_2017() {
		inputField_2017.setText("");
		panelArray_2017.removeAll();
		panelArray_2017.revalidate();
		panelArray_2017.repaint();
		stepArea_2017.setText("");
		stepButton_2017.setEnabled(false);
		sorting_2017 = false;
		i_2017 = 1;
		stepCount_2017 = 1;
	}
	
	private String arrayToString_2017 (int[] arr_2017) {
		StringBuilder sb_2017 = new StringBuilder();
		for (int k_2017 = 0; k_2017 < arr_2017.length; k_2017++) {
			sb_2017.append(arr_2017[k_2017]);
			if (k_2017 < arr_2017.length - 1) sb_2017.append(", ");
		}
		return sb_2017.toString();
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> {
			InsertionGUI_2511532017 gui_2017 = new InsertionGUI_2511532017();
			gui_2017.setVisible (true);
		});
	}
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InsertionGUI_2511532017 frame = new InsertionGUI_2511532017();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

}
