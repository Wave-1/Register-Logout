package vn.iotstar.entity;

import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@AllArgsConstructor

@NoArgsConstructor

@Data

@Entity

@Table(name = "Category")

@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")

public class Category {

	@Id

	@Column(name = "CategoryId")

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@Column(columnDefinition = "NVARCHAR(255)")

	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	private int status;

	@Column(columnDefinition = "NVARCHAR(1000)")

	private String images;

	private String code;

//bi-directional many-to-one association to Video

	@OneToMany(mappedBy = "category")

	private List<Video> videos;

	public Video addVideo(Video video) {

		videos.add(video);

		video.setCategory(this);

		return video;

	}

	public Video removeVideo(Video video) {

		videos.remove(video);

		video.setCategory(null);

		return video;

	}

}