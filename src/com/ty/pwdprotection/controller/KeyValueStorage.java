package com.ty.pwdprotection.controller;

import com.ty.pwdprotection.dto.UserDto;
import com.ty.pwdprotection.service.PasswordService;

public class KeyValueStorage {

	public void saveCredentials(UserDto dto) {

		PasswordService passwordService = new PasswordService();
		passwordService.saveCredentials(dto);
	}
}
