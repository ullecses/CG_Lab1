package org.example;

import javax.swing.*;
import java.awt.*;

public class ColorConverterApp extends JFrame {
    private JTextField rField, gField, bField; // RGB
    private JTextField cField, mField, yField, kField; // CMYK
    private JTextField hField, sField, vField; // HSV
    private JPanel colorDisplay;
    private JSlider rSlider, gSlider, bSlider; // Sliders for RGB
    private JSlider cSlider, mSlider, ySlider, kSlider; // Sliders for CMYK
    private JSlider hSlider, sSlider, vSlider; // Sliders for HSV
    private int countR = 0;
    private int countC = 0;
    private int countH = 0;

    public ColorConverterApp() {
        setTitle("Color Converter");
        setSize(500, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // Устанавливаем null layout для абсолютного позиционирования

        // Панель для отображения цвета
        colorDisplay = new JPanel();
        colorDisplay.setBackground(Color.BLACK);
        colorDisplay.setBounds(0, 0, 500, 200);
        add(colorDisplay);

        // Добавляем кнопку для выбора цвета через палитру
        JButton chooseColorButton = new JButton("Choose Color");
        chooseColorButton.setBounds(320, 220, 150, 25);
        chooseColorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose a Color", colorDisplay.getBackground());
            if (selectedColor != null) {
                rSlider.setValue(selectedColor.getRed());
                gSlider.setValue(selectedColor.getGreen());
                bSlider.setValue(selectedColor.getBlue());
                updateFromRGB(++countR);
                --countR;
            }
        });
        add(chooseColorButton);

        // Панель для RGB
        JLabel rLabel = new JLabel("R");
        rLabel.setBounds(20, 220, 20, 25);
        add(rLabel);
        rField = new JTextField("0");
        rField.setBounds(40, 220, 50, 25);
        rField.setEditable(false);
        add(rField);

        rSlider = new JSlider(0, 255);
        rSlider.setBounds(100, 220, 200, 25);
        rSlider.setValue(0);
        rSlider.addChangeListener(e -> {
            rField.setText(String.valueOf(rSlider.getValue()));
            updateFromRGB(++countR);
            --countR;
        });
        add(rSlider);

        JLabel gLabel = new JLabel("G");
        gLabel.setBounds(20, 250, 20, 25);
        add(gLabel);
        gField = new JTextField("0");
        gField.setBounds(40, 250, 50, 25);
        gField.setEditable(false);
        add(gField);

        gSlider = new JSlider(0, 255);
        gSlider.setBounds(100, 250, 200, 25);
        gSlider.setValue(0);
        gSlider.addChangeListener(e -> {
            gField.setText(String.valueOf(gSlider.getValue()));
            updateFromRGB(++countR);
            --countR;
        });
        add(gSlider);

        JLabel bLabel = new JLabel("B");
        bLabel.setBounds(20, 280, 20, 25);
        add(bLabel);
        bField = new JTextField("0");
        bField.setBounds(40, 280, 50, 25);
        bField.setEditable(false);
        add(bField);

        bSlider = new JSlider(0, 255);
        bSlider.setBounds(100, 280, 200, 25);
        bSlider.setValue(0);
        bSlider.addChangeListener(e -> {
            bField.setText(String.valueOf(bSlider.getValue()));
            updateFromRGB(++countR);
            --countR;
        });
        add(bSlider);


        // Панель для CMYK
        JLabel cLabel = new JLabel("C");
        cLabel.setBounds(20, 330, 20, 25);
        add(cLabel);
        cField = new JTextField("0");
        cField.setBounds(40, 330, 50, 25);
        cField.setEditable(false);
        add(cField);

        cSlider = new JSlider(0, 100);
        cSlider.setBounds(100, 330, 200, 25);
        cSlider.setValue(0);
        cSlider.addChangeListener(e -> {
            cField.setText(String.valueOf(cSlider.getValue()));
            updateFromCMYK(++countC);
            --countC;
        });
        add(cSlider);

        JLabel mLabel = new JLabel("M");
        mLabel.setBounds(20, 360, 20, 25);
        add(mLabel);
        mField = new JTextField("0");
        mField.setBounds(40, 360, 50, 25);
        mField.setEditable(false);
        add(mField);
        mSlider = new JSlider(0, 100);
        mSlider.setBounds(100, 360, 200, 25);
        mSlider.setValue(0);
        mSlider.addChangeListener(e -> {
            mField.setText(String.valueOf(mSlider.getValue()));
            updateFromCMYK(++countC);
            --countC;
        });
        add(mSlider);

