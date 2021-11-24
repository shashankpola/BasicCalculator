import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
	static JFrame f;

	static JTextField l;
	String s0, s1, s2;
	calculator()
	{
		s0 = s1 = s2 = "";
	}
	public static void main(String args[])
	{
		f = new JFrame("calculator");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		calculator c = new calculator();
		l = new JTextField(16);
		l.setEditable(false);
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1,bps;
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		beq1 = new JButton("=");

		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		beq = new JButton("C");
		be = new JButton(".");
		bps = new JButton("+/-");
		b0.setPreferredSize(new Dimension(60, 60));
        b1.setPreferredSize(new Dimension(60, 60));
        b2.setPreferredSize(new Dimension(60, 60));
        b3.setPreferredSize(new Dimension(60, 60));
        b4.setPreferredSize(new Dimension(60, 60));
        b5.setPreferredSize(new Dimension(60, 60));
        b6.setPreferredSize(new Dimension(60, 60));
        b7.setPreferredSize(new Dimension(60, 60));
        b8.setPreferredSize(new Dimension(60, 60));
        b9.setPreferredSize(new Dimension(60, 60));
        beq1.setPreferredSize(new Dimension(60, 60));
        ba.setPreferredSize(new Dimension(60, 60));
        bs.setPreferredSize(new Dimension(60, 60));
        bd.setPreferredSize(new Dimension(60, 60));
        bm.setPreferredSize(new Dimension(60, 60));
        beq.setPreferredSize(new Dimension(60, 60));
        be.setPreferredSize(new Dimension(60, 60));
        bps.setPreferredSize(new Dimension(60, 60));



		JPanel p = new JPanel();
		bm.addActionListener(c);
		bd.addActionListener(c);
		bs.addActionListener(c);
		ba.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		be.addActionListener(c);
		beq.addActionListener(c);
		beq1.addActionListener(c);
		bps.addActionListener(c);

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(b0);
		p.add(ba);
		p.add(bs);
		p.add(bm);
		p.add(bd);
		p.add(be);
		p.add(beq);
		p.add(bps);
		p.add(beq1);
		p.add(l);

		f.add(p);

		f.setSize(300,300);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			s0 = s1 = s2 = "";

			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double te;

			if (s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else if(s1.equals("+/-"))
					{
						te=Double.parseDouble(s0)*-1;
					}
			else
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));
			if(String.valueOf(te).length()>8)
			{
				l.setText("ERR");
			}
			else
				l.setText(""+te);
			s0 = Double.toString(te);

			s1 = s2 = "";
		}
		else {
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			else {
				double te;
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else if(s1.equals("+/-"))
					{
						te=Double.parseDouble(s0)*-1;
					}
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));

				s0 = Double.toString(te);
				s1 = s;
				s2 = "";
			}
			l.setText(s0 + s1 + s2);
		}
	}
}
