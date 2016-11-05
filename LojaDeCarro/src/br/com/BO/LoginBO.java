package br.com.BO;

public class LoginBO {

	public static Boolean verificaLogin(String user, String senha) {
		if(user.equals("josue") && senha.equals("1234")){
			return true;
		}
		return false;
	}

}
