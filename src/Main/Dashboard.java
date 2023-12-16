
package Main;


import Swing.EventMenu;
import Swing.MainForm;
import Swing.MenuItem;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.mysql.fabric.xmlrpc.base.Data;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class Dashboard extends javax.swing.JFrame {
    private ConnectDB db = new ConnectDB();
    ProductModel1 pro1 = new ProductModel1();
    
    private double total=0,discount,payment,disprice,cash_recieve,cashReturn_dollar,cashReturn_reil;
    private int index ;
    DecimalFormat df = new DecimalFormat("###0.00");
    DecimalFormat df1 = new DecimalFormat("###0.000");
    
    int op;
    public Dashboard() {
        initComponents();
       db.getDrinkOrder();        
        
        tbtable.setModel(db.getModel());

        tbtableedit.setModel(db.getModeledit());
        total=db.getTotal();
        txttotal.setText(String.valueOf(total));
        int x=0,y=0;
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 4, 10, 4);
        
            
        
        db.FecthDrink();
        for(int i=0;i<ListDrink_Stock.listDrink.size();i++){
            ProductModel1 pro1 = new ProductModel1();            
            pro1.setCode(ListDrink_Stock.listDrink.get(i).getCode());
            pro1.setName(ListDrink_Stock.listDrink.get(i).getName());
            pro1.setPrice(ListDrink_Stock.listDrink.get(i).getPrice());
            pro1.setImage(ListDrink_Stock.listDrink.get(i).getImage());
            gbc.gridx=x;
            gbc.gridy=y;
            x++;
            drinkPanel.add(pro1,gbc);
            if(x==4){
                y++;
                x=0;
            }
            ListDrink_Order.listOrder.clear();
        }
        
        db.FecthOrder();
        for(int i=0;i<ListDrink_Order.listOrder.size();i++){
            ProductModel1 pro1 = new ProductModel1();
            
            pro1.setCode(ListDrink_Order.listOrder.get(i).getCode());
            pro1.setName(ListDrink_Order.listOrder.get(i).getName());
            pro1.setPrice(ListDrink_Order.listOrder.get(i).getPrice());
            pro1.setImage(ListDrink_Order.listOrder.get(i).getImage());
            gbc.gridx=x;
            gbc.gridy=y;
            x++;
            cartPanel.add(pro1,gbc);
            if(x==4){
                y++;
                x=0;
            }
            
        }
        
//        menu1.addEventMenuSelected(new EventMenu() {
//            @Override
//            public void mainMenuSelected(MainForm mainForm, int index, MenuItem menuItem) {                
//            }
//
//            @Override
//            public void subMenuSelected(MainForm mainForm, int index, int subMenuIndex, Component menuItem) {
//                
////                 for(int i=0;i<10;i++){
////                    ProductModel1 pro1 = new ProductModel1();
////                  mainForm1.displayForm(drink);
////                  drinkPanel.add(pro1);
////                }
//            }
//        });
        menu1.setSelectedIndex(0);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu1 = new Swing.Menu();
        jLabel1 = new javax.swing.JLabel();
        menuItem1 = new Swing.MenuItem();
        menuItem2 = new Swing.MenuItem();
        menuItem3 = new Swing.MenuItem();
        jLabel3 = new javax.swing.JLabel();
        subMenuPanel1 = new Swing.SubMenuPanel();
        mainForm1 = new Swing.MainForm();
        drink = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        drinkPanel = new javax.swing.JPanel();
        cart = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartPanel = new javax.swing.JPanel();
        paymentP = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        txtcashreil = new Swing.TextField();
        cbpaymentmethod = new javax.swing.JComboBox<>();
        cbdiscount = new javax.swing.JComboBox<>();
        txtdisprice = new Swing.TextField();
        txtcashrecieve = new Swing.TextField();
        jLabel6 = new javax.swing.JLabel();
        txtcashdollar = new Swing.TextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbtable = new javax.swing.JTable();
        txttotal = new Swing.TextField();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton4 = new com.k33ptoo.components.KButton();
        kButton5 = new com.k33ptoo.components.KButton();
        addDrink = new javax.swing.JPanel();
        addDrinkPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new Swing.TextField();
        txtprice = new Swing.TextField();
        btnimage = new Swing.Button();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnadd = new javax.swing.JLabel();
        txtcode = new Swing.TextField();
        txtimage = new javax.swing.JTextField();
        lbimage = new javax.swing.JLabel();
        editDrink = new javax.swing.JPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        txteditname = new Swing.TextField();
        txteditcode = new Swing.TextField();
        txteditprice = new Swing.TextField();
        btnimage1 = new Swing.Button();
        txteditimage = new javax.swing.JTextField();
        lbediticon = new javax.swing.JLabel();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbtableedit = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu1.setSubMenuPanel(subMenuPanel1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/Design/icons8-m-cute-48.png"))); // NOI18N
        menu1.add(jLabel1);

        menuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/Design/icons8-package-48.png"))); // NOI18N
        menuItem1.setText("menuItem1");
        menuItem1.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "Main/Design/icons8-wine-bar-60.png" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem1.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Drink" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem1ActionPerformed(evt);
            }
        });
        menu1.add(menuItem1);

        menuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/Design/icons8-cash-16.png"))); // NOI18N
        menuItem2.setText("menuItem2");
        menuItem2.setMaximumSize(new java.awt.Dimension(54, 55));
        menuItem2.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "Main/Design/icons8-cash-16.png", "Main/Design/icons8-card-payment-24.png" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem2.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Cart", "Payment" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem2.setPreferredSize(new java.awt.Dimension(54, 55));
        menuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem2ActionPerformed(evt);
            }
        });
        menu1.add(menuItem2);

        menuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/Design/icons8-add-new-50.png"))); // NOI18N
        menuItem3.setText("menuItem3");
        menuItem3.setMaximumSize(new java.awt.Dimension(54, 55));
        menuItem3.setMenuIcon(new javax.swing.AbstractListModel() {
            String[] strings = { "Main/Design/icons8-add-new-24.png" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem3.setMenuModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Add Drink", "Edit Drink" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        menuItem3.setPreferredSize(new java.awt.Dimension(54, 55));
        menuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem3ActionPerformed(evt);
            }
        });
        menu1.add(menuItem3);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Refresh");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        menu1.add(jLabel3);

        subMenuPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(80, 1, 1, 1));

        mainForm1.setLayout(new java.awt.CardLayout());

        drinkPanel.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(drinkPanel);

        javax.swing.GroupLayout drinkLayout = new javax.swing.GroupLayout(drink);
        drink.setLayout(drinkLayout);
        drinkLayout.setHorizontalGroup(
            drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        drinkLayout.setVerticalGroup(
            drinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        mainForm1.add(drink, "card5");

        cartPanel.setLayout(new java.awt.GridBagLayout());
        jScrollPane2.setViewportView(cartPanel);

        javax.swing.GroupLayout cartLayout = new javax.swing.GroupLayout(cart);
        cart.setLayout(cartLayout);
        cartLayout.setHorizontalGroup(
            cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        cartLayout.setVerticalGroup(
            cartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );

        mainForm1.add(cart, "card4");

        kGradientPanel1.setkEndColor(new java.awt.Color(204, 255, 204));
        kGradientPanel1.setLayout(null);

        txtcashreil.setEditable(false);
        txtcashreil.setLabelText("Cash Return R");
        kGradientPanel1.add(txtcashreil);
        txtcashreil.setBounds(20, 530, 180, 70);

        cbpaymentmethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Payment Method", "Dollar", "Riel" }));
        cbpaymentmethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpaymentmethodActionPerformed(evt);
            }
        });
        kGradientPanel1.add(cbpaymentmethod);
        cbpaymentmethod.setBounds(20, 350, 180, 60);

        cbdiscount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Discount", "10%", "20%", "30%", "40%", "50%", " " }));
        cbdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdiscountActionPerformed(evt);
            }
        });
        kGradientPanel1.add(cbdiscount);
        cbdiscount.setBounds(20, 110, 180, 60);

        txtdisprice.setLabelText("Disprice");
        txtdisprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdispriceActionPerformed(evt);
            }
        });
        kGradientPanel1.add(txtdisprice);
        txtdisprice.setBounds(20, 180, 180, 70);

        txtcashrecieve.setLabelText("Cash Recieve");
        kGradientPanel1.add(txtcashrecieve);
        txtcashrecieve.setBounds(20, 260, 180, 70);

        jLabel6.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel6.setText("Payment");
        kGradientPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 41, 13);

        txtcashdollar.setEditable(false);
        txtcashdollar.setLabelText("Cash Return $");
        txtcashdollar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcashdollarActionPerformed(evt);
            }
        });
        kGradientPanel1.add(txtcashdollar);
        txtcashdollar.setBounds(20, 440, 180, 70);

        tbtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Price", "Qty", "Amount"
            }
        ));
        jScrollPane3.setViewportView(tbtable);
        if (tbtable.getColumnModel().getColumnCount() > 0) {
            tbtable.getColumnModel().getColumn(4).setHeaderValue("Amount");
        }

        kGradientPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(290, 20, 630, 510);

        txttotal.setLabelText("Total");
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });
        kGradientPanel1.add(txttotal);
        txttotal.setBounds(20, 20, 180, 70);

        kButton1.setText("Print");
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton1);
        kButton1.setBounds(805, 560, 120, 45);

        kButton4.setText("Print");
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton4);
        kButton4.setBounds(805, 560, 120, 45);

        kButton5.setText("Cancel");
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton5);
        kButton5.setBounds(320, 560, 110, 45);

        javax.swing.GroupLayout paymentPLayout = new javax.swing.GroupLayout(paymentP);
        paymentP.setLayout(paymentPLayout);
        paymentPLayout.setHorizontalGroup(
            paymentPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paymentPLayout.setVerticalGroup(
            paymentPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainForm1.add(paymentP, "card3");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("MS PGothic", 0, 12)); // NOI18N
        jLabel2.setText("Add Drink");

        txtname.setLabelText("Name");
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        txtprice.setLabelText("Price");
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });

        btnimage.setBackground(new java.awt.Color(0, 0, 0));
        btnimage.setForeground(new java.awt.Color(255, 255, 255));
        btnimage.setText("Image");
        btnimage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimageActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/Design/giphy.gif"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 0, 0, new java.awt.Color(0, 0, 0)));

        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/Design/icons8-enter-96.png"))); // NOI18N
        btnadd.setText("jLabel6");
        btnadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnaddMouseClicked(evt);
            }
        });

        txtcode.setLabelText("Code");
        txtcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeActionPerformed(evt);
            }
        });

        txtimage.setBackground(new java.awt.Color(255, 255, 255));

        lbimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(315, 315, 315))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addComponent(jLabel5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(btnimage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtimage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 216, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnimage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtimage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel4))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout addDrinkPanelLayout = new javax.swing.GroupLayout(addDrinkPanel);
        addDrinkPanel.setLayout(addDrinkPanelLayout);
        addDrinkPanelLayout.setHorizontalGroup(
            addDrinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addDrinkPanelLayout.setVerticalGroup(
            addDrinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout addDrinkLayout = new javax.swing.GroupLayout(addDrink);
        addDrink.setLayout(addDrinkLayout);
        addDrinkLayout.setHorizontalGroup(
            addDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addDrinkPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        addDrinkLayout.setVerticalGroup(
            addDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addDrinkPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainForm1.add(addDrink, "card2");

        kGradientPanel2.setkEndColor(new java.awt.Color(204, 255, 204));
        kGradientPanel2.setkGradientFocus(250);
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 204, 204));

        txteditname.setLabelText("Name");
        txteditname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteditnameActionPerformed(evt);
            }
        });

        txteditcode.setLabelText("Code");
        txteditcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteditcodeActionPerformed(evt);
            }
        });

        txteditprice.setLabelText("Price");
        txteditprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txteditpriceActionPerformed(evt);
            }
        });

        btnimage1.setBackground(new java.awt.Color(0, 0, 0));
        btnimage1.setForeground(new java.awt.Color(255, 255, 255));
        btnimage1.setText("Image");
        btnimage1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnimage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimage1ActionPerformed(evt);
            }
        });

        txteditimage.setBackground(new java.awt.Color(255, 255, 255));

        lbediticon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        kButton2.setText("UPDATE");
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setText("DELETE");
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        tbtableedit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Price", "Image"
            }
        ));
        tbtableedit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtableeditMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbtableedit);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnimage1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txteditimage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbediticon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txteditcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txteditprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txteditname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(80, 80, 80)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(lbediticon, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnimage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txteditimage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(txteditcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txteditname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txteditprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout editDrinkLayout = new javax.swing.GroupLayout(editDrink);
        editDrink.setLayout(editDrinkLayout);
        editDrinkLayout.setHorizontalGroup(
            editDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editDrinkLayout.setVerticalGroup(
            editDrinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainForm1.add(editDrink, "card6");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Option");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subMenuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainForm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subMenuPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainForm1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void menuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem1ActionPerformed
        
          menu1.addEventMenuSelected(new EventMenu() {
            @Override
            public void mainMenuSelected(MainForm mainForm, int index, MenuItem menuItem) {                
            }

            @Override
            public void subMenuSelected(MainForm mainForm, int index, int subMenuIndex, Component menuItem) {
//                for(int i=0;i<10;i++){
//                    ProductModel1 pro1 = new ProductModel1();
                  mainForm1.displayForm(drink);
                  
                  
//                  drinkPanel.add(pro1);
//                }
            }
        });          
    }//GEN-LAST:event_menuItem1ActionPerformed

    private void menuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem3ActionPerformed
        menu1.addEventMenuSelected(new EventMenu() {
            @Override
            public void mainMenuSelected(MainForm mainForm, int index, MenuItem menuItem) {                
            }

            @Override
            public void subMenuSelected(MainForm mainForm, int index, int subMenuIndex, Component menuItem) {
              
                switch(subMenuIndex){
                    case 0:{
                          mainForm1.displayForm(addDrinkPanel);
                        
                    }break;
                    case 1:{
                        mainForm1.displayForm(editDrink);
                       
                    }break;
                }
            }
        });
        
    }//GEN-LAST:event_menuItem3ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeActionPerformed

    private void btnaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnaddMouseClicked
        db.AddDrinkStock(
                Integer.parseInt(txtcode.getText()),
                txtname.getText(),
                Float.parseFloat(txtprice.getText()),
                txtimage.getText()
                
        );
        db.getModeledit().setRowCount(0);
        db.FecthDrink();
    }//GEN-LAST:event_btnaddMouseClicked

    private ImageIcon resizeImage (String imagePath, byte[] pic){
        ImageIcon myImage;
        if(imagePath!=null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img1 = img.getScaledInstance(lbimage.getWidth(), lbimage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img1);
        return image;
    }
    private void btnimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        txtimage.setText(filename);
        Image getAbsolutePath=null;
        
        lbimage.setIcon(resizeImage(filename, null));
    }//GEN-LAST:event_btnimageActionPerformed

    private void menuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem2ActionPerformed
        menu1.addEventMenuSelected(new EventMenu() {
            @Override
            public void mainMenuSelected(MainForm mainForm, int index, MenuItem menuItem) {      
                
            }

            @Override
            public void subMenuSelected(MainForm mainForm, int index, int subMenuIndex, Component menuItem) {
                switch(subMenuIndex){
                    case 0:{
                        mainForm1.displayForm(cart);
                        
                    }break;
                    case 1:{
                        mainForm1.displayForm(paymentP);
                       
                    }break;
                }
                
                
            }
        });
    }//GEN-LAST:event_menuItem2ActionPerformed

    private void txtdispriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdispriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdispriceActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        
    }//GEN-LAST:event_txttotalActionPerformed

    private void cbdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdiscountActionPerformed
       String sdiscount = cbdiscount.getSelectedItem().toString();
       sdiscount=sdiscount.replace("%","");
       discount=Double.parseDouble(sdiscount);
       disprice=total*discount/100;
       payment=total-disprice;
       txtdisprice.setText(String.valueOf(payment));
       
    }//GEN-LAST:event_cbdiscountActionPerformed

    private void paymentDollar(){
        String cashReceive = txtcashrecieve.getText();
        cashReceive=cashReceive.replace("$", "");
        cash_recieve = Double.parseDouble(cashReceive);
         cashReturn_dollar = cash_recieve-payment;
         cashReturn_reil = cashReturn_dollar*4000;
        txtcashdollar.setText(df.format(cashReturn_dollar));
        txtcashreil.setText(df1.format(cashReturn_reil));   
    }
    private void paymentreil(){
        String cashReceive = txtcashrecieve.getText();
        cashReceive=cashReceive.replace("R", "");
//        total=total*4000;
        cashReturn_dollar = Double.parseDouble(cashReceive)-payment;
        cashReturn_reil = cashReturn_dollar*4000;
        txtcashdollar.setText(df.format(cashReturn_dollar));
        txtcashreil.setText(df1.format(cashReturn_reil));           
    }
    private void cbpaymentmethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpaymentmethodActionPerformed
        index =  cbpaymentmethod.getSelectedIndex();
        switch(index){
            case 1:{
                paymentDollar();
            }case 2:{ 
                paymentreil();
            }
        }
    }//GEN-LAST:event_cbpaymentmethodActionPerformed

    private Collection data(){
       ArrayList<ListDrink_Order> listpayment = new ArrayList<>();
        //db.FecthOrder();
        
        for(ListDrink_Order temp: ListDrink_Order.listOrder){
            int code = temp.getCode();
            String name = temp.getName();
            double price = temp.getPrice();
            int qty = temp.getQty();
            double amount = temp.getAmount();
           listpayment.add(new ListDrink_Order(code, name, price, name, qty, amount));
           
        }
     //  ListDrink_Order.listOrder.clear();
        return listpayment;
    }
    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        try {
            
            JasperReport jp = JasperCompileManager.compileReport("Report/Storemanagement.jrxml");
            HashMap pr = new HashMap();
            pr.put("total", total);
            pr.put("discount", discount/100);
            pr.put("disprice", disprice);
        pr.put("cashRecieve", txtcashrecieve.getText());
         pr.put("cashReturn_dollar", txtcashdollar.getText());
            pr.put("cashReturn_reil", txtcashreil.getText());
          
//            if(index==1){
//                pr.put("cash_recieve", txtcashrecieve+"R");
//            }else{
//                pr.put("cash_recieve", txtcashrecieve+"$");
//            }
            
            
            JRBeanCollectionDataSource jcd = new JRBeanCollectionDataSource(data());
            JasperPrint price = JasperFillManager.fillReport(jp, pr,jcd);
           JasperViewer.viewReport(price,false);
           db.DeleteDataOrder();
           
            //JasperPrintManager.printReport(price, true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
       
    }//GEN-LAST:event_kButton1ActionPerformed

    private void txtcashdollarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcashdollarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcashdollarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dispose();
       ListDrink_Stock.listDrink.clear();
       Dashboard.main(null);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void txteditnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteditnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteditnameActionPerformed

    private void txteditcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteditcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteditcodeActionPerformed

    private void txteditpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txteditpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txteditpriceActionPerformed

    private void btnimage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimage1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnimage1ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
        db.DeleteDataOrder();
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        int code = Integer.parseInt(txteditcode.getText());
        db.DeleteFetchData(code);
        db.getModeledit().setRowCount(0);
        db.FecthDrink();
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        int code= Integer.parseInt(txteditcode.getText());
        String name = txteditname.getText();
        double price = Double.parseDouble(txteditprice.getText());
        String image = txteditimage.getText();
        db.UpdateData(
                Integer.parseInt(txteditcode.getText()),
                txteditname.getText(),
                Double.parseDouble(txteditprice.getText()),
                txteditimage.getText()
        );
        db.getModeledit().setRowCount(0);
        db.FecthDrink();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void tbtableeditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtableeditMouseClicked
        int row = tbtableedit.getSelectedRow();
        txteditcode.setText(db.getModeledit().getValueAt(row, 0).toString());
        txteditname.setText(db.getModeledit().getValueAt(row, 1).toString());
        String price = db.getModeledit().getValueAt(row, 2).toString();
        price=price.replace("$", "");
        txteditprice.setText(price);
        txteditimage.setText(db.getModeledit().getValueAt(row, 3).toString());
        lbediticon.setIcon(resizeImage(db.getModeledit().getValueAt(row, 3).toString(), null));
    }//GEN-LAST:event_tbtableeditMouseClicked

    public static void main(String args[]) {
        FlatIntelliJLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addDrink;
    private javax.swing.JPanel addDrinkPanel;
    private javax.swing.JLabel btnadd;
    private Swing.Button btnimage;
    private Swing.Button btnimage1;
    private javax.swing.JPanel cart;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JComboBox<String> cbdiscount;
    private javax.swing.JComboBox<String> cbpaymentmethod;
    private javax.swing.JPanel drink;
    private javax.swing.JPanel drinkPanel;
    private javax.swing.JPanel editDrink;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KButton kButton5;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lbediticon;
    private javax.swing.JLabel lbimage;
    private Swing.MainForm mainForm1;
    private Swing.Menu menu1;
    private Swing.MenuItem menuItem1;
    private Swing.MenuItem menuItem2;
    private Swing.MenuItem menuItem3;
    private javax.swing.JPanel paymentP;
    private Swing.SubMenuPanel subMenuPanel1;
    private javax.swing.JTable tbtable;
    private javax.swing.JTable tbtableedit;
    private Swing.TextField txtcashdollar;
    private Swing.TextField txtcashrecieve;
    private Swing.TextField txtcashreil;
    private Swing.TextField txtcode;
    private Swing.TextField txtdisprice;
    private Swing.TextField txteditcode;
    private javax.swing.JTextField txteditimage;
    private Swing.TextField txteditname;
    private Swing.TextField txteditprice;
    private javax.swing.JTextField txtimage;
    private Swing.TextField txtname;
    private Swing.TextField txtprice;
    private Swing.TextField txttotal;
    // End of variables declaration//GEN-END:variables
}
