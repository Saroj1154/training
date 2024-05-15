package training.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
    @Column(length = 255)
    private String doctorName;
    @Column(length = 255)
    

    private String doctorAddress;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "doctor_patient_mapping",
//            joinColumns = @JoinColumn(name = "doctorId"),
//            inverseJoinColumns =@JoinColumn(name = "patientId")
//    )
    @ManyToMany(mappedBy = "doctors")
   private Set<Patient>patients=new HashSet();
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorAddress() {
		return doctorAddress;
	}
	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}
	public Set<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}







}
