package teletubbies.updatechecker;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import teletubbies.Teletubbies;

public class UpdateChecker implements Runnable {
	
	private static boolean isLatestVersion = false;
	private static String latestVersion = null;
	private static String currentVersion = Teletubbies.MODVERSION;

	@Override
	public void run() {
		//Get Newest Version
		try {
			String[] mcVersionArray = Teletubbies.MCVERSION.split(Pattern.quote("."));
			
			URL url = new URL("https://raw.githubusercontent.com/Rexbas/Teletubbies-Mod/master/" +
			mcVersionArray[0] + "." + mcVersionArray[1] + "%20Version.txt");
			
			Scanner s = new Scanner(url.openStream());
			latestVersion = s.next();
			s.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//Print to Console
		if(latestVersion == null) {
			System.out.println("Could Not Check For Updates!");
			System.out.println("Your Mod Version = " + currentVersion);
		}
		else {
			System.out.println("Latest Mod Version = " + latestVersion);
			System.out.println("Your Mod Version = " + currentVersion);
			isLatestVersion = Teletubbies.MODVERSION.equals(latestVersion);
		}
	}
	
	//Print InGame
	public void updateStatus(EntityPlayer player) {
		char c = 167;
		String p = Character.toString((char)c); //p = paragraph
		if(latestVersion == null) {
			//versionWarningChatComponent = new ChatComponentText("Could not check for update!");
			//Not important for user
		}
		else {
			IChatComponent versionWarningChatComponent = null;
			ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "http://www.planetminecraft.com/mod/teletubbie-mod-3463624/");
			ChatStyle clickableChatStyle = new ChatStyle().setChatClickEvent(versionCheckChatClickEvent);
			versionWarningChatComponent = new ChatComponentText(p + "d[" + p + "3Teletubbies Mod" + p + "d] " + p + "eNew Version Available, Click To Download!");
			versionWarningChatComponent.setChatStyle(clickableChatStyle);
			player.addChatMessage(versionWarningChatComponent);
		}
		Teletubbies.haveWarnedVersionOutOfDate = true;
	}
	
	public boolean isLatestVersion() {
		return isLatestVersion;
	}
}