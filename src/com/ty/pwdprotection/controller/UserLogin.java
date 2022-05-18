package com.ty.pwdprotection.controller;

import java.util.Scanner;

import com.ty.pwdprotection.service.UserService;

public class UserLogin {

	public static void main(String[] args) {
		
		System.out.println("1.SignUp\n2.SignIn");		
		Scanner scanner = new Scanner(System.in);		
		int ch = scanner.nextInt();
		if(ch == 1) {
			UserService service = new UserService();
			service.signUpUser();
		}
		else if(ch == 2) {
			UserService service = new UserService();
			service.signInUser();
		}
		else {
			System.out.println("Invalid Choice !!!");
		}		
	}
}
