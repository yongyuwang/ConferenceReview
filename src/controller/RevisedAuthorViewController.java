package controller;

/**
 * RevisedAuthorViewController.java
 * Controls the behavior of buttons in RevisedAuthorView
 * 
 * @author yongyuwang
 * @version 3
 * Based on code from AuthorViewController 
 * by Roshun Jones 
 */

import gui.MainView;
import gui.RevisedAuthorView;
import gui.RevisedPaperSubmissionForm;


import java.awt.event.ActionEvent;
import java.util.List;


import model.Author;
import model.Paper;


public class RevisedAuthorViewController implements Controller
{
	private RevisedAuthorView my_view;
	private Author the_author;

	public RevisedAuthorViewController(final RevisedAuthorView the_view)
	{
		my_view = the_view;
		the_author = my_view.getAuthor();
	}

	@Override
	public void actionPerformed(final ActionEvent the_event)
	{
		String command = the_event.getActionCommand();
		if("view_edit".equals(command))
		{
			Paper paper = my_view.getSelectedRow();
	        new RevisedPaperSubmissionForm(the_author, paper).setVisible(true); 
			my_view.getTableModel().fireTableDataChanged();
		}
		if("add_submission".equals(command))
		{
			//Launches the new paper submission form when pressed.
	        new RevisedPaperSubmissionForm(the_author, null).setVisible(true); 
			my_view.getTableModel().fireTableDataChanged();
		}
		if("view_reviews".equals(command))
		{
			
		}
		if("delete_submission".equals(command))
		{
			Paper paper = my_view.getSelectedRow();
			try {
				the_author.deletePaper(paper);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			my_view.getTableModel().fireTableDataChanged();
		}
	
	}

	@Override
	public void update(Object aObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setModel(Object aObject) {
		// TODO Auto-generated method stub

	}
}