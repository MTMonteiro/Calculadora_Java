package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Font;
// import java.awt.*;

// @SuppressWarnings("serial")
public class View extends JFrame {
  // private JTextPane textNum;
  private JTextField textNum;
  private JLabel visor;
  private JButton btn_soma;
  private JButton btn_subtracao;
  private JButton btn_divisao;
  private JButton btn_multiplicacao;
  private JButton btn[] = new JButton[10];
  private JButton btn_enter;
  private JButton btn_CE;
  private JButton btn_i;
  private JRadioButton opInteiro;
  private JRadioButton opComplexo;
  private JPanel jPanel1;
  private JPanel jPanel2;
  private JScrollPane jScrollPane1;

  public View() {

    setTitle("Calculadora RPN - MatheusMonteiroAlves");
    setSize(1000, 1000);
    setBounds(0, 0, 500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    textNum = new JTextField("", 50);
    textNum.setPreferredSize(new Dimension(80,50)); // aumentar dimensão do campo
    Font font1 = new Font("SansSerif", Font.BOLD, 20);

    textNum.setFont(font1);
    // textNum = new javax.swing.JTextPane();
    // add(textNum);

    jScrollPane1 = new javax.swing.JScrollPane();
    jScrollPane1.setViewportView(textNum);

    // Create the radio buttons.
    opInteiro = new JRadioButton("Inteiros", false);
    opInteiro.setSelected(true);

    opComplexo = new JRadioButton("Complexos", false);

    ButtonGroup grupo1 = new ButtonGroup();
    grupo1.add(opInteiro);
    grupo1.add(opComplexo);

    btn_soma = new JButton("+");
    btn_subtracao = new JButton("-");
    btn_multiplicacao = new JButton("*");
    btn_divisao = new JButton("/");
    btn_enter = new JButton("ENTER");
    btn_CE = new JButton("CE");
    btn_i = new JButton("i");
    btn_i.setEnabled(false);
    btn_CE.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        setNum("");
      }
    });

    // instanciar botoes de 0 a 9
    for (int i = 0; i < 10; i++) {
      btn[i] = new JButton(String.valueOf(i));
    }

    // primeira parte do painel
    jPanel1 = new JPanel();
    jPanel2 = new JPanel();
    jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(textNum).addComponent(opInteiro)
            .addComponent(opComplexo).addContainerGap()));
    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
            .addComponent(textNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(opInteiro).addComponent(opComplexo)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

    // segunda parte do painel
    jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btn_i, javax.swing.GroupLayout.PREFERRED_SIZE, 218,
                    javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(btn_CE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE,
                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(btn[0],
                    javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                    .addComponent(btn[1], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btn[2],
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                    jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn[7], javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn[4], javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn[5], javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn[8], javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn[3], javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btn_soma,
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                            Short.MAX_VALUE))
                    .addComponent(btn_enter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn[6], javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_subtracao, javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btn_multiplicacao, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                jPanel2Layout.createSequentialGroup()
                                    .addComponent(btn[9], javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btn_divisao, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(2, 2, 2)))))
            .addContainerGap()));
    jPanel2Layout
        .setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                    jPanel2Layout.createSequentialGroup().addGap(44, 44, 44)
                        .addComponent(btn_i, javax.swing.GroupLayout.PREFERRED_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_multiplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_CE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(btn[7], javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn[8], javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn[9], javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_divisao, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn[5], javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn[6], javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn[4], javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btn_subtracao, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn[1], javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn[2], javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn[3], javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_soma, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn[0], javax.swing.GroupLayout.PREFERRED_SIZE, 33,

                                javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                javax.swing.GroupLayout.PREFERRED_SIZE))));

    jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] { btn[7], btn[8], btn[9] });

    // adicionando os dois layout em 1
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout
        .setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE))
                .addContainerGap()));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup().addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel2,
                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap()));

    pack();
    setVisible(true);

    setLocationRelativeTo(null);

    opInteiro.addItemListener(new RadioButtonHandler());

  }

  private class RadioButtonHandler implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent event) {
      if (opInteiro.isSelected()) {
        System.out.println("desabilitado");
        btn_i.setEnabled(false);

      } else {
        System.out.println("habilitado");
        btn_i.setEnabled(true);
      }

    }

  }

  public String modo() {
    if (opInteiro.isSelected()) {
      return "inteiro";
    } else
      return "complexo";
  }

  public String getNum() {
    return textNum.getText();
  }

  public void setNum(String text) {
    textNum.setText(text);
  }

  public void setBotaoSoma(ActionListener botaoBehavior) {
    btn_soma.addActionListener(botaoBehavior);
  }

  public void setBotaoSubtracao(ActionListener botaoBehavior) {
    btn_subtracao.addActionListener(botaoBehavior);
  }

  public void setBotaoMultiplicacao(ActionListener botaoBehavior) {
    btn_multiplicacao.addActionListener(botaoBehavior);
  }

  public void setBotaoDivisao(ActionListener botaoBehavior) {
    btn_divisao.addActionListener(botaoBehavior);
  }

  public void setBotaoEnter(ActionListener botaoBehavior) {
    btn_enter.addActionListener(botaoBehavior);
  }

  public void setBotaoI(ActionListener botaoBehavior) {
    btn_i.addActionListener(botaoBehavior);
  }

  public void setBotao0(ActionListener botaoBehavior) {
    btn[0].addActionListener(botaoBehavior);
  }

  public void setBotao1(ActionListener botaoBehavior) {
    btn[1].addActionListener(botaoBehavior);
  }

  public void setBotao2(ActionListener botaoBehavior) {
    btn[2].addActionListener(botaoBehavior);
  }

  public void setBotao3(ActionListener botaoBehavior) {
    btn[3].addActionListener(botaoBehavior);
  }

  public void setBotao4(ActionListener botaoBehavior) {
    btn[4].addActionListener(botaoBehavior);
  }

  public void setBotao5(ActionListener botaoBehavior) {
    btn[5].addActionListener(botaoBehavior);
  }

  public void setBotao6(ActionListener botaoBehavior) {
    btn[6].addActionListener(botaoBehavior);
  }

  public void setBotao7(ActionListener botaoBehavior) {
    btn[7].addActionListener(botaoBehavior);
  }

  public void setBotao8(ActionListener botaoBehavior) {
    btn[8].addActionListener(botaoBehavior);
  }

  public void setBotao9(ActionListener botaoBehavior) {
    btn[9].addActionListener(botaoBehavior);
  }

  public void setVisor(String result) {
    visor.setText(result);
  }

}