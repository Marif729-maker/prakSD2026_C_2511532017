package Pekan8_2511532017;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BubbleSortGUI_2511532017 extends JFrame {

    private JTextField inputField_2017;
    private JButton setButton_2017;
    private JButton stepButton_2017;
    private JButton resetButton_2017;
    private JTextArea stepArea_2017;
    private JPanel panelArray_2017;

    private int[] array_2017;
    private JLabel[] labelArray_2017;

    private int i_2017 = 0;
    private int j_2017 = 0;
    private int stepCount_2017 = 1;
    private boolean sorting_2017 = false;

    public BubbleSortGUI_2511532017() {
        setTitle("Visualisasi Bubble Sort");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel input bagian atas
        JPanel inputPanel_2017 = new JPanel(new FlowLayout());

        JLabel inputLabel_2017 = new JLabel("Masukkan angka (pisahkan dengan koma):");
        inputField_2017 = new JTextField(30);

        setButton_2017 = new JButton("Set Array");
        stepButton_2017 = new JButton("Step");
        resetButton_2017 = new JButton("Reset");

        stepButton_2017.setEnabled(false);

        inputPanel_2017.add(inputLabel_2017);
        inputPanel_2017.add(inputField_2017);
        inputPanel_2017.add(setButton_2017);
        inputPanel_2017.add(stepButton_2017);
        inputPanel_2017.add(resetButton_2017);

        add(inputPanel_2017, BorderLayout.NORTH);

        // Panel untuk menampilkan array
        panelArray_2017 = new JPanel(new FlowLayout());
        panelArray_2017.setPreferredSize(new Dimension(750, 120));
        add(panelArray_2017, BorderLayout.CENTER);

        // Text area untuk menampilkan langkah sorting
        stepArea_2017 = new JTextArea();
        stepArea_2017.setEditable(false);
        stepArea_2017.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(stepArea_2017);
        scrollPane.setPreferredSize(new Dimension(750, 250));

        add(scrollPane, BorderLayout.SOUTH);

        // Event tombol
        setButton_2017.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setArrayFromInput_2017();
            }
        });

        stepButton_2017.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performStep_2017();
            }
        });

        resetButton_2017.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset_2017();
            }
        });
    }

    private void setArrayFromInput_2017() {
        String text_2017 = inputField_2017.getText().trim();

        if (text_2017.isEmpty()) {
            return;
        }

        String[] parts_2017 = text_2017.split(",");
        array_2017 = new int[parts_2017.length];

        try {
            for (int k = 0; k < parts_2017.length; k++) {
                array_2017[k] = Integer.parseInt(parts_2017[k].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Masukkan hanya angka yang dipisahkan koma!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        i_2017 = 0;
        j_2017 = 0;
        stepCount_2017 = 1;
        sorting_2017 = true;

        stepButton_2017.setEnabled(true);
        stepArea_2017.setText("");
        panelArray_2017.removeAll();

        labelArray_2017 = new JLabel[array_2017.length];

        for (int k = 0; k < array_2017.length; k++) {
            labelArray_2017[k] = new JLabel(String.valueOf(array_2017[k]));
            labelArray_2017[k].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2017[k].setOpaque(true);
            labelArray_2017[k].setBackground(Color.WHITE);
            labelArray_2017[k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2017[k].setPreferredSize(new Dimension(50, 50));
            labelArray_2017[k].setHorizontalAlignment(SwingConstants.CENTER);

            panelArray_2017.add(labelArray_2017[k]);
        }

        panelArray_2017.revalidate();
        panelArray_2017.repaint();
    }

    private void performStep_2017() {
        if (!sorting_2017 || i_2017 >= array_2017.length - 1) {
            sorting_2017 = false;
            stepButton_2017.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Sorting selesai!");
            return;
        }

        resetHighlights_2017();

        StringBuilder stepLog_2017 = new StringBuilder();

        labelArray_2017[j_2017].setBackground(Color.CYAN);
        labelArray_2017[j_2017 + 1].setBackground(Color.CYAN);

        if (array_2017[j_2017] > array_2017[j_2017 + 1]) {
            // Swap
            int temp = array_2017[j_2017];
            array_2017[j_2017] = array_2017[j_2017 + 1];
            array_2017[j_2017 + 1] = temp;

            labelArray_2017[j_2017].setBackground(Color.RED);
            labelArray_2017[j_2017 + 1].setBackground(Color.RED);

            stepLog_2017.append("Langkah ").append(stepCount_2017).append(": ")
                    .append("Menukar elemen ke-").append(j_2017)
                    .append(" (").append(array_2017[j_2017 + 1]).append(")")
                    .append(" dengan ke-").append(j_2017 + 1)
                    .append(" (").append(array_2017[j_2017]).append(")\n");

        } else {
            stepLog_2017.append("Langkah ").append(stepCount_2017).append(": ")
                    .append("Tidak ada pertukaran antara ke-")
                    .append(j_2017).append(" dan ke-")
                    .append(j_2017 + 1).append("\n");
        }

        stepLog_2017.append("Hasil: ").append(arrayToString_2017(array_2017)).append("\n\n");
        stepArea_2017.append(stepLog_2017.toString());

        updateLabels_2017();

        j_2017++;

        if (j_2017 >= array_2017.length - 1 - i_2017) {
            j_2017 = 0;
            i_2017++;
        }

        stepCount_2017++;

        if (i_2017 >= array_2017.length - 1) {
            sorting_2017 = false;
            stepButton_2017.setEnabled(false);
            resetHighlights_2017();

            for (JLabel label : labelArray_2017) {
                label.setBackground(Color.GREEN);
            }

            JOptionPane.showMessageDialog(this, "Sorting selesai!");
        }
    }

    private void updateLabels_2017() {
        for (int k_2017 = 0; k_2017 < array_2017.length; k_2017++) {
            labelArray_2017[k_2017].setText(String.valueOf(array_2017[k_2017]));
        }
    }

    private void resetHighlights_2017() {
        for (JLabel label : labelArray_2017) {
            label.setBackground(Color.WHITE);
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
        i_2017 = 0;
        j_2017 = 0;
        stepCount_2017 = 1;
    }

    private String arrayToString_2017(int[] arr_2017) {
        StringBuilder sb_2017 = new StringBuilder();

        for (int k_2017 = 0; k_2017 < arr_2017.length; k_2017++) {
            sb_2017.append(arr_2017[k_2017]);

            if (k_2017 < arr_2017.length - 1) {
                sb_2017.append(", ");
            }
        }

        return sb_2017.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BubbleSortGUI_2511532017().setVisible(true);
            }
        });
    }
}