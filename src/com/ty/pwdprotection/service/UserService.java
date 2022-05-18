package com.ty.pwdprotection.service;

import java.util.Scanner;

import com.ty.pwdprotection.controller.KeyValueStorage;
import com.ty.pwdprotection.dao.UserDao;
import com.ty.pwdprotection.dto.UserDto;

public class UserService {

	public void signUpUser() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the user name");
		String userName = scanner.nextLine();

		System.out.println("Enter the email id");
		String userEmail = scanner.nextLine();

		System.out.println("Enter the password");
		String userPassword = scanner.nextLine();

		UserDao dao = new UserDao();

		if (dao.saveUser(id, userName, userEmail, userPassword) > 0) {
			System.out.println("Signup Successfull, Try login now !!");
		} else {
			System.out.println("Something went wrong in signup !!");
		}
	}

	public void signInUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the email id");
		String userEmail = scanner.nextLine();

		System.out.println("Enter the password");
		String userPassword = scanner.nextLine();

		UserDao dao = new UserDao();
		UserDto dto = dao.validateUser(userEmail, userPassword);
		if (dto != null) {
			System.out.println("***** Login Successfull *****");
			KeyValueStorage keyValueStorage = new KeyValueStorage();
			keyValueStorage.saveCredentials(dto);

		} else {
			System.out.println("Invalid e-mail/password");
		}

	}
}
