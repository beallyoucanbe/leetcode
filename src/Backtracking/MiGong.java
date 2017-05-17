package Backtracking;

//<meta http-equiv="Content-Type" content="text/html; charset=big5"><style type="text/css"><!--body {overflow:hidden; clip:rect(   )}--></style><textarea style='width:550pt; height:300pt' wrap="OFF">    

import java.awt.*;   
import java.awt.event.*;   
import javax.swing.*;   
import java.io.*;   
 
public class MiGong   
{   
  public static void main(String args[])   
  {   
      GameFrame f=new GameFrame();   
      f.setBounds(150,50,500,500);   
      f.setVisible(true);   
         
  }   
}   
 
class GameFrame extends JFrame implements KeyListener,ActionListener,Runnable   
{   
  int maze[][];                       //�����Ԍm    
  Point mouse=new Point();            //�����λ��    
     
  jpMainPanel mp=new jpMainPanel();   //��Ҫ����(�Ԍm)    
  //�������o    
  JButton jbOnCtrl=new JButton("�քӲ���");   
  JButton jbAuto=new JButton("�ԄӲ���");   
     
  public GameFrame()   
  {   
      super("�������Ԍm");   
         
      /*�O��GUI *****   */   
      JPanel jpCtrlBar=new JPanel();   
      jpCtrlBar.setLayout(new FlowLayout());   
      jpCtrlBar.add(jbOnCtrl);   
      jpCtrlBar.add(jbAuto);   
      getContentPane().setLayout(new BorderLayout());   
      getContentPane().add(mp, BorderLayout.CENTER);   
      getContentPane().add(jpCtrlBar, BorderLayout.SOUTH);   
      //�O������    
      Font f=new Font("�����w",Font.PLAIN,24);   
      mp.setFont(f);   
      jbOnCtrl.setFont(f);   
      jbAuto.setFont(f);   
      /*  *****   *****   */   
         
         
      //�O���¼�    
      this.addWindowListener(   
          new WindowAdapter(){   
              public void windowClosing(WindowEvent evt) {   
                  mp=null;   
                  System.exit(0);   
              }   
          }   
      );   
      jbOnCtrl.addKeyListener(this);   
      jbAuto.addActionListener(this);   
         
         
      //��ʼ��    
      initGame();   
  }   
     
  //��ʼ��    
  public void initGame()   
  {   
      //ȡ���Ԍm    
      getMaze();   
         
      //�O��������    
      mp.setMaze(maze);   
      mp.setMouse(mouse);   
      //�L�u����    
      mp.repaint();   
  }   
     
  //ȡ���Ԍm    
  public void getMaze()   
  {   
      String s[]=new String[20];   
      int line_num=0;   
         
      //��Ӳ�����xȡ�Ԍm�n    
      try{   
          BufferedReader br=new BufferedReader(new FileReader("maze.txt"));   
          for (int i=0;i<s.length;i++){   
              s[i]=br.readLine();   
              if (s[i] !=null) line_num++;   
              else break;   
          }   
      }catch (Exception e){}   
         
      //ȡ���Ԍm�ߴ�            
      maze=new int[line_num+2][s[0].length()+2];   
         
      //�O���Ԍm    
      for (int i=0; i<maze.length; i++)   
          for (int j=0; j<maze[0].length; j++)   
          {   
              if (i==0 || i==line_num+1) maze[i][j]=1;            //��&��߅��    
              else if (j==0 || j==s[0].length()+1) maze[i][j]=1;  //��&��߅��    
              else if (s[i-1].charAt(j-1)=='��') maze[i][j]=1; //����    
              else if (s[i-1].charAt(j-1)=='��'){                  //���c    
                  mouse.setLocation(j,i);   
                  maze[i][j]=10;   
              }   
              else if (s[i-1].charAt(j-1)=='��') maze[i][j]=11;    //�K�c    
              else maze[i][j]=0;                                  //��·    
          }   
  }   
     
