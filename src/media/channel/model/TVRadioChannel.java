package media.channel.model;

public class TVRadioChannel extends Channel {
	
	public TVRadioChannel(String channelId, String channelName, String broadcastName) {
			super(EChannelType.CHANNEL_TYPE_TVRADIO,channelId,channelName,broadcastName);
	}
		
}
