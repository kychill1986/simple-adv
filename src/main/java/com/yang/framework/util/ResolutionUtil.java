package com.yang.framework.util;

public class ResolutionUtil {

	public static int[] matchResolution(int phoneResolution) {
		int[] matched = new int[2];

		if (phoneResolution > 0 && phoneResolution < 320) {
			matched[0] = 240;
			matched[1] = 240;
		} else if (phoneResolution >= 320 && phoneResolution < 480) {
			matched[0] = 240;
			matched[1] = 360;
		} else if (phoneResolution >= 480 && phoneResolution < 720) {
			matched[0] = 240;
			matched[1] = 480;
		} else if (phoneResolution >= 720 && phoneResolution < 1080) {
			matched[0] = 240;
			matched[1] = 720;
		} else if (phoneResolution >= 1080) {
			matched[0] = 360;
			matched[1] = 720;
		}

		return matched;
	}
}
