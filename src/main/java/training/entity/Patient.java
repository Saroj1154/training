package training.entity;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name="patient")
public class Patient {
     @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
     @Column(length = 255)
    private String patientName;
     @Column(length = 255)
    private String patientAddress;
    @Column(length = 255)
    private String patientEmail;
    @Column(length = 10)
    private String password;
    
    @ManyToMany(cascade = CascadeType.ALL)//mappedBy = "patients")
    @JoinTable(
            name = "doctor_patient_mapping",
            joinColumns = @JoinColumn(name = "patientId"),
            inverseJoinColumns =@JoinColumn(name = "doctorId")
    )
    
//    @ManyToMany(mappedBy = "patients")
     private Set<Doctor> doctors=new HashSet();
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Doctor> getDoctors() {
		return doctors;
	}
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	public String  printDrDetail() {
		doctors.forEach(d -> {
			System.out.println("Id - "+d.getDoctorId() +" Doctor Name - "+d.getDoctorName());
		});
		return "";
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAddress=" + patientAddress
				+ ", patientEmail=" + patientEmail + ", password=" + password + ", doctors=" + doctors +printDrDetail()+"]";
	}



}
