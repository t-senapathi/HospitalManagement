package global.coda.hms.model;

import java.util.List;

/**
 * The type Doctor.
 */
public class Doctor extends User {
	private int pkDoctorId;
	private int fkUserId;
	private int experience;
	private String specialisation;
	private List<Patient> patientList;

	/**
	 * Gets patient list.
	 *
	 * @return the patient list
	 */
	public List<Patient> getPatientList() {
		return patientList;
	}

	/**
	 * Sets patient list.
	 *
	 * @param patientList the patient list
	 */
	public void setPatientList(List<Patient> patientList) {
		this.patientList = patientList;
	}

	/**
	 * Gets pk doctor id.
	 *
	 * @return the pk doctor id
	 */
	public int getPkDoctorId() {
		return pkDoctorId;
	}

	/**
	 * Sets pk doctor id.
	 *
	 * @param pkDoctorId the pk doctor id
	 */
	public void setPkDoctorId(int pkDoctorId) {
		this.pkDoctorId = pkDoctorId;
	}

	/**
	 * Gets fk user id.
	 *
	 * @return the fk user id
	 */
	public int getFkUserId() {
		return fkUserId;
	}

	/**
	 * Sets fk user id.
	 *
	 * @param fkUserId the fk user id
	 */
	public void setFkUserId(int fkUserId) {
		this.fkUserId = fkUserId;
	}

	/**
	 * Gets experience.
	 *
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Sets experience.
	 *
	 * @param experience the experience
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Gets specialisation.
	 *
	 * @return the specialisation
	 */
	public String getSpecialisation() {
		return specialisation;
	}

	/**
	 * Sets specialisation.
	 *
	 * @param specialisation the specialisation
	 */
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	/**
	 *
	 * @return toString
	 */
	@Override
	public String toString() {
		return "Doctor [pkDoctorId=" + pkDoctorId + ", fkUserId=" + fkUserId + ", experience=" + experience
				+ ", specialisation=" + specialisation + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", pkUserId=" + pkUserId
				+ ", fkRoleId=" + fkRoleId + "]";
	}

}