        JLabel yLabel = new JLabel("Y");
        yLabel.setBounds(20, 390, 20, 25);
        add(yLabel);
        yField = new JTextField("0");
        yField.setBounds(40, 390, 50, 25);
        yField.setEditable(false);
        add(yField);

        ySlider = new JSlider(0, 100);
        ySlider.setBounds(100, 390, 200, 25);
        ySlider.setValue(0);
        ySlider.addChangeListener(e -> {
            yField.setText(String.valueOf(ySlider.getValue()));
            updateFromCMYK(++countC);
            --countC;
        });
        add(ySlider);

        JLabel kLabel = new JLabel("K");
        kLabel.setBounds(20, 420, 20, 25);
        add(kLabel);
        kField = new JTextField("100");
        kField.setBounds(40, 420, 50, 25);
        kField.setEditable(false);
        add(kField);

        kSlider = new JSlider(0, 100);
        kSlider.setBounds(100, 420, 200, 25);
        kSlider.setValue(100);
        kSlider.addChangeListener(e -> {
            kField.setText(String.valueOf(kSlider.getValue()));
            updateFromCMYK(++countC);
            --countC;
        });
        kField.setEditable(false);
        add(kSlider);

        // Панель для HSV
        JLabel hLabel = new JLabel("H"); //оттенок
        hLabel.setBounds(20, 470, 20, 25);
        add(hLabel);
        hField = new JTextField("0");
        hField.setBounds(40, 470, 50, 25);
        hField.setEditable(false);
        add(hField);

        hSlider = new JSlider(0, 360);
        hSlider.setBounds(100, 470, 200, 25);
        hSlider.setValue(0);
        hSlider.addChangeListener(e -> {
            hField.setText(String.valueOf(hSlider.getValue()));
            updateFromHSV(++countH);
            --countH;
        });
        add(hSlider);

        JLabel sLabel = new JLabel("S"); //насыщенность
        sLabel.setBounds(20, 500, 20, 25);
        add(sLabel);
        sField = new JTextField("0");
        sField.setBounds(40, 500, 50, 25);
        sField.setEditable(false);
        add(sField);

        sSlider = new JSlider(0, 100);
        sSlider.setBounds(100, 500, 200, 25);
        sSlider.setValue(0);
        sSlider.addChangeListener(e -> {
            sField.setText(String.valueOf(sSlider.getValue()));
            updateFromHSV(++countH);
            --countH;
        });
        add(sSlider);

        JLabel vLabel = new JLabel("V"); //яркость
        vLabel.setBounds(20, 530, 20, 25);
        add(vLabel);
        vField = new JTextField("0");
        vField.setBounds(40, 530, 50, 25);
        vField.setEditable(false);
        add(vField);

        vSlider = new JSlider(0, 100);
        vSlider.setBounds(100, 530, 200, 25);
        vSlider.setValue(0);
        vSlider.addChangeListener(e -> {
            vField.setText(String.valueOf(vSlider.getValue()));
            updateFromHSV(++countH);
            --countH;
        });
        add(vSlider);