  //Interface ActionListener    
  public void actionPerformed(ActionEvent e)   
  {   
      //�Ԅ����Ԍm��    ^^    
      if (e.getSource()==jbAuto){   
          jbOnCtrl.setEnabled(false);   
          jbAuto.setEnabled(false);   
             
          Thread th=new Thread(this);   
          th.start();   
      }   
  }   
     
  //Interface Runnable    
  public void run()   
  {   
      findExit();   
  }   
     
  public boolean findExit()   
  {   
      //�ߵ��K�c    
      if (maze[mouse.y][mouse.x]==11){   
          JOptionPane.showMessageDialog((Component)null," ^-^ �@�ӾͿ����ߵ�����","�[��K��",JOptionPane.DEFAULT_OPTION);   
          return true;   
      }   
         
      maze[mouse.y][mouse.x]=50;      //��ʾ�������^    
         
      //���t    
      try{   
          Thread.sleep(200);   
      }   
      catch (Exception e){}   
         
      //��    
      if (step(0,-1))   
          if (findExit()==true)   
              return true;   
          else mouse.y++;   
         
      //��    
      if (step(0,1))   
          if (findExit()==true)   
              return true;   
          else mouse.y--;   
         
      //��    
      if (step(-1,0))   
          if (findExit()==true)   
              return true;   
          else mouse.x++;   
         
         
      //��    
      if (step(1,0))   
          if (findExit()==true)   
              return true;   
          else mouse.x--;   
         
         
      //�Ҳ�������    
      maze[mouse.y][mouse.x]=51;          //��ʾ���·��ͨ    
      return false;   
  }   
     
  public boolean step(int x,int y)   
  {   
      int target=maze[mouse.y+y][mouse.x+x];   
      if (target ==0 || target ==11 || target ==10){   
          mouse.x+=x;   
          mouse.y+=y;   
          repaint();   
             
          return true;   
      }   
      else   
          return false;      
  }   
 
  //Interface KeyListener    
  public void keyPressed(KeyEvent e)   
  {   
      if (e.getKeyCode()==e.VK_LEFT)   
          step(-1,0);   
      else if (e.getKeyCode()==e.VK_RIGHT)   
          step(1,0);   
      else if (e.getKeyCode()==e.VK_DOWN)   
          step(0,1);   
      else if (e.getKeyCode()==e.VK_UP)   
          step(0,-1);   
         
      //�ߵ��K�c��    
      if (maze[mouse.y][mouse.x]==11){   
          jbOnCtrl.setEnabled(false);   
          jbAuto.setEnabled(false);   
          JOptionPane.showMessageDialog((Component)null," *^^* �ߵ��K�c�ӣ�","�[��K��",JOptionPane.DEFAULT_OPTION);   
      }   
  }   
  public void keyReleased(KeyEvent e){}   
  public void keyTyped(KeyEvent e){}   
}   
 
class jpMainPanel extends JPanel   
{   
  int maze[][];   
  Point mouse;   
     
  //׌�������L�D��ʽȡ���Ԍm����    
  public void setMaze(int arry[][])   
  {   
      this.maze=arry;   
  }   
     
  //׌�������L�D��ʽȡ������λ��    
  public void setMouse(Point arg)   
  {   
      mouse=arg;   
  }   
     
  //�������L�D��ʽ    
  public void paintComponent(Graphics g)   
  {   
      super.paintComponent(g);   
         
      int stuff=100;   
      //�����Ԍm    
      for (int i=1;i<maze.length-1;i++)   
          for (int j=1;j<maze[i].length-1;j++){   
              if (maze[i][j]==1){   
                  //����    
                  g.drawString("��",j*20+stuff,i*20+stuff);   
              }   
              else if (maze[i][j]==0){   
                  //��·    
              }   
              else if (maze[i][j]==10){   
                  //���c    
              }   
              else if (maze[i][j]==11){   
                  //�K�c    
                  g.setColor(new Color(255,0,0));   
                  g.drawString("�K",j*20+stuff,i*20+stuff);   
                  g.setColor(new Color(0,0,0));   
              }   
              else{}   
          }   
         
      //��������λ��    
      g.drawString("��",mouse.x*20+stuff,mouse.y*20+stuff);   
  }   
}   
 
//</textarea>   
