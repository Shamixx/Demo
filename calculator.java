import java.awt.*;
import java.awt.event.*;

class MyWindow extends Frame implements WindowListener
{

	public MyWindow()
	{
		setTitle("My Calculator");
		setSize(320,350);
		setVisible(true);

		addWindowListener(this);
	}

	public void paint(Graphics g)
	{
	}


	public void windowActivated(WindowEvent we)
	{
		System.out.println("Activated...");
	}

	public void windowDeactivated(WindowEvent we)
	{
			System.out.println("DeActivated...");
	}

	public void windowOpened(WindowEvent we)
	{
			System.out.println("Opened...");
	}

	public void windowClosed(WindowEvent we)
	{
			System.out.println("Closed...");
	}

	public void windowIconified(WindowEvent we)
	{
			System.out.println("Iconified...");
	}

	public void windowDeiconified(WindowEvent we)
	{
			System.out.println("Deiconified...");
	}

	public void windowClosing(WindowEvent we)
	{
		setVisible(false);
		System.exit(0);
	}

}

class MyCalc extends MyWindow implements ActionListener
{
	TextField Data;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
	Button bdot,bback,bplus,bminus,bmul,bequal,bdiv,bcancel;
	Button bsqrt,bdivx,bsign;

	char Op ='=';
	double Ans = 0,Last=0;

	Panel pn,pn0,pn1,pn2,pn3;

	String sq;

	public MyCalc()
	{
		setLayout(null);


		pn = new Panel();
		pn.setLayout(new BorderLayout(10,10));
		pn.setBounds(30,50,250,250);

		pn0 = new Panel();
		pn1 = new Panel();
		pn2 = new Panel();
		pn3 = new Panel();



		pn0.setLayout(new GridLayout(1,1,5,5));
		pn1.setLayout(new GridLayout(3,4,5,5));
		pn2.setLayout(new GridLayout(4,3,5,5));
		pn3.setLayout(new GridLayout(1,2,5,5));


		pn.add(pn0,BorderLayout.NORTH);
		pn.add(pn1,BorderLayout.WEST);
		pn.add(pn2,BorderLayout.CENTER);
		pn.add(pn3,BorderLayout.SOUTH);

		Data = new TextField(20);
		Data.setEditable(false);

		b0 = new Button(" 0 ");
		b1 = new Button(" 1 ");
		b2 = new Button(" 2 ");
		b3 = new Button(" 3 ");
		b4 = new Button(" 4 ");
		b5 = new Button(" 5 ");
		b6 = new Button(" 6 ");
		b7 = new Button(" 7 ");
		b8 = new Button(" 8 ");
		b9 = new Button(" 9 ");
		bdot = new Button(" . ");

		bback = new Button(" Back ");

		bplus = new Button(" + ");
		bminus = new Button(" - ");
		bmul = new Button(" * ");
		bdiv = new Button(" / ");
		bequal = new Button(" = ");
		bcancel = new Button(" Cancel ");
			sq=" "+(char)0x221A+" ";
		bsqrt = new Button(sq);
		bdivx  = new Button(" 1/x ");
		bsign = new Button(" +/- ");

		pn0.add(Data);

		pn1.add(b0);
		pn1.add(b1);
		pn1.add(b2);
		pn1.add(b3);
		pn1.add(b4);
		pn1.add(b5);
		pn1.add(b6);
		pn1.add(b7);
		pn1.add(b8);
		pn1.add(b9);
		pn1.add(bdot);
		pn1.add(bsign);

		pn2.add(bplus);
		pn2.add(bminus);
		pn2.add(bmul);
		pn2.add(bdiv);
		pn2.add(bsqrt);
		pn2.add(bdivx);
		pn2.add(bequal);

		pn3.add(bback);
		pn3.add(bcancel);

		add(pn);

		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bdot.addActionListener(this);
		bback.addActionListener(this);
		bplus.addActionListener(this);
		bminus.addActionListener(this);
		bmul.addActionListener(this);
		bdiv.addActionListener(this);
		bequal.addActionListener(this);
		bcancel.addActionListener(this);
		bdivx.addActionListener(this);
		bsqrt.addActionListener(this);
		bsign.addActionListener(this);


	}

