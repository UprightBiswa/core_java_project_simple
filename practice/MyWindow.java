package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyWindow extends JFrame
{
    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("",Font.BOLD,35);

    MyWindow(){
        super.setTitle("My Clock");
        super.setSize(400,400);
        super.setLocation(300,100);
        super.setVisible(true);
    }
    public void createGUI(){
        heading=new JLabel("Clock");
        clockLabel=new JLabel("time");

        heading.setFont(font);
        clockLabel.setFont(font);

        this.setLayout(new GridLayout(2,1));
        this.add(heading);
        this.add(clockLabel);
    }
    public void startClock(){
//       Timer timer=new Timer(1000, new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
//             //  String dateTime=new Date().toString();
////               Date date = new Date();
////               SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
////               String dateTime=sdf.format(date);
////               clockLabel.setText(dateTime);
//
//           }
//       });
//       timer.start();

       Thread thread = new Thread(){
           public void run(){
               try{
                   while (true){
                       Date date = new Date();
                       SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                       String dateTime=sdf.format(date);
                       clockLabel.setText(dateTime);
//                       Thread.sleep(1000);
                       Thread.currentThread().sleep(1000);
                   }
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
           }
       };
       thread.start();
    }
}
