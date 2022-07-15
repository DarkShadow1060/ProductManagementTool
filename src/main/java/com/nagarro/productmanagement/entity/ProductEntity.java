/**
 * 
 */
package com.nagarro.productmanagement.entity;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 * @author heram
 *
 */
@Entity
public class ProductEntity {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	/** The image. */
	@Lob
	@Column(name = "Image_name", columnDefinition = "mediumblob")
	private byte[] image;

	
	@Transient
	private String base64Image;
	
	public String getBase64Image() {
	    base64Image = Base64.getEncoder().encodeToString(this.image);
	    return base64Image;
	}
 
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
	
	/** The imgname. */
	@Column(name = "imgname")
	private String imgname;

	/** The title. */
	@Column(name = "title")
	private String title;

	/** The Quantity. */
	@Column(name = "quantity")
	private Integer quantity;

	/** The size. */
	@Column(name = "size")
	private String size;
	
	@Column
	private String userName;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * Gets the imgname.
	 *
	 * @return the imgname
	 */
	public String getImgname() {
		return imgname;
	}

	/**
	 * Sets the imgname.
	 *
	 * @param imgname the new imgname
	 */
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", Quantity=" + quantity + ", size=" + size + "]";
	}
}
