package odevAramaAgaci;

class node {
    int sayi;
    node sol, sag;

    public node(int sayi) {
        this.sayi = sayi;
        sol = sag = null;
    }
}

class agac{
    node kok;
    public agac(){
        kok = null;
    }
    
void ekle(node yeni) {
    node yer = null;
    node x = kok;

    while (x != null) {
        // Aynı sayı varsa metottan çık, ekleme yapma
        if (yeni.sayi == x.sayi) {
            return; 
        }
        
        yer = x;
        if (yeni.sayi < x.sayi)
            x = x.sol;
        else
            x = x.sag;
    }

    if (yer == null)
        kok = yeni;
    else if (yeni.sayi < yer.sayi)
        yer.sol = yeni;
    else
        yer.sag = yeni;
}
    
    void ciz(java.awt.Graphics g, int x, int y, int gap, node n) {
        //x ve y değerleri her düğümün sol üst köşesini belirler
        //gap değeri ise her düğümün atasından yatay eksende kaç piksel uzak olacağını belirler
        if (n == null) return;

        //dugum cizer(daire) fontu ayarlar ve daire içine sayıyı yazar
        g.drawOval(x, y, 50, 50);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
        g.drawString(String.valueOf(n.sayi), x + 15, y + 35);

        //sol dal
        if (n.sol != null) {
            g.drawLine(x + 15, y + 30, x - gap + 15, y + 60);
            ciz(g, x - gap, y + 60, gap / 2, n.sol);
        }
        //sağ dal
        if (n.sag != null) {
            g.drawLine(x + 15, y + 30, x + gap + 15, y + 60);
            ciz(g, x + gap, y + 60, gap / 2, n.sag);
        }
    }
}



public class odev2 extends javax.swing.JFrame {
    
    agac a = new agac();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(odev2.class.getName());

    public odev2() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        numberInput = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                if (a != null && a.kok != null) {
                    a.ciz(g, getWidth() / 2, 30, getWidth() / 4, a.kok);
                }
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sayı gir");

        jButton1.setText("Ekle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        numberInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numberInput, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(179, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(numberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int girdi = Integer.parseInt(numberInput.getText());
        a.ekle(new node(girdi));
        numberInput.setText("");
        jPanel1.repaint();
        numberInput.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void numberInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberInputActionPerformed

    }//GEN-LAST:event_numberInputActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new odev2().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField numberInput;
    // End of variables declaration//GEN-END:variables
}
