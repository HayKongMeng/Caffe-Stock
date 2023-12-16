
package Main;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
        
public class ConnectDB extends JFrame{

    public DefaultTableModel getModeledit() {
        return modeledit;
    }

    public DefaultTableModel getModel() {
        return model;
    }

   
    public double getTotal() {
        return total;
    }

    public boolean isB() {
        return b;
    }
    private PreparedStatement ps;
    private ResultSet r;
    private boolean b=false;
    private String col[] = {"Code","Name","Price","Qty","Amount"};
    private DefaultTableModel model = new DefaultTableModel(col, 0);
    private String colEdit[] = {"Code","Name","Price","Image"};
    private DefaultTableModel modeledit = new DefaultTableModel(colEdit, 0);
    private double total=0;
    
    public Connection connection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/caffe_app","root","");
            System.out.println("Complete...");
            
        } catch (Exception e) {
            System.out.println("Connection Error: "+e.getMessage());
        }
        return con;
    }
    //signin
    public void SignIn(){
        try {
            ps=connection().prepareStatement("SELECT * FROM signin");
            r=ps.executeQuery();
            while(r.next()){
                List_Account.listAccount.add(new List_Account(
                        r.getString("Username"),
                        r.getString("Password")
                ));
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        
    }
    //register
    public void Register(String username,String password, String confirm){
        SignIn();
//        String username = txtusername.getText();
//        String password = String.valueOf(txtpassword.getPassword());
//        String confirm_password = String.valueOf(txtconfirm.getPassword());
        if(username.equals("") || password.equals("") || confirm.equals("")){
            JOptionPane.showMessageDialog(null, "Please enter your account", "REGISTER", JOptionPane.ERROR_MESSAGE);
        }else{
            boolean isCheck = false;
            for(int i=0;i<List_Account.listAccount.size();i++){
                if(username.equals(List_Account.listAccount.get(i).getUsername()) && password.equals(List_Account.listAccount.get(i).getPassword())){
                    JOptionPane.showMessageDialog(null, "Error ...! Duplicate Username and Password", "REGISTER", JOptionPane.ERROR_MESSAGE);
                    isCheck = true;
                }
            }
            if(isCheck==false){
                if(password.equals(confirm)){
                    try {
                        ps=connection().prepareStatement("INSERT INTO signin(Username,Password) VALUES(?,?)");
                        ps.setString(1, username);
                        ps.setString(2, confirm);
                        int index = ps.executeUpdate();
                        if(index>0){
                            JOptionPane.showMessageDialog(null, "Account Created", "REGISTER", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    } catch (Exception e) {
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error...! Confirm password is not correct...", "REGISTER", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //fetch check user
    public void checkUser(String username, String password){
        SignIn();
        //String password = txtpassword.getText();
        boolean Isusername = false;
        boolean Ispassword = false;
        for(int i=0;i<List_Account.listAccount.size();i++){
            if(username.equals(List_Account.listAccount.get(i).getUsername())){
                Isusername=true;
            }
            if(password.equals(List_Account.listAccount.get(i).getPassword())){
                Ispassword=true;
            }
            
        }
        if(Isusername==true && Ispassword==true){
            JOptionPane.showMessageDialog(null, "Welcome to user login.");
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
            b=true;
        }
        if(Isusername==false && Ispassword==true){
//            txtUser.setBackground(new Color(255,69,0));
            JOptionPane.showMessageDialog(null, "Incorrect username...!", "SIGN IN", JOptionPane.ERROR_MESSAGE);            
        }
        if(Ispassword==false && Isusername==true){
//            txtPass.setBackground(new Color(255,69,0));
            JOptionPane.showMessageDialog(null, "Incorrect password...!", "SIGN IN", JOptionPane.ERROR_MESSAGE);
        }
        if(Isusername==false && Ispassword==false){
//            txtUser.setBackground(new Color(255,69,0));
//            txtPass.setBackground(new Color(255,69,0));
            JOptionPane.showMessageDialog(null, "Incorrect username and password...!", "SIGN IN", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Method FetchData
    public void FecthDrink(){
        try {
            ps=connection().prepareStatement("SELECT * FROM drink_stock");
            r=ps.executeQuery();
            while(r.next()){
               
                Object row[]={
               
                    r.getInt("Code"),
                    r.getString("Name"),
                    r.getDouble("Price")+"$",
                    r.getString("Image")
                };
                modeledit.addRow(row);
                ListDrink_Stock.listDrink.add(new ListDrink_Stock(
                        r.getInt("Code"),
                        r.getString("Name"),
                        r.getFloat("Price"),
                        r.getString("Image")
                ));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //--------------
    public void AddDrinkStock(int code, String name, double price, String image){
        try {
            ps=connection().prepareStatement("INSERT INTO drink_stock(Code,Name,Price,Image) VALUES(?,?,?,?)");
            ps.setInt(1, code);
            ps.setString(2, name);
            ps.setDouble(3, price);
            ps.setString(4, image);
            
            int index=ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Success");
            }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    //delete fetchDrink
    public void DeleteFetchData(int code){
        try {
            
          
            ps=connection().prepareStatement("DELETE FROM drink_stock WHERE Code=?");
            ps.setInt(1, code);
            int index = ps.executeUpdate();
            if(index>0){
                JOptionPane.showMessageDialog(null, "Success");
            }
        } catch (Exception e) {
        }
    }
    //DrinkOrder
    public void OrderDrinkStock(int code, String name, double price ,String image,int qty,double amount){
        if(qty==1){
            try {
                ps=connection().prepareStatement("INSERT INTO orderdrinkstock(Code,Name,Price,Image,Qty,Amount) VALUES(?,?,?,?,?,?)");
                ps.setInt(1, code);
                ps.setString(2, name);
                ps.setDouble(3, price);
                ps.setString(4, image);
                ps.setInt(5, qty);
                ps.setDouble(6, amount);
                int index=ps.executeUpdate();
                if(index>0){
                    JOptionPane.showMessageDialog(null, "Add");
                }else{
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }else if(qty==0){
            try {
                ps=connection().prepareStatement("DELETE FROM orderdrinkstock WHERE Code=?");
                ps.setInt(1, code);
                int index=ps.executeUpdate();
                if(index>0){
                    JOptionPane.showMessageDialog(null, "Success");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else{
            try {
                //update
                ps=connection().prepareStatement("UPDATE orderdrinkstock SET Qty=?,Amount=? WHERE Code=?");
                ps.setInt(1, qty);
                ps.setDouble(2, amount);
                ps.setInt(3, code);
                int index=ps.executeUpdate();
                if(index>0){
                    JOptionPane.showMessageDialog(null, "Success");
                }
            } catch (Exception e) {
            }
        }
    }
    
    //fecthOrder
    public void FecthOrder(){
        try {
            ps=connection().prepareStatement("SELECT * FROM orderdrinkstock");
            r=ps.executeQuery();
            while(r.next()){
                ListDrink_Order.listOrder.add(new ListDrink_Order(
                        r.getInt("Code"),
                        r.getString("Name"),
                        r.getDouble("Price"),
                        r.getString("Image"),
                        r.getInt("Qty"),
                        r.getDouble("Amount")
                ));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //
    public void getDrinkOrder(){
        try {
            ps=connection().prepareStatement("SELECT * FROM orderdrinkstock");
            r=ps.executeQuery();
            while(r.next()){
                Object row[]={
               
                    r.getInt("Code"),
                    r.getString("Name"),
                    r.getDouble("Price")+"$",
                    r.getInt("Qty"),
                    r.getDouble("Amount")+"$",
                };
                model.addRow(row);
                total+=r.getDouble("Amount");
                //add to list
                ListDrink_Order.listOrder.add(new ListDrink_Order(
                        r.getInt("Code"),
                        r.getString("Name"),
                        r.getDouble("Price"),
                        r.getString("Image"),
                        r.getInt("Qty"),
                        r.getDouble("Amount")
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }
    //delete Data
    public void DeleteDataOrder(){
        try {
            
            ps=connection().prepareStatement("DELETE FROM orderdrinkstock");
                
                int index=ps.executeUpdate();
                if(index>0){
                    JOptionPane.showMessageDialog(null, "Success");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //updateData
    public void UpdateData(int code, String name, double price, String image){
        try {
            ps=connection().prepareStatement("UPDATE drink_stock SET Name=?,Price=?,Image=? WHERE Code=?");
           
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, image);
            ps.setInt(4, code);
            int index=ps.executeUpdate();
                if(index>0){
                    JOptionPane.showMessageDialog(null, "Success");
                }
//            ps=connection().prepareStatement("UPDATE drink_stock SET Name=?,Price=?,Image=? WHERE Code=?");
//            ps.setString(1, name);
//            ps.setDouble(2, price);
//            ps.setString(3, image);
//            ps.setInt(4, code);
//            int index = ps.executeUpdate();
//            if(index>0){
//                    JOptionPane.showMessageDialog(null, "Success");
//                    
//            }
        } catch (Exception e) {
        }
    }
}
