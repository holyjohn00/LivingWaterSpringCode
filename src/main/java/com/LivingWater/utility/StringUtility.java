package com.LivingWater.utility;

import com.LivingWater.constants.StringConstants;

public class StringUtility {

	public static final boolean isStringNullOrEmpty(String paramString) {
		if (paramString != null && !paramString.equals(StringConstants.EMPTY_STRING))
			return false;
		return true;
	}
}
