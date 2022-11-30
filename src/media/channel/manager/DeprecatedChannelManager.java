package media.channel.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import media.channel.model.Channel;
import media.channel.model.RadioChannel;
import media.channel.model.TVChannel;
import media.channel.model.TVRadioChannel;

public class DeprecatedChannelManager {

//	
//	/**
//	 * @Method Name : createChannelList
//	 * @param Channel
//	 * @Method 설명 : 채널 객체 정보 저장  
//	 */
//	public List<Channel> createChannelList(Channel channel) {
//
//        //객체를 집어넣
//        List<Channel> channelList = new ArrayList<>();
//        String channelType = "";
//		String[] arrChannelId = null;
//	    String[] arrChannelName = null;
//		String[] arrBroadcasName = null;
//        if(channel instanceof TVChannel) {
//            
//    		channelType = "TV";
//    		arrChannelId = new String[]{"5","8","7","6"}; 
//            arrChannelName = new String[]{"E","F","G","H"};
//            arrBroadcasName = new String[]{"KBS","SBS","MBC","YTN"}; 
//            String[] arrChannelNum = {"7","5","11","15"};
//            String[] arrBroadcastDivision = {"지상파","지상파","지상파","케이블"};
//            
//    		for(int i=0; i<arrChannelId.length; i++) {
//    			channel = new TVChannel(channelType, arrChannelId[i], 
//    					arrChannelName[i], arrBroadcasName[i], arrChannelNum[i],arrBroadcastDivision[i]);
//    			channelList.add(channel);
//    			//System.out.println(channel.toString());
//    		}
//    		
//        }else if( channel instanceof RadioChannel) {
//        	channelType = "Radio";
//    		arrChannelId = new String[]{"3","2","1","4"}; 
//            arrChannelName = new String[]{"A","B","C","D"}; 
//            arrBroadcasName = new String[]{"KBS","SBS","MBC","YTN"}; 
//            String[] arrFrequency = {"100","101","102","103"};
//            
//    		for(int i=0; i<arrChannelId.length; i++) {
//    			channel = new RadioChannel(channelType, arrChannelId[i], 
//    					arrChannelName[i], arrBroadcasName[i], arrFrequency[i]);
//    			channelList.add(channel);
//    		}
//        }else if( channel instanceof TVRadioChannel ) {
//        	channelType = "TV/Radio";
//    		arrChannelId = new String[]{"3","7"}; 
//            arrChannelName = new String[]{"I","J"}; 
//            arrBroadcasName = new String[]{"KBS","MBC"}; 
//    		for(int i=0; i<arrChannelId.length; i++) {
//    			channel = new TVRadioChannel(channelType, arrChannelId[i], 
//    					arrChannelName[i], arrBroadcasName[i]);
//    			channelList.add(channel);
//    		}
//        }        
//        
//        
//        return channelList;
//	}
//	
//	
//	/**
//	 * @author	작성자
//	 * @Method Name : channelLisManagement
//	 * @Method 설명 : 채널정보 객체 관리 
//	 */
//	public void channelLisManagement() {
//		List<Channel> radioChannelList = createChannelList(new RadioChannel());
//		List<Channel> tvChannelList = createChannelList(new TVChannel());
//		List<Channel> tvradioChannelList = createChannelList(new TVRadioChannel());
//
//		List<Channel> totalChannelList = null;
//		
//		//List 병합
//		totalChannelList = Stream.of(radioChannelList, tvChannelList)
//	                .flatMap(x -> x.stream())
//	                .collect(Collectors.toList());
//		totalChannelList = Stream.of(totalChannelList, tvradioChannelList)
//                .flatMap(x -> x.stream())
//                .collect(Collectors.toList());
//		
//		
//		//List 정렬  
//		totalChannelList = totalChannelList.stream().sorted(Comparator.comparing(Channel::getChannelId)).collect(Collectors.toList());
//		
//		//List 우선순위 순으로 교체
//		priorityReplacementList(totalChannelList);
//		
//		//특정 채널리스트 출력 
//		String paramChannelType = "Radio";
//		channelInfo(totalChannelList,paramChannelType);
//		
//		//모든 채널 이름 출력 
//		channelInfo(totalChannelList);
//	}
//	
//	
//	/**
//	 * @Method Name : specificChannelInfo
//	 * @param specificChannelInfo
//	 * @Method 설명 : 채널타입에 해당하는 채널리스트 출력  
//	 */
//	public void channelInfo(List<Channel> totalChannelList,String channelType) {
//		for(int i=0; i<totalChannelList.size(); i++) {
//			if(totalChannelList.get(i).getChannelType().contains(channelType)) {
//				System.out.println(totalChannelList.get(i).toString());
//			}
//		} 
//		
//	}
//	
//	/**
//	 * @Method Name : totalChannelInfo
//	 * @param totalChannelList
//	 * @Method 설명 : totalChannelLi 모든 채널 이름 출력 
//	 */
//	public void channelInfo(List<Channel> totalChannelList) {
//		for(int i=0; i<totalChannelList.size(); i++) {
//				System.out.print(totalChannelList.get(i).getChannelName());
//				if(i < totalChannelList.size()-1) {
//					System.out.print(",");
//				}
//		} 
//	}
//	
//	
//	
//	/**
//	 * @Method Name : priorityReplacementList
//	 * @param totalChannelList
//	 * @Method 설명 : 채널 ID가 동일한 항목은 “Radio<<TV<<TV/Radio” 우선순위 순으로 교체
//	 */
//	public void priorityReplacementList(List<Channel> totalChannelList) {
//		//채널 ID가 동일한 항목은 ( Radio<<TV<<TV/Radio ) 우선순위 순으로 교
//		int removeChankCountNum = 0;
//		for(int i=0; i<totalChannelList.size(); i++) {
//			String channelId = totalChannelList.get(i).getChannelId();
//			if(i < totalChannelList.size() - 1 ) {
//				
//				if(channelId == totalChannelList.get(i+1).getChannelId()) {
//					String channelType = totalChannelList.get(i).getChannelType();
//					String nextChannelType = totalChannelList.get(i+1).getChannelType();
//					
//					if(channelType.equals("Radio")) {
//						if(nextChannelType.equals("TV") || nextChannelType.equals("TV/Radio")) {
//							totalChannelList.remove(totalChannelList.get(i-removeChankCountNum));
//							removeChankCountNum++;
//						}
//						
//					}else if(channelType.equals("TV")) {
//						if(nextChannelType.equals("TV/Radio")) {
//							totalChannelList.remove(totalChannelList.get(i-removeChankCountNum));
//							removeChankCountNum++;
//						}
//					}
//				}
//				
//			}
//		} 
//	}
//	
	
}
