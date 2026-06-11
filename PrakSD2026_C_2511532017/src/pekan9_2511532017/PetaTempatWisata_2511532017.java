package pekan9_2511532017;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

public class PetaTempatWisata_2511532017 extends JFrame {

    private static final long serialVersionUID = 1L;


    static class GraphTraversal_2017 {

        private Map<String, List<String>> graph_2017 = new LinkedHashMap<>();

        public void addEdge_2017(String node1_2017, String node2_2017) {
            graph_2017.putIfAbsent(node1_2017, new ArrayList<>());
            graph_2017.putIfAbsent(node2_2017, new ArrayList<>());
            graph_2017.get(node1_2017).add(node2_2017);
            graph_2017.get(node2_2017).add(node1_2017);
        }

        public List<String[]> getAllEdges_2017() {
            List<String[]> edges_2017 = new ArrayList<>();
            Set<String> added_2017 = new HashSet<>();
            for (String node_2017 : graph_2017.keySet()) {
                for (String neighbor_2017 : graph_2017.get(node_2017)) {
                    String key1_2017 = node_2017 + "-" + neighbor_2017;
                    String key2_2017 = neighbor_2017 + "-" + node_2017;
                    if (!added_2017.contains(key1_2017) && !added_2017.contains(key2_2017)) {
                        edges_2017.add(new String[]{node_2017, neighbor_2017});
                        added_2017.add(key1_2017);
                    }
                }
            }
            return edges_2017;
        }

        // BFS iteratif
        public TraversalResult_2017 bfs_2017(String start_2017, String goal_2017) {
            List<String> visited_2017 = new ArrayList<>();
            Map<String, String> parent_2017 = new LinkedHashMap<>();
            Queue<String> queue_2017 = new LinkedList<>();
            queue_2017.add(start_2017);
            visited_2017.add(start_2017);
            parent_2017.put(start_2017, null);
            while (!queue_2017.isEmpty()) {
                String current_2017 = queue_2017.poll();
                if (current_2017.equals(goal_2017)) break;
                for (String neighbor_2017 : graph_2017.getOrDefault(current_2017, new ArrayList<>())) {
                    if (!visited_2017.contains(neighbor_2017)) {
                        queue_2017.add(neighbor_2017);
                        visited_2017.add(neighbor_2017);
                        parent_2017.put(neighbor_2017, current_2017);
                    }
                }
            }
            return new TraversalResult_2017(visited_2017, buildPath_2017(parent_2017, start_2017, goal_2017));
        }

        // DFS rekursif
        public TraversalResult_2017 dfs_2017(String start_2017, String goal_2017) {
            List<String> visited_2017 = new ArrayList<>();
            Map<String, String> parent_2017 = new LinkedHashMap<>();
            parent_2017.put(start_2017, null);
            dfsHelper_2017(start_2017, goal_2017, visited_2017, parent_2017);
            return new TraversalResult_2017(visited_2017, buildPath_2017(parent_2017, start_2017, goal_2017));
        }

        private boolean dfsHelper_2017(String current_2017, String goal_2017,
                List<String> visited_2017, Map<String, String> parent_2017) {
            if (visited_2017.contains(current_2017)) return false;
            visited_2017.add(current_2017);
            if (current_2017.equals(goal_2017)) return true;
            for (String neighbor_2017 : graph_2017.getOrDefault(current_2017, new ArrayList<>())) {
                if (!visited_2017.contains(neighbor_2017)) {
                    parent_2017.put(neighbor_2017, current_2017);
                    if (dfsHelper_2017(neighbor_2017, goal_2017, visited_2017, parent_2017)) return true;
                }
            }
            return false;
        }

        private List<String> buildPath_2017(Map<String, String> parent_2017,
                String start_2017, String goal_2017) {
            List<String> path_2017 = new ArrayList<>();
            if (!parent_2017.containsKey(goal_2017)) return path_2017;
            String cur_2017 = goal_2017;
            while (cur_2017 != null) {
                path_2017.add(0, cur_2017);
                cur_2017 = parent_2017.get(cur_2017);
            }
            return path_2017;
        }

        static class TraversalResult_2017 {
            public final List<String> visited_2017;
            public final List<String> path_2017;
            TraversalResult_2017(List<String> v, List<String> p) {
                visited_2017 = v;
                path_2017 = p;
            }
        }
    }


    class GraphPanel_2017 extends JPanel {

        private static final long serialVersionUID = 2L;
        private static final int R_2017 = 30;

        @Override
        protected void paintComponent(Graphics g_2017) {
            super.paintComponent(g_2017);
            Graphics2D g2_2017 = (Graphics2D) g_2017;
            g2_2017.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                     RenderingHints.VALUE_ANTIALIAS_ON);
            drawEdges_2017(g2_2017);
            drawNodes_2017(g2_2017);
            drawLegend_2017(g2_2017);
        }

