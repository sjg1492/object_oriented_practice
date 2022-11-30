package media.channel.model;

public class TVChannel extends Channel {
	private String channelNum;
	private String broadcasDivision;
	
	public TVChannel(String channelId, String channelName, String broadcastName,String channelNum, String broadcasDivision) {
		super(EChannelType.CHANNEL_TYPE_TV,channelId,channelName,broadcastName);
		this.channelNum = channelNum;
		this.broadcasDivision = broadcasDivision;
	}
	
	public String getChannelNum() {
		return channelNum;
	}

	public void setChannelNum(String channelNum) {
		this.channelNum = channelNum;
	}

	public String getBroadcasDivision() {
		return broadcasDivision;
	}

	public void setBroadcasDivision(String broadcasDivision) {
		this.broadcasDivision = broadcasDivision;
	}

	@Override
	public String printChannelInfo()
	{
		return super.printChannelInfo() + 
				"\t 채널번호 : " + getChannelNum() +
				"\t 방송 구분 : " + getBroadcasDivision();
	}
	
}
