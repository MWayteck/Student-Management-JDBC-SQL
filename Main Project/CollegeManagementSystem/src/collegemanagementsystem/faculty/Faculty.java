package collegemanagementsystem.faculty;

import collegemanagementsystem.MainMenu;
import collegemanagementsystem.model.FacultyModel;
import collegemanagementsystem.model.Staff;
import collegemanagementsystem.model.StudentModel;
import database.DatabaseHandler;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Faculty extends javax.swing.JFrame {

    String searchingTable = "";
    int facultyID;
    DatabaseHandler db = new DatabaseHandler();
    public Faculty() {
        initComponents();
    }
    
    public Faculty(int id){
        this.facultyID = id;
        initComponents();
        facultyId.setText(String.valueOf(facultyID));
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchCombobox = new javax.swing.JComboBox();
        searchId = new javax.swing.JTextField();
        faculty_searchBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        facultyId = new javax.swing.JTextField();
        faculty_backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("Faculty Menu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel2.setText("Search For");

        searchCombobox.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        searchCombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Faculty", "Staff", "Student" }));
        searchCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboboxActionPerformed(evt);
            }
        });

        faculty_searchBtn.setFont(new java.awt.Font("Tahoma", 0, 18));
        faculty_searchBtn.setText("Search");
        faculty_searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faculty_searchBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel3.setText("Enter Search Id");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel4.setText("Your ID");

        faculty_backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        faculty_backBtn.setText("Back");
        faculty_backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faculty_backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(faculty_searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCombobox, 0, 359, Short.MAX_VALUE)
                    .addComponent(searchId)
                    .addComponent(facultyId))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(faculty_backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(facultyId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(searchCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(searchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(faculty_searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(faculty_backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }

    private void searchComboboxActionPerformed(java.awt.event.ActionEvent evt) {
        searchingTable = searchCombobox.getSelectedItem().toString();
    }

    private void faculty_searchBtnActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedItem = searchCombobox.getSelectedItem().toString();
        String searchingCriteria = searchId.getText().toString();
        String fId = facultyId.getText().toString();
        FacultyModel fm = db.searchFaculty(Integer.parseInt(fId));
        if(fm!=null)
        {
            if(selectedItem.equalsIgnoreCase("Faculty")) {
                 FacultyModel faculty= db.searchFaculty(Integer.parseInt(searchingCriteria));
                if(faculty !=null)
                    JOptionPane.showMessageDialog(this, faculty.toString());
                else
                     JOptionPane.showMessageDialog(this, "Record Not Found");
             
            } else if(selectedItem.equalsIgnoreCase("Staff"))
            {
                Staff staff = db.searchStaff(Integer.parseInt(searchingCriteria));
                if(staff !=null)
                    JOptionPane.showMessageDialog(this, staff.toString());
                else
                     JOptionPane.showMessageDialog(this, "Record Not Found");
            } else if(selectedItem.equalsIgnoreCase("Student")) {
                StudentModel studentModel = db.searchStudent(Integer.parseInt(searchingCriteria));
                if(studentModel !=null)
                    JOptionPane.showMessageDialog(this, studentModel.toString());
                else
                     JOptionPane.showMessageDialog(this, "Record Not Found");
            }
        }
    }

    private void faculty_backBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        new MainMenu().setVisible(true);
        
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
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Faculty().setVisible(true);
            }
        });
    }

    // Variables declaration 
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField facultyId;
    private javax.swing.JButton faculty_backBtn;
    private javax.swing.JButton faculty_searchBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox searchCombobox;
    private javax.swing.JTextField searchId;
   
}
