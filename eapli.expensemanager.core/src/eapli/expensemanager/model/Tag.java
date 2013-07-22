/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author Paulo Gandra Sousa
 */
@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tag;

	public Tag() {
	}

	public Tag(String tag) {
		this.tag = tag;
	}
}
