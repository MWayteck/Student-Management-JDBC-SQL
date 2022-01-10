/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemanagementsystem.staff;
import collegemanagementsystem.model.StudentModel;
import database.DatabaseHandler;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AR
 */
public class StudentCRUD extends javax.swing.JFrame {

    /**
     * Creates new form StudentCRUD
     */
    DatabaseHandler db = new DatabaseHandler();
    int row;
    public StudentCRUD() {
        initComponents();
        loadJTable();
    }

    
       public void loadJTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        List<StudentModel> list = db.getAllStudents();
        Object rowData[] = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getStudentID();
            rowData[1] = list.get(i).getStudentName();
            rowData[2] = list.get(i).getMajor();
            rowData[3] = list.get(i).getsLevel();
           rowData[4] = list.get(i).getAge();
            model.addRow(rowData);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addStudentBtn = new javax.swing.JButton();
        deleteStudentBtn = new javax.swing.JButton();
        updateStudentBtn = new javax.swing.JButton();
        majorTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        studentIDTextField = new javax.swing.JTextField();
        studentNameTextField = new javax.swing.JTextField();
        levelTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Major", "Level", "Age"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        addStudentBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addStudentBtn.setText("Add Student");
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });

        deleteStudentBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteStudentBtn.setText("Delete Student");
        deleteStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStudentBtnActionPerformed(evt);
            }
        });

        updateStudentBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateStudentBtn.setText("Update Student");
        updateStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentBtnActionPerformed(evt);
            }
        });

        majorTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Major");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("StudentID(Unique)");

        studentIDTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        studentNameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        levelTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("level");

        ageTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("age");

        searchBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchBtn.setText("Search Student");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ageTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(studentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(studentNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                        .addComponent(majorTextField)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(levelTextField)))
                            .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateStudentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(deleteStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(majorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(levelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStudentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        studentIDTextField.setText(model.getValueAt(row, 0).toString());
        studentNameTextField.setText(model.getValueAt(row, 1).toString());
        majorTextField.setText(model.getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        // TODO add your handling code here:
        String studentID = studentIDTextField.getText().toString();
        String studentName = studentNameTextField.getText().toString();
        String major = majorTextField.getText().toString();
        String level = levelTextField.getText().toString();
        String age = ageTextField.getText().toString();
        

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (studentID.isEmpty() || studentName.isEmpty() || major.isEmpty() || level.isEmpty() || age.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty Data Not Acceptable");
        } else {
            int sid = Integer.parseInt(studentID);
            int ageInt = Integer.parseInt(age);

            new DatabaseHandler().addStudentModel(new StudentModel(sid, studentName, major, level,ageInt));
            model.addRow(new Object[]{sid, studentName, major, level, ageInt});
            JOptionPane.showMessageDialog(null, "Student Added Successfully !");
        }
    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void deleteStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStudentBtnActionPerformed
        // TODO add your handling code here:
        String studentID = studentIDTextField.getText().toString();
        if(studentID.isEmpty()){
            JOptionPane.showMessageDialog(null, "Empty Data Acceptable !");
        }else{
            new DatabaseHandler().deleteStudent(Integer.parseInt(studentID));
            JOptionPane.showMessageDialog(null, "Student Deleted Successfully !");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(row);

        }
    }//GEN-LAST:event_deleteStudentBtnActionPerformed

    private void updateStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStudentBtnActionPerformed
        // TODO add your handling code here:

        String studentID = studentIDTextField.getText().toString();
        String sname = studentNameTextField.getText().toString();
        String major = majorTextField.getText().toString();
        String level = levelTextField.getText().toString();
        String age = ageTextField.getText().toString();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(row);

        model.addRow(new Object[]{studentID, sname, major, level, age});

        int sid = Integer.parseInt(studentID);
        int ageInt = Integer.parseInt(age);

        if (studentID.isEmpty() || sname.isEmpty() || major.isEmpty() || level.isEmpty() || age.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty Data Acceptable !");
        } else {
            new DatabaseHandler().updateStudent(new StudentModel(sid, sname, major, level,ageInt));
            JOptionPane.showMessageDialog(null, "Student Updated Successfully !");
        }
    }//GEN-LAST:event_updateStudentBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        String id = studentIDTextField.getText().toString();
        if(!id.isEmpty()){
            StudentModel std = db.searchStudent(Integer.parseInt(id));
            if(std!=null)
                JOptionPane.showMessageDialog(this, std.toString());
            else
                JOptionPane.showMessageDialog(this, "No Record Found");
        } else {
            JOptionPane.showMessageDialog(this, "Enter Valid Student ID");
            
        }
        
    }//GEN-LAST:event_searchBtnActionPerformed

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
            java.util.logging.Logger.getLogger(StudentCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentBtn;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton deleteStudentBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField levelTextField;
    private javax.swing.JTextField majorTextField;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField studentIDTextField;
    private javax.swing.JTextField studentNameTextField;
    private javax.swing.JButton updateStudentBtn;
    // End of variables declaration//GEN-END:variables
}