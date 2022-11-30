package media.channel.manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import media.channel.model.Channel;
import media.channel.model.EChannelType;

public class ChannelManager {
	
	//채널 리스트 
	private List<Channel> mChannelList  = new ArrayList<>();
	
	/**
	 * 채널 객체를 입력 받아 정렬된 리스트로 관리
	 * 
	 * @version : 1.0.1
	 * @author : Jhon
	 * @param channel : 채널 객체 
	 */
	public void addChannel(Channel channel) {
		if(channel != null) {
			if(!replacementPriorityChannelIdSame(channel)) {
				mChannelList.add(channel);
			}
			sortChannelListASC();
		}
	}
	
	/**
	 * 채널타입에 해당하는 채널리스트 출력 
	 * 
	 * @version : 1.0.1
	 * @author : Jhon
	 * @param channelType : 채널타입 
	 */
	public void printChannelInfoByChannelType(EChannelType channelType) {
		for(int i=0; i<mChannelList.size(); i++) {  
			if( ( channelType.equals(EChannelType.CHANNEL_TYPE_RADIO) || 
					channelType.equals(EChannelType.CHANNEL_TYPE_TV) ) &&
					mChannelList.get(i).getChannelType().equals(EChannelType.CHANNEL_TYPE_TVRADIO) ||
					mChannelList.get(i).getChannelType().equals(channelType)) {
				System.out.println(mChannelList.get(i).printChannelInfo());
			}
		} 
	}
	
	/**
	 * 채널리스트의 모든 채널 이름 출력  
	 * 
	 * @version : 1.0.1
	 * @author : Jhon
	 */
	public void printAllChannelNameList() {
		for(int i=0; i<mChannelList.size(); i++) {
			Channel channel = mChannelList.get(i);
			if(channel != null) {
				System.out.print(channel.getChannelName());
				if(i < mChannelList.size()-1) {
					System.out.print(",");
				}	
			}
		} 
	}
	
	/**
	 * 채널 ID가 동일한 항목은 “Radio<<TV<<TV/Radio” 우선순위 순으로 교체
	 * 
	 * @version : 1.0.1
	 * @author : Jhon
	 * @param channel : 채널 객체 
	 * @return : 교체 여부 (교체 : true 교체X : false)
	 */
	private boolean replacementPriorityChannelIdSame(Channel channel) {
		boolean channelIdDuplicationCheck = false;
		
		for(int i=0; i<mChannelList.size(); i++) {
			if(channel.getChannelId().equals(mChannelList.get(i).getChannelId()) ) {
				if(mChannelList.get(i).getChannelType().getPriority() < channel.getChannelType().getPriority()) {
					mChannelList.set(i, channel);
					channelIdDuplicationCheck = true;
				}
			}
		}
		return channelIdDuplicationCheck;
	}
	
	/**
	 * 채널리스트 오름차순 정렬 
	 * 
	 * @version : 1.0.1
	 * @author : Jhon
	 */
	private void sortChannelListASC() {
		// TODO 내림 차순 정렬 기능 추가 및 해당 로직 설명
		//스트림 : 데이터 집합을 읽는 객체 (정렬/필터링/반복문에서 많이사용함)
		//Comparator.comparing : 정렬의 기준이 되는 필드 정의 
		//stream.collect : 형변환 메소드 
		mChannelList = mChannelList.stream().sorted(Comparator.comparing(Channel::getChannelId)).collect(Collectors.toList());
	}
	
	
}