	public void actionPerformed(ActionEvent ae)
	{
		String Cmd = ae.getActionCommand();

		if(Cmd.equals(" 1 "))
		{
			Data.setText(Data.getText()+"1");
		}
		else if(Cmd.equals(" 0 "))
		{
			Data.setText(Data.getText()+"0");
		}
		else if(Cmd.equals(" 2 "))
		{
			Data.setText(Data.getText()+"2");
		}
		else if(Cmd.equals(" 3 "))
		{
			Data.setText(Data.getText()+"3");
		}
		else if(Cmd.equals(" 4 "))
		{
			Data.setText(Data.getText()+"4");
		}
		else if(Cmd.equals(" 5 "))
		{
			Data.setText(Data.getText()+"5");
		}
		else if(Cmd.equals(" 6 "))
		{
			Data.setText(Data.getText()+"6");
		}
		else if(Cmd.equals(" 7 "))
		{
			Data.setText(Data.getText()+"7");
		}
		else if(Cmd.equals(" 8 "))
		{
			Data.setText(Data.getText()+"8");
		}
		else if(Cmd.equals(" 9 "))
		{
			Data.setText(Data.getText()+"9");
		}
		else if(Cmd.equals(" . "))
		{
			if(haveDot(Data.getText())==false)
				Data.setText(Data.getText()+".");
		}
		else if(Cmd.equals(" Back "))
		{
			if(Data.getText().equals("")==false)
			{
				String t = Data.getText();
				int len = t.length();
				Data.setText(t.substring(0,len-1));
			}
		}
		else if(Cmd.equals(" + "))
		{
			if(Data.getText().equals("")==false)
			{
				Ans = Last;
				Last = Double.parseDouble(Data.getText());
				Data.setText("");
				doOperation();
				Op = '+';
			}
			System.out.println(Ans + "===" + Last);

		}
		else if(Cmd.equals(" - "))
		{
			if(Data.getText().equals("")==false)
			{
				Ans = Last;
				Last = Double.parseDouble(Data.getText());
				doOperation();
				Data.setText("");
				Op = '-';
			}
			System.out.println(Ans + "===" + Last);
		}
		else if(Cmd.equals(" * "))
		{
			if(Data.getText().equals("")==false)
			{
				Ans = Last;
				Last = Double.parseDouble(Data.getText());
				doOperation();
				Data.setText("");
				Op = '*';
			}
			System.out.println(Ans + "===" + Last);
		}
		else if(Cmd.equals(" / "))
		{
			if(Data.getText().equals("")==false)
			{
				Ans = Last;
				Last = Double.parseDouble(Data.getText());
				doOperation();
				Data.setText("");
				Op = '/';
			}
			System.out.println(Ans + "===" + Last);
		}
		else if(Cmd.equals(" = "))
		{
			if(Data.getText().equals("")==false)
			{
				Ans = Last;
				Last = Double.parseDouble(Data.getText());
				doOperation();
				Op = '=';
			}
			Data.setText(""+Last);
			System.out.println(Ans + "===" + Last);
		}
		else if(Cmd.equals(" Cancel "))
		{
			Ans = Last = 0;
			Op = '=';
			Data.setText("");
		}
		else if(Cmd.equals(sq))
		{
			if(Data.getText().equals("")==false)
			{
				Last = Double.parseDouble(Data.getText());
				Last = Math.sqrt(Last);
				Data.setText(""+Last);
			}
		}
		else if(Cmd.equals(" 1/x "))
		{
			if(Data.getText().equals("")==false)
			{
				Last = Double.parseDouble(Data.getText());
				Last = 1/Last;
				Data.setText(""+Last);
			}
		}
		else if(Cmd.equals(" +/- "))
		{
			if(Data.getText().equals("")==false)
			{
				Last = Double.parseDouble(Data.getText());
				Last = -Last;
				Data.setText(""+Last);
			}
		}
	}

	boolean haveDot(String Str)
	{
		for(int i=0;i<Str.length();i++)
		{
			if(Str.charAt(i)=='.')
				return(true);
		}
		return(false);
	}

	void doOperation()
	{
		switch(Op)
		{
			case '+':	Last = Ans + Last;
				break;
			case '-':	Last = Ans - Last;
				break;
			case '*':	Last = Ans * Last;
				break;
			case '/':	Last = Ans / Last;
				break;
			case '=':	Last = Last;
				break;
		}
		Ans = 0;
	}




}

public class Ex10
{
	public static void main(String[] args)
	{
		new MyCalc();
	}
}
