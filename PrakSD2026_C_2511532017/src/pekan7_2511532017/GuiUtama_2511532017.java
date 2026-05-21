package pekan7_2511532017;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GuiUtama_2511532017 extends JFrame {
    private static final long serialVersionUID = 1L;

    private ArrayList<MahasiswaSort_2511532017> listMahasiswa_2017 = new ArrayList<>();
    private ArrayList<MahasiswaSort_2511532017> dataSorting_2017 = new ArrayList<>();

    private JTextField fieldNama_2017, fieldNim_2017, fieldProdi_2017;
    private JComboBox<String> comboAlgo_2017;
    private JPanel panelArray_2017;
    private JLabel[] labelArray_2017;
    private JTextArea stepArea_2017;
    private JButton stepButton_2017, resetButton_2017, mulaiButton_2017;

    private int stepI_2017 = 1;
    private int stepCount_2017 = 1;
    private boolean sorting_2017 = false;
    private String algoMode_2017 = "";
    private int selMinIdx_2017 = 0;

    public GuiUtama_2511532017() {
        setTitle("Sorting Mahasiswa");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        // Panel input NORTH
        JPanel inputPanel_2017 = new JPanel(new FlowLayout());
        inputPanel_2017.add(new JLabel("Nama:"));
        fieldNama_2017 = new JTextField(10);
        inputPanel_2017.add(fieldNama_2017);
        inputPanel_2017.add(new JLabel("NIM:"));
        fieldNim_2017 = new JTextField(10);
        inputPanel_2017.add(fieldNim_2017);
        inputPanel_2017.add(new JLabel("Prodi:"));
        fieldProdi_2017 = new JTextField(8);
        inputPanel_2017.add(fieldProdi_2017);
        JButton btnTambah_2017 = new JButton("Tambah");
        inputPanel_2017.add(btnTambah_2017);

        //Visualisasi sorting
        panelArray_2017 = new JPanel(new GridLayout(0, 3, 5, 5));
        panelArray_2017.setBorder(BorderFactory.createTitledBorder("Visualisasi Sorting"));
        JScrollPane scrollArray_2017 = new JScrollPane(panelArray_2017);
        scrollArray_2017.setPreferredSize(new Dimension(300, 300));

        //Panel kontrol 
        JPanel controlPanel_2017 = new JPanel(new FlowLayout());
        comboAlgo_2017 = new JComboBox<>(new String[]{"Insertion Sort", "Selection Sort", "Bubble Sort"});
        mulaiButton_2017 = new JButton("Mulai Sorting");
        stepButton_2017 = new JButton("Langkah Selanjutnya");
        resetButton_2017 = new JButton("Reset");
        stepButton_2017.setEnabled(false);
        controlPanel_2017.add(comboAlgo_2017);
        controlPanel_2017.add(mulaiButton_2017);
        controlPanel_2017.add(stepButton_2017);
        controlPanel_2017.add(resetButton_2017);

        //Area langkah 
        stepArea_2017 = new JTextArea(8, 40);
        stepArea_2017.setEditable(false);
        stepArea_2017.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane_2017 = new JScrollPane(stepArea_2017);

        getContentPane().add(inputPanel_2017, BorderLayout.NORTH);
        getContentPane().add(scrollArray_2017, BorderLayout.WEST);
        getContentPane().add(controlPanel_2017, BorderLayout.SOUTH);
        getContentPane().add(scrollPane_2017, BorderLayout.CENTER);

        btnTambah_2017.addActionListener(e -> tambahMahasiswa_2017());
        mulaiButton_2017.addActionListener(e -> mulaiSorting_2017());
        stepButton_2017.addActionListener(e -> performStep_2017());
        resetButton_2017.addActionListener(e -> reset_2017());
    }

    private void tambahMahasiswa_2017() {
        String nama_2017  = fieldNama_2017.getText().trim();
        String nim_2017   = fieldNim_2017.getText().trim();
        String prodi_2017 = fieldProdi_2017.getText().trim();

        if (nama_2017.isEmpty() || nim_2017.isEmpty() || prodi_2017.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        listMahasiswa_2017.add(new MahasiswaSort_2511532017(nim_2017, nama_2017, prodi_2017));
        updateLabels_2017();

        fieldNama_2017.setText("");
        fieldNim_2017.setText("");
        fieldProdi_2017.setText("");
    }

    private void updateLabels_2017() {
        panelArray_2017.removeAll();
        ArrayList<MahasiswaSort_2511532017> src_2017 =
                dataSorting_2017.isEmpty() ? listMahasiswa_2017 : dataSorting_2017;
        labelArray_2017 = new JLabel[src_2017.size()];

        for (int k_2017 = 0; k_2017 < src_2017.size(); k_2017++) {
            labelArray_2017[k_2017] = new JLabel(src_2017.get(k_2017).Nama_2017());
            labelArray_2017[k_2017].setFont(new Font("Arial", Font.BOLD, 15));
            labelArray_2017[k_2017].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2017[k_2017].setPreferredSize(new Dimension(80, 40));
            labelArray_2017[k_2017].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2017.add(labelArray_2017[k_2017]);
        }
        panelArray_2017.revalidate();
        panelArray_2017.repaint();
    }

    private void mulaiSorting_2017() {
        if (listMahasiswa_2017.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data masih kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dataSorting_2017 = salinList_2017();
        algoMode_2017    = (String) comboAlgo_2017.getSelectedItem();

        // Insertion & Bubble mulai dari 1, Selection mulai dari 0
        if ("Selection Sort".equals(algoMode_2017)) {
            stepI_2017 = 0;
        } else {
            stepI_2017 = 1;
        }

        stepCount_2017 = 1;
        selMinIdx_2017 = 0;
        sorting_2017   = true;
        stepButton_2017.setEnabled(true);
        mulaiButton_2017.setEnabled(false);
        stepArea_2017.setText("=== " + algoMode_2017.toUpperCase() + " ===\n");
        stepArea_2017.append("Data awal:\n" + toStringList_2017(dataSorting_2017) + "\n\n");
        updateLabels_2017();
    }

    private void performStep_2017() {
        if (!sorting_2017) return;
        if ("Insertion Sort".equals(algoMode_2017))      stepInsertion_2017();
        else if ("Selection Sort".equals(algoMode_2017)) stepSelection_2017();
        else                                              stepBubble_2017();
    }

    private void stepInsertion_2017() {
        if (stepI_2017 >= dataSorting_2017.size()) { selesai_2017(); return; }

        MahasiswaSort_2511532017 key_2017 = dataSorting_2017.get(stepI_2017);
        int j_2017 = stepI_2017 - 1;
        while (j_2017 >= 0 &&
               dataSorting_2017.get(j_2017).Nama_2017().compareToIgnoreCase(key_2017.Nama_2017()) > 0) {
            dataSorting_2017.set(j_2017 + 1, dataSorting_2017.get(j_2017));
            j_2017--;
        }
        dataSorting_2017.set(j_2017 + 1, key_2017);

        stepArea_2017.append("Langkah " + stepCount_2017 + " : Memasukkan [" + key_2017.Nama_2017() + "]\n");
        stepArea_2017.append("Hasil:\n" + toStringList_2017(dataSorting_2017) + "\n\n");

        updateLabels_2017();
        stepI_2017++;
        stepCount_2017++;
        if (stepI_2017 >= dataSorting_2017.size()) selesai_2017();
    }

    private void stepSelection_2017() {
        int n_2017 = dataSorting_2017.size();

        if (stepI_2017 >= n_2017 - 1) {
            selesai_2017();
            return;
        }
        selMinIdx_2017 = stepI_2017;
        for (int j_2017 = stepI_2017 + 1; j_2017 < n_2017; j_2017++) {
            if (dataSorting_2017.get(j_2017).Nama_2017()
                    .compareToIgnoreCase(dataSorting_2017.get(selMinIdx_2017).Nama_2017()) < 0) {
                selMinIdx_2017 = j_2017;
            }
        }

        MahasiswaSort_2511532017 temp_2017 = dataSorting_2017.get(selMinIdx_2017);
        dataSorting_2017.set(selMinIdx_2017, dataSorting_2017.get(stepI_2017));
        dataSorting_2017.set(stepI_2017, temp_2017);

        stepArea_2017.append("Pass " + stepCount_2017 + " : Min = [" + temp_2017.Nama_2017() +
                             "] -> posisi " + stepI_2017 + "\n");
        stepArea_2017.append("Hasil:\n" + toStringList_2017(dataSorting_2017) + "\n\n");

        updateLabels_2017();
        stepI_2017++;
        stepCount_2017++;
        if (stepI_2017 >= n_2017 - 1) selesai_2017();
    }
    private void stepBubble_2017() {
        int n_2017 = dataSorting_2017.size();

        if (stepI_2017 >= n_2017) { 
            selesai_2017(); 
            return; 
        }

        boolean swapped_2017 = false;

        for (int j_2017 = 0; j_2017 < n_2017 - stepI_2017; j_2017++) {
            if (dataSorting_2017.get(j_2017).Nama_2017()
                    .compareToIgnoreCase(dataSorting_2017.get(j_2017 + 1).Nama_2017()) > 0) {
                MahasiswaSort_2511532017 temp_2017 = dataSorting_2017.get(j_2017);
                dataSorting_2017.set(j_2017, dataSorting_2017.get(j_2017 + 1));
                dataSorting_2017.set(j_2017 + 1, temp_2017);
                swapped_2017 = true;
            }
        }

        stepArea_2017.append("Pass " + stepCount_2017 + " :\n" + toStringList_2017(dataSorting_2017) + "\n\n");

        updateLabels_2017();
        stepI_2017++;
        stepCount_2017++;
        
        if (!swapped_2017 || stepI_2017 >= n_2017) {
            selesai_2017();
        }
    }

    private void selesai_2017() {
        sorting_2017 = false;
        stepButton_2017.setEnabled(false);
        stepArea_2017.append("=== Sorting selesai! ===\n");
        stepArea_2017.append("Hasil akhir:\n" + toStringList_2017(dataSorting_2017) + "\n");
        JOptionPane.showMessageDialog(this, "Sorting selesai!");
    }

    private String toStringList_2017(ArrayList<MahasiswaSort_2511532017> list_2017) {
        StringBuilder sb_2017 = new StringBuilder();
        for (int i_2017 = 0; i_2017 < list_2017.size(); i_2017++) {
            sb_2017.append("---- Mahasiswa ").append(i_2017 + 1).append(" ----");
            sb_2017.append(list_2017.get(i_2017).toString());
            if (i_2017 < list_2017.size() - 1) sb_2017.append("\n");
        }
        return sb_2017.toString();
    }

    private ArrayList<MahasiswaSort_2511532017> salinList_2017() {
        ArrayList<MahasiswaSort_2511532017> copy_2017 = new ArrayList<>();
        for (MahasiswaSort_2511532017 m : listMahasiswa_2017) {
            copy_2017.add(new MahasiswaSort_2511532017(m.Nim_2017(), m.Nama_2017(), m.Prodi_2017()));
        }
        return copy_2017;
    }

    private void reset_2017() {
        listMahasiswa_2017.clear();
        dataSorting_2017.clear();
        panelArray_2017.removeAll();
        panelArray_2017.revalidate();
        panelArray_2017.repaint();
        stepArea_2017.setText("");
        stepButton_2017.setEnabled(false);
        mulaiButton_2017.setEnabled(true);
        sorting_2017   = false;
        stepI_2017     = 1;
        stepCount_2017 = 1;
        fieldNama_2017.setText("");
        fieldNim_2017.setText("");
        fieldProdi_2017.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuiUtama_2511532017 gui_2017 = new GuiUtama_2511532017();
            gui_2017.setVisible(true);
        });
    }
}