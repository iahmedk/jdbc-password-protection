package com.ty.pwdprotection.service;

import java.util.Scanner;

import com.ty.pwdprotection.dao.PasswordDao;
import com.ty.pwdprotection.dto.PasswordDto;
import com.ty.pwdprotection.dto.UserDto;
import com.ty.pwdprotection.util.AES;
import static com.ty.pwdprotection.util.ApplicationConstants.SECRETE_KEY;

public class PasswordService {

	public void saveCredentials(UserDto udto) {

		System.out.println("Enter the details of " + udto.getUserName() + " to be stored !!");
		Scanner scanner = new Scanner(System.in);
		PasswordDao dao = new PasswordDao();

		while (true) {
			System.out.println("Enter the id");
			int id =scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter the key");
			String key = scanner.nextLine();

			System.out.println("Enter the value");
			String value = scanner.nextLine();

			System.out.println("Enter the type");
			String type = scanner.nextLine();

			System.out.println("Enter the hint");
			String hint = scanner.nextLine();

			PasswordDto pdto = new PasswordDto();
			pdto.setId(id);
			pdto.setKey(AES.encrypt(key, SECRETE_KEY));
			pdto.setValue(AES.encrypt(value, SECRETE_KEY));
			pdto.setType(type);
			pdto.setHint(hint);

			if (dao.saveCredentials(udto.getUid(), pdto) > 0) {
				System.out.println("Saved Successfully !!");
				System.out.println("1.Continue storing for " + udto.getUserName() + " ?");
				System.out.println("2.Return");
				int ch = scanner.nextInt();
				scanner.nextLine();
				if (ch == 2) {
					break;
				}
			}
		}
	}
}
