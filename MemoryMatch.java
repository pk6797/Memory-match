import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.event.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
 //main window creating
class MemoryMatch extends JFrame
{
    JButton b1;
    JLabel l1;
    public int itemselected=0;
	public MemoryMatch()
	{
	setTitle("Welcome......");
	setSize(500,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);

	setLayout(new BorderLayout());
	ImageIcon pic1=new ImageIcon("img1.png");
	setContentPane(new JLabel(pic1));

	
	this.setLayout(new BorderLayout());
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    JButton b1 = new JButton("Click Me to continue...");
    b1.setBackground(Color.cyan);
    b1.setOpaque(true);
    b1.setPreferredSize(new Dimension(150, 30));
    buttonPanel.add(b1);
    this.add(buttonPanel,BorderLayout.SOUTH);

	
	// Just for refresh :) Not optional!

	//setSize(430,430);
	
	
	 ButtonHandler handler = new ButtonHandler();  
     b1.addActionListener(handler);  
     setSize(430,430);  
     setVisible(true); 
	
   }
   
   
   
   //constuction n working of frame2:to choose category
    public class SelectCategory {
    
        private JFrame mainFrame;
        private JLabel headerLabel;
        private JLabel statusLabel;
        private JPanel controlPanel;

        public SelectCategory(){
             prepareGUI();
        }

