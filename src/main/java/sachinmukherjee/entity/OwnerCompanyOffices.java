package sachinmukherjee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="owner_company_offices")
public class OwnerCompanyOffices {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_company_id")
	private OwnerCompany ownerCompany;
	
	
	

	public OwnerCompanyOffices() {
	}

	public OwnerCompanyOffices( String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public OwnerCompany getOwnerCompany() {
		return ownerCompany;
	}

	public void setOwnerCompany(OwnerCompany ownerCompany) {
		this.ownerCompany = ownerCompany;
	}

	public int getId() {
		return id;
	}

	
	
}