        private void drawEdges_2017(Graphics2D g2_2017) {
            for (String[] edge_2017 : traversal_2017.getAllEdges_2017()) {
                int[] p1_2017 = nodePos_2017.get(edge_2017[0]);
                int[] p2_2017 = nodePos_2017.get(edge_2017[1]);
                if (p1_2017 == null || p2_2017 == null) continue;
                if (isEdgeOnPath_2017(edge_2017[0], edge_2017[1])) {
                    g2_2017.setColor(Color.ORANGE);
                    g2_2017.setStroke(new BasicStroke(3f));
                } else {
                    g2_2017.setColor(Color.DARK_GRAY);
                    g2_2017.setStroke(new BasicStroke(1.5f));
                }
                g2_2017.drawLine(p1_2017[0], p1_2017[1], p2_2017[0], p2_2017[1]);
            }
            g2_2017.setStroke(new BasicStroke(1f));
        }

        private boolean isEdgeOnPath_2017(String a_2017, String b_2017) {
            if (pathNodes_2017.size() < 2) return false;
            for (int i_2017 = 0; i_2017 < pathNodes_2017.size() - 1; i_2017++) {
                String u_2017 = pathNodes_2017.get(i_2017);
                String v_2017 = pathNodes_2017.get(i_2017 + 1);
                if ((u_2017.equals(a_2017) && v_2017.equals(b_2017)) ||
                    (u_2017.equals(b_2017) && v_2017.equals(a_2017))) return true;
            }
            return false;
        }

        private void drawNodes_2017(Graphics2D g2_2017) {
            for (String node_2017 : nodePos_2017.keySet()) {
                int[] pos_2017 = nodePos_2017.get(node_2017);
                int x_2017 = pos_2017[0];
                int y_2017 = pos_2017[1];

                Color fill_2017;
                if (!pathNodes_2017.isEmpty() && node_2017.equals(pathNodes_2017.get(0))) {
                    fill_2017 = Color.GREEN;
                } else if (!pathNodes_2017.isEmpty() &&
                           node_2017.equals(pathNodes_2017.get(pathNodes_2017.size() - 1))) {
                    fill_2017 = Color.RED;
                } else if (pathNodes_2017.contains(node_2017)) {
                    fill_2017 = Color.YELLOW;
                } else if (visitedNodes_2017.contains(node_2017)) {
                    fill_2017 = Color.CYAN;
                } else {
                    fill_2017 = Color.LIGHT_GRAY;
                }

                g2_2017.setColor(fill_2017);
                g2_2017.fillOval(x_2017 - R_2017, y_2017 - R_2017, R_2017 * 2, R_2017 * 2);
                g2_2017.setColor(Color.BLACK);
                g2_2017.setStroke(new BasicStroke(1.5f));
                g2_2017.drawOval(x_2017 - R_2017, y_2017 - R_2017, R_2017 * 2, R_2017 * 2);
                g2_2017.setStroke(new BasicStroke(1f));

                g2_2017.setFont(new Font("SansSerif", Font.BOLD, 10));
                g2_2017.setColor(Color.BLACK);
                FontMetrics fm_2017 = g2_2017.getFontMetrics();
                String[] parts_2017 = node_2017.split(" ", 2);
                if (parts_2017.length == 2) {
                    g2_2017.drawString(parts_2017[0],
                        x_2017 - fm_2017.stringWidth(parts_2017[0]) / 2, y_2017 - 3);
                    g2_2017.drawString(parts_2017[1],
                        x_2017 - fm_2017.stringWidth(parts_2017[1]) / 2, y_2017 + 11);
                } else {
                    g2_2017.drawString(node_2017,
                        x_2017 - fm_2017.stringWidth(node_2017) / 2, y_2017 + 4);
                }
            }
        }

