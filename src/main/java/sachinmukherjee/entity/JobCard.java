package sachinmukherjee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="job_card")
public class JobCard {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="job_no")
	private String job_no;
	
	@Column(name="created_by")
	private String created_by;

	@OneToMany(mappedBy = "jobCard",cascade = CascadeType.ALL)
	private List<JobCardProducts> job_card_products;
	
	public JobCard() {
	}



	public JobCard(String job_no, String created_by) {
		this.job_no = job_no;
		this.created_by = created_by;
	}



	public String getJob_no() {
		return job_no;
	}



	public void setJob_no(String job_no) {
		this.job_no = job_no;
	}



	public String getCreated_by() {
		return created_by;
	}



	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}



	public int getId() {
		return id;
	}



	public List<JobCardProducts> getJob_card_products() {
		return job_card_products;
	}



	public void setJob_card_products(List<JobCardProducts> job_card_products) {
		this.job_card_products = job_card_products;
	}



	@Override
	public String toString() {
		return "JobCard [id=" + id + ", job_no=" + job_no + ", created_by=" + created_by + "]";
	}
	
	//For Bi Directional Adding
	public void add(JobCardProducts job_card_product) {
		
		if(job_card_products == null) {
			job_card_products = new ArrayList<JobCardProducts>();
		}
		
		job_card_products.add(job_card_product);
		
		job_card_product.setJobCard(this);
	}
	
	
	
}
