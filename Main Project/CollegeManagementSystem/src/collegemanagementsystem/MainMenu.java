package collegemanagementsystem;

import collegemanagementsystem.faculty.Faculty;
import collegemanagementsystem.model.FacultyModel;
import collegemanagementsystem.model.Staff;
import collegemanagementsystem.staff.StaffCRUD;
import collegemanagementsystem.staff.StaffMenus;
import collegemanagementsystem.student.StudentEnrollment;
import collegemanagementsystem.student.StudentMenu;
import database.DatabaseHandler;
import javax.swing.JOptionPane;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        staffLoginBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        facultyLoginBtn = new javax.swing.JButton();
        studentLoginBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staffLoginBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        staffLoginBtn.setText("Login As Staff");
        staffLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffLoginBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("College Management System");

        facultyLoginBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        facultyLoginBtn.setText("Login As Faculty");
        facultyLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyLoginBtnActionPerformed(evt);
            }
        });

        studentLoginBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        studentLoginBtn.setText("Login As Student");
        studentLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentLoginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(235, 235, 235))
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentLoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffLoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(facultyLoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(staffLoginBtn)
                .addGap(53, 53, 53)
                .addComponent(facultyLoginBtn)
                .addGap(54, 54, 54)
                .addComponent(studentLoginBtn)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }

    private void staffLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {

        String id = JOptionPane.showInputDialog("Enter your Staff Id");
        int sid = Integer.parseInt(id);

        Staff staff = new DatabaseHandler().searchStaff(sid);
        if (staff.getStaffname() != null) {
            StaffMenus staffMenu = new StaffMenus();
            staffMenu.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect Staff ID.", "Alert", JOptionPane.WARNING_MESSAGE);

        }
    }

    private void facultyLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {

        String id = JOptionPane.showInputDialog("Enter your Faculty Id");
        int sid = Integer.parseInt(id);

        FacultyModel faculty = new DatabaseHandler().searchFaculty(sid);
        if (faculty != null) {
            Faculty fac = new Faculty(sid);
            fac.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect Faculty ID.", "Alert", JOptionPane.WARNING_MESSAGE);

        }

    }

    private void studentLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentLoginBtnActionPerformed
        // TODO add your handling code here:
        StudentMenu student = new StudentMenu();
        student.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton facultyLoginBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton staffLoginBtn;
    private javax.swing.JButton studentLoginBtn;
    
}
