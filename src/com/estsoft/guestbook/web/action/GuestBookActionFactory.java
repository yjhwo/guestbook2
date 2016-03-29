package com.estsoft.guestbook.web.action;


import com.estsoft.web.action.Action;
import com.estsoft.web.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory{

	@Override
	public Action getAction(String actionName) {

		Action action = null;
				
		if ("add".equals(actionName)) { // 리스트에 추가
			action = new AddAction();			
		} else if ("deleteform".equals(actionName)) { // 삭제
			action = new DeleteFormAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else { // default action(list, index action)
			action = new IndexAction();
		}

		return action;
	}

}
