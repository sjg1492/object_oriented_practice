package media;

import media.channel.manager.ChannelManager;
import media.channel.model.EChannelType;
import media.channel.model.RadioChannel;
import media.channel.model.TVChannel;
import media.channel.model.TVRadioChannel;



public class ChannelMain {
	
	public static void main(String[] args) {
		
		//채널정보  관리 객체 생성 
		ChannelManager channelManager = new ChannelManager();
		channelManager.addChannel(new RadioChannel("3", "A", "KBS", "100"));
		channelManager.addChannel(new RadioChannel("2", "B", "SBS", "101"));
		channelManager.addChannel(new RadioChannel( "1", "C", "MBC", "102"));
		channelManager.addChannel(new RadioChannel( "4", "D", "YTN", "103"));
		
		channelManager.addChannel(new TVChannel("5","E","KBS","7","지상파"));
		channelManager.addChannel(new TVChannel("8","F","SBS","5","지상파"));
		channelManager.addChannel(new TVChannel("7","G","MBC","11","지상파"));
		channelManager.addChannel(new TVChannel("6","H","YTN","15","케이블"));
		
		channelManager.addChannel(new TVRadioChannel("3","I","KBS"));
		channelManager.addChannel(new TVRadioChannel("7","J","MBC"));
		
		//출력결과물 1
		channelManager.printChannelInfoByChannelType(EChannelType.CHANNEL_TYPE_RADIO);
//		channelManager.printChannelInfoByChannelType(EChannelType.CHANNEL_TYPE_TV);
//		channelManager.printChannelInfoByChannelType(EChannelType.CHANNEL_TYPE_TVRADIO);
		
		//출력결과물 2
		channelManager.printAllChannelNameList();		
	}

}