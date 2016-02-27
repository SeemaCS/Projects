

import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

/**
 *
 * @author Seema Sardesa - W1008598 Database Homework 3
 */
public class DB3UI extends javax.swing.JFrame {
    int xCoordinate = 0;
    int yCoordinate = 0;
    int pointCount = 0;
    int y1 = 0;
    Graphics g;
    List<Double> buildPoints = new ArrayList<Double>();
    List<Integer> buildingCoords = new ArrayList<Integer>();
    ArrayList<Integer> xCoordList = new ArrayList<Integer>();
    ArrayList<Integer> yCoordList = new ArrayList<Integer>();
    boolean buildingSelected = false;
    boolean buildingsOnFireSelected = false;
    boolean hydrantSelected = false;
    boolean wholeRegion = false;
    boolean rangeQuery = false;
    boolean neighborBuilding = false;
    boolean closestHydrant = false;

    public DB3UI() {
        initComponents();
        radioButton();
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
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Active Feature Type");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Buildings");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Buildings on Fire");
        jCheckBox2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox2StateChanged(evt);
            }
        });

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Hydrant");
        jCheckBox3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox3StateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Query");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Whole Region");
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRadioButton2.setText("Range Query");
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRadioButton3.setText("Find Neighbor Buildings");
        jRadioButton3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton3StateChanged(evt);
            }
        });

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jRadioButton4.setText("Find Closest Fire Hydrants");
        jRadioButton4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton4StateChanged(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Submit Query");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setText("jLabel4");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("map.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel5MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(212, 212, 212))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton4))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jButton1))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     private void radioButton() {
         ButtonGroup bg = new ButtonGroup();
         bg.add(jRadioButton1);
         bg.add(jRadioButton2);
         bg.add(jRadioButton3);
         bg.add(jRadioButton4);
     }
     
    /*
     * This method will get the points where the mouse is placed on the map
     */
    private void jLabel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseMoved
        xCoordinate = evt.getX();
        yCoordinate = evt.getY();
        jLabel4.setText("Current Mouse Position :" + xCoordinate + "," + yCoordinate);
    }//GEN-LAST:event_jLabel5MouseMoved

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        xCoordList.add(evt.getX());
        yCoordList.add(evt.getY());
        System.out.println(xCoordList.size());
        try {
            if (jRadioButton2.isSelected()) {
                showLine(xCoordList);
            }
            if (jRadioButton4.isSelected()) {
                drawCustomBuilding(evt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    public void drawCustomBuilding(java.awt.event.MouseEvent evt) throws SQLException, ClassNotFoundException {
       Connection conn1 = null;
        try{
        conn1 = openConnection();
        double[] buildingArray;
        int coordinatex = evt.getX();
        int coordinatey = evt.getY();
        int[] pointsX = new int[60];
        int[] pointsY = new int[60];
        StringBuffer query1 = new StringBuffer();
        query1.append("SELECT b.shape, b.no_points FROM building b WHERE SDO_CONTAINS(b.shape,SDO_GEOMETRY(2001, NULL, SDO_POINT_TYPE(" + coordinatex + "," + coordinatey + ",NULL),NULL,NULL)) = 'TRUE'");
        String queryToFire1 = query1.toString();
        ResultSet building1 = null;
        PreparedStatement stmt9 = conn1.prepareStatement(queryToFire1);
        building1 = stmt9.executeQuery();
        
        while (building1.next()) {
            int buildingPoints = building1.getInt("no_points");
            buildingCoords.add(buildingPoints);
            STRUCT st1 = (oracle.sql.STRUCT) building1.getObject(1);
            JGeometry buildingGeom = JGeometry.load(st1);
            buildingArray = buildingGeom.getOrdinatesArray();
            for (int i = 0; i < buildingArray.length; i++) {
                buildPoints.add(buildingArray[i]);
            }
            int numberOfPoints = buildingGeom.getNumPoints();
            int count = 0;
            for (int i = 0; i < numberOfPoints; i++) {
                pointsX[i] = (int) buildingArray[count];
                ++count;
                pointsY[i] = (int) buildingArray[count];
                ++count;
            }
            drawBuilding1(pointsX, pointsY, numberOfPoints, Color.RED);
            setVisible(true);
        } 
       } finally {
                conn1.commit();
                conn1.close();
                }
    }
    
    public Connection openConnection() throws SQLException, ClassNotFoundException
        {
           // Load the Oracle database driver
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
  
           String host = "dagobah.engr.scu.edu";
           String port = "1521";
           String dbName = "db11g";
           String userName = "ssardesa";
           String password = "oracle";
   
          // Construct the JDBC URL
          String dbURL = "jdbc:oracle:thin:@" + host + ":" + port + ":" + dbName;
          return DriverManager.getConnection(dbURL, userName, password);             
      }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int queryCounter = 0;
        List<String> queries = new ArrayList<String>();
        List<Integer> counter = new ArrayList<Integer>();
        buildingSelected = jCheckBox1.isSelected();
        buildingsOnFireSelected = jCheckBox2.isSelected();
        hydrantSelected = jCheckBox3.isSelected();
        wholeRegion = jRadioButton1.isSelected();
        rangeQuery = jRadioButton2.isSelected();
        neighborBuilding = jRadioButton3.isSelected();
        closestHydrant = jRadioButton4.isSelected();
        try {
            if (buildingSelected && wholeRegion) {
                counter.add(++queryCounter);
                showBuilding();
                queries.add("select * from building");
            }
            if (buildingsOnFireSelected && wholeRegion) {
                counter.add(++queryCounter);
                showFireBuilding();
                queries.add("select * from firebuilding");
            }
            if (hydrantSelected && wholeRegion) {
                counter.add(++queryCounter);
                showHydrant();
                queries.add("select * from hydrant");
            }
            if (rangeQuery) {
                String rangeQ = select_range();
                jTextArea1.setText("Query 1:"+rangeQ);
            }
            if (neighborBuilding) {
                String neighborQ = select_fireBuildings();
                jTextArea1.setText("Query 1:"+neighborQ);
            }
            if (closestHydrant) {
                String hydrantQ = select_hydrantInRange();
                jTextArea1.setText("Query 1:"+hydrantQ);
            }
            
            if(buildingSelected && buildingsOnFireSelected && hydrantSelected && wholeRegion) {
            jTextArea1.setText("Query "+counter.get(0)+":"+queries.get(0)+"\nQuery "+counter.get(1)+":"+queries.get(1)+"\nQuery "+counter.get(2)+":"+queries.get(2));
            }
            else if(buildingSelected && buildingsOnFireSelected && wholeRegion) {
              jTextArea1.setText("Query "+counter.get(0)+":"+queries.get(0)+"\nQuery "+counter.get(1)+":"+queries.get(1));  
            }
            else  if(buildingsOnFireSelected && hydrantSelected && wholeRegion) {
              jTextArea1.setText("Query "+counter.get(0)+":"+queries.get(0)+"\nQuery "+counter.get(1)+":"+queries.get(1));  
            }
            else if(buildingSelected && hydrantSelected && wholeRegion) {
              jTextArea1.setText("Query "+counter.get(0)+":"+queries.get(0)+"\nQuery "+counter.get(1)+":"+queries.get(1));  
            }
            else if(buildingSelected && wholeRegion) {
              jTextArea1.setText("Query "+counter.get(0)+":"+queries.get(0));  
            }
            else if(buildingsOnFireSelected && wholeRegion) {
              jTextArea1.setText("Query "+counter.get(0)+":"+queries.get(0));  
            }
            else if(hydrantSelected && wholeRegion) {
              jTextArea1.setText("Query "+counter.get(0)+":"+queries.get(0));  
            } 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        jLabel5.repaint();
        jTextArea1.setText("");
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox2StateChanged
        jLabel5.repaint();
        jTextArea1.setText("");
    }//GEN-LAST:event_jCheckBox2StateChanged

    private void jCheckBox3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox3StateChanged
        jLabel5.repaint();
        jTextArea1.setText("");
    }//GEN-LAST:event_jCheckBox3StateChanged

    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton1StateChanged
        jLabel5.repaint();
        jTextArea1.setText("");
    }//GEN-LAST:event_jRadioButton1StateChanged

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged
        jLabel5.repaint();
        jTextArea1.setText("");
    }//GEN-LAST:event_jRadioButton2StateChanged

    private void jRadioButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton3StateChanged
        jLabel5.repaint();
        jTextArea1.setText("");
    }//GEN-LAST:event_jRadioButton3StateChanged

    private void jRadioButton4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton4StateChanged
        jLabel5.repaint();
        jTextArea1.setText("");
    }//GEN-LAST:event_jRadioButton4StateChanged

    
    public String select_hydrantInRange() throws SQLException {
        String qu1 = "";
        Connection conn2 = null;
        try {
            conn2 = openConnection();
            ResultSet hydrantResult = null;
            double[] coordinateHydrant;
            
            int coordinateLength = 0;
            StringBuffer hydrantQuery = new StringBuffer();
            int numCoords = 0;
            for (int i = 0; i < buildingCoords.size(); i++) {
                numCoords = buildingCoords.get(i);
                hydrantQuery.append("SELECT h.location, SDO_NN_DISTANCE(1) dist from hydrant h WHERE SDO_NN(h.location, SDO_GEOMETRY(2001, NULL, NULL, SDO_ELEM_INFO_ARRAY(1,1003,1), SDO_ORDINATE_ARRAY(");
                for (y1 = 0; y1 < numCoords * 2; y1++) {
                    hydrantQuery.append(buildPoints.get(pointCount));
                    hydrantQuery.append(",");
                    pointCount++;
                }
                pointCount += 2;
                hydrantQuery.append(buildPoints.get(0));
                hydrantQuery.append(",");
                hydrantQuery.append(buildPoints.get(1));
                hydrantQuery.append(")),'SDO_NUM_RES =1', 1) = 'TRUE' ORDER BY dist");
                qu1 = hydrantQuery.toString();
                PreparedStatement stmt1 = conn2.prepareStatement(qu1);
                hydrantResult = stmt1.executeQuery();

                while (hydrantResult.next()) {
                    STRUCT st = (oracle.sql.STRUCT) hydrantResult.getObject(1);
                    JGeometry hydrant = JGeometry.load(st);
                    coordinateHydrant = hydrant.getPoint();
                    coordinateLength = hydrant.getNumPoints();
                    List<Integer> hPoints = new ArrayList<Integer>();
                    hPoints.add(coordinateLength);
                    int xPoint = 0;
                    int yPoint = 0;
                    for (int j = 0; j <= hPoints.size(); j++) {
                        if (j % 2 == 0) {
                            xPoint = (int) coordinateHydrant[j];
                        } else {
                            yPoint = (int) coordinateHydrant[j];
                        }
                    }
                    drawHydrant(xPoint, yPoint, Color.GREEN);
                    setVisible(true);
                    hydrantQuery.replace(0, hydrantQuery.length(), "");
                }
            }
            
        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn2.commit();
            conn2.close();
        }
        return qu1;
    }

    private void Move(java.awt.event.MouseEvent evt) {
        xCoordinate = evt.getX();
        yCoordinate = evt.getY();
        jLabel4.setText("Mouse is set to " + xCoordinate + "," + yCoordinate);
        // TODO add your handling code here:
    }

    public void drawBuilding1(int[] u, int[] n, int length, Color C) {
        g = jLabel5.getGraphics();
        g.setColor(C);
        g.drawPolygon(u, n, length);      
    }

    public void drawHydrant(int u, int n, Color C) {
        g = jLabel5.getGraphics();
        g.setColor(Color.GREEN);
        g.fillOval(u, n, 5, 5);
    }

    public String select_fireBuildings() throws SQLException {
        Connection conn3 = null;
        ResultSet fireBuilding = null;
        double[] fireOridinate;
        double[] buildOrdinate;
        int[] x1 = new int[60];
        int[] y1 = new int[60];
        String fire1 = "";
        try {          
                conn3 = openConnection();           
            StringBuffer buildQuery = new StringBuffer();
            buildQuery.append("select b.shape from building b where b.name in(select f.name from firebuilding f)");
            String query1 = buildQuery.toString();
            PreparedStatement stmt1 = conn3.prepareStatement(query1);
            fireBuilding = stmt1.executeQuery();

            while (fireBuilding.next()) {
                STRUCT st = (oracle.sql.STRUCT) fireBuilding.getObject(1);
                JGeometry buildGeom = JGeometry.load(st);
                fireOridinate = buildGeom.getOrdinatesArray();
                int firePoint = buildGeom.getNumPoints();
                StringBuffer sb = new StringBuffer();
                for (int e = 0; e < fireOridinate.length; e++) {
                    if (e < fireOridinate.length - 1) {
                        sb.append(fireOridinate[e]);
                        sb.append(",");
                    } else {
                        sb.append(fireOridinate[e]);
                    }
                }
                String fire = sb.toString();
                StringBuffer q1 = new StringBuffer();
                q1.append("SELECT b.shape FROM building b WHERE SDO_WITHIN_DISTANCE(b.shape,SDO_GEOMETRY(2003, NULL, NULL, SDO_ELEM_INFO_ARRAY(1,1003,1), SDO_ORDINATE_ARRAY(");
                q1.append(fire);
                q1.append(")),'distance=100') = 'TRUE'");
                fire1 = q1.toString();
                System.out.println(fire1);
                ResultSet shapeResult = null;
                PreparedStatement stmt3 = conn3.prepareStatement(fire1);
                shapeResult = stmt3.executeQuery();

                while (shapeResult.next()) {
                    STRUCT st1 = (oracle.sql.STRUCT) shapeResult.getObject(1);
                    JGeometry shapeGeom = JGeometry.load(st1);
                    buildOrdinate = shapeGeom.getOrdinatesArray();
                    int shapePoint = shapeGeom.getNumPoints();
                    int countPoint = 0;

                    for (int i = 0; i < shapePoint; i++) {
                        x1[i] = (int) buildOrdinate[countPoint];
                        ++countPoint;
                        y1[i] = (int) buildOrdinate[countPoint];
                        ++countPoint;
                    }
                    drawBuilding1(x1, y1, shapePoint, Color.YELLOW);
                    setVisible(true);
                }
                int countFirePoint = 0;
                for (int i = 0; i < firePoint; i++) {
                    x1[i] = (int) fireOridinate[countFirePoint];
                    ++countFirePoint;
                    y1[i] = (int) fireOridinate[countFirePoint];
                    ++countFirePoint;
                }
                drawBuilding1(x1, y1, firePoint, Color.RED);
                setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn3.commit();
            conn3.close();
        } 
        return fire1;
    }

    public String select_range() throws SQLException {
        Connection conn4 = null;
        ResultSet rangeResult = null;
        String qu = "";
        try {
            conn4 = openConnection();
            StringBuffer q = new StringBuffer();
            q.append("SELECT b.shape FROM building b WHERE SDO_ANYINTERACT(b.shape, SDO_GEOMETRY(2003, NULL, NULL,SDO_ELEM_INFO_ARRAY(1,1003,1),SDO_ORDINATE_ARRAY(");
            double[] rangeOrdinate;
            int rangePoint = 0;
            int[] x1 = new int[60];
            int[] y1 = new int[60];
            double[] coord = new double[xCoordList.size() * 2];
            int s = 0;
            int r = 0;
            for (int t = 0; t < xCoordList.size() * 2; t++) {
                if (t % 2 == 0) {
                    coord[t] = xCoordList.get(s++);
                } else {
                    coord[t] = yCoordList.get(r++);
                }
            }
            for (int y = 0; y <= coord.length - 1; y++) {
                if (y <= coord.length - 2) {
                    q.append(coord[y]);
                    q.append(",");
                } else {
                    q.append(coord[y]);
                }
            }
            q.append("))) = 'TRUE'");
            qu = q.toString();
            PreparedStatement stmt1 = conn4.prepareStatement(qu);
            rangeResult = stmt1.executeQuery();

            while (rangeResult.next()) {
                STRUCT st = (oracle.sql.STRUCT) rangeResult.getObject(1);
                JGeometry rangeGeom = JGeometry.load(st);
                rangeOrdinate = rangeGeom.getOrdinatesArray();
                rangePoint = rangeGeom.getNumPoints();
                int countRange = 0;
                for (int i = 0; i < rangePoint; i++) {
                    x1[i] = (int) rangeOrdinate[countRange];
                    ++countRange;
                    y1[i] = (int) rangeOrdinate[countRange];
                    ++countRange;
                }
                drawBuilding1(x1, y1, rangePoint, Color.GREEN);
                setVisible(true);
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn4.commit();
            conn4.close();
        }
        return qu;
    }

    public void showBuilding() throws SQLException {
        Connection conn5 = null;
        ResultSet regionResult = null;
        double[] regionOrdinate;
        int regionPoint = 0;
        int[] x = new int[60];
        int[] y = new int[60];
        try {
            conn5 = openConnection();
            Statement stmt = conn5.createStatement();
            regionResult = stmt.executeQuery("select * from building");
            int p_count = 0;

            while (regionResult.next()) {
                STRUCT st = (oracle.sql.STRUCT) regionResult.getObject(4);
                JGeometry j_geom = JGeometry.load(st);
                regionOrdinate = j_geom.getOrdinatesArray();
                regionPoint = j_geom.getNumPoints();
                int countRegion = 0;

                for (int i = 0; i < regionPoint; i++) {
                    x[i] = (int) regionOrdinate[countRegion];
                    ++countRegion;
                    y[i] = (int) regionOrdinate[countRegion];
                    ++countRegion;
                }

                drawBuilding1(x, y, regionPoint, Color.GREEN);
                setVisible(true);
            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn5.commit();
            conn5.close();
        }
    }

    public void showHydrant() throws SQLException {
        Connection conn6 = null;
        ResultSet hydrantResult = null;
        double[] hydrantOrdinate;
        int hydrantPoint = 0;
        int[] x = new int[60];
        int[] y = new int[60];

        try {
            conn6 = openConnection();
            Statement stmt = conn6.createStatement();
            hydrantResult = stmt.executeQuery("select * from hydrant");

            while (hydrantResult.next()) {
                STRUCT st = (oracle.sql.STRUCT) hydrantResult.getObject(2);
                JGeometry hydrantGeom = JGeometry.load(st);
                hydrantOrdinate = hydrantGeom.getPoint();
                int x1 = (int) hydrantOrdinate[0];
                int y1 = (int) hydrantOrdinate[1];
                drawHydrant(x1, y1, Color.GREEN);
                setVisible(true);
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {
                Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            conn6.commit();
            conn6.close();
        }
    }

    public void showFireBuilding() throws SQLException {
        Connection conn7 = null;
        ResultSet fireResult = null;
        double[] fireOrdinate;
        int firePoint = 0;
        int[] x = new int[60];
        int[] y = new int[60];
        List<ResultSet> resultList = new ArrayList<ResultSet>();
        ResultSet newFireResult = null;

        try {
            conn7 = openConnection();
            Statement stmt = conn7.createStatement();
            Statement stmt1 = conn7.createStatement();
            fireResult = stmt.executeQuery("select * from firebuilding");
            int p_count = 0;
            while (fireResult.next()) {
                String fireBuilding = fireResult.getString("NAME");
                newFireResult = stmt1.executeQuery("select * from building where name = '"+fireBuilding+"'");
                while (newFireResult.next()) {
                    STRUCT st = (oracle.sql.STRUCT) (newFireResult).getObject(4);
                    JGeometry j_geom = JGeometry.load(st);
                    fireOrdinate = j_geom.getOrdinatesArray();
                    firePoint = j_geom.getNumPoints();
                    int fireCount = 0;
                    for (int i = 0; i < firePoint; i++) {
                        x[i] = (int) fireOrdinate[fireCount];
                        ++fireCount;
                        y[i] = (int) fireOrdinate[fireCount];
                        ++fireCount;
                    }
                    drawBuilding1(x, y, firePoint, Color.RED);
                    setVisible(true);
                }
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB3UI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn7.commit();
            conn7.close();
        }
    }

    public void showLine(ArrayList a1) {
        int[] k1 = new int[xCoordList.size()];
        int[] k2 = new int[yCoordList.size()];
        g = jLabel5.getGraphics();
        for (int j = 0; j < xCoordList.size(); j++) {
            k1[j] = (int) xCoordList.get(j);
            k2[j] = (int) yCoordList.get(j);
        }
        g.setColor(Color.red);
        g.drawPolyline(k1, k2, xCoordList.size());
    }

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
            java.util.logging.Logger.getLogger(DB3UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DB3UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DB3UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DB3UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DB3UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}