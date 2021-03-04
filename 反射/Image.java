package com.example.demo.entity;

public class Image {
    private Integer id;
    private Object image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

	public Image() {
		super();
	}

	public Image(Integer id, Object image) {
		super();
		this.id = id;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", image=" + image + "]";
	}
    
    
}