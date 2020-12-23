package com.pdf.merger.utility.components;

import com.pdf.merger.utility.actionevent.FileSelectionActionListener;
import com.pdf.merger.utility.actionevent.InterchangeListListener;
import com.pdf.merger.utility.actionevent.MergeActionEventListener;
import com.pdf.merger.utility.util.FileSelectionUtil;

import javax.swing.*;
import java.awt.*;

public class FileChooseComponent extends JFrame {

    //public static JList jList = new JList();
    public static JButton mergeButton = new JButton();
    public static JButton interchangeButton = new JButton();

    public JLabel getFileChooseLabel() {
        JLabel fileChooserLabel = new JLabel();
        fileChooserLabel.setText("Choose filed (PDF only)");
        fileChooserLabel.setBounds(50, 50, 400,40);

        return fileChooserLabel;
    }

    public JButton getFileChooserButton() {
        JButton javaButton = new JButton("Choose Files");
        javaButton.setBounds(200,50,100, 40);
        javaButton.addActionListener(new FileSelectionActionListener());

        return javaButton;
    }

    public JList getFileNameList() {
        FileSelectionUtil.fileList.hide();
        FileSelectionUtil.fileList.setSelectionMode(2);
        FileSelectionUtil.fileList.setBounds(new Rectangle(0, 0, 300, 400));
        return FileSelectionUtil.fileList;
    }

    public JButton getMergeButton() {
        mergeButton.setText("Merge Files");
        mergeButton.setBounds(200,350,100, 40);
        mergeButton.addActionListener(new MergeActionEventListener());
        mergeButton.setVisible(false);

        return mergeButton;
    }


    public JButton getInterchangeValuesButton() {
        interchangeButton.setText("Interchange");
        interchangeButton.setVisible(false);
        interchangeButton.setBounds(200,350,100, 40);

        interchangeButton.addActionListener(new InterchangeListListener());

        return interchangeButton;
    }
}
