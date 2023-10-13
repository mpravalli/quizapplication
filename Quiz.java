import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    JLabel label;
    JRadioButton[] radioButton =new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count=0,current=0;
    Quiz(String s){
        super(s);
        label=new JLabel();
        add(label);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++){
            radioButton[i]=new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }
        btnNext=new JButton("Next");
        btnResult=new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButton[0].setBounds(50,80,450,20);
        radioButton[1].setBounds(50,110,200,20);
        radioButton[2].setBounds(50,140,200,20);
        radioButton[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);

    }
    void setData(){
       radioButton[4].setSelected(true);
       if(current==0){
           label.setText("Q1 : What is the size of integer variable in java?");
           radioButton[0].setText("8 bit");
           radioButton[1].setText("32 bit");
           radioButton[2].setText("16 bit");
           radioButton[3].setText("128 bit");
       }
        if(current==1){
            label.setText("Q2 : Who invented Java Programming?");
            radioButton[0].setText("Guido van Rossum");
            radioButton[1].setText("Dennis Ritchie");
            radioButton[2].setText("James Gosling");
            radioButton[3].setText("Both B and C");
        }if(current==2){
            label.setText("Q3 : Which is the official language for Android Development");
            radioButton[0].setText("Java");
            radioButton[1].setText("Kotlin");
            radioButton[2].setText("C++");
            radioButton[3].setText("Java Script");
        }if(current==3){
            label.setText("Q4 : Which one of the following is not a feature of java?");
            radioButton[0].setText("Object-Oriented");
            radioButton[1].setText("Use of Pointers");
            radioButton[2].setText("Portable");
            radioButton[3].setText("Dynamic and Extensible");
        }
        if(current==4){
            label.setText("Q5 : What is the extension of java script file?");
            radioButton[0].setText(".js");
            radioButton[1].setText(".txt");
            radioButton[2].setText(".class");
            radioButton[3].setText(".java");
        }
        if(current==5){
            label.setText("Q6 : What is the default value of static variable in java?");
            radioButton[0].setText("1");
            radioButton[1].setText("garbage value");
            radioButton[2].setText("0.0");
            radioButton[3].setText("0");
        }
        if(current==6){
            label.setText("Q7 : Which of the following is non-primitive data type?");
            radioButton[0].setText("int");
            radioButton[1].setText("char");
            radioButton[2].setText("String");
            radioButton[3].setText("boolean");
        }
        if(current==7){
            label.setText("Q8 : Which data structure will follow LIFO?");
            radioButton[0].setText("array");
            radioButton[1].setText("stack");
            radioButton[2].setText("queue");
            radioButton[3].setText("tree");
        }
        if(current==8){
            label.setText("Q9 : Who call the main method in Java?");
            radioButton[0].setText("JDK");
            radioButton[1].setText("Compiler");
            radioButton[2].setText("JVM");
            radioButton[3].setText("Interpreter");
        }
        if(current==9){
            label.setText("Q10 : Which is not a access specifier?");
            radioButton[0].setText("public");
            radioButton[1].setText("private");
            radioButton[2].setText("protected");
            radioButton[3].setText("void");
        }
        label.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++){
            radioButton[j].setBounds(50,80+i,200,20);
        }
    }
    boolean checkAns(){
        if(current==0){
            return (radioButton[1].isSelected());
        }
        if(current==1){
            return (radioButton[2].isSelected());
        }
        if(current==2){
            return (radioButton[0].isSelected());
        }
        if(current==3){
            return (radioButton[1].isSelected());
        }
        if(current==4){
            return (radioButton[0].isSelected());
        }
        if(current==5){
            return (radioButton[3].isSelected());
        }
        if(current==6){
            return (radioButton[2].isSelected());
        }
        if(current==7){
            return (radioButton[1].isSelected());
        }
        if(current==8){
            return (radioButton[2].isSelected());
        }
        if(current==9){
            return (radioButton[3].isSelected());
        }
        return false;
    }
    public static void main(String[] args){
        new Quiz("Simple Quiz app");
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnNext){
            if(checkAns())
                count=count+1;
            current++;
            setData();
            if(current==9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Result")){
            if(checkAns())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this,"Correct Answers are"+count);
            System.exit(0);
        }
    }
}
