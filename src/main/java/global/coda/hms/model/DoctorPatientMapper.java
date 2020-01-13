package global.coda.hms.model;

import java.util.List;

/**
 * The type Doctor patient mapper.
 */
public class DoctorPatientMapper {
    private int doctorId;
    private List<Patient> patients;

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
     * Gets patients.
     *
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * Sets patients.
     *
     * @param patients the patients
     */
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    /**
     * To String.
     *
     * @return toString
     */
    @Override
    public String toString() {
        return "DoctorPatientMapper{"
                + "doctorId=" + doctorId
                + ", patients=" + patients
                + '}';
    }
}
