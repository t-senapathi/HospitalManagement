package global.coda.hms.model;

/**
 * The type Doctor patient assign.
 */
public class DoctorPatientAssign {
    private int doctorId;
    private int patientId;
    private String disease;

    /**
     * Gets doctor id.
     *
     * @return the doctor id
     */
    public int getDoctorId() {
        return doctorId;
    }

    /**
     * Sets doctor id.
     *
     * @param doctorId the doctor id
     */
    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * Gets patient id.
     *
     * @return the patient id
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Sets patient id.
     *
     * @param patientId the patient id
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * Gets disease.
     *
     * @return the disease
     */
    public String getDisease() {
        return disease;
    }

    /**
     * Sets disease.
     *
     * @param disease the disease
     */
    public void setDisease(String disease) {
        this.disease = disease;
    }
}
