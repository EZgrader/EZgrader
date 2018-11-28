package Lib;

/*
 * (swing1.1beta3)
 * 
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class GroupableTableHeaderUI extends BasicTableHeaderUI {

    protected GroupableTableHeader getHeader() {
        return (GroupableTableHeader) header;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Rectangle clipBounds = g.getClipBounds();
        if (header.getColumnModel().getColumnCount() == 0) {
            return;
        }
        int column = 0;
        Dimension size = header.getSize();
        Rectangle cellRect = new Rectangle(0, 0, size.width, size.height);
        Map<ColumnGroup, Rectangle> groupSizeMap = new HashMap<ColumnGroup, Rectangle>();

        for (Enumeration<TableColumn> enumeration = header.getColumnModel().getColumns(); enumeration.hasMoreElements();) {
            cellRect.height = size.height;
            cellRect.y = 0;
            TableColumn aColumn = enumeration.nextElement();
            List<ColumnGroup> groups = getHeader().getColumnGroups(aColumn);
            int groupHeight = 0;
            
            for (ColumnGroup group : groups) {
                Rectangle groupRect = groupSizeMap.get(group);
                if (groupRect == null) {
                    groupRect = new Rectangle(cellRect);
                    Dimension d = group.getSize(header.getTable());
                    groupRect.width = d.width;
                    groupRect.height = d.height;
                    groupSizeMap.put(group, groupRect);
                }
                paintCell(g, groupRect, group);
                groupHeight += groupRect.height;
                cellRect.height = size.height - groupHeight;
                cellRect.y = groupHeight;
            }
            cellRect.width = aColumn.getWidth();
            if (cellRect.intersects(clipBounds)) {
                paintCell(g, cellRect, column);
            }
            cellRect.x += cellRect.width;
            column++;

        }
    }

    private void paintCell(Graphics g, Rectangle cellRect, int columnIndex) {
        TableColumn aColumn = header.getColumnModel().getColumn(columnIndex);
        TableCellRenderer renderer = aColumn.getHeaderRenderer();
        if (renderer == null) {
            renderer = getHeader().getDefaultRenderer();
        }
        Component c = renderer.getTableCellRendererComponent(header.getTable(), aColumn.getHeaderValue(), false, false,
                -1, columnIndex);

        c.setBackground(UIManager.getColor("control"));
        rendererPane.paintComponent(g, c, header, cellRect.x, cellRect.y, cellRect.width, cellRect.height, true);
    }

    private void paintCell(Graphics g, Rectangle cellRect, ColumnGroup cGroup) {
        TableCellRenderer renderer = cGroup.getHeaderRenderer();
        if (renderer == null) {
            renderer = getHeader().getDefaultRenderer();
        }

        Component component = renderer.getTableCellRendererComponent(header.getTable(), cGroup.getHeaderValue(), false,
                false, -1, -1);
        
        if(cGroup.type == 1) {
        	ImageIcon icon = new ImageIcon("/home/xzhang/cs591/EZgrader/ui/Lib/iconfinder_plus-circle_2561291.png");
            Image img = icon.getImage();
            Image dimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            Component component2 = new JLabel(imageIcon);
            rendererPane.paintComponent(g, component2, header, cellRect.x + cellRect.width - 20, cellRect.y, 20, cellRect.height, true);
            
            ImageIcon icon2 = new ImageIcon("/home/xzhang/cs591/EZgrader/ui/Lib/icons8-edit-50.png");
            Image img2 = icon2.getImage();
            Image dimg2 = img2.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            ImageIcon imageIcon2 = new ImageIcon(dimg2);
            Component component3 = new JLabel(imageIcon2);
            rendererPane.paintComponent(g, component3, header, cellRect.x + cellRect.width - 40, cellRect.y, 20, cellRect.height, true);

        }
        if(cGroup.type == 2) {
        	ImageIcon icon = new ImageIcon("/home/xzhang/cs591/EZgrader/ui/Lib/iconfinder_checkmark_1315086.png");
            Image img = icon.getImage();
            Image dimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            Component component2 = new JLabel(imageIcon);
            rendererPane.paintComponent(g, component2, header, cellRect.x + cellRect.width - 20, cellRect.y, 20, cellRect.height, true);
        }
        

        
        rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y, cellRect.width, cellRect.height, true);
        
    }

    private int getHeaderHeight() {
        int headerHeight = 0;
        TableColumnModel columnModel = header.getColumnModel();
        for (int column = 0; column < columnModel.getColumnCount(); column++) {
            TableColumn aColumn = columnModel.getColumn(column);
            TableCellRenderer renderer = aColumn.getHeaderRenderer();
            if (renderer == null) {
                renderer = getHeader().getDefaultRenderer();
            }

            Component comp = renderer.getTableCellRendererComponent(header.getTable(), aColumn.getHeaderValue(), false,
                    false, -1, column);
            int cHeight = comp.getPreferredSize().height;
            List<ColumnGroup> groups = getHeader().getColumnGroups(aColumn);
            for (ColumnGroup group : groups) {
                cHeight += group.getSize(header.getTable()).height;
            }
            headerHeight = Math.max(headerHeight, cHeight);
        }
        return headerHeight;
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        int width = 0;
        for (Enumeration<TableColumn> enumeration = header.getColumnModel().getColumns(); enumeration.hasMoreElements();) {
            TableColumn aColumn = enumeration.nextElement();
            width += aColumn.getPreferredWidth();
        }
        return createHeaderSize(width);
    }

    private Dimension createHeaderSize(int width) {
        TableColumnModel columnModel = header.getColumnModel();
        width += columnModel.getColumnMargin() * columnModel.getColumnCount();
        if (width > Integer.MAX_VALUE) {
            width = Integer.MAX_VALUE;
        }
        return new Dimension(width, getHeaderHeight());
    }

}