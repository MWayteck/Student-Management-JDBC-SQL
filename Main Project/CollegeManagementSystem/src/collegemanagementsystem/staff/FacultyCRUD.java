/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package collegemanagementsystem.staff;

import collegemanagementsystem.model.CourseModel;
import collegemanagementsystem.model.FacultyModel;
import database.DatabaseHandler;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AR
 */
public class FacultyCRUD extends javax.swing.JFrame {

    /** Creates new form FacultyCRUD */
    DatabaseHandler db= new DatabaseHandler();
    public FacultyCRUD() {
        initComponents();
        loadJTable();
    }
    int row;
    
      public void loadJTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        List<FacultyModel> list = db.getAllFaculty();
        Object rowData[] = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            rowData[0] = list.get(i).getFacultyID();
            rowData[1] = list.get(i).getFacultyName();
            rowData[2] = list.get(i).getDeptID();
            model.addRow(rowData);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addFacultyBtn = new javax.swing.JButton();
        deleteFacultyBtn = new javax.swing.JButton();
        updateFacultyBtn = new javax.swing.JButton();
        deptIDTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        facultyIDTextField = new javax.swing.JTextField();
        facultyNameTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        facultyMenu_backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Faculty ID", "Name", "Department ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        addFacultyBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addFacultyBtn.setText("Add Faculty");
        addFacultyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFacultyBtnActionPerformed(evt);
            }
        });

        deleteFacultyBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteFacultyBtn.setText("Delete Faculty");
        deleteFacultyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFacultyBtnActionPerformed(evt);
            }
        });

        updateFacultyBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateFacultyBtn.setText("Update Faculty");
        updateFacultyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFacultyBtnActionPerformed(evt);
            }
        });

        deptIDTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("DepartmentID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("FacultyID(Unique)");

        facultyIDTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        facultyNameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        searchBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchBtn.setText("Search Faculty");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        facultyMenu_backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        facultyMenu_backBtn.setText("Back");
        facultyMenu_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyMenu_backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deptIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(facultyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(facultyIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(facultyMenu_backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(addFacultyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(updateFacultyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(deleteFacultyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(facultyIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(facultyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deptIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addFacultyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteFacultyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateFacultyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addComponent(facultyMenu_backBtn, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        row = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        facultyIDTextField.setText(model.getValueAt(row, 0).toString());
        facultyNameTextField.setText(model.getValueAt(row, 1).toString());
        deptIDTextField.setText(model.getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void addFacultyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFacultyBtnActionPerformed
        // TODO add your handling code here:
        String facultyID = facultyIDTextField.getText().toString();
        String facultyName = facultyNameTextField.getText().toString();
        String deptID = deptIDTextField.getText().toString();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (facultyID.isEmpty() || facultyName.isEmpty() || deptID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty Data Not Acceptable");
        } else {
            int fId = Integer.parseInt(facultyID);
            int did = Integer.parseInt(deptID);

            new DatabaseHandler().addFaculty(new FacultyModel(fId, facultyName, did));
            model.addRow(new Object[]{fId, facultyName, deptID});
            JOptionPane.showMessageDialog(null, "Faculty Added Successfully !");
        }
    }//GEN-LAST:event_addFacultyBtnActionPerformed

    private void deleteFacultyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFacultyBtnActionPerformed
        // TODO add your handling code here:
        String fID = facultyIDTextField.getText().toString();
        if(fID.isEmpty()){
            JOptionPane.showMessageDialog(null, "Empty Data Acceptable !");
        }else{
            new DatabaseHandler().deleteFaculty(Integer.parseInt(fID));
            JOptionPane.showMessageDialog(null, "Faculty Deleted Successfully !");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(row);

        }
    }//GEN-LAST:event_deleteFacultyBtnActionPerformed

    private void updateFacultyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFacultyBtnActionPerformed
        // TODO add your handling code here:

        String facultyID = facultyIDTextField.getText().toString();
        String fname = facultyNameTextField.getText().toString();
        String depid = deptIDTextField.getText().toString();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(row);

        model.addRow(new Object[]{facultyID, fname, depid});

        int fid = Integer.parseInt(facultyID);
        int did = Integer.parseInt(depid);

        if (facultyID.isEmpty() || fname.isEmpty() || depid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty Data Acceptable !");
        } else {
            new DatabaseHandler().updateFaculty(new FacultyModel(fid, fname, did));
            JOptionPane.showMessageDialog(null, "Faculty Updated Successfully !");
        }
    }//GEN-LAST:event_updateFacultyBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        String id = facultyIDTextField.getText().toString();
        if(!id.isEmpty()){
            FacultyModel fm = db.searchFaculty(Integer.parseInt(id));
            if(fm!=null)
                JOptionPane.showMessageDialog(this, fm.toString());
            else
                JOptionPane.showMessageDialog(this, "No Record Found");
        } else {
            JOptionPane.showMessageDialog(this, "Enter Valid Faculty ID");
            
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void facultyMenu_backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyMenu_backBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new StaffMenus().setVisible(true);
    }//GEN-LAST:event_facultyMenu_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(FacultyCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacultyCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacultyCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacultyCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacultyCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFacultyBtn;
    private javax.swing.JButton deleteFacultyBtn;
    private javax.swing.JTextField deptIDTextField;
    private javax.swing.JTextField facultyIDTextField;
    private javax.swing.JButton facultyMenu_backBtn;
    private javax.swing.JTextField facultyNameTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton updateFacultyBtn;
    // End of variables declaration//GEN-END:variables

}
