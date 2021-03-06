package controller;

import dao.UserDao;
import domain.User;
import view.AlertView;
import view.UserDeleteView;
import view.UserLoginShowView;
import view.UserMyInfo;
import view.UserRegisterView;
import view.UserUpdateView;

public class UserController {

	UserDao userDao;

	public UserController() {

		userDao = new UserDao();

	}

	// 회원 가입 요청 메서드
	public void requestRegister() {

		UserRegisterView userRegisterView = new UserRegisterView();
		userRegisterView.userRegister();

	}

	public void requestReturnRegister(User newUser) {
	
		boolean success = userDao.userRegister(newUser);

		if (success) {
			new AlertView().alert("회원가입을 성공했습니다.");
		} else {
			new AlertView().alert("중복된 아이디가 있습니다.");
		}
		Controllers.getMainController().requestMainView();
		
	}

	// 업데이트 뷰에서 정보를 받아오는 메서드
		public void requestUserUpdate(){
			
			UserUpdateView userUpdateView = new UserUpdateView();
			userUpdateView.userUpdate();
			
		}
		
		
		
		// 업데이트 뷰에서 받아온 정보를 DAO 로 전달하는 메서드
		
		public void requestUserUpdateProsccesing(User user){
			
			boolean success = userDao.userUpdate(user);
			if(success){
				new AlertView().alert("정보 수정에 성공하였습니다.");
				
			}else {
				new AlertView().alert("정보수정에 실패하였습니다.");
			}
			
			Controllers.getMainController().requestUserMainView();
			// 여기서 다시 수정화면이든 메인메뉴로 돌아가는 컨트롤러 연결이 필요할듯함
				
		}
		
		public void requestUserDelete() {

			UserDeleteView userDeleteView = new UserDeleteView();
			userDeleteView.userDelete();

		}

		public void requestUserDeleteProcessing() {

			boolean success = userDao.UserDelete();
			if (success) {
				new AlertView().alert("회원 정보 삭제에 성공하였습니다.");
				Controllers.getMainController().requestMainView();
			} else {
				new AlertView().alert("회원 정보 삭제에 실패하였습니다.");
				Controllers.getMainController().requestUserMainView();
			}

		}
		
		public void requestUserInfo() {
			
			//내정보 메뉴로 이동하는 컨트롤러 메서드
			
			UserMyInfo userMyInfor = new UserMyInfo();
			userMyInfor.UserInfoMenu();

		}

		public void requestUserinfoShowView() {
			
			//DAO에서 내정보 리스트를 받아서 뷰로 전달하는 메서드
			User searchedUser = userDao.UserLoginInfo();
			 UserLoginShowView userLoginShowView = new UserLoginShowView();
			 userLoginShowView.userLoginInfoView(searchedUser);
			
		
		}
	
}
