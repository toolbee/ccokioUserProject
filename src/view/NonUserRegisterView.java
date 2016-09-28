package view;

import java.util.Scanner;

import controller.Controllers;
import domain.NonUser;

public class NonUserRegisterView {

	Scanner keyboard;

	public NonUserRegisterView() {

		keyboard = new Scanner(System.in);

	}

	// 비회원 사용자 등록 view
	public void nonUsertRegister() {

		String nonUserName = null;
		String nonUserTel = null;

		System.out.println("[비회원 주문 모드]");
		System.out.print("이름 : ");
		nonUserName = keyboard.next();
		System.out.print("전화번호 : ");
		nonUserTel = keyboard.next();

		NonUser newNonUser = new NonUser(nonUserName, nonUserTel);

		Controllers.getNonUserController().requestReturnNonUserRegister(newNonUser);
	}

}
