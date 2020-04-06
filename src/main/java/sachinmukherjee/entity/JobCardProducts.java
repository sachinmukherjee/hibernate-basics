package sachinmukherjee.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="job_card_products")
public class JobCardProducts {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="weight")
	private Double weight;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_card_id")
	private JobCard jobCard;
	
	
	
	public JobCardProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobCardProducts(String name, Double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public JobCard getJobCard() {
		return jobCard;
	}

	public void setJobCard(JobCard jobCard) {
		this.jobCard = jobCard;
	}

	public int getId() {
		return id;
	}
	
	
	
}
