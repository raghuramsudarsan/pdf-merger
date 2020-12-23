package com.pdf.merger.utility.main;

import com.pdf.merger.utility.components.FileChooseComponent;
import com.pdf.merger.utility.components.FileMergerPanel;
import javafx.scene.control.SplitPane;

import javax.swing.*;
import java.awt.*;

public class PdfMergerMain {
    public static JFrame frame = new JFrame();

    public static void main(String[] args) {
        JSplitPane splitPane = new JSplitPane();
        splitPane.setDividerLocation(75);
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

        JPanel fileChooserPanel = new JPanel();
        fileChooserPanel.setMaximumSize(new Dimension(100, 100));
        FileChooseComponent fileChooseComponent = new FileChooseComponent();
        fileChooserPanel.add(fileChooseComponent.getFileChooseLabel());
        fileChooserPanel.add(fileChooseComponent.getFileChooserButton());
        fileChooserPanel.add(fileChooseComponent.getMergeButton());


        JPanel fileListPanel = new JPanel();
        fileChooserPanel.setMaximumSize(new Dimension(400, 400));
        fileListPanel.add(fileChooseComponent.getFileNameList());
        fileListPanel.add(fileChooseComponent.getInterchangeValuesButton());

        splitPane.setTopComponent(fileChooserPanel);
        splitPane.setBottomComponent(fileListPanel);

        frame.setContentPane(splitPane);
        frame.setSize(500, 600);
        frame.setTitle("Sanky PDfMerger");

        frame.show();
    }

    public static void throwAnAlert(String messageText) {
        JOptionPane.showMessageDialog(frame, messageText);
    }

}
