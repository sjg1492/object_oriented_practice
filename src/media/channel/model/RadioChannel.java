package media.channel.model;

public class RadioChannel extends Channel {
	
	private String frequency;
	
	public RadioChannel( String channelId, String channelName, String broadcastName,String frequency) {
		super(EChannelType.CHANNEL_TYPE_RADIO,channelId,channelName,broadcastName);
		this.frequency = frequency;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	@Override
	public String printChannelInfo()
	{
		return super.printChannelInfo() + "\t 주파수 : " + getFrequency();
	}
	
}

