import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.*;
import java.io.*;


public class Server  implements ActionListener{
    JTextField text;
    JPanel p2;
    static DataOutputStream dout;
    static Box vertical = Box.createVerticalBox();
    
    static JFrame f = new JFrame();
    
    Server(){
        
       
       Container c = f.getContentPane();
       c.setLayout(null);
       c.setBackground(Color.WHITE);
       
       JPanel p1 = new JPanel();
       p1.setLayout(null);
       p1.setBackground(new Color(18,140,126));
       p1.setBounds(0,0,450,70);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
       Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel backbtn = new JLabel(i3);
       
       backbtn.setBounds(5,20,30,30);
       p1.add(backbtn);
       
       backbtn.addMouseListener(new MouseAdapter(){
    
        public void mouseClicked(MouseEvent me){
        
            System.exit(0);
            
        }
    
        });
       
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/vilas_profile.png"));
       Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel profile = new JLabel(i6);
       
       profile.setBounds(45,10,50,50);
       p1.add(profile);
       
       ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
       Image i8 = i7.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
       ImageIcon i9 = new ImageIcon(i8);
       JLabel video = new JLabel(i9);
       
       video.setBounds(300,20,35,30);
       p1.add(video);
       
       ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
       Image i11 = i10.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
       ImageIcon i12 = new ImageIcon(i11);
       JLabel phone = new JLabel(i12);
       
       phone.setBounds(360,20,30,30);
       p1.add(phone);
       
       
       ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
       Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
       ImageIcon i15 = new ImageIcon(i14);
       JLabel morevert = new JLabel(i15);
       
       morevert.setBounds(415,20,10,25);
       p1.add(morevert);
       
       
       JLabel name = new JLabel("Vilas Myakal");
       name.setBounds(110,15,100,18);
       name.setForeground(Color.WHITE);
       name.setFont(new Font("SAN_SARIF",Font.BOLD,17));
       
       p1.add(name);
       
       
       JLabel status = new JLabel("Online");
       status.setBounds(110,35,100,18);
       status.setForeground(Color.WHITE);
       status.setFont(new Font("SAN_SARIF",Font.BOLD,14));
       
       p1.add(status);
       
       
//  ------------------- Header Section Completed ----------------     
       
       
       p2 = new JPanel();
       p2.setLayout(null);
//       p2.setBackground(new Color(18,140,126));
       p2.setBounds(5,75,440,560);
       
       
       
       ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("icons/attachfile.png"));
       Image i17 = i16.getImage().getScaledInstance(30, 40, Image.SCALE_DEFAULT);
       ImageIcon i18 = new ImageIcon(i17);
       JButton attachfile = new JButton(i18);
       attachfile.setBackground(Color.WHITE);
       attachfile. setBorder(BorderFactory. createEmptyBorder());
       attachfile.setBounds(5,640,30,40);
       f.add(attachfile);
       
       
       
       text = new JTextField();
       text.setBounds(50,640,330,40);
       text.setFont(new Font("SAN_SARIF",Font.PLAIN,15));
       f.add(text);
       
       
       
       ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("icons/Send.png"));
       Image i20 = i19.getImage().getScaledInstance(40, 50, Image.SCALE_DEFAULT);
       ImageIcon i21 = new ImageIcon(i20);
       JButton sendIcon = new JButton(i21);
       
       sendIcon.setBackground(Color.WHITE);
       sendIcon.setBounds(390,635,40,50);
       sendIcon. setBorder(BorderFactory. createEmptyBorder());
       f.add(sendIcon);
       
       sendIcon.addActionListener(this);
       
       
       
       int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
       int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
       
       JScrollPane js = new JScrollPane(p2,v,h);
       js.setBounds(5,75,440,560);
       js.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
       
       f.add(js);
       f.add(p1);
       
        
    }

    public void actionPerformed(ActionEvent ae){
        try{
        p2.setLayout(new BorderLayout());
        
        String myMessage = text.getText();
        JPanel p3 = formatingMyMessage(myMessage);
       
        
        JPanel right = new JPanel(new BorderLayout());
        right.add(p3, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        
        p2.add(vertical,BorderLayout.PAGE_START);
        text.setText("");
       
        f.repaint();
        f.invalidate();
        f.validate();
         dout.writeUTF(myMessage);
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static JPanel formatingMyMessage(String out){
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout( panel , BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style='width: 150px'>"+ out +"</p></html>");
        
        output.setFont(new Font("Tahoma",Font.PLAIN, 16));
        output.setBackground(new Color(220,248,198));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        
        panel.add(output);  
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);

        return panel;
    }
    public static JPanel formatingMyLeftMessage(String out){
    
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout( panel , BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style='width: 150px'>"+ out +"</p></html>");
        
        output.setFont(new Font("Tahoma",Font.PLAIN, 16));
        output.setBackground(Color.WHITE);
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        
        panel.add(output);  
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        return panel;
    }
    
    public static void main(String args[]){
    
        new Server();
        f.setSize(450,700);
        f.setLocation(300,100);
        f.setUndecorated(true);
        f.setVisible(true);
        
        
        try{
            
            ServerSocket skt = new ServerSocket(3333);
            
            while(true){
            
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
            
                while(true){
                
                    String msg = din.readUTF();
                    JPanel panel = formatingMyLeftMessage(msg);
                
                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel,BorderLayout.LINE_START);
                    vertical.add(left);
                    
                    
                    
                    f.validate();
                    
                }
            
            
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    
    }


}