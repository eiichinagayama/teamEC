package com.internousdev.leo.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.leo.dao.DestinationInfoDAO;
import com.internousdev.leo.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteDestinationAction extends ActionSupport implements SessionAware {

	private String id;
	private List<DestinationInfoDTO> destinationInfoDTOList;
	private Map<String, Object> session;

	public String execute() {

		if(session.isEmpty()) {
			return "sessionTimeout";
		}

		String result = ERROR;
		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		int count = destinationInfoDAO.deleteDestination(id);
		if(count > 0) {
			destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(String.valueOf(session.get("userId")));
			result=SUCCESS;
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DestinationInfoDTO> getDestinationInfoDTOList() {
		return destinationInfoDTOList;
	}

	public void setDestinationInfoDTOList(List<DestinationInfoDTO> destinationInfoDTOList) {
		this.destinationInfoDTOList = destinationInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}