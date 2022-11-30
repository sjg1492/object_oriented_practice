package media.channel.model;

public class Channel {
	private EChannelType channelType;
	private String channelId;
	private String channelName;
	private String broadcastName;
	
	protected Channel(EChannelType channelType, String channelId, String channelName, String broadcastName) {
		this.channelType = channelType;
		this.channelId = channelId;
		this.channelName = channelName;
		this.broadcastName = broadcastName;
	}
	
	public EChannelType getChannelType() {
		return channelType;
	}
	
	public String getChannelId() {
		return channelId;
	}
	
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	
	public String getChannelName() {
		return channelName;
	}
	
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	
	public String getBroadcastName() {
		return broadcastName;
	}
	
	public void setBroadcastName(String broadcastName) {
		this.broadcastName = broadcastName;
	}
	
	/**
	 * 채널 객체의 모든 정보 출력 
	 * 
	 * @version : 1.0.1
	 * @author : Jhon
	 * @return 채널 객체 정보 출력 
	 */
	public String printChannelInfo()
	{
		return "채널타입 : " + getChannelType().getName() + 
				"\t 채널ID : " + getChannelId() + 
				"\t 채널이름 : "+ getChannelName() + 
				"\t 방송국이름 : " + getBroadcastName();
	}

}
