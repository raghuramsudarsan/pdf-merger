package com.pdf.merger.utility.components;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class FileMergerPanel extends JPanel
        implements ListSelectionListener {

    private DefaultListModel defaultListModel;
    private JList fileList;

    public FileMergerPanel() {
        super(new BorderLayout(30, 30));

        defaultListModel = new DefaultListModel();
        defaultListModel.addElement("Something");
        defaultListModel.addElement("Is");
        defaultListModel.addElement("Going");
        defaultListModel.addElement("On");

        fileList = new JList(defaultListModel);
        fileList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        fileList.setSize(200, 200);
        fileList.setDragEnabled(false);
        fileList.setSelectedIndex(0);

        JScrollPane scrollPane = new JScrollPane(fileList);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setMaximumSize(new Dimension(200, 200));

        add(scrollPane, BorderLayout.CENTER);
    }

    public void addComponents() {

    }

    public void valueChanged(ListSelectionEvent e) {

    }
}
