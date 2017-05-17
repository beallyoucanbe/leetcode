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
  int maze[][];                       //儲存迷宮    
  Point mouse=new Point();            //老鼠的位置    
     
  jpMainPanel mp=new jpMainPanel();   //主要畫面(迷宮)    
  //操作按鈕    
  JButton jbOnCtrl=new JButton("手動操作");   
  JButton jbAuto=new JButton("自動操作");   
     
  public GameFrame()   
  {   
      super("老鼠走迷宮");   
         
      /*設定GUI *****   */   
      JPanel jpCtrlBar=new JPanel();   
      jpCtrlBar.setLayout(new FlowLayout());   
      jpCtrlBar.add(jbOnCtrl);   
      jpCtrlBar.add(jbAuto);   
      getContentPane().setLayout(new BorderLayout());   
      getContentPane().add(mp, BorderLayout.CENTER);   
      getContentPane().add(jpCtrlBar, BorderLayout.SOUTH);   
      //設定字型    
      Font f=new Font("細明體",Font.PLAIN,24);   
      mp.setFont(f);   
      jbOnCtrl.setFont(f);   
      jbAuto.setFont(f);   
      /*  *****   *****   */   
         
         
      //設定事件    
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
         
         
      //初始化    
      initGame();   
  }   
     
  //初始化    
  public void initGame()   
  {   
      //取得迷宮    
      getMaze();   
         
      //設定主畫面    
      mp.setMaze(maze);   
      mp.setMouse(mouse);   
      //繪製畫面    
      mp.repaint();   
  }   
     
  //取得迷宮    
  public void getMaze()   
  {   
      String s[]=new String[20];   
      int line_num=0;   
         
      //自硬碟中讀取迷宮檔    
      try{   
          BufferedReader br=new BufferedReader(new FileReader("maze.txt"));   
          for (int i=0;i<s.length;i++){   
              s[i]=br.readLine();   
              if (s[i] !=null) line_num++;   
              else break;   
          }   
      }catch (Exception e){}   
         
      //取得迷宮尺寸            
      maze=new int[line_num+2][s[0].length()+2];   
         
      //設定迷宮    
      for (int i=0; i<maze.length; i++)   
          for (int j=0; j<maze[0].length; j++)   
          {   
              if (i==0 || i==line_num+1) maze[i][j]=1;            //上&下邊界    
              else if (j==0 || j==s[0].length()+1) maze[i][j]=1;  //左&右邊界    
              else if (s[i-1].charAt(j-1)=='＊') maze[i][j]=1; //牆壁    
              else if (s[i-1].charAt(j-1)=='Ｓ'){                  //起點    
                  mouse.setLocation(j,i);   
                  maze[i][j]=10;   
              }   
              else if (s[i-1].charAt(j-1)=='Ｅ') maze[i][j]=11;    //終點    
              else maze[i][j]=0;                                  //道路    
          }   
  }   
     
  //Interface ActionListener    
  public void actionPerformed(ActionEvent e)   
  {   
      //自動走迷宮囉    ^^    
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
      //走到終點    
      if (maze[mouse.y][mouse.x]==11){   
          JOptionPane.showMessageDialog((Component)null," ^-^ 這樣就可以走到啦！","遊戲終了",JOptionPane.DEFAULT_OPTION);   
          return true;   
      }   
         
      maze[mouse.y][mouse.x]=50;      //標示為已走過    
         
      //延遲    
      try{   
          Thread.sleep(200);   
      }   
      catch (Exception e){}   
         
      //上    
      if (step(0,-1))   
          if (findExit()==true)   
              return true;   
          else mouse.y++;   
         
      //下    
      if (step(0,1))   
          if (findExit()==true)   
              return true;   
          else mouse.y--;   
         
      //左    
      if (step(-1,0))   
          if (findExit()==true)   
              return true;   
          else mouse.x++;   
         
         
      //右    
      if (step(1,0))   
          if (findExit()==true)   
              return true;   
          else mouse.x--;   
         
         
      //找不到出口    
      maze[mouse.y][mouse.x]=51;          //標示為此路不通    
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
         
      //走到終點啦    
      if (maze[mouse.y][mouse.x]==11){   
          jbOnCtrl.setEnabled(false);   
          jbAuto.setEnabled(false);   
          JOptionPane.showMessageDialog((Component)null," *^^* 走到終點囉！","遊戲終了",JOptionPane.DEFAULT_OPTION);   
      }   
  }   
  public void keyReleased(KeyEvent e){}   
  public void keyTyped(KeyEvent e){}   
}   
 
class jpMainPanel extends JPanel   
{   
  int maze[][];   
  Point mouse;   
     
  //讓主畫面繪圖程式取得迷宮配置    
  public void setMaze(int arry[][])   
  {   
      this.maze=arry;   
  }   
     
  //讓主畫面繪圖程式取得老鼠位置    
  public void setMouse(Point arg)   
  {   
      mouse=arg;   
  }   
     
  //主畫面繪圖程式    
  public void paintComponent(Graphics g)   
  {   
      super.paintComponent(g);   
         
      int stuff=100;   
      //畫出迷宮    
      for (int i=1;i<maze.length-1;i++)   
          for (int j=1;j<maze[i].length-1;j++){   
              if (maze[i][j]==1){   
                  //牆壁    
                  g.drawString("＊",j*20+stuff,i*20+stuff);   
              }   
              else if (maze[i][j]==0){   
                  //道路    
              }   
              else if (maze[i][j]==10){   
                  //起點    
              }   
              else if (maze[i][j]==11){   
                  //終點    
                  g.setColor(new Color(255,0,0));   
                  g.drawString("終",j*20+stuff,i*20+stuff);   
                  g.setColor(new Color(0,0,0));   
              }   
              else{}   
          }   
         
      //畫出老鼠位置    
      g.drawString("＠",mouse.x*20+stuff,mouse.y*20+stuff);   
  }   
}   
 
//</textarea>   
