package com.ecom.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Category {

	private int id;
	private String name;
	private String imageName;
	private Boolean isActive;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
	    return id; // Correct value return kar raha hai
	}

	public void setId(int id) {
	    this.id = id; // Value assign kar raha hai
	}

	public String getName() {
	    return name; // Null nahi hoga agar sahi value assign ki hai
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getImageName() {
	    return imageName;
	}

	public void setImageName(String imageName) {
	    this.imageName = imageName;
	}

	public Boolean getIsActive() {
	    return isActive;
	}

	public void setIsActive(Boolean isActive) {
	    this.isActive = isActive;
	}

}
