package cmsystem

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;

class UserController {

    def index() { 
		render(view: 'index')
	}
	
	def login() {
		def login = false
		def user = User.findByUserNameLike(params.userName)
		
		if(user.password == checkHash(params.password, user.salt)) {
			session.user = user
			session.login = false

			if(user.level == Permission.ADMIN)
				redirect(controller: "AdminHome", action: "renderHomePage")
			else
				redirect(controller: "GeneralHome", action: "renderHomePage")
		}
		else {
			//flash.message = "Login Failed"
			flash.message = "User Password: " + user.password + "\nEntered password Hash:" + checkHash(params.password, user.salt)
			session.login = true

			redirect(action: 'index')
		}
		
		/*def login = false;	
		def user = User.findByUserNameAndPasswordAndSalt(params.userName, params.password,)
		
		if(user) {
			flash.message = "Login Succeeded"
			session.user = user
			session.login = false

			if(user.level == Permission.ADMIN)
				redirect(controller: "AdminHome", action: "renderHomePage")
			else
				redirect(controller: "GeneralHome", action: "renderHomePage")
		}
		else {
			flash.message = "Login Failed"
			session.login = true

			redirect(action: 'index')
		}*/
		
	}
	
	def renderUserForm() {
		render(view: "createUserForm")
	}
	
	def createUser() {
		def userInstance = new User()
		def passwordHash
		
		if(User.findByFirstNameLike(params.firstName) && User.findByLastNameLike(params.lastName) && User.findByUserNameLike(params.userName)) {
			flash.message = "- Name already in Use.\n- Username Already in use."
			render(view: "createUserForm")
		}
		else if(User.findByFirstNameLike(params.firstName) && User.findByLastNameLike(params.lastName)) {
			flash.message = "- Name already in Use."
			render(view: "createUserForm")
		}
		else if(User.findByUserNameLike(params.userName)) {
			flash.message = "- Username Already in use."
			render(view: "createUserForm")
		}
		else {
			userInstance.firstName = params.firstName.toLowerCase()
			userInstance.lastName = params.lastName.toLowerCase()
			userInstance.userName = params.userName.toLowerCase()
			userInstance.password = params.password
			userInstance.level = params.level
			userInstance.salt = randomSalt()
			
			passwordHash = calculateHash(userInstance.password, userInstance.salt)
			userInstance.password = passwordHash
			
			userInstance.save(flush: true)
			
			flash.message = "User created."
			//login() - uncomment once login is setup to decode sha512+salt
			redirect(controller: "User", action: "index")
		}
		
	}
	
	def randomSalt () {
		def String salt = 0
		def random = new Random()
		
		
		for(int i = 0; i < 16; i++)
		{
			salt = salt + random.nextInt(10)
		}
		
		return salt
	}
	
	def checkHash(String password, String salt) {
		DigestUtils.sha512Hex(password + salt);
	}
	
	def calculateHash(String password, String salt) {
		return DigestUtils.sha512Hex(password + salt);
	}
	
	def deleteUser() {
		def user = User.findById(params.id)
		
		if(user) {
			user.delete(flush: true)
			//redirect(controller: "User", action: "renderListing") -- Uncomment once list has been created
		}
	}
	
	def logout() {
		session.user = null
		redirect(action: 'index')
	}
}