        setVisible(true);
    }

    private void updateFromRGB(int coun) {
        try {
            if(coun<2) {
                int r = rSlider.getValue();
                int g = gSlider.getValue();
                int b = bSlider.getValue();

                // Update CMYK
                int[] cmyk = rgbToCmyk(r, g, b);
                cField.setText(String.valueOf(cmyk[0]));
                cSlider.setValue(cmyk[0]);
                mField.setText(String.valueOf(cmyk[1]));
                mSlider.setValue(cmyk[1]);
                yField.setText(String.valueOf(cmyk[2]));
                ySlider.setValue(cmyk[2]);
                kField.setText(String.valueOf(cmyk[3]));
                kSlider.setValue(cmyk[3]);

                // Update HSV
                int[] hsv = rgbToHsv(r, g, b);
                hField.setText(String.valueOf(hsv[0]));
                hSlider.setValue(hsv[0]);
                sField.setText(String.valueOf(hsv[1]));
                sSlider.setValue(hsv[1]);
                vField.setText(String.valueOf(hsv[2]));
                vSlider.setValue(hsv[2]);

                updateColorDisplay(r, g, b);
            }
        } catch (NumberFormatException e) {
            showError();
        }
    }

    private void updateFromCMYK(int coun) {
        try { if(coun<2) {
            float c = Float.parseFloat(cField.getText()) / 100;
            float m = Float.parseFloat(mField.getText()) / 100;
            float y = Float.parseFloat(yField.getText()) / 100;
            float k = Float.parseFloat(kField.getText()) / 100;

            // Update RGB
            int[] rgb = cmykToRgb(c, m, y, k);
            rSlider.setValue(rgb[0]);
            gSlider.setValue(rgb[1]);
            bSlider.setValue(rgb[2]);

            // Update HSV
            int[] hsv = rgbToHsv(rgb[0], rgb[1], rgb[2]);
            hField.setText(String.valueOf(hsv[0]));
            sField.setText(String.valueOf(hsv[1]));
            vField.setText(String.valueOf(hsv[2]));

            updateColorDisplay(rgb[0], rgb[1], rgb[2]);
        }
        } catch (NumberFormatException e) {
            showError();
        }
    }

    private void updateFromHSV(int coun) {
        try { if(coun<2) {
            float h = Float.parseFloat(hField.getText());
            float s = Float.parseFloat(sField.getText()) / 100;
            float v = Float.parseFloat(vField.getText()) / 100;

            // Update RGB
            int[] rgb = hsvToRgb(h, s, v);
            rSlider.setValue(rgb[0]);
            gSlider.setValue(rgb[1]);
            bSlider.setValue(rgb[2]);

            // Update CMYK
            int[] cmyk = rgbToCmyk(rgb[0], rgb[1], rgb[2]);
            cField.setText(String.valueOf(cmyk[0]));
            mField.setText(String.valueOf(cmyk[1]));
            yField.setText(String.valueOf(cmyk[2]));
            kField.setText(String.valueOf(cmyk[3]));

            updateColorDisplay(rgb[0], rgb[1], rgb[2]);
        }
        } catch (NumberFormatException e) {
            showError();
        }
    }

    private void updateColorDisplay(int r, int g, int b) {
        colorDisplay.setBackground(new Color(r, g, b));  // Обновление цвета панели
    }

    private int[] rgbToCmyk(int r, int g, int b) {
        float c = 1 - (r / 255f);
        float m = 1 - (g / 255f);
        float y = 1 - (b / 255f);
        float k = Math.min(c, Math.min(m, y));

        if (k < 1) {
            c = (c - k) / (1 - k);
            m = (m - k) / (1 - k);
            y = (y - k) / (1 - k);
        } else {
            c = m = y = 0;
        }
        return new int[]{(int)(c*100), (int)(m*100), (int)(y*100), (int)(k*100)};
    }

    private int[] cmykToRgb(float c, float m, float y, float k) {
        int r = (int) ((1 - c) * (1 - k) * 255);
        int g = (int) ((1 - m) * (1 - k) * 255);
        int b = (int) ((1 - y) * (1 - k) * 255);
        return new int[]{r, g, b};
    }

    private int[] rgbToHsv(int r, int g, int b) {
        float rN = r / 255f;
        float gN = g / 255f;
        float bN = b / 255f;

        float max = Math.max(rN, Math.max(gN, bN));
        float min = Math.min(rN, Math.min(gN, bN));
        float h, s, v = max;

        float d = max - min;
        s = max == 0 ? 0 : d / max;

        if (max == min) {
            h = 0; // achromatic
        } else {
            if (max == rN) {
                h = (gN - bN) / d + (gN < bN ? 6 : 0);
            } else if (max == gN) {
                h = (bN - rN) / d + 2;
            } else {
                h = (rN - gN) / d + 4;
            }
            h /= 6;
        }
        return new int[]{(int)(h * 360), (int)(s*100), (int)(v*100)};
    }

    private int[] hsvToRgb(float h, float s, float v) {
        int r, g, b;
        int i = (int) Math.floor(h / 60) % 6;
        float f = (float) (h / 60 - Math.floor(h / 60));
        float p = v * (1 - s);
        float q = v * (1 - f * s);
        float t = v * (1 - (1 - f) * s);
        v *= 255;
        p *= 255;
        q *= 255;
        t *= 255;

        switch (i) {
            case 0 -> {
                r = (int) v;
                g = (int) t;
                b = (int) p;
            }
            case 1 -> {
                r = (int) q;
                g = (int) v;
                b = (int) p;
            }
            case 2 -> {
                r = (int) p;
                g = (int) v;
                b = (int) t;
            }
            case 3 -> {
                r = (int) p;
                g = (int) q;
                b = (int) v;
            }
            case 4 -> {
                r = (int) t;
                g = (int) p;
                b = (int) v;
            }
            default -> {
                r = (int) v;
                g = (int) p;
                b = (int) q;
            }
        }
        return new int[]{r, g, b};
    }

    private void showError() {
        JOptionPane.showMessageDialog(this, "Invalid input, please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorConverterApp::new);
    }
}