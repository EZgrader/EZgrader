
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import Lib.GroupableTableHeader;
import Lib.ColumnGroup;

 
public class courseDetail  extends JPanel {
 
	private JTabbedPane jTabbedpane = new JTabbedPane();
	private String[] tabNames = { "CS655", "CS591" };
	ImageIcon icon = null;
 
	public courseDetail() {
		layoutComponents();
	}
 
	private void layoutComponents() {
		int i = 0;
		JPanel jpanelFirst = new JPanel();
		jTabbedpane.addTab(tabNames[i++], icon, jpanelFirst, "first");
		jTabbedpane.setMnemonicAt(0, KeyEvent.VK_0);
 
		JPanel jpanelSecond = new JPanel();
		jTabbedpane.addTab(tabNames[i++], icon, jpanelSecond, "second");
		jTabbedpane.setMnemonicAt(1, KeyEvent.VK_1);
		setLayout(new GridLayout(1, 1));
		add(jTabbedpane);
		

		DefaultTableModel dm = new DefaultTableModel();
	    dm.setDataVector(new Object[][]{
	      {"Kevin Durant","-17","83"},
	      {"Lebron James","-23","77"}},
	    new Object[]{"Name","Point Lost","Score","Point Lost","Score","Point Lost","Score","Point Lost","Score", "Cumulative"});

	    JTable table = new JTable( dm ) {
	      protected JTableHeader createDefaultTableHeader() {
	          return new GroupableTableHeader(columnModel);
	      }
	    };
	    
	    
	    TableColumnModel cm = table.getColumnModel();
	    ColumnGroup assignment = new ColumnGroup("Assignment (UG30%, G30%)", 1);
	    ColumnGroup assignment1 = new ColumnGroup("Assignment1", 2);
	    assignment1.add(cm.getColumn(1));
	    assignment1.add(cm.getColumn(2));
	    ColumnGroup assignment2 = new ColumnGroup("Assignment1", 2);
	    assignment2.add(cm.getColumn(3));
	    assignment2.add(cm.getColumn(4));
	    assignment.add(assignment1);
	    assignment.add(assignment2);
	    ColumnGroup project = new ColumnGroup("Project (UG30%, G30%)", 1);
	    ColumnGroup project1 = new ColumnGroup("Project1",2);
	    project1.add(cm.getColumn(5));
	    project1.add(cm.getColumn(6));
	    project.add(project1);
	    
	    ColumnGroup exam = new ColumnGroup("Exam (UG40%, G40%)",1);
	    ColumnGroup exam1 = new ColumnGroup("exam1",2);
	    exam1.add(cm.getColumn(7));
	    exam1.add(cm.getColumn(8));
	    exam.add(exam1);




	    
	    GroupableTableHeader header = (GroupableTableHeader)table.getTableHeader();
	    header.addColumnGroup(assignment);
	    header.addColumnGroup(project);
	    header.addColumnGroup(exam);
	    System.out.println(header.getTable().getSize().height);
        
        
        JScrollPane sp = new JScrollPane(table);
        jpanelFirst.setLayout(null);
        sp.setBounds(50, 50, 1200, 200);
        jpanelFirst.add(sp);
        
        JButton btn_changeweight = new JButton("Change Weight");
        btn_changeweight.setBounds(100, 300, 150, 30);
        jpanelFirst.add(btn_changeweight);
        JButton btn_calFinal = new JButton("Calculate Final");
        btn_calFinal.setBounds(300, 300, 150, 30);
        jpanelFirst.add(btn_calFinal);
        JButton btn_printStat = new JButton("Print Statistics");
        btn_printStat.setBounds(500, 300, 150, 30);
        jpanelFirst.add(btn_printStat);
        
        
        

	}
	

 
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
 
			public void run() {
				JFrame frame = new JFrame();
				frame.getContentPane().setLayout(null);
				frame.setContentPane(new courseDetail());
				frame.setSize(1300, 900);
				frame.setVisible(true);
			}
		});
	}
 
}
