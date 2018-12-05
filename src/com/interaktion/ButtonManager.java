package com.interaktion;

import java.util.List;
import java.util.ArrayList;

public class ButtonManager {
private static List<String> buttons = new ArrayList<String>();

public static List<String> getButtons() {
	return buttons;
}

public static void setButtons(List<String> buttons) {
	ButtonManager.buttons = buttons;
}

}
