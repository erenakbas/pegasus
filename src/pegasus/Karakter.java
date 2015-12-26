package pegasus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;





import javazoom.jl.player.Player;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Karakter extends JPanel implements ActionListener,MouseListener,KeyListener,Runnable{
	
	
	
	
	
	Thread t;
	
	int kus_x1,kus_y1,kus_gen1,kus_yuk1;
	
	int uc=0;
	
	int arkaplan_x1,arkaplan_y1,arkaplan_gen1,arkaplan_yuk1;
	int arkaplan_x2,arkaplan_y2,arkaplan_gen2,arkaplan_yuk2;
	int arkaplan_x3,arkaplan_y3,arkaplan_gen3,arkaplan_yuk3;
	
	int player_x=50,player_y=250,player_gen=280,player_yuk=200;
	
	
	
	int mermi_x1,mermi_y1,mermi_gen1,mermi_yuk1;
	int mermi_x2,mermi_y2,mermi_gen2,mermi_yuk2;
	int mermi_x3,mermi_y3,mermi_gen3,mermi_yuk3;
	
	int ates_x,ates_y,ates_gen,ates_yuk;
	
public static  int ekstra_puan=0;
	int makspuan=0;
	int ds=0;
	
	


	
	int w=0;
	int z=0;
	
	Random r = new Random();
	Timer zaman=new Timer(25,this);
	
	Image kus1;
	
	
	Image arka_plan;
	Image arka_plan2;
	Image arka_plan3;

	Image at;

	Image mermi1;
	Image mermi2;
	Image mermi3;
	
	private String isim; 
	
	Image ates;
	
	int sayac=1;
public static	int puan=1;
	int geri=0;
	int mermi_hizi=1;
	
	private int intersect = 1;

	
	public Karakter(){
		
		
		super();
		
		
		
	     Veritaban� a = new Veritaban�();
	   		try {
				isim = a.dosya_oku()[0];
				makspuan = Integer.parseInt(a.dosya_oku()[1]);
			} catch (IOException e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
	   		
		
		t = new Thread(this);
		t.start();
		
		addMouseListener(this);
		
		ates_x=-111100;
		ates_y=160;
		ates_gen=60;
		ates_yuk=60;
		
		
		kus_x1=1550;
		kus_y1=165;
		kus_gen1=160;
		kus_yuk1=100;
	
		arkaplan_x1=0;
		arkaplan_y1=0;
		arkaplan_gen1=2048;
		arkaplan_yuk1=469;
		
		arkaplan_x2=arkaplan_x1+2048;
		arkaplan_y2=0;
		arkaplan_gen2=2048;
		arkaplan_yuk2=469;
		
		arkaplan_x3=arkaplan_x2+2048;
		arkaplan_y3=0;
		arkaplan_gen3=2048;
		arkaplan_yuk3=469;
		
		
		mermi_x1=1350;
		mermi_x2= mermi_x1+r.nextInt(800)+450;
		mermi_x3= mermi_x2+r.nextInt(800)+450;	
		mermi_gen1=r.nextInt(45)+55;
		mermi_yuk1=r.nextInt(40)+55;
		mermi_y1=450- mermi_yuk1;
		mermi_gen2=r.nextInt(45)+55;
		mermi_yuk2=r.nextInt(40)+55;
		mermi_y2=450- mermi_yuk2;
		mermi_gen3=r.nextInt(45)+55;
		mermi_yuk3=r.nextInt(40)+55;
		mermi_y3=450- mermi_yuk3;
		
		
		kus1=Toolkit.getDefaultToolkit().getImage(getClass().getResource("kus1.gif"));
		
		arka_plan=Toolkit.getDefaultToolkit().getImage(getClass().getResource("aap.png"));
		arka_plan2=Toolkit.getDefaultToolkit().getImage(getClass().getResource("aap2.png"));
		arka_plan3=Toolkit.getDefaultToolkit().getImage(getClass().getResource("aap3.png"));
		
		at=Toolkit.getDefaultToolkit().getImage(getClass().getResource("asp.gif"));
		
		mermi1=Toolkit.getDefaultToolkit().getImage(getClass().getResource("mermi1.jpg"));
		mermi2=Toolkit.getDefaultToolkit().getImage(getClass().getResource("mermi2.jpg"));  
		mermi3=Toolkit.getDefaultToolkit().getImage(getClass().getResource("mermi3.jpg"));
		
		ates=Toolkit.getDefaultToolkit().getImage(getClass().getResource("ates.png"));
		
		
		zaman.start();
		
		
		
	}

	
	public void paint(Graphics g)
	{
		
		
		super.paintComponent(g);
		
		g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);
		g.drawImage(arka_plan, arkaplan_x1, arkaplan_y1, arkaplan_gen1, arkaplan_yuk1, null);
		g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);
		g.drawImage(arka_plan2, arkaplan_x2, arkaplan_y2, arkaplan_gen2, arkaplan_yuk2, null);   
		g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);
		g.drawImage(arka_plan3, arkaplan_x3, arkaplan_y3, arkaplan_gen3, arkaplan_yuk3, null);
		g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);
		g.drawImage(kus1, kus_x1, kus_y1, kus_gen1,kus_yuk1, null);
		g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);
        g.drawImage(mermi1, mermi_x1, mermi_y1, mermi_gen1, mermi_yuk1, null);
        g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);
        g.drawImage(mermi2, mermi_x2, mermi_y2, mermi_gen2, mermi_yuk2, null);
        g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);
        g.drawImage(mermi3, mermi_x3, mermi_y3, mermi_gen3, mermi_yuk3, null);
        g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);   
        g.drawImage(ates, ates_x, ates_y, ates_gen, ates_yuk, null);
        g.drawImage(at,player_x, player_y, player_gen,player_yuk, null);
        
        String yazi;


        yazi=Integer.toString(puan);
        
        g.setFont(new Font("Times New Roman", Font.BOLD, 12));
       
        g.drawString("puan:"+yazi, 25, 25);
      
        sayac++;
        if(sayac % 10 == 0){
            puan+=1;
            
      if(puan%100==0){mermi_hizi+=1;}
      
		}
        
      
       
        
     
        g.setFont(new Font("Times New Roman", Font.BOLD, 12));
        
        g.drawString("Avlanan Kus: "+(ekstra_puan/10), 25, 50);
        
      g.drawString("En Y�ksek Skor ",25,75);
 		g.drawString(isim,115,75);
    	g.drawString(""+makspuan,(isim.length()*9)+115,75);

        
        
        if(!zaman.isRunning()){
          

        
        
        	g.setFont(new Font("Algerian", Font.PLAIN, 30));
    	

           
            g.drawString("puaniniz: "+puan+" "+"Kus Bonusu x10: "+ekstra_puan, 100, 125);
            g.drawString("toplam puan:"+(puan + ekstra_puan),100, 165);
            g.drawString("Tekrar oynamak icin Enter'a Basin",100,205);
           
        
        	
        	
        	 
			
           
        }

		

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
	
		Rectangle at =new Rectangle(player_x+100 ,player_y,player_gen-150,player_yuk-50);
	
		Rectangle e1 =new Rectangle(mermi_x1,mermi_y1,mermi_gen1,1);
		Rectangle e2 =new Rectangle(mermi_x2,mermi_y2,mermi_gen2,1);
		Rectangle e3 =new Rectangle(mermi_x3,mermi_y3,mermi_gen3,1);
		
		Rectangle ates = new Rectangle(ates_x,ates_y,ates_gen,ates_yuk-20);
		Rectangle kus1 = new Rectangle(kus_x1,kus_y1-19,kus_gen1,kus_yuk1-80);

		
		
	
		
		if(kus1.intersects(ates)){
			
			
			ds=1;
			if(intersect == 1){
				ekstra_puan+=10;
				intersect++;
	
				
			}

		}

		if ((puan+ekstra_puan)>1200){
			uc=1;
	
		}
		
		for(int i=0; i<=4; i++){
		if( at.intersects(e1) || at.intersects(e2) || at.intersects(e3)	|| at.intersects(kus1)){
			zaman.stop();
		    if((puan+ekstra_puan)>makspuan)
		        {
		    	   
		    	   
		    	   makspuan=((puan+ekstra_puan));
		    	
		    	   
		     Veritaban� a = new Veritaban�();
		   		
		   		a.dosyaAc();
		   		a.kay�tEkle();
		   		a.dosyaKapa();
		   		try {
					isim = a.dosya_oku()[0];
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
		       }
		       
		   		
			
			
		}
		
		else{
			
			
			
			
			kus_x1-=2;

			arkaplan_x1-=1;
			arkaplan_x2-=1;
			arkaplan_x3-=1;
			
			
			mermi_x1-=mermi_hizi;
			mermi_x2-=mermi_hizi;
			mermi_x3-=mermi_hizi;
		
			if(ates_x>0){
			ates_x+=5;
			}
			if (uc==1){
				player_x+=1;
				player_y-=1;
				
				if(player_y==-10)
				{
					zaman.stop();
					
					 if((puan+ekstra_puan)>makspuan)
				        {
				    	   
				    	   
				    	   makspuan=((puan+ekstra_puan));
				    	
				    	   
				     Veritaban� a = new Veritaban�();
				   		
				   		a.dosyaAc();
				   		a.kay�tEkle();
				   		a.dosyaKapa();
				   		try {
							isim = a.dosya_oku()[0];
						} catch (IOException e4) {
							// TODO Auto-generated catch block
							e4.printStackTrace();
						}
				        } 
				
					 
				Main.pencere.setVisible(false);
				
				Bonus bn =new Bonus();
				
				
				Main.bonus.add(bn);
				Main.bonus.setSize(2048, 1024);
				Main.bonus.setResizable(false);
				Main.bonus.setVisible(true);
				Main.bonus.addKeyListener(bn);
				Main.bonus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
			
		if (ds==1){
				
				kus_y1+=1;
				
		
				if(kus_y1>180){
					
					kus_x1=2550;
					kus_y1=165;
					
					
				
					ds=0;
				}
				

			
			}
	}

		}
		
		if(z>0){z++;}
		
		if(z==10){
			
			
			player_y=250;
			player_x=player_x+100;
			z=0;
			geri=1;
		}

		if(w>0){w++;}
		
		if(w==22){
			
			
			ates_x=-111100;
			w=0;
			
			
			
		}

		
		if (player_x>1200){
			
			player_x=50;
			
		}
		
        	
        
		
		if(geri==1){

			
			for(int j =0;j<5;j++)
				{
					
				player_x-=mermi_hizi;
				
				if(player_x<50){
					geri=0;
				}
				
				}
	             
				
			} 

		
		if(mermi_x3<0){
			mermi_x1=1350;
			mermi_x2=mermi_x1+r.nextInt(800)+450;
			mermi_x3=mermi_x2+r.nextInt(800)+450;
			mermi_gen1=r.nextInt(45)+55;
			mermi_yuk1=r.nextInt(40)+55;
			mermi_y1=450-mermi_yuk1;
			mermi_gen2=r.nextInt(45)+55;			
			mermi_yuk2=r.nextInt(40)+55;
			mermi_y2=450-mermi_yuk2;
			mermi_gen3=r.nextInt(45)+55;
			mermi_yuk3=r.nextInt(40)+55;
			mermi_y3=450-mermi_yuk3;
		}
		

		
	if(kus_x1<0){
		
			kus_x1=1500;
			kus_y1=165;

		}
	

		
		
		
		
		for(int a=0;a<3;a++){
			
			if(arkaplan_x3<0){
			arkaplan_x1=0;
			arkaplan_x2=arkaplan_x1+2048;
			arkaplan_x3=arkaplan_x2+2048;

		}
			
			
			}

		repaint();
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
	
	
	if(player_y!=160){
		player_y=160;//(280-125)
	 	player_x=player_x+150;
		z=1;
	}
		
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	//	y=360;
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//y=360;
		
	}

	@Override
	public void mousePressed(MouseEvent e) {


	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// BIRAKILDI�INDA
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		// TODO Auto-generated method stub
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(ates_x<0)
			{
				ates_x=player_x+player_gen;
				ates_y=player_y;
				intersect = 1;
				try {


					  AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("ases.wav"));
			        Clip clip = AudioSystem.getClip();
			        clip.open(audioInputStream);
			        clip.start();
			    } catch(Exception ex) {
			        System.out.println("Error with playing sound.");
			        ex.printStackTrace();
			    }
				w=1;
			}
		
		}
	
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{

			
	

		if(ates_x<0)
		{
			ates_x=player_x+player_gen;
			ates_y=player_y;
			intersect = 1;
			try {


				 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("ases.wav"));
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
			w=1;
		}
	
		
		
			
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
 
			if(player_y!=160){
			player_y=160;//(280-125)
		 	player_x=player_x+150;
			z=1;
			}
		
			
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){ 

            if(!zaman.isRunning()) {
                z = 0;
                sayac = 1;
                puan = 1;
                geri = 0;
                uc=0;
              
                mermi_hizi=1;
                ates_x=-101100;
                
                kus_x1=1550;
        		kus_y1=165;
        		kus_gen1=160;
        		kus_yuk1=100;
        		
        		arkaplan_x1 = 0;
                arkaplan_y1 = 0;
                arkaplan_gen1 = 2048;
                arkaplan_yuk1 = 469;

                arkaplan_x2 = arkaplan_x1 + 2048;
                arkaplan_y2 = 0;
                arkaplan_gen2 = 2048;
                arkaplan_yuk2 = 469;

                arkaplan_x3 = arkaplan_x2 + 2048;
                arkaplan_y3 = 0;
                arkaplan_gen3 = 2048;
                arkaplan_yuk3 = 469;

        		mermi_x1=1350;    			
        		mermi_x2= mermi_x1+r.nextInt(800)+450;
        		mermi_x3= mermi_x2+r.nextInt(800)+450;	
        		mermi_gen1=r.nextInt(50)+45;
        		mermi_yuk1=r.nextInt(40)+55;
        		mermi_y1=450- mermi_yuk1;
        		mermi_gen2=r.nextInt(50)+45;
        		mermi_yuk2=r.nextInt(40)+55;
        		mermi_y2=450- mermi_yuk2;
        		mermi_gen3=r.nextInt(50)+45;
        		mermi_yuk3=r.nextInt(40)+55;
        		mermi_y3=450- mermi_yuk3;

                player_x = 50;
                player_y = 250;
                
                ds=0;
        
                
                ekstra_puan=0;
                zaman.start();
            }

        }

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		while(true){
		/*try {
		//	System.out.println(getClass().getResource("ap_muzik.mp3").toString());
			String yol =getClass().getResource("/ap_muzik.mp3").toString().substring(6);
			System.out.println(yol);
			FileInputStream fis = new FileInputStream("ap_muzik.mp3");
		    Player playMP3 = new Player(fis);
		    playMP3.play();
	    } catch(Exception ex) {
	        System.out.println(ex);
	        ex.printStackTrace();
	    }
		*/
		
			
			try {


			  AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("ap_muzik.wav"));
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		        
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
			try {
				Thread.sleep(34000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		
		
	}
 
}
