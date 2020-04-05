package sachinmukherjee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="owner_company")
public class OwnerCompany {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="short_name")
	private String short_name;
	
	@Column(name="is_head_office")
	private int is_head_office;
	
	@OneToOne(mappedBy = "ownerCompany", cascade = CascadeType.ALL) // Points to ownerCompany Property in OwnerCompany Offices Entity
	private OwnerCompanyOffices ownerCompanyOffices;

	public OwnerCompany() {
		
	}
	
	public OwnerCompany(String name, String short_name, int i) {
		this.name = name;
		this.short_name = short_name;
		this.is_head_office = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	
	public void setOwnerCompanyOffices(OwnerCompanyOffices ownerCompanyOffices) {
		this.ownerCompanyOffices = ownerCompanyOffices;
	}

	public int getIs_head_office() {
		return is_head_office;
	}

	public void setIs_head_office(int is_head_office) {
		this.is_head_office = is_head_office;
	}

	public int getId() {
		return id;
	}
	
	public OwnerCompanyOffices getOwnerCompanyOffices() {
		return ownerCompanyOffices;
	}

	@Override
	public String toString() {
		return "OwnerCompany [id=" + id + ", name=" + name + ", short_name=" + short_name + ", is_head_office="
				+ is_head_office + "]";
	}
	
	
	
}
