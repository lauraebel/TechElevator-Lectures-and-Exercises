package com.techelevator.contacts;

public class ContactInfo {
	
	private int contactId;
	private String contactType;
	private String contactMethod;
	private String contact;
	private String contactMethodOther;
	
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getContactMethod() {
		return contactMethod;
	}
	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContactMethodOther() {
		return contactMethodOther;
	}
	public void setContactMethodOther(String contactMethodOther) {
		this.contactMethodOther = contactMethodOther;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + contactId;
		result = prime * result + ((contactMethod == null) ? 0 : contactMethod.hashCode());
		result = prime * result + ((contactMethodOther == null) ? 0 : contactMethodOther.hashCode());
		result = prime * result + ((contactType == null) ? 0 : contactType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactInfo other = (ContactInfo) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (contactId != other.contactId)
			return false;
		if (contactMethod == null) {
			if (other.contactMethod != null)
				return false;
		} else if (!contactMethod.equals(other.contactMethod))
			return false;
		if (contactMethodOther == null) {
			if (other.contactMethodOther != null)
				return false;
		} else if (!contactMethodOther.equals(other.contactMethodOther))
			return false;
		if (contactType == null) {
			if (other.contactType != null)
				return false;
		} else if (!contactType.equals(other.contactType))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ContactInfo [contactId=" + contactId + ", contactType=" + contactType + ", contactMethod="
				+ contactMethod + ", contact=" + contact + ", contactMethodOther=" + contactMethodOther + "]";
	}
	
	
	
	
}
