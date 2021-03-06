package com.plugin.core.ui;

import android.content.Context;
import android.content.Intent;

public class PluginDispatcher {
	
	/**
	 * 在普通的activity中展示插件中的fragment，
	 * 
	 * 因为fragment的宿主Activity是一个普通的activity，所以对目标fragment有特殊要求，
	 * 即fragment中所有需要使用context的地方，都是有PluginLoader.getPluginContext()来获取

	 * @param context
	 * @param target
	 */
	public static void startFragment(Context context, String target) {

		Intent pluginActivity = new Intent();
		pluginActivity.setClass(context, PluginNormalDisplayer.class);
		pluginActivity.putExtra("classId", resloveTarget(target));
		pluginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(pluginActivity);
	}
	
	/**
	 * 在重写过Context的activity中展示插件中的fragment，
	 * 
	 * 因为fragment的宿主Activity是重写过的，所以对目标fragment没有特殊要求，无需在fragment中包含任何插件相关的代码
	 * 
	 * 此重写过的activity同样可以展示通过包含PluginLoader.getPluginContext()获取context的fragment
	 * 
	 * @param context
	 * @param target
	 */
	public static void startNormalFragment(Context context, String target) {

		Intent pluginActivity = new Intent();
		pluginActivity.setClass(context, PluginSpecDisplayer.class);
		pluginActivity.putExtra("classId", resloveTarget(target));
		pluginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(pluginActivity);
	}
	
	/**
	 * 显示插件中的activity
	 * 
	 *  因为目标activity的宿主Activity是重写过的，所以对目标activity没有特色要求
	 * 
	 * @param context
	 * @param target
	 */
	public static void startActivity(Context context, String target) {

		Intent pluginActivity = new Intent();
		pluginActivity.setClass(context, PluginProxyActivity.class);
		pluginActivity.putExtra("classId", resloveTarget(target));
		pluginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(pluginActivity);
	
	}
	
	private static String resloveTarget(String target) {
		return target;
	}
	
}
