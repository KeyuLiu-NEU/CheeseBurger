/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AssistantMedicineRequest;
import Business.WorkQueue.CareTeamRequest;
import Business.WorkQueue.DoctorMedicineRequest;
import Business.WorkQueue.MedicalDeviceWorkRequest;
import Business.WorkQueue.ReserveDoctorRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private DoctorOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Network network;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DoctorOrganization organization, Enterprise enterprise, Network network) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.network = network;
        valueLabel.setText(enterprise.getName());
        populateAppointmentTable();
        populateMedicineTable();
        populateMedicalDeviceTable();
        populateCareTeamTable();
        surgeryStatusUpdate();
    }
    
    public void populateAppointmentTable(){
        DefaultTableModel model = (DefaultTableModel) appointmentJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest request : network.getWorkQueue().getWorkRequestList()){
            if(request.getType().equals(WorkRequest.Type.ReserveDoctor.getValue())) {
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = request.getReceiver();
                row[2] = request.getStatus();
                //String result = ((AssistantMedicineRequest) request).getTestResult();
                String result = null;

                result = ((ReserveDoctorRequest) request).getPrescription();
                row[3] = result == null ? "Waiting" : result;

                model.addRow(row);
            }
        }
    }
    
    public void populateMedicineTable(){
        DefaultTableModel model = (DefaultTableModel)medicineRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : network.getWorkQueue().getWorkRequestList()){
            if(request.getType().equals(WorkRequest.Type.DoctorMedicine.getValue())){
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getStatus();
                row[4] = request.getType();
                model.addRow(row);
            }
        }

    }
    
      public void populateMedicalDeviceTable(){
        DefaultTableModel model = (DefaultTableModel)medicalDeviceRequestJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : network.getWorkQueue().getWorkRequestList()){
            if(request.getType().equals(WorkRequest.Type.MedicalDevice.getValue())){
                Object[] row = new Object[7];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getStatus();
                row[4] = request.getType();
                row[5] = ((MedicalDeviceWorkRequest)request).getMedicalDeviceANum();
                row[6] = ((MedicalDeviceWorkRequest)request).getMedicalDeviceBNum();
                model.addRow(row);
            }
        }

    }
      
    public void populateCareTeamTable(){
        DefaultTableModel model = (DefaultTableModel)careTeamJTable.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : network.getWorkQueue().getWorkRequestList()){
            if(request.getType().equals(WorkRequest.Type.CareTeam.getValue())){
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getStatus();

                model.addRow(row);
            }
        }
    }
    
    public void surgeryStatusUpdate(){
        if(userAccount.getCareTeamStatus() == true){
            careTeamStatusLabel.setText("Ready");
        }
        else{
            careTeamStatusLabel.setText("Not ready");
        }
        
        if(userAccount.getMedicalDeviceStatus() == true){
            medicalDeviceStatusLabel.setText("Ready");
        }
        else{
            medicalDeviceStatusLabel.setText("Not ready");
        }
        
        if(userAccount.getCareTeamStatus() == true && userAccount.getMedicalDeviceStatus() == true){
            userAccount.setSurgeryStatus(Boolean.TRUE);
            surgeryStatusLabel.setText("Ready");
        }
        else{
            userAccount.setSurgeryStatus(Boolean.FALSE);
            surgeryStatusLabel.setText("Not ready");
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
        appointmentJTable = new javax.swing.JTable();
        requestMedicineJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        requestMedicalDeviceJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicineRequestJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicalDeviceRequestJTable = new javax.swing.JTable();
        enterpriseLabel1 = new javax.swing.JLabel();
        enterpriseLabel2 = new javax.swing.JLabel();
        enterpriseLabel3 = new javax.swing.JLabel();
        enterpriseLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        careTeamJTable = new javax.swing.JTable();
        requestCareTeamJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        careTeamStatusLabel = new javax.swing.JLabel();
        medicalDeviceStatusLabel = new javax.swing.JLabel();
        surgeryStatusLabel = new javax.swing.JLabel();
        processSurgeryJButton = new javax.swing.JButton();

        appointmentJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(appointmentJTable);
        if (appointmentJTable.getColumnModel().getColumnCount() > 0) {
            appointmentJTable.getColumnModel().getColumn(0).setResizable(false);
            appointmentJTable.getColumnModel().getColumn(1).setResizable(false);
            appointmentJTable.getColumnModel().getColumn(2).setResizable(false);
            appointmentJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        requestMedicineJButton.setText("Request Medicine");
        requestMedicineJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestMedicineJButtonActionPerformed(evt);
            }
        });

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        valueLabel.setText("<value>");

        requestMedicalDeviceJButton.setText("Request Medical Device");
        requestMedicalDeviceJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestMedicalDeviceJButtonActionPerformed(evt);
            }
        });

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        processJButton.setText("Inquiry");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        medicineRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(medicineRequestJTable);
        if (medicineRequestJTable.getColumnModel().getColumnCount() > 0) {
            medicineRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            medicineRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            medicineRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            medicineRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        medicalDeviceRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(medicalDeviceRequestJTable);
        if (medicalDeviceRequestJTable.getColumnModel().getColumnCount() > 0) {
            medicalDeviceRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            medicalDeviceRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            medicalDeviceRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            medicalDeviceRequestJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        enterpriseLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel1.setText("Medical Device");

        enterpriseLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel2.setText("Medicine");

        enterpriseLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel3.setText("Care Team List");

        enterpriseLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel4.setText("Appointments");

        careTeamJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Assistant", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(careTeamJTable);
        if (careTeamJTable.getColumnModel().getColumnCount() > 0) {
            careTeamJTable.getColumnModel().getColumn(0).setResizable(false);
            careTeamJTable.getColumnModel().getColumn(1).setResizable(false);
            careTeamJTable.getColumnModel().getColumn(2).setResizable(false);
            careTeamJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        requestCareTeamJButton.setText("Request Care Team");
        requestCareTeamJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestCareTeamJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Surgery Status:");

        jLabel2.setText("Care Team Status:");

        jLabel3.setText("Medical Device Status:");

        careTeamStatusLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        careTeamStatusLabel.setText("<value>");

        medicalDeviceStatusLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        medicalDeviceStatusLabel.setText("<value>");

        surgeryStatusLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        surgeryStatusLabel.setText("<value>");

        processSurgeryJButton.setText("Process Surgery");
        processSurgeryJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processSurgeryJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(processJButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assignJButton)))
                    .addComponent(enterpriseLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(careTeamStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(requestCareTeamJButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(requestMedicineJButton)
                            .addComponent(requestMedicalDeviceJButton)
                            .addComponent(enterpriseLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(221, 221, 221))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(medicalDeviceStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshTestJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surgeryStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(processSurgeryJButton)
                        .addGap(648, 648, 648))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(refreshTestJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(enterpriseLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(medicalDeviceStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enterpriseLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(requestMedicalDeviceJButton)
                        .addGap(44, 44, 44)
                        .addComponent(enterpriseLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(requestMedicineJButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assignJButton)
                        .addGap(4, 4, 4)
                        .addComponent(processJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(careTeamStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(enterpriseLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(requestCareTeamJButton)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(surgeryStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(processSurgeryJButton))))
                        .addGap(92, 92, 92))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestMedicineJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestMedicineJButtonActionPerformed
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("DoctorRequestMedicineJPanel", new DoctorRequestMedicineJPanel(userProcessContainer, userAccount, enterprise, network));
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_requestMedicineJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateAppointmentTable();
        populateMedicineTable();
        populateMedicalDeviceTable();
        populateCareTeamTable();
        surgeryStatusUpdate();
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void requestMedicalDeviceJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestMedicalDeviceJButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestMedicalDeviceJPanel", new RequestMedicalDeviceJPanel(userProcessContainer, userAccount, enterprise, network));
        layout.next(userProcessContainer);
        
        userAccount.setMedicalDeviceStatus(Boolean.FALSE);
    }//GEN-LAST:event_requestMedicalDeviceJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = appointmentJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        WorkRequest request = (WorkRequest)appointmentJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        populateAppointmentTable();

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = appointmentJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        ReserveDoctorRequest request = (ReserveDoctorRequest)appointmentJTable.getValueAt(selectedRow, 0);

        request.setStatus("Processing");

        DoctorProcessAppointmentRequestJPanel processWorkRequestJPanel = new DoctorProcessAppointmentRequestJPanel(userProcessContainer, request);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void requestCareTeamJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestCareTeamJButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestMedicalDeviceJPanel", new DoctorRequestCareTeamJPanel(userProcessContainer, userAccount, enterprise, network));
        layout.next(userProcessContainer);
       
        userAccount.setCareTeamStatus(Boolean.FALSE);
    }//GEN-LAST:event_requestCareTeamJButtonActionPerformed

    private void processSurgeryJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processSurgeryJButtonActionPerformed
        if(userAccount.getCareTeamStatus() == false){
            JOptionPane.showMessageDialog(this, "Care Team is not ready!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(userAccount.getMedicalDeviceStatus() == false){
            JOptionPane.showMessageDialog(this, "Medical Devices are not ready!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        JOptionPane.showMessageDialog(this, "Surgery success!");
            
    }//GEN-LAST:event_processSurgeryJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appointmentJTable;
    private javax.swing.JButton assignJButton;
    private javax.swing.JTable careTeamJTable;
    private javax.swing.JLabel careTeamStatusLabel;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel enterpriseLabel1;
    private javax.swing.JLabel enterpriseLabel2;
    private javax.swing.JLabel enterpriseLabel3;
    private javax.swing.JLabel enterpriseLabel4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable medicalDeviceRequestJTable;
    private javax.swing.JLabel medicalDeviceStatusLabel;
    private javax.swing.JTable medicineRequestJTable;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton processSurgeryJButton;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestCareTeamJButton;
    private javax.swing.JButton requestMedicalDeviceJButton;
    private javax.swing.JButton requestMedicineJButton;
    private javax.swing.JLabel surgeryStatusLabel;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
