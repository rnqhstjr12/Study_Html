package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.EmploDeleteAction;
import com.saeyan.controller.action.EmploListAction;
import com.saeyan.controller.action.EmploUpdateAction;
import com.saeyan.controller.action.EmploUpdateFormAction;
import com.saeyan.controller.action.EmploViewAction;
import com.saeyan.controller.action.EmploWriteAction;
import com.saeyan.controller.action.EmploWriteFormAction;

public class ActionFactory {
	private ActionFactory() {
		
	}
	private static ActionFactory inst = new ActionFactory();
	public static ActionFactory Inst() {
		return inst;
	}
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory :" + command);
		if (command.equals("emplo_list")) {
			action = new EmploListAction();
		} else if (command.equals("emplo_write_form")) {
			action = new EmploWriteFormAction();
		} else if (command.equals("emplo_write")) {
			action = new EmploWriteAction();
		} else if (command.equals("emplo_view")) {
			action = new EmploViewAction();
		} else if (command.equals("emplo_update_form")) {
			action = new EmploUpdateFormAction();
		} else if (command.equals("emplo_update")) {
			action = new EmploUpdateAction();
		} else if (command.equals("emplo_delete")) {
			action = new EmploDeleteAction();
		}
		return action;
	}
}
