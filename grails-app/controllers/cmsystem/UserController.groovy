package cmsystem

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;

class UserController {

    def index() { 
		render(view: 'index')
	}
	
	def login() {
		def login = false;
		
		def user = User.findByUserNameAndPassword(params.userName, params.password)
		
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
		}
		
	}
	
	def renderUserForm() {
		render(view: "createUserForm")
	}
	
	def createUser() {
		def userInstance = new User()
		def passwordHash
		
		userInstance.firstName = params.firstName
		userInstance.lastName = params.lastName
		userInstance.userName = params.userName
		userInstance.password = params.password
		userInstance.salt = randomSalt()
		
		passwordHash = calculateHash(userInstance.password, userInstance.salt)
		userInstance.password = passwordHash
		
		userInstance.save(flush: true)
		
		flash.message = "User created."
		//login() - uncomment once login is setup to decode sha512+salt
		redirect(controller: "User", action: "index")
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
