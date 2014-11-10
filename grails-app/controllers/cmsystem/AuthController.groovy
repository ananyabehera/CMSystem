package cmsystem

import grails.converters.JSON
import org.apache.commons.codec.digest.DigestUtils
import javax.servlet.*

class AuthController {
	
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
	
	def logout = {
		if(session.user != null) {
			session.user = null
			return true
		} else {
			render(status: 400, text: '400: Bad Request') as JSON
		}
	}
	
	def calculateHash(String password) {
		return DigestUtils.sha512Hex(password);
	}
	
	def sessionActive() {
		
		if(session.user != null) {
			return true
		} else {
			render(status: 401, text: '401: Unauthorized') as JSON
		}
	}
	
	def adminAccess() {
		if(session.user.permissionId == 1)
		{
			return true
		} else {
			render(status: 401, text: '401: Unauthorized') as JSON
		}
	}
}
