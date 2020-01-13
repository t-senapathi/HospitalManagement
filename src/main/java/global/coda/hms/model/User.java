package global.coda.hms.model;

/**
 * The type User.
 */
public class User {
	/**
	 * The Username.
	 */
	String username;
	/**
	 * The Password.
	 */
	String password;
	/**
	 * The First name.
	 */
	String firstName;
	/**
	 * The Last name.
	 */
	String lastName;
	/**
	 * The Age.
	 */
	int age;
	/**
	 * The Pk user id.
	 */
	int pkUserId;
	/**
	 * The Fk role id.
	 */
	int fkRoleId;

	/**
	 * Gets username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets username.
	 *
	 * @param username the username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets first name.
	 *
	 * @param firstName the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets last name.
	 *
	 * @param lastName the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets age.
	 *
	 * @param age the age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets pk user id.
	 *
	 * @return the pk user id
	 */
	public int getPkUserId() {
		return pkUserId;
	}

	/**
	 * Sets pk user id.
	 *
	 * @param pkUserId the pk user id
	 */
	public void setPkUserId(int pkUserId) {
		this.pkUserId = pkUserId;
	}

	/**
	 * Gets fk role id.
	 *
	 * @return the fk role id
	 */
	public int getFkRoleId() {
		return fkRoleId;
	}

	/**
	 * Sets fk role id.
	 *
	 * @param fkRoleId the fk role id
	 */
	public void setFkRoleId(int fkRoleId) {
		this.fkRoleId = fkRoleId;
	}

	/**
	 *
	 * @return tostring
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", pkUserId=" + pkUserId + ", fkRoleId=" + fkRoleId + "]";
	}

}
