package com.vulinh.qrgenerator;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;

/**
 * @author LinhNV42
 */
public class Main {

    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.printf("Windows LookAndFeel class not found: %s", ex.getMessage());
        } catch (InstantiationException ex) {
            System.err.printf("Windows LookAndFeel instantiation error: %s", ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.err.printf("Access violation error: %s", ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.printf("Unsupported LaF error: %s", ex.getMessage());
        }

        EventQueue.invokeLater(() -> {
            QRCodeForm form = new QRCodeForm();
            form.setLocationRelativeTo(null); // Center to main monitor or whatever
            form.setVisible(true);
        });
    }
}