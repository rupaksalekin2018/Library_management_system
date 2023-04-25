/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YorickDigsGraves
 */
import java.awt.Font;
import java.util.*;
import java.io.*;
import java.text.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class SearchBookMenu extends javax.swing.JFrame {

    /**
     * Creates new form SearchBookMenu
     */
    String n, getsearch = "";
    String check;
    int filesize = 0, count = 0;
    public int StudentID;
    BufferedReader br, br1, br2, br3;
    ArrayList<String> book = new ArrayList<>();
    ArrayList<String> author = new ArrayList<>();
    ArrayList<String> genre = new ArrayList<>();
    ArrayList<String> contain = new ArrayList<>();

    ArrayList<String> bookBook = new ArrayList<>();
    ArrayList<String> finalArray = new ArrayList<>();
    ArrayList<String> temporary = new ArrayList<>();
    ArrayList<String> sortedBook = new ArrayList<>();
    ArrayList<String> saveDate = new ArrayList<>();

    {
        try {
            br = new BufferedReader(new FileReader("Book Name.txt"));
            while (br.readLine() != null) {
                filesize++;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }

    }

    void setButforparttwo() {
        jComboBox4.setEnabled(false);
        jLabel6.setEnabled(false);
        jButton3.setEnabled(false);
    }

    void setButforpartone() {
        jComboBox1.setEnabled(false);
        jComboBox2.setEnabled(false);
        jComboBox3.setEnabled(false);

        jLabel2.setEnabled(false);
        jLabel3.setEnabled(false);
        jLabel4.setEnabled(false);

        jButton2.setEnabled(false);
    }

    void forAuthor() throws FileNotFoundException, IOException {

        book.clear();
        author.clear();
        genre.clear();
        contain.clear();

        br1 = new BufferedReader(new FileReader("Author Name.txt"));

        int temp = filesize;

        while (temp > 0) {
            if (contain.isEmpty()) {
                contain.add(br1.readLine());
            } else {
                ArrayList<String> tempo = contain;
                int i;
                String pep = br1.readLine();

                for (i = 0; i < tempo.size(); i++) {

                    if (pep.equals(tempo.get(i))) {
                        break;
                    }
                }
                if (i == tempo.size()) {
                    contain.add(pep);
                }
            }
            temp--;
        }
        br1.close();
        for (int i = 0; i < contain.size(); i++) {

            jComboBox2.addItem(contain.get(i));
        }

        temp = filesize;

        br = new BufferedReader(new FileReader("Book Name.txt"));
        br1 = new BufferedReader(new FileReader("Author Name.txt"));
        br2 = new BufferedReader(new FileReader("Catagory.txt"));
        br3 = new BufferedReader(new FileReader("Availability.txt"));

        while (temp > 0) {
            String x = br3.readLine();
            if (x.equals("yes")) {
                book.add(br.readLine());
                author.add(br1.readLine());
                genre.add(br2.readLine());
            } else {
                br.readLine();
                br1.readLine();
                br2.readLine();
            }

            temp--;
        }
        br.close();
        br1.close();
        br2.close();
        br3.close();

    }

    void forAll() throws FileNotFoundException, IOException {

        br = new BufferedReader(new FileReader("Book Name.txt"));
        br1 = new BufferedReader(new FileReader("Author Name.txt"));
        br2 = new BufferedReader(new FileReader("Catagory.txt"));
        br3 = new BufferedReader(new FileReader("Availability.txt"));

        int temp = filesize;

        while (temp > 0) {

            String gar;
            String check = br3.readLine();

            if (check.equals("yes")) {
                gar = "Book = " + br.readLine() + "         written by = " + br1.readLine() + ",\t Type : " + br2.readLine();
                jComboBox3.addItem(gar);
            } else {
                br.readLine();
                br1.readLine();
                br2.readLine();
            }
            temp--;
        }
        br.close();
        br1.close();
        br2.close();
        br3.close();

    }

    void forGenre() throws FileNotFoundException, IOException {

        book.clear();
        author.clear();
        genre.clear();
        contain.clear();

        br2 = new BufferedReader(new FileReader("Catagory.txt"));

        int temp = filesize;

        while (temp > 0) {
            if (contain.isEmpty()) {
                contain.add(br2.readLine());
            } else {
                ArrayList<String> tempo = contain;
                int i;
                String pep = br2.readLine();

                for (i = 0; i < tempo.size(); i++) {
                    if (pep.equals(tempo.get(i))) {
                        break;
                    }
                }
                if (i == tempo.size()) {
                    contain.add(pep);
                }
            }
            temp--;
        }
        br2.close();

        for (int i = 0; i < contain.size(); i++) {

            jComboBox2.addItem(contain.get(i));
        }

        temp = filesize;

        br = new BufferedReader(new FileReader("Book Name.txt"));
        br1 = new BufferedReader(new FileReader("Author Name.txt"));
        br2 = new BufferedReader(new FileReader("Catagory.txt"));
        br3 = new BufferedReader(new FileReader("Availability.txt"));

        while (temp > 0) {
            String x = br3.readLine();
            if (x.equals("yes")) {
                book.add(br.readLine());
                author.add(br1.readLine());
                genre.add(br2.readLine());
            } else {
                br.readLine();
                br1.readLine();
                br2.readLine();
            }

            temp--;
        }
        br.close();
        br1.close();
        br2.close();
        br3.close();
    }

    void author() {
        check = jComboBox2.getItemAt(jComboBox2.getSelectedIndex());

        jComboBox3.removeAllItems();
        for (int i = 0; i < book.size(); i++) {
            if (author.get(i).equals(check)) {
                String greg = "Book = " + book.get(i) + "         written by = " + author.get(i) + ",\t Type : " + genre.get(i);
                jComboBox3.addItem(greg);
            }

        }
    }

    void genre() {
        check = jComboBox2.getItemAt(jComboBox2.getSelectedIndex());

        jComboBox3.removeAllItems();
        for (int i = 0; i < book.size(); i++) {
            if (genre.get(i).equals(check)) {
                String greg = "Book = " + book.get(i) + "         written by = " + author.get(i) + ",\t Type : " + genre.get(i);
                jComboBox3.addItem(greg);
            }

        }
    }

    public SearchBookMenu() {
        initComponents();
        setButforparttwo();

        jComboBox1.setEnabled(true);
        jComboBox2.setEnabled(true);
        jComboBox3.setEnabled(true);

        jLabel2.setEnabled(true);
        jLabel3.setEnabled(true);
        jLabel4.setEnabled(true);

        jButton2.setEnabled(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search & Add your desire book here");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Type   :");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Author", "Genre" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(153, 153, 153));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(153, 153, 153));
        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/done.png"))); // NOI18N
        jButton2.setText("Done");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Confirm Your Desire Book");
        jLabel5.setToolTipText("Confirm carefully because one you confirm it you can not undo it");

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Books  :");

        jButton3.setBackground(new java.awt.Color(0, 204, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Confirm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(786, 786, 786)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(389, 389, 389)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(281, 281, 281))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        n = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
        if (n.equals("All")) {

            jLabel3.setText("");
            jLabel4.setText(n + "  :");

            jComboBox3.removeAllItems();
            jComboBox2.removeAllItems();
            jComboBox2.setEnabled(false);
            try {
                forAll();
            } catch (FileNotFoundException ex) {
                ex.getMessage();
            } catch (IOException io) {
                io.getMessage();
            }
        } else if (n.equals("Author")) {

            jLabel3.setText(n + "  :");
            jLabel4.setText("Books  :");

            jComboBox2.setEnabled(true);
            jComboBox2.removeAllItems();
            jComboBox3.removeAllItems();

            try {
                forAuthor();
            } catch (IOException ex) {
                ex.getMessage();
            }

        } else if (n.equals("Genre")) {

            jLabel3.setText(n + "  :");
            jLabel4.setText("Books  :");

            jComboBox2.setEnabled(true);
            jComboBox2.removeAllItems();
            jComboBox3.removeAllItems();
            try {
                forGenre();
            } catch (IOException ex) {
                ex.getMessage();
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

        String gg = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());

        if (gg.equals("Author")) {

            if (temporary.size() > 0) {
                temporary.remove(0);
                //System.out.println(temporary);
                bookBook.addAll(temporary);
                temporary.clear();
            }

            author();

        } else if (gg.equals("Genre")) {

            if (temporary.size() > 0) {
                temporary.remove(0);
                //System.out.println(temporary);
                bookBook.addAll(temporary);
                temporary.clear();
            }

            genre();
        }

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        StudentMenu gg = new StudentMenu();
        gg.setVisible(true);
        gg.catchID = StudentID;
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        jComboBox4.setEnabled(true);
        jLabel6.setEnabled(true);
        jButton3.setEnabled(true);

        setButforpartone();

        if (temporary.size() > 0) {
            temporary.remove(0);
            //System.out.println(temporary);
            bookBook.addAll(temporary);
            temporary.clear();
        }

        if (bookBook.size() > 0) {
            sortedBook.add(bookBook.get(0));

            int i, j;

            for (i = 0; i < bookBook.size(); i++) {

                for (j = 0; j < sortedBook.size(); j++) {

                    if (bookBook.get(i).equals(sortedBook.get(j))) {
                        break;
                    }
                }

                if (j == sortedBook.size()) {
                    sortedBook.add(bookBook.get(i));
                }
            }

            //System.out.println("b2   " + sortedBook);
            for (i = 0; i < sortedBook.size(); i++) {
                jComboBox4.addItem(sortedBook.get(i));
            }

            jComboBox4.setSelectedIndex(-1);
        }

        if (sortedBook.size() == 0) {
            jComboBox4.setEnabled(false);
            jButton3.setEnabled(false);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed

        if (jComboBox3.getSelectedIndex() != -1) {
            String temp = "";
            temp = jComboBox3.getItemAt(jComboBox3.getSelectedIndex());

            temporary.add(temp);
        }

    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed

        UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.BOLD, 14));

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat weep = new SimpleDateFormat("'on' E dd/MM/yyyy 'at' hh:mm:ss a");

        if (jComboBox4.getSelectedIndex() > -1) {
            int x = jComboBox4.getSelectedIndex();

            saveDate.add(weep.format(cal.getTime()));   ///date save korbe
            finalArray.add(sortedBook.get(x));   ///finally book save korbe
            count = 1;

            if ((count == 1) && finalArray.size() > 1) {
                JOptionPane.showMessageDialog(null, "Book is add in your library");
            }

            if (finalArray.size() > 1) {
                //System.out.println("11111" + sortedBook);

                sortedBook.remove(x);
                jComboBox4.removeAllItems();

                for (int i = 0; i < sortedBook.size(); i++) {
                    jComboBox4.addItem(sortedBook.get(i));
                }

                jButton3.setEnabled(true);
            } else {
                jButton3.setEnabled(false);
            }

            //System.out.println("11111" + sortedBook);
        }

    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //System.out.println(finalArray);
        //System.out.println(saveDate);

        saveDate.remove(0);
        finalArray.remove(0);

        //System.out.println(saveDate);
        //System.out.println(finalArray);
        //System.out.println("Student id = " + StudentID);
        try {
            FileInputStream fis;
            ObjectInputStream ois;
            FileOutputStream fos;
            ObjectOutputStream oos;

            ArrayList<StudentInfo> hold = new ArrayList<>();

            fis = new FileInputStream("studentinfo.txt");
            ois = new ObjectInputStream(fis);

            hold = (ArrayList<StudentInfo>) ois.readObject();
            
            ArrayList<String> customFinalArray = new ArrayList<>();
            ArrayList<String> customSaveDate = new ArrayList<>();

            for (int i = 0; i < hold.size(); i++) {
                if (StudentID == hold.get(i).userID) {
                    
                    customFinalArray = hold.get(i).booklist;
                    customSaveDate = hold.get(i).datelist;
                    
                    customFinalArray.addAll(finalArray);
                    customSaveDate.addAll(saveDate);
                    
                    hold.get(i).booklist = customFinalArray;
                    hold.get(i).datelist = customSaveDate;
                    break;
                }
            }

            fis.close();
            ois.close();
            
            fos = new FileOutputStream("studentinfo.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(hold);
            oos.flush();
            oos.close();
            fos.close();
            
            
            StudentMenu xd = new StudentMenu();
            xd.catchID = StudentID;
            xd.setVisible(true);
            this.dispose();

        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException es) {
            es.getMessage();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchBookMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchBookMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchBookMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchBookMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBookMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
