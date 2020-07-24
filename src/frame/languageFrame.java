package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Basic.language;
import Basic.o_jPanel;
import Basic.o_jbutton;

public class languageFrame {
	
	title title;
	
	JPanel listPanel,buttonPanel;
	JButton backButton,confirmButton;
	JList<String> langList;
	JScrollPane listScroller;
	
	Control.languageHandler languageHandler;
	ListSelectionListener listSelectionListener = new listSelectionListener();
	DefaultListCellRenderer transparentListCellRenderer = new transparentListCellRenderer();
	
	int selection;
	
	public languageFrame(title t){
		title = t;
		
		languageHandler = new Control.languageHandler(this,t);
		
		listPanel = new o_jPanel(2);
		listPanel.setBounds(100,50,590,400);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.setBounds(100,500,590,50);
		buttonPanel.setOpaque(false);
		
		langList = new JList<String>(language.langList());
		langList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		langList.setLayoutOrientation(JList.VERTICAL);
		langList.setVisibleRowCount(1);
		langList.setForeground(Color.WHITE);
		langList.setFont(language.titleFont);
		langList.setCellRenderer(transparentListCellRenderer);
		langList.setOpaque(false);
		langList.addListSelectionListener(listSelectionListener);
		
		listScroller = new JScrollPane(langList);
		listScroller.setPreferredSize(new Dimension(590,400));
		listScroller.setBorder(BorderFactory.createEmptyBorder());
		listScroller.setOpaque(false);
		listScroller.getViewport().setOpaque(false);
		
		backButton = new o_jbutton(language.getV("menuBackButton"));
		backButton.setFont(language.normalFont);
		backButton.setForeground(Color.BLACK);
		backButton.setFocusPainted(false);
		backButton.setActionCommand("back");
		backButton.addActionListener(languageHandler);
		
		confirmButton = new o_jbutton(language.getV("confirm"));
		confirmButton.setFont(language.normalFont);
		confirmButton.setForeground(Color.BLACK);
		confirmButton.setFocusPainted(false);
		confirmButton.setActionCommand("submit");
		confirmButton.setEnabled(false);
		confirmButton.addActionListener(languageHandler);
		
		listPanel.add(listScroller);
		buttonPanel.add(backButton);
		buttonPanel.add(confirmButton);
		
		frameSetup();
	}
	
	private void frameSetup(){
		
		title.con.add(listPanel);
		title.con.add(buttonPanel);
		
		listPanel.setVisible(true);
		buttonPanel.setVisible(true);
		
	}
	
	public void clearFrame(){
		listPanel.setVisible(false);
		buttonPanel.setVisible(false);
	}
	
	public int getSelection(){
		return selection;
	}
	
	private class listSelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			selection = langList.getSelectedIndex();
			confirmButton.setEnabled(true);
			 
		}
		
	}
	
	private class transparentListCellRenderer extends DefaultListCellRenderer{
		
	
		private static final long serialVersionUID = -7170599439361595609L;

		@Override
		public Component getListCellRendererComponent(JList<?> list,Object value,int index,boolean isSelected,boolean cellHasFocus){
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			setOpaque(isSelected);
			return this;
		}
	}
}