        private void drawLegend_2017(Graphics2D g2_2017) {
            int lx_2017 = 16;
            int ly_2017 = getHeight() - 105;
            g2_2017.setFont(new Font("SansSerif", Font.PLAIN, 11));
            String[][] items_2017 = {
                {"Start Node",       "GREEN"},
                {"Goal Node",        "RED"},
                {"Node pada Jalur",  "YELLOW"},
                {"Dikunjungi",       "CYAN"},
                {"Belum Dikunjungi", "LIGHT_GRAY"}
            };
            Color[] colors_2017 = {Color.GREEN, Color.RED, Color.YELLOW, Color.CYAN, Color.LIGHT_GRAY};
            for (int i_2017 = 0; i_2017 < items_2017.length; i_2017++) {
                g2_2017.setColor(colors_2017[i_2017]);
                g2_2017.fillRect(lx_2017, ly_2017, 14, 14);
                g2_2017.setColor(Color.BLACK);
                g2_2017.drawRect(lx_2017, ly_2017, 14, 14);
                g2_2017.drawString(items_2017[i_2017][0], lx_2017 + 20, ly_2017 + 12);
                ly_2017 += 20;
            }
        }
    }


    private JComboBox<String> cbStart_2017;
    private JComboBox<String> cbGoal_2017;
    private JTextArea         taResult_2017;
    private GraphPanel_2017   graphPanel_2017;

    private final GraphTraversal_2017    traversal_2017    = new GraphTraversal_2017();
    private List<String>                 visitedNodes_2017 = new ArrayList<>();
    private List<String>                 pathNodes_2017    = new ArrayList<>();
    private final Map<String, int[]>     nodePos_2017      = new LinkedHashMap<>();

    private static final String[] NODES_2017 = {
        "Garegeh", "Pasa Ateh", "Pasa Bawah", "Jam Gadang", "Panorama",
        "Ngarai Sianok", "Kbn Binatang", "Blkg Balok", "Lapang Kantin", "Rmh Bung Hatta"
    };


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new PetaTempatWisata_2511532017().setVisible(true);
            } catch (Exception e) { e.printStackTrace(); }
        });
    }


    public PetaTempatWisata_2511532017() {
        setTitle("Pencarian Jalur Wisata Bukittinggi - BFS & DFS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 680);
        buildGraph_2017();
        setupUI_2017();
    }

    private void buildGraph_2017() {
        nodePos_2017.put("Garegeh",        new int[]{  90, 210});
        nodePos_2017.put("Pasa Ateh",      new int[]{ 240,  80});
        nodePos_2017.put("Pasa Bawah",     new int[]{ 240, 210});
        nodePos_2017.put("Jam Gadang",     new int[]{ 400,  80});
        nodePos_2017.put("Panorama",       new int[]{ 560,  80});
        nodePos_2017.put("Ngarai Sianok",  new int[]{ 720,  80});
        nodePos_2017.put("Kbn Binatang",   new int[]{ 560, 250});
        nodePos_2017.put("Blkg Balok",     new int[]{ 720, 360});
        nodePos_2017.put("Lapang Kantin",  new int[]{ 400, 360});
        nodePos_2017.put("Rmh Bung Hatta", new int[]{ 240, 360});

        traversal_2017.addEdge_2017("Garegeh",       "Pasa Ateh");
        traversal_2017.addEdge_2017("Garegeh",       "Pasa Bawah");
        traversal_2017.addEdge_2017("Garegeh",       "Rmh Bung Hatta");
        traversal_2017.addEdge_2017("Pasa Ateh",     "Pasa Bawah");
        traversal_2017.addEdge_2017("Pasa Ateh",     "Jam Gadang");
        traversal_2017.addEdge_2017("Pasa Bawah",    "Jam Gadang");
        traversal_2017.addEdge_2017("Pasa Bawah",    "Rmh Bung Hatta");
        traversal_2017.addEdge_2017("Jam Gadang",    "Panorama");
        traversal_2017.addEdge_2017("Jam Gadang",    "Lapang Kantin");
        traversal_2017.addEdge_2017("Panorama",      "Ngarai Sianok");
        traversal_2017.addEdge_2017("Panorama",      "Kbn Binatang");
        traversal_2017.addEdge_2017("Ngarai Sianok", "Kbn Binatang");
        traversal_2017.addEdge_2017("Kbn Binatang",  "Blkg Balok");
        traversal_2017.addEdge_2017("Blkg Balok",    "Lapang Kantin");
        traversal_2017.addEdge_2017("Lapang Kantin", "Rmh Bung Hatta");
        traversal_2017.addEdge_2017("Ngarai Sianok", "Blkg Balok");
    }

    private void setupUI_2017() {
        JPanel contentPane_2017 = new JPanel(new BorderLayout(5, 5));
        contentPane_2017.setBorder(new EmptyBorder(8, 8, 8, 8));
        setContentPane(contentPane_2017);

        // Panel atas
        JPanel topPanel_2017 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        topPanel_2017.setBorder(new TitledBorder("Pencarian Jalur Menggunakan BFS dan DFS"));

        topPanel_2017.add(new JLabel("Lokasi Awal :"));
        cbStart_2017 = new JComboBox<>(NODES_2017);
        topPanel_2017.add(cbStart_2017);

        topPanel_2017.add(new JLabel("Lokasi Tujuan :"));
        cbGoal_2017 = new JComboBox<>(NODES_2017);
        cbGoal_2017.setSelectedIndex(5);
        topPanel_2017.add(cbGoal_2017);

        JButton btnBFS_2017   = new JButton("BFS");
        JButton btnDFS_2017   = new JButton("DFS");
        JButton btnReset_2017 = new JButton("Reset");

        btnBFS_2017.addActionListener(e -> runBFS_2017());
        btnDFS_2017.addActionListener(e -> runDFS_2017());
        btnReset_2017.addActionListener(e -> resetGraph_2017());

        topPanel_2017.add(btnBFS_2017);
        topPanel_2017.add(btnDFS_2017);
        topPanel_2017.add(btnReset_2017);
        contentPane_2017.add(topPanel_2017, BorderLayout.NORTH);

        // Panel tengah 
        graphPanel_2017 = new GraphPanel_2017();
        graphPanel_2017.setBorder(new TitledBorder("Visualisasi Graph"));
        contentPane_2017.add(graphPanel_2017, BorderLayout.CENTER);

        // Panel bawah 
        JPanel bottomPanel_2017 = new JPanel(new BorderLayout());
        bottomPanel_2017.setBorder(new TitledBorder("Hasil Pencarian"));
        bottomPanel_2017.setPreferredSize(new Dimension(0, 160));

        taResult_2017 = new JTextArea();
        taResult_2017.setEditable(false);
        taResult_2017.setFont(new Font("Monospaced", Font.PLAIN, 12));
        bottomPanel_2017.add(new JScrollPane(taResult_2017), BorderLayout.CENTER);
        contentPane_2017.add(bottomPanel_2017, BorderLayout.SOUTH);
    }

    
    private void runBFS_2017() {
        String start_2017 = (String) cbStart_2017.getSelectedItem();
        String goal_2017  = (String) cbGoal_2017.getSelectedItem();
        if (start_2017.equals(goal_2017)) { showSameNodeWarning_2017(); return; }
        GraphTraversal_2017.TraversalResult_2017 res_2017 =
            traversal_2017.bfs_2017(start_2017, goal_2017);
        visitedNodes_2017 = res_2017.visited_2017;
        pathNodes_2017    = res_2017.path_2017;
        displayResult_2017("BFS", start_2017, goal_2017, res_2017.visited_2017, res_2017.path_2017);
        graphPanel_2017.repaint();
    }

    
    private void runDFS_2017() {
        String start_2017 = (String) cbStart_2017.getSelectedItem();
        String goal_2017  = (String) cbGoal_2017.getSelectedItem();
        if (start_2017.equals(goal_2017)) { showSameNodeWarning_2017(); return; }
        GraphTraversal_2017.TraversalResult_2017 res_2017 =
            traversal_2017.dfs_2017(start_2017, goal_2017);
        visitedNodes_2017 = res_2017.visited_2017;
        pathNodes_2017    = res_2017.path_2017;
        displayResult_2017("DFS", start_2017, goal_2017, res_2017.visited_2017, res_2017.path_2017);
        graphPanel_2017.repaint();
    }


    private void resetGraph_2017() {
        visitedNodes_2017.clear();
        pathNodes_2017.clear();
        taResult_2017.setText("");
        cbStart_2017.setSelectedIndex(0);
        cbGoal_2017.setSelectedIndex(5);
        graphPanel_2017.repaint();
    }

    
    private void displayResult_2017(String algo_2017, String start_2017, String goal_2017,
            List<String> visited_2017, List<String> path_2017) {
        StringBuilder sb_2017 = new StringBuilder();
        sb_2017.append("Algoritma           : ").append(algo_2017).append("\n");
        sb_2017.append("Lokasi Awal         : ").append(start_2017).append("\n");
        sb_2017.append("Lokasi Tujuan       : ").append(goal_2017).append("\n");
        sb_2017.append("--------------------------------------------------\n");
        sb_2017.append("Node Dikunjungi     : ").append(String.join(" -> ", visited_2017)).append("\n");
        sb_2017.append("Jumlah Dieksplorasi : ").append(visited_2017.size()).append(" node\n");
        sb_2017.append("--------------------------------------------------\n");
        if (path_2017.isEmpty()) {
            sb_2017.append("Jalur               : Tidak ditemukan!\n");
        } else {
            sb_2017.append("Jalur               : ").append(String.join(" -> ", path_2017)).append("\n");
            sb_2017.append("Panjang Jalur       : ").append(path_2017.size() - 1).append(" langkah\n");
        }
        taResult_2017.setText(sb_2017.toString());
    }

    private void showSameNodeWarning_2017() {
        JOptionPane.showMessageDialog(this,
            "Lokasi awal dan tujuan tidak boleh sama!",
            "Peringatan", JOptionPane.WARNING_MESSAGE);
    }
}