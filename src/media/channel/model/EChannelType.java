package media.channel.model;

public enum EChannelType {
	CHANNEL_TYPE_RADIO(1,"Radio"),
	CHANNEL_TYPE_TV(2,"TV"),
	CHANNEL_TYPE_TVRADIO(3,"TV/Radio");
	
	private final int priority;
	private final String name;
	
	EChannelType(int priority, String name){
		this.priority = priority;
		this.name = name;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public String getName() {
		return name;
	}
	
}
