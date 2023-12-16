package Main;

import java.awt.Image;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ProductModel1 extends javax.swing.JPanel {

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
        
    }

    DecimalFormat df = new DecimalFormat("###0.00");
    
    public ProductModel1() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbprice = new javax.swing.JLabel();
        lbimage = new javax.swing.JLabel();

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/Design/icons8-card-payment-24.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("jLabel3");

        setBackground(new java.awt.Color(204, 255, 204));
        setForeground(new java.awt.Color(255, 204, 204));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        lbname.setForeground(new java.awt.Color(0, 0, 0));
        lbname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbname.setText("Name");

        lbprice.setForeground(new java.awt.Color(0, 0, 0));
        lbprice.setText("price:");

        lbimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbprice)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(lbname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbprice)
                .addGap(14, 14, 14)
                .addComponent(lbimage, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbname)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private ImageIcon resizeImage (String imagePath, byte[] pic){
        ImageIcon myImage;
        if(imagePath!=null){
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(pic);
        }
        Image img = myImage.getImage();
        Image img1 = img.getScaledInstance(147, 189, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img1);
        return image;
    }
    
//    public ProductModel1(int code,String name,float price,String image){
//        initComponents();
//        this.code=code;
//        this.name=name;
//        this.price=price;
//        this.image=image;
//        db.OrderDrinkStock(code, name, price, image, qty);
//    }
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        
     
    }//GEN-LAST:event_formMouseEntered

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
       
    }//GEN-LAST:event_formMouseReleased

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        
        
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Detail_Product detailProduct = new Detail_Product(code, name, price, image,qty);
        ListDrink_Order DrinkOrder = new ListDrink_Order(code, name, price, image, qty,amount);
        detailProduct.setVisible(true);
        
    }//GEN-LAST:event_formMouseClicked

    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        lbname.setText(name);
        
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        lbimage.setIcon(resizeImage(image, null));
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        lbprice.setText(df.format((price))+"$");
    }
   
    
    private int code,qty=0;
    private String name,image;
    private double price;
    private double amount;
    private ConnectDB db = new ConnectDB();
    static ArrayList<ProductModel1> listProduct = new ArrayList<>();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbimage;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbprice;
    // End of variables declaration//GEN-END:variables
}
