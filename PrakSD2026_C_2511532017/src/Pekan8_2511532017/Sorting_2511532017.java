package Pekan8_2511532017;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sorting_2511532017 extends JFrame {

    private JTextField judulField_2017;
    private JTextField penyanyiField_2017;
    private JTextField durasiField_2017;
    private JButton addButton_2017;
    private JButton stepButton_2017;
    private JButton resetButton_2017;
    private JTextArea stepArea_2017;
    private JPanel panelArray_2017;

    private Lagu_2511532017[] array_2017;
    private JLabel[] labelArray_2017;

    private int gap_2017 = 0;
    private int i_2017 = 0;
    private int j_2017 = 0;
    private Lagu_2511532017 temp_2017 = null;
    private int stepCount_2017 = 1;
    private boolean sorting_2017 = false;

    private java.util.List<Lagu_2511532017> daftarLagu_2017 = new java.util.ArrayList<>();
    private static final int MAKS_LAGU = 20;

    public Sorting_2511532017() {
        setTitle("Visualisasi Shell Sort - Lagu");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel input bagian atas
        JPanel inputPanel_2017 = new JPanel(new FlowLayout());

        inputPanel_2017.add(new JLabel("Judul:"));
        judulField_2017 = new JTextField(10);
        inputPanel_2017.add(judulField_2017);

        inputPanel_2017.add(new JLabel("Penyanyi:"));
        penyanyiField_2017 = new JTextField(10);
        inputPanel_2017.add(penyanyiField_2017);

        inputPanel_2017.add(new JLabel("Durasi (dtk):"));
        durasiField_2017 = new JTextField(5);
        inputPanel_2017.add(durasiField_2017);

        addButton_2017 = new JButton("Tambah");
        stepButton_2017 = new JButton("Step");
        resetButton_2017 = new JButton("Reset");

        stepButton_2017.setEnabled(false);

        inputPanel_2017.add(addButton_2017);
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
        addButton_2017.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahLagu_2017();
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

    private void tambahLagu_2017() {
        if (daftarLagu_2017.size() >= MAKS_LAGU) {
            JOptionPane.showMessageDialog(this,
                "Maksimal " + MAKS_LAGU + " lagu!",
                "Batas Tercapai", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String judul = judulField_2017.getText().trim();
        String penyanyi = penyanyiField_2017.getText().trim();
        String durasiStr = durasiField_2017.getText().trim();

        if (judul.isEmpty() || penyanyi.isEmpty() || durasiStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Isi semua field!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int durasi;
        try {
            durasi = Integer.parseInt(durasiStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Durasi harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        daftarLagu_2017.add(new Lagu_2511532017(judul, penyanyi, durasi));

        judulField_2017.setText("");
        penyanyiField_2017.setText("");
        durasiField_2017.setText("");

        // Inisialisasi ulang array dan state sorting
        array_2017 = daftarLagu_2017.toArray(new Lagu_2511532017[0]);

        gap_2017 = array_2017.length / 2;
        i_2017 = gap_2017;
        j_2017 = gap_2017;
        temp_2017 = array_2017.length >= 2 ? array_2017[i_2017] : null;
        stepCount_2017 = 1;
        sorting_2017 = array_2017.length >= 2;

        stepButton_2017.setEnabled(sorting_2017);

        // Tampilkan data sebelum diurutkan di log
        stepArea_2017.setText("");
        stepArea_2017.append("Data sebelum diurutkan:\n");
        stepArea_2017.append(arrayToString_2017() + "\n");
        stepArea_2017.append("Gap awal: " + gap_2017 + "\n\n");

        tampilanArray_2017();
    }

    private void performStep_2017() {
        if (!sorting_2017 || gap_2017 < 1) {
            finishSort_2017();
            return;
        }

        resetHighlights_2017();

        // pergeseran insertion dalam gap
        if (j_2017 >= gap_2017 && array_2017[j_2017 - gap_2017].Judul_2017().compareToIgnoreCase(temp_2017.Judul_2017()) > 0) {
            // Geser elemen ke kanan
            array_2017[j_2017] = array_2017[j_2017 - gap_2017];

            labelArray_2017[j_2017].setBackground(Color.RED);
            labelArray_2017[j_2017 - gap_2017].setBackground(Color.CYAN);

            stepArea_2017.append("Langkah " + stepCount_2017 + ": Geser \"" +
                    array_2017[j_2017].Judul_2017() + "\" ke posisi " + j_2017 +
                    " (gap=" + gap_2017 + ")\n");
            stepArea_2017.append("Hasil: " + arrayToString_2017() + "\n\n");

            stepCount_2017++;
            j_2017 -= gap_2017;

        } else {
            // Sisipkan temp ke posisi j
            array_2017[j_2017] = temp_2017;
            labelArray_2017[j_2017].setBackground(Color.CYAN);

            stepArea_2017.append("Langkah " + stepCount_2017 + ": Sisipkan \"" +
                    temp_2017.Judul_2017() + "\" ke posisi " + j_2017 + "\n");
            stepArea_2017.append("Hasil: " + arrayToString_2017() + "\n\n");

            stepCount_2017++;
            i_2017++;

            if (i_2017 >= array_2017.length) {
                gap_2017 /= 2;
                if (gap_2017 < 1) {
                    // Sorting selesai
                    updateLabels_2017();
                    finishSort_2017();
                    return;
                }
                i_2017 = gap_2017;
                stepArea_2017.append("--- Gap baru: " + gap_2017 + " ---\n\n");
            }

            j_2017 = i_2017;
            temp_2017 = array_2017[i_2017];
        }

        updateLabels_2017();
    }

    private void finishSort_2017() {
        sorting_2017 = false;
        stepButton_2017.setEnabled(false);
        resetHighlights_2017();
        for (JLabel lbl : labelArray_2017) lbl.setBackground(Color.GREEN);
        stepArea_2017.append("Sorting selesai!\n");
        stepArea_2017.append("Hasil akhir: " + arrayToString_2017() + "\n");
        JOptionPane.showMessageDialog(this, "Sorting selesai!");
    }

    private void tampilanArray_2017() {
        panelArray_2017.removeAll();
        labelArray_2017 = new JLabel[array_2017.length];

        for (int k = 0; k < array_2017.length; k++) {
            Lagu_2511532017 lagu = array_2017[k];
            JLabel lbl = new JLabel(
                "<html><center><b>" + lagu.Judul_2017() + "</b><br/>" +
                lagu.Penyanyi_2017() + "<br/>" + lagu.Durasi_2017() + " dtk</center></html>",
                SwingConstants.CENTER
            );
            lbl.setFont(new Font("Arial", Font.PLAIN, 12));
            lbl.setOpaque(true);
            lbl.setBackground(Color.WHITE);
            lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            lbl.setPreferredSize(new Dimension(100, 70));
            panelArray_2017.add(lbl);
            labelArray_2017[k] = lbl;
        }

        panelArray_2017.revalidate();
        panelArray_2017.repaint();
    }

    private void updateLabels_2017() {
        for (int k = 0; k < array_2017.length; k++) {
            Lagu_2511532017 lagu = array_2017[k];
            labelArray_2017[k].setText(
                "<html><center><b>" + lagu.Judul_2017() + "</b><br/>" +
                lagu.Penyanyi_2017() + "<br/>" + lagu.Durasi_2017() + " dtk</center></html>"
            );
        }
    }

    private void resetHighlights_2017() {
        for (JLabel lbl : labelArray_2017) {
            lbl.setBackground(Color.WHITE);
        }
    }

    private String arrayToString_2017() {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < array_2017.length; k++) {
            sb.append(array_2017[k].Judul_2017());
            if (k < array_2017.length - 1) sb.append(", ");
        }
        return sb.toString();
    }

    private void reset_2017() {
        daftarLagu_2017.clear();
        array_2017 = null;
        labelArray_2017 = null;
        gap_2017 = 0;
        i_2017 = 0;
        j_2017 = 0;
        temp_2017 = null;
        stepCount_2017 = 1;
        sorting_2017 = false;

        judulField_2017.setText("");
        penyanyiField_2017.setText("");
        durasiField_2017.setText("");
        stepButton_2017.setEnabled(false);
        stepArea_2017.setText("");
        panelArray_2017.removeAll();
        panelArray_2017.revalidate();
        panelArray_2017.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sorting_2511532017().setVisible(true);
            }
        });
    }
}