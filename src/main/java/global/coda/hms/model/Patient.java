package global.coda.hms.model;

/**
 * The type Patient.
 */
public class Patient extends User {
	private int pkPatientId;
	private int patientHeight;
	private int patientWeight;
	private String street;
	private String city;
	private String doorNo;
	private String bloodGroup;

	/**
	 * Gets pk patient id.
	 *
	 * @return the pk patient id
	 */
	public int getPkPatientId() {
		return pkPatientId;
	}

	/**
	 * Sets pk patient id.
	 *
	 * @param pkPatientId the pk patient id
	 */
	public void setPkPatientId(int pkPatientId) {
		this.pkPatientId = pkPatientId;
	}

	/**
	 * Gets patient height.
	 *
	 * @return the patient height
	 */
	public int getPatientHeight() {
		return patientHeight;
	}

	/**
	 * Sets patient height.
	 *
	 * @param patientHeight the patient height
	 */
	public void setPatientHeight(int patientHeight) {
		this.patientHeight = patientHeight;
	}

	/**
	 * Gets patient weight.
	 *
	 * @return the patient weight
	 */
	public int getPatientWeight() {
		return patientWeight;
	}

	/**
	 * Sets patient weight.
	 *
	 * @param patientWeight the patient weight
	 */
	public void setPatientWeight(int patientWeight) {
		this.patientWeight = patientWeight;
	}

	/**
	 * Gets street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets street.
	 *
	 * @param street the street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets city.
	 *
	 * @param city the city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets door no.
	 *
	 * @return the door no
	 */
	public String getDoorNo() {
		return doorNo;
	}

	/**
	 * Sets door no.
	 *
	 * @param doorNo the door no
	 */
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	/**
	 * Gets blood group.
	 *
	 * @return the blood group
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**
	 * Sets blood group.
	 *
	 * @param bloodGroup the blood group
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**
	 *
	 * @return toString
	 */
	@Override
	public String toString() {
		return "Patient [pkPatientId=" + pkPatientId + ", patientHeight=" + patientHeight
				+ ", patientWeight=" + patientWeight + ", street=" + street + ", city=" + city + ", doorNo=" + doorNo
				+ ", bloodGroup=" + bloodGroup + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ",  age=" + age + ", pkUserId=" + pkUserId
				+ ", fkRoleId=" + fkRoleId + "]";
	}



}