        private void prepareGUI(){
	   //setting frame
            mainFrame = new JFrame("CATEGORIES  :");
            mainFrame.setSize(400,400);
            mainFrame.setLayout(new GridLayout(3, 1));
            mainFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent windowEvent){
                    System.exit(0);
                }        
            });    
            headerLabel = new JLabel("", JLabel.LEFT);        
            statusLabel = new JLabel("",JLabel.CENTER);    

            statusLabel.setSize(350,100);

            controlPanel = new JPanel();
            controlPanel.setLayout(new FlowLayout());

            mainFrame.add(headerLabel);
            mainFrame.add(controlPanel);
            mainFrame.add(statusLabel);
            mainFrame.setVisible(true);  
        }

        private void showComboboxDemo(){                                    
            headerLabel.setText("Select a category ......"); 
	   //headerLabel.setFont(new Font("Courier New", Font.ITALIC, 28));
	        headerLabel.setFont(new Font("Georgia", Font.PLAIN, 24));
    //headerLabel.setForeground(Color.GRAY);
            headerLabel.setForeground(new Color(50, 50, 25));

  // headerLabel.setFont(headerLabel.getFont().deriveFont(30.0f));
            final DefaultComboBoxModel CategoryName = new DefaultComboBoxModel();

            CategoryName.addElement("Elizabeth family");
            CategoryName.addElement("Simsons treee");
            CategoryName.addElement("Mango");
            CategoryName.addElement("Peer");

            final JComboBox Combo = new JComboBox(CategoryName);    
            Combo.setSelectedIndex(0);

            JScrollPane ListScrollPane = new JScrollPane(Combo);    

            JButton showButton = new JButton("Show");
	  	    JButton nextButton = new JButton("next");

            showButton.addActionListener(new ActionListener() {
				
                public void actionPerformed(ActionEvent e) { 
				
                    String data = "";
			        itemselected = Combo.getSelectedIndex();
					
                    if (Combo.getSelectedIndex() != -1) {   
                			data = "Selected: " + Combo.getItemAt(Combo.getSelectedIndex());             
                        }              
                    statusLabel.setText(data);
                }
            }); 
			
            controlPanel.add(ListScrollPane);          
            controlPanel.add(showButton);    
	        controlPanel.add(nextButton);
            mainFrame.setVisible(true); 

	        ButtonHandler handler1 = new ButtonHandler();  
            nextButton.addActionListener(handler1);  
            setSize(400,150);  
            setVisible(true);  
        }
    }
	
	
    public class  Quiz extends JFrame implements ActionListener{
            JPanel panel;
            JPanel panelresult;
            JRadioButton choice1;
            JRadioButton choice2;
            JRadioButton choice3;
            JRadioButton choice4;
            ButtonGroup bg;
            JLabel lblmess;
            JButton btnext;
            String[][] qpa;
            String[][] qca;
            int qaid;
            HashMap<Integer, String> map;

            Quiz(){
                      initializedata();
                      setTitle("Quiz !!!");
                     setDefaultCloseOperation(EXIT_ON_CLOSE);
                      setSize(530,450);
					  //frame.setUndecorated(true);
					  //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                      //frame.setVisible(true);
                     setLocation(350,150);
                      setResizable(true);
                      Container cont=getContentPane();
                      cont.setLayout(null);          
                      cont.setBackground(Color.GRAY);
                    bg=new ButtonGroup();     
                    choice1=new JRadioButton("Choice1",true);
                    choice2=new JRadioButton("Choice2",false);
                    choice3=new JRadioButton("Choice3",false);
                    choice4=new JRadioButton("Choice4",false);
                    bg.add(choice1);
                    bg.add(choice2);
                    bg.add(choice3);
                    bg.add(choice4);
                    lblmess=new JLabel("Choose a correct anwswer");
                    lblmess.setForeground(Color.BLUE);
                    lblmess.setFont(new Font("Arial", Font.BOLD, 11));
                    btnext=new JButton("Next");
                    btnext.setForeground(Color.GREEN);                
                    btnext.addActionListener(this);
                    panel=new JPanel();
                    panel.setBackground(Color.LIGHT_GRAY);
                    panel.setLocation(10,10);
                    panel.setSize(400,300);
                    panel.setLayout(new GridLayout(6,2));
                    panel.add(lblmess);
                    panel.add(choice1);
                    panel.add(choice2);
                    panel.add(choice3);
                    panel.add(choice4);
                    panel.add(btnext);
                    cont.add(panel);
                    setVisible(true);
                  if(itemselected==0) qaid=0;
				  else  { qaid=5;}
                   readqa(qaid);
           
            }
           
        public void actionPerformed(ActionEvent e){
           System.out.println("inside action performed @@@@!"); 
		   
                        if(btnext.getText().equals("Next")){
                                    
									      if(itemselected==0&&qaid<4){
                                               
                                                   map.put(qaid,getSelection());
												   
                                                     qaid++;
													 
                                                    readqa(qaid);
													
											   
										    }
												
                                            else if(itemselected==1 && qaid<9) {
												
												
                                                   map.put(qaid,getSelection());
                                                    qaid++;
                                                    readqa(qaid);
													
											   
											}
                        
						
						else{
                                     map.put(qaid,getSelection());
                                      btnext.setText("Show answers");
                                               
                             }
		                }    
                        else if(btnext.getText().equals("Show answers"))
                                    new Report();
                       
                      
            }
           

           
        public void initializedata(){
                        //qpa stores pairs of question and its possible answers
                        qpa=new String[10][5];
                        
                        qpa[0][0]="How many princes are there in picture?";
                        qpa[0][1]="5";
                        qpa[0][2]="4";
                        qpa[0][3]="6";
                        qpa[0][4]="7";

                        qpa[1][0]="How many couples got diversed?";
                        qpa[1][1]="2";
                        qpa[1][2]="4";
                        qpa[1][3]="5";
                        qpa[1][4]="3";
                       
                        qpa[2][0]="Queen Elizabeth is married to?";
                        qpa[2][1]="Mark Phillips";
                        qpa[2][2]="Philips";
                        qpa[2][3]="Duke";
                        qpa[2][4]="Edward";

                        qpa[3][0]="What is the height of hierarchy?";
                        qpa[3][1]="5";
                        qpa[3][2]="4";
                        qpa[3][3]="6";
                        qpa[3][4]="3";

                        qpa[4][0]="Hierarcy tree belongs to?";
                        qpa[4][1]="Elizabeth 1";
                        qpa[4][2]="Elizabeth 2";
                        qpa[4][3]="Elizabeth 3";
                        qpa[4][4]="Elizabeth 4";
						
						
                        qpa[5][0]="How many members in the family?";
                        qpa[5][1]="12";
                        qpa[5][2]="13";
                        qpa[5][3]="14";
                        qpa[5][4]="11";

                        qpa[6][0]="Who is the father of 3 childeren?";
                        qpa[6][1]="Herb";
                        qpa[6][2]="Homer";
                        qpa[6][3]="Abraham";
                        qpa[6][4]="Jon";

                        qpa[7][0]="Cousin of lisa?";
                        qpa[7][1]="Brat";
                        qpa[7][2]="Maggie";
                        qpa[7][3]="Lusy";
                        qpa[7][4]="Ling";

                        qpa[8][0]="Name of Family tree!";
                        qpa[8][1]="Simpson";
                        qpa[8][2]="The Simpson";
                        qpa[8][3]="The Simpsons";
                        qpa[8][4]="Simpsons";

                        qpa[9][0]="Height of tree?";
                        qpa[9][1]="4";
                        qpa[9][2]="3";
                        qpa[9][3]="5";
                        qpa[9][4]="2";
						
                       
                        //qca stores pairs of question and its correct answer
                        qca=new String[10][2];
                       
                        qca[0][0]="How many princes are there in picture?";
                        qca[0][1]="5";

                        qca[1][0]="How many couples got diversed?";
                        qca[1][1]="3";

                        qca[2][0]="Queen Elizabeth is married to?";
                        qca[2][1]="Philips";

                        qca[3][0]="What is the height of hierarchy?";
                        qca[3][1]="4";


                        qca[4][0]="Hierarcy tree belongs to?";
                        qca[4][1]="Elizabeth 2";
		                
                        qca[5][0]="How many members in the family?";
                        qca[5][1]="13";

                        qca[6][0]="Who is the father of 3 childeren?";
                        qca[6][1]="Homer";
                       
                        qca[7][0]="Cousin of lisa?";
                        qca[7][1]="Ling";
                       
                        qca[8][0]="Name of Family tree!";
                        qca[8][1]="The Simpsons";

                        qca[9][0]="Height of tree?";
                        qca[9][1]="3";
						
                       
                        //create a map object to store pairs of question and selected answer
                        map=new HashMap<Integer, String>();
                       
                        }
        public String getSelection(){
			            
                        String selectedChoice=null;
                        Enumeration<AbstractButton> buttons=bg.getElements(); 
                        while(buttons.hasMoreElements()) 
                        { 
                        JRadioButton temp=(JRadioButton)buttons.nextElement(); 
                        if(temp.isSelected()) 
                                    { 
                                                selectedChoice=temp.getText();
                                    } 
                         }  
                        return(selectedChoice);
            }

        public void readqa(int qid){
			//System.out.println("inside readga");
                        lblmess.setText("  "+qpa[qid][0]);
                        choice1.setText(qpa[qid][1]);
                        choice2.setText(qpa[qid][2]);
                        choice3.setText(qpa[qid][3]);
                        choice4.setText(qpa[qid][4]);
                        choice1.setSelected(true);
					
						
            }
       public void reset(){
                        qaid=0;
                        map.clear();
                        readqa(qaid);
                        btnext.setText("Next");
                        }
						public int calCorrectAnswer(){
                        int qnum=10;
                        int count=0;
                        for(int qid=0;qid<qnum;qid++)
                                    if(qca[qid][1].equals(map.get(qid))) count++;
                        return count;
            }

        public class Report extends JFrame{
                        Report(){
                                    setTitle("Score Board !!!");
                                    setSize(850,550);
                                    setBackground(Color.WHITE);
                                    addWindowListener(new WindowAdapter(){
                                                            public void windowClosing(WindowEvent e){
                                                                        dispose();
                                                                        reset();
                                                            }
                                                });
									int numc=calCorrectAnswer();
									Container cp = this.getContentPane();
                                    JLabel d= new JLabel("Correct"); 
									JTextField s= new JTextField(numc);
									 s.setEditable(false);
                                    									
                                    cp.add(d);
									cp.add(s);
                                    setVisible(true);
                                    }
                       
                       
                    /*class Draw extends Canvas{
                                    public void paint(Graphics g){
                                                int qnum=10;
                                                int x=10;
                                                int y=20;
                                                for(int i=0;i<qnum;i++){
                                                            //print the 1st column
                                                            g.setFont(new Font("Arial",Font.BOLD,12));                                         
                                                            g.drawString(i+1+". "+qca[i][0], x,y);
                                                            y+=30;           
                                                            g.setFont(new Font("Arial",Font.PLAIN,12));                             
                                                            g.drawString("      Correct answer:"+qca[i][1], x,y);
                                                            y+=30;
                                                            g.drawString("      Your answer:"+map.get(i), x,y);
                                                            y+=30;
                                                            //print the 2nd column
                                                            if(y>400)
                                                            {y=20;
                                                              x=450;
                                                            }
                                                           
                                                }
                                                //Show number of correct answers
                                                int numc=calCorrectAnswer();
                                                g.setColor(Color.BLUE);
                                                g.setFont(new Font("Arial",Font.BOLD,14));
                                                g.drawString("Number of correct answers:"+numc,300,500);
                       
                                               
                                    }
                        }*/
                                   
            }
           

           

}
	



	
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            
			 String btnLabel = event.getActionCommand();
			 ImageIcon icon;
         if (btnLabel.equals("Click Me to continue...")) {
            
              SelectCategory  Demo = new SelectCategory();      
              Demo.showComboboxDemo();
	          dispose();
		    }
		else {
            System.out.print(itemselected);
			 JFrame frame = new JFrame();
             if(itemselected==0) 
			    {
				    icon = new ImageIcon("elizabeth.jpg");
			    }
			else{
					 icon = new ImageIcon("img2.jpg");
				}
            JLabel label = new JLabel(icon);
            frame.add(label);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
						   
             new Quiz();
				dispose();		
		    }
        }
    }  




	public static void main(String args[])
	{
	     MemoryMatch obj=new MemoryMatch();
	     obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
}