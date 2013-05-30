package model;

import service.PaperService;

/**
 * Class to create a SubProgramChair Object and its functionalities.
 * 
 * @author Levon Kechichian
 * @version Spring 2013
 */
public class SubProgramChair extends User
{	
	/**
	 * Constructs a SubProgramChair Object based
	 * on the given parameters.
	 * 
	 * @param the_conference the Conference the User is a SubProgramChair for
	 * @param the_first_name the first name of the User
	 * @param the_last_name	the last name of the User
	 * @param the_password the Users password
	 * @param the_username the Users screen name
	 * @param the_email the Users e-mail
	 */
	public SubProgramChair(final Conference the_conference, final String the_first_name, 
		final String the_last_name, final String the_password, final String the_username, 
		final String the_email)
	{
		super(the_conference, Role.SUB_PROGRAM_CHAIR, the_first_name, the_last_name, 
			the_password, the_username, the_email);
	}
	
	/**
	 * Assigns a Reviewer to a specified Paper.
	 * 
	 * @param the_user the Reviewer that is being assigned to the Paper
	 * @param the_paper the Paper that the User is being assigned to
	 */
	public void assignReviewer(final User the_user, final Paper the_paper, 
		final Conference the_conference)
	{
		PaperService.getInstance().assignPaper(the_paper.getID(), the_user.getID(), 
			the_conference.getID(), Role.REVIEWER);
	}
	
	/**
	 * Submits a Recommendation for a specified Paper.
	 * 
	 * @param the_paper the Paper the Recommendation is being
	 * assigned to
	 */
	public void submitRecommendation(final Recommendation the_recommendation, final Paper the_paper)
	{
		PaperService.getInstance().addRecommendation(the_recommendation, the_paper.getID());
	}
}

