/**
	Authentication Controller class to enable session management and permission levels.

	@authors Ananya Behera and Christian Sesta
	@version 2.1
	@datemodified 10th November 2014
*/

package cmsystem

import grails.converters.JSON
import org.apache.commons.codec.digest.DigestUtils
import javax.servlet.*

class AuthController {
	
	/**
		Checks Sign In form data to check whether the user is legitimate via two matching the username and 
		password against existing entries in the database.

		@arguments Sign in form input data as field in the 'params' argument
		@precondition Username and Password fields must have been filled in
		@postcondition The session.user is attribute is assigned to the current user, which is necessary for session 
						management and permission levels
		@return Status message depending on credential matching
	*/
	def login = {
		def user = UserAccount.findByUsername(params.username)
		
		if(user != null) {		
			if(user.password == calculateHash(params.password)) {
				session.user = user
				return true
			} else {
				render(status: 401, text: '401: Unauthorized') as JSON
			}
		} else {
			render(status: 404, text: '404: Not Found') as JSON
		}
	}
	
	/**
		Enables safe and secure exit out of the system.

		@arguments None
		@precondition User must have been logged into the system and session.user attribute must hold user data.
		@postcondition The session.user attribute is cleared to emphasize that the user is no longer logged in.
		@return Status message depending on whether the logout was successful or not.
	*/
	def logout = {
		if(session.user != null) {
			session.user = null
			return true
		} else {
			render(status: 400, text: '400: Bad Request') as JSON
		}
	}
	
	/**
		Helper method to calculate the hash value of a given password.
	*/
	def calculateHash(String password) {
		return DigestUtils.sha512Hex(password);
	}
	
	/**
		Helper method that determines where the session is currently active.
	*/
	def sessionActive() {
		
		if(session.user != null) {
			return true
		} else {
			render(status: 401, text: '401: Unauthorized') as JSON
		}
	}
	
	/**
		This method when called upon, decides whether the current user has administrator privileges or not.

		@argument None
		@precondition There must be a user logged into the system such that the session.user attribute is populated.
		@postcondition None
		@return Returns true if the session user has admin access or returns a 401 error message.
	*/
	def adminAccess() {
		if(session.user.permissionId == 1)
		{
			return true
		} else {
			render(status: 401, text: '401: Unauthorized') as JSON
		}
	}
}
